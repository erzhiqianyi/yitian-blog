package com.erzhiqianyi.yitian.article.service.impl;

import com.erzhiqianyi.yitian.article.model.vo.ArticleVo;
import com.erzhiqianyi.yitian.article.repository.reactor.ArticleRepository;
import com.erzhiqianyi.yitian.article.service.ArticleManageService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Log4j2
public class ArticleManageServiceImpl implements ArticleManageService {


    private ArticleRepository articleRepository;

    public ArticleManageServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public Mono<ArticleVo> postArticle(ArticleVo article) {
        return articleRepository.saveArticle(article.toArticleEntity())
                .map(entity -> {
                    article.setId(entity.getId());
                    return article;
                })
                .doOnNext(articleVo -> log.info("增加操作日志"));
    }
}
