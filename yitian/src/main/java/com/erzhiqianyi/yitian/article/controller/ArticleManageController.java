package com.erzhiqianyi.yitian.article.controller;


import com.erzhiqianyi.yitian.article.model.vo.ArticleVo;
import com.erzhiqianyi.yitian.security.model.bo.AuthResponse;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RequestMapping("/api/admin/article")
@RestController
@Api(tags = "文章管理")
@Log4j2
public class ArticleManageController {

    @PostMapping
    public Mono<AuthResponse> postArticle(@RequestBody @Valid ArticleVo article) {
        log.info("文章信息: "+article);
        return Mono.empty();
    }
}
