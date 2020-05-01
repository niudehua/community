package cn.niudehua.community;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author: deng
 * @datetime: 2020/4/26 2:46 下午
 * @desc: 嘟嘟社区
 */
@SpringBootApplication
@MapperScan("cn.niudehua.community.mapper")
public class CommunityApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommunityApplication.class, args);
    }

}
