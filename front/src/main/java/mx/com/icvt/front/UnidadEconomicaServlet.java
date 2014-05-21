package mx.com.icvt.front;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UnidadEconomicaServlet extends HttpServlet {

    private static final long serialVersionUID = -46590523520534621L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String razonSocial = request.getParameter("razonSocial");
        String claseActividad = request.getParameter("claseActividad");
        String latitud = request.getParameter("latitud");
        String longitud = request.getParameter("longitud");
        String segmentoPersonalOcupado = request.getParameter("segmentoPersonalOcupado");
        String calle = request.getParameter("calle");
        String numeroExterior = request.getParameter("numeroExterior");
        String numeroInterior = request.getParameter("numeroInterior");
        String colonia = request.getParameter("colonia");
        String municipio = request.getParameter("municipio");
        String localidad = request.getParameter("localidad");
        String codigoPostal = request.getParameter("codigoPostal");
        String nombreRepresentante = request.getParameter("nombreRepresentante");
        String telefono = request.getParameter("telefono");
        String correo = request.getParameter("correo");
        String url = request.getParameter("url");
        String facebook = request.getParameter("facebook");
        String twitter = request.getParameter("twitter");
    }
}
