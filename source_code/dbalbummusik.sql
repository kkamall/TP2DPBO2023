/*
Navicat MySQL Data Transfer

Source Server         : Koneksi_Saya
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : dbalbummusik

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2023-04-13 09:55:42
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id_admin` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  PRIMARY KEY (`id_admin`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'kamal', 'kamal123');
INSERT INTO `admin` VALUES ('2', 'nurrr', 'nur123');
INSERT INTO `admin` VALUES ('3', 'a', 'a');

-- ----------------------------
-- Table structure for `album_musik`
-- ----------------------------
DROP TABLE IF EXISTS `album_musik`;
CREATE TABLE `album_musik` (
  `id_album` int(11) NOT NULL AUTO_INCREMENT,
  `nama_album` varchar(25) NOT NULL,
  `tahun_rilis` varchar(4) NOT NULL,
  `nama_musisi` varchar(25) NOT NULL,
  `path` varchar(255) DEFAULT '',
  PRIMARY KEY (`id_album`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of album_musik
-- ----------------------------
INSERT INTO `album_musik` VALUES ('1', 'Collide With The Sky', '2012', 'Pierce The Veil', 'fotoAlbum/CollidewiththeSkycover.jpg');
INSERT INTO `album_musik` VALUES ('4', 'Here We Go Again', '2000', 'SR-71', 'fotoAlbum/HereWeGoAgain.jpg');
INSERT INTO `album_musik` VALUES ('5', 'Now You See Inside', '2004', 'SR-71', 'fotoAlbum/NowYouSeeInside.jpg');

-- ----------------------------
-- Table structure for `musisi`
-- ----------------------------
DROP TABLE IF EXISTS `musisi`;
CREATE TABLE `musisi` (
  `id_musisi` int(11) NOT NULL AUTO_INCREMENT,
  `nama_musisi` varchar(25) NOT NULL,
  `lagu_populer` varchar(25) NOT NULL,
  `path` varchar(255) DEFAULT '',
  PRIMARY KEY (`id_musisi`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of musisi
-- ----------------------------
INSERT INTO `musisi` VALUES ('1', 'Pierce The Veil', 'King for a day', 'fotoMusisi/Pierce The Veil.jpg');
INSERT INTO `musisi` VALUES ('2', 'SR-71', 'Right Now', 'fotoMusisi/sr-71.jpg');
INSERT INTO `musisi` VALUES ('15', 'Green Day', 'Saint jimmy', 'fotoMusisi/default.jpg');
