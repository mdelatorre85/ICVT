package mx.com.icvt.front;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.com.icvt.persistence.impl.user.UserResultData;
import mx.com.icvt.persistence.impl.user.User;
import net.sf.json.JSONArray;

@PersistenceContext
public class UserRestServlet extends HttpServlet {

    private class RestRequest {

        private Pattern regExAllPattern = Pattern.compile("/user/");
        private Pattern regExIdPattern = Pattern.compile("/user/([0-9a-z]*)");

        private String id;

        public RestRequest(String pathInfo) throws ServletException {
            // regex parse pathInfo
            Matcher matcher;

            // Check for ID case first, since the All pattern would also match
            matcher = regExIdPattern.matcher(pathInfo);
            if (matcher.find()) {
                id = matcher.group(1);
                return;
            }

            matcher = regExAllPattern.matcher(pathInfo);
            if (matcher.find()) return;

            throw new ServletException("Invalid URI");
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        out.println("GET request handling");
        out.println(request.getPathInfo());
        out.println(request.getParameterMap());

        try {
            RestRequest resourceValues = new RestRequest(request.getPathInfo());
            out.println(resourceValues.getId());
        } catch (ServletException e) {
            response.setStatus(400);
            response.resetBuffer();
            e.printStackTrace();
            out.println(e.toString());
        }

        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        try {
            RestRequest resourceValues = new RestRequest(request.getPathInfo());
        } catch (ServletException e) {
            response.setStatus(400);
            response.resetBuffer();
            e.printStackTrace();
            out.println(e.toString());
        }

        UserResultData obj =new UserResultData();
        User us = new User();

        String user = request.getParameter("identity");
        String pass = request.getParameter("password");

        us.setIdentity(user);
        us.setPassword(pass);
        obj.user=us;

        List<User> listUser = obj.login();

        if(listUser!=null){
            JSONArray array = JSONArray.fromObject(listUser);
            out.println(array);
        }

        out.close();
    }

}