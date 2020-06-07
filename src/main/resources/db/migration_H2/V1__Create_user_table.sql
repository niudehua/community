create table USER
(
	ID BIGINT auto_increment,
	TOKEN CHAR(36),
	NAME VARCHAR(50),
	ACCOUNT_ID VARCHAR(100),
	GMT_CREAT BIGINT,
	GMT_MODIFIED BIGINT,
	BIO VARCHAR(256),
	AVATAR_URL VARCHAR(100),
	constraint USER_PK
		primary key (ID)
);

comment on column USER.ID is '主键ID';

comment on column USER.TOKEN is '登录令牌';

comment on column USER.NAME is '用户名称';

comment on column USER.ACCOUNT_ID is '账户名';

comment on column USER.GMT_CREAT is '创建时间';

comment on column USER.GMT_MODIFIED is '修改时间';

comment on column USER.BIO is '个人经历';

comment on column USER.AVATAR_URL is '网络头像';

