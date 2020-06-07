package com.erzhiqianyi.yitian.article.repository.reactor.impl;

import com.erzhiqianyi.yitian.article.model.entity.ArticleEntity;
import com.erzhiqianyi.yitian.article.repository.mapper.ArticleMapper;
import com.erzhiqianyi.yitian.article.repository.reactor.ArticleRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;

@Service
public class ArticleRepositoryImpl implements ArticleRepository {

    private final Scheduler jdbcScheduler;

    private final ArticleMapper articleMapper;

    public ArticleRepositoryImpl(Scheduler jdbcScheduler, ArticleMapper articleMapper) {
        this.jdbcScheduler = jdbcScheduler;
        this.articleMapper = articleMapper;
    }

    @Override
    public Mono<ArticleEntity> saveArticle(ArticleEntity entity) {
        return Mono.defer(() -> {
            articleMapper.insert(entity);
            return Mono.just(entity);
        }).subscribeOn(jdbcScheduler);
    }
}
