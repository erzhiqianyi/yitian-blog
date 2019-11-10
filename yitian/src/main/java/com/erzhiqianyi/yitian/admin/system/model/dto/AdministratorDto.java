package com.erzhiqianyi.yitian.admin.system.model.dto;

import lombok.Data;

@Data
public class AdministratorDto {
    private Long id;
    private String email;
    private String nickname;
    private String username;
    private String password;

    public AdministratorDto(SystemInstallDto installDto) {
        this.email = installDto.getEmail();
        this.nickname = installDto.getNickname();
        this.password = installDto.getPassword();
    }
}
