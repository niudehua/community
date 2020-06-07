create table comment
(
    id            bigint auto_increment comment '自增主键id',
    parent_id     bigint not null comment '父级id',
    type          int    not null comment '类型：1：评论 2：回复',
    commentator   bigint not null comment '回复者',
    gmt_create    bigint not null comment '创建时间',
    gmt_modified  bigint not null comment '修改时间',
    like_count    int default 0 comment '点赞数',
    content       varchar(1024) comment '评论内容',
    comment_count int default 0 comment '评论数',
    constraint comment_pk
        primary key (id)
) comment '评论表';

