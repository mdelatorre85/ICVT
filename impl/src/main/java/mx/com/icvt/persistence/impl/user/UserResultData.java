package mx.com.icvt.persistence.impl.user;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lnx1337 on 27/04/14.
 */
public class UserResultData {
    public User user;
    public String token;

    public UserResultData() {
        this.user = new User();
    }

    public List<User> login() {
        String identity = "dev.lnx1337@gmail.com";
        String password = "lamisma00";
        List<User> users;

        EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();
        Query query = manager.createQuery("SELECT u FROM User u WHERE u.identity = :identity AND u.password = :password");
        query.setParameter("identity", identity);
        query.setParameter("password", password);
        users = query.getResultList();

        if (users.isEmpty()) {
            users = null;
        }

        manager.close();
        return users;
    }

    public List<User> list() {
        List<User> users;
        EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();
        Query query = manager.createQuery("SELECT u FROM User u");
        users = query.getResultList();
        manager.close();
        return users;
    }

    public List<User> save() {
        if (!exist()) {
            EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();
            manager.getTransaction().begin();
            manager.persist(this.user);
            manager.getTransaction().commit();

        }

        return null;
    }

    public List<User> findById(int id) {
        List<User> users = new ArrayList<User>();
        EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();
        User user = manager.find(User.class, id);
        if (user != null) {
            users.add(user);
        }
        manager.close();
        return users;
    }

    public boolean exist() {
        boolean exist = false;
        EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();
        User user = manager.find(User.class, this.user.getIdentity());
        if (user != null) {
            exist = true;
        }

        manager.close();
        return exist;
    }
}
