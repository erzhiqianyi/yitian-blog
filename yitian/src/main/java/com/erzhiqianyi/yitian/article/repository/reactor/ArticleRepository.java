package com.erzhiqianyi.yitian.article.repository.reactor;

import com.erzhiqianyi.yitian.article.model.entity.ArticleEntity;
import reactor.core.publisher.Mono;

public interface ArticleRepository {
    Mono<ArticleEntity> saveArticle(ArticleEntity entity);
}
