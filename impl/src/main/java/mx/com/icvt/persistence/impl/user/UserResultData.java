package mx.com.icvt.persistence.impl.user;

import mx.com.icvt.hash.BCrypt;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserResultData {
    public User user;
    public String token;
    private static EntityManagerFactory factory;

    public UserResultData() {
        this.user = new User();
    }

    public List<User> login() {

        List<User> users;

        factory = Persistence.createEntityManagerFactory("SITE");
        EntityManager em = factory.createEntityManager();

        Query query = em.createQuery("SELECT u FROM User u WHERE u.identity=:identity");
        query.setParameter("identity", this.user.getIdentity());
        users = query.getResultList();

        if (users.isEmpty()) {
            users = null;
        } else {
            boolean matchFound = false;
            for (User pro : users) {
                boolean matched = BCrypt.checkpw(this.user.getPassword(), pro.getPassword());
                if (matched) {
                    this.user.setId(pro.getId());
                    this.updateAccesToken();
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

    public String getPassword(){

        String generatedSecuredPasswordHash = BCrypt.hashpw("lamisma00", BCrypt.gensalt(12));
        return generatedSecuredPasswordHash;
    }

    public void updateAccesToken() {
        factory = Persistence.createEntityManagerFactory("SITE");
        EntityManager em = factory.createEntityManager();
        User user = em.find(User.class, this.user.getId());
        em.getTransaction().begin();
        user.setAccess_token(this.getAccesToken());
        em.getTransaction().commit();
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

    public String getAccesToken() {

        char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNNO12343567890".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String output = sb.toString();
        return output;
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
