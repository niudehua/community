create table question
(
    id            bigint auto_increment comment '主键id',
    title         varchar(50) comment '问题标题',
    description   text comment '问题描述',
    gmt_create    bigint comment '创建时间',
    gmt_modified  bigint comment '修改时间',
    creator       bigint comment '提问者',
    comment_count int default 0 comment '评论数',
    view_count    int default 0 comment '浏览数',
    like_count    int default 0 comment '点赞数',
    tag           varchar(256) comment '问题标签',
    constraint question_pk
        primary key (id)
) comment '提问表';

