# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table check_in (
  id                        integer auto_increment not null,
  date                      datetime(6),
  constraint pk_check_in primary key (id))
;

create table clothes (
  id                        integer auto_increment not null,
  number                    varchar(255),
  size                      varchar(255),
  color                     varchar(255),
  sold                      tinyint(1) default 0,
  price                     double,
  cost                      double,
  sold_price                double,
  note                      varchar(255),
  constraint pk_clothes primary key (id))
;

create table clothes_order (
  id                        integer auto_increment not null,
  date                      datetime(6),
  name                      varchar(255),
  amount                    double,
  note                      varchar(255),
  processing_fee            double,
  constraint pk_clothes_order primary key (id))
;

create table fur (
  id                        integer auto_increment not null,
  date                      bigint,
  gender                    varchar(255),
  color                     varchar(255),
  price                     double,
  note                      varchar(255),
  constraint pk_fur primary key (id))
;

create table fur_order (
  id                        integer auto_increment not null,
  amount                    integer,
  constraint uq_fur_order_id unique (id),
  constraint pk_fur_order primary key (id))
;

create table payment_record (
  id                        integer auto_increment not null,
  type                      varchar(255),
  info                      varchar(255),
  amount                    double,
  date                      datetime(6),
  constraint pk_payment_record primary key (id))
;

create table price_change_record (
  id                        integer auto_increment not null,
  date                      datetime(6),
  prev_price                double,
  cur_price                 double,
  constraint pk_price_change_record primary key (id))
;

create table rebate_record (
  id                        integer auto_increment not null,
  name                      varchar(255),
  amount                    double,
  constraint pk_rebate_record primary key (id))
;

create table receipt (
  id                        integer auto_increment not null,
  date                      datetime(6),
  total                     double,
  paid                      tinyint(1) default 0,
  note                      varchar(255),
  constraint pk_receipt primary key (id))
;

create table return_record (
  id                        integer auto_increment not null,
  date                      datetime(6),
  constraint pk_return_record primary key (id))
;

create table salary (
  id                        integer auto_increment not null,
  start_date                datetime(6),
  end_date                  datetime(6),
  base                      double,
  bonus                     double,
  total                     double,
  constraint pk_salary primary key (id))
;

create table sale_record (
  id                        integer auto_increment not null,
  price                     double,
  returned                  tinyint(1) default 0,
  constraint pk_sale_record primary key (id))
;

create table staff (
  id                        integer auto_increment not null,
  name                      varchar(255),
  constraint pk_staff primary key (id))
;

create table store (
  id                        integer auto_increment not null,
  name                      varchar(255),
  constraint pk_store primary key (id))
;

alter table fur_order add constraint fk_fur_order_fur_1 foreign key (id) references fur (id) on delete restrict on update restrict;
create index ix_fur_order_fur_1 on fur_order (id);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table check_in;

drop table clothes;

drop table clothes_order;

drop table fur;

drop table fur_order;

drop table payment_record;

drop table price_change_record;

drop table rebate_record;

drop table receipt;

drop table return_record;

drop table salary;

drop table sale_record;

drop table staff;

drop table store;

SET FOREIGN_KEY_CHECKS=1;

