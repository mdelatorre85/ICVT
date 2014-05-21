package mx.com.icvt.front;

import mx.com.icvt.persistence.impl.vocaciones.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class UnidadEconomicaServlet extends HttpServlet {

    private static final long serialVersionUID = -46590523520534621L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/registrarUnidadEconomica.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher;

        boolean exito = false;
        List<String> errores = new LinkedList<String>();

        String claseActividad = request.getParameter("claseActividad");
        String municipio = request.getParameter("municipio");
        String segmentoPersonalOcupado = request.getParameter("segmentoPersonalOcupado");

        String nombre = request.getParameter("nombre");
        String razonSocial = request.getParameter("razonSocial");
        String latitud = request.getParameter("latitud");
        String longitud = request.getParameter("longitud");
        String calle = request.getParameter("calle");
        String numeroExterior = request.getParameter("numeroExterior");
        String numeroInterior = request.getParameter("numeroInterior");
        String colonia = request.getParameter("colonia");
        String codigoPostal = request.getParameter("codigoPostal");
        String nombreRepresentante = request.getParameter("nombreRepresentante");
        String telefono = request.getParameter("telefono");
        String extension = request.getParameter("extension");
        String correo = request.getParameter("correo");
        String url = request.getParameter("url");
        String facebook = request.getParameter("facebook");
        String twitter = request.getParameter("twitter");

        int idClaseActividad = 0;
        int idMunicipio = 0;
        int idSegmentoPersonal = 0;

        Double latitudD = null;
        Double longitudD = null;

        if (claseActividad.isEmpty()) {
            errores.add("El campo Clase de actividad es requerido");
        } else {
            try {
                idClaseActividad = Integer.parseInt(claseActividad);
            } catch (NumberFormatException e) {
                errores.add("El valor del campo Clase actividad no es válido");
            }
        }

        if (municipio.isEmpty()) {
            errores.add("El campo Municipio es requerido");
        } else {
            try {
                idMunicipio = Integer.parseInt(municipio);
            } catch (NumberFormatException e) {
                errores.add("El valor del campo Municipio no es válido");
            }
        }

        if (segmentoPersonalOcupado.isEmpty()) {
            errores.add("El campo Segmento de personal es requerido");
        } else {
            try {
                idSegmentoPersonal = Integer.parseInt(segmentoPersonalOcupado);
            } catch (NumberFormatException e) {
                errores.add("El valor del campo Segmento de personal no es válido");
            }
        }

        if (!latitud.isEmpty()) {
            try {
                latitudD = Double.parseDouble(latitud);
            } catch (NumberFormatException e) {
                errores.add("El valor del campo Latitud no es válido");
            }
        }

        if (!longitud.isEmpty()) {
            try {
                longitudD = Double.parseDouble(longitud);
            } catch (NumberFormatException e) {
                errores.add("El valor del campo Longitud no es válido");
            }
        }

        if (!codigoPostal.isEmpty()){
            if (codigoPostal.length() != 5){
                errores.add("El Código postal debe contener 5 dígitos");
            } else {
                try{
                    Integer.parseInt(codigoPostal);
                } catch (NumberFormatException e){
                    errores.add("El Código postal debe ser numérico");
                }
            }
        }

        //TODO Validar teléfono
        //TODO Validar extensión
        //TODO Validar correo
        //TODO Validar correo
        //TODO Validar facebook
        //TODO Validar twitter

        if (errores.isEmpty()) {
            UnidadEconomica unidadEconomica = new UnidadEconomica();
            unidadEconomica.setNombreEstablecimiento(nombre);
            unidadEconomica.setRazonSocial(razonSocial);
            unidadEconomica.setLatitud(latitudD);
            unidadEconomica.setLongitud(longitudD);
            unidadEconomica.setCalle(calle);
            unidadEconomica.setNumeroExterior(numeroExterior);
            unidadEconomica.setNumeroInterior(numeroInterior);
            unidadEconomica.setColonia(colonia);
            unidadEconomica.setCodigoPostal(codigoPostal);
            unidadEconomica.setNombrePropietario(nombreRepresentante);
            unidadEconomica.setTelefono(telefono);
            unidadEconomica.setExtensionTelefono(extension);
            unidadEconomica.setCorreoElectronico(correo);
            unidadEconomica.setUrl(url);
            unidadEconomica.setFacebook(facebook);
            unidadEconomica.setTwitter(twitter);

            UnidadEconomicaPersister persister = new UnidadEconomicaPersister();

            boolean persisted = persister.persist(unidadEconomica, idSegmentoPersonal, idClaseActividad, idMunicipio);
            if (persisted) {
                exito = true;
            } else {
                errores.add("No fue posible registrar la unidad económica. Contacte al administrador del sistema para mayor información");
            }
        }

        request.setAttribute("exito", exito);
        request.setAttribute("errores", errores);
        dispatcher = request.getRequestDispatcher("WEB-INF/registrarUnidadEconomica.jsp");
        dispatcher.forward(request, response);
    }
}
