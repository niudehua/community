package cn.niudehua.community.dto;

import cn.niudehua.community.model.User;
import lombok.Data;

/**
 * @author deng
 * @datetime: 2020/4/27 12:08 上午
 * @desc: 评论数据传输
 */
@Data
public class CommentDTO {
    private Long id;

    private Long parentId;

    private Integer type;

    private Long commentator;

    private Long gmtCreate;

    private Long gmtModified;

    private Integer likeCount;

    private String content;

    private Integer commentCount;

    private User user;

}