1. Builder là gì ?
    - Builder là mẫu thiết kế (Design Pattern) thuộc nhóm Creational Design Patterns, cho phép tạo các object phức tạp theo từng bước, cho phép tạo các loại và cách trình bày khác nhau của một đối tượng bằng cách sử dụng cùng một mã cấu trúc.
2. Tại sao lại dùng Builder ?
    - Khi việc tạo một đối tượng yêu cầu nhiều bước hoặc cấu hình, Builder giúp chia nhỏ quy trình thành các bước rõ ràng
    - Không sử dụng trực tiếp contructor để tạo đối tượng mà dùng thông qua các setter của lớp builder giúp code rõ dàng
3. Khi nào dùng bilder
    - Khi cần tạo một đối tượng phức tạp với nhiều bước và tùy chọn cấu hình
4. Use case có thể áp dụng Builder :
    - Tạo truy vấn cơ sở dữ liệu (CreateQueryBuilder trong Typeorm)
    - Usecase tạo giao diện tuỳ chọn
    - Tạo request https gồm nhiều phần, header, method, body, query , param, 
