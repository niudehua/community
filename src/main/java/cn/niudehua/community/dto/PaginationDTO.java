package cn.niudehua.community.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: deng
 * @datetime: 2020/4/29 10:50 上午
 * @desc: 分页对象传输
 */
@Data
public class PaginationDTO {
    /**
     * 分页数据
     */
    private List<QuestionDTO> data;
    /**
     * 当前页
     */
    private Integer page;
    private Integer totalPage;
    /**
     * 前一页
     */
    private Boolean showPrevious;
    /**
     * 第一页
     */
    private Boolean showFirstPage;
    /**
     * 下一页
     */
    private Boolean showNextPage;
    /**
     * 最后一页
     */
    private Boolean showLastPage;
    /**
     * 展示页
     */
    private List<Integer> pages = new ArrayList<>();

    /**
     * 设置分页内容
     *
     * @param totalCount 总数据条数
     * @param page       当前页
     * @param size       每页展示规格
     */
    public void setPagination(Integer totalCount, Integer page, Integer size) {
        //数据总条数跟每页展示页数取模
        if (totalCount % size == 0) {
            this.totalPage = totalCount / size;
        } else {
            this.totalPage = totalCount / size + 1;
        }
        // 判断page容错 小于1时设置为1，大于总页数时设置为总页数
        if (page < 1) {
            page = 1;
        }
        if (page > this.totalPage) {
            page = this.totalPage;
        }
        // 设置判断容错后的当前页
        this.page = page;
        pages.add(page);
        for (int i = 1; i <= 3; i++) {
            if (page - i > 0) {
                pages.add(0, page - i);
            }

            if ((page + i) <= this.totalPage) {
                pages.add(page + i);
            }
        }

        //如果当前页是第一页就没有上一页
        if (this.page == 1) {
            showPrevious = false;
        } else {
            showPrevious = true;
        }
        //如果当前页是最后页就没有下一页
        if (this.page.equals(this.totalPage)) {
            showNextPage = false;
        } else {
            showNextPage = true;
        }
        //如果展示页包含第一页就不展示第一页
        if (pages.contains(1)) {
            showFirstPage = false;
        } else {
            showFirstPage = true;
        }
        //如果展示页包含最后一页就不展示最后一页
        if (pages.contains(this.totalPage)) {
            showLastPage = false;
        } else {
            showLastPage = true;
        }


    }
}
