1. Abstract Factory là gì ?
    - Factory method là một mẫu thiết kế (Design Pattern) thuộc nhóm Creational Design Patterns, phép bạn tạo ra các nhóm đối tượng liên quan mà không cần chỉ định các lớp cụ thể của chúng

2. Tại sao lại dùng Abstract Factory ?
    - Đảm bảo tính nhất quán ,khi gọi tạo class từ một factory sẽ cùng họ, đảm bảo chúng được sử dụng cùng ngữ cảnh
    - Abstract Factory tách biệt logic khởi tạo đối tượng khỏi việc sử dụng đối tượng giúp giảm sự phụ thuộc, tạo ra một họ các đối tượng liên quan mà không chỉ rõ lớp cụ thể của chúng.
    - Khi có họ mới cần triển khai chỉ cần thêm class mới của chúng và thêm 1 facotory implement từ interface đã định nghĩa

3. Dùng Abstract Factory khi nào ?
    - Khi hệ thống có nhiều biến thể (họ) muốn thay đổi hoặc thêm các class mới mà không cần thay đổi logic cũ

4. Use case có thể áp dụng Abstract Factory là các use case có nhiều option
    - Trong ứng dụng đa ngôn ngữ
    - Trong ứng dụng hỗi trợ tốt các nền tảng khác nhau
    - Trong lựa chọn phương thức thanh toán