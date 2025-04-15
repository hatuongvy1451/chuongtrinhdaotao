* src/main/java:
- Model: Mô tả dữ liệu
Ví dụ: Cột Điểm có các thuộc tính như id, columnName, và weight.
- Repository: Tương tác với cơ sở dữ liệu để thực hiện các thao tác như lưu, tìm, xóa. 
Ví dụ: GradeColumnRepository giúp tìm kiếm và lưu trữ thông tin về các cột điểm.
- Service: Chứa các logic nghiệp vụ, gọi Repository để thao tác với dữ liệu. 
Ví dụ: GradeColumnService giúp thêm, cập nhật và xóa các cột điểm.
- Controller: Nhận và xử lý các yêu cầu HTTP từ người dùng, gọi Service để thực hiện các tác vụ và trả kết quả. 
Ví dụ: GradeColumnController giúp người dùng thao tác với các cột điểm qua API.

* src/main/resource:
- templates: giao diện html
- static: chứa các mục về img, css, js
- application.properties: cấu hình ứng dụng
