package mx.com.icvt.front;

import mx.com.icvt.model.News;
import mx.com.icvt.persistence.impl.news.NewsDataPersister;
import mx.com.icvt.persistence.impl.news.NewsDataRetriever;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdministrarNoticiasServlet extends HttpServlet {
    private static final long serialVersionUID = 4362731618560279040L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NewsDataRetriever retriever = new NewsDataRetriever();
        List<News> noticias = retriever.getAllEnabled();
        request.setAttribute("noticias", noticias);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/administrarNoticias.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String idNoticia = request.getParameter("idNoticia");

        System.out.printf("Accion: %s\n", action);
        System.out.printf("Id noticia: %s\n", idNoticia);

        RequestDispatcher dispatcher;

        NewsDataRetriever retriever = new NewsDataRetriever();
        NewsDataPersister persister = new NewsDataPersister();
        Long id = Long.parseLong(idNoticia);

        if (action.equals("deshabilitar")) {
            persister.deshabilitar(id);

            List<News> noticias = retriever.getAllEnabled();
            request.setAttribute("noticias", noticias);
            dispatcher = request.getRequestDispatcher("WEB-INF/administrarNoticias.jsp");
            dispatcher.forward(request, response);
        } else if (action.equals("editar")) {
            News noticia = retriever.getById(id);

            request.setAttribute("noticia", noticia);
            dispatcher = request.getRequestDispatcher("WEB-INF/editarNoticia.jsp");
            dispatcher.forward(request, response);
        } else if (action.equals("guardarCambios")){
            String titulo = request.getParameter("titulo");
            String descripcion = request.getParameter("descripcion");
            persister.actualizar(id, titulo, descripcion);

            List<News> noticias = retriever.getAllEnabled();
            request.setAttribute("noticias", noticias);
            dispatcher = request.getRequestDispatcher("WEB-INF/administrarNoticias.jsp");
            dispatcher.forward(request, response);
        }
    }
}
