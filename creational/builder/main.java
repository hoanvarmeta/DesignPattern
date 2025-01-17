package creational.builder;

class LoginInfo {
    String username;
    String password;

    public LoginInfo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void print() {
        System.out.println("username: " + this.username + ", password: " + this.password);
    }
}

class Account {
    private static int current = 0;
    private int id;
    private String firstNamee;
    private String lastName;
    private int age;
    private LoginInfo loginInfo;

    Account(String firstNamee, String lastName, int age, LoginInfo loginInfo) {
        this.id = ++this.current;
        this.firstNamee = firstNamee;
        this.lastName = lastName;
        this.age = age;
        this.loginInfo = loginInfo;
    }

    public void print() {
        System.out.println("Id: " + this.id + ", firstName: " + this.firstNamee + ", lastName: " + this.lastName
                + ", age: " + this.age);
        this.loginInfo.print();
    }
}

interface Builder {
    void setFirstName(String firstName);

    void setLastName(String lastName);

    void setAge(int age);

    void setLoginInfo(LoginInfo loginInfo);
}

class UserTestBuilder implements Builder {
    private String firstNamee;
    private String lastName;
    private int age;
    private LoginInfo loginInfo;

    public void setFirstName(String firstName) {
        this.firstNamee = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setLoginInfo(LoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }

    public Account Build() {
        return new Account(this.firstNamee, this.lastName, this.age, this.loginInfo);
    }

}

class AdminTestBuilder implements Builder {
    private String firstNamee;
    private String lastName;
    private int age;
    private LoginInfo loginInfo;

    public void setFirstName(String firstName) {
        this.firstNamee = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setLoginInfo(LoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }

    public Account Build() {
        return new Account(this.firstNamee, this.lastName, this.age, this.loginInfo);
    }

}

class Director {
    public void constructUserTest(UserTestBuilder builder) {
        builder.setFirstName("John");
        builder.setLastName("Doe");
        builder.setAge(30);
        builder.setLoginInfo(new LoginInfo("johndoe", "password"));
    }

    public void constructAdminTest(AdminTestBuilder builder) {
        builder.setFirstName("Admin");

        builder.setAge(20);
        builder.setLoginInfo(new LoginInfo("admin", "password"));
    }
}

public class main {
    public static void main(String[] args) {
        UserTestBuilder builder = new UserTestBuilder();
        Director director = new Director();
        director.constructUserTest(builder);
        Account accountUser = builder.Build();
        accountUser.print();

        AdminTestBuilder builder2 = new AdminTestBuilder();
        director.constructAdminTest(builder2);
        Account accountAdmin = builder2.Build();
        accountAdmin.print();
    }
}
