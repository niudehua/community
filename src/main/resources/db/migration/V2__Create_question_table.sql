create table QUESTION
(
    ID BIGINT auto_increment,
    TITLE VARCHAR(50),
    DESCRIPTION TEXT,
    GMT_CREAT BIGINT,
    GMT_MODIFIED BIGINT,
    CREATOR BIGINT,
    COMMENT_COUNT INT default 0,
    VIEW_COUNT INT default 0,
    LIKE_COUNT INT default 0,
    TAG VARCHAR(256),
    constraint QUESTION_PK
        primary key (ID)
);

comment on table QUESTION is '提问表';

comment on column QUESTION.TITLE is '问题标题';

comment on column QUESTION.DESCRIPTION is '问题描述';

comment on column QUESTION.GMT_CREAT is '创建时间';

comment on column QUESTION.GMT_MODIFIED is '修改时间';

comment on column QUESTION.COMMENT_COUNT is '评论数';

comment on column QUESTION.VIEW_COUNT is '浏览数';

comment on column QUESTION.LIKE_COUNT is '点赞数';

comment on column QUESTION.TAG is '问题标签';

