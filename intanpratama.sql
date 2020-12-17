# Host: localhost  (Version: 5.5.8)
# Date: 2020-12-18 00:36:45
# Generator: MySQL-Front 5.3  (Build 4.81)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "dt_keluar"
#

DROP TABLE IF EXISTS `dt_keluar`;
CREATE TABLE `dt_keluar` (
  `iddetailkeluar` varchar(11) NOT NULL DEFAULT '',
  `idkeluar` varchar(11) DEFAULT NULL,
  `tanggal` date DEFAULT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `harga` int(11) DEFAULT NULL,
  `jumlah` int(11) DEFAULT NULL,
  `total` int(11) DEFAULT NULL,
  `stok` int(11) DEFAULT NULL,
  PRIMARY KEY (`iddetailkeluar`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "dt_keluar"
#

INSERT INTO `dt_keluar` VALUES ('DT001','T001','2020-12-14','Keramik Manise',110000,1200,132000000,120),('DT002','T002','2020-12-16','Keramik Manise',110000,2200,11000000,300),('DT003','T003','2020-12-17','Keramik Manise',110000,2000,220000000,2160),('DT004','T004','2020-12-18','Keramik Manise',110000,2,220000,160);

#
# Structure for table "dt_masuk"
#

DROP TABLE IF EXISTS `dt_masuk`;
CREATE TABLE `dt_masuk` (
  `iddetailmasuk` varchar(20) NOT NULL DEFAULT '',
  `idmasuk` varchar(20) DEFAULT NULL,
  `idbarang` varchar(20) DEFAULT NULL,
  `tanggal` date DEFAULT NULL,
  `jumlah` int(11) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`iddetailmasuk`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "dt_masuk"
#

INSERT INTO `dt_masuk` VALUES ('DT-IN0001','IN-0001','B0001','2020-12-03',600,'Selesai'),('DT-IN0002','IN-0001','B0002','2020-12-03',1200,'Selesai'),('DT-IN0003','IN-0002','B0001','2020-12-03',400,'Proses'),('DT-IN0004','IN-0003','B0001','2020-12-03',500,'Selesai'),('DT-IN0005','IN-0004','B0002','2020-12-14',1000,'Proses'),('DT-IN0006','IN-0005','B0001','2020-12-17',2000,'Proses');

#
# Structure for table "tb_admin"
#

DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin` (
  `username` varchar(50) NOT NULL DEFAULT '',
  `password` varchar(50) DEFAULT NULL,
  `konfirmasi` varchar(50) DEFAULT NULL,
  `role` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "tb_admin"
#

INSERT INTO `tb_admin` VALUES ('steven123','12345','12345','admin');

#
# Structure for table "tb_barang"
#

DROP TABLE IF EXISTS `tb_barang`;
CREATE TABLE `tb_barang` (
  `idbarang` varchar(11) NOT NULL DEFAULT '',
  `nama` varchar(255) DEFAULT NULL,
  `kategori` varchar(50) DEFAULT NULL,
  `satuan` varchar(255) DEFAULT NULL,
  `hargabeli` int(11) DEFAULT NULL,
  `hargajual` int(11) DEFAULT NULL,
  `stok` int(11) DEFAULT NULL,
  `minstok` int(11) DEFAULT NULL,
  PRIMARY KEY (`idbarang`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "tb_barang"
#

INSERT INTO `tb_barang` VALUES ('B0001','Keramik Manise','Keramik','KOTAK',110000,130000,158,20),('B0002','Keramik Gajah','Keramik','Kotak',130000,150000,130,10);

#
# Structure for table "tb_kategori"
#

DROP TABLE IF EXISTS `tb_kategori`;
CREATE TABLE `tb_kategori` (
  `kategori` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`kategori`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "tb_kategori"
#

INSERT INTO `tb_kategori` VALUES ('Keramik'),('Manise'),('Pot');

#
# Structure for table "tb_pelanggan"
#

DROP TABLE IF EXISTS `tb_pelanggan`;
CREATE TABLE `tb_pelanggan` (
  `idpelanggan` varchar(11) NOT NULL DEFAULT '',
  `nama` varchar(50) DEFAULT NULL,
  `kontak` varchar(12) DEFAULT NULL,
  `alamat` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idpelanggan`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "tb_pelanggan"
#

INSERT INTO `tb_pelanggan` VALUES ('P0000001','Moeldoko','081978765555','Batu 2');

#
# Structure for table "tb_prediksi"
#

DROP TABLE IF EXISTS `tb_prediksi`;
CREATE TABLE `tb_prediksi` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `tanggal` varchar(50) DEFAULT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `harga` int(11) DEFAULT NULL,
  `jumlah` int(11) DEFAULT NULL,
  `stok` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

#
# Data for table "tb_prediksi"
#

INSERT INTO `tb_prediksi` VALUES (1,'2020-12-14','Keramik Manise',110000,1200,120),(2,'2020-12-16','Keramik Manise',110000,2200,140),(3,'2020-12-17','Keramik Manise',110000,2000,170);

#
# Structure for table "tb_supplier"
#

DROP TABLE IF EXISTS `tb_supplier`;
CREATE TABLE `tb_supplier` (
  `idsupplier` varchar(11) NOT NULL DEFAULT '0',
  `nama` varchar(50) DEFAULT NULL,
  `kontak` varchar(12) DEFAULT NULL,
  `alamat` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idsupplier`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "tb_supplier"
#

INSERT INTO `tb_supplier` VALUES ('S0001','Cv. Tuah Jaya Perdana','081277618851','Jl. Ganet Perum Catur No,208'),('S0002','PT. Utama','980101011','Batu 2');

#
# Structure for table "tr_barang"
#

DROP TABLE IF EXISTS `tr_barang`;
CREATE TABLE `tr_barang` (
  `idtransaksibarang` varchar(11) NOT NULL DEFAULT '',
  `idbarang` varchar(11) DEFAULT NULL,
  `kategori` varchar(50) DEFAULT NULL,
  `satuan` varchar(255) DEFAULT NULL,
  `tanggal` date DEFAULT NULL,
  `idsupplier` varchar(11) DEFAULT NULL,
  `jumlah` int(11) DEFAULT NULL,
  PRIMARY KEY (`idtransaksibarang`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "tr_barang"
#

INSERT INTO `tr_barang` VALUES ('TRB0001','B0001','Keramik','KOTAK','2020-08-03','S0001',30),('TRB0002','B0002','Keramik','Kotak','2020-08-03','S0001',20),('TRB0003','B0001','Keramik','KOTAK','2020-08-03','S0002',40),('TRB0004','B0001','Keramik','KOTAK','2020-08-03','S0001',5),('TRB0005','B0002','Keramik','Kotak','2020-12-14','S0001',40),('TRB0006','B0002','Keramik','Kotak','2020-12-14','S0001',20),('TRB0007','B0002','Keramik','Kotak','2020-12-14','S0001',30),('TRB0008','B0002','Keramik','Kotak','2020-12-14','S0001',10),('TRB0009','B0002','Keramik','Kotak','2020-12-01','S0001',10),('TRB0010','B0001','Keramik','KOTAK','2020-12-03','S0001',10),('TRB0011','B0001','Keramik','KOTAK','2020-12-17','S0001',2000);

#
# Structure for table "tr_keluar"
#

DROP TABLE IF EXISTS `tr_keluar`;
CREATE TABLE `tr_keluar` (
  `idkeluar` varchar(11) NOT NULL DEFAULT '',
  `tanggal` date DEFAULT NULL,
  `jumlah` int(11) DEFAULT NULL,
  `total` int(11) DEFAULT NULL,
  `bayar` int(11) DEFAULT NULL,
  `kembalian` int(11) DEFAULT NULL,
  `pelanggan` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`idkeluar`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "tr_keluar"
#

INSERT INTO `tr_keluar` VALUES ('T001','2020-12-14',1200,132000000,132000000,0,'Moeldoko'),('T002','2020-12-16',100,11000000,11000000,0,'Moeldoko'),('T003','2020-12-17',2000,220000000,220000000,0,'Moeldoko'),('T004','2020-12-18',2,220000,250000,30000,'Moeldoko');

#
# Structure for table "tr_masuk"
#

DROP TABLE IF EXISTS `tr_masuk`;
CREATE TABLE `tr_masuk` (
  `idmasuk` varchar(11) NOT NULL DEFAULT '',
  `tanggal` date DEFAULT NULL,
  `jumlah` int(11) DEFAULT NULL,
  `idsupplier` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`idmasuk`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "tr_masuk"
#

INSERT INTO `tr_masuk` VALUES ('IN-0001','2020-12-03',1800,'S0001'),('IN-0002','2020-12-03',1300,'S0002'),('IN-0003','2020-12-03',1200,'S0001'),('IN-0004','2020-12-14',1000,'S0001'),('IN-0005','2020-12-17',2000,'S0001');
