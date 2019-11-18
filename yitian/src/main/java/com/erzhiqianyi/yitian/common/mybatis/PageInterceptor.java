package com.erzhiqianyi.yitian.common.mybatis;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Connection;
import java.util.Properties;


/**
 * @author 二之前一
 * 2019/11/18 20:29
 * @Intercepts 说明是拦截器
 * @Signature 拦截器签名
 * type 拦截类型  四大对象之一( Executor,ResultSetHandler,ParameterHandler,StatementHandler)
 * method 拦截的方法
 * arge 参数
 */
@Intercepts(
        {@Signature(
                type = StatementHandler.class,
                method = "prepare",
                args = {Connection.class, Integer.class}
        )
        })
public class PageInterceptor implements Interceptor {

    //每页显示数量
    private int pageSize;

    //当前页
    private int currentPage;

    //数据库类型，不同数据库分页不一样 ,mysql用limit
    private DbTypeEnum dbType;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 获取StatementHandler , 默认是RoutingStatementHandler
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        //获取statementHandler包装类
        MetaObject MetaObjectHandler = SystemMetaObject.forObject(statementHandler);

        //分离代理对象链
        while (MetaObjectHandler.hasGetter("h")) {
            Object obj = MetaObjectHandler.getValue("h");
            MetaObjectHandler = SystemMetaObject.forObject(obj);
        }

        while (MetaObjectHandler.hasGetter("target")) {
            Object obj = MetaObjectHandler.getValue("target");
            MetaObjectHandler = SystemMetaObject.forObject(obj);
        }

        //获取连接对象
        //Connection connection = (Connection) invocation.getArgs()[0];


        //object.getValue("delegate");  获取StatementHandler的实现类

        //获取查询接口映射的相关信息
        MappedStatement mappedStatement = (MappedStatement) MetaObjectHandler.getValue("delegate.mappedStatement");
        String mapId = mappedStatement.getId();

        //statementHandler.getBoundSql().getParameterObject();

        //拦截以.ByPage结尾的请求，分页功能的统一实现
        if (mapId.matches(".+ByPage$")) {
            //获取进行数据库操作时管理参数的handler
            ParameterHandler parameterHandler = (ParameterHandler) MetaObjectHandler.getValue("delegate.parameterHandler");
            //获取请求时的参数

            Object param = parameterHandler.getParameterObject();

            String sortField = null;

            String sortOrder = null;
            if (param instanceof PaginationQuery) {
                PaginationQuery paginationQuery = (PaginationQuery) param;
                currentPage = null == paginationQuery.getPage() ? 1 : paginationQuery.getPage();
                currentPage = currentPage <= 0 ? 1 : currentPage;
                pageSize = null != paginationQuery.getSize() ? paginationQuery.getSize() : pageSize;
                sortField = paginationQuery.getSortField();
                sortOrder = paginationQuery.getSortOrder().name();
            } else {
                currentPage = 1;
            }

            String sql = (String) MetaObjectHandler.getValue("delegate.boundSql.sql");
            //也可以通过statementHandler直接获取
            //sql = statementHandler.getBoundSql().getSql();

            //构建分页功能的sql语句
            String limitSql = null;
            sql = sql.trim();
            switch (dbType) {
                case MYSQL:
                    if (null != sortField) {
                        limitSql = sql + " order by " + sortField + " " + sortOrder
                                + " limit " + (currentPage - 1) * pageSize + "," + pageSize;
                    } else {
                        limitSql = sql + " limit " + (currentPage - 1) * pageSize + "," + pageSize;
                    }
                    break;
            }
            //将构建完成的分页sql语句赋值个体'delegate.boundSql.sql'，偷天换日
            MetaObjectHandler.setValue("delegate.boundSql.sql", limitSql);
        }

        return invocation.proceed();
    }

    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o, this);
    }

    @Override
    public void setProperties(Properties properties) {
        String limitSize = properties.getProperty("limit", "10");
        this.pageSize = Integer.valueOf(limitSize);
        this.dbType = DbTypeEnum.valueOf(properties.getProperty("dbType", "MYSQL"));
    }
}
