package mx.com.icvt.persistence.impl.vocaciones;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lnx1337 on 27/03/14.
 */

public class UnidadEconomicaModel {

    public int clase_act;
    public String d_llave;
    public String tipoIndustria;
    public String proceso;
    public String queryProceso;
    public List<UnidadEconomica> proveedores;
    private static EntityManagerFactory factory;


    public UnidadEconomica getUnidadEconomica() {

        List<UnidadEconomica> LunidadE = null;
        UnidadEconomica unidadE = null;

        this.queryProceso = " WHERE numero_denue=" + getD_llave();

        LunidadE = this.execQueryCondition();

        if (LunidadE.size() == 0) return null;

        unidadE = LunidadE.get(0);

        ClaseActividad obj;

        obj = unidadE.getClaseActividad();

        this.setClase_act(obj.getId());
        this.setTipoIndustriaProceso();

        return unidadE;
    }

    public  List<UnidadEconomica> getProveedores() {

        List<UnidadEconomica> proveedores = null;


        if (getTipoIndustria().equals("313")) {

            this.setQueryParticularInsumos();

            if (this.getQuery()!= ""){
                proveedores = this.execQueryCondition();
            }

            return proveedores;
        }

        if (getTipoIndustria().equals("314")) {

            this.setQueryParticularConfeccionPT();

            if (this.getQuery()!="") {
                proveedores = this.execQueryCondition();
            }

            return proveedores;
        }

        if (getTipoIndustria().equals("315")) {

            this.setQueryProveedoresFabricacionPV();

            if (this.getQuery()!="") {
                proveedores = this.execQueryCondition();
            }
            return proveedores;
        }

        if (getTipoIndustria().equals("316")) {

            this.setQueryProveedoresFabricacionCPMS();

            if (this.getQuery()!= "") {
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

        // Fabricaci��n de calzado

        if (this.proceso.equals("3162")) {
            this.queryProceso =" where id_clase_actividad like \"3161%\"";
        }

        // Fabricacion de otros

        if (this.proceso.equals("3169")) {
            this.queryProceso = " where id_clase_actividad like \"3161%\"";
        }

    }

    public void setQueryProveedoresFabricacionPV() {

        // Tejido

        if (this.proceso.equals("3151")) {
            this.queryProceso=" where id_clase_actividad like \"3132%\" or  "+
                    "id_clase_actividad like \"3133%\"";
        }

        // Confeccion prendas de vestir

        if (this.proceso.equals("3152")) {
            this.queryProceso=" where id_clase_actividad like \"3132%\" or  "+
                    "id_clase_actividad like \"3133%\" or id_clase_actividad like \"3161%\" ";
        }

        // Confeccion accesorios de vestir

        if (this.proceso.equals("3159")) {
            this.queryProceso=" where id_clase_actividad like \"3132%\" or  "+
                    "id_clase_actividad like \"3133%\" or id_clase_actividad like \"3131%\"";
        }

    }

    public void setQueryParticularConfeccionPT() {

        this.queryProceso = " where id_clase_actividad like \"313%\"";

    }

    public void setQueryParticularInsumos() {

        if (this.proceso.equals("3131")) {
            System.out.println("Proceso: Preparacion");
            this.queryProceso = "";
        }

        if (this.proceso.equals("3132")) {
            System.out.println("Proceso: Fabricacion Depende: Preparacion 331");
            this.queryProceso = " where id_clase_actividad like \"3131%\"";
        }

        if (this.proceso.equals("3133")) {

            System.out.println("Proceso: Acabado Depende: Fabricacion-->Preparacion  332 331");
            this.queryProceso = " where id_clase_actividad like \"3131%\" or "+
                    "id_clase_actividad like \"3132%\"";
        }

    }

    public  List<UnidadEconomica> getClientes() {

        List<UnidadEconomica> clientes = null;

        if (getTipoIndustria().equals("313")) {

            this.setQueryProcesoParticularClientesInsumos();

            if (this.getQuery()!="") {
                clientes = this.execQueryCondition();
            }

            return clientes;
        }

        if (getTipoIndustria().equals("314")) {

            this.setQueryParticularConfeccionClientesPT();

            if (this.getQuery()!="") {
                clientes = this.execQueryCondition();
            }

            return clientes;
        }

        if (getTipoIndustria().equals("316")) {

            this.setQueryProcesoParticularClientesFabricacionCPMS();

            if (this.getQuery()!="") {
                clientes = this.execQueryCondition();
            }

            return clientes;
        }

        return clientes;
    }

    public void setQueryProcesoParticularClientesFabricacionCPMS() {

        // Curtido y acabado de cuero y piel

        if (this.proceso.equals("3161")) {
            this.queryProceso = " where id_clase_actividad like \"3162%\" ";
        }

        // Fabricación de calzado

        if (this.proceso.equals("3162")) {
            this.queryProceso = " where id_clase_actividad like \"31521%\" ";
        }

        // Fabricacion de otros productos

        if (this.proceso.equals("3169")) {
            this.queryProceso = " where id_clase_actividad like \"315999%\" or " +
                    " id_clase_actividad like \"31521%\"";
        }

    }

    public void setQueryProcesoParticularClientesInsumos() {

        this.queryProceso = " where  id_clase_actividad like \"314%\" or " +
                " id_clase_actividad like \"315%\"";

    }

    public void setQueryParticularConfeccionClientesPT() {
        this.queryProceso = " where id_clase_actividad=\"463112\"";
    }

    public List<UnidadEconomica> getCompetencias() {

        List<UnidadEconomica> competencias;
        this.queryProceso = " where id_clase_actividad="+this.getClase_act();
        competencias = this.execQueryCondition();
        return competencias;

    }

    public List<UnidadEconomica> execQueryCondition(){
        List<UnidadEconomica> unidades;

        try {
            EntityManager manager = Persistence.createEntityManagerFactory("SITE").createEntityManager();
            String queryString = "select * from unidad_economica " + this.queryProceso;
            Query query = manager.createNativeQuery(queryString, UnidadEconomica.class);
            unidades = query.getResultList();
            manager.close();
        } catch (Exception e){
            System.err.printf("Ocurrió un error al ejecutar la consulta: %s\n", e.getMessage());
            unidades = new LinkedList<UnidadEconomica>();
        }

        return unidades;
    }

    public String getQuery() {
        return this.queryProceso;
    }

    public void setTipoIndustriaProceso() {
        this.tipoIndustria = String.valueOf(this.getClase_act()).substring(0, 3);
        this.proceso = String.valueOf(this.getClase_act()).substring(0, 4);
    }

    public String getTipoIndustria() {
        return this.tipoIndustria;
    }

    public String getD_llave() {
        return d_llave;
    }

    public int getClase_act() {
        return clase_act;
    }

    public void setClase_act(int clase_act) {
        this.clase_act = clase_act;
    }

    public UnidadEconomicaModel(String d_llave) {
        this.d_llave = d_llave;
    }

}