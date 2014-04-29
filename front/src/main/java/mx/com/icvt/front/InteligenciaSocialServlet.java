package mx.com.icvt.front;

import mx.com.icvt.persistence.impl.news.NewsDataRetriever;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class InteligenciaSocialServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NewsDataRetriever retriever = new NewsDataRetriever();
        List<mx.com.icvt.model.News> noticias = retriever.retrieveAllEnabled();

        request.setAttribute("noticias", null);
        RequestDispatcher dispatcher = request.getRequestDispatcher("inteligenciaSocial.jsp");
        dispatcher.forward(request, response);
    }
}
