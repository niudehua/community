create table user
(
    id           bigint auto_increment comment '主键id',
    token        char(36)     null comment '登录令牌',
    name         varchar(50)  null comment '用户名称',
    account_id   varchar(100) null comment '账户名',
    gmt_create   bigint       null comment '创建时间',
    gmt_modified bigint       null comment '修改时间',
    bio          varchar(256) null comment '个人经历',
    avatar_url   varchar(100) null comment '网络头像',
    constraint user_pk
        primary key (id)
) comment '用户表';

