package com.erzhiqianyi.blog.model;

public interface MsgConstant {
    String EMPTY_USERNAME = "用户名不能为空";
    String USERNAME_SIZE = "用户名长度为 3 到 20 个字符";

    String EMPTY_PASSWORD = "密码不能为空";
    String PASSWORD_SIZE = "密码长度为 3 到 20 个字符";

    String EMPTY_EMAIL = "邮箱不能为空";
    String EMAIL_SIZE = "邮箱长度为 3 到 20 个字符";
    String EMAIL_WRONG_FORMAT = "邮箱格式不正确";

    String EMPTY_CODE = "验证码不能为空";
    String CODE_SIZE = "验证码长度为 4 到 8 个字符";
}
