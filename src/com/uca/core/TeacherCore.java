package com.uca.core;
import com.uca.dao.TeacherDAO;
import com.uca.entity.TeacherEntity;

import java.util.ArrayList;

public class TeacherCore 
{

    /* -------------------------------------------------------------------------- */
    /* Get all teachers :                                                         */
    /* -------------------------------------------------------------------------- */
    
    public static ArrayList<TeacherEntity> getAllTeachers() 
    {
        ArrayList<TeacherEntity> list = new TeacherDAO().getAllTeachers();

        return list;
    }

    /* -------------------------------------------------------------------------- */
    /* Get teacher with Username :                                                */
    /* -------------------------------------------------------------------------- */
    
    public static TeacherEntity getTeacher(String username) 
    {
        TeacherEntity teacher = new TeacherDAO().getTeacher(username);

        return teacher;
    }

    /* -------------------------------------------------------------------------- */
    /* Get teacher with Id :                                                      */
    /* -------------------------------------------------------------------------- */
    
    public static TeacherEntity getTeacherId(int id) 
    {
        TeacherEntity teacher = new TeacherDAO().getTeacherId(id);

        return teacher;
    }


    /* -------------------------------------------------------------------------- */
    /* Create new teacher :                                                       */
    /* -------------------------------------------------------------------------- */

    public static void createTeacher(TeacherEntity teacher) 
    {
        new TeacherDAO().createTeacher(teacher);
    }


}
