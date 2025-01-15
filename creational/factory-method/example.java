import java.util.ArrayList;

interface MyAppLogin {
    String login();
}

class User {
    String id;
    String username;
    String password;
    String OAuth2;
    String typeOAuth2;

    User(String id, String username, String password, String OAuth2, String typeOAuth2) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.OAuth2 = OAuth2;
        this.typeOAuth2 = typeOAuth2;
    }
}

class UserPasswordLogin implements MyAppLogin {
    public String login() {
        System.out.println("User Password Login success");
        return "Token";
    }
}

class FaceBookLogin implements MyAppLogin {
    public String login() {
        System.out.println("FaceBook Login success");
        return "Token";
    }
}

class GoogleLogin implements MyAppLogin {
    public String login() {
        System.out.println("Google Login success");
        return "Token";
    }
}

abstract class AbstractLoginFactory {
    public abstract MyAppLogin userLogin(String type, String username, String password, String oauth2,

            ArrayList<User> list);
}

class LoginFactory extends AbstractLoginFactory {
    public MyAppLogin userLogin(String type, String username, String password, String oauth2,
            ArrayList<User> list) {
        if (type.equals("UserPassword")) {
            for (User user : list) {
                if (user.username.equals(username)) {
                    return new UserPasswordLogin();
                }
            }
            list.add(new User(String.valueOf(list.size() + 1), username, password, oauth2, type));
            return new UserPasswordLogin();

        } else if (type.equals("FaceBook")) {
            for (User user : list) {
                if (user.OAuth2.equals(oauth2)) {
                    return new UserPasswordLogin();
                }
            }
            list.add(new User(String.valueOf(list.size() + 1), "", "", oauth2, type));
            return new FaceBookLogin();
        } else if (type.equals("Google")) {
            for (User user : list) {
                if (user.OAuth2.equals(oauth2)) {
                    return new UserPasswordLogin();
                }
            }
            list.add(new User(String.valueOf(list.size() + 1), "", "", oauth2, type));
            return new GoogleLogin();
        }
        return null;
    }
}

public class example {
    public static void main(String[] args) {
        ArrayList<User> list = new ArrayList<User>();
        AbstractLoginFactory loginFactory = new LoginFactory();
        MyAppLogin myapp = loginFactory.userLogin("UserPassword", "username", "password", "oauth2", list);
        myapp.login();
    }
}
