/*
Navicat MySQL Data Transfer

Source Server         : lyc
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-06-07 22:53:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for persistent_logins
-- ----------------------------
DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of persistent_logins
-- ----------------------------
INSERT INTO `persistent_logins` VALUES ('王致和', 'lJp4tR5Xu639ri+1YFY8gA==', 'xA55JVtV9QlRpFbSYcg+sg==', '2018-05-05 19:41:06');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `age` tinyint(4) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `sex` tinyint(4) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  `image_url` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '王致和', '123456', '纸盒', '30', '15811525928', '0', '2015-06-09 00:00:00', '2015-06-10 00:00:00', '2015-06-11 00:00:00', null);
INSERT INTO `t_user` VALUES ('6', '亚超', '123456', null, null, null, null, null, null, null, 'http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKiaSGNaly6XzgQq72DuL05icvRJAWufXnCKTt0QspNU6cNiaaichhEHWuBWhOcR4HudQwfD6fDnTCJjQ/132');
INSERT INTO `t_user` VALUES ('7', 'EXCEPTION', '123456', null, null, null, null, null, null, null, 'http://thirdqq.qlogo.cn/qqapp/100550231/35976670941B1DA35C9B7BC95A603C88/40');
INSERT INTO `t_user` VALUES ('8', '晓诗', '123456', null, null, null, null, null, null, null, 'http://thirdqq.qlogo.cn/qqapp/100550231/06A5478592CF9CDBDE218B5CE4997064/40');

-- ----------------------------
-- Table structure for t_userconnection
-- ----------------------------
DROP TABLE IF EXISTS `t_userconnection`;
CREATE TABLE `t_userconnection` (
  `userId` varchar(255) NOT NULL,
  `providerId` varchar(255) NOT NULL,
  `providerUserId` varchar(255) NOT NULL,
  `rank` int(11) NOT NULL,
  `displayName` varchar(255) DEFAULT NULL,
  `profileUrl` varchar(512) DEFAULT NULL,
  `imageUrl` varchar(512) DEFAULT NULL,
  `accessToken` varchar(512) NOT NULL,
  `secret` varchar(512) DEFAULT NULL,
  `refreshToken` varchar(512) DEFAULT NULL,
  `expireTime` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`userId`,`providerId`,`providerUserId`),
  UNIQUE KEY `UserConnectionRank` (`userId`,`providerId`,`rank`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_userconnection
-- ----------------------------
INSERT INTO `t_userconnection` VALUES ('EXCEPTION', 'callback.do', '35976670941B1DA35C9B7BC95A603C88', '1', 'EXCEPTION', null, 'http://thirdqq.qlogo.cn/qqapp/100550231/35976670941B1DA35C9B7BC95A603C88/40', 'BA3934E5BB8A7B1FCA363B08B3CE7247', null, '035C173F9E676B77A3637F1BAD5214B4', '1536157485222');
INSERT INTO `t_userconnection` VALUES ('亚超', 'weixin', 'od4PTw3NGDtZwA2ptDjLBBVnGx6U', '1', '亚超', null, 'http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKiaSGNaly6XzgQq72DuL05icvRJAWufXnCKTt0QspNU6cNiaaichhEHWuBWhOcR4HudQwfD6fDnTCJjQ/132', '10_jMaziOfzDJy7zhvrMrJbMSudiUlc-J7rhxyux-CvlGa6nwPO-dZouM1AeB8Ri29uZNq_Z4xlcdDubdUbHbifvw', null, '10_-w8IJOUNeVgyqzud-eazvPTJJwREqR_L_LziO2xIH_ZkznMEn04FzxDGJRzpKyVoCgZNjpOS-x5KKSMAG_RsGg', '1528389330963');
INSERT INTO `t_userconnection` VALUES ('晓诗', 'callback.do', '06A5478592CF9CDBDE218B5CE4997064', '1', '晓诗', null, 'http://thirdqq.qlogo.cn/qqapp/100550231/06A5478592CF9CDBDE218B5CE4997064/40', 'E30D7BDBD09A32A9D50DA51BA7ECC375', null, 'B5EC0917C641544B55793024B17C9BFD', '1536158294189');
DROP TRIGGER IF EXISTS `inset_in_user`;
DELIMITER ;;
CREATE TRIGGER `inset_in_user` AFTER INSERT ON `t_userconnection` FOR EACH ROW insert into t_user(user_name,password,image_url) values(NEW.userId,'123456',NEW.imageUrl)
;;
DELIMITER ;
