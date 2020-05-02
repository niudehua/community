## Community 嘟嘟社区

## 资料
[码匠笔记](https://www.bilibili.com/video/BV1Zb41137X2)

[Elasticsearch中文论坛](https://elasticsearch.cn)

[Spring文档](https://spring.io/guides)

[Thymeleaf整合Spring MVC文档](https://spring.io/guides/gs/serving-web-content)

[BootStrap文档](https://v3.bootcss.com/getting-started)
 
[GitHub OAuth](https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/)

[OkHttp文档](https://square.github.io/okhttp)

[Fastjson](https://github.com/alibaba/fastjson)

[H2DB](http://www.h2database.com/html/quickstart.html)

[MyBatis整合SpringBoot](http://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/)

[Flayway Maven Plugin](https://flywaydb.org/getstarted/firststeps/maven)

[Thymeleaf使用教程](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html)

[Lombok插件](https://projectlombok.org/features/all)

[Spring Web MVC](https://docs.spring.io/spring/docs/5.2.5.RELEASE/spring-framework-reference/web.html)

[MyBatis Generator自生成](http://mybatis.org/generator/)

[分页插件org.mybatis.generator.plugins.RowBoundsPlugin](http://mybatis.org/generator/reference/plugins.html)

[Spring异常错误处理](https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/reference/html/spring-boot-features.html#boot-features-error-handling)

## 工具
[Git](https://git-scm.com/downloads)

[Visual Paradigm](https://www.visual-paradigm.com/cn/download/community.jsp)

[IntelliJ IDEA](https://www.jetbrains.com/idea/download)

## 数据库sql
```sql
create table USER
(
	ID INT auto_increment,
	TOKEN CHAR(36),
	NAME VARCHAR(50),
	ACCOUNT_ID VARCHAR(100),
	GMT_CREAT BIGINT,
	GMT_MODIFIED BIGINT,
	constraint USER_PK
		primary key (ID)
);
```
## Flayway使用
```bash
mvn flyway:migrate

mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate

```


