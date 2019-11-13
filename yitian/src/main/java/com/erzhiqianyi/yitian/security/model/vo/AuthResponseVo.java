package com.erzhiqianyi.yitian.security.model.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuthResponseVo {

    private String token;

    private Instant expirationAt;


}
