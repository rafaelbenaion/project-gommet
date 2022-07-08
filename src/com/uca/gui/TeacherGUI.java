package com.uca.gui;

import com.uca.core.TeacherCore;
import com.uca.entity.TeacherEntity;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.lang.*;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import spark.Request;

public class TeacherGUI {

    /* -------------------------------------------------------------------------- */
    /* Get all students stickers page :                                           */
    /* -------------------------------------------------------------------------- */

    public static String getAllTeachers(boolean isLoggedIn) throws IOException, TemplateException {
        
        Configuration       configuration = _FreeMarkerInitializer.getContext();
        Map<String, Object> input         = new HashMap<>();
        Writer              output        = new StringWriter();
        Template            template      = configuration.getTemplate("teachers/teachers.ftl");

        if(isLoggedIn)
        {
            input.put("logged", "yes");
        }
        
        input.put("teachers", TeacherCore.getAllTeachers());

        template.setOutputEncoding("UTF-8");
        template.process(input,     output);

        return output.toString();
    }

    /* -------------------------------------------------------------------------- */
    /* Get login page :                                                           */
    /* -------------------------------------------------------------------------- */

    public static String getLogin(Request req, boolean isLoggedIn) throws IOException, TemplateException {
        
        Configuration       configuration  =  _FreeMarkerInitializer.getContext();
        Map<String, Object> input          =  new HashMap<>();
        Writer              output         =  new StringWriter();
        Template            template       =  configuration.getTemplate("auth/login.ftl");
        TeacherEntity       loggedTeacher  =  getLoggedTeacher(req);

        if(isLoggedIn)
        {
            String success = "Welcome, " + loggedTeacher.getFirstName() + " !";
            input.put("success", success);  
        }

        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }

    /* -------------------------------------------------------------------------- */
    /* Get logout page :                                                          */
    /* -------------------------------------------------------------------------- */

    public static String authLogout(Request req) throws IOException, TemplateException {
        
        Configuration       configuration  =  _FreeMarkerInitializer.getContext();
        Map<String, Object> input          =  new HashMap<>();
        Writer              output         =  new StringWriter();
        Template            template       =  configuration.getTemplate("auth/login.ftl");

        logoutTeacher(req);

        // Send logout message
        input.put("error", "You have successfully logged out."); 

        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }

    /* -------------------------------------------------------------------------- */
    /* Verify teacher authentication :                                            */
    /* -------------------------------------------------------------------------- */

    public static String authLogin(String username, String password, Request req) throws IOException, TemplateException
    {
        Configuration       configuration  =  _FreeMarkerInitializer.getContext();
        Map<String, Object> input          =  new HashMap<>();
        TeacherEntity       teacher        =  TeacherCore.getTeacher(username);

        if( teacher.getUsername() == null || (!teacher.getPassword().equals(password)) )
        {
            // Send error message
            String error = "You have entered an invalid username or password.";
            input.put("error", error); 
        }
        else
        {
            // Send success reponse
            String success = "Welcome, " + teacher.getFirstName() + " !";
            input.put("success", success); 
            req.session().attribute("logged_session", teacher);
        }

        Writer output       = new StringWriter();
        Template template   = configuration.getTemplate("auth/login.ftl");
        
        template.setOutputEncoding("UTF-8");
        template.process(input,     output);

        return output.toString();
    }

    private static void logoutTeacher(Request request) {
		request.session().removeAttribute("logged_session");
	}

	private static TeacherEntity getLoggedTeacher(Request request) {
		return request.session().attribute("logged_session");
	}

}
