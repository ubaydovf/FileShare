package additional;

/**
 * Created by firdavs on 22/01/17.
 */
public class User {

    private String login;
    private String password;

    /* @login - кажется это логин
       @password - наверное это пароль !
       Дээмн, да я же Captain очевидность -_- */

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
