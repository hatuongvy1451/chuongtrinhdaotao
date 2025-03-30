-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th3 30, 2025 lúc 07:04 AM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `ctdaotao`
--
CREATE DATABASE IF NOT EXISTS `ctdaotao` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE `ctdaotao`;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ctdt_decuongchitiet`
--

CREATE TABLE `ctdt_decuongchitiet` (
  `id` int(11) NOT NULL,
  `id_hocphan` int(11) NOT NULL,
  `mo_ta` text NOT NULL,
  `muc_tieu` text NOT NULL,
  `chuong_noi_dung` text NOT NULL,
  `bo_phan_danh_gia` text NOT NULL,
  `ten_diem_danh_gia` text NOT NULL,
  `trong_so_danh_gia` float NOT NULL,
  `hinh_thuc_danh_gia` text NOT NULL,
  `tai_lieu_tham_khao` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `ctdt_decuongchitiet` 
(`id`, `id_hocphan`, `mo_ta`, `muc_tieu`, `chuong_noi_dung`, `bo_phan_danh_gia`, `ten_diem_danh_gia`, `trong_so_danh_gia`, `hinh_thuc_danh_gia`, `tai_lieu_tham_khao`) 
VALUES
-- Học phần 1: Triết học Mác-Lênin
(1, 1, 
'Học phần này cung cấp nguyên tắc cơ bản và cách tiếp cận của triết học Mác-Lênin.', 
'Giúp sinh viên hiểu và vận dụng các nguyên lý triết học vào phân tích thực tế.', 
'Chương 1: Khái niệm triết học\nChương 2: Phép biện chứng duy vật\nChương 3: Lịch sử triết học Mác', 
'Kiểm tra giữa kỳ và bài luận cuối kỳ', 
'Kiểm tra giữa kỳ', 30, 
'Trắc nghiệm và tự luận', 
'Triết học Mác-Lênin, NXB Giáo dục, 2021'),

-- Học phần 2: Kinh tế chính trị Mác-Lênin
(2, 2, 
'Nội dung cung cấp kiến thức về quy luật kinh tế và cơ sở lý luận kinh tế chính trị.', 
'Hiểu được mối quan hệ giữa sản xuất, phân phối, và tiêu dùng trong nền kinh tế.', 
'Chương 1: Quy luật giá trị\nChương 2: Lý thuyết lao động giá trị\nChương 3: Kinh tế vĩ mô theo Mác', 
'Bài tập nhóm và bài kiểm tra cuối kỳ', 
'Bài kiểm tra cuối kỳ', 40, 
'Tự luận và thuyết trình', 
'Kinh tế chính trị, NXB Chính trị Quốc gia, 2020'),

-- Học phần 3: Chủ nghĩa xã hội khoa học
(3, 3, 
'Học phần nghiên cứu về sự hình thành và phát triển của chủ nghĩa xã hội khoa học.', 
'Tăng cường khả năng phân tích các quan điểm lý luận về chủ nghĩa xã hội.', 
'Chương 1: Tư tưởng Mác về chủ nghĩa xã hội\nChương 2: Lịch sử phát triển CNXH\nChương 3: Ứng dụng CNXH vào thực tiễn', 
'Thuyết trình và bài kiểm tra cuối kỳ', 
'Thuyết trình', 50, 
'Bài tập nhóm', 
'Chủ nghĩa xã hội khoa học, NXB Giáo dục, 2021'),

-- Học phần 4: Giáo dục quốc phòng
(4, 4, 
'Giới thiệu các kiến thức cơ bản về quốc phòng và an ninh.', 
'Trang bị kỹ năng cơ bản và nâng cao ý thức trách nhiệm đối với quốc phòng.', 
'Chương 1: Kiến thức quốc phòng cơ bản\nChương 2: Quân sự căn bản\nChương 3: Quản lý quốc phòng', 
'Thực hành quân sự và bài kiểm tra cuối kỳ', 
'Thực hành quân sự', 40, 
'Thực hành và tự luận', 
'Tài liệu quốc phòng, NXB Quốc phòng, 2019'),

-- Học phần 5: Tiếng Anh cơ bản
(5, 5, 
'Học phần giúp sinh viên nâng cao kỹ năng nghe, nói, đọc, viết tiếng Anh ở mức cơ bản.', 
'Rèn luyện nền tảng ngoại ngữ phục vụ học tập và giao tiếp.', 
'Chương 1: Phát âm cơ bản\nChương 2: Ngữ pháp cơ bản\nChương 3: Viết luận cơ bản', 
'Bài tập nhóm và kiểm tra cuối kỳ', 
'Bài kiểm tra cuối kỳ', 30, 
'Trắc nghiệm và bài tập nhóm', 
'Tiếng Anh cơ bản, NXB Đại học Quốc gia, 2020'),

-- Học phần 6: Cơ sở lập trình
(6, 6, 
'Giới thiệu nền tảng lập trình bằng các ngôn ngữ lập trình cơ bản.', 
'Cung cấp kỹ năng tư duy logic và áp dụng giải thuật lập trình.', 
'Chương 1: Biến và kiểu dữ liệu\nChương 2: Vòng lặp và điều kiện\nChương 3: Xây dựng hàm', 
'Bài tập cá nhân và bài kiểm tra thực hành', 
'Bài kiểm tra thực hành', 40, 
'Thực hành và tự luận', 
'Lập trình cơ bản bằng C, NXB Khoa học, 2019'),

-- Học phần 7: Cơ sở dữ liệu
(7, 7, 
'Học phần cung cấp kiến thức cơ bản về thiết kế và tối ưu hóa cơ sở dữ liệu.', 
'Hiểu và áp dụng các mô hình dữ liệu trong thực tế.', 
'Chương 1: Tổng quan cơ sở dữ liệu\nChương 2: SQL cơ bản\nChương 3: Quản trị cơ sở dữ liệu', 
'Thực hành và đồ án cuối kỳ', 
'Đồ án cuối kỳ', 60, 
'Thực hành và báo cáo', 
'Cơ sở dữ liệu, NXB Khoa học Kỹ thuật, 2020'),

-- Học phần 8: Kiểm thử phần mềm
(8, 8, 
'Giới thiệu các phương pháp và công cụ kiểm thử phần mềm.', 
'Tăng cường kỹ năng kiểm thử, đảm bảo chất lượng sản phẩm.', 
'Chương 1: Kiểm thử chức năng\nChương 2: Kiểm thử hiệu năng\nChương 3: Công cụ kiểm thử', 
'Bài tập thực hành và bài kiểm tra giữa kỳ', 
'Kiểm tra giữa kỳ', 50, 
'Thực hành và tự luận', 
'Kiểm thử phần mềm, NXB Công nghệ, 2018'),

-- Học phần 9: Xây dựng phần mềm theo mô hình phân lớp
(9, 9, 
'Khóa học tập trung vào thiết kế và phát triển phần mềm theo mô hình phân lớp.', 
'Nâng cao kỹ năng lập trình phần mềm hiện đại.', 
'Chương 1: Phân tích yêu cầu\nChương 2: Thiết kế lớp xử lý\nChương 3: Triển khai và kiểm thử', 
'Đồ án nhóm và bài kiểm tra cuối kỳ', 
'Đồ án cuối kỳ', 50, 
'Thực hành và báo cáo', 
'Thiết kế phần mềm phân lớp, NXB Khoa học, 2019'),

-- Học phần 10: Đồ án tốt nghiệp
(10, 10, 
'Nội dung yêu cầu sinh viên thực hiện một dự án thực tế.', 
'Hoàn thiện kỹ năng thiết kế, lập trình và phân tích dự án.', 
'Chương 1: Lập kế hoạch dự án\nChương 2: Thực thi dự án\nChương 3: Báo cáo và đánh giá', 
'Báo cáo đồ án và thuyết trình', 
'Báo cáo đồ án', 100, 
'Thuyết trình và phản biện', 
'Tài liệu tham khảo tùy theo đề tài.');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ctdt_giangvien`
--

