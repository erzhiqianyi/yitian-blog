package com.erzhiqianyi.yitian.article.repository.reactor;

import com.erzhiqianyi.yitian.YitianApplication;
import com.erzhiqianyi.yitian.article.model.entity.ArticleEntity;
import com.erzhiqianyi.yitian.article.model.enums.ArticleStatus;
import com.erzhiqianyi.yitian.article.model.enums.SwitchEnum;
import com.erzhiqianyi.yitian.article.model.po.AccessPermission;
import com.erzhiqianyi.yitian.article.model.po.ArticlePublishTrigger;
import lombok.extern.log4j.Log4j2;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.test.StepVerifier;


@SpringBootTest(classes = YitianApplication.class)
@RunWith(SpringRunner.class)
@Log4j2
public class ArticleRepositoryTest {

    @Autowired
    private ArticleRepository articleRepository;

    private ArticleEntity articleEntity;

    @Before
    public void init() {
        articleEntity = new ArticleEntity();
        long now = System.currentTimeMillis();
        articleEntity.setTitle("测试" + now);
        articleEntity.setSubTitle("副标题" + now);
        articleEntity.setKeyWord("测试");
        articleEntity.setContent("内容" + now);
        articleEntity.setStatus(ArticleStatus.PUBLISH.getCode());
        articleEntity.setPublishTrigger(ArticlePublishTrigger.Trigger.NOW.getCode());
        articleEntity.setPublishTime(now);
        articleEntity.setPermissionGroup(AccessPermission.Group.PUBLIC.getCode());
        articleEntity.setAllowComment(SwitchEnum.CLOSE.getCode());
        articleEntity.setCheckComment(SwitchEnum.CLOSE.getCode());
        articleEntity.setRecommend(SwitchEnum.CLOSE.getCode());
        articleEntity.setRecommendPriority(1);
        articleEntity.setAuthorId(now);
        articleEntity.setCreateAt(now);
        articleEntity.setCreateBy(now);
        articleEntity.setUpdateAt(now);
        articleEntity.setUpdateBy(now);
    }

    @Test
    public void addArticle() {
        StepVerifier.create(
                articleRepository.saveArticle(articleEntity)
                        .map(ArticleEntity::getTitle)
        )
                .expectNext(articleEntity.getTitle())
                .expectComplete()
                .verify();

    }
}