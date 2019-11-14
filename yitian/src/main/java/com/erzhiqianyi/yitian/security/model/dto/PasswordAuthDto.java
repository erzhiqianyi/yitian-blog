package com.erzhiqianyi.yitian.security.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;


@Getter
@AllArgsConstructor
@ToString
public class PasswordAuthDto {
    private String email;

    private String password;
}
