-- 多数据源测试
create database if not exists `multi-1`; -- 数据库1
create database if not exists `multi-2`; -- 数据库2

use `multi-1`; -- 使用数据库1
drop table if exists `multi-1`.student;

create table if not exists `student`
(
    student_id     int primary key auto_increment comment '唯一标识',
    student_name   varchar(255) comment '用户名称',
    student_gender varchar(10) comment '学生性别',
    create_time    datetime comment '创建时间',
    update_time    datetime comment '更新时间'
) comment '数据库1测试表student';


insert into `multi-1`.student(student_name, student_gender, create_time, update_time)
values ('路人甲', '男', sysdate(), sysdate()),
       ('炮灰乙', '女', sysdate(), sysdate()),
       ('流氓丙', '女', sysdate(), sysdate()),
       ('土匪丁', '男', sysdate(), sysdate()),
       ('舔狗戊', '女', now(), now());

select student_id, student_name, student_gender, create_time, update_time from `multi-1`.student ;


use `multi-2`;
create table if not exists `teacher`
(
    `teacher_id`     int primary key auto_increment comment '教师编号',
    `teacher_name`   varchar(255) comment '教师姓名',
    `teacher_gender` varchar(20) comment '教师性别',
    `create_time`    date comment '创建时间',
    `update_time`    date comment '更新时间'
) comment '数据2测试表teacher';

insert into teacher(teacher_name, teacher_gender, create_time, update_time)
values ('白名', '男', sysdate(), sysdate()),
       ('孙悟空', '男', sysdate(), sysdate()),
       ('白晶晶', '女', sysdate(), sysdate()),
       ('唐僧', '男', sysdate(), sysdate()),
       ('八戒', '男', sysdate(), sysdate());

select teacher_id, teacher_name, teacher_gender, create_time, update_time from teacher;