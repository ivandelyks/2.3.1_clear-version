package web.DAO;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImp implements UserDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> getAll() {

        return entityManager.createQuery("SELECT u FROM User u", User.class).
                getResultList();
    }

    public User show(Long id) {
        return entityManager.find(User.class, id);
    }

    public void update(Long id, User updatedUser) {
        User userToBeUpdated = show(id);
        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setLastName(updatedUser.getLastName());
        userToBeUpdated.setAge(updatedUser.getAge());
        entityManager.merge(userToBeUpdated);
        entityManager.flush();
    }

    @Override
    public void delete(Long id) {
        User userNow = entityManager.find(User.class, id);
        entityManager.remove(userNow);
    }

}
