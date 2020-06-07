package com.erzhiqianyi.yitian.article.service;

import com.erzhiqianyi.yitian.article.model.vo.ArticleVo;
import reactor.core.publisher.Mono;

public interface ArticleManageService {
    Mono<ArticleVo> postArticle(ArticleVo article);
}
