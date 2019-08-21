-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.5.36 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win32
-- HeidiSQL 版本:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 schooltao 的数据库结构
CREATE DATABASE IF NOT EXISTS `schooltao` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `schooltao`;

-- 导出  表 schooltao.t_buy_goods 结构
CREATE TABLE IF NOT EXISTS `t_buy_goods` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品Id',
  `product_img` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '商品图片',
  `product_title` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '商品标题',
  `product_details` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '商品详情',
  `product_price` double(10,2) NOT NULL COMMENT '商品价格',
  `product_contact_phone` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '商品的联系人电话',
  `product_category_id` int(11) NOT NULL COMMENT '商品种类id',
  `product_contact_qq` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '商品联系人qq',
  `product_publish_time` int(11) NOT NULL COMMENT '商品发布时间',
  `product_status` int(11) NOT NULL COMMENT '商品有效时间',
  `product_by_user_id` int(255) NOT NULL COMMENT '商品发布人的id',
  `product_hot` int(255) NOT NULL COMMENT '商品点击量',
  `product_category_name` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '商品种类名称',
  PRIMARY KEY (`product_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- 正在导出表  schooltao.t_buy_goods 的数据：~20 rows (大约)
/*!40000 ALTER TABLE `t_buy_goods` DISABLE KEYS */;
INSERT INTO `t_buy_goods` (`product_id`, `product_img`, `product_title`, `product_details`, `product_price`, `product_contact_phone`, `product_category_id`, `product_contact_qq`, `product_publish_time`, `product_status`, `product_by_user_id`, `product_hot`, `product_category_name`) VALUES
	(1, '1.img', '貂皮大衣', '貂皮大衣50一件', 50.00, '110', 1, '111', 20190612, 1, 1, 1, '代步工具'),
	(2, '1.img', '虎皮大衣', '貂皮大衣50一件', 50.00, '110', 1, '111', 20190612, 1, 1, 1, '代步工具'),
	(3, '1.img', '蛇皮大衣', '貂皮大衣50一件', 50.00, '110', 1, '111', 20190612, 1, 1, 1, '代步工具'),
	(4, '1.img', '牛皮大衣', '貂皮大衣50一件', 50.00, '110', 1, '111', 20190612, 1, 1, 1, '代步工具'),
	(5, '1.img', '豹皮大衣', '貂皮大衣50一件', 50.00, '110', 1, '111', 20190612, 1, 1, 1, '代步工具'),
	(6, '1.img', '貂皮大衣', '貂皮大衣50一件', 50.00, '110', 1, '111', 20190612, 1, 1, 1, '代步工具'),
	(7, '1.img', '虎皮大衣', '貂皮大衣50一件', 50.00, '110', 1, '111', 20190612, 1, 1, 1, '代步工具'),
	(8, '1.img', '蛇皮大衣', '貂皮大衣50一件', 50.00, '110', 1, '111', 20190612, 0, 1, 1, '代步工具'),
	(9, '1.img', '牛皮大衣', '貂皮大衣50一件', 50.00, '110', 1, '111', 20190612, 0, 1, 1, '代步工具'),
	(10, '1.img', '豹皮大衣', '貂皮大衣50一件', 50.00, '110', 1, '111', 20190612, 1, 1, 1, '代步工具'),
	(11, '1.img', '貂皮大衣', '貂皮大衣50一件', 50.00, '110', 1, '111', 20190612, 1, 1, 1, '代步工具'),
	(12, '1.img', '虎皮大衣', '貂皮大衣50一件', 50.00, '110', 1, '111', 20190612, 1, 1, 1, '代步工具'),
	(13, '1.img', '蛇皮大衣', '貂皮大衣50一件', 50.00, '110', 1, '111', 20190612, 1, 1, 1, '代步工具'),
	(14, '1.img', '牛皮大衣', '貂皮大衣50一件', 50.00, '110', 1, '111', 20190612, 1, 1, 1, '代步工具'),
	(15, '1.img', '豹皮大衣', '貂皮大衣50一件', 50.00, '110', 1, '111', 20190612, 1, 1, 1, '代步工具'),
	(16, '1.img', '貂皮大衣', '貂皮大衣50一件', 50.00, '110', 1, '111', 20190612, 1, 1, 1, '代步工具'),
	(17, '1.img', '虎皮大衣', '貂皮大衣50一件', 50.00, '110', 1, '111', 20190612, 1, 1, 1, '代步工具'),
	(18, '1.img', '蛇皮大衣', '貂皮大衣50一件', 50.00, '110', 1, '111', 20190612, 1, 1, 1, '代步工具'),
	(19, '1.img', '牛皮大衣', '貂皮大衣50一件', 50.00, '110', 1, '111', 20190612, 1, 1, 1, '代步工具'),
	(20, '1.img', '豹皮大衣', '貂皮大衣50一件', 50.00, '110', 1, '111', 20190612, 1, 1, 1, '代步工具');
/*!40000 ALTER TABLE `t_buy_goods` ENABLE KEYS */;

-- 导出  表 schooltao.t_category 结构
CREATE TABLE IF NOT EXISTS `t_category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- 正在导出表  schooltao.t_category 的数据：~11 rows (大约)
/*!40000 ALTER TABLE `t_category` DISABLE KEYS */;
INSERT INTO `t_category` (`category_id`, `category_name`) VALUES
	(1, '代步工具'),
	(2, '手机'),
	(3, '电脑'),
	(4, '数码'),
	(5, '电器'),
	(6, '衣鞋伞帽'),
	(7, '书籍教材'),
	(8, '体育健身'),
	(9, '乐器'),
	(10, '自行设计'),
	(11, '其他');
/*!40000 ALTER TABLE `t_category` ENABLE KEYS */;

-- 导出  表 schooltao.t_collection 结构
CREATE TABLE IF NOT EXISTS `t_collection` (
  `collection_id` int(11) NOT NULL AUTO_INCREMENT,
  `collection_goods_id` int(11) NOT NULL DEFAULT '0',
  `collection_user_id` int(11) NOT NULL DEFAULT '0',
  `collection_status` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`collection_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- 正在导出表  schooltao.t_collection 的数据：~5 rows (大约)
/*!40000 ALTER TABLE `t_collection` DISABLE KEYS */;
INSERT INTO `t_collection` (`collection_id`, `collection_goods_id`, `collection_user_id`, `collection_status`) VALUES
	(1, 1, 1, 1),
	(2, 4, 1, 1),
	(3, 14, 1, 1),
	(4, 15, 1, 1),
	(5, 2, 1, 0),
	(6, 3, 1, 0);
/*!40000 ALTER TABLE `t_collection` ENABLE KEYS */;

-- 导出  表 schooltao.t_comment 结构
CREATE TABLE IF NOT EXISTS `t_comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论id',
  `product_id` int(11) DEFAULT NULL COMMENT '商品id',
  `user_id` int(11) DEFAULT NULL COMMENT '哪个发的评论',
  `comment_time` int(11) DEFAULT NULL COMMENT '发表评论的时间',
  `comment_content` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '评论的内容',
  `comment_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- 正在导出表  schooltao.t_comment 的数据：~11 rows (大约)
/*!40000 ALTER TABLE `t_comment` DISABLE KEYS */;
INSERT INTO `t_comment` (`comment_id`, `product_id`, `user_id`, `comment_time`, `comment_content`, `comment_name`) VALUES
	(8, 3, 3, 1560907756, 'wqdwqdwq', 'stystysty'),
	(9, 3, 3, 1560907780, 'wqdwqdwq', 'stystysty'),
	(10, 3, 3, 1560908372, 'wqdwqdwq', 'stystysty'),
	(11, 3, 3, 1560908374, 'wqdwqdwq', 'stystysty'),
	(12, 3, 3, 1560908651, 'wqdwqdwq', 'stystysty'),
	(13, 3, 3, 1560920936, 'ddwada', 'stystysty'),
	(14, 3, 3, 1560921054, 'sas', 'stystysty'),
	(15, 3, 3, 1560933968, 'dwafafa', 'stystysty'),
	(16, 3, 3, 1560934058, 'dwafafa', 'stystysty'),
	(17, 3, 3, 1560934082, 'dwafafa', 'stystysty'),
	(18, 3, 3, 1560956557, 'sdawd', 'stystysty');
/*!40000 ALTER TABLE `t_comment` ENABLE KEYS */;

-- 导出  表 schooltao.t_reply 结构
CREATE TABLE IF NOT EXISTS `t_reply` (
  `reply_id` int(11) DEFAULT NULL COMMENT '回复的评论信息的id',
  `user_id` int(11) DEFAULT NULL COMMENT '当前评论的用户id',
  `user_name` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '当前用户名',
  `replyuser_id` int(255) DEFAULT NULL COMMENT '回复对象的用户id',
  `replyuser_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '回复对象的用户名',
  `reply_content` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '回复的内容',
  `reply_time` int(11) DEFAULT NULL COMMENT '回复的时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- 正在导出表  schooltao.t_reply 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `t_reply` DISABLE KEYS */;
INSERT INTO `t_reply` (`reply_id`, `user_id`, `user_name`, `replyuser_id`, `replyuser_name`, `reply_content`, `reply_time`) VALUES
	(1, 1, 'sty', 1, 'stystysty', 'test content', 1560934092),
	(2, 1, 'sty', 2, 'stystysty', 'test content', 1560934093),
	(2, 1, 'sty', 2, 'stystysty', 'test content', 1560934098);
/*!40000 ALTER TABLE `t_reply` ENABLE KEYS */;

-- 导出  表 schooltao.t_sale_goods 结构
CREATE TABLE IF NOT EXISTS `t_sale_goods` (
  `goods_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `goods_img` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '商品图片',
  `goods_title` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '商品标题',
  `goods_details` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '商品详情',
  `goods_price` double(10,2) NOT NULL COMMENT '商品的价格',
  `goods_contact_phone` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '商品联系电话',
  `goods_category_id` int(11) NOT NULL COMMENT '商品种类id',
  `goods_contact_qq` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '商品联系QQ',
  `goods_publish_time` int(11) NOT NULL COMMENT '商品发布时间',
  `goods_by_user_id` int(11) NOT NULL COMMENT '商品发布人的id',
  `goods_hot` int(11) NOT NULL COMMENT '商品点击量',
  `goods_category_name` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '商品分类名称',
  `goods_status` int(11) DEFAULT NULL COMMENT '商品有效时间',
  PRIMARY KEY (`goods_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- 正在导出表  schooltao.t_sale_goods 的数据：~21 rows (大约)
/*!40000 ALTER TABLE `t_sale_goods` DISABLE KEYS */;
INSERT INTO `t_sale_goods` (`goods_id`, `goods_img`, `goods_title`, `goods_details`, `goods_price`, `goods_contact_phone`, `goods_category_id`, `goods_contact_qq`, `goods_publish_time`, `goods_by_user_id`, `goods_hot`, `goods_category_name`, `goods_status`) VALUES
	(1, '/10/14/cee34b4589a44d0792acda778ca03240.png', '猫皮大衣', '貂皮大衣50一件', 50.00, '110', 6, '111', 20190612, 1, 3, '衣鞋伞帽', 1),
	(2, '/9/6/87f4dddf76484ddba18718c3dadd1b46.png', '虾皮大衣', '貂皮大衣50一件', 50.00, '110', 1, '111', 20190612, 2, 1, '代步工具', 1),
	(3, '/10/14/cee34b4589a44d0792acda778ca03240.png', '猫皮大衣', '貂皮大衣50一件', 50.00, '110', 6, '111', 20190612, 3, 1, '衣鞋伞帽', 1),
	(4, '/9/6/87f4dddf76484ddba18718c3dadd1b46.png', '虾皮大衣', '貂皮大衣50一件', 50.00, '110', 1, '111', 20190612, 4, 1, '代步工具', 1),
	(5, '/10/14/cee34b4589a44d0792acda778ca03240.png', '猫皮大衣', '貂皮大衣50一件', 50.00, '110', 1, '111', 20190612, 5, 1, '代步工具', 1),
	(6, '/9/6/87f4dddf76484ddba18718c3dadd1b46.png', '虾皮大衣', '貂皮大衣50一件', 50.00, '110', 6, '111', 20190612, 6, 1, '衣鞋伞帽', 1),
	(7, '/10/14/cee34b4589a44d0792acda778ca03240.png', '猫皮大衣', '貂皮大衣50一件', 50.00, '110', 1, '111', 20190612, 1, 3, '代步工具', 0),
	(8, '/9/6/87f4dddf76484ddba18718c3dadd1b46.png', '虾皮大衣', '貂皮大衣50一件', 50.00, '110', 1, '111', 20190612, 2, 1, '代步工具', 1),
	(9, '/10/14/cee34b4589a44d0792acda778ca03240.png', '猫皮大衣', '貂皮大衣50一件', 50.00, '110', 1, '111', 20190612, 3, 19, '代步工具', 1),
	(10, '/9/6/87f4dddf76484ddba18718c3dadd1b46.png', '虾皮大衣', '貂皮大衣50一件', 50.00, '110', 1, '111', 20190612, 4, 9, '代步工具', 0),
	(11, '/9/6/87f4dddf76484ddba18718c3dadd1b46.png', '猫皮大衣', '貂皮大衣50一件', 50.00, '110', 1, '111', 20190612, 5, 3, '代步工具', 1),
	(12, '/9/6/87f4dddf76484ddba18718c3dadd1b46.png', '虾皮大衣', '貂皮大衣50一件', 50.00, '110', 1, '111', 20190612, 6, 2, '代步工具', 1),
	(13, '/9/6/87f4dddf76484ddba18718c3dadd1b46.png', '猫皮大衣', '貂皮大衣50一件', 50.00, '110', 1, '111', 20190612, 2, 1, '代步工具', 1),
	(14, '/10/14/cee34b4589a44d0792acda778ca03240.png', '虾皮大衣', '貂皮大衣50一件', 50.00, '110', 1, '111', 20190612, 1, 28, '代步工具', 1),
	(15, '/10/14/cee34b4589a44d0792acda778ca03240.png', '猫皮大衣', '貂皮大衣50一件', 50.00, '110', 1, '111', 20190612, 3, 8, '代步工具', 1),
	(16, '/10/14/cee34b4589a44d0792acda778ca03240.png', '虾皮大衣', '貂皮大衣50一件', 50.00, '110', 1, '111', 20190612, 4, 1, '代步工具', 1),
	(17, '/9/6/87f4dddf76484ddba18718c3dadd1b46.png', '猫皮大衣', '貂皮大衣50一件', 50.00, '110', 1, '111', 20190612, 5, 5, '代步工具', 1),
	(18, '/9/6/87f4dddf76484ddba18718c3dadd1b46.png', '虾皮大衣', '貂皮大衣50一件', 50.00, '110', 1, '111', 20190612, 6, 1, '代步工具', 1),
	(19, '/9/6/87f4dddf76484ddba18718c3dadd1b46.png', '猫皮大衣', '貂皮大衣50一件', 50.00, '110', 1, '111', 20190612, 3, 1, '代步工具', 1),
	(20, '/9/6/87f4dddf76484ddba18718c3dadd1b46.png', '虾皮大衣', '貂皮大衣50一件', 50.00, '110', 1, '111', 20190612, 2, 1, '代步工具', 1),
	(21, '/9/6/87f4dddf76484ddba18718c3dadd1b46.png', '嘎嘎嘎嘎嘎过', '吧吧吧吧吧吧吧吧吧吧吧吧吧吧吧吧吧吧吧吧v', 123.00, '12345678908', 6, '12345689', 20190625, 1, 14, '衣鞋伞帽', 1);
/*!40000 ALTER TABLE `t_sale_goods` ENABLE KEYS */;

-- 导出  表 schooltao.t_stu 结构
CREATE TABLE IF NOT EXISTS `t_stu` (
  `stu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学生学号',
  `stu_phone` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '学生电话',
  `stu_name` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '学生姓名',
  `stu_xy` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '学生学院信息',
  PRIMARY KEY (`stu_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- 正在导出表  schooltao.t_stu 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `t_stu` DISABLE KEYS */;
INSERT INTO `t_stu` (`stu_id`, `stu_phone`, `stu_name`, `stu_xy`) VALUES
	(1, '111', '李露', '计科'),
	(2, '111', '邵天友', '计科'),
	(3, '111', '沈怡', '计科');
/*!40000 ALTER TABLE `t_stu` ENABLE KEYS */;

-- 导出  表 schooltao.t_user 结构
CREATE TABLE IF NOT EXISTS `t_user` (
  `user_id` int(32) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '用户名',
  `user_pwd` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '用户密码',
  `user_email` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '用户邮箱',
  `user_status` int(255) NOT NULL COMMENT '用户是否认证的状态',
  `user_img` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '用户头像',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;

-- 正在导出表  schooltao.t_user 的数据：~6 rows (大约)
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` (`user_id`, `user_name`, `user_pwd`, `user_email`, `user_status`, `user_img`) VALUES
	(1, 'stystysty', '11111111', '111@qq.com', 0, '/9/6/87f4dddf76484ddba18718c3dadd1b46.png'),
	(2, 'wwwwwwww', '11111111', 'w@qq.com', 0, '/10/14/cee34b4589a44d0792acda778ca03240.png'),
	(3, 'wqewqewe', 'qwewqeqw', 'qw@qq.com', 0, '1.png'),
	(4, 'wdawawaw', '11111111', 'w@qq.com', 0, '1.png'),
	(5, 'dawdwdew', '22222222', 'aas@qq.com', 0, '1.png'),
	(6, 'dwdadawd', '2222222', '2@qq.com', 0, '1.png');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;