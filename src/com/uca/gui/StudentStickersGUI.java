package com.uca.gui;

import com.uca.entity.StickerEntity;
import com.uca.entity.TeacherEntity;

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

public class StudentStickersGUI 
{

    /* -------------------------------------------------------------------------- */
    /* Get all students stickers page :                                           */
    /* -------------------------------------------------------------------------- */

    public static String getAllStudentStickers() throws IOException, TemplateException 
    {
        Configuration       configuration = _FreeMarkerInitializer.getContext();
        Map<String, Object> input         = new HashMap<>();
        Writer              output        = new StringWriter();
        Template            template      = configuration.getTemplate("studentstickers/studentstickers.ftl");

        input.put("studentstickers", StudentStickersCore.getAllStudentStickers());

        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }

    /* -------------------------------------------------------------------------- */
    /* Get all stickers page :                                                    */
    /* -------------------------------------------------------------------------- */

    public static String getAllStickers(boolean isLoggedIn) throws IOException, TemplateException 
    {
        Configuration       configuration = _FreeMarkerInitializer.getContext();
        Map<String, Object> input         = new HashMap<>();
        Writer              output        = new StringWriter();
        Template            template      = configuration.getTemplate("studentstickers/stickers.ftl");
        
        if(isLoggedIn)
        {
            input.put("logged", "yes");
        }

        input.put("stickers", StudentStickersCore.getAllStickers());
        
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }

    /* -------------------------------------------------------------------------- */
    /* Get sticker with ID :                                                      */
    /* -------------------------------------------------------------------------- */

    public static String getSticker(int id) throws IOException, TemplateException 
    {
        Configuration       configuration = _FreeMarkerInitializer.getContext();
        Map<String, Object> input         = new HashMap<>();
        Writer              output        = new StringWriter();
        Template            template      = configuration.getTemplate("studentstickers/sticker.ftl");

        input.put("sticker", StudentStickersCore.getSticker(id));
        
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }

    /* -------------------------------------------------------------------------- */
    /* Get logged teacher :                                                       */
    /* -------------------------------------------------------------------------- */

    private static TeacherEntity getLoggedTeacher(Request request) {
		return request.session().attribute("logged_session");
	}
    
}
