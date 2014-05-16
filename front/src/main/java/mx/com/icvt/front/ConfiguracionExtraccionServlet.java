package mx.com.icvt.front;

import mx.com.icvt.persistence.impl.news.ConfiguracionExtraccionNoticias;
import mx.com.icvt.persistence.impl.news.NewsDataPersister;
import mx.com.icvt.persistence.impl.news.NewsDataRetriever;
import mx.com.icvt.persistence.impl.tweets.ConfiguracionExtraccionTweets;
import mx.com.icvt.persistence.impl.tweets.TweetsDataPersister;
import mx.com.icvt.persistence.impl.tweets.TweetsDataRetriever;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Cesar
 * Date: 06/05/14
 * Time: 21:37
 */
public class ConfiguracionExtraccionServlet extends HttpServlet {
    private static final long serialVersionUID = -580780477345298259L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tipo = request.getParameter("tipo");
        assert tipo != null;

        if (tipo.equals("noticia")) {
            persistirConfiguracionExtraccionNoticias(request);
        } else if (tipo.equals("tweet")) {
            persistirConfiguracionExtraccionTweets(request);
        }

        doGet(request, response);
    }

    private void persistirConfiguracionExtraccionNoticias(HttpServletRequest request) {
        String terminoBusqueda = request.getParameter("terminoBusqueda");
        assert terminoBusqueda != null;
        if (!terminoBusqueda.isEmpty()) {
            NewsDataPersister persister;
            ConfiguracionExtraccionNoticias configuracion;

            persister = new NewsDataPersister();
            configuracion = new ConfiguracionExtraccionNoticias(terminoBusqueda, "");
            persister.persist(configuracion);
        }
    }

    private void persistirConfiguracionExtraccionTweets(HttpServletRequest request) {
        String terminoBusquedaParam = request.getParameter("terminoBusqueda");
        String fechaInicioParam = request.getParameter("fechaInicio");
        String fechaFinParam = request.getParameter("fechaFin");
        String numeroResultadosParam = request.getParameter("numeroResultados");
        String tipoBusquedaParam = request.getParameter("tipoBusqueda");
        String tipoResultadoParam = request.getParameter("tipoResultado");

        assert terminoBusquedaParam != null;
        assert fechaInicioParam != null;
        assert fechaFinParam != null;
        assert numeroResultadosParam != null;
        assert tipoBusquedaParam != null;
        assert tipoResultadoParam != null;

        Date fechaInicio = null;
        Date fechaFin = null;
        int numeroResultados = 100;
        int tipoBusqueda = 0;
        int tipoResultado = 0;

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        if (!terminoBusquedaParam.isEmpty()) {
            if (!fechaInicioParam.isEmpty()) {
                try {
                    fechaInicio = format.parse(fechaInicioParam);
                } catch (ParseException ignored) {
                }
            }

            if (!fechaFinParam.isEmpty()) {
                try {
                    fechaFin = format.parse(fechaFinParam);
                } catch (ParseException ignored) {
                }
            }

            if (!numeroResultadosParam.isEmpty()) {
                try {
                    numeroResultados = Integer.parseInt(numeroResultadosParam);
                } catch (NumberFormatException ignored) {
                }
            }

            if (!tipoBusquedaParam.isEmpty()) {
                try {
                    tipoBusqueda = Integer.parseInt(tipoBusquedaParam);
                } catch (NumberFormatException ignored) {
                }
            }

            if (!tipoResultadoParam.isEmpty()) {
                try {
                    tipoResultado = Integer.parseInt(tipoResultadoParam);
                } catch (NumberFormatException ignored) {
                }
            }

            ConfiguracionExtraccionTweets configuracion;
            TweetsDataPersister persister;

            persister = new TweetsDataPersister();
            configuracion = new ConfiguracionExtraccionTweets(terminoBusquedaParam);
            configuracion.setNumeroResultados(numeroResultados);
            configuracion.setTipoBusqueda(tipoBusqueda);
            configuracion.setTipoResultado(tipoResultado);
            configuracion.setFechaInicio(fechaInicio);
            configuracion.setFechaFin(fechaFin);
            persister.persist(configuracion);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NewsDataRetriever newsDataRetriever = new NewsDataRetriever();
        TweetsDataRetriever tweetsDataRetriever = new TweetsDataRetriever();
        List<ConfiguracionExtraccionNoticias> configuracionesNoticias = newsDataRetriever.getAllConfigurations();
        List<ConfiguracionExtraccionTweets> configuracionesTweets = tweetsDataRetriever.getAllConfigurations();

        request.setAttribute("configuracionesNoticias", configuracionesNoticias);
        request.setAttribute("configuracionesTweets", configuracionesTweets);
        RequestDispatcher dispatcher = request.getRequestDispatcher("configuracionExtraccion.jsp");
        dispatcher.forward(request, response);
    }
}
