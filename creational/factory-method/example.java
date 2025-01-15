import java.util.ArrayList;

interface MyAppLogin {
    String login(String username, String password, String oauth2, ArrayList<User> list);
}

class User {
    String id;
    String username;
    String password;
    String OAuth2;
    String typelogin;

    User(String id, String username, String password, String OAuth2, String typelogin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.OAuth2 = OAuth2;
        this.typelogin = typelogin;
    }
}

class UserPasswordLogin implements MyAppLogin {
    public String login(String username, String password, String oauth2, ArrayList<User> list) {
        for (User user : list) {
            if (user.username.equals(username)) {
                System.out.println("User Password Login success");
                return "Token";
            }
        }
        list.add(new User(String.valueOf(list.size() + 1), username, password, "", "UserPassword"));
        System.out.println("User Password Login success");
        return "Token";
    }
}

class FaceBookLogin implements MyAppLogin {
    public String login(String username, String password, String oauth2, ArrayList<User> list) {
        for (User user : list) {
            if (user.OAuth2.equals(oauth2)) {
                System.out.println("Facebook Login success");
                return "Token";
            }
        }
        list.add(new User(String.valueOf(list.size() + 1), "", "", oauth2, "Facebook"));
        System.out.println("Facebook Login success");
        return "Token";
    }
}

class GoogleLogin implements MyAppLogin {
    public String login(String username, String password, String oauth2, ArrayList<User> list) {
        for (User user : list) {
            if (user.OAuth2.equals(oauth2)) {
                System.out.println("Google Login success");
                return "Token";
            }
        }
        list.add(new User(String.valueOf(list.size() + 1), "", "", oauth2, "Google"));
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
        ArrayList<User> list = new ArrayList<User>();
        AbstractLoginFactory loginFactory = new LoginFactory();
        MyAppLogin myapp = loginFactory.userLogin("Google", "username", "password", "oauth2", list);
        myapp.login("username", "password", "oauth2", list);
    }
}
