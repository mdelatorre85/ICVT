package mx.com.icvt.extraction.impl.vocaciones;

import javax.jdo.*;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lnx1337 on 27/03/14.
 */

public class UnidadEconomicaModel {

    public String clase_act;
    public String d_llave;
    public String tipoIndustria;
    public String proceso;
    public String queryProceso;
    public List<UnidadEconomica> proveedores;

    public UnidadEconomica getUnidadEconomica() {

        List<UnidadEconomica> LunidadE = null;
        UnidadEconomica unidadE = null;

        this.queryProceso = " WHERE d_llave==" + getD_llave();

        LunidadE = this.execQueryCondition();

        if (LunidadE.size() == 0) return null;

        unidadE = LunidadE.get(0);

        this.setClase_act(unidadE.getClase_act());
        this.setTipoIndustriaProceso();

        return unidadE;
    }

    public List<UnidadEconomica> getProveedores() {

        List<UnidadEconomica> proveedores = null;


        if (getTipoIndustria().equals("313")) {

            this.setQueryParticularInsumos();

            if (this.getQuery() != "") {
                proveedores = this.execQueryCondition();
            }

            return proveedores;
        }

        if (getTipoIndustria().equals("314")) {

            this.setQueryParticularConfeccionPT();

            if (this.getQuery() != "") {
                proveedores = this.execQueryCondition();
            }

            return proveedores;
        }

        if (getTipoIndustria().equals("315")) {

            this.setQueryProveedoresFabricacionPV();

            if (this.getQuery() != "") {
                proveedores = this.execQueryCondition();
            }
            return proveedores;
        }

        if (getTipoIndustria().equals("316")) {

            this.setQueryProveedoresFabricacionCPMS();

            if (this.getQuery() != "") {
                proveedores = this.execQueryCondition();
            }

            return proveedores;
        }

        return proveedores;
    }

    public void setQueryProveedoresFabricacionCPMS() {

        // Curtido y acabado de cuero y piel

        if (this.proceso.equals("3161")) {
            this.queryProceso = "";
        }

        // Fabricación de calzado

        if (this.proceso.equals("3162")) {
            this.queryProceso = " where clase_act.startsWith(\"3161\")";
        }

        // Fabricacion de otros

        if (this.proceso.equals("3169")) {
            this.queryProceso = " where clase_act.startsWith(\"3161\")";
        }

    }

    public void setQueryProveedoresFabricacionPV() {

        // Tejido

        if (this.proceso.equals("3151")) {
            this.queryProceso = " where clase_act.startsWith(\"3132\") ||  " +
                    "clase_act.startsWith(\"3133\")";
        }

        // Confeccion prendas de vestir

        if (this.proceso.equals("3152")) {
            this.queryProceso = " where clase_act.startsWith(\"3132\") ||  " +
                    "clase_act.startsWith(\"3133\") || clase_act.startsWith(\"3161\") ";
        }

        // Confeccion accesorios de vestir

        if (this.proceso.equals("3159")) {
            this.queryProceso = " where clase_act.startsWith(\"3132\") ||  " +
                    "clase_act.startsWith(\"3133\") || clase_act.startsWith(\"3131\") ";
        }

    }

    public void setQueryParticularConfeccionPT() {

        this.queryProceso = " where clase_act.startsWith(\"313\")";

    }

    public void setQueryParticularInsumos() {

        if (this.proceso.equals("3131")) {
            System.out.println("Proceso: Preparación");
            this.queryProceso = "";
        }

        if (this.proceso.equals("3132")) {
            System.out.println("Proceso: Fabricacion Depende: Preparacion 331");
            this.queryProceso = " where clase_act.startsWith(\"3131\")";
        }

        if (this.proceso.equals("3133")) {

            System.out.println("Proceso: Acabado Depende: Fabricacion-->Preparacion  332 331");
            this.queryProceso = " where clase_act.startsWith(\"3131\") || " +
                    "clase_act.startsWith(\"3132\")";
        }

    }

