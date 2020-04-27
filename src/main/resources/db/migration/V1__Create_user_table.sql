create table USER
(
	ID INT auto_increment,
	TOKEN CHAR(36),
	NAME VARCHAR(50),
	ACCOUNT_ID VARCHAR(100),
	GMT_CREAT BIGINT,
	GMT_MODIFIED BIGINT,
	BIO VARCHAR(256),
	constraint USER_PK
		primary key (ID)
);

