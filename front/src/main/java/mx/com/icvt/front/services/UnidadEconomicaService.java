package mx.com.icvt.front.services;

import mx.com.icvt.persistence.impl.vocaciones.UnidadEconomica;
import mx.com.icvt.persistence.impl.vocaciones.UnidadEconomicaModel;


import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Iterator;
import java.util.List;

/**
 * Created by lnx1337 on 22/05/14.
 */
@Path("/ue")
public class UnidadEconomicaService {

    @POST
    @Path("/info")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public UnidadEconomica index(@FormParam("numero_denue") String numero_denue) {

        UnidadEconomicaModel obj = new UnidadEconomicaModel(numero_denue);
        System.out.println("Unidad economica clase: ");
        UnidadEconomica unidadEconomica;
        unidadEconomica = obj.getUnidadEconomica();
        if (unidadEconomica == null) {
            return null;
        }
        return unidadEconomica;
    }

    @POST
    @Path("/proveedores")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<UnidadEconomica> proveedores(@FormParam("numero_denue") String numero_denue) {


        UnidadEconomicaModel obj = new UnidadEconomicaModel(numero_denue);
        System.out.println("numero_denue:"+numero_denue);
        System.out.println("Unidad economica proveedores: ");
        UnidadEconomica unidadEconomica;
        unidadEconomica = obj.getUnidadEconomica();
        if (unidadEconomica == null) {
            System.out.println("no se encontro numero");
            return null;
        }

        System.out.println(unidadEconomica.getNombreEstablecimiento());

        List<UnidadEconomica> proveedores = null;
        proveedores = obj.getProveedores();

        if (proveedores != null) {
            Iterator<UnidadEconomica> pro = proveedores.iterator();
            while (pro.hasNext()) {
                UnidadEconomica pr = pro.next();
                System.out.println(pr.getDireccion());
            }
        }

        return proveedores;
    }


    @POST
    @Path("/competencias")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<UnidadEconomica> competencias(@FormParam("numero_denue") String numero_denue) {

        UnidadEconomicaModel obj = new UnidadEconomicaModel(numero_denue);
        System.out.println("Unidad economica : ");
        UnidadEconomica unidadEconomica;
        unidadEconomica = obj.getUnidadEconomica();
        if (unidadEconomica == null) {
            return null;
        }

        List<UnidadEconomica> competencias = null;
        competencias = obj.getCompetencias();

        return competencias;
    }

    @POST
    @Path("/clientes")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public List<UnidadEconomica> clientes(@FormParam("numero_denue") String numero_denue) {

        UnidadEconomicaModel obj = new UnidadEconomicaModel(numero_denue);
        System.out.println("Unidad economica clase: ");
        UnidadEconomica unidadEconomica;
        unidadEconomica = obj.getUnidadEconomica();
        if (unidadEconomica == null) {
            return null;
        }

        List<UnidadEconomica> clientes = null;
        clientes = obj.getClientes();

        return clientes;
    }

}
