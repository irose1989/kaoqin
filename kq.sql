-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.6.26-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.2.0.4947
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 kq 的数据库结构
CREATE DATABASE IF NOT EXISTS `kq` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `kq`;


-- 导出  表 kq.attendance 结构
CREATE TABLE IF NOT EXISTS `attendance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL COMMENT '日期表',
  `user_id` int(11) DEFAULT NULL COMMENT '员工id',
  `workhours` int(11) DEFAULT NULL COMMENT '正常工作时间',
  `overhour` int(11) DEFAULT NULL COMMENT '加班小时',
  `work_off` int(11) DEFAULT NULL COMMENT '调休',
  `late` int(11) DEFAULT NULL COMMENT '迟到',
  `early` int(11) DEFAULT NULL COMMENT '早退',
  `absent` int(11) DEFAULT NULL COMMENT '旷工',
  `on_duty` date DEFAULT NULL COMMENT '上班时间',
  `off_duty` date DEFAULT NULL COMMENT '下班时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。


-- 导出  表 kq.emp_user 结构
CREATE TABLE IF NOT EXISTS `emp_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) DEFAULT NULL COMMENT '用户名',
  `job_state` int(11) DEFAULT NULL COMMENT '状态0，在职，1，离职，2，待入职，3，离职调出4，离职调回，',
  `real_name` varchar(32) DEFAULT NULL COMMENT '真实名字',
  `telephone` varchar(22) DEFAULT NULL COMMENT '手机号',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `roleId` int(11) DEFAULT NULL COMMENT '角色id 1，普通 2，管理员，3，项目经理',
  `job` int(11) DEFAULT NULL COMMENT '职务岗位 1，java，2，前端，3，UED，4，测试，5，PM',
  `professional_skill` int(11) DEFAULT NULL COMMENT '专业技术  同上',
  `skill_lever` int(11) DEFAULT NULL COMMENT '技术等级 1，初级，2，中级 3，高级，4，资深',
  `location` varchar(22) DEFAULT NULL COMMENT '办公地点',
  `on_the_job` varchar(22) DEFAULT NULL COMMENT '是否在职 1，在职，2,离职',
  `hiredate` date DEFAULT NULL COMMENT '入职日期',
  `departure_date` date DEFAULT NULL COMMENT '离职日期',
  `project_id` int(11) DEFAULT NULL COMMENT '项目编号 匹配项目的id',
  `wangwang_num` int(11) DEFAULT NULL COMMENT '旺旺号',
  `isoft_no` int(11) DEFAULT NULL COMMENT '软通工号',
  `wb_no` int(11) DEFAULT NULL COMMENT '外包工号',
  `isoft_email` varchar(62) DEFAULT NULL COMMENT '软通邮箱',
  `wb_email` varchar(62) DEFAULT NULL COMMENT '阿里邮箱',
  `description` text COMMENT '备注说明',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `telephone` (`telephone`),
  UNIQUE KEY `isoft_no` (`isoft_no`),
  UNIQUE KEY `wb_no` (`wb_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。


-- 导出  表 kq.project 结构
CREATE TABLE IF NOT EXISTS `project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(32) DEFAULT NULL COMMENT '实际项目',
  `project_type` varchar(10) DEFAULT NULL COMMENT '项目类型',
  `project_state` int(11) DEFAULT NULL COMMENT '项目状态 0，筹建中 1，进行中，2，已结束',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。


-- 导出  表 kq.record 结构
CREATE TABLE IF NOT EXISTS `record` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '入职 离职 入项 离项 记录',
  `project_id` int(11) DEFAULT NULL COMMENT '项目id',
  `user_id` int(11) DEFAULT NULL COMMENT '员工id',
  `in_job` date DEFAULT NULL COMMENT '入职时间',
  `out_job` date DEFAULT NULL COMMENT '离职时间',
  `in_project` date DEFAULT NULL COMMENT '入项时间',
  `out_project` date DEFAULT NULL COMMENT '离项时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
