package com.uca.entity;
import java.util.Date;
import java.util.ArrayList;

public class StudentStickersEntity {

    private int           id;
    private String        reason;
    private String        date;
    public  TeacherEntity teacher = new TeacherEntity();
    public  StudentEntity student = new StudentEntity();
    public  StickerEntity sticker = new StickerEntity();


    public void setDate(String date)
    {
        this.date = date;
    }

    public String getDate()
    {
        return date;
    }

    public void setReason(String reason)
    {
        this.reason = reason;
    }

    public String getReason()
    {
        return reason;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return id;
    }

    public StudentEntity getStudent()
    {
        return student;
    }

    public StickerEntity getSticker()
    {
        return sticker;
    }

    public TeacherEntity getTeacher()
    {
        return teacher;
    }
   
   
   
}
