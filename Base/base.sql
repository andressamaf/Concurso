/*==============================================================*/
/* DBMS name:      Sybase SQL Anywhere 12                       */
/* Created on:     31/7/2016 21:57:31                           */
/*==============================================================*/


if exists(select 1 from sys.sysforeignkey where role='FK_CIUDAD_2_PROVINCI') then
    alter table CIUDAD
       delete foreign key FK_CIUDAD_2_PROVINCI
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_PROVINCI_1_SOLICITU') then
    alter table PROVINCIA
       delete foreign key FK_PROVINCI_1_SOLICITU
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_SOLICITU_3_USUARIO') then
    alter table SOLICITUD
       delete foreign key FK_SOLICITU_3_USUARIO
end if;

drop index if exists CIUDAD.2_FK;

drop index if exists CIUDAD.CIUDAD_PK;

drop table if exists CIUDAD;

drop index if exists PROVINCIA.1_FK;

drop index if exists PROVINCIA.PROVINCIA_PK;

drop table if exists PROVINCIA;

drop index if exists SOLICITUD.3_FK;

drop index if exists SOLICITUD.SOLICITUD_PK;

drop table if exists SOLICITUD;

drop index if exists USUARIO.USUARIO_PK;

drop table if exists USUARIO;

/*==============================================================*/
/* Table: CIUDAD                                                */
/*==============================================================*/
create table CIUDAD 
(
   CIUDAD_ID            int(11)                        not null,
   CIUDAD_NOMBRE        varchar(45)                    not null,
   PROVINCIA_ID         int(11)                        not null,
   constraint PK_CIUDAD primary key (CIUDAD_ID)
);

/*==============================================================*/
/* Index: CIUDAD_PK                                             */
/*==============================================================*/
create unique index CIUDAD_PK on CIUDAD (
CIUDAD_ID ASC
);

/*==============================================================*/
/* Index: 2_FK                                                  */
/*==============================================================*/
create index 2_FK on CIUDAD (
PROVINCIA_ID ASC
);

/*==============================================================*/
/* Table: PROVINCIA                                             */
/*==============================================================*/
create table PROVINCIA 
(
   PROVINCIA_ID         int(11)                        not null,
   SOL_CI               varchar(10)                    null,
   PROVINCIA_NOMBRE     varchar(45)                    null,
   constraint PK_PROVINCIA primary key (PROVINCIA_ID)
);

/*==============================================================*/
/* Index: PROVINCIA_PK                                          */
/*==============================================================*/
create unique index PROVINCIA_PK on PROVINCIA (
PROVINCIA_ID ASC
);

/*==============================================================*/
/* Index: 1_FK                                                  */
/*==============================================================*/
create index 1_FK on PROVINCIA (
SOL_CI ASC
);

/*==============================================================*/
/* Table: SOLICITUD                                             */
/*==============================================================*/
create table SOLICITUD 
(
   SOL_CI               varchar(10)                    not null,
   USR_CI               varchar(10)                    null,
   SOL_APELLIDOS        varchar(50)                    not null,
   SOL_NOMBRE           varchar(50)                    not null,
   SOL_CODPROV          int(11)                        not null,
   SOL_CODCIU           int(11)                        not null,
   SOL_SEXO             varchar(1)                     not null,
   SOL_FECHANAC         date                           not null,
   SOL_NUMMIEM          int(11)                        not null,
   SOL_TELEFONO         varchar(15)                    not null,
   SOL_DISC             tinyint(4)                     not null,
   SOL_FECHA            date                           not null,
   SOL_ESTADO           varchar(1)                     not null,
   constraint PK_SOLICITUD primary key (SOL_CI)
);

/*==============================================================*/
/* Index: SOLICITUD_PK                                          */
/*==============================================================*/
create unique index SOLICITUD_PK on SOLICITUD (
SOL_CI ASC
);

/*==============================================================*/
/* Index: 3_FK                                                  */
/*==============================================================*/
create index 3_FK on SOLICITUD (
USR_CI ASC
);

/*==============================================================*/
/* Table: USUARIO                                               */
/*==============================================================*/
create table USUARIO 
(
   USR_CI               varchar(10)                    not null,
   USR_ROL              varchar(15)                    not null,
   USR_CLAVE            varchar(32)                    not null,
   USR_NOMBRE           varchar(70)                    not null,
   USR_TELEFONO         varchar(15)                    not null,
   USR_CORREO           varchar(60)                    not null,
   constraint PK_USUARIO primary key (USR_CI)
);

/*==============================================================*/
/* Index: USUARIO_PK                                            */
/*==============================================================*/
create unique index USUARIO_PK on USUARIO (
USR_CI ASC
);

alter table CIUDAD
   add constraint FK_CIUDAD_2_PROVINCI foreign key (PROVINCIA_ID)
      references PROVINCIA (PROVINCIA_ID)
      on update restrict
      on delete restrict;

alter table PROVINCIA
   add constraint FK_PROVINCI_1_SOLICITU foreign key (SOL_CI)
      references SOLICITUD (SOL_CI)
      on update restrict
      on delete restrict;

alter table SOLICITUD
   add constraint FK_SOLICITU_3_USUARIO foreign key (USR_CI)
      references USUARIO (USR_CI)
      on update restrict
      on delete restrict;

