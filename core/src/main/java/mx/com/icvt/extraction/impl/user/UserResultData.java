package mx.com.icvt.extraction.impl.user;

import mx.com.icvt.model.User;

import javax.jdo.*;
import javax.jdo.annotations.PersistenceAware;
import java.util.Arrays;
import java.util.List;
import java.util.Iterator;


/**
 * Created by lnx1337 on 27/04/14.
 */
@PersistenceAware
public class UserResultData {

    public User user;
    public String token;

    public List<User> Login(){

        PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("SITE");
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        List<User> users;
        users = Arrays.asList();
        try
        {
            // tx.begin();
            Query q = pm.newQuery("SELECT FROM " + User.class.getName());
            q.setFilter("identity==\""+"dev.lnx1337@gmail.com"+"\"");
            q.setFilter("password==\""+"lamisma00"+"\"");
            users =(List<User>)q.execute();
            // tx.commit();
        }
        catch (Exception e)
        {
            System.out.println("Exception performing queries : " + e.getMessage());
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }

            pm.close();
        }


        if(users!=null){
            Iterator<User> prov = users.iterator();
            while (prov.hasNext()) {
                User pro = prov.next();
                if(pro.identity.equals(this.user.getIdentity()) && pro.password.equals(this.user.getPassword())){
                    return users;
                }
            }
        }

        return null;
    }

    public List<User> List(){

        PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("SITE");
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        List<User> users;
        users = Arrays.asList();

        try
        {
            tx.begin();
            Query q = pm.newQuery("SELECT FROM " + User.class.getName());
            users = (List<User>)q.execute();
            tx.commit();
        }
        catch (Exception e)
        {
            System.out.println("Exception performing queries : " + e.getMessage());
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }

        return users;
    }

    public List<User> Save(){

        boolean existUser = this.Exist();

        if(!existUser){
            PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("SITE");
            PersistenceManager pm = pmf.getPersistenceManager();
            try {
                pm.makePersistent(this.user);
                return  this.FindById(this.user.id);

            } finally {
                pm.close();
            }
        }

        return  null;
    }

    public List<User> FindById(int id){

        PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("SITE");
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        List<User> users;
        users = Arrays.asList();

        try
        {
            tx.begin();
            Query q = pm.newQuery("SELECT FROM " + User.class.getName());
            q.setFilter("id=="+id);

            users = (List<User>)q.execute();
            tx.commit();
        }
        catch (Exception e)
        {
            System.out.println("Exception performing queries : " + e.getMessage());
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
        return users;

    }

    public boolean Exist() {

        PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("SITE");
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();

        List<User> users;
        users = Arrays.asList();

        try
        {
            tx.begin();
            Query q = pm.newQuery("SELECT FROM " + User.class.getName());
            q.setFilter("identity==\""+this.user.identity+"\"");
            users =(List<User>)q.execute();
            tx.commit();
        }
        catch (Exception e)
        {
            System.out.println("Exception performing queries : " + e.getMessage());
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }

        if(users.size()>0){
          return  true;
        }

        return  false;
    }

    public UserResultData() {
        this.user = new User();
    }
}
