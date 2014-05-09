package mx.com.icvt.front;

import mx.com.icvt.extraction.ProcesoExtraccionNoticias;
import mx.com.icvt.persistence.impl.news.ExtraccionNoticias;

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
public class ExtraerNoticiasServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ProcesoExtraccionNoticias pen = new ProcesoExtraccionNoticias();
        pen.extraerNoticias();
        PrintWriter writer = response.getWriter();
        writer.print("<html><head><title>Extracci\u00f3n noticias></title></head>");
        writer.print("<body><p>Proceso extracción noticias finalizado</p></body></html>");
        writer.flush();
        writer.close();
    }
}
