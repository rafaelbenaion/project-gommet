package com.uca.gui;

import com.uca.entity.TeacherEntity;
import com.uca.entity.StudentEntity;
import com.uca.core.StudentCore;
import com.uca.core.StudentStickersCore;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import spark.Request;

public class StudentGUI 
{

    /* -------------------------------------------------------------------------- */
    /* Get all students page :                                                    */
    /* -------------------------------------------------------------------------- */

    public static String getAllStudents(boolean isLoggedIn) throws IOException, TemplateException 
    {
        Configuration       configuration = _FreeMarkerInitializer.getContext();
        Map<String, Object> input         = new HashMap<>();
        Writer              output        = new StringWriter();
        Template            template      = configuration.getTemplate("students/students.ftl");
        
        if(isLoggedIn)
        {
            input.put("logged", "yes");
        }

        input.put("students", StudentCore.getAllStudents());

        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }

    /* -------------------------------------------------------------------------- */
    /* Get one student page :                                                     */
    /* -------------------------------------------------------------------------- */

    public static String getStudent(int id, boolean isLoggedIn, Request req) throws IOException, TemplateException
    {
        Configuration       configuration = _FreeMarkerInitializer.getContext();
        Map<String, Object> input         = new HashMap<>();
        Writer              output        = new StringWriter();
        Template            template      = configuration.getTemplate("students/student.ftl");
        TeacherEntity       loggedTeacher = getLoggedTeacher(req);

        if(isLoggedIn)
        {
            input.put("logged", loggedTeacher.getId());
        }

        input.put("student", StudentCore.getStudent(id));      // Get student by ID
        input.put("stickers", StudentStickersCore.getAllStickers()); // Get Stickers
        
        template.setOutputEncoding("UTF-8");
        template.process(input,     output);

        return output.toString();
    }

    /* -------------------------------------------------------------------------- */
    /* Get student edit page :                                                    */
    /* -------------------------------------------------------------------------- */

    public static String getEditStudent(int id) throws IOException, TemplateException
    {
        Configuration       configuration = _FreeMarkerInitializer.getContext();
        Map<String, Object> input         = new HashMap<>();
        Writer              output        = new StringWriter();
        Template            template      = configuration.getTemplate("students/student_edit.ftl");

        input.put("student", StudentCore.getStudent(id));      // Get student by ID
        
        template.setOutputEncoding("UTF-8");
        template.process(input,     output);

        return output.toString();
    }

    private static TeacherEntity getLoggedTeacher(Request request) {
		return request.session().attribute("logged_session");
	}
}
 