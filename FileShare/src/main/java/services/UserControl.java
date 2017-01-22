package services;

import additional.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by firdavs on 22/01/17.
 */
public class UserControl {

    private static UserControl instance = null;

    // Короче типо пока будем работать с мапой, посмотрим, что да как потом перейдем на БД
    // @users будет содержать пользователей, эту мапу будем тоскать по 'Auth and Reg' сервлетам
    private static Map<String, User> users;

    //Приватный конструктор, все дела, туда-сюда
    private UserControl() {}

    public static UserControl getInstance() {

        //  Это типо синглтон    -_-

        if (instance == null) {
            instance = new UserControl();

            /* Че за бред я пишу */

            users = new HashMap<>();
        }
        return instance;
    }

    public void addUser(String login, String password) {

        //Все так тупо написано
        //И так сойдет пока, первый мой проект все таки o_O
        users.put(login, new User(login, password));
    }

    public User getUser(String login) {

        /* пусть пока будет по левому
        без проверок на null и прочее */

        return users.get(login);

    }

}
