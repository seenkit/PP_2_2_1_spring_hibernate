package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> getUsersList();

    List<User> getUserByCar(String model, String series);
}
