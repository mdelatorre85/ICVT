package mx.com.icvt.persistence.impl.user;

import mx.com.icvt.hash.BCrypt;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class UserResultData {
    public User user;
    public String token;
    private static EntityManagerFactory factory;

    public UserResultData() {
        this.user = new User();
    }

    public List<User> login() {
        String identity = "dev.lnx1337@gmail.com";
        String password = "lamisma00";
        List<User> users;

        factory = Persistence.createEntityManagerFactory("SITE");
        EntityManager em = factory.createEntityManager();

        Query query = em.createQuery("SELECT u FROM User u WHERE u.identity = :identity AND u.password = :password");
        query.setParameter("identity", identity);
        query.setParameter("password", password);
        users = query.getResultList();

        if (users.isEmpty()) {
            users = null;
        } else {
            boolean matchFound = false;
            for (User pro : users) {
                boolean matched = BCrypt.checkpw(this.user.getPassword(), pro.getPassword());
                if (matched) {
                    matchFound = true;
                }
            }

            if (!matchFound){
                users = null;
            }
        }

        em.close();
        return users;
    }

    public List<User> list() {
        List<User> users;
        factory = Persistence.createEntityManagerFactory("SITE");
        EntityManager em = factory.createEntityManager();
        Query query = em.createQuery("SELECT u FROM User u");
        users = query.getResultList();
        factory.close();
        return users;
    }

    public List<User> save() {
        if (!exist()) {
            EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();
            String generatedSecuredPasswordHash = BCrypt.hashpw(this.user.getPassword(), BCrypt.gensalt(12));
            this.user.setPassword(generatedSecuredPasswordHash);
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
