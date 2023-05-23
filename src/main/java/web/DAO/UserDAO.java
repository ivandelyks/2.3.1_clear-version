package web.DAO;

import web.model.User;

import java.util.List;

public interface UserDAO {

    void add(User user);

    void delete(Long id);

    List<User> getAll();

    User show(Long id);

    void update(Long id, User updatedUser);

}

