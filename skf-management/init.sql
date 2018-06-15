drop table if exists SKF_GEAR;
drop table if exists SKF_BRNG;
drop table if exists SKF_IMG;
drop table if exists SKF_CMPT;
drop table if exists SKF_CPCT;
drop table if exists SKF_SNSR;
drop table if exists SKF_QPMT;
drop table if exists SKF_QPMT_TYPE;
drop table if exists SKF_USR_CSTM;
drop table if exists SKF_USR_OEM;
drop table if exists SKF_CSTM;
drop table if exists SKF_OEM;
drop table if exists SKF_USR;
drop table if exists SKF_RL;

INSERT INTO SKF_CPCT
(CPCT_ID,CPCT_NAME)
VALUES
(1,'bearing'),(2,'gear');

INSERT INTO SKF_RL
(`RL_ID`,
`RL_NAME`)
VALUES
(1,'admin'),(2,'user');


INSERT INTO SKF_USR
(`USR_CODE`,
`USR_NAME`,
`USR_COMPANY`,
`USR_ADDRESS`,
`USR_RL_ID`,
`USR_PASSWORD`,
`USR_PHONE`,
`USR_EMAIL`,
`USR_IMG`,
`USR_LOGIN_TIME`)
VALUES
('f4493e316ade11e89b3000ffa79f2300',
'admin',
'skf',
'skf',
1,
'U2tmMTIzNDU2',
13333333333,
'admin@skf.com',
'img',
now());
/** 
 * password: Skf123456
 */




