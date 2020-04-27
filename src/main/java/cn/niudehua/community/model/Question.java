package cn.niudehua.community.model;

import lombok.Data;

/**
 * @author: deng
 * @datetime: 2020/4/27 4:30 下午
 * @desc:
 */
@Data
public class Question {
    private String title;
    private String description;
    private Long gmtCreat;
    private Long gmtModified;
    private Integer creator;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;
    private String tag;
}
