1. Singleton là gì ?
    - Singleton là một mẫu thiết kế (Design pattern) đảm bảo rằng một class chỉ có một thể hiện, đồng thời cung cấp một điểm truy cập chung cho phiên bản này.

2. Tại sao lại dùng Singleton ?
    - Kiểm soát được số kết nối của ứng dụng với tài nguyên hạn chế
    - Tối ưu tài nguyên bộ nhớ, thay vì khởi tạo object mới thì dùng lại object cũ

3. Khi nào dùng Singleton ?
    - Khi cần một và chỉ một thể hiện của class trong toàn bộ ứng dụng.
    - Khi muốn chia sẻ trạng thái hoặc dữ liệu giữa các phần khác nhau của ứng dụng.

4. Use case có thể áp dụng Singleton:
    - Kết nối database 
    - hàm logger trong ứng dụng
    - Config global trong ứng dụng
