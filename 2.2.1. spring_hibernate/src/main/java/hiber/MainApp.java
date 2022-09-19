package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.add(new User("Nikolai", "Ivanov", "nikolai1971@mail.ru",
                new Car("Lada", "Granta")));
        userService.add(new User("Aleksei", "Petrov", "lexxxa1989@yandex.ru",
                new Car("Lada", "Priora")));
        userService.add(new User("Vladimir", "Terentiev", "v.terentiev@gmail.com",
                new Car("Kia", "Rio")));
        userService.add(new User("Maksim", "Moskvin", "maks.moskva@mgail.com",
                new Car("Skoda", "Yeti")));

        userService.add(new User("Danila", "Voroncov", "dania2010@yandex.ru"));

        List<User> users = userService.getUsersList();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            if (user.getCar() != null) {
                System.out.println("Car = " + user.getCar());
            }
            System.out.println();
        }

        List<User> userByCar = userService.getUserByCar("Lada", "Priora");
        for (User user : userByCar) {
            System.out.println(user);
        }

        context.close();
    }
}
