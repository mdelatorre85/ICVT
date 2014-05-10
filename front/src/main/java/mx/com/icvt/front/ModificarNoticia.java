package mx.com.icvt.front;

import mx.com.icvt.persistence.impl.news.NewsDataPersister;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ModificarNoticia extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();

        Long idEtiqueta;
        Long idNoticia;

        try {
            idEtiqueta = Long.parseLong(request.getParameter("idEtiqueta"));
            idNoticia = Long.parseLong(request.getParameter("idNoticia"));

            NewsDataPersister persister = new NewsDataPersister();
            persister.addLabel(idNoticia, idEtiqueta);
            writer.print("<html><head><title>Success</title></head><body><p>Etiqueta agregada</p></body></html>");
        } catch (NumberFormatException e){
            writer.print("<html><head><title>Failure</title></head><body><p>No se pudo agregar la etiqueta</p></body></html>");
        }

        writer.flush();
        writer.close();
    }
}
