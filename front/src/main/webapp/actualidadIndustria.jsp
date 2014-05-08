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
        <title>Inteligencia Social</title>
        <%=getJSONArray("noticias", request.getAttribute("noticias"))%>
    </head>
    <body>
        <scrip>
            alert(noticias);
        </scrip>
    </body>
</html>