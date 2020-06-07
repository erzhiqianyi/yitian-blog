package com.erzhiqianyi.yitian.article.model.vo;


import com.erzhiqianyi.yitian.article.model.entity.ArticleEntity;
import com.erzhiqianyi.yitian.article.model.enums.ArticleStatus;
import com.erzhiqianyi.yitian.article.model.po.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.Instant;

@ApiModel("文章")
@Data
public class ArticleVo {

    private Long id;

    @ApiModelProperty(value = "标题")
    @NotNull(message = "标题不能为空")
    private ArticleTitle title;

    @ApiModelProperty(value = "内容")
    private ArticleContent content;

    @ApiModelProperty(value = "配置")
    private ArticleConfig config;

    @ApiModelProperty(value = "作者")
    private Author author;

    private Long createBy;

    public ArticleEntity toArticleEntity() {
        ArticleEntity article = new ArticleEntity();
        article.setTitle(title.getTitle());
        article.setSubTitle(title.getSubTitle());
        article.setKeyWord(title.getTitle());
        article.setContent(content.getContent());
        article.setStatus(ArticleStatus.PUBLISH.getCode());

        ArticlePublishTrigger trigger = config.getPublish();
        article.setPublishTrigger(trigger.getTrigger().getCode());
        article.setPublishTime(trigger.publishTime());

        article.setPermissionGroup(config.getPermission().getGroup().getCode());

        CommentConfig commentConfig = config.getComment();
        article.setAllowComment(commentConfig.getAllow().getCode());
        article.setCheckComment(commentConfig.getCheck().getCode());
        RecommendConfig recommendConfig = config.getRecommend();
        article.setRecommend(recommendConfig.getRecommend().getCode());
        article.setRecommendPriority(recommendConfig.priority());


        article.setAuthorId(author.getAuthorId());
        Long now = Instant.now().toEpochMilli();

        article.setCreateAt(now);
        article.setCreateBy(now);
        article.setUpdateAt(now);
        article.setUpdateBy(now);

        return article;
    }
}
