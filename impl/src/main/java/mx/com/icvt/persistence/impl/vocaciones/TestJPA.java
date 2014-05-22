package mx.com.icvt.persistence.impl.vocaciones;

import mx.com.icvt.persistence.impl.intsocial.CensosEconomicos;
import mx.com.icvt.persistence.impl.intsocial.CensosEconomicosModel;

import java.util.Iterator;
import java.util.List;

public class TestJPA {
    public static void main(String[] args){
        /*
        UnidadEconomicaModel model = new UnidadEconomicaModel("8716");
        List<UnidadEconomica> unidadesEconomicas = model.execQueryCondition();
        System.out.printf("Número de unidades económicas: %d\n", unidadesEconomicas.size());
        for (UnidadEconomica unidadEconomica : unidadesEconomicas){
            System.out.println("Nombre: " + unidadEconomica.getNombreEstablecimiento());
            System.out.println("Razón social: " + unidadEconomica.getRazonSocial());
        }
        */

        UnidadEconomicaModel obj = new UnidadEconomicaModel("12168");

        // get info unidad economica

        System.out.println("Unidad economica clase: ");
        UnidadEconomica unidadEconomica;
        unidadEconomica = obj.getUnidadEconomica();

        if (unidadEconomica == null) {
            System.out.println("No Existe unidad economica");
            return;
        }

        System.out.println(unidadEconomica.getNombreEstablecimiento());

        /*
        // getCensosEconomicos 1999 2009

        System.out.println("CensosEconomicos:");

        CensosEconomicosModel censoEconomico = new CensosEconomicosModel();
        censoEconomico.setAnno("1999");
        Municipio mun =unidadEconomica.getMunicipio();
        censoEconomico.setCve_mun(mun.getId());

        censoEconomico.setCve_actividad_economica(String.valueOf(obj.getClase_act()).substring(0, 3));

        List<CensosEconomicos> censoEc=null;
        censoEc = censoEconomico.getCensoEconomico();

        Iterator<CensosEconomicos> prov = censoEc.iterator();
        while (prov.hasNext()) {
            CensosEconomicos pro = prov.next();
            System.out.println(pro.getActividadEconomica()+"Año"+pro.getAnio());

        }
        */



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


        // get competencias unidad economica

        System.out.println("Unidad economica Competencias: ");
        List<UnidadEconomica> competencias = null;
        competencias = obj.getCompetencias();
        Iterator<UnidadEconomica> comp = competencias.iterator();

        while (comp.hasNext()) {
            UnidadEconomica com = comp.next();
            System.out.println(com.getNombreEstablecimiento());
        }


        // get clientes unidad economica

        System.out.println("Unidad economica Clientes: ");
        List<UnidadEconomica> clientes = null;
        clientes = obj.getClientes();

        if (clientes != null) {
            Iterator<UnidadEconomica> cli = clientes.iterator();
            while (cli.hasNext()) {
                UnidadEconomica cliente = cli.next();
                System.out.println(cliente.getNombreEstablecimiento());
            }
        }




    }
}
