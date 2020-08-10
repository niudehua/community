create table notification
(
    id bigint auto_increment comment '主键id',
    notifier bigint null comment '通知人',
    receiver bigint null comment '接收人',
    outId bigint null comment '关联通知内容（问题，评论。。）',
    type int null comment '通知类型',
    gmt_creat bigint null comment '创建时间
',
    status int default 0 null comment '通知状态（已读1，未读0）',
    constraint notification_pk
        primary key (id)
)
comment '通知表';

