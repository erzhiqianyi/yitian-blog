package com.erzhiqianyi.yitian.article.controller;


import com.erzhiqianyi.yitian.article.model.po.Author;
import com.erzhiqianyi.yitian.article.model.vo.ArticleVo;
import com.erzhiqianyi.yitian.article.service.ArticleManageService;
import com.erzhiqianyi.yitian.security.annotations.CurrentUser;
import com.erzhiqianyi.yitian.security.model.bo.CurrentLoginUser;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
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

    private ArticleManageService articleManageService;

    public ArticleManageController(ArticleManageService articleManageService) {
        this.articleManageService = articleManageService;
    }

    @PostMapping
    public Mono<ArticleVo> postArticle(@RequestBody @Valid ArticleVo article, @CurrentUser CurrentLoginUser user) {
        return articleManageService.postArticle(article);
    }
}
