```sql
CREATE DATABASE spring_demo DEFAULT CHARACTER SET utf8mb4;
USE spring_demo;

create table user
(
  id          int auto_increment primary key,
  name        varchar(30) not null comment '数据源名称',
  create_time datetime default current_timestamp comment '创建时间',
  update_time datetime default current_timestamp on update current_timestamp comment '更新时间'
) engine = innodb
  character set utf8mb4 comment ='user';
```