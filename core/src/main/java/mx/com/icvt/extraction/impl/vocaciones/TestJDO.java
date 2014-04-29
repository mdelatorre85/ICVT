package mx.com.icvt.extraction.impl.vocaciones;


import java.util.Iterator;
import java.util.List;

import mx.com.icvt.extraction.impl.intsocial.*;
import mx.com.icvt.extraction.impl.user.UserResultData;
import mx.com.icvt.model.User;


public class TestJDO {


    public static void main(String args[]) {

        UserResultData urd = new UserResultData();
        User us = new User();

        // Add User
        System.out.println("Add user:");
        us.setIdentity("dev.lnx1337@gmail.com");
        us.setPassword("lamisma00");
        us.setRole_site_id(1);
        us.setRole_social_id(1);
        us.setUnidad_economica_id(1453);
        us.setName("Jair");
        us.setFirst_name("Peña");
        us.setLast_name("Trejo");
        us.setPhone("5544963762");
        us.setAvatar("http://lols.com/img.com");
        us.setStatus(1);
        urd.user = us;

        Iterator<User> responseAdd = urd.Save().iterator();
        while (responseAdd.hasNext()) {
            User pro = responseAdd.next();
            System.out.println("identity: "+pro.getIdentity()+" password:"+pro.getPassword());
        }

        // List User
        System.out.println("List users:");
        List<User> allUsers =null;
        allUsers = urd.List();
        Iterator<User> allUserList = allUsers.iterator();
        while (allUserList.hasNext()) {
            User pro = allUserList.next();
            System.out.println("identity: "+pro.getIdentity()+" password:"+pro.getPassword());
        }

        // Login User
        System.out.println("Login user:");
        us.setIdentity("dev.lnx1337@gmail.com");
        us.setPassword("lamisma00");
        Iterator<User> responseLogin = urd.Login().iterator();
        while (responseLogin.hasNext()) {
            User u = responseLogin.next();
            System.out.println("identity: "+u.getName()+"  password:"+u.getAvatar());
        }

       /*
       UnidadEconomicaModel obj = new UnidadEconomicaModel("12168");

       // get info unidad economica

        System.out.println("Unidad economica clase: ");
        UnidadEconomica unidadEconomica;
        unidadEconomica = obj.getUnidadEconomica();

        if (unidadEconomica == null) {
            System.out.println("No Existe unidad economica");
            return;
        }

        System.out.println(unidadEconomica.getNom_estab());


       // getCensosEconomicos 1999 2009

       System.out.println("CensosEconomicos:");

       CensosEconomicosModel censoEconomico = new CensosEconomicosModel();
       censoEconomico.setAnno("1999");
       censoEconomico.setCve_mun(unidadEconomica.getCve_mun());
       censoEconomico.setCve_actividad_economica(obj.getClase_act().substring(0, 3));

       List<CensosEconomicos> censoEc=null;
       censoEc = censoEconomico.getCensoEconomico();

       Iterator<CensosEconomicos> prov = censoEc.iterator();
       while (prov.hasNext()) {
           CensosEconomicos pro = prov.next();
           System.out.println(pro.getActividad_economica_id()+"Año"+pro.getAnno());

       }


       // getCensosPoblacion 2000 2010

        System.out.println("CensosPoblacion:");

        CensosPoblacionModel censoPoblacion = new CensosPoblacionModel();
        censoPoblacion.setAnno("2000");
        censoPoblacion.setCve_mun(unidadEconomica.getCve_mun());

        List<CensosPoblacion> censoPob = null;
        censoPob = censoPoblacion.getCensoPoblacion();

        Iterator<CensosPoblacion> ListCenPob = censoPob.iterator();

        while (ListCenPob.hasNext()) {
            CensosPoblacion cp = ListCenPob.next();
            System.out.println(cp.getId()+"Año"+cp.getAnno());
        }

        // getCensosEducacion 2000 2010

        System.out.println("CensosEducacion:");

        CensosEducacionModel censoEducacion = new CensosEducacionModel();
        censoEducacion.setAnno("2000");
        censoEducacion.setCve_mun(unidadEconomica.getCve_mun());

        List<CensosEducacion> censoEdu = null;
        censoEdu = censoEducacion.getCensoEducacion();

        Iterator <CensosEducacion> ListCenEdu = censoEdu.iterator();

        while (ListCenEdu.hasNext()) {
            CensosEducacion cedu = ListCenEdu.next();
            System.out.println(cedu.getMedia_superior()+"Año"+cedu.getAnno());
        }





        // get proveedores

        System.out.println("Unidad Economica Proveedores");

        List<UnidadEconomica> proveedores = null;
        proveedores = obj.getProveedores();

        if (proveedores != null) {
           Iterator<UnidadEconomica> pro = proveedores.iterator();
           while (pro.hasNext()) {
               UnidadEconomica pr = pro.next();
               System.out.println(pr.getDireccion());
           }
        }



        List<UnidadEconomica> demo = null;
        demo =obj.test();

        Iterator<UnidadEconomica> p=demo.iterator();


        while (p.hasNext()){
            UnidadEconomica pp=p.next();
            System.out.println(pp.getNom_estab());

        }


        // get competencias unidad economica

        System.out.println("Unidad economica Competencias: ");
        List<UnidadEconomica> competencias = null;
        competencias = obj.getCompetencias();
        Iterator<UnidadEconomica> comp = competencias.iterator();

        while (comp.hasNext()) {
            UnidadEconomica com = comp.next();
            System.out.println(com.getNom_estab());
        }


        // get clientes unidad economica

        System.out.println("Unidad economica Clientes: ");
        List<UnidadEconomica> clientes = null;
        clientes = obj.getClientes();

        if (clientes != null) {

            Iterator<UnidadEconomica> cli = clientes.iterator();

            while (cli.hasNext()) {
                UnidadEconomica cliente = cli.next();
                System.out.println(cliente.getNom_estab());
            }
        }
        */
    }

}