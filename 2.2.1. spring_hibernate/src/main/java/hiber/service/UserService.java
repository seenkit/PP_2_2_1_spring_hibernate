package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    List<User> getUsersList();

    List<User> getUserByCar(String model, String series);
}
