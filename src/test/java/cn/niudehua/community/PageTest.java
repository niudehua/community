package cn.niudehua.community;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: deng
 * @datetime: 2020/4/29 11:54 上午
 * @desc:
 */
public class PageTest {
    public static void main(String[] args) {
        for (int i = 1; i < 35; i++) {
            System.out.println("page=:" + i + test(i));
        }

    }

    static List test(int page) {
        List pages = new ArrayList();
        int totalCount = 100;
        int totalPage;
        int size = 3;
        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }
        pages.add(page);

        for (int i = 1; i <= 3; i++) {
            if (page - i > 0) {
                pages.add(0, page - i);
            }

            if (page + i <= totalPage) {
                pages.add(page + i);
            }

        }
        return pages;
    }
}
