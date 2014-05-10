<%@ page import="java.util.List" %>
<%@ page import="mx.com.icvt.model.News" %>
<%@ page import="net.sf.json.JSONObject" %>
<%@ page import="net.sf.json.JSONArray" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    public String getJSONArray(String varName, Object objeto) {
        StringBuilder buffer = new StringBuilder("");
        if (objeto != null) {
            JSONArray array = JSONArray.fromObject(objeto);
            buffer.append("<script language='javascript'>\n");
            buffer.append("var " + varName + " = " + array + ";");
            buffer.append("</script>\n");
        }
        return buffer.toString();
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Actualidad de la industria</title>
        <%=getJSONArray("noticias", request.getAttribute("noticias"))%>
        <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
        <script>
            $(function(){
                var table = $("#noticias");
                var row;
                var title;
                var description;
                var image;
                var issueDate;
                var url;
                $.each(noticias, function(index, noticia){
                    row = $("<tr></tr>");

                    title = $("<td></td>");
                    title.text(noticia.title.substring(0, 20) + " ...");

                    description = $("<td></td>");
                    description.text(noticia.description.substring(0, 50) + " ...");

                    url = $("<td></td>");
                    url.text(noticia.url.substring(0, 20) + " ...");

                    image = $("<td></td>");
                    image.text(noticia.image.substring(0, 20) + " ...");

                    issueDate = $("<td></td>");
                    issueDate.text(noticia.pubDateString);

                    row.append(title);
                    row.append(description);
                    row.append(url);
                    row.append(image);
                    row.append(issueDate);
                    table.append(row);
                });
            });
        </script>
    </head>
    <body>
        <h2>Noticias</h2>
        <table id="noticias">
            <tr>
                <td>Titulo</td>
                <td>Descripcion</td>
                <td>Imagen</td>
                <td>Fecha publicación</td>
            </tr>
        </table>
    </body>
</html>