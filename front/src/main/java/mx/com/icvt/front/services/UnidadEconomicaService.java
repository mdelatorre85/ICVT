package mx.com.icvt.front.services;

import mx.com.icvt.persistence.impl.vocaciones.UnidadEconomica;
import mx.com.icvt.persistence.impl.vocaciones.UnidadEconomicaModel;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.LinkedList;
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
    public List<mx.com.icvt.front.presenters.UnidadEconomica> proveedores(@FormParam("numero_denue") String numero_denue) {
        List<mx.com.icvt.front.presenters.UnidadEconomica> unidadesEconomicas;
        unidadesEconomicas = new LinkedList<mx.com.icvt.front.presenters.UnidadEconomica>();
        mx.com.icvt.front.presenters.UnidadEconomica ue;

        UnidadEconomicaModel obj = new UnidadEconomicaModel(numero_denue);
        System.out.println("numero_denue:" + numero_denue);
        System.out.println("Unidad economica clase: ");

        UnidadEconomica unidadEconomica;
        unidadEconomica = obj.getUnidadEconomica();

        if (unidadEconomica == null) {
            System.out.println("No se encontro número de DENUE");
        } else {
            List<UnidadEconomica> proveedores;
            proveedores = obj.getProveedores();
            if (proveedores != null && !proveedores.isEmpty()){
                for (UnidadEconomica u : proveedores){
                    ue = new mx.com.icvt.front.presenters.UnidadEconomica();
                    ue.setNombre(u.getNombreEstablecimiento());

                    //Evita devolver null, devuelve 0 si no tiene latitud
                    if (u.getLatitud() != null){
                        ue.setLatitud(u.getLatitud());
                    } else {
                        ue.setLatitud(0d);
                    }

                    //Evita devolver null, devuelve 0 si no tiene longitud
                    if (u.getLongitud() != null){
                        ue.setLongitud(u.getLongitud());
                    } else {
                        ue.setLatitud(0d);
                    }

                    unidadesEconomicas.add(ue);
                }
            }
        }

        return unidadesEconomicas;
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
