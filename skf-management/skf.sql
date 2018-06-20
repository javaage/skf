/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     6/20/2018 2:32:21 PM                         */
/*==============================================================*/


drop table if exists SKF_BRNG;

drop table if exists SKF_CMPT;

drop table if exists SKF_CPCT;

drop table if exists SKF_CSTM;

drop table if exists SKF_GEAR;

drop table if exists SKF_IMG;

drop table if exists SKF_OEM;

drop table if exists SKF_QPMT;

drop table if exists SKF_QPMT_TYPE;

drop table if exists SKF_RL;

drop table if exists SKF_SNSR;

drop table if exists SKF_USR;

drop table if exists SKF_USR_CSTM;

drop table if exists SKF_USR_OEM;

/*==============================================================*/
/* Table: SKF_BRNG                                              */
/*==============================================================*/
create table SKF_BRNG
(
   BRNG_CODE            varchar(50) not null,
   BRNG_MODEL_NUMBER    varchar(50) not null,
   BRNG_MANUFACTURE     varchar(50),
   BRNG_DESCRIPTION     varchar(1024),
   BRNG_BPFO            float,
   BRNG_BPFI            float,
   BRNG_BSF             float,
   BRNG_FTF             float,
   BRNG_IMAGE_CODE      varchar(50) not null,
   primary key (BRNG_CODE),
   unique key AK_KEY_BRNG_MODEL_NUMBER (BRNG_MODEL_NUMBER)
)
charset = UTF8;

alter table SKF_BRNG comment 'bearing';

/*==============================================================*/
/* Table: SKF_CMPT                                              */
/*==============================================================*/
create table SKF_CMPT
(
   CMPT_CODE            varchar(50) not null,
   CMPT_NAME            varchar(50) not null,
   CMPT_SNSR_CODE       varchar(50) not null,
   CMPT_CPCT_ID         int not null,
   CMPT_BEARINGGEAR_CODE varchar(50) not null,
   CMPT_DANGER_LEVEL    float not null,
   CMPT_ROTATION_SPEED  float,
   CMPT_SPEED_TYPE      int not null,
   CMPT_SCHEMA_NAME     varchar(50),
   CMPT_NODE_ID         int(11),
   CMPT_TOTAL_VALUE     float not null,
   CMPT_DEFECT_RANGE    float,
   CMPT_DEFECT_TYPE     int not null,
   CMPT_RATIO           float,
   primary key (CMPT_CODE),
   unique key AK_KEY_CMPT_NAME (CMPT_NAME, CMPT_SNSR_CODE)
)
charset = UTF8;

alter table SKF_CMPT comment 'component';

/*==============================================================*/
/* Table: SKF_CPCT                                              */
/*==============================================================*/
create table SKF_CPCT
(
   CPCT_ID              int not null auto_increment,
   CPCT_NAME            varchar(50) not null,
   primary key (CPCT_ID)
)
charset = UTF8;

alter table SKF_CPCT comment 'component catelog';

/*==============================================================*/
/* Table: SKF_CSTM                                              */
/*==============================================================*/
create table SKF_CSTM
(
   CSTM_OEM_CODE        VARCHAR(50) not null,
   CSTM_CODE            VARCHAR(50) not null,
   CSTM_NAME            VARCHAR(50) not null,
   CSTM_COUNTRY         varchar(50) not null,
   CSTM_STATE           varchar(50) not null,
   CSTM_CITY            varchar(50) not null,
   CSTM_ADDRESS         VARCHAR(50) not null,
   CSTM_URL             varchar(50),
   CSTM_INTRODUCTION    varchar(50),
   CSTM_IMG             mediumblob not null,
   primary key (CSTM_CODE),
   unique key AK_KEY_CSTM_NAME (CSTM_NAME)
)
charset = UTF8;

alter table SKF_CSTM comment 'custom';

/*==============================================================*/
/* Table: SKF_GEAR                                              */
/*==============================================================*/
create table SKF_GEAR
(
   GEAR_CODE            varchar(50) not null,
   GEAR_MODEL_NUMBER    varchar(50) not null,
   GEAR_MANUFACTURE     varchar(50),
   GEAR_DESCRIPTION     varchar(1024),
   GEAR_MESHING_FREQUENCY float,
   GEAR_IMAGE_CODE      varchar(50) not null,
   primary key (GEAR_CODE),
   unique key AK_KEY_GEAR_MODEL_NUMBER (GEAR_MODEL_NUMBER)
)
charset = UTF8;

