create table question
(
    id INT auto_increment,
    title VARCHAR(50),
    description TEXT,
    gmt_creat BIGINT,
    gmt_modified BIGINT,
    creator INT,
    comment_count INT default 0,
    view_count INT default 0,
    like_count INT default 0,
    tag VARCHAR(256),
    constraint QUESTION_PK
        primary key (id)
);

comment on table question is '提问表';

comment on column question.title is '问题标题';

comment on column question.description is '问题描述';

comment on column question.creator is '提问人';

comment on column question.comment_count is '评论数';

comment on column question.view_count is '浏览数';

comment on column question.like_count is '点赞数';

comment on column question.tag is '问题标签';