    public List<UnidadEconomica> getClientes() {

        List<UnidadEconomica> clientes = null;

        if (getTipoIndustria().equals("313")) {

            this.setQueryProcesoParticularClientesInsumos();

            if (this.getQuery() != "") {
                clientes = this.execQueryCondition();
            }

            return clientes;
        }

        if (getTipoIndustria().equals("314")) {

            this.setQueryParticularConfeccionClientesPT();

            if (this.getQuery() != "") {
                clientes = this.execQueryCondition();
            }

            return clientes;
        }

        if (getTipoIndustria().equals("316")) {

            this.setQueryProcesoParticularClientesFabricacionCPMS();

            if (this.getQuery() != "") {
                clientes = this.execQueryCondition();
            }

            return clientes;
        }

        return clientes;
    }

    public void setQueryProcesoParticularClientesFabricacionCPMS() {

        // Curtido y acabado de cuero y piel

        if (this.proceso.equals("3161")) {
            this.queryProceso = " where clase_act.startsWith(\"3162\") ";
        }

        // Fabricación de calzado

        if (this.proceso.equals("3162")) {
            this.queryProceso = " where clase_act.startsWith(\"31521\") ";
        }

        // Fabricacion de otros productos

        if (this.proceso.equals("3169")) {
            this.queryProceso = " where clase_act.startsWith(\"315999\") || " +
                    " clase_act.startsWith(\"31521\")";
        }

    }

    public void setQueryProcesoParticularClientesInsumos() {

        this.queryProceso = " where  clase_act.startsWith(\"314\") || " +
                " clase_act.startsWith(\"315\")";

    }

    public void setQueryParticularConfeccionClientesPT() {
        this.queryProceso = " where clase_act==\"463112\"  ";
    }

    public List<UnidadEconomica> execQueryCondition() {

        PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("SITE");
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();

        List<UnidadEconomica> proveedores = null;
        try {
            tx.begin();
            Query q = pm.newQuery("SELECT FROM " + UnidadEconomica.class.getName() + this.queryProceso);
            q.setOrdering("nom_estab asc");
            proveedores = (List<UnidadEconomica>) q.execute();
            tx.commit();
        } catch (Exception e) {
            System.out.println("Exception performing queries : " + e.getMessage());
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
            pm.close();
        }

        return proveedores;

    }



    public  List<UnidadEconomica> test() {


        PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("SITE");
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();

        List<UnidadEconomica> competencias;
        competencias = Arrays.asList();

        try
        {
            tx.begin();
           // Query q = pm.newQuery("SELECT FROM " + UnidadEconomica.class.getName());
            Query q = pm.newQuery("javax.jdo.query.SQL", "select a.d_llave,nom_estab,a.clase_act,u.desc_act from "+UnidadEconomica.class.getName()+" a  inner join clase_actividades u  where  u.clase_act=a.clase_act and a.d_llave=22816");
            //q.setFilter("clase_act==\""+ this.getClase_act()+"\"");
            //q.setOrdering("nom_estab asc");
            competencias = (List<UnidadEconomica>)q.execute();
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

        return competencias;

    }

    public List<UnidadEconomica> getCompetencias() {

        PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("SITE");
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();

        List<UnidadEconomica> competencias;
        competencias = Arrays.asList();

        try {
            tx.begin();
            Query q = pm.newQuery("SELECT FROM " + UnidadEconomica.class.getName());
            q.setFilter("clase_act==\"" + this.getClase_act() + "\"");
            q.setOrdering("nom_estab asc");
            competencias = (List<UnidadEconomica>) q.execute();
            tx.commit();
        } catch (Exception e) {
            System.out.println("Exception performing queries : " + e.getMessage());
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
            pm.close();
        }

        return competencias;

    }

    public String getQuery() {
        return this.queryProceso;
    }

    public void setTipoIndustriaProceso() {
        this.tipoIndustria = this.getClase_act().substring(0, 3);
        this.proceso = this.getClase_act().substring(0, 4);
    }

    public String getTipoIndustria() {
        return this.tipoIndustria;
    }

    public String getD_llave() {
        return d_llave;
    }

    public String getClase_act() {
        return clase_act;
    }

    public void setClase_act(String clase_act) {
        this.clase_act = clase_act;
    }

    public UnidadEconomicaModel(String d_llave) {
        this.d_llave = d_llave;
    }

}