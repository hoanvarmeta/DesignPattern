import java.util.ArrayList;

class LoginPayload {

}

class LoginOauth2 extends LoginPayload {
    String type;
    String OAuth2;
}

class LoginUsernamePassword extends LoginPayload {
    String type;
    String username;
    String password;
}

interface MyAppLogin<T> {
    public String login(T payload);
}

class DB {
    public static ArrayList<User> list = new ArrayList<User>();
}

class User {
    String id;
    String username;
    String password;
    String OAuth2;
    String typelogin;

    User(String id, String username, String password, String typelogin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.OAuth2 = "";
        this.typelogin = typelogin;
    }

    User(String id, String OAuth2, String typelogin) {
        this.id = id;
        this.username = "";
        this.password = "";
        this.OAuth2 = OAuth2;
        this.typelogin = typelogin;
    }
}

class UserPasswordLogin<T extends LoginPayload> implements MyAppLogin<LoginUsernamePassword> {

    public String login(LoginUsernamePassword payload) {
        for (User user : DB.list) {
            if (user.username.equals(payload.username) && user.password.equals(payload.password)) {
                System.out.println("User Password Login success");
                return "Token";
            }
        }
        DB.list.add(new User(String.valueOf(DB.list.size() + 1), payload.username, payload.password,
                payload.type));
        System.out.println("User Password Login success");
        return "Token";
    }
}

class FaceBookLogin<T extends LoginPayload> implements MyAppLogin<LoginOauth2> {

    public String login(LoginOauth2 payload) {
        LoginOauth2 newPayload = (LoginOauth2) payload;
        for (User user : DB.list) {
            if (user.OAuth2.equals(newPayload.OAuth2)) {
                System.out.println("Facebook Login success");
                return "Token";
            }
        }
        DB.list.add(new User(String.valueOf(DB.list.size() + 1), newPayload.OAuth2, newPayload.type));
        System.out.println("Facebook Login success");
        return "Token";
    }
}

class GoogleLogin<T extends LoginPayload> implements MyAppLogin<LoginOauth2> {

    public String login(LoginOauth2 payload) {
        LoginOauth2 newPayload = (LoginOauth2) payload;
        System.out.println("Google auth: " + newPayload.OAuth2);
        for (User user : DB.list) {
            if (user.OAuth2.equals(newPayload.OAuth2)) {
                System.out.println("Google Login success");
                return "Token";
            }
        }
        DB.list.add(new User(String.valueOf(DB.list.size() + 1), newPayload.OAuth2, newPayload.type));
        System.out.println("Google Login success");
        return "Token";
    }
}

abstract class AbstractLoginFactory {
    public abstract MyAppLogin<LoginPayload> userLogin(String type);
}

class LoginFactory extends AbstractLoginFactory {

    public MyAppLogin<LoginPayload> userLogin(String type) {
        if (type.equals("UserPassword")) {
            return new UserPasswordLogin();
        } else if (type.equals("FaceBook")) {
            return new FaceBookLogin();
        } else if (type.equals("Google")) {
            return new GoogleLogin();
        }
        return null;
    }
}

public class example {
    public static void main(String[] args) {

        AbstractLoginFactory loginFactory = new LoginFactory();

        MyAppLogin<LoginPayload> passwordLogin = loginFactory.userLogin("UserPassword");
        LoginUsernamePassword passwordPayload = new LoginUsernamePassword();
        passwordPayload.username = "john";
        passwordPayload.password = "doe123";
        passwordPayload.type = "UserPassword";
        passwordLogin.login(passwordPayload);

        MyAppLogin<LoginPayload> googleLogin = loginFactory.userLogin("Google");
        LoginOauth2 googlePayload = new LoginOauth2();
        googlePayload.OAuth2 = "253";
        googlePayload.type = "Google";
        googleLogin.login(googlePayload);
    }
}
