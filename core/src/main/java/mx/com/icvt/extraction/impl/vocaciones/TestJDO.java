package mx.com.icvt.extraction.impl.vocaciones;


import java.util.Iterator;
import java.util.List;


public class TestJDO {



    public static void main(String args[]) {


       UnidadEconomicaModel obj = new UnidadEconomicaModel("1337");


       // get info unidad economica

       System.out.println("Unidad economica clase: ");
       UnidadEconomica unidadEconomica;
       unidadEconomica = obj.getUnidadEconomica();

       if (unidadEconomica == null ) {
           System.out.println("No Existe unidad economica");
           return;
       }

       System.out.println(unidadEconomica.getNom_estab());


       // get proveedores

       System.out.println("Unidad Economica Proveedores");

       List<UnidadEconomica> proveedores = null;
       proveedores = obj.getProveedores();

       if (proveedores != null){

           Iterator<UnidadEconomica> prov = proveedores.iterator();
           while (prov.hasNext()) {
               UnidadEconomica pro = prov.next();
               System.out.println(pro.getNom_estab());
           }

       }


       // get competencias unidad economica

       System.out.println("Unidad economica Competencias: ");
       List<UnidadEconomica> competencias=null;
       competencias=obj.getCompetencias();
       Iterator<UnidadEconomica> comp = competencias.iterator();

       while (comp.hasNext()) {
            UnidadEconomica com = comp.next();
            System.out.println(com.getNom_estab());
       }



       // get clientes unidad economica

       System.out.println("Unidad economica Clientes: ");
       List<UnidadEconomica> clientes = null;
       clientes=obj.getClientes();

       if (clientes!=null) {

           Iterator<UnidadEconomica> cli = clientes.iterator();

           while (cli.hasNext())
           {
               UnidadEconomica cliente = cli.next();
               System.out.println(cliente.getNom_estab());
           }
       }


    }

}
