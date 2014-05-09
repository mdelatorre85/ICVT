<%@ page import="mx.com.icvt.persistence.impl.news.ConfiguracionExtraccionNoticias" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title></title>
    </head>
    <body>
        <h2>Configuraciones de extracción</h2>
        <table>
            <tr>
                Id
            </tr>
            <tr>
                Término de búsqueda
            </tr>
            <%
                List<ConfiguracionExtraccionNoticias> configuraciones;
                configuraciones = (List<ConfiguracionExtraccionNoticias>) request.getAttribute("configuraciones");

                for (ConfiguracionExtraccionNoticias configuracion : configuraciones) {
            %>
            <tr>
                <td>
                    <%= configuracion.getId()%>
                </td>
                <td>
                    <%= configuracion.getTerminoBusqueda()%>
                </td>
            </tr>
            <%
                }

            %>
        </table>
        <h2>
            Registrar nueva configuración
        </h2>
        <form action="configuracionExtraccion" method="get">
            Término de búsqueda: <input type="text" name="terminoBusqueda"/>
            <input type="hidden" name="action" value="persist"/>
            <input type="submit"/>
        </form>
    </body>
</html>