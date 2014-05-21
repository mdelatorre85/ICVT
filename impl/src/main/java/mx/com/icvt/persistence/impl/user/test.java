package mx.com.icvt.persistence.impl.user;

import mx.com.icvt.persistence.impl.vocaciones.UnidadEconomica;
import mx.com.icvt.persistence.impl.vocaciones.UnidadEconomicaModel;

import java.util.Iterator;
import java.util.List;

/**
 * Created by lnx1337 on 05/05/14.
 */


public class test {


    public static void main(String args[]) {
        /*
        UserResultData urd = new UserResultData();
        User us = new User();

        // Login User
        System.out.println("Login user:");
        us.setIdentity("dev.lnx1337@gmail.com");
        us.setPassword("lamisma00");
        urd.user = us;

        List<User> uus =null;
        uus=urd.login();

        Iterator<User> responseLogin = uus.iterator();
        System.out.println(responseLogin);

        while (responseLogin.hasNext()) {
            User u = responseLogin.next();
            System.out.println("identity: "+u.getName()+"  password:"+u.getAvatar());
        }
        */
        // System.out.println("Login user");

        UnidadEconomicaModel obj = new UnidadEconomicaModel("12168");

        // get info unidad economica

        System.out.println("Unidad economica clase: ");
        UnidadEconomica unidadEconomica;
        unidadEconomica = obj.getUnidadEconomica();

        /*
        if (unidadEconomica == null) {
            System.out.println("No Existe unidad economica");
            return;
        }
       */
        // System.out.println(unidadEconomica.getNom_estab());

    }

}