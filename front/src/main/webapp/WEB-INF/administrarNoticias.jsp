<%@ page import="mx.com.icvt.model.News" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Administración de noticias</title>
        <script type="text/javascript" src="bower_components/jquery/dist/jquery.min.js"></script>
        <script type="text/javascript">
            $(function () {
                $(".deshabilitar").click(function () {
                    if (confirm('\u00bfEst\u00e1s seguro de deshabilitar la noticia?')) {
                        var id = $(this).prop("id").replace("deshabilitar_", "");
                        $("#idNoticia").val(id);
                        $("#action").val("deshabilitar");
                        $("#main").submit();
                    }
                });

                $(".editar").click(function () {
                    if (confirm('\u00bfEst\u00e1s seguro de editar la noticia?')) {
                        var id = $(this).prop("id").replace("editar_", "");
                        $("#idNoticia").val(id);
                        $("#action").val("editar");
                        $("#main").submit();
                    }
                });
            });
        </script>
        <style type="text/css">
            td{border: 1px solid blue;}
        </style>
    </head>
    <body>
        <form action="administrarNoticias" method="post" id="main">
            <input type="hidden" name="action" id="action" value=""/>
            <input type="hidden" name="idNoticia" id="idNoticia" value=""/>
        </form>
        <table>
            <tr>
                <td>Título</td>
                <td>Descripción</td>
                <td>Fuente</td>
                <td>URL</td>
                <td>Fecha publicación</td>
                <td>Deshabilitar</td>
                <td>Editar</td>
            </tr>
            <%
                List<News> noticias = (List<News>) request.getAttribute("noticias");
                for (News noticia : noticias) {
            %>
            <tr>
                <td><%=noticia.getTitle()%>
                </td>
                <td><%=noticia.getDescription()%>
                </td>
                <td><%=noticia.getSource()%>
                </td>
                <td><%=noticia.getUrl()%>
                </td>
                <td><%=noticia.getPubDateString()%>
                </td>
                <td>
                    <input type="button" class="deshabilitar" id="<%= "deshabilitar_" + noticia.getID()%>" value="Deshabilitar"/>
                </td>
                <td>
                    <input type="button" class="editar" id="<%= "editar_" + noticia.getID()%>" value="Editar"/>
                </td>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>