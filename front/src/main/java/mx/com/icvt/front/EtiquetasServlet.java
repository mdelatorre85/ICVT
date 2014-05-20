package mx.com.icvt.front;

import mx.com.icvt.persistence.impl.tags.Etiqueta;
import mx.com.icvt.persistence.impl.tags.EtiquetaPersister;
import mx.com.icvt.persistence.impl.tags.EtiquetaRetriever;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Cesar
 * Date: 06/05/14
 * Time: 18:21
 */
public class EtiquetasServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") != null ? request.getParameter("action") : "retrieve";

        if (action.equals("persist")) {
            EtiquetaPersister persister = new EtiquetaPersister();
            String nombreEtiqueta = request.getParameter("nombreEtiqueta");
            String color = request.getParameter("color");
            persister.persist(new Etiqueta(nombreEtiqueta, color));
        }

        EtiquetaRetriever retriever = new EtiquetaRetriever();
        List<mx.com.icvt.model.common.Etiqueta> etiquetas = retriever.getAllPersisted();
        request.setAttribute("etiquetas", etiquetas);
        RequestDispatcher dispatcher = request.getRequestDispatcher("etiquetas.jsp");
        dispatcher.forward(request, response);
    }
}
