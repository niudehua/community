create table COMMENT
(
    ID BIGINT auto_increment,
    PARENT_ID BIGINT not null,
    TYPE INT not null,
    COMMENTATOR BIGINT not null,
    GMT_CREATE BIGINT not null,
    GMT_MODIFIED BIGINT not null,
    LIKE_COUNT INT default 0,
    CONTENT VARCHAR(1024),
    COMMENT_COUNT INT default 0,
    constraint COMMENT_PK
        primary key (ID)
);

comment on table COMMENT is '评论表';

comment on column COMMENT.ID is '自增主键ID';

comment on column COMMENT.PARENT_ID is '父级ID';

comment on column COMMENT.TYPE is '类型：1：评论 2：回复';

comment on column COMMENT.GMT_CREATE is '创建时间';

comment on column COMMENT.GMT_MODIFIED is '修改时间';

comment on column COMMENT.COMMENTATOR is '回复者';

comment on column COMMENT.CONTENT is '评论内容';

comment on column COMMENT.COMMENT_COUNT is '评论数';

