package com.erzhiqianyi.yitian.article.repository.mapper;

import com.erzhiqianyi.yitian.article.model.entity.ArticleEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectKey;


@Mapper
public interface ArticleMapper {
    @Insert({
            " insert into ",
            " article ",
            " ( ",
            " title, ",
            " sub_title, ",
            " key_word, ",
            " content, ",
            " status, ",
            " url,",
            " password, ",
            " publish_trigger,",
            " publish_time, ",
            " permission_group,",
            " allow_comment, ",
            " check_comment, ",
            " recommend, ",
            " recommend_priority, ",
            " author_id, ",
            " create_at, ",
            " create_by, ",
            " update_at, ",
            " update_by ",
            " ) ",
            " values ",
            " ( ",
            "#{title} , ",
            "#{subTitle} , ",
            "#{keyWord} , ",
            "#{content} , ",
            "#{status} , ",
            "#{url} , ",
            "#{password} , ",
            "#{publishTrigger} , ",
            "#{publishTime} , ",
            "#{permissionGroup} , ",
            "#{allowComment} , ",
            "#{checkComment} , ",
            "#{recommend} , ",
            "#{recommendPriority} , ",
            "#{authorId} , ",
            "#{createAt} , ",
            "#{createBy} , ",
            "#{updateAt} , ",
            "#{updateBy}  ",
            " ) "
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Long.class)
    void insert(ArticleEntity article);
}
