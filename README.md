
Program CRUD CLI Java OOP Menggunakan MySQL


Buat DB dan Tabel Dibawah ini
===========================================================

--
-- Database: `si_tokohp`
--

-- --------------------------------------------------------

--
-- Table structure for table `product_hp`
--

CREATE TABLE `product_hp` (
  `productId` int(4) NOT NULL,
  `productCategory` varchar(250) NOT NULL,
  `productName` varchar(250) NOT NULL,
  `price` double(15,2) NOT NULL,
  `qty` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------
 
--
-- SILAKAN BUAT FILE BARU DENGAN KASUS YANG BERBEDA
--
===========================================================


Keterangan Tambahan:
Tambahkan Dependencies mysql-connector-java-8.0.28.jar pada Project Baru anda
