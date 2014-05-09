<%@ page import="mx.com.icvt.persistence.impl.tags.Etiqueta" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Administrador de etiquetas</title>
    </head>
    <body>
        <h2>Etiquetas actuales</h2>
        <table>
            <tr>
                <td>ID</td>
                <td>Valor</td>
            </tr>
            <%
                List<Etiqueta> etiquetas = (List<Etiqueta>) request.getAttribute("etiquetas");
                for (Etiqueta etiqueta : etiquetas) {
            %>
            <tr>
                <td><%=etiqueta.getId()%>
                </td>
                <td><%=etiqueta.getValor()%>
                </td>
            </tr>
            <%
                }
            %>
        </table>
        <h2>Agregar etiqueta</h2>
        <form action="etiquetas">
            Nombre de la etiqueta: <input type="text" name="nombreEtiqueta"/>
            <input type="hidden" name="action" value="persist"/>
            <input type="submit"/>
        </form>
    </body>
</html>