package com.erzhiqianyi.yitian.article.model.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.Instant;

@ApiModel("文章发表配置")
@Data
public class ArticlePublishTrigger {

   @ApiModelProperty("发布类型")
   private Trigger trigger;

   @ApiModelProperty("发布时间")
   private Instant time;


   public enum Trigger{
      TIMING("TIMING","定时发布"),
      NOT("NOW","立即发布");
      private String code;
      private String remark;

      Trigger(String code, String remark) {
         this.code = code;
         this.remark = remark;
      }
   }
}
