package mx.com.icvt.persistence.impl.user;

import java.util.Iterator;
import java.util.List;

/**
 * Created by lnx1337 on 05/05/14.
 */


public class test {


    public static void main(String args[]) {

        UserResultData urd = new UserResultData();
        User us = new User();


        // Login User
        System.out.println("Login user:");
        us.setIdentity("dev.lnx1337@gmail.com");
        us.setPassword("gabo");
        urd.user = us;

        List<User> uus =null;
        uus=urd.login();

        /*
        Iterator<User> responseLogin = uus.iterator();
        System.out.println(responseLogin);

        while (responseLogin.hasNext()) {
            User u = responseLogin.next();
            System.out.println("identity: "+u.getName()+"  password:"+u.getAvatar());
        }
        */
    }

}