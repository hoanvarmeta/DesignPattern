1. Factory method là gì ?
    - Factory method là một mẫu thiết kế (Design Pattern) thuộc nhóm Creational Design Patterns, cung cấp interface để tạo object ở supperclass, cho phép tạo các đối tượng thông qua một phương thức mà không cần sử dụng trực tiếp từ khóa new và được quyết định kiểu class được trả về.

2. Tại sao lại dùng Factory method ?
    - Tách biệt logic khởi tạo, giúp thêm các class mới mà không ảnh hưởng tới logic cũ
    - Các class product implements interface giúp giảm sự phụ thuộc, kiểu trả về của factory method là nhiều kiểu object miễn là class đó implements cùng 1 interface

3. Dùng Factory Methods khi nào ?
    - Khi có nhiều class có cùng interface, sẽ mở rộng và bảo trì trong tương lai.
    - Dùng khi có nhiều option cho một cùng một chức năng

4. Use case có thể áp dụng Factory method là các use case có nhiều option
    - Trong lựa chọn phương thức thanh toán
    - Trong lựa chọn network kết nối
    - Trong lựa chọn dữ liệu trả về khi sử dụng các thiết bị khác nhau