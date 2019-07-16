package com.erzhiqianyi.blog.swagger;


public interface SwaggerConstant {

    String MEDIA_JSON = "application/json";

    String TAG_LOGIN = "登录接口";

    String TAG_REGISTER = "用户注册接口";

    String TAG_VERIFY_CODE =  "验证码接口";

    String VALUE_LOGIN_PASSWORD = "密码登录";

    String VALUE_LOGIN_PHONE = "手机验证码登录";

    String VALUE_LOGIN_EMAIL = "邮箱验证码登录";

    String VALUE_LOGIN_THIRD = "第三方登录";

    String VALUE_EMAIL_CODE = "获取邮箱验证码";

    String VALUE_REGISTER_BY_EMAIL = "通过邮箱注册";

    String PROPERTY_USER_ID ="用户id" ;

    String PROPERTY_USER_NAME = "用户名" ;

    String PROPERTY_USER_EMAIL = "邮箱";

    String PROPERTY_USER_PASSWORD = "密码";

    String PROPERTY_USER_RE_PASSWORD = "确认密码";

    String PROPERTY_USER_CODE = "验证码";

    String PROPERTY_RESULT_CODE = "返回结果,0表示成功，其他看返回msg";

    String PROPERTY_RESULT_MSG = "处理结果";

    String PROPERTY_RESULT_DATA = "数据";

}
