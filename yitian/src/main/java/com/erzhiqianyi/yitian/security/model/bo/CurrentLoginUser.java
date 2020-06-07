package com.erzhiqianyi.yitian.security.model.bo;

import lombok.Getter;
import lombok.ToString;
import org.springframework.security.core.Authentication;

@Getter
@ToString
public class CurrentLoginUser {

    private Long id;

    private String name;

    private String uuid;

    public CurrentLoginUser(Authentication authentication) {
        this.uuid = (String) authentication.getPrincipal();
        //todo 根据uuid 加载用户

    }
}