CREATE TABLE `ctdt_giangvien` (
  `id` int(11) NOT NULL,
  `ma_giang_vien` varchar(50) NOT NULL,
  `ten_giang_vien` varchar(255) NOT NULL,
  `chuyen_mon` varchar(255) NOT NULL,
  `loai_giang_vien` int(11) NOT NULL COMMENT '0: Thỉnh giảng, 1: Cơ hữu'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `ctdt_giangvien` (`id`, `ma_giang_vien`, `ten_giang_vien`, `chuyen_mon`, `loai_giang_vien`) 
VALUES
(1, 'GV001', 'Lê Minh D', 'Lập trình phần mềm nâng cao', 1), -- Cơ hữu
(2, 'GV002', 'Hoàng Ngọc E', 'Hệ thống thông tin', 1), -- Cơ hữu
(3, 'GV003', 'Nguyễn Văn F', 'Mạng máy tính và bảo mật', 1), -- Cơ hữu
(4, 'GV004', 'Dương Văn J', 'Phát triển ứng dụng web', 1), -- Cơ hữu
(5, 'GV005', 'Nguyễn Văn A', 'Trí tuệ nhân tạo và Học máy', 1), -- Cơ hữu
(6, 'GV006', 'Phạm Thị L', 'Hệ thống nhúng', 1), -- Cơ hữu
(7, 'GV007', 'Ngô Văn H', 'Bảo mật và an toàn thông tin', 0), -- Thỉnh giảng
(8, 'GV008', 'Lê Thị Thúy H', 'Blockchain và Công nghệ số', 0), -- Thỉnh giảng
(9, 'GV009', 'Trần Đức M', 'Phân tích dữ liệu lớn (Big Data)', 0), -- Thỉnh giảng
(10, 'GV010', 'Hoàng Gia N', 'Lập trình di động', 0); -- Thỉnh giảng

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ctdt_hocphan`
--

CREATE TABLE `ctdt_hocphan` (
  `id` int(11) NOT NULL,
  `id_khungct` int(11) NOT NULL,
  `ma_hoc_phan` varchar(50) NOT NULL,
  `ten_hoc_phan` varchar(255) NOT NULL,
  `so_tin_chi` int(11) NOT NULL,
  `so_tiet_ly_thuyet` int(11) DEFAULT NULL,
  `so_tiet_thuc_hanh` int(11) DEFAULT NULL,
  `so_tiet_thuc_tap` int(11) DEFAULT NULL,
  `so_tiet_cong` int(11) NOT NULL,
  `he_so_hocphan` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `ctdt_hocphan` 
(`id`, `id_khungct`, `ma_hoc_phan`, `ten_hoc_phan`, `so_tin_chi`, `so_tiet_ly_thuyet`, 
`so_tiet_thuc_hanh`, `so_tiet_thuc_tap`, `so_tiet_cong`, `he_so_hocphan`) 
VALUES
-- Khối Đại cương (id_khungct = 1)
(1, 1, 'DC001', 'Triết học Mác-Lênin', 3, 30, 0, 0, 30, 1),
(2, 1, 'DC002', 'Kinh tế chính trị Mác-Lênin', 2, 20, 0, 0, 20, 1),
(3, 1, 'DC003', 'Chủ nghĩa xã hội khoa học', 2, 20, 0, 0, 20, 1),
(4, 1, 'DC004', 'Giáo dục quốc phòng', 2, 20, 0, 0, 20, 1),
(5, 1, 'DC005', 'Tiếng Anh cơ bản', 3, 30, 0, 0, 30, 1),

-- Khối Cơ sở ngành (id_khungct = 2)
(6, 2, 'CSN001', 'Cơ sở lập trình', 3, 20, 10, 0, 30, 1),
(7, 2, 'CSN002', 'Cơ sở dữ liệu', 4, 30, 15, 0, 45, 1),

-- Khối Chuyên ngành (id_khungct = 3)
(8, 3, 'CN001', 'Kiểm thử phần mềm', 4, 30, 20, 0, 50, 1),
(9, 3, 'CN002', 'Xây dựng phần mềm theo mô hình phân lớp', 4, 30, 20, 0, 50, 1),

-- Khối Tốt nghiệp (id_khungct = 4)
(10, 4, 'TN001', 'Đồ án tốt nghiệp', 5, 50, 0, 0, 50, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ctdt_kehoachdayhoc`
--

CREATE TABLE `ctdt_kehoachdayhoc` (
  `id` int(11) NOT NULL,
  `id_hocphan` int(11) NOT NULL,
  `hoc_ky_thuc_hien` int(11) NOT NULL,
  `ma_hocphan_truoc` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `ctdt_kehoachdayhoc` (`id`, `id_hocphan`, `hoc_ky_thuc_hien`, `ma_hocphan_truoc`) 
VALUES
-- Khối Đại cương (id_khungct = 1)
(1, 1, 1, NULL), -- Triết học Mác-Lênin (học kỳ 1, không có học phần tiên quyết)
(2, 2, 1, NULL), -- Kinh tế chính trị Mác-Lênin (học kỳ 1, không có học phần tiên quyết)
(3, 3, 2, 'DC001'), -- Chủ nghĩa xã hội khoa học (học kỳ 2, cần hoàn thành Triết học)
(4, 4, 1, NULL), -- Giáo dục quốc phòng (học kỳ 1, không có học phần tiên quyết)
(5, 5, 2, NULL), -- Tiếng Anh cơ bản (học kỳ 2, không có học phần tiên quyết)

-- Khối Cơ sở ngành (id_khungct = 2)
(6, 6, 2, NULL), -- Cơ sở lập trình (học kỳ 2, không có học phần tiên quyết)
(7, 7, 3, 'CSN001'), -- Cơ sở dữ liệu (học kỳ 3, cần hoàn thành Cơ sở lập trình)

-- Khối Chuyên ngành (id_khungct = 3)
(8, 8, 4, 'CSN002'), -- Kiểm thử phần mềm (học kỳ 4, cần hoàn thành Cơ sở dữ liệu)
(9, 9, 5, 'CN001'), -- Xây dựng phần mềm theo mô hình phân lớp (học kỳ 5, cần hoàn thành Kiểm thử phần mềm)

-- Khối Tốt nghiệp (id_khungct = 4)
(10, 10, 6, 'CN002'); -- Đồ án tốt nghiệp (học kỳ 6, cần hoàn thành Xây dựng phần mềm theo mô hình phân lớp)

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ctdt_kehoachmonhom`
--

CREATE TABLE `ctdt_kehoachmonhom` (
  `id` int(11) NOT NULL,
  `id_hocphan` int(11) NOT NULL,
  `nam_hoc` varchar(255) NOT NULL,
  `so_nhom` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `ctdt_kehoachmonhom` (`id`, `id_hocphan`, `nam_hoc`, `so_nhom`) 
VALUES
(1, 1, '2025-2026', 4), -- Triết học Mác-Lênin
(2, 2, '2025-2026', 3), -- Kinh tế chính trị Mác-Lênin
(3, 3, '2025-2026', 3), -- Chủ nghĩa xã hội khoa học
(4, 4, '2025-2026', 2), -- Giáo dục quốc phòng
(5, 5, '2025-2026', 3), -- Tiếng Anh cơ bản
(6, 6, '2025-2026', 4), -- Cơ sở lập trình
(7, 7, '2025-2026', 5), -- Cơ sở dữ liệu
(8, 8, '2025-2026', 4), -- Kiểm thử phần mềm
(9, 9, '2025-2026', 4), -- Xây dựng phần mềm theo mô hình phân lớp
(10, 10, '2025-2026', 2); -- Đồ án tốt nghiệp

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ctdt_khungchuongtrinh`
--

CREATE TABLE `ctdt_khungchuongtrinh` (
  `id` int(11) NOT NULL,
  `id_thongtin` int(11) NOT NULL,
  `ten_khoi` varchar(255) NOT NULL,
  `loai_khoi` varchar(255) NOT NULL,
  `tin_chi_bat_buoc` int(11) NOT NULL,
  `tin_chi_tu_chon` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `ctdt_khungchuongtrinh` (`id`, `id_thongtin`, `ten_khoi`, `loai_khoi`, `tin_chi_bat_buoc`, `tin_chi_tu_chon`) 
VALUES
(1, 1, 'Khối kiến thức Đại cương', 'Cơ bản', 35, 5), 
(2, 1, 'Khối kiến thức Cơ sở ngành', 'Nền tảng', 45, 10), 
(3, 1, 'Khối kiến thức Chuyên ngành', 'Chuyên sâu', 55, 15), 
(4, 1, 'Khối kiến thức Tốt nghiệp', 'Tốt nghiệp', 15, 0), 
(5, 1, 'Khối kiến thức Tự chọn mở rộng', 'Tự chọn', 0, 15);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ctdt_phanconggiangday`
--

CREATE TABLE `ctdt_phanconggiangday` (
  `id` int(11) NOT NULL,
  `id_giangvien` int(11) NOT NULL,
  `id_hocphan` int(11) NOT NULL,
  `hoc_ky` int(11) NOT NULL,
  `so_tiet_thuc_hien` int(11) NOT NULL,
  `so_tiet_thuc_te` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `ctdt_phanconggiangday` 
(`id`, `id_giangvien`, `id_hocphan`, `hoc_ky`, `so_tiet_thuc_hien`, `so_tiet_thuc_te`) 
VALUES
-- Phân công giảng dạy các học phần Đại cương
(1, 1, 1, 1, 30, 30), 
(2, 2, 2, 1, 20, 20), 
(3, 3, 3, 2, 20, 20), 
(4, 4, 4, 1, 20, 20), 
(5, 5, 5, 2, 30, 30), 

-- Phân công giảng dạy các học phần Cơ sở ngành
(6, 6, 6, 2, 30, 30), 
(7, 7, 7, 3, 45, 45), 

-- Phân công giảng dạy các học phần Chuyên ngành
(8, 8, 8, 4, 50, 50), 
(9, 9, 9, 5, 50, 50),

-- Phân công giảng dạy học phần Tốt nghiệp
(10, 10, 10, 6, 50, 50); 

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ctdt_thongtinchung`
--

CREATE TABLE `ctdt_thongtinchung` (
  `id` int(11) NOT NULL,
  `ma_ctdt` varchar(50) NOT NULL,
  `ten_ctdt` varchar(255) NOT NULL,
  `bac_dao_tao` varchar(255) NOT NULL,
  `loai_bang` varchar(255) NOT NULL,
  `loai_hinh_dao_tao` varchar(255) NOT NULL,
  `thoi_gian_dao_tao` decimal(3,1) NOT NULL,
  `tin_chi_toi_thieu` int(11) NOT NULL,
  `khoa_quan_ly` varchar(255) NOT NULL,
  `ngon_ngu` varchar(255) NOT NULL,
  `website` varchar(255) DEFAULT NULL,
  `ban_hanh` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `ctdt_thongtinchung` 
(`id`, `ma_ctdt`, `ten_ctdt`, `bac_dao_tao`, `loai_bang`, `loai_hinh_dao_tao`, `thoi_gian_dao_tao`, 
`tin_chi_toi_thieu`, `khoa_quan_ly`, `ngon_ngu`, `website`, `ban_hanh`) 
VALUES
(1, 'CNTT', 'Chương trình đào tạo ngành Công nghệ thông tin', 'Đại học, Bậc 7/8 đối với đào tạo kỹ sư', 
'Kỹ sư', 'Chính quy', 4.5, 155, 'Công nghệ thông tin', 'Tiếng Việt', 
'http://fit.sgu.edu.vn/', 
'Theo Quyết định số ........./QĐ-ĐHSG ngày .... tháng .... năm 2020 của Hiệu trưởng Trường Đại học Sài Gòn'
),
(2, 'KT', 'Chương trình đào tạo ngành Kế toán', 'Đại học', 'Cử nhân', 'Chính quy', 4.0, 135, 'Khoa Kế toán', 'Tiếng Việt', 
'http://accounting.sgu.edu.vn/', 
'Theo Quyết định số ........./QĐ-ĐHSG ngày .... tháng .... năm 2020 của Hiệu trưởng Trường Đại học Sài Gòn'
),
(3, 'QTKD', 'Chương trình đào tạo ngành Quản trị Kinh doanh', 'Đại học', 'Cử nhân', 'Chính quy', 4.0, 140, 'Khoa Quản trị Kinh doanh', 'Tiếng Việt', 
'http://business.sgu.edu.vn/', 
'Theo Quyết định số ........./QĐ-ĐHSG ngày .... tháng .... năm 2020 của Hiệu trưởng Trường Đại học Sài Gòn'
),
(4, 'SP', 'Chương trình đào tạo ngành Sư phạm Toán học', 'Đại học', 'Cử nhân Sư phạm', 'Chính quy', 4.5, 150, 'Khoa Sư phạm', 'Tiếng Việt', 
'http://education.sgu.edu.vn/', 
'Theo Quyết định số ........./QĐ-ĐHSG ngày .... tháng .... năm 2020 của Hiệu trưởng Trường Đại học Sài Gòn'
),
(5, 'NN', 'Chương trình đào tạo ngành Ngôn ngữ Anh', 'Đại học', 'Cử nhân', 'Chính quy', 4.0, 130, 'Khoa Ngôn ngữ Anh', 'Tiếng Anh', 
'http://english.sgu.edu.vn/', 
'Theo Quyết định số ........./QĐ-ĐHSG ngày .... tháng .... năm 2020 của Hiệu trưởng Trường Đại học Sài Gòn'
);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ctdt_user`
--

CREATE TABLE `ctdt_user` (
  `id` int(11) NOT NULL,
  `ten_dang_nhap` varchar(255) NOT NULL,
  `mat_khau` varchar(255) NOT NULL,
  `ho_ten` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `vai_tro` int(11) NOT NULL COMMENT '0: Sinh viên, 1: Giảng viên, 2: Quản trị viên'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `ctdt_user` (`id`, `ten_dang_nhap`, `mat_khau`, `ho_ten`, `email`, `vai_tro`) 
VALUES
-- Sinh viên (vai_tro = 0)
(1, 'ngocan', '123456', 'Nguyễn Ngọc An', 'nguyenngocan@gmail.com', 0), 
(2, 'thuhuyen', '123456', 'Trần Thị Thu Huyền', 'tranthithuhuyen@gmail.com', 0), 
(3, 'huynhnhu', '123456', 'Võ Ngọc Huỳnh Như', 'vongochuynhnhu@gmail.com', 0), 
(4, 'kimngan', '123456', 'Nguyễn Lê Kim Ngân', 'nguyenlekimngan@gmail.com', 0),
(5, 'tuongvy', '123456', 'Hà Tường Vy', 'hatuongvy@gmail.com', 0),

-- Giảng viên (vai_tro = 1)
(6, 'giangvien001', '123456', 'Lê Minh D', 'leminhd@gmail.com', 1), 
(7, 'giangvien002', '123456', 'Hoàng Ngọc E', 'hoangngoc@gmail.com', 1), 
(8, 'giangvien003', '123456', 'Nguyễn Văn F', 'nguyenvanf@gmail.com', 1), 
(9, 'giangvien004', '123456', 'Dương Văn J', 'duongvanj@gmail.com', 1),
(10, 'giangvien005', '123456', 'Nguyễn Văn A', 'nguyenvana@gmail.com', 1),
(11, 'giangvien006', '123456', 'Phạm Thị L', 'phamthil@gmail.com', 1), 
(12, 'giangvien007', '123456', 'Ngô Văn H', 'ngovanh@gmail.com', 1), 
(13, 'giangvien008', '123456', 'Lê Thị Thúy H', 'lethithuyh@gmail.com', 1), 
(14, 'giangvien009', '123456', 'Trần Đức M', 'tranducm@gmail.com', 1),
(15, 'giangvien010', '123456', 'Hoàng Gia N', 'hoangian@gmail.com', 1),

-- Quản trị viên (vai_tro = 2)
(16, 'admin001', '123456', 'Võ Đức G', 'voducg@example.com', 2), 
(17, 'admin002', '123456', 'Bùi Thị H', 'buithih@example.com', 2);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `ctdt_decuongchitiet`
--
ALTER TABLE `ctdt_decuongchitiet`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_hocphan_dcct` (`id_hocphan`);

--
-- Chỉ mục cho bảng `ctdt_giangvien`
--
ALTER TABLE `ctdt_giangvien`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `ma_gv_unique` (`ma_giang_vien`);

--
-- Chỉ mục cho bảng `ctdt_hocphan`
--
ALTER TABLE `ctdt_hocphan`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `ma_hoc_phan_unique` (`ma_hoc_phan`),
  ADD KEY `fk_khungct_hocphan` (`id_khungct`);

--
-- Chỉ mục cho bảng `ctdt_kehoachdayhoc`
--
ALTER TABLE `ctdt_kehoachdayhoc`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_hocphan_khdh` (`id_hocphan`);

--
-- Chỉ mục cho bảng `ctdt_kehoachmonhom`
--
ALTER TABLE `ctdt_kehoachmonhom`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_hocphan_khmn` (`id_hocphan`);

--
-- Chỉ mục cho bảng `ctdt_khungchuongtrinh`
--
ALTER TABLE `ctdt_khungchuongtrinh`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_thongtin_khungct` (`id_thongtin`);

--
-- Chỉ mục cho bảng `ctdt_phanconggiangday`
--
ALTER TABLE `ctdt_phanconggiangday`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_giangvien_pcgd` (`id_giangvien`),
  ADD KEY `fk_hocphan_pcgd` (`id_hocphan`);

--
-- Chỉ mục cho bảng `ctdt_thongtinchung`
--
ALTER TABLE `ctdt_thongtinchung`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `ma_ctdt_unique` (`ma_ctdt`);

--
-- Chỉ mục cho bảng `ctdt_user`
--
ALTER TABLE `ctdt_user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `ctdt_decuongchitiet`
--
ALTER TABLE `ctdt_decuongchitiet`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `ctdt_giangvien`
--
ALTER TABLE `ctdt_giangvien`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `ctdt_hocphan`
--
ALTER TABLE `ctdt_hocphan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `ctdt_kehoachdayhoc`
--
ALTER TABLE `ctdt_kehoachdayhoc`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `ctdt_kehoachmonhom`
--
ALTER TABLE `ctdt_kehoachmonhom`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `ctdt_khungchuongtrinh`
--
ALTER TABLE `ctdt_khungchuongtrinh`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `ctdt_phanconggiangday`
--
ALTER TABLE `ctdt_phanconggiangday`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `ctdt_thongtinchung`
--
ALTER TABLE `ctdt_thongtinchung`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `ctdt_user`
--
ALTER TABLE `ctdt_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `ctdt_decuongchitiet`
--
ALTER TABLE `ctdt_decuongchitiet`
  ADD CONSTRAINT `fk_hocphan_dcct` FOREIGN KEY (`id_hocphan`) REFERENCES `ctdt_hocphan` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `ctdt_hocphan`
--
ALTER TABLE `ctdt_hocphan`
  ADD CONSTRAINT `fk_khungct_hocphan` FOREIGN KEY (`id_khungct`) REFERENCES `ctdt_khungchuongtrinh` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `ctdt_kehoachdayhoc`
--
ALTER TABLE `ctdt_kehoachdayhoc`
  ADD CONSTRAINT `fk_hocphan_khdh` FOREIGN KEY (`id_hocphan`) REFERENCES `ctdt_hocphan` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `ctdt_kehoachmonhom`
--
ALTER TABLE `ctdt_kehoachmonhom`
  ADD CONSTRAINT `fk_hocphan_khmn` FOREIGN KEY (`id_hocphan`) REFERENCES `ctdt_hocphan` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `ctdt_khungchuongtrinh`
--
ALTER TABLE `ctdt_khungchuongtrinh`
  ADD CONSTRAINT `fk_thongtin_khungct` FOREIGN KEY (`id_thongtin`) REFERENCES `ctdt_thongtinchung` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `ctdt_phanconggiangday`
--
ALTER TABLE `ctdt_phanconggiangday`
  ADD CONSTRAINT `fk_giangvien_pcgd` FOREIGN KEY (`id_giangvien`) REFERENCES `ctdt_giangvien` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_hocphan_pcgd` FOREIGN KEY (`id_hocphan`) REFERENCES `ctdt_hocphan` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
