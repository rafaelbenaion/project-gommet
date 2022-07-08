package com.uca.core;
import com.uca.dao.StudentDAO;
import com.uca.dao.StudentStickersDAO;
import com.uca.entity.StudentEntity;
import spark.Request;

import java.util.ArrayList;

public class StudentCore 
{

    /* -------------------------------------------------------------------------- */
    /* Get all students :                                                     */
    /* -------------------------------------------------------------------------- */
    
    public static ArrayList<StudentEntity> getAllStudents() 
    {
        ArrayList<StudentEntity> list = new StudentDAO().getAllStudents();
        
        for(StudentEntity student : list){
            student.setStickerList(new StudentStickersDAO().getAllStudentStickersByStudentId(student.getId()));
        }

        return list;
    }

    /* -------------------------------------------------------------------------- */
    /* Get one student with ID :                                                  */
    /* -------------------------------------------------------------------------- */

    public static StudentEntity getStudent(int id) 
    {
        StudentEntity student = new StudentDAO().getStudent(id);

        student.setStickerList(new StudentStickersDAO().getAllStudentStickersByStudentId(student.getId()));
    
        return student;
    }

    /* -------------------------------------------------------------------------- */
    /* Create new student :                                                       */
    /* -------------------------------------------------------------------------- */

    public static void createStudent(StudentEntity student) 
    {
        new StudentDAO().createStudent(student);
    }

    /* -------------------------------------------------------------------------- */
    /* Delete one student with ID :                                               */
    /* -------------------------------------------------------------------------- */

    public static void deleteStudent(int id) 
    {
        new StudentDAO().deleteStudent(id);
    }

    /* -------------------------------------------------------------------------- */
    /* Update one student with ID :                                               */
    /* -------------------------------------------------------------------------- */

    public static void updateStudent(int id, Request req) 
    {
        new StudentDAO().updateStudent(id, req);
    }

}