alter table SKF_GEAR comment 'gear';

/*==============================================================*/
/* Table: SKF_IMG                                               */
/*==============================================================*/
create table SKF_IMG
(
   IMG_CODE             varchar(50) not null,
   IMG_CPCT_ID          int not null,
   IMG_DATA             mediumblob not null,
   primary key (IMG_CODE)
)
charset = UTF8;

/*==============================================================*/
/* Table: SKF_OEM                                               */
/*==============================================================*/
create table SKF_OEM
(
   OEM_CODE             VARCHAR(50) not null,
   OEM_NAME             VARCHAR(50) not null,
   OEM_COUNTRY          varchar(50) not null,
   OEM_STATE            varchar(50) not null,
   OEM_CITY             varchar(50) not null,
   OEM_ADDRESS          VARCHAR(50) not null,
   OEM_URL              varchar(50),
   OEM_INTRODUCTION     varchar(1024),
   OEM_IMG              mediumblob not null,
   primary key (OEM_CODE),
   unique key AK_KEY_OEM_NAME (OEM_NAME, OEM_CODE)
)
charset = UTF8;

alter table SKF_OEM comment 'oem';

/*==============================================================*/
/* Table: SKF_QPMT                                              */
/*==============================================================*/
create table SKF_QPMT
(
   QPMT_CODE            VARCHAR(50) not null,
   QPMT_TYPE_CODE       VARCHAR(50) not null,
   QPMT_NAME            VARCHAR(50) not null,
   QPMT_SETUP_DATE      date not null,
   QPMT_CSTM_CODE       varchar(50) not null,
   primary key (QPMT_CODE),
   unique key AK_KEY_QPMT_NAME (QPMT_NAME, QPMT_CSTM_CODE)
)
charset = UTF8;

alter table SKF_QPMT comment 'equipment';

/*==============================================================*/
/* Table: SKF_QPMT_TYPE                                         */
/*==============================================================*/
create table SKF_QPMT_TYPE
(
   QPTP_CSTM_CODE       VARCHAR(50) not null,
   QPTP_TYPE_CODE       VARCHAR(50) not null,
   QPTP_TYPE_NAME       VARCHAR(50) not null,
   QPTP_TYPE_DESC       VARCHAR(50),
   QPTP_TYPE_IMG        mediumblob not null,
   primary key (QPTP_TYPE_CODE),
   unique key AK_KEY_QPTP_TYPE_NAME (QPTP_TYPE_NAME, QPTP_CSTM_CODE)
)
charset = UTF8;

alter table SKF_QPMT_TYPE comment 'equipment type';

/*==============================================================*/
/* Table: SKF_RL                                                */
/*==============================================================*/
create table SKF_RL
(
   RL_ID                int not null,
   RL_NAME              varchar(50) not null,
   primary key (RL_ID)
)
charset = UTF8;

alter table SKF_RL comment 'role';

/*==============================================================*/
/* Table: SKF_SNSR                                              */
/*==============================================================*/
create table SKF_SNSR
(
   SNSR_CODE            varchar(50) not null,
   SNSR_QPMT_CODE       varchar(50) not null,
   SNSR_NAME            varchar(50) not null,
   SNSR_ANGLE           float not null,
   SNSR_POS_X           float not null,
   SNSR_POS_Y           float not null,
   SNSR_SCHEMA_NAME     varchar(50) not null,
   SNSR_NODE_ID         int(11) not null,
   primary key (SNSR_CODE),
   unique key AK_KEY_SNSR_NAME (SNSR_NAME)
)
charset = UTF8;

alter table SKF_SNSR comment 'sensor';

