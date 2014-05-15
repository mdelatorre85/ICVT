<%--suppress XmlDuplicatedId --%>
<%@ page import="mx.com.icvt.persistence.impl.news.ConfiguracionExtraccionNoticias" %>
<%@ page import="mx.com.icvt.persistence.impl.tweets.ConfiguracionExtraccionTweets" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Configuraciones de extraccion</title>
        <style type="text/css">
            label {
                display: block;
                padding-top: 5px;
            }

            form {
                overflow: hidden;
            }

            td{
                border: solid 1px #195f91;
            }
        </style>
    </head>
    <body>
        <h2>Configuraciones de extracción para noticias</h2>
        <table>
            <tr>
                <td>
                    Id
                </td>
                <td>
                    Término de búsqueda
                </td>
            </tr>

            <%
                List<ConfiguracionExtraccionNoticias> configuracionesNoticias;
                configuracionesNoticias = (List<ConfiguracionExtraccionNoticias>) request.getAttribute("configuracionesNoticias");

                for (ConfiguracionExtraccionNoticias configuracion : configuracionesNoticias) {
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

        <h2>Configuraciones de extracción para tweets</h2>
        <table>
            <tr>
                <td>
                    Id
                </td>
                <td>
                    Término de búsqueda
                </td>
                <td>
                    Fecha de inicio
                </td>
                <td>
                    Fecha de fin
                </td>
                <td>
                    Número de resultados
                </td>
                <td>
                    Tipo de búsqueda
                </td>
                <td>
                    Tipo de resultados
                </td>
            </tr>
            <%
                List<ConfiguracionExtraccionTweets> configuracionesTweets;
                configuracionesTweets = (List<ConfiguracionExtraccionTweets>) request.getAttribute("configuracionesTweets");

                for (ConfiguracionExtraccionTweets configuracion : configuracionesTweets) {
            %>
            <tr>
                <td>
                    <%= configuracion.getId()%>
                </td>
                <td>
                    <%= configuracion.getTerminoBusqueda()%>
                </td>
                <td>
                    <%= configuracion.getFechaInicio()%>
                </td>
                <td>
                    <%= configuracion.getFechaFin()%>
                </td>
                <td>
                    <%= configuracion.getNumeroResultados()%>
                </td>
                <td>
                    <%= configuracion.getTipoBusqueda()%>
                </td>
                <td>
                    <%= configuracion.getTipoResultado()%>
                </td>
            </tr>
            <%
                }

            %>
        </table>

        <h2>
            Registrar nueva configuración de búsqueda para noticia
        </h2>

        <form action="configuracionExtraccion" method="post">
            <label for="terminoBusqueda">Término de búsqueda: </label>
            <input type="text" name="terminoBusqueda" id="terminoBusqueda"/>

            <input type="hidden" name="tipo" value="noticia"/>
            <input type="submit"/>
        </form>

        <h2>
            Registrar nueva configuración de búsqueda para tweets
        </h2>

        <form action="configuracionExtraccion" method="post">
            <label for="terminoBusqueda">Término de búsqueda:</label>
            <input type="text" name="terminoBusqueda" id="terminoBusqueda"/>

            <label for="fechaInicio">Fecha de inicio (AAAA-MM-DD):</label>
            <input type="text" name="fechaInicio" id="fechaInicio"/>

            <label for="fechaFin">Fecha de fin (AAAA-MM-DD):</label>
            <input type="text" name="fechaFin" id="fechaFin"/>

            <label for="numeroResultados">Número de resultados: </label>
            <input type="text" name="numeroResultados" id="numeroResultados"/>

            <label for="tipoBusqueda">Tipo de búsqueda: </label>
            <select type="text" name="tipoBusqueda" id="tipoBusqueda">
                <option value="0">Timeline de usuario</option>
                <option value="1">Término de búsqueda</option>
            </select>

            <label for="tipoResultado">Tipo de resultados:</label>
            <select name="tipoResultado" id="tipoResultado">
                <option value="0">Populares</option>
                <option value="1">Mezcladas</option>
                <option value="2">Recientes</option>
            </select>

            <input type="hidden" name="tipo" value="tweet"/>
            <input type="submit"/>
        </form>
    </body>
</html>