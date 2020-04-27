package cn.niudehua.community.dto;

import cn.niudehua.community.model.User;
import lombok.Data;

/**
 * @author: deng
 * @datetime: 2020/4/27 10:26 下午
 * @desc:
 */
@Data
public class QuestionDTO {
    private String title;
    private String description;
    private Long gmtCreat;
    private Long gmtModified;
    private Integer creator;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;
    private String tag;
    private User user;
}
