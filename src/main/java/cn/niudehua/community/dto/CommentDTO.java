package cn.niudehua.community.dto;

import lombok.Data;

/**
 * @author deng
 * @datetime: 2020/4/27 12:08 上午
 * @desc: 评论数据传输
 */
@Data
public class CommentDTO {
    private Long parentId;
    private String content;
    private Integer type;

}