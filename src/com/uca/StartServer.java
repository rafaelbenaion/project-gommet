package com.uca;

import java.lang.*;
import com.uca.dao._Initializer;
import com.uca.gui.*;
import com.uca.core.*;
import com.uca.entity.StickerEntity;
import com.uca.entity.TeacherEntity;
import com.uca.entity.StudentEntity;

import static spark.Spark.*;
import spark.Request;

public class StartServer {
 
    public static void main(String[] args) {
  
        staticFiles.location("/static/");
        port(24330);    

        _Initializer.Init();

        /* -------------------------------------------------------------------- */
        /* Route Configuration :                                                */
        /* -------------------------------------------------------------------- */

        get("/", (req, res) -> {
            return UserGUI.getHome();
        });

        /* -------------------------------------------------------------------- */
        /* Student :                                                            */
        /* -------------------------------------------------------------------- */

        get("/students", (req, res) -> {         
            return StudentGUI.getAllStudents(checkLogin(req));
        });

        post("/students", (req, res) -> {
            
            StudentEntity student  = new StudentEntity();
            student.setFirstName(req.queryParams("firstName"));
            student.setLastName(req.queryParams("lastName"));
            student.setBirthDate(req.queryParams("birthdate"));
            student.setClassroom(req.queryParams("classroom"));

            if(checkLogin(req))
            {
                StudentCore.createStudent(student);
            }

            return StudentGUI.getAllStudents(checkLogin(req));
        });

        get("/students/:id/delete", (req, res) -> {

            int id = Integer.parseInt(req.params(":id"));

            if(checkLogin(req))
            {
                StudentCore.deleteStudent(id);
            }

            res.redirect("/students");
			return null;
        });

        get("/students/:id", (req, res) -> {

            int id = Integer.parseInt(req.params(":id"));

            return StudentGUI.getStudent(id, checkLogin(req), req);
        });

        get("/students/:id/edit", (req, res) -> {
        
            if(!checkLogin(req))
            {
                res.redirect("/students");
                return null;
            }
            
            int id = Integer.parseInt(req.params(":id"));
            return StudentGUI.getEditStudent(id);
        });

        post("/students/:id/edit", (req, res) -> {
            
            if(checkLogin(req))
            {
                int id = Integer.parseInt(req.params(":id"));
                StudentCore.updateStudent(id, req);
            }
    
            res.redirect("/students");
			return null;
        });

        post("/students/:id", (req, res) -> {
        
            int student = Integer.parseInt(req.params(":id"));

            if(checkLogin(req))
            {
                StudentStickersCore.giveStudentSticker(req);
            }
            
            return StudentGUI.getStudent(student, checkLogin(req), req);
        });

        /* -------------------------------------------------------------------- */
        /* Teacher :                                                            */
        /* -------------------------------------------------------------------- */

        get("/teachers", (req, res) -> {
            return TeacherGUI.getAllTeachers(checkLogin(req));
        });

        post("/teachers", (req, res) -> {
            
            TeacherEntity teacher  = new TeacherEntity();
            teacher.setFirstName(req.queryParams("firstName"));
            teacher.setLastName(req.queryParams("lastName"));
            teacher.setUsername(req.queryParams("username"));
            teacher.setPassword(req.queryParams("password"));

            TeacherEntity loggedTeacher = getLoggedTeacher(req);
            if(!checkLogin(req))
            {
                res.redirect("/teachers");
                return null;
            }

            TeacherCore.createTeacher(teacher);
            return TeacherGUI.getAllTeachers(true);
        });

        /* -------------------------------------------------------------------- */
        /* Login :                                                              */
        /* -------------------------------------------------------------------- */

        get("/login", (req, res) -> {
            return TeacherGUI.getLogin(req, checkLogin(req));
        });

        post("/login", (req, res) -> {
            
            String username = req.queryParams("username");
            String password = req.queryParams("password");
            String logout   = req.queryParams("logout");

            if(logout != null && logout.equals("out"))
            {
                return TeacherGUI.authLogout(req);
            }

            return TeacherGUI.authLogin(username, password, req);
            
        });

        /* -------------------------------------------------------------------- */
        /* Sticker :                                                            */
        /* -------------------------------------------------------------------- */

        get("/stickers/:id", (req, res) -> {

            int id = Integer.parseInt(req.params(":id"));
        
            if(!checkLogin(req))
            {
                res.redirect("/stickers");
                return null;
            }

            return StudentStickersGUI.getSticker(id);
        });

        get("/stickers", (req, res) -> {
            return StudentStickersGUI.getAllStickers(checkLogin(req));
        });

        post("/stickers", (req, res) -> {
            
            StickerEntity sticker  = new StickerEntity();
            sticker.setColor("" + req.queryParams("color"));
            sticker.setDescription("" + req.queryParams("description"));

            if(checkLogin(req))
            {
                StudentStickersCore.createSticker(sticker);
            }
            
            return StudentStickersGUI.getAllStickers(checkLogin(req));
        });

        get("/stickers/:id/delete", (req, res) -> {
            
            int id = Integer.parseInt(req.params(":id"));

            if(checkLogin(req))
            {
                StudentStickersCore.deleteSticker(id);
            }

            res.redirect("/stickers");
			return null;
        });

        post("/stickers/:id/edit", (req, res) -> {
            
            int id = Integer.parseInt(req.params(":id"));

            if(checkLogin(req))
            {
                StudentStickersCore.updateSticker(id, req);
            }
            
            res.redirect("/stickers");
			return null;
        });

        get("/studentstickers/:id/delete/:idStudent", (req, res) -> {
            
            int id        = Integer.parseInt(req.params(":id"));
            int idStudent = Integer.parseInt(req.params(":idStudent"));
            
            if(checkLogin(req))
            {
                StudentStickersCore.deleteStudentSticker(id);
            }

            res.redirect("/students/" + idStudent);
			return null;
        });
    }

    /* -------------------------------------------------------------------- */
    /* Verify logged Teacher  :                                             */
    /* -------------------------------------------------------------------- */

    private static TeacherEntity getLoggedTeacher(Request request) {
		return request.session().attribute("logged_session");
	}

    private static boolean checkLogin(Request request) {
       
        TeacherEntity loggedTeacher = getLoggedTeacher(request);
        
        return loggedTeacher != null;
	}
   
}