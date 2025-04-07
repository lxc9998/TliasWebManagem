create table dept(
                     id int unsigned primary key auto_increment comment 'ID，主键',
                     dept_name varchar(12) not null unique comment '部门名称',
                     create_time datetime not null default current_timestamp comment '创建时间',
                     update_time datetime not null default current_timestamp on update current_timestamp comment '更新时间'
) comment '部门表';


insert into dept
values (1, '学工部', '2025-03-23 18:05:02', '2025-03-23 18:05:12'),
       (2, '教研部', '2025-03-23 18:09:05', '2025-03-23 18:09:14'),
       (3, '咨询部', '2025-03-23 18:10:42', '2025-03-23 18:10:48'),
       (4, '就业部', '2025-03-23 18:11:04', '2025-03-23 18:11:07'),
       (5, '人事部', '2025-03-23 18:11:20', '2025-03-23 18:11:23'),
       (6, '行政部', '2025-03-23 18:11:41', '2025-03-23 18:11:48');

select * from dept;

-- 修改字段名
ALTER table dept rename column name to dept_name;
alter table dept change name dept_name1 varchar(12);

-- 修改crete_time默认为current_timestamp
alter table dept
    modify create_time datetime not null default current_timestamp,
    modify update_time datetime not null default current_timestamp on update current_timestamp;

DESCRIBE dept;

SHOW CREATE TABLE dept;

ALTER TABLE dept RENAME INDEX dept_name TO dept_name;

-- 先删除原有唯一约束
ALTER TABLE dept DROP INDEX name;

-- 添加新的唯一约束
ALTER TABLE dept ADD UNIQUE KEY dept_name (dept_name);


-- 创建员工表
create table emp(
                    id int unsigned primary key auto_increment comment '主键id',
                    user_name varchar(20) not null unique comment '用户名'
)