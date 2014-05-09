package mx.com.icvt.front;

import mx.com.icvt.persistence.impl.news.ConfiguracionExtraccionNoticias;
import mx.com.icvt.persistence.impl.news.NewsDataPersister;
import mx.com.icvt.persistence.impl.news.NewsDataRetriever;

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
 * Time: 21:37
 */
public class ConfiguracionExtraccionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NewsDataRetriever retriever = new NewsDataRetriever();

        String action = request.getParameter("action");
        if (action == null) {
            action = "retrieve";
        }

        if (action.equals("persist")) {
            NewsDataPersister persister = new NewsDataPersister();

            String terminoBusqueda = request.getParameter("terminoBusqueda");
            if (terminoBusqueda == null || terminoBusqueda.equals(""))  {
                ConfiguracionExtraccionNoticias configuracion = new ConfiguracionExtraccionNoticias(terminoBusqueda, "");
                persister.persist(configuracion);
            }
        }

        List<ConfiguracionExtraccionNoticias> configurations = retriever.getAllConfigurations();
        request.setAttribute("configuraciones", configurations);
        RequestDispatcher dispatcher = request.getRequestDispatcher("configuracionExtraccion.jsp");
        dispatcher.forward(request, response);
    }
}
