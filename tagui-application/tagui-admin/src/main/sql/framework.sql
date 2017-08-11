/*
Navicat MySQL Data Transfer

Source Server         : framework
Source Server Version : 50148
Source Host           : qdm172049381.my3w.com:3306
Source Database       : qdm172049381_db

Target Server Type    : MYSQL
Target Server Version : 50148
File Encoding         : 65001

Date: 2017-08-02 16:55:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for core_companyinfo
-- ----------------------------
DROP TABLE IF EXISTS `core_companyinfo`;
CREATE TABLE `core_companyinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `companyname` varchar(100) DEFAULT NULL COMMENT '物业名称',
  `companyaddress` varchar(254) DEFAULT NULL COMMENT '物业地址',
  `state` varchar(4) NOT NULL DEFAULT '1' COMMENT '0 停用 1 启用',
  `createTime` varchar(24) DEFAULT NULL,
  `updateTime` varchar(24) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='物业公司信息';

-- ----------------------------
-- Records of core_companyinfo
-- ----------------------------
INSERT INTO `core_companyinfo` VALUES ('1', '海市优选停车责任有限公司', '上海市漕河泾虹漕路461号', '1', '2016-03-11 12:12:12', null);
INSERT INTO `core_companyinfo` VALUES ('2', '上海第十人民医院物业管理有限公司', '上海市延长中路301号', '1', '2016-03-11 12:12:12', null);
INSERT INTO `core_companyinfo` VALUES ('3', '南京辉通电子科技有限公司', '南京市六合区北大街83号402室', '1', '2016-05-18 13:36:00 ', null);

-- ----------------------------
-- Table structure for core_merchantcompanyinfo
-- ----------------------------
DROP TABLE IF EXISTS `core_merchantcompanyinfo`;
CREATE TABLE `core_merchantcompanyinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `merchantcompanyname` varchar(40) DEFAULT NULL COMMENT '商户名称',
  `state` varchar(4) NOT NULL DEFAULT '1',
  `createtime` varchar(24) DEFAULT NULL,
  `updatetime` varchar(24) DEFAULT NULL,
  `createpersonid` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='商户所属公司列表';

-- ----------------------------
-- Records of core_merchantcompanyinfo
-- ----------------------------
INSERT INTO `core_merchantcompanyinfo` VALUES ('1', 'xxxxx', '1', null, null, null);
INSERT INTO `core_merchantcompanyinfo` VALUES ('2', '上海百盛管理有限公司', '1', '2016-03-31 13:46:10', '2016-31-03 13:47:28', 'admin');

-- ----------------------------
-- Table structure for core_merchantinfo
-- ----------------------------
DROP TABLE IF EXISTS `core_merchantinfo`;
CREATE TABLE `core_merchantinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `merchantcompanyid` varchar(20) NOT NULL COMMENT '商户公司id',
  `merchantname` varchar(80) NOT NULL COMMENT '商户名称',
  `state` varchar(4) NOT NULL DEFAULT '1' COMMENT '状态 0不显示 1显示',
  `createtime` varchar(24) DEFAULT NULL,
  `updatetime` varchar(24) DEFAULT NULL,
  `createpersonid` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='商户信息';

-- ----------------------------
-- Records of core_merchantinfo
-- ----------------------------
INSERT INTO `core_merchantinfo` VALUES ('1', '2', '松江万达肯德基', '1', '2016-03-31 13:47:52', '2016-03-31 13:58:20', 'admin');

-- ----------------------------
-- Table structure for core_parkdic
-- ----------------------------
DROP TABLE IF EXISTS `core_parkdic`;
CREATE TABLE `core_parkdic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parkcode` varchar(100) DEFAULT NULL,
  `parkname` varchar(100) DEFAULT NULL COMMENT '停车场名称',
  `parkaddress` varchar(100) DEFAULT NULL COMMENT '停车场地址',
  `parkplateaccount` varchar(8) DEFAULT NULL COMMENT '车位数',
  `inparkplateaccount` varchar(8) DEFAULT NULL COMMENT '室内总车位数',
  `outparkplateaccount` varchar(8) DEFAULT NULL COMMENT '室外车位总数',
  `monthrentplateaccount` varchar(8) DEFAULT NULL COMMENT '月租车位总数',
  `sparkplateaccount` varchar(8) DEFAULT NULL COMMENT '总剩余车位数',
  `sinparkplateaccount` varchar(8) DEFAULT NULL COMMENT '室内剩余车位总数',
  `soutparkplateaccount` varchar(8) DEFAULT NULL COMMENT '室外剩余车位总数',
  `smonthrentplateaccount` varchar(8) DEFAULT NULL COMMENT '月租剩余总数',
  `parktype` varchar(4) DEFAULT NULL COMMENT '停车场类型 0室内停车场\n  1 室外停车场 2混合停车场',
  `monthrent` varchar(4) DEFAULT NULL COMMENT '月租 1支持月租 0不支持月租',
  `nightrent` varchar(4) DEFAULT NULL COMMENT '夜租 0不支持夜租  1支持夜租  ',
  `city` varchar(100) DEFAULT NULL COMMENT '城市',
  `lon` varchar(30) DEFAULT NULL COMMENT '经度',
  `lat` varchar(30) DEFAULT NULL COMMENT '纬度',
  `bttcjg` varchar(200) DEFAULT NULL COMMENT '白天停车价格',
  `wstcjg` varchar(200) DEFAULT NULL COMMENT '晚上停车价格',
  `fromtype` varchar(4) DEFAULT NULL COMMENT '信息来源 0优选停车 1蓝卡 2辉通 3网络',
  `state` varchar(4) NOT NULL DEFAULT '1',
  `createtime` varchar(24) DEFAULT NULL,
  `updatetime` varchar(24) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=189 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of core_parkdic
-- ----------------------------
INSERT INTO `core_parkdic` VALUES ('1', 'yxtc', '优选停车测试停车场', '上海市漕河泾虹漕路461号', '1000', null, null, null, null, null, null, null, null, null, null, '上海市', '121.4136960000', '31.1844520000', null, null, null, '1', '2016-4-13 13:23:00', null);
INSERT INTO `core_parkdic` VALUES ('2', 'dsrmyy', '第十人民医院', '上海市延长中路301号', '1000', null, null, null, null, null, null, null, '1', null, null, '上海市', '121.4606', '31.277436', '8元/小时', '8元/小时', null, '1', '2016-4-13 13:23:00', null);
INSERT INTO `core_parkdic` VALUES ('3', 'huitongcarparkcode', '曹杨经贸大厦', '上海普陀区怒江北路399号', '500', '20', '10', '1', '26', '20', '10', '5', '2', null, null, '310100', '121.396979', '31.241473', '10元/小时', '10元/小时', '', '1', '2016-4-13 13:23:00', '2016-06-28 19:09:33');
INSERT INTO `core_parkdic` VALUES ('14', 'b4xfbtgs', '四川北路公园', '四川北路1468号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.490934', '31.259907', null, null, null, '1', '2016-07-26 13:26:00', null);
INSERT INTO `core_parkdic` VALUES ('15', 've0o66b9', '上海华翼恒翔物业管理有限公司', '金丰路170号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.663468', '31.241411', null, null, null, '1', '2016-07-26 13:27:25', null);
INSERT INTO `core_parkdic` VALUES ('16', 'hn11z5wb', 'id657创意产业园', '广中路657号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.468867', '31.286166', null, null, null, '1', '2016-07-26 13:27:28', null);
INSERT INTO `core_parkdic` VALUES ('17', 'y3bcxeb6', '李子园商务园区', '交通路4703弄', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.396484', '31.273332', null, null, null, '1', '2016-07-26 13:27:30', null);
INSERT INTO `core_parkdic` VALUES ('18', 'yl4qse34', '中茂世纪广场', '汇源路208号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.21092', '31.423049', null, null, null, '1', '2016-07-26 13:27:32', null);
INSERT INTO `core_parkdic` VALUES ('19', '1381omcu', '海鸥商务大厦', '中山北二路1800号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.500915', '31.291755', null, null, null, '1', '2016-07-26 13:27:35', null);
INSERT INTO `core_parkdic` VALUES ('20', '6nnnvg5p', '通华大厦', '四平路1230号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.511361', '31.284385', null, null, null, '1', '2016-07-26 13:27:37', null);
INSERT INTO `core_parkdic` VALUES ('21', '97i8rvqf', '同济大学沪西校区', '真南路500号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.39744', '31.274751', null, null, null, '1', '2016-07-26 13:27:39', null);
INSERT INTO `core_parkdic` VALUES ('22', 'p4yavl7m', '红星美凯龙真北路店', '真北路1108号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.392685', '31.246306', null, null, null, '1', '2016-07-26 13:27:42', null);
INSERT INTO `core_parkdic` VALUES ('23', '3br19h8w', '中天新世纪商务大厦', '怒江北路302弄', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.398295', '31.242097', null, null, null, '1', '2016-07-26 13:27:44', null);
INSERT INTO `core_parkdic` VALUES ('24', 'l1j46hgu', '福德大厦', '四川北路1688号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.489834', '31.264003', null, null, null, '1', '2016-07-26 13:27:46', null);
INSERT INTO `core_parkdic` VALUES ('25', '38mz1hx8', '华虹大厦', '塘沽路463号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.492901', '31.253899', null, null, null, '1', '2016-07-26 13:27:52', null);
INSERT INTO `core_parkdic` VALUES ('26', 'jsujj6gk', '虹口足球场', '东江湾路444号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.488202', '31.277748', null, null, null, '1', '2016-07-26 13:27:54', null);
INSERT INTO `core_parkdic` VALUES ('27', 'urlkcjmh', '中山soho广场', '中山西路1065号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.421823', '31.20492', null, null, null, '1', '2016-07-26 13:27:56', null);
INSERT INTO `core_parkdic` VALUES ('28', 'mgsogu1l', '滨江大厦', '张杨路88号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.516799', '31.230081', null, null, null, '1', '2016-07-26 13:27:58', null);
INSERT INTO `core_parkdic` VALUES ('29', 'rz4sul5t', '良友大厦', '商城路618号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.524445', '31.236029', null, null, null, '1', '2016-07-26 13:28:00', null);
INSERT INTO `core_parkdic` VALUES ('30', '0qaal3op', '三鑫世界商厦', '张杨路579号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.524823', '31.233984', null, null, null, '1', '2016-07-26 13:28:02', null);
INSERT INTO `core_parkdic` VALUES ('31', 'lpab2xop', '华隆大厦', '南苏州路333号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.490568', '31.24786', null, null, null, '1', '2016-07-26 13:28:04', null);
INSERT INTO `core_parkdic` VALUES ('32', 'gvw9teyb', '汇通大厦', '金陵东路569号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.48753', '31.232877', null, null, null, '1', '2016-07-26 13:28:06', null);
INSERT INTO `core_parkdic` VALUES ('33', 'kf6vo2m6', '景醇大酒店', '颥兴路185号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.487636', '31.264378', null, null, null, '1', '2016-07-26 13:28:08', null);
INSERT INTO `core_parkdic` VALUES ('34', '5agd402x', '古华医院', '南桥镇南奉公路9220号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.474186', '30.91943', null, null, null, '1', '2016-07-26 13:28:10', null);
INSERT INTO `core_parkdic` VALUES ('35', 'mrhu3rre', '新湖明珠城', '东新路88弄新湖明珠城北区', null, null, null, null, null, null, null, null, '2', null, null, '310100', '101.712664', '36.686368', null, null, null, '1', '2016-07-26 13:28:13', null);
INSERT INTO `core_parkdic` VALUES ('36', 'd361ah3h', '创邑金沙谷', '真北路988号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.389781', '31.241425', null, null, null, '1', '2016-07-26 13:28:15', null);
INSERT INTO `core_parkdic` VALUES ('37', '3ntz0ujq', '同济大学附属天佑医院', '真南路528号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.397029', '31.27478', null, null, null, '1', '2016-07-26 13:28:17', null);
INSERT INTO `core_parkdic` VALUES ('38', 'o6w5l6h5', '上海恒阜停车场管理有限公司', '亭枫公路8328号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.033868', '30.886475', null, null, null, '1', '2016-07-26 13:28:19', null);
INSERT INTO `core_parkdic` VALUES ('39', '5gdqokki', '紫竹国际大厦', '芳甸路1088号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.568278', '31.218296', null, null, null, '1', '2016-07-26 13:28:22', null);
INSERT INTO `core_parkdic` VALUES ('40', '9yoxe3ax', '思源大厦', '西藏中路500号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.480749', '31.242025', null, null, null, '1', '2016-07-26 13:28:24', null);
INSERT INTO `core_parkdic` VALUES ('41', 'vewp1ipx', '新金桥广场', '北京西路1号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.479854', '31.243381', null, null, null, '1', '2016-07-26 13:28:26', null);
INSERT INTO `core_parkdic` VALUES ('42', 'yzjjync6', '申鑫大厦', '宁海东路200号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.48824', '31.234865', null, null, null, '1', '2016-07-26 13:28:29', null);
INSERT INTO `core_parkdic` VALUES ('43', 't31inho6', '星河世纪广场', '真北路2500号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.399773', '31.265886', null, null, null, '1', '2016-07-26 13:28:31', null);
INSERT INTO `core_parkdic` VALUES ('44', 'yue17ooh', '富都滨江大道', '陆家嘴2967号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.522908', '31.2146', null, null, null, '1', '2016-07-26 13:28:32', null);
INSERT INTO `core_parkdic` VALUES ('45', 'a9kfhzkx', '上海精英物业管理有限公司', '金皖路389号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.625928', '31.261326', null, null, null, '1', '2016-07-26 13:28:35', null);
INSERT INTO `core_parkdic` VALUES ('46', '9uv9tflg', '中港汇大厦', '长寿路868号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.436885', '31.241736', null, null, null, '1', '2016-07-26 13:28:37', null);
INSERT INTO `core_parkdic` VALUES ('47', '1ek1zbg9', '东方艺术中心', '丁香路425号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.548333', '31.228557', null, null, null, '1', '2016-07-26 13:28:40', null);
INSERT INTO `core_parkdic` VALUES ('48', 'q75fk88u', '东方金融广场', '世纪大道1168号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.529142', '31.235496', null, null, null, '1', '2016-07-26 13:28:44', null);
INSERT INTO `core_parkdic` VALUES ('49', '0e85j6l7', '东辰大厦', '牡丹路60号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.550772', '31.21195', null, null, null, '1', '2016-07-26 13:28:46', null);
INSERT INTO `core_parkdic` VALUES ('50', 'nsj19qub', '芳草路培花服务中心', '芳草路231号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.562023', '31.199605', null, null, null, '1', '2016-07-26 13:28:48', null);
INSERT INTO `core_parkdic` VALUES ('51', 'w8ht6xef', '东方国际科技大厦', '向城路58号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.536598', '31.229886', null, null, null, '1', '2016-07-26 13:28:50', null);
INSERT INTO `core_parkdic` VALUES ('52', 'xezanf64', '旺角广场', '延安东路175号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.491325', '31.236531', null, null, null, '1', '2016-07-26 13:28:52', null);
INSERT INTO `core_parkdic` VALUES ('53', '86xrb9i9', '锦江国际购物中心', '淮海中路527号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.47517', '31.22657', null, null, null, '1', '2016-07-26 13:28:54', null);
INSERT INTO `core_parkdic` VALUES ('54', '94b65v3h', '豫园万丽大酒店', '河南南路159号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.494579', '31.233214', null, null, null, '1', '2016-07-26 13:28:57', null);
INSERT INTO `core_parkdic` VALUES ('55', 'afgf59yz', '宝鼎大厦', '徐家汇路550号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.476918', '31.212034', null, null, null, '1', '2016-07-26 13:28:59', null);
INSERT INTO `core_parkdic` VALUES ('56', 'n52jlkk5', '中福酒店公寓', '浙江中路283号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.48524', '31.240185', null, null, null, '1', '2016-07-26 13:29:01', null);
INSERT INTO `core_parkdic` VALUES ('57', 'u1hxpduo', '曹杨经贸大厦', '怒江北路427号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.395775', '31.241298', null, null, null, '1', '2016-07-26 13:29:04', null);
INSERT INTO `core_parkdic` VALUES ('58', 'fa2i1k6s', '世博洲际酒店', '雪野路1188号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.511841', '31.204883', null, null, null, '1', '2016-07-26 13:29:07', null);
INSERT INTO `core_parkdic` VALUES ('59', '9q8nien2', '华夏银行大厦', '浦东南路256号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.5156', '31.245569', null, null, null, '1', '2016-07-26 13:29:10', null);
INSERT INTO `core_parkdic` VALUES ('60', 'k98hl8nv', '上海世纪公园', '芳甸路666号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.566244', '31.227239', null, null, null, '1', '2016-07-26 13:29:14', null);
INSERT INTO `core_parkdic` VALUES ('61', 'z7r5kwne', '齐来工业园', '宜山路889号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.410997', '31.177691', null, null, null, '1', '2016-07-26 13:29:16', null);
INSERT INTO `core_parkdic` VALUES ('62', 'wxpfdxy0', '虹钦园', '虹漕路461号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.413716', '31.184463', null, null, null, '1', '2016-07-26 13:29:18', null);
INSERT INTO `core_parkdic` VALUES ('63', 'ukvo6hwy', '虹漕园', '虹漕路421号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.415019', '31.183057', null, null, null, '1', '2016-07-26 13:29:20', null);
INSERT INTO `core_parkdic` VALUES ('64', 'n54j0mo1', '桂箐园', '桂箐路69号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.411416', '31.180449', null, null, null, '1', '2016-07-26 13:29:21', null);
INSERT INTO `core_parkdic` VALUES ('65', 'r8bazbkr', '桂平园', '桂平路555号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.409345', '31.176391', null, null, null, '1', '2016-07-26 13:29:24', null);
INSERT INTO `core_parkdic` VALUES ('66', '6y4po7xz', '桂果园', '桂平路471号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.410341', '31.172949', null, null, null, '1', '2016-07-26 13:29:26', null);
INSERT INTO `core_parkdic` VALUES ('67', 'kppoj4gp', '创业园', '桂平路680号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.408985', '31.178504', null, null, null, '1', '2016-07-26 13:29:27', null);
INSERT INTO `core_parkdic` VALUES ('68', '2nfd9qsc', '凯特利广场地下', '公园路458号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.123826', '31.154462', null, null, null, '1', '2016-07-26 13:29:29', null);
INSERT INTO `core_parkdic` VALUES ('69', '3eo6hdib', '上海双季花卉园艺市场', '浦建路620号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.536386', '31.213517', null, null, null, '1', '2016-07-26 13:29:31', null);
INSERT INTO `core_parkdic` VALUES ('70', 'uq42cb44', '象屿集团大厦', '西藏中路725弄28号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.478155', '31.245043', null, null, null, '1', '2016-07-26 13:29:33', null);
INSERT INTO `core_parkdic` VALUES ('71', '6p4jsgj3', '大盈综合楼', '南京西路456号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.474901', '31.237156', null, null, null, '1', '2016-07-26 13:29:36', null);
INSERT INTO `core_parkdic` VALUES ('72', 'ydhrbos9', '国际饭店', '南京西路170号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.478157', '31.239514', null, null, null, '1', '2016-07-26 13:29:39', null);
INSERT INTO `core_parkdic` VALUES ('73', 'pjit1dnh', '陈云纪念馆', '朱枫公路3501号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.051655', '31.013441', null, null, null, '1', '2016-07-26 13:29:41', null);
INSERT INTO `core_parkdic` VALUES ('74', 'h0bqqd7r', '金山嘴渔村', '山阳镇沪杭公路', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.362906', '30.766975', null, null, null, '1', '2016-07-26 13:29:43', null);
INSERT INTO `core_parkdic` VALUES ('75', 'bgfdopyi', '金梦坊', '徐德路85号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.274858', '31.198447', null, null, null, '1', '2016-07-26 13:29:45', null);
INSERT INTO `core_parkdic` VALUES ('76', 'hmkl3qs9', '创意阁', '冠生园路231号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.433389', '31.169078', null, null, null, '1', '2016-07-26 13:29:47', null);
INSERT INTO `core_parkdic` VALUES ('77', 'pq3uwzhn', '上海报闻经贸有限公司', '大统路1098号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.465669', '31.263824', null, null, null, '1', '2016-07-26 13:29:49', null);
INSERT INTO `core_parkdic` VALUES ('78', 'ri82ot4m', '上海敏大帮帮车辆停放管理有限公司', '大渡河路160号对面', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.404123', '31.224623', null, null, null, '1', '2016-07-26 13:29:51', null);
INSERT INTO `core_parkdic` VALUES ('79', '7kj7lnoo', '山海大厦', '浦东大道1482号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.542924', '31.248734', null, null, null, '1', '2016-07-26 13:29:53', null);
INSERT INTO `core_parkdic` VALUES ('80', 'wtsobgv6', '由由国际广场', '浦建路76号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.525998', '31.214641', null, null, null, '1', '2016-07-26 13:29:55', null);
INSERT INTO `core_parkdic` VALUES ('81', 'ch9wj1fl', '东方城市花园二期', '东方路1881弄', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.53101', '31.199154', null, null, null, '1', '2016-07-26 13:29:57', null);
INSERT INTO `core_parkdic` VALUES ('82', 'rzidj8qy', '上海悦华大酒店', '南桥镇江海路88号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.465114', '30.910587', null, null, null, '1', '2016-07-26 13:29:59', null);
INSERT INTO `core_parkdic` VALUES ('83', 'pumzmi35', '海鸥饭店', '黄浦路60号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.498229', '31.249377', null, null, null, '1', '2016-07-26 13:30:00', null);
INSERT INTO `core_parkdic` VALUES ('84', 'baaf8wgx', '岚桥国际大厦', '世纪大道1128号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.528119', '31.236339', null, null, null, '1', '2016-07-26 13:30:02', null);
INSERT INTO `core_parkdic` VALUES ('85', 'afgftdco', '金外滩宾馆', '广东路525号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.488092', '31.237808', null, null, null, '1', '2016-07-26 13:30:04', null);
INSERT INTO `core_parkdic` VALUES ('86', '8udf1zq1', '金田大厦', '陆家浜路1295号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.490775', '31.217576', null, null, null, '1', '2016-07-26 13:30:06', null);
INSERT INTO `core_parkdic` VALUES ('87', 'h6t4uc7c', '徐泾农贸市场', '徐泾镇明珠路258号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.277231', '31.175291', null, null, null, '1', '2016-07-26 13:30:09', null);
INSERT INTO `core_parkdic` VALUES ('88', '6k36ktsn', '新发展亚太JW万豪酒店', '大渡河路158号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.402789', '31.227254', null, null, null, '1', '2016-07-26 13:30:11', null);
INSERT INTO `core_parkdic` VALUES ('89', '4p3ayli0', '甘泉德必易园', '交通路2447号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.432182', '31.265478', null, null, null, '1', '2016-07-26 13:30:14', null);
INSERT INTO `core_parkdic` VALUES ('90', 'apsyqzcs', '永融企业中心', '四平路257号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.496125', '31.267604', null, null, null, '1', '2016-07-26 13:30:15', null);
INSERT INTO `core_parkdic` VALUES ('91', '2ytjktyz', '春申创意园', '梅富路228号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.425845', '31.114626', null, null, null, '1', '2016-07-26 13:30:18', null);
INSERT INTO `core_parkdic` VALUES ('92', 'r4wreeun', '峰汇嘉苑', '天祝路555弄', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.265712', '31.349611', null, null, null, '1', '2016-07-26 13:30:21', null);
INSERT INTO `core_parkdic` VALUES ('93', 'ae8gzj8l', '南郊聚润广场', '南桥镇德丰路299弄', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.492811', '30.931481', null, null, null, '1', '2016-07-26 13:30:21', null);
INSERT INTO `core_parkdic` VALUES ('94', '8lb4b4g1', '上海众市实业有限公司（天津路）', '天津路297号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.487298', '31.24308', null, null, null, '1', '2016-07-26 13:30:24', null);
INSERT INTO `core_parkdic` VALUES ('95', 'lut0p9u8', '奉贤体育中心', '南桥镇古华路100号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.474827', '30.91097', null, null, null, '1', '2016-07-26 13:30:25', null);
INSERT INTO `core_parkdic` VALUES ('96', 'y58izscy', '上海久创科技园', '瓶安路1358号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.407105', '31.058112', null, null, null, '1', '2016-07-26 13:30:27', null);
INSERT INTO `core_parkdic` VALUES ('97', '91pq9kgs', '皋城菜场', '仓场路331号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.280108', '31.388773', null, null, null, '1', '2016-07-26 13:30:29', null);
INSERT INTO `core_parkdic` VALUES ('98', '3ecs1jaa', '上海岚灵花鸟市场', '灵石路1539号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.429412', '31.27432', null, null, null, '1', '2016-07-26 13:30:30', null);
INSERT INTO `core_parkdic` VALUES ('99', 'kkft50fl', '张慕工业基地', '春申路2328号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.424591', '31.119575', null, null, null, '1', '2016-07-26 13:30:31', null);
INSERT INTO `core_parkdic` VALUES ('100', 'kz7gsd15', '虹顺商业广场', '天山西路4086号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.31759', '31.221689', null, null, null, '1', '2016-07-26 13:30:33', null);
INSERT INTO `core_parkdic` VALUES ('101', '7unybwkl', '思南公馆', '重庆南路258号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.476694', '31.21999', null, null, null, '1', '2016-07-26 13:30:36', null);
INSERT INTO `core_parkdic` VALUES ('102', 'fllcftns', '复兴SOHO广场', '马当路388号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.481719', '31.220626', null, null, null, '1', '2016-07-26 13:30:39', null);
INSERT INTO `core_parkdic` VALUES ('103', 'zbbxe3ch', '虹口soho广场', '武进路190号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.493569', '31.258705', null, null, null, '1', '2016-07-26 13:30:41', null);
INSERT INTO `core_parkdic` VALUES ('104', 'm5k1hubf', '上海汇银金融商务中心', '云岭东路599弄', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.3887', '31.226632', null, null, null, '1', '2016-07-26 13:30:43', null);
INSERT INTO `core_parkdic` VALUES ('105', 'tgmonejp', '绿天商城', '百兴路8号11633室', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.494531', '30.920972', null, null, null, '1', '2016-07-26 13:30:45', null);
INSERT INTO `core_parkdic` VALUES ('106', 'ee5znz7w', '新天国际大厦', '福山路450号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.537633', '31.230056', null, null, null, '1', '2016-07-26 13:30:47', null);
INSERT INTO `core_parkdic` VALUES ('107', 'orxmp899', '天山衡辰公寓', '天山路388弄1号地下二层', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.394001', '31.220956', null, null, null, '1', '2016-07-26 13:30:49', null);
INSERT INTO `core_parkdic` VALUES ('108', 'jtdipr49', '船研大厦', '民生路600号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.54902', '31.245027', null, null, null, '1', '2016-07-26 13:30:51', null);
INSERT INTO `core_parkdic` VALUES ('109', 'uug7owgj', '嘉瑞酒店', '潍坊路328号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.541953', '31.234568', null, null, null, '1', '2016-07-26 13:30:54', null);
INSERT INTO `core_parkdic` VALUES ('110', 'but5kluj', '华辰大厦', '浦东大道958号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.538049', '31.247293', null, null, null, '1', '2016-07-26 13:30:56', null);
INSERT INTO `core_parkdic` VALUES ('111', 'yqvf0uvb', '上海T71园区', '秦桥路71号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.633594', '31.276175', null, null, null, '1', '2016-07-26 13:30:58', null);
INSERT INTO `core_parkdic` VALUES ('112', 'xw3fb6qu', '嘉实生活广场', '嘉松北路6130弄', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.228252', '31.294756', null, null, null, '1', '2016-07-26 13:31:01', null);
INSERT INTO `core_parkdic` VALUES ('113', 'ejglv0yh', '嘉定体育中心', '新成路118号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.277313', '31.382153', null, null, null, '1', '2016-07-26 13:31:03', null);
INSERT INTO `core_parkdic` VALUES ('114', 'qfq10q9i', '昂立大厦', '广富林路697弄', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.2082', '31.066368', null, null, null, '1', '2016-07-26 13:31:05', null);
INSERT INTO `core_parkdic` VALUES ('115', 'vzhweqze', '富绅国际大厦', '公园东路1590-1650号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.142638', '31.159861', null, null, null, '1', '2016-07-26 13:31:07', null);
INSERT INTO `core_parkdic` VALUES ('116', 'tdq2r1h4', '桥梓湾购物中心', '沅河路271号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.118493', '31.155095', null, null, null, '1', '2016-07-26 13:31:09', null);
INSERT INTO `core_parkdic` VALUES ('117', 'k5wo1ho5', '上海御豪置业有限公司（2535号）', '虹桥路2535号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.361261', '31.19661', null, null, null, '1', '2016-07-26 13:31:12', null);
INSERT INTO `core_parkdic` VALUES ('118', 'ngzi46dz', '嘉鸿大厦', '广富林路699号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.266184', '31.059981', null, null, null, '1', '2016-07-26 13:31:14', null);
INSERT INTO `core_parkdic` VALUES ('119', '00mxos61', '沪宁停车场', '江桥镇华江路230弄80号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.341483', '31.258376', null, null, null, '1', '2016-07-26 13:31:16', null);
INSERT INTO `core_parkdic` VALUES ('120', '0ud607qw', '威隆大厦', '曹安路1718号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.370948', '31.259995', null, null, null, '1', '2016-07-26 13:31:18', null);
INSERT INTO `core_parkdic` VALUES ('121', 'ihb8gvan', '新虹桥中心花园', '延安西路2238号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.410192', '31.207322', null, null, null, '1', '2016-07-26 13:31:20', null);
INSERT INTO `core_parkdic` VALUES ('122', 'sqfnw5oz', '申康宾馆', '虹桥路1440号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.409161', '31.204641', null, null, null, '1', '2016-07-26 13:31:22', null);
INSERT INTO `core_parkdic` VALUES ('123', 'gbp3o6pi', '祥腾财富广场', '共和新路3088弄', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.453113', '31.299857', null, null, null, '1', '2016-07-26 13:31:25', null);
INSERT INTO `core_parkdic` VALUES ('124', '2h3lj66z', '嘉禾大厦', '叶城路818号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.258419', '31.371332', null, null, null, '1', '2016-07-26 13:31:27', null);
INSERT INTO `core_parkdic` VALUES ('125', '2ox40ksh', '宝燕集团', '春申路3333号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.402441', '31.109649', null, null, null, '1', '2016-07-26 13:31:29', null);
INSERT INTO `core_parkdic` VALUES ('126', 'ecnarx86', '上海外高桥保宏大酒店有限公司（上海外高桥皇冠假日酒店）', '杨高北路1000号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.596868', '31.345387', null, null, null, '1', '2016-07-26 13:31:31', null);
INSERT INTO `core_parkdic` VALUES ('127', 'x3w5kmmx', '上海周浦停车场（周康路）', '周康路21号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.577447', '31.122065', null, null, null, '1', '2016-07-26 13:31:33', null);
INSERT INTO `core_parkdic` VALUES ('128', 'vf7fy2nb', '上海周杨物业管理有限公司（百顺路）', '南桥镇百顺路201号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.489311', '30.918121', null, null, null, '1', '2016-07-26 13:31:36', null);
INSERT INTO `core_parkdic` VALUES ('129', 'bwi4nqo5', '上海申奉道路清障施救服务有限公司', '沪杭公路2142号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.446279', '30.914352', null, null, null, '1', '2016-07-26 13:31:38', null);
INSERT INTO `core_parkdic` VALUES ('130', 'dv2tl3nq', '上海星峡置业有限公司（上海海洋大厦）', '延安东路550号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.488128', '31.23672', null, null, null, '1', '2016-07-26 13:31:40', null);
INSERT INTO `core_parkdic` VALUES ('131', 'o3v9s30x', '上海先达房地产发展有限公司（我格广场B2.B3A车库）', '武宁路99号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.429479', '31.244393', null, null, null, '1', '2016-07-26 13:31:42', null);
INSERT INTO `core_parkdic` VALUES ('132', 'oj3g9iwi', '上海南利置业有限公司（璞邸精品酒店）', '雁荡路99号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.476376', '31.225237', null, null, null, '1', '2016-07-26 13:31:44', null);
INSERT INTO `core_parkdic` VALUES ('133', '0en8d0gq', '上海卡菱电子科技有限公司（美罗大厦）', '天钥桥路30号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.44697', '31.199522', null, null, null, '1', '2016-07-26 13:31:46', null);
INSERT INTO `core_parkdic` VALUES ('134', 'ul57gmba', '上海继杰实业有限公司（虹桥车酷）', '天山西路4358弄53号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.313111', '31.215002', null, null, null, '1', '2016-07-26 13:31:47', null);
INSERT INTO `core_parkdic` VALUES ('135', 'hqlx3qps', '上海富都物业管理有限公司（海富花园）', '东方路1365号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.535936', '31.217646', null, null, null, '1', '2016-07-26 13:31:49', null);
INSERT INTO `core_parkdic` VALUES ('136', 'ywqhkbqc', '上海中茂房地产开发有限公司（中茂世纪广场）', '汇源路208号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.21092', '31.423049', null, null, null, '1', '2016-07-26 13:31:52', null);
INSERT INTO `core_parkdic` VALUES ('137', '7ab8sl4x', '上海灏芯电子科技有限公司', '西环路777弄23号101室', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.370466', '31.119316', null, null, null, '1', '2016-07-26 13:31:56', null);
INSERT INTO `core_parkdic` VALUES ('138', 'a3k3qt6w', '上海奥林实业有限公司（嘉定体育中心（新馆））', '新成路138号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.276905', '31.383276', null, null, null, '1', '2016-07-26 13:31:59', null);
INSERT INTO `core_parkdic` VALUES ('139', '4m5ca866', '上海圣骊投资发展有限公司（圣骊虹桥创意园）', '虹桥路996弄161号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.42719', '31.201136', null, null, null, '1', '2016-07-26 13:32:02', null);
INSERT INTO `core_parkdic` VALUES ('140', '7dw9wfzl', '上海东湖宾馆', '东湖路70号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.460084', '31.222849', null, null, null, '1', '2016-07-26 13:32:04', null);
INSERT INTO `core_parkdic` VALUES ('141', '2a5cz7nx', '上海深南交通设施有限公司（悦达889）', '万航渡路889号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.435156', '31.235446', null, null, null, '1', '2016-07-26 13:32:06', null);
INSERT INTO `core_parkdic` VALUES ('142', '6sh20wlx', '上海嘉定商城有限公司', '清河路48号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.254649', '31.390262', null, null, null, '1', '2016-07-26 13:32:08', null);
INSERT INTO `core_parkdic` VALUES ('143', '6do7d6iz', '上海安帮成扬停车管理服务社(中环大厦)', '中山北路3856弄1~4号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.417992', '31.232836', null, null, null, '1', '2016-07-26 13:32:10', null);
INSERT INTO `core_parkdic` VALUES ('144', '4ehnjpvj', '泊斯停车管理咨询（上海）有限公司', '卫清西路477号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.35033', '30.735007', null, null, null, '1', '2016-07-26 13:32:12', null);
INSERT INTO `core_parkdic` VALUES ('145', '2sx3wlbv', '青浦鹤森广场', '诸陆西路852号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.265872', '31.180808', null, null, null, '1', '2016-07-26 13:32:15', null);
INSERT INTO `core_parkdic` VALUES ('146', '99y6n488', '上海新世纪大厦发展有限公司（新世纪大厦）', '陆家浜路1011号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.49538', '31.218099', null, null, null, '1', '2016-07-26 13:32:19', null);
INSERT INTO `core_parkdic` VALUES ('147', 'tehjx30k', '加恒（上海）置业有限公司（南翔太茂）', '南翔镇丰翔路3168号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.332083', '31.304943', null, null, null, '1', '2016-07-26 13:32:24', null);
INSERT INTO `core_parkdic` VALUES ('148', 'r6yz33b7', '上海梅华实业有限公司集心路分公司（梅美商务园区）', '集心路168号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.420176', '31.113264', null, null, null, '1', '2016-07-26 13:32:27', null);
INSERT INTO `core_parkdic` VALUES ('149', 'jz217wp8', '上海梅华实业有限公司罗阳路分公司（梅夏商务园区）', '罗阳路168号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.419455', '31.130909', null, null, null, '1', '2016-07-26 13:32:29', null);
INSERT INTO `core_parkdic` VALUES ('150', '8siwmjyr', '加恒（上海）置业有限公司（瑞林路）', '南翔镇瑞林路', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.326807', '31.300289', null, null, null, '1', '2016-07-26 13:32:31', null);
INSERT INTO `core_parkdic` VALUES ('151', 'iy4iuoec', '上海无线电电子研究所科技经营部（凯利大厦）', '淮海西路432号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.433406', '31.205412', null, null, null, '1', '2016-07-26 13:32:33', null);
INSERT INTO `core_parkdic` VALUES ('152', 'b3wto009', '上海嘉沙物业管理有限公司（嘉乐广场）', '仓场路365号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.278803', '31.388397', null, null, null, '1', '2016-07-26 13:32:35', null);
INSERT INTO `core_parkdic` VALUES ('153', '2v7xl02b', '上海曹安置业有限公司（福瑞大厦）', '曹安路1509号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.378068', '31.256681', null, null, null, '1', '2016-07-26 13:32:37', null);
INSERT INTO `core_parkdic` VALUES ('154', 'tr1lsuit', '泊斯停车管理咨询（上海）有限公司（乐购超市莘庄店）', '七莘路695号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.378613', '31.124642', null, null, null, '1', '2016-07-26 13:32:39', null);
INSERT INTO `core_parkdic` VALUES ('155', 'vj414vy1', '泊斯停车管理咨询（上海）有限公司（乐购超市锦绣店）', '锦绣路3218号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.547141', '31.18579', null, null, null, '1', '2016-07-26 13:32:41', null);
INSERT INTO `core_parkdic` VALUES ('156', 'yieh300w', '上海福辰物业管理有限公司（福城商城）', '宜川路310号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.44402', '31.268884', null, null, null, '1', '2016-07-26 13:32:44', null);
INSERT INTO `core_parkdic` VALUES ('157', '3ovnxkjz', '上海恒通云生置业有限公司', '塔新路999号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.290112', '31.398666', null, null, null, '1', '2016-07-26 13:32:46', null);
INSERT INTO `core_parkdic` VALUES ('158', 'ij3de11p', '上海嘉定汽车客运场站管理有限公司（嘉定客运中心）', '陈家山路1800号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.232476', '31.381708', null, null, null, '1', '2016-07-26 13:32:48', null);
INSERT INTO `core_parkdic` VALUES ('159', 'b464n5lm', '上海磊成物业管理有限公司（泰宸商务楼）', '博乐路158号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.258774', '31.390719', null, null, null, '1', '2016-07-26 13:32:52', null);
INSERT INTO `core_parkdic` VALUES ('160', 'hm5buatc', '上海嘉定欧亚美沪宜家具市场经营管理有限公司（欧亚美）', '沪宜公路3518号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.254021', '31.379304', null, null, null, '1', '2016-07-26 13:32:54', null);
INSERT INTO `core_parkdic` VALUES ('161', 'nbs0qpup', '上海磊成物业管理有限公司（泰宸汇金商务楼）', '金沙路75、77号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.391378', '31.237338', null, null, null, '1', '2016-07-26 13:32:56', null);
INSERT INTO `core_parkdic` VALUES ('162', 'ik65043f', '上海俱美物业管理有限公司（丽都广场）', '友谊路2758号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.441473', '31.391941', null, null, null, '1', '2016-07-26 13:32:58', null);
INSERT INTO `core_parkdic` VALUES ('163', 'y5qju0kb', '上海玖如物业管理有限公司', '定康路25号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.511443', '30.925933', null, null, null, '1', '2016-07-26 13:33:01', null);
INSERT INTO `core_parkdic` VALUES ('164', 'hunmkvyx', '上海永佳物业管理有限公司（奉贤中医医院）', '南奉公路5988号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.512668', '30.926254', null, null, null, '1', '2016-07-26 13:33:08', null);
INSERT INTO `core_parkdic` VALUES ('165', 'ehme2o95', '上海乾亨物业管理有限公司—奉贤分公司', '南奉公路6600号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.748164', '31.192395', null, null, null, '1', '2016-07-26 13:33:12', null);
INSERT INTO `core_parkdic` VALUES ('166', 'bcrtod67', '上海奉鼎停车场（奉城医院）', '南奉公路9983号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.748164', '31.192395', null, null, null, '1', '2016-07-26 13:33:15', null);
INSERT INTO `core_parkdic` VALUES ('167', '59j12gr5', '上海永达置业发展有限公司（永达国际大厦）', '龙阳路2277号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.569582', '31.211021', null, null, null, '1', '2016-07-26 13:33:17', null);
INSERT INTO `core_parkdic` VALUES ('168', 'w7u6ur8u', '上海浦东新区花木物业公司', '梅花路768弄', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.56001', '31.214966', null, null, null, '1', '2016-07-26 13:33:19', null);
INSERT INTO `core_parkdic` VALUES ('169', 'lviia1g4', '上港集团海湾分公司（港务大厦）', '丰和路1号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.50431', '31.246062', null, null, null, '1', '2016-07-26 13:33:21', null);
INSERT INTO `core_parkdic` VALUES ('170', 'jsuuqyt0', '上海森然商务咨询有限公司', '沪南路2591号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.57352', '31.154077', null, null, null, '1', '2016-07-26 13:33:25', null);
INSERT INTO `core_parkdic` VALUES ('171', 'gtoqqumw', '上海尤文交通设施有限公司（上南路）', '上南路3855号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.512599', '31.156341', null, null, null, '1', '2016-07-26 13:33:28', null);
INSERT INTO `core_parkdic` VALUES ('172', 'ls5hfquo', '上海尤文交通设施有限公司（康桥路787）', '康桥路787号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.555596', '31.151096', null, null, null, '1', '2016-07-26 13:33:30', null);
INSERT INTO `core_parkdic` VALUES ('173', 'aasvru9e', '深圳市城投物业管理有限公司上海分公司（嘉福汇商务广场）', '福海路777弄', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.24867', '31.370318', null, null, null, '1', '2016-07-26 13:33:32', null);
INSERT INTO `core_parkdic` VALUES ('174', 'oevdwiks', '上海致源置业有限公司（源达大厦）', '长寿路360号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.445722', '31.248458', null, null, null, '1', '2016-07-26 13:33:35', null);
INSERT INTO `core_parkdic` VALUES ('175', 'c1h6ys5w', '上海工宇物业管理有限公司（T15园区）', '宁桥路999号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.630528', '31.259194', null, null, null, '1', '2016-07-26 13:33:37', null);
INSERT INTO `core_parkdic` VALUES ('176', '0k2wne6b', '上海新金桥设施管理有限公司（红枫路）', '红枫路233号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.597561', '31.24921', null, null, null, '1', '2016-07-26 13:33:39', null);
INSERT INTO `core_parkdic` VALUES ('177', '8n5t8itf', '上海太湖世家物业管理有限公司嘉定分公司（太湖世家国际大厦）', '德富路1198号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.265183', '31.353342', null, null, null, '1', '2016-07-26 13:33:42', null);
INSERT INTO `core_parkdic` VALUES ('178', 'hod66rgb', '上海新金桥设施管理有限公司（T52）', '申江路3079号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.632002', '31.252973', null, null, null, '1', '2016-07-26 13:33:44', null);
INSERT INTO `core_parkdic` VALUES ('179', 'nwhutkjt', '上海证大歌腾投资管理有限公司（金桥大拇指广场）', '平度路258号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.598595', '31.261339', null, null, null, '1', '2016-07-26 13:33:46', null);
INSERT INTO `core_parkdic` VALUES ('180', 'sb7nr76t', '上海嘉莲华国际商业广场经营管理有限公司（嘉莲华国际商业广场）', '曹安路2188号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.350792', '31.266203', null, null, null, '1', '2016-07-26 13:33:48', null);
INSERT INTO `core_parkdic` VALUES ('181', 'unm8b9vg', '上海国际汽车城新安亭联合发展有限公司（汽车博览公园）', '博园路7575号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.174702', '31.286052', null, null, null, '1', '2016-07-26 13:33:50', null);
INSERT INTO `core_parkdic` VALUES ('182', 'mvvbb56w', '上海科技京城管理发展有限公司（科技京城）', '北京东路666号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.484571', '31.245298', null, null, null, '1', '2016-07-26 13:33:52', null);
INSERT INTO `core_parkdic` VALUES ('183', 'vp7ojybu', '上海新世纪房产服务有限公司（同盛大厦）', '福山路458号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.538071', '31.229274', null, null, null, '1', '2016-07-26 13:33:54', null);
INSERT INTO `core_parkdic` VALUES ('184', 'l3akeeub', '上海昌呈牧业有限公司', '周浦镇瓦屑镇北路1号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.581473', '31.120602', null, null, null, '1', '2016-07-26 13:33:56', null);
INSERT INTO `core_parkdic` VALUES ('185', 'f7isbec0', '上海久方旅馆有限公司', '长寿路522号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.443005', '31.246303', null, null, null, '1', '2016-07-26 13:33:59', null);
INSERT INTO `core_parkdic` VALUES ('186', 'rtclpy8g', '上海国信广场经营有限公司（国兴广场）', '建国中路29号', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.477464', '31.216164', null, null, null, '1', '2016-07-26 13:34:02', null);
INSERT INTO `core_parkdic` VALUES ('187', 'dypmxdob', '上海新国际博览中心', '上海浦东新区龙阳路2345', null, null, null, null, null, null, null, null, '2', null, null, '310100', '121.570184', '31.214427', null, null, null, '1', '2016-08-02 11:14:57', null);
INSERT INTO `core_parkdic` VALUES ('188', 'fuhuiguangchang', '冨荟广场', '上海市普通新区樱花路80弄', null, null, null, null, null, null, null, null, '2', null, null, '310100', null, null, null, null, null, '1', '2016-08-13 17:09:51', null);

-- ----------------------------
-- Table structure for core_parkinfo
-- ----------------------------
DROP TABLE IF EXISTS `core_parkinfo`;
CREATE TABLE `core_parkinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `companyid` int(11) DEFAULT NULL COMMENT '物业id',
  `parkname` varchar(100) DEFAULT NULL COMMENT '停车场名称',
  `parkaddress` varchar(400) DEFAULT NULL,
  `platenum` varchar(8) DEFAULT NULL COMMENT '停车位数',
  `feeinfo` varchar(400) DEFAULT NULL COMMENT '收费介绍',
  `parkdicid` int(11) DEFAULT NULL COMMENT '字典字段',
  `text` varchar(400) DEFAULT NULL COMMENT '停车场描述',
  `outparktime` varchar(20) DEFAULT NULL COMMENT '停车场支付后出场时间',
  `state` varchar(4) NOT NULL DEFAULT '1' COMMENT '状态 0 停用 1启用',
  `createtime` varchar(24) DEFAULT NULL,
  `updatetime` varchar(24) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=181 DEFAULT CHARSET=utf8 COMMENT='停车场信息';

-- ----------------------------
-- Records of core_parkinfo
-- ----------------------------
INSERT INTO `core_parkinfo` VALUES ('1', '2', '第十人民医院', '上海市延长中路301号', '120', '4', '2', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-03-11 12:12:12', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('2', '1', '辉通测试停车场', '上海市漕河泾虹漕路461号', '120', '4', '1', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-05-11 12:12:12', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('3', '1', '曹杨经贸大厦', '上海普陀区怒江北路399号', '120', '4', '3', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-05-18 12:12:12', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('6', '2', '四川北路公园', '四川北路1468号', '175', '', '14', '', '15', '1', '2016-07-26 13:26:00', '2016-08-22 12:23:23');
INSERT INTO `core_parkinfo` VALUES ('7', '2', '上海华翼恒翔物业管理有限公司', '金丰路170号', '120', '4', '15', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:27:26', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('8', '2', 'id657创意产业园', '广中路657号', '120', '4', '16', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:27:28', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('9', '2', '李子园商务园区', '交通路4703弄', '74', '4', '17', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:27:30', '2016-08-22 12:23:24');
INSERT INTO `core_parkinfo` VALUES ('10', '2', '中茂世纪广场', '汇源路208号', '120', '4', '18', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:27:32', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('11', '2', '海鸥商务大厦', '中山北二路1800号', '120', '4', '19', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:27:35', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('12', '2', '通华大厦', '四平路1230号', '120', '4', '20', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:27:37', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('13', '2', '同济大学沪西校区', '真南路500号', '120', '4', '21', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:27:39', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('14', '2', '红星美凯龙真北路店', '真北路1108号', '943', '5', '22', '购物中心|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:27:42', '2016-08-22 12:23:25');
INSERT INTO `core_parkinfo` VALUES ('15', '2', '中天新世纪商务大厦', '怒江北路302弄', '120', '4', '23', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:27:44', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('16', '2', '福德大厦', '四川北路1688号', '120', '4', '24', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:27:46', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('17', '2', '华虹大厦', '塘沽路463号', '130', '9', '25', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:27:52', '2016-08-22 12:23:25');
INSERT INTO `core_parkinfo` VALUES ('18', '2', '虹口足球场', '东江湾路444号', '120', '4', '26', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:27:54', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('19', '2', '中山soho广场', '中山西路1065号', '120', '4', '27', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:27:56', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('20', '2', '滨江大厦', '张杨路88号', '120', '4', '28', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:27:58', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('21', '2', '良友大厦', '商城路618号', '80', '6', '29', '写字楼|地下车库|车牌识别移动支付', '15', '1', '2016-07-26 13:28:00', '2016-08-22 12:23:25');
INSERT INTO `core_parkinfo` VALUES ('22', '2', '三鑫世界商厦', '张杨路579号', '40', '10', '30', '综合CBD|地下车库|车牌识别移动支付', '15', '1', '2016-07-26 13:28:02', '2016-08-22 12:23:26');
INSERT INTO `core_parkinfo` VALUES ('23', '2', '华隆大厦', '南苏州路333号', '120', '4', '31', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:28:04', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('24', '2', '汇通大厦', '金陵东路569号', '66', '10', '32', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:28:06', '2016-08-22 12:23:26');
INSERT INTO `core_parkinfo` VALUES ('25', '2', '景醇大酒店', '颥兴路185号', '120', '4', '33', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:28:08', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('26', '2', '古华医院', '南桥镇南奉公路9220号', '120', '4', '34', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:28:10', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('27', '2', '新湖明珠城', '东新路88弄新湖明珠城北区', '744', '10', '35', '住宅|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:28:13', '2016-08-22 12:23:26');
INSERT INTO `core_parkinfo` VALUES ('28', '2', '创邑金沙谷', '真北路988号', '98', '5', '36', '商购物中心|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:28:15', '2016-08-22 12:23:27');
INSERT INTO `core_parkinfo` VALUES ('29', '2', '同济大学附属天佑医院', '真南路528号', '120', '4', '37', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:28:17', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('30', '2', '上海恒阜停车场管理有限公司', '亭枫公路8328号', '120', '4', '38', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:28:19', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('31', '2', '紫竹国际大厦', '芳甸路1088号', '340', '15', '39', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:28:22', '2016-08-22 12:23:27');
INSERT INTO `core_parkinfo` VALUES ('32', '2', '思源大厦', '西藏中路500号', '120', '4', '40', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:28:24', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('33', '2', '新金桥广场', '北京西路1号', '145', '15', '41', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:28:27', '2016-08-22 12:23:27');
INSERT INTO `core_parkinfo` VALUES ('34', '2', '申鑫大厦', '宁海东路200号', '120', '4', '42', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:28:29', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('35', '2', '星河世纪广场', '真北路2500号', '476', '5', '43', '商场|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:28:31', '2016-08-22 12:23:28');
INSERT INTO `core_parkinfo` VALUES ('36', '2', '富都滨江大道', '陆家嘴2967号', '120', '4', '44', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:28:33', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('37', '2', '上海精英物业管理有限公司', '金皖路389号', '120', '4', '45', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:28:35', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('38', '2', '中港汇大厦', '长寿路868号', '151', '10', '46', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:28:37', '2016-08-22 12:23:28');
INSERT INTO `core_parkinfo` VALUES ('39', '2', '东方艺术中心', '丁香路425号', '78', '10', '47', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:28:40', '2016-08-22 12:23:29');
INSERT INTO `core_parkinfo` VALUES ('40', '2', '东方金融广场', '世纪大道1168号', '120', '4', '48', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:28:44', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('41', '2', '东辰大厦', '牡丹路60号', '50', '10', '49', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:28:46', '2016-08-22 12:23:29');
INSERT INTO `core_parkinfo` VALUES ('42', '2', '芳草路培花服务中心', '芳草路231号', '200', '10', '50', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:28:48', '2016-08-22 12:23:29');
INSERT INTO `core_parkinfo` VALUES ('43', '2', '东方国际科技大厦', '向城路58号', '120', '4', '51', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:28:50', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('44', '2', '旺角广场', '延安东路175号', '140', '8', '52', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:28:52', '2016-08-22 12:23:30');
INSERT INTO `core_parkinfo` VALUES ('45', '2', '锦江国际购物中心', '淮海中路527号', '120', '4', '53', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:28:54', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('46', '2', '豫园万丽大酒店', '河南南路159号', '120', '4', '54', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:28:57', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('47', '2', '宝鼎大厦', '徐家汇路550号', '120', '4', '55', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:28:59', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('48', '2', '中福酒店公寓', '浙江中路283号', '120', '4', '56', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:29:02', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('49', '2', '曹杨经贸大厦', '怒江北路427号', '120', '4', '57', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:29:04', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('50', '2', '世博洲际酒店', '雪野路1188号', '120', '4', '58', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:29:07', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('51', '2', '华夏银行大厦', '浦东南路256号', '120', '4', '59', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:29:10', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('52', '2', '上海世纪公园', '芳甸路666号', '120', '4', '60', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:29:14', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('53', '2', '齐来工业园', '宜山路889号', '120', '4', '61', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:29:16', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('54', '2', '虹钦园', '虹漕路461号', '120', '4', '62', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:29:18', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('55', '2', '虹漕园', '虹漕路421号', '120', '4', '63', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:29:20', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('56', '2', '桂箐园', '桂箐路69号', '120', '4', '64', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:29:22', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('57', '2', '桂平园', '桂平路555号', '120', '4', '65', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:29:24', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('58', '2', '桂果园', '桂平路471号', '120', '4', '66', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:29:26', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('59', '2', '创业园', '桂平路680号', '120', '4', '67', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:29:27', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('60', '2', '凯特利广场地下', '公园路458号', '120', '4', '68', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:29:29', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('61', '2', '上海双季花卉园艺市场', '浦建路620号', '120', '4', '69', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:29:31', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('62', '2', '象屿集团大厦', '西藏中路725弄28号', '120', '4', '70', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:29:33', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('63', '2', '大盈综合楼', '南京西路456号', '120', '4', '71', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:29:36', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('64', '2', '国际饭店', '南京西路170号', '120', '4', '72', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:29:39', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('65', '2', '陈云纪念馆', '朱枫公路3501号', '120', '4', '73', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:29:41', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('66', '2', '金山嘴渔村', '山阳镇沪杭公路', '120', '4', '74', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:29:43', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('67', '2', '金梦坊', '徐德路85号', '120', '4', '75', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:29:45', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('68', '2', '创意阁', '冠生园路231号', '120', '4', '76', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:29:47', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('69', '2', '上海报闻经贸有限公司', '大统路1098号', '120', '4', '77', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:29:49', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('70', '2', '上海敏大帮帮车辆停放管理有限公司', '大渡河路160号对面', '35', '7', '78', '地面车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:29:51', '2016-08-22 12:23:30');
INSERT INTO `core_parkinfo` VALUES ('71', '2', '山海大厦', '浦东大道1482号', '120', '4', '79', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:29:53', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('72', '2', '由由国际广场', '浦建路76号', '120', '4', '80', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:29:55', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('73', '2', '东方城市花园二期', '东方路1881弄', '120', '4', '81', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:29:57', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('74', '2', '上海悦华大酒店', '南桥镇江海路88号', '120', '4', '82', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:29:59', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('75', '2', '海鸥饭店', '黄浦路60号', '42', '10', '83', '酒店|车牌识别|移动支付', '15', '1', '2016-07-26 13:30:01', '2016-08-22 12:23:31');
INSERT INTO `core_parkinfo` VALUES ('76', '2', '岚桥国际大厦', '世纪大道1128号', '100', '8', '84', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:30:02', '2016-08-22 12:23:31');
INSERT INTO `core_parkinfo` VALUES ('77', '2', '金外滩宾馆', '广东路525号', '120', '4', '85', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:30:04', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('78', '2', '金田大厦', '陆家浜路1295号', '50', '10', '86', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:30:06', '2016-08-22 12:23:31');
INSERT INTO `core_parkinfo` VALUES ('79', '2', '徐泾农贸市场', '徐泾镇明珠路258号', '120', '4', '87', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:30:09', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('80', '2', '新发展亚太JW万豪酒店', '大渡河路158号', '177', '10', '88', '酒店|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:30:12', '2016-08-22 12:23:32');
INSERT INTO `core_parkinfo` VALUES ('81', '2', '甘泉德必易园', '交通路2447号', '10', '', '89', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:30:14', '2016-08-22 12:23:32');
INSERT INTO `core_parkinfo` VALUES ('82', '2', '永融企业中心', '四平路257号', '180', '10', '90', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:30:15', '2016-08-22 12:23:32');
INSERT INTO `core_parkinfo` VALUES ('83', '2', '春申创意园', '梅富路228号', '120', '4', '91', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:30:18', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('84', '2', '峰汇嘉苑', '天祝路555弄', '120', '4', '92', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:30:21', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('85', '2', '南郊聚润广场', '南桥镇德丰路299弄', '120', '4', '93', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:30:21', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('86', '2', '上海众市实业有限公司（天津路）', '天津路297号', '120', '4', '94', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:30:24', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('87', '2', '奉贤体育中心', '南桥镇古华路100号', '120', '4', '95', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:30:25', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('88', '2', '上海久创科技园', '瓶安路1358号', '120', '4', '96', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:30:27', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('89', '2', '皋城菜场', '仓场路331号', '119', '5', '97', '农贸市场|地面车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:30:29', '2016-08-22 12:23:33');
INSERT INTO `core_parkinfo` VALUES ('90', '2', '上海岚灵花鸟市场', '灵石路1539号', '120', '4', '98', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:30:30', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('91', '2', '张慕工业基地', '春申路2328号', '120', '4', '99', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:30:31', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('92', '2', '虹顺商业广场', '天山西路4086号', '120', '4', '100', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:30:33', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('93', '2', '思南公馆', '重庆南路258号', '120', '4', '101', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:30:36', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('94', '2', '复兴SOHO广场', '马当路388号', '120', '4', '102', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:30:39', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('95', '2', '虹口soho广场', '武进路190号', '120', '4', '103', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:30:41', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('96', '2', '上海汇银金融商务中心', '云岭东路599弄', '200', '5', '104', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:30:43', '2016-08-22 12:23:33');
INSERT INTO `core_parkinfo` VALUES ('97', '2', '绿天商城', '百兴路8号11633室', '120', '4', '105', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:30:45', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('98', '2', '新天国际大厦', '福山路450号', '120', '4', '106', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:30:47', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('99', '2', '天山衡辰公寓', '天山路388弄1号地下二层', '120', '4', '107', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:30:49', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('100', '2', '船研大厦', '民生路600号', '120', '4', '108', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:30:51', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('101', '2', '嘉瑞酒店', '潍坊路328号', '60', '10', '109', '酒店|车牌识别|移动支付|地下车库', '15', '1', '2016-07-26 13:30:54', '2016-08-22 12:23:33');
INSERT INTO `core_parkinfo` VALUES ('102', '2', '华辰大厦', '浦东大道958号', '120', '4', '110', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:30:56', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('103', '2', '上海T71园区', '秦桥路71号', '120', '4', '111', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:30:58', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('104', '2', '嘉实生活广场', '嘉松北路6130弄', '120', '4', '112', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:31:01', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('105', '2', '嘉定体育中心', '新成路118号', '300', '5', '113', '体育场|车牌识别|移动支付|地面车库', '15', '1', '2016-07-26 13:31:03', '2016-08-22 12:23:34');
INSERT INTO `core_parkinfo` VALUES ('106', '2', '昂立大厦', '广富林路697弄', '120', '4', '114', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:31:05', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('107', '2', '富绅国际大厦', '公园东路1590-1650号', '120', '4', '115', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:31:07', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('108', '2', '桥梓湾购物中心', '沅河路271号', '120', '4', '116', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:31:09', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('109', '2', '上海御豪置业有限公司（2535号）', '虹桥路2535号', '120', '4', '117', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:31:12', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('110', '2', '嘉鸿大厦', '广富林路699号', '120', '4', '118', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:31:14', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('111', '2', '沪宁停车场', '江桥镇华江路230弄80号', '120', '4', '119', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:31:16', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('112', '2', '威隆大厦', '曹安路1718号', '120', '4', '120', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:31:18', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('113', '2', '新虹桥中心花园', '延安西路2238号', '249', '10', '121', '住宅|地面车库|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:31:20', '2016-08-22 12:23:34');
INSERT INTO `core_parkinfo` VALUES ('114', '2', '申康宾馆', '虹桥路1440号', '75', '5', '122', '酒店|车牌识别|移动支付', '15', '1', '2016-07-26 13:31:22', '2016-08-22 12:23:34');
INSERT INTO `core_parkinfo` VALUES ('115', '2', '祥腾财富广场', '共和新路3088弄', '486', '5', '123', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:31:25', '2016-08-22 12:23:35');
INSERT INTO `core_parkinfo` VALUES ('116', '2', '嘉禾大厦', '叶城路818号', '120', '4', '124', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:31:27', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('117', '2', '宝燕集团', '春申路3333号', '120', '4', '125', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:31:29', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('118', '2', '上海外高桥保宏大酒店有限公司（上海外高桥皇冠假日酒店）', '杨高北路1000号', '120', '4', '126', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:31:32', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('119', '2', '上海周浦停车场（周康路）', '周康路21号', '120', '4', '127', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:31:34', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('120', '2', '上海周杨物业管理有限公司（百顺路）', '南桥镇百顺路201号', '120', '4', '128', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:31:36', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('121', '2', '上海申奉道路清障施救服务有限公司', '沪杭公路2142号', '120', '4', '129', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:31:38', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('122', '2', '上海星峡置业有限公司（上海海洋大厦）', '延安东路550号', '120', '4', '130', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:31:40', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('123', '2', '上海先达房地产发展有限公司（我格广场B2.B3A车库）', '武宁路99号', '120', '4', '131', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:31:42', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('124', '2', '上海南利置业有限公司（璞邸精品酒店）', '雁荡路99号', '120', '4', '132', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:31:44', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('125', '2', '上海卡菱电子科技有限公司（美罗大厦）', '天钥桥路30号', '120', '4', '133', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:31:47', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('126', '2', '上海继杰实业有限公司（虹桥车酷）', '天山西路4358弄53号', '120', '4', '134', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:31:48', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('127', '2', '上海富都物业管理有限公司（海富花园）', '东方路1365号', '120', '4', '135', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:31:49', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('128', '2', '上海中茂房地产开发有限公司（中茂世纪广场）', '汇源路208号', '120', '4', '136', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:31:52', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('129', '2', '上海灏芯电子科技有限公司', '西环路777弄23号101室', '120', '4', '137', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:31:56', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('130', '2', '上海奥林实业有限公司（嘉定体育中心（新馆））', '新成路138号', '120', '4', '138', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:31:59', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('131', '2', '上海圣骊投资发展有限公司（圣骊虹桥创意园）', '虹桥路996弄161号', '120', '4', '139', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:32:02', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('132', '2', '上海东湖宾馆', '东湖路70号', '120', '4', '140', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:32:04', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('133', '2', '上海深南交通设施有限公司（悦达889）', '万航渡路889号', '410', '10', '141', '商场|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:32:06', '2016-08-22 12:23:35');
INSERT INTO `core_parkinfo` VALUES ('134', '2', '上海嘉定商城有限公司', '清河路48号', '51', '5', '142', '商场|地面车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:32:08', '2016-08-22 12:23:35');
INSERT INTO `core_parkinfo` VALUES ('135', '2', '上海安帮成扬停车管理服务社(中环大厦)', '中山北路3856弄1~4号', '120', '4', '143', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:32:10', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('136', '2', '泊斯停车管理咨询（上海）有限公司', '卫清西路477号', '120', '4', '144', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:32:12', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('137', '2', '青浦鹤森广场', '诸陆西路852号', '120', '4', '145', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:32:15', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('138', '2', '上海新世纪大厦发展有限公司（新世纪大厦）', '陆家浜路1011号', '50', '9', '146', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:32:19', '2016-08-22 12:23:36');
INSERT INTO `core_parkinfo` VALUES ('139', '2', '加恒（上海）置业有限公司（南翔太茂）', '南翔镇丰翔路3168号', '120', '4', '147', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:32:24', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('140', '2', '上海梅华实业有限公司集心路分公司（梅美商务园区）', '集心路168号', '120', '4', '148', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:32:27', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('141', '2', '上海梅华实业有限公司罗阳路分公司（梅夏商务园区）', '罗阳路168号', '120', '4', '149', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:32:29', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('142', '2', '加恒（上海）置业有限公司（瑞林路）', '南翔镇瑞林路', '120', '4', '150', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:32:31', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('143', '2', '上海无线电电子研究所科技经营部（凯利大厦）', '淮海西路432号', '120', '4', '151', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:32:33', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('144', '2', '上海嘉沙物业管理有限公司（嘉乐广场）', '仓场路365号', '78', '5', '152', '商场|地面车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:32:35', '2016-08-22 12:23:36');
INSERT INTO `core_parkinfo` VALUES ('145', '2', '上海曹安置业有限公司（福瑞大厦）', '曹安路1509号', '200', '2', '153', '商场|地面车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:32:37', '2016-08-22 12:23:37');
INSERT INTO `core_parkinfo` VALUES ('146', '2', '泊斯停车管理咨询（上海）有限公司（乐购超市莘庄店）', '七莘路695号', '120', '4', '154', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:32:39', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('147', '2', '泊斯停车管理咨询（上海）有限公司（乐购超市锦绣店）', '锦绣路3218号', '120', '4', '155', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:32:41', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('148', '2', '上海福辰物业管理有限公司（福城商城）', '宜川路310号', '120', '4', '156', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:32:44', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('149', '2', '上海恒通云生置业有限公司', '塔新路999号', '120', '4', '157', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:32:46', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('150', '2', '上海嘉定汽车客运场站管理有限公司（嘉定客运中心）', '陈家山路1800号', '120', '4', '158', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:32:49', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('151', '2', '上海磊成物业管理有限公司（泰宸商务楼）', '博乐路158号', '178', '5', '159', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:32:52', '2016-08-22 12:23:37');
INSERT INTO `core_parkinfo` VALUES ('152', '2', '上海嘉定欧亚美沪宜家具市场经营管理有限公司（欧亚美）', '沪宜公路3518号', '200', '5', '160', '商场|地面车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:32:54', '2016-08-22 12:23:37');
INSERT INTO `core_parkinfo` VALUES ('153', '2', '上海磊成物业管理有限公司（泰宸汇金商务楼）', '金沙路75、77号', '125', '5', '161', '写字楼|地下车库|车牌识别移动支付', '15', '1', '2016-07-26 13:32:56', '2016-08-22 12:23:38');
INSERT INTO `core_parkinfo` VALUES ('154', '2', '上海俱美物业管理有限公司（丽都广场）', '友谊路2758号', '120', '4', '162', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:32:58', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('155', '2', '上海玖如物业管理有限公司', '定康路25号', '120', '4', '163', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:33:01', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('156', '2', '上海永佳物业管理有限公司（奉贤中医医院）', '南奉公路5988号', '120', '4', '164', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:33:08', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('157', '2', '上海乾亨物业管理有限公司—奉贤分公司', '南奉公路6600号', '120', '4', '165', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:33:13', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('158', '2', '上海奉鼎停车场（奉城医院）', '南奉公路9983号', '120', '4', '166', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:33:15', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('159', '2', '上海永达置业发展有限公司（永达国际大厦）', '龙阳路2277号', '120', '4', '167', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:33:17', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('160', '2', '上海浦东新区花木物业公司', '梅花路768弄', '120', '4', '168', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:33:19', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('161', '2', '上港集团海湾分公司（港务大厦）', '丰和路1号', '120', '4', '169', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:33:21', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('162', '2', '上海森然商务咨询有限公司', '沪南路2591号', '120', '4', '170', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:33:25', '2016-08-22 12:23:38');
INSERT INTO `core_parkinfo` VALUES ('163', '2', '上海尤文交通设施有限公司（上南路）', '上南路3855号', '120', '4', '171', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:33:28', '2016-08-22 12:23:38');
INSERT INTO `core_parkinfo` VALUES ('164', '2', '上海尤文交通设施有限公司（康桥路787）', '康桥路787号', '572', '5', '172', '园区|地面车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:33:30', '2016-08-22 12:23:39');
INSERT INTO `core_parkinfo` VALUES ('165', '2', '深圳市城投物业管理有限公司上海分公司（嘉福汇商务广场）', '福海路777弄', '120', '4', '173', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:33:32', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('166', '2', '上海致源置业有限公司（源达大厦）', '长寿路360号', '186', '10', '174', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:33:35', '2016-08-22 12:23:39');
INSERT INTO `core_parkinfo` VALUES ('167', '2', '上海工宇物业管理有限公司（T15园区）', '宁桥路999号', '120', '4', '175', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:33:37', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('168', '2', '上海新金桥设施管理有限公司（红枫路）', '红枫路233号', '120', '4', '176', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:33:39', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('169', '2', '上海太湖世家物业管理有限公司嘉定分公司（太湖世家国际大厦）', '德富路1198号', '120', '4', '177', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:33:42', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('170', '2', '上海新金桥设施管理有限公司（T52）', '申江路3079号', '120', '4', '178', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:33:44', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('171', '2', '上海证大歌腾投资管理有限公司（金桥大拇指广场）', '平度路258号', '120', '4', '179', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:33:46', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('172', '2', '上海嘉莲华国际商业广场经营管理有限公司（嘉莲华国际商业广场）', '曹安路2188号', '200', '5', '180', '商场|车牌识别|移动支付', '15', '1', '2016-07-26 13:33:48', '2016-08-22 12:23:40');
INSERT INTO `core_parkinfo` VALUES ('173', '2', '上海国际汽车城新安亭联合发展有限公司（汽车博览公园）', '博园路7575号', '120', '4', '181', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:33:50', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('174', '2', '上海科技京城管理发展有限公司（科技京城）', '北京东路666号', '120', '4', '182', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:33:52', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('175', '2', '上海新世纪房产服务有限公司（同盛大厦）', '福山路458号', '120', '4', '183', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:33:54', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('176', '2', '上海昌呈牧业有限公司', '周浦镇瓦屑镇北路1号', '120', '4', '184', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:33:57', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('177', '2', '上海久方旅馆有限公司', '长寿路522号', '120', '4', '185', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:33:59', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('178', '2', '上海国信广场经营有限公司（国兴广场）', '建国中路29号', '120', '4', '186', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-07-26 13:34:02', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('179', '2', '上海新国际博览中心', '上海浦东新区龙阳路2345', '120', '4', '187', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-08-02 11:15:00', '2016-08-22 12:19:35');
INSERT INTO `core_parkinfo` VALUES ('180', '2', '冨荟广场', '上海市普通新区樱花路80弄', '120', '4', '188', '写字楼|地下车库|车牌识别|移动支付', '15', '1', '2016-08-13 17:09:55', '2016-08-22 12:19:35');

-- ----------------------------
-- Table structure for yxtc_framework_menu
-- ----------------------------
DROP TABLE IF EXISTS `yxtc_framework_menu`;
CREATE TABLE `yxtc_framework_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menuname` varchar(50) DEFAULT NULL,
  `ordernum` int(11) DEFAULT NULL,
  `describes` varchar(50) DEFAULT NULL,
  `state` varchar(4) NOT NULL DEFAULT '1',
  `pic` varchar(80) DEFAULT NULL,
  `createdatetime` varchar(50) DEFAULT NULL,
  `updatedatetime` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='一级目录';

-- ----------------------------
-- Records of yxtc_framework_menu
-- ----------------------------
INSERT INTO `yxtc_framework_menu` VALUES ('1', '系统设置', '1', null, '1', 'menu-icon fa fa-tachometer', null, null);
INSERT INTO `yxtc_framework_menu` VALUES ('2', '我的功能', '2', '', '1', 'fa fa-lg fa-fw fa-cloud', null, null);

-- ----------------------------
-- Table structure for yxtc_framework_menuinfo
-- ----------------------------
DROP TABLE IF EXISTS `yxtc_framework_menuinfo`;
CREATE TABLE `yxtc_framework_menuinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menuinfoname` varchar(50) DEFAULT NULL,
  `ordernum` int(11) DEFAULT NULL,
  `describes` varchar(200) DEFAULT NULL,
  `menuid` varchar(50) DEFAULT NULL,
  `url` varchar(500) DEFAULT NULL,
  `state` varchar(4) NOT NULL DEFAULT '1',
  `createdatetime` varchar(50) DEFAULT NULL,
  `updatedatetime` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COMMENT='二级目录';

-- ----------------------------
-- Records of yxtc_framework_menuinfo
-- ----------------------------
INSERT INTO `yxtc_framework_menuinfo` VALUES ('1', '角色管理', '3', null, '1', '/pages/framework/rolemanager.jsp', '1', null, null);
INSERT INTO `yxtc_framework_menuinfo` VALUES ('3', '目录管理', '4', null, '1', '/pages/framework/menumanager.jsp', '1', null, null);
INSERT INTO `yxtc_framework_menuinfo` VALUES ('4', '角色分配', '6', null, '1', '/pages/framework/userrole.jsp', '1', null, null);
INSERT INTO `yxtc_framework_menuinfo` VALUES ('5', '用户管理', '2', null, '1', '/pages/framework/usermanager.jsp', '1', null, null);
INSERT INTO `yxtc_framework_menuinfo` VALUES ('6', '目录权限管理', '7', null, '1', '/pages/framework/menuright.jsp', '1', null, null);
INSERT INTO `yxtc_framework_menuinfo` VALUES ('34', '系统参数设置', '9', '', '1', '/pages/framework/parammanager.jsp', '1', null, null);
INSERT INTO `yxtc_framework_menuinfo` VALUES ('35', '我的功能1', '1', '', '2', '', '1', null, null);

-- ----------------------------
-- Table structure for yxtc_framework_menuright
-- ----------------------------
DROP TABLE IF EXISTS `yxtc_framework_menuright`;
CREATE TABLE `yxtc_framework_menuright` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleid` varchar(50) DEFAULT NULL,
  `menuid` varchar(50) DEFAULT NULL,
  `menuinfoid` varchar(50) DEFAULT NULL,
  `righttype` varchar(2) DEFAULT NULL,
  `state` varchar(4) NOT NULL DEFAULT '1',
  `createdatetime` varchar(50) DEFAULT NULL,
  `updatedatetime` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=380 DEFAULT CHARSET=utf8 COMMENT='目录权限列表';

-- ----------------------------
-- Records of yxtc_framework_menuright
-- ----------------------------
INSERT INTO `yxtc_framework_menuright` VALUES ('1', '1', '1', '1', '4', '1', null, null);
INSERT INTO `yxtc_framework_menuright` VALUES ('3', '1', '1', '3', '4', '1', null, null);
INSERT INTO `yxtc_framework_menuright` VALUES ('4', '1', '1', '4', '4', '1', null, null);
INSERT INTO `yxtc_framework_menuright` VALUES ('6', '1', '1', '6', '4', '1', null, null);
INSERT INTO `yxtc_framework_menuright` VALUES ('347', '1', '1', '34', '4', '1', null, null);
INSERT INTO `yxtc_framework_menuright` VALUES ('377', '1', '1', '5', '4', '1', null, null);
INSERT INTO `yxtc_framework_menuright` VALUES ('378', '1', '2', '35', '1', '1', null, null);
INSERT INTO `yxtc_framework_menuright` VALUES ('379', '1', '2', '35', '4', '1', null, null);

-- ----------------------------
-- Table structure for yxtc_framework_paraminfo
-- ----------------------------
DROP TABLE IF EXISTS `yxtc_framework_paraminfo`;
CREATE TABLE `yxtc_framework_paraminfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `paramtypeid` varchar(4) NOT NULL COMMENT '参数类型 id',
  `paramtypename` varchar(40) DEFAULT NULL COMMENT '参数类型名称',
  `paramkey` varchar(20) NOT NULL COMMENT '参数主键',
  `paramvalue` text NOT NULL COMMENT '参数内容',
  `paramtext` varchar(200) DEFAULT NULL COMMENT '备注',
  `usetype` varchar(4) DEFAULT '1' COMMENT '启用状态 1启用 0停用',
  `state` varchar(4) DEFAULT '1' COMMENT '状态 1使用 0删除',
  `createpersonid` varchar(20) DEFAULT NULL COMMENT '最后修改人',
  `createtime` varchar(24) DEFAULT NULL,
  `updatetime` varchar(24) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8 COMMENT='系统参数';

-- ----------------------------
-- Records of yxtc_framework_paraminfo
-- ----------------------------
INSERT INTO `yxtc_framework_paraminfo` VALUES ('1', '1', '用户类型', '0', '云平台用户类型', '云平台用户类型1', '1', '1', null, '2016-04-03', '2017-03-15 13:29:46');
INSERT INTO `yxtc_framework_paraminfo` VALUES ('2', '1', '用户类型', '1', '供应商', '供应商', '1', '1', null, null, '2016-09-28 09:04:45');
INSERT INTO `yxtc_framework_paraminfo` VALUES ('14', '3', '短信位数', 'register', '5', '登录短信位数', '1', '1', null, null, '2016-09-28 09:04:47');
INSERT INTO `yxtc_framework_paraminfo` VALUES ('15', '4', '微信支付参数', 'appid', 'wxa4609c0083e67d21', 'appid', '1', '1', null, null, '2016-09-28 09:04:49');
INSERT INTO `yxtc_framework_paraminfo` VALUES ('16', '4', '微信支付参数', 'appsecret', 'c2279c8cea30d5e2bceb55dea0efc92b', 'appsecret', '1', '1', null, null, null);
INSERT INTO `yxtc_framework_paraminfo` VALUES ('17', '4', '微信支付参数', 'mchid', '1262942001', '商户id', '1', '1', null, null, null);
INSERT INTO `yxtc_framework_paraminfo` VALUES ('18', '4', '微信支付参数', 'unifiedorder', 'https://api.mch.weixin.qq.com/pay/unifiedorder', '统一支付接口', '1', '1', null, null, null);
INSERT INTO `yxtc_framework_paraminfo` VALUES ('19', '4', '微信支付参数', 'notify_url', 'http://www.laicigo.cn:8081/pay/paynotice', '支付成功返回地址', '1', '1', null, null, null);
INSERT INTO `yxtc_framework_paraminfo` VALUES ('20', '4', '微信支付参数', 'key', '89505c8ab8a947df9ae22a49fcff33d6', '秘钥', '1', '1', null, null, null);
INSERT INTO `yxtc_framework_paraminfo` VALUES ('21', '5', '微信公众账号参数', 'appid', 'wxc1a1ca2ee3c1610c', 'appid', '1', '1', null, null, null);
INSERT INTO `yxtc_framework_paraminfo` VALUES ('22', '5', '微信公众账号参数', 'appsecret', 'ee5929578ba543314146c05849c5e664', 'appsecret', '1', '1', null, null, null);
INSERT INTO `yxtc_framework_paraminfo` VALUES ('23', '5', '微信公众账号参数', 'mchid', '1326361801', '商户id', '1', '1', null, null, null);
INSERT INTO `yxtc_framework_paraminfo` VALUES ('24', '5', '微信公众账号参数', 'unifiedorder', 'https://api.mch.weixin.qq.com/pay/unifiedorder', '统一支付接口', '1', '1', null, null, null);
INSERT INTO `yxtc_framework_paraminfo` VALUES ('25', '5', '微信公众账号参数', 'notify_url', 'http://www.laicigo.cn:8081/pay/paynotice', '支付成功返回地址', '1', '1', null, null, null);
INSERT INTO `yxtc_framework_paraminfo` VALUES ('26', '5', '微信公众账号参数', 'key', '1234567899876543223dfgd56321wtre', '秘钥', '1', '1', null, null, null);
INSERT INTO `yxtc_framework_paraminfo` VALUES ('27', '6', '支付宝支付参数', 'partner', '2088911844112230', '商户id', '1', '1', null, null, null);
INSERT INTO `yxtc_framework_paraminfo` VALUES ('28', '6', '支付宝支付参数', 'appid', '2015070800160729', null, '1', '1', null, null, null);
INSERT INTO `yxtc_framework_paraminfo` VALUES ('29', '6', '支付宝支付参数', 'public_key', 'MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDI6d306Q8fIfCOaTXyiUeJHkrIvYISRcc73s3vF1ZT7XN8RNPwJxo8pWaJMmvyTn9N4HQ632qJBVHf8sxHi/fEsraprwCtzvzQETrNRwVxLO5jVmRGi60j8Ue1efIlzPXV9je9mkjzOmdssymZkh2QhUrCmZYI/FCEa3/cNMW0QIDAQAB', '公钥', '1', '1', null, null, null);
INSERT INTO `yxtc_framework_paraminfo` VALUES ('30', '6', '支付宝支付参数', 'private_key', 'MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALTUWzjSSE9xHqxLEzh4OSUgp/3ewEcirAq+iEdC+WaVA9jt4VbAjRl+CFTcAywsbMFeAh3I83TToD/D6i+tnLkvElf5nLWocsbpbRfq2FBTClGa+gJ7UZTSEqeTrK6UYsWzobTDt24pKvkIhFk51XQZ1K05sK5zwJvaKJ3B8YPnAgMBAAECgYA+ObUKYJIxhCOh9lOu4vAHLq2gVr6ju/Kn39jVbN6VxkGErJcWWzwywYPsb6lH0iG6iLcBuNzOHuTODITR01RScQiLpLbLyHGsJocjI8gWwMzjun/rIoWLXXOHXFLPxX8yExfF9+mxIKtlRq1rlAhFAfcudyj6tLzaBr5yxH2BAQJBAN+Pg3N4RBHwaSEFntDDWJYFov0Nl+0gcjyZ6W3ZQ0YLjreefuPPwcgSBBM0KkOo91qN5wQ1ANcT76wueDo1mXcCQQDPEYi6DzAe8DJ2i4GyJ+syNzaR5RZYPd9whgmdT2werQmNYdMqSL1s2gwXhNQ5PYxXbi6SNXWEEcLARTszdQURAkAoQJbSe50F/dtv7qshu4p/uJQYLBJmx6jJ8IxvEudh/UK9HPSL4CRr+ZJyQro5ZHrk+xfVUhXMo/JLdjJ/iJcRAkBLYYS2xySrfqHAShUS+DlE9JinEBDMWunmmsURQYKIwFGD6KLo98YNxGs2fKKNm/xlL7VAgLmhNJ4DRLDCkM0hAkEAlhdErsett3LcUJHd1wC2+vheaq7lfoflox0/qDZsMalWl7xc0weNHNIli3apyqiNRPubbj/an9ReNmyMkZeT3g==', '商户的私钥', '1', '1', null, null, null);
INSERT INTO `yxtc_framework_paraminfo` VALUES ('31', '6', '支付宝支付参数', 'input_charset', 'utf-8', '传输数据格式', '1', '1', null, null, null);
INSERT INTO `yxtc_framework_paraminfo` VALUES ('32', '6', '支付宝支付参数', 'ali_public_key', 'MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB', '支付宝的公钥', '1', '1', null, null, null);
INSERT INTO `yxtc_framework_paraminfo` VALUES ('33', '6', '支付宝支付参数', 'seller_id', 'lujunchao@laicigo.cn', '支付宝账号', '1', '1', null, null, null);
INSERT INTO `yxtc_framework_paraminfo` VALUES ('34', '6', '支付宝支付参数', 'sign_type', 'RSA', '签名方式', '1', '1', null, null, null);
INSERT INTO `yxtc_framework_paraminfo` VALUES ('35', '6', '支付宝支付参数', 'https_verify_url', 'https://mapi.alipay.com/gateway.do?service=notify_verify&', '校验地址', '1', '1', null, null, null);
INSERT INTO `yxtc_framework_paraminfo` VALUES ('36', '6', '支付宝支付参数', 'open_api_gateway', 'https://openapi.alipay.com/gateway.do', '支付宝交易网关', '1', '1', null, null, null);
INSERT INTO `yxtc_framework_paraminfo` VALUES ('37', '6', '支付宝支付参数', 'notify_url', 'http://www.laicigo.cn:8081/pay/alipaynotice', '支付成功返回地址', '1', '1', null, null, null);
INSERT INTO `yxtc_framework_paraminfo` VALUES ('38', '7', '极光推送参数', 'appkey', 'ee2b76feca2b1129910cd88b', 'appkey', '1', '1', null, null, null);
INSERT INTO `yxtc_framework_paraminfo` VALUES ('39', '7', '极光推送参数', 'mastersecret', 'c31cb982ca2458f935a38811', 'mastersecret', '1', '1', null, null, null);
INSERT INTO `yxtc_framework_paraminfo` VALUES ('40', '8', '大鱼短信参数', 'url', 'http://gw.api.taobao.com/router/rest', '请求url', '1', '1', null, null, null);
INSERT INTO `yxtc_framework_paraminfo` VALUES ('41', '8', '大鱼短信参数', 'appid', '23358348', null, '1', '1', null, null, null);
INSERT INTO `yxtc_framework_paraminfo` VALUES ('42', '8', '大鱼短信参数', 'appsecret', 'e5dd1d1c12b6c223fbd1130444afa5d2', null, '1', '1', null, null, null);
INSERT INTO `yxtc_framework_paraminfo` VALUES ('43', '8', '大鱼短信参数', 'smssign', '优选停车', '短信签名', '1', '1', null, null, null);
INSERT INTO `yxtc_framework_paraminfo` VALUES ('44', '8', '大鱼短信参数', 'smstemplet', 'SMS_7380189', '短信模板', '1', '1', null, null, null);
INSERT INTO `yxtc_framework_paraminfo` VALUES ('45', '9', '邮箱服务器参数', 'hostname', 'smtp.laicigo.cn', '邮箱地址', '1', '1', null, null, null);
INSERT INTO `yxtc_framework_paraminfo` VALUES ('46', '9', '邮箱服务器参数', 'port', '25', '邮箱端口', '1', '1', null, null, null);
INSERT INTO `yxtc_framework_paraminfo` VALUES ('47', '9', '邮箱服务器参数', 'username', 'system@laicigo.cn', '用户名', '1', '1', null, null, null);
INSERT INTO `yxtc_framework_paraminfo` VALUES ('48', '9', '邮箱服务器参数', 'password', 'Lcg20160504', '密码', '1', '1', null, null, null);
INSERT INTO `yxtc_framework_paraminfo` VALUES ('49', '9', '邮箱服务器参数', 'fromemail', 'system@laicigo.cn', '邮箱名称', '1', '1', null, null, null);
INSERT INTO `yxtc_framework_paraminfo` VALUES ('50', '10', '极速接口参数', 'apikey', '3c3223379e28c636', 'rrrrrr', '1', '1', null, null, '2017-03-15 13:29:27');
INSERT INTO `yxtc_framework_paraminfo` VALUES ('51', '10', '极速接口参数', 'serviceurl', 'http://api.jisuapi.com/', null, '1', '1', null, null, null);
INSERT INTO `yxtc_framework_paraminfo` VALUES ('52', '10', '极速接口参数', 'getcityurl', 'http://api.jisuapi.com/weather/query?/weather/city?appkey=${appkey}', null, '1', '1', null, null, null);
INSERT INTO `yxtc_framework_paraminfo` VALUES ('53', '10', '极速接口参数', 'weatherurl', 'http://api.jisuapi.com/weather/query?appkey=${appkey}&&city=${city}', null, '1', '1', null, null, null);
INSERT INTO `yxtc_framework_paraminfo` VALUES ('54', '10', '极速接口参数', 'oilurl', 'http://api.jisuapi.com/oil/query?appkey=${appkey}&province=${province}', null, '1', '1', null, null, null);
INSERT INTO `yxtc_framework_paraminfo` VALUES ('55', '10', '极速接口参数', 'aqiurl', 'http://api.jisuapi.com/aqi/query?appkey=${appkey}&city=${city}', null, '1', '1', null, null, null);
INSERT INTO `yxtc_framework_paraminfo` VALUES ('56', '10', '极速接口参数', 'illegalcarorgurl', 'http://api.jisuapi.com/illegal/carorg?appkey=${appkey}', null, '1', '1', null, null, null);
INSERT INTO `yxtc_framework_paraminfo` VALUES ('57', '10', '极速接口参数', 'illegallstypeurl', 'http://api.jisuapi.com/illegal/lstype?appkey=${appkey}', null, '1', '1', null, null, null);
INSERT INTO `yxtc_framework_paraminfo` VALUES ('58', '10', '极速接口参数', 'illegalqueryurl', 'http://api.jisuapi.com/illegal/query?appkey=${appkey}&carorg=${carorg}&lsprefix=${lsprefix}&lsnum=${lsnum}&lstype=${lstype}&engineno=${engineno}&frameno=${frameno}', null, '1', '1', null, null, null);
INSERT INTO `yxtc_framework_paraminfo` VALUES ('70', '13', '百度API参数', 'geocding', 'http://api.map.baidu.com/geocoder/v2/?ak=F3af9951922670f0964bceda52bdcf9b&location=${lat},${lon}&output=json&pois=0', '获取地理位置信息', '1', '1', null, null, null);
INSERT INTO `yxtc_framework_paraminfo` VALUES ('71', '13', '百度API参数', 'weather', 'http://api.map.baidu.com/telematics/v3/weather?location=${location}&output=json&ak=F3af9951922670f0964bceda52bdcf9b', '获取天气接口', '1', '1', null, null, null);
INSERT INTO `yxtc_framework_paraminfo` VALUES ('73', '14', '百度apistore参数', 'apikey', '700b7cafee71d9f1e8234e26b1591bd1', null, '1', '1', null, null, null);
INSERT INTO `yxtc_framework_paraminfo` VALUES ('74', '14', '百度apistore参数', 'oilurl', 'http://apis.baidu.com/showapi_open_bus/oil_price/find?prov=${province}', '获取油价地址', '1', '1', null, null, null);
INSERT INTO `yxtc_framework_paraminfo` VALUES ('80', '1', '用户类型', '2', '圆通速递', '圆通速递', '0', '1', null, '2016-09-30 17:14:51', '2017-03-15 13:25:50');

-- ----------------------------
-- Table structure for yxtc_framework_roleinfo
-- ----------------------------
DROP TABLE IF EXISTS `yxtc_framework_roleinfo`;
CREATE TABLE `yxtc_framework_roleinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(20) DEFAULT NULL,
  `describes` varchar(500) DEFAULT NULL,
  `add1` varchar(50) DEFAULT NULL,
  `add2` varchar(100) DEFAULT NULL,
  `state` varchar(4) NOT NULL DEFAULT '1',
  `createdatetime` varchar(50) DEFAULT NULL,
  `updatedatetime` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='角色信息';

-- ----------------------------
-- Records of yxtc_framework_roleinfo
-- ----------------------------
INSERT INTO `yxtc_framework_roleinfo` VALUES ('1', '系统管理员', '系统管理员', '请选择', null, '1', null, '2016-27-09 15:56:13');
INSERT INTO `yxtc_framework_roleinfo` VALUES ('2', '供应商', '供应商1', null, null, '0', '2016-03-21 09:38:23', '2016-27-09 15:59:23');
INSERT INTO `yxtc_framework_roleinfo` VALUES ('3', '停车场', '停车场', null, null, '0', '2016-03-23 15:35:07', null);
INSERT INTO `yxtc_framework_roleinfo` VALUES ('4', '测试', '测试账户2', null, null, '0', '2016-04-01 17:47:12', '2016-01-04 17:47:33');
INSERT INTO `yxtc_framework_roleinfo` VALUES ('5', '测试3', '测试3', null, null, '0', '2016-04-13 16:05:08', '2016-15-04 17:15:14');
INSERT INTO `yxtc_framework_roleinfo` VALUES ('6', '圆通速递', '圆通速递', null, null, '1', '2016-09-30 17:14:11', null);

-- ----------------------------
-- Table structure for yxtc_framework_userinfo
-- ----------------------------
DROP TABLE IF EXISTS `yxtc_framework_userinfo`;
CREATE TABLE `yxtc_framework_userinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` varchar(20) NOT NULL,
  `username` varchar(40) NOT NULL,
  `password` varchar(80) NOT NULL COMMENT '登录密码',
  `usertype` varchar(4) DEFAULT NULL COMMENT '用户类型  0 优选平台用户 1物业 2停车场   3商户 4车主  5 移动设备',
  `companyid` varchar(20) DEFAULT NULL COMMENT '物业公司id',
  `parkid` varchar(20) DEFAULT NULL COMMENT '停车场id',
  `merchantcompanyid` varchar(20) DEFAULT NULL COMMENT '商户公司',
  `merchantid` varchar(20) DEFAULT NULL COMMENT '商户id',
  `email` varchar(40) DEFAULT NULL COMMENT 'email',
  `telphone` varchar(20) DEFAULT NULL,
  `regeisttime` varchar(24) DEFAULT NULL COMMENT '注册时间',
  `state` varchar(4) NOT NULL DEFAULT '1' COMMENT '逻辑删除标示  0表示删除',
  `createpersonid` varchar(20) DEFAULT NULL COMMENT '创建人',
  `createtime` varchar(24) DEFAULT NULL COMMENT '创建时间',
  `updatetime` varchar(24) DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`,`userid`),
  UNIQUE KEY `userid` (`userid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='云平台用户信息';

-- ----------------------------
-- Records of yxtc_framework_userinfo
-- ----------------------------
INSERT INTO `yxtc_framework_userinfo` VALUES ('2', 'admin', '系统管理员', '21232f297a57a5a743894a0e4a801fc3', '0', '', '', null, null, 'wangrui@laicigo.cn', '15000000000', '2016-03-02 00:00:00', '1', 'admin', '2016-03-02 00:00:00', '2016-27-09 17:01:30');
INSERT INTO `yxtc_framework_userinfo` VALUES ('3', 'reywong', 'reywong', '56144c6ed12079b7e0f758226e6d89e2', '1', null, null, null, null, '', '', null, '1', 'admin', '2016-09-27 17:31:57', null);

-- ----------------------------
-- Table structure for yxtc_framework_userrole
-- ----------------------------
DROP TABLE IF EXISTS `yxtc_framework_userrole`;
CREATE TABLE `yxtc_framework_userrole` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` varchar(8) DEFAULT NULL,
  `roleid` varchar(8) DEFAULT NULL,
  `descirbes` varchar(50) DEFAULT NULL,
  `state` varchar(4) NOT NULL DEFAULT '1',
  `createdatetime` varchar(50) DEFAULT NULL,
  `updatedatetime` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='用户角色信息';

-- ----------------------------
-- Records of yxtc_framework_userrole
-- ----------------------------
INSERT INTO `yxtc_framework_userrole` VALUES ('2', '2', '1', null, '1', null, null);
INSERT INTO `yxtc_framework_userrole` VALUES ('3', '12', '2', null, '1', null, null);
INSERT INTO `yxtc_framework_userrole` VALUES ('4', '13', '3', null, '1', null, null);
INSERT INTO `yxtc_framework_userrole` VALUES ('8', '3', '2', null, '1', null, null);
INSERT INTO `yxtc_framework_userrole` VALUES ('9', '3', '3', null, '1', null, null);
INSERT INTO `yxtc_framework_userrole` VALUES ('10', '3', '4', null, '1', null, null);
INSERT INTO `yxtc_framework_userrole` VALUES ('11', '3', '4', null, '1', null, null);
INSERT INTO `yxtc_framework_userrole` VALUES ('12', '3', '4', null, '1', null, null);
INSERT INTO `yxtc_framework_userrole` VALUES ('13', '3', '4', null, '1', null, null);
INSERT INTO `yxtc_framework_userrole` VALUES ('14', '3', '3', null, '1', null, null);
INSERT INTO `yxtc_framework_userrole` VALUES ('15', '3', '2', null, '1', null, null);
INSERT INTO `yxtc_framework_userrole` VALUES ('16', '22', '1', null, '1', null, null);
