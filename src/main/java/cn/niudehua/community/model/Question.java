package cn.niudehua.community.model;

import lombok.Data;

/**
 * @author: deng
 * @datetime: 2020/4/27 4:30 下午
 * @desc: 问题模型
 */
@Data
public class Question {
    /**
     * 问题标题
     */
    private String title;
    /**
     * 问题补充、问题描述
     */
    private String description;
    /**
     * 创建时间
     */
    private Long gmtCreat;
    /**
     * 修改时间
     */
    private Long gmtModified;
    /**
     * 创建用户
     */
    private Integer creator;
    /**
     * 评论次数
     */
    private Integer commentCount;
    /**
     * 浏览次数
     */
    private Integer viewCount;
    /**
     * 点赞次数
     */
    private Integer likeCount;
    /**
     * 标签
     */
    private String tag;
}