/*==============================================================*/
/* Table: SKF_USR                                               */
/*==============================================================*/
create table SKF_USR
(
   USR_CODE             varchar(50) not null,
   USR_NAME             varchar(50) not null,
   USR_COMPANY          varchar(50) not null,
   USR_ADDRESS          varchar(50) not null,
   USR_RL_ID            int not null,
   USR_PASSWORD         varchar(50) not null,
   USR_PHONE            varchar(50) not null,
   USR_EMAIL            varchar(50) not null,
   USR_IMG              mediumblob not null,
   USR_LOGIN_TIME       timestamp,
   primary key (USR_CODE),
   unique key AK_KEY_USR_NAME (USR_NAME),
   unique key AK_USR_PHONE (USR_PHONE),
   unique key AK_USR_EMAIL (USR_EMAIL)
)
charset = UTF8;

alter table SKF_USR comment 'user';

/*==============================================================*/
/* Table: SKF_USR_CSTM                                          */
/*==============================================================*/
create table SKF_USR_CSTM
(
   USR_CODE             varchar(50) not null,
   CSTM_CODE            varchar(50) not null,
   primary key (USR_CODE, CSTM_CODE)
)
charset = UTF8;

/*==============================================================*/
/* Table: SKF_USR_OEM                                           */
/*==============================================================*/
create table SKF_USR_OEM
(
   USR_CODE             varchar(50) not null,
   OEM_CODE             VARCHAR(50) not null,
   primary key (USR_CODE, OEM_CODE)
)
charset = UTF8;

alter table SKF_BRNG add constraint FK_REFERENCE_BRNG_IMAGE_CODE foreign key (BRNG_IMAGE_CODE)
      references SKF_IMG (IMG_CODE) on delete restrict on update restrict;

alter table SKF_CMPT add constraint FK_REFERENCE_CMPT_CPTT_ID foreign key (CMPT_CPCT_ID)
      references SKF_CPCT (CPCT_ID) on delete restrict on update restrict;

alter table SKF_CMPT add constraint FK_REFERENCE_COMPT_SNSR_CODE foreign key (CMPT_SNSR_CODE)
      references SKF_SNSR (SNSR_CODE) on delete restrict on update restrict;

alter table SKF_CSTM add constraint FK_REFERENCE_SHOP_CSTM_CODE foreign key (CSTM_OEM_CODE)
      references SKF_OEM (OEM_CODE) on delete restrict on update restrict;

alter table SKF_GEAR add constraint FK_REFERENCE_GEAR_IMAGE_CODE foreign key (GEAR_IMAGE_CODE)
      references SKF_IMG (IMG_CODE) on delete restrict on update restrict;

alter table SKF_QPMT add constraint FK_REFERENCE_QPMT_CSTM_CODE foreign key (QPMT_CSTM_CODE)
      references SKF_CSTM (CSTM_CODE) on delete restrict on update restrict;

alter table SKF_QPMT add constraint FK_REFERENCE_QPMT_TYPE_CODE foreign key (QPMT_TYPE_CODE)
      references SKF_QPMT_TYPE (QPTP_TYPE_CODE) on delete restrict on update restrict;

alter table SKF_QPMT_TYPE add constraint FK_REFERENCE_QPTP_CSTM_CODE foreign key (QPTP_CSTM_CODE)
      references SKF_CSTM (CSTM_CODE) on delete restrict on update restrict;

alter table SKF_SNSR add constraint FK_REFERENCE_SNSR_QPMT_CODE foreign key (SNSR_QPMT_CODE)
      references SKF_QPMT (QPMT_CODE) on delete restrict on update restrict;

alter table SKF_USR add constraint FK_REFERENCE_USR_RL_ID foreign key (USR_RL_ID)
      references SKF_RL (RL_ID) on delete restrict on update restrict;

alter table SKF_USR_CSTM add constraint FK_REFERENCE_CSTM_USR_CODE foreign key (USR_CODE)
      references SKF_USR (USR_CODE) on delete restrict on update restrict;

alter table SKF_USR_CSTM add constraint FK_REFERENCE_USR_CSTM_CODE foreign key (CSTM_CODE)
      references SKF_CSTM (CSTM_CODE) on delete restrict on update restrict;

alter table SKF_USR_OEM add constraint FK_REFERENCE_OEM_USR_CODE foreign key (USR_CODE)
      references SKF_USR (USR_CODE) on delete restrict on update restrict;

alter table SKF_USR_OEM add constraint FK_REFERENCE_USR_OEM_CODE foreign key (OEM_CODE)
      references SKF_OEM (OEM_CODE) on delete restrict on update restrict;

