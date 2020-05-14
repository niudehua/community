package cn.niudehua.community.dto;

import lombok.Data;

import java.util.List;

/**
 * @author: deng
 * @datetime: 2020/5/14 10:02 上午
 * @desc: 标签
 */
@Data
public class TagDTO {
    /**
     * 标签类型
     */
    private String tagCategory;
    /**
     * 标签
     */
    private List<String> tags;
}
