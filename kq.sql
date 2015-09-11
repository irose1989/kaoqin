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
  `date` date DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
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
  `username` varchar(32) DEFAULT NULL,
  `real_name` varchar(32) DEFAULT NULL,
  `telephone` varchar(22) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL,
  `job` int(11) DEFAULT NULL,
  `professional_skill` int(11) DEFAULT NULL COMMENT '专业技术',
  `skill_lever` int(11) DEFAULT NULL,
  `location` varchar(22) DEFAULT NULL,
  `hiredate` date DEFAULT NULL,
  `departure_date` date DEFAULT NULL,
  `project_id` int(11) DEFAULT NULL,
  `join_project_date` date DEFAULT NULL,
  `out_project_date` date DEFAULT NULL,
  `wangwang_num` int(11) DEFAULT NULL,
  `isoft_no` int(11) DEFAULT NULL,
  `wb_no` int(11) DEFAULT NULL,
  `isoft_email` varchar(62) DEFAULT NULL,
  `wb_email` varchar(62) DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。


-- 导出  表 kq.project 结构
CREATE TABLE IF NOT EXISTS `project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(32) DEFAULT NULL,
  `project_type` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
