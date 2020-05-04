package cn.niudehua.community.dto;

import lombok.Data;

/**
 * @author: deng
 * @datetime: 2020/5/3 9:21 下午
 * @desc: 添加评论传输对象
 */
@Data
public class CommentCreateDTO {
    private Long parentId;
    private String content;
    private Integer type;
}
