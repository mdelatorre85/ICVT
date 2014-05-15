package mx.com.icvt.front.services;

import mx.com.icvt.front.presenters.cuestionarios.Cuestionario;
import mx.com.icvt.front.presenters.cuestionarios.CuestionariosAgrupados;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by miguelangeldelatorre on 15/05/14.
 */
@Path("/cuestionarios")
public class CuestionariosService {

    @POST
    @Path("/agrupadas")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public CuestionariosAgrupados getCuestionario(@FormParam("numeroNoticias") long unidadEconomicaId){
        return null;
    }

}
