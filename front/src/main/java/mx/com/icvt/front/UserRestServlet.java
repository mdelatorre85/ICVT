package mx.com.icvt.front;


import mx.com.icvt.persistence.impl.user.User;
import mx.com.icvt.persistence.impl.user.UserResultData;
import net.sf.json.JSONArray;
import org.apache.commons.codec.binary.Base64;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.security.*;
import java.security.MessageDigest;


public class UserRestServlet extends HttpServlet {

    private class RestRequest {

        private Pattern regExAllPattern = Pattern.compile("/users/");
        private Pattern regExIdPattern = Pattern.compile("/users/([0-9a-z]*)");
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
         out.println("hollaa");

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


       //  if(action.equals("login")){
            UserResultData obj = new UserResultData();
            User us = new User();
            String user = request.getParameter("identity");
            String pass = request.getParameter("password");
            us.setIdentity(user);
            us.setPassword(pass);
            obj.user=us;

            List<User> listUser = obj.login();

            if(listUser==null){
                response(response,"{errors:\"Username or password incorrect.\"}"+obj.getPassword());
            }else{
                listUser.get(0).setPassword("");
                // listUser.remove();
                JSONArray array = JSONArray.fromObject(listUser);
                response(response,array.toString());
            }
       // }


/*


        try {
            RestRequest resourceValues = new RestRequest(request.getPathInfo());
            action=resourceValues.getId();

            if(action.equals("add")){

                UserResultData obj = new UserResultData();
                User us = new User();
                String user = request.getParameter("identity");
                String pass = request.getParameter("password");
                us.setAvatar(request.getParameter("avatar"));
                us.setUnidad_economica_id( Integer.parseInt(request.getParameter("unidad")));
                us.setPhone(request.getParameter("phone"));
                us.setRole_site_id(Integer.parseInt(request.getParameter("rol_site_id")));
                us.setRole_social_id(Integer.parseInt(request.getParameter("rol_social_id")));
                us.setName(request.getParameter("name"));
                us.setFirst_name(request.getParameter("first_name"));
                us.setLast_name(request.getParameter("last_name"));
                us.setIdentity(user);
                us.setPassword(pass);
                us.setStatus(1);
                obj.user=us;

                List<User> listUser = obj.save();

                if(listUser==null){
                    response(response,"{errors:\"Not save user\"}");
                }else{
                    listUser.get(0).setPassword("");
                    // listUser.remove();
                    JSONArray array = JSONArray.fromObject(listUser);
                    response(response,array.toString());
                }
            }

            if(action.equals("login")){
                UserResultData obj = new UserResultData();
                User us = new User();
                String user = request.getParameter("identity");
                String pass = request.getParameter("password");
                us.setIdentity(user);
                us.setPassword(pass);
                obj.user=us;

                List<User> listUser = obj.login();

                if(listUser==null){
                    response(response,"{errors:\"Username or password incorrect.\"}");
                }else{
                    listUser.get(0).setPassword("");
                    // listUser.remove();
                    JSONArray array = JSONArray.fromObject(listUser);
                    response(response,array.toString());
                }
            }

            if(action.equals("delete")){


            }

        } catch (ServletException e) {
            response.setStatus(400);
            response.resetBuffer();
            e.printStackTrace();
            out.println(e.toString());
        }
        */
    }



    private void response(HttpServletResponse resp, String msg)
            throws IOException {
        PrintWriter out = resp.getWriter();

        out.println(msg);
    }

}