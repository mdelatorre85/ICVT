package mx.com.icvt.front;

import mx.com.icvt.extraction.ProcesoExtraccionNoticias;
import mx.com.icvt.extraction.ProcessExtraccionTweets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: Cesar
 * Date: 09/05/14
 * Time: 10:37
 */
public class EjecutarExtraccionServlet extends HttpServlet {
    private static final long serialVersionUID = 3277237380852733301L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tipo = request.getParameter("tipo");
        if (tipo == null || tipo.equals("")) tipo = "noticias";

        PrintWriter writer = response.getWriter();
        writer.print("<html><head><title>Proceso de extracción></title></head>");

        if (tipo.equals("noticias")) {
            ProcesoExtraccionNoticias proceso = new ProcesoExtraccionNoticias();
            proceso.extraerNoticias();
            writer.print("<body><p>Proceso extracción de Noticias finalizado</p></body></html>");
        } else if (tipo.equals("tweets")) {
            ProcessExtraccionTweets proceso = new ProcessExtraccionTweets();
            proceso.extraeTweets();
            writer.print("<body><p>Proceso extracción de Tweets finalizado</p></body></html>");
        }

        writer.flush();
        writer.close();
    }
}