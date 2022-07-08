package com.uca.dao;
import com.uca.entity.StudentStickersEntity;
import com.uca.entity.StickerEntity;
import com.uca.entity.TeacherEntity;
import com.uca.core.TeacherCore;
import java.sql.*;
import java.util.ArrayList;
import spark.Request;
import java.time.LocalDate;

public class StudentStickersDAO extends _Generic<StudentStickersEntity> 
{

    public ArrayList<StudentStickersEntity> getAllStudentStickers() 
    {
        ArrayList<StudentStickersEntity> entities = new ArrayList<>();
        
        try 
        {
            PreparedStatement preparedStatement = this.connect.prepareStatement
            ("SELECT * FROM studentStickers AS p JOIN stickers AS s ON s.id = p.idSticker JOIN students AS u ON u.id = p.idStudent ORDER BY p.idStudent ASC;");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                StudentStickersEntity entity = new StudentStickersEntity();
                
                entity.student.setFirstName     (resultSet.getString("firstname"));
                entity.student.setLastName      (resultSet.getString("lastname"));
                entity.student.setClassroom     (resultSet.getString("classroom"));
                entity.student.setBirthDate     (resultSet.getString("birthdate"));

                entity.sticker.setColor         (resultSet.getString("color"));
                entity.sticker.setDescription   (resultSet.getString("description"));       

                entities.add(entity);
            }
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return entities;
    }
    
    /* -------------------------------------------------------------------------- */
    /* Fonction : getAllStudentStickersByStudentId()                              */
    /* -------------------------------------------------------------------------- */
    /* Input    : Integer   = Student Id                                          */
    /* Output   : ArrayList = StudentStickersEntity                               */
    /* -------------------------------------------------------------------------- */
    /* Get all stickers of one student from the database using the student id.    */
    /* -------------------------------------------------------------------------- */

    public ArrayList<StudentStickersEntity> getAllStudentStickersByStudentId(Integer studentId) 
    {
        ArrayList<StudentStickersEntity> entities = new ArrayList<>();
        
        try 
        {
            PreparedStatement preparedStatement = this.connect.prepareStatement
            ("SELECT * FROM studentStickers AS p JOIN stickers AS s ON s.id = p.idSticker JOIN students AS u ON u.id = p.idStudent WHERE p.idStudent = ? ORDER BY p.idStudent ASC;");

            preparedStatement.setInt(1, studentId);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                StudentStickersEntity entity  = new StudentStickersEntity();
                TeacherEntity         teacher = TeacherCore.getTeacherId(resultSet.getInt("idTeacher"));
                
                entity.setId                    (resultSet.getInt("id"));
                entity.setReason                (resultSet.getString("reason"));
                entity.setDate                  (resultSet.getString("date"));

                entity.teacher.setFirstName     (teacher.getFirstName());
                entity.teacher.setLastName      (teacher.getLastName());
                
                entity.student.setFirstName     (resultSet.getString("firstname"));
                entity.student.setLastName      (resultSet.getString("lastname"));
                entity.student.setClassroom     (resultSet.getString("classroom"));
                entity.student.setBirthDate     (resultSet.getString("birthdate"));

                entity.sticker.setColor         (resultSet.getString("color"));
                entity.sticker.setDescription   (resultSet.getString("description"));       

                entities.add(entity);
            }
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return entities;
    }

    /* -------------------------------------------------------------------------- */
    /* Fonction : getAllStickers()                                                */
    /* -------------------------------------------------------------------------- */
    /* Input    : void                                                            */
    /* Output   : ArrayList = StickerEntity                                       */
    /* -------------------------------------------------------------------------- */
    /* Get all stickers from the database.                                        */
    /* -------------------------------------------------------------------------- */

    public ArrayList<StickerEntity> getAllStickers() 
    {
        ArrayList<StickerEntity> entities = new ArrayList<>();
        
        try 
        {
            PreparedStatement preparedStatement = this.connect.prepareStatement
            ("SELECT * FROM stickers ORDER BY id ASC;");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                StickerEntity entity = new StickerEntity();
                
                entity.setId            (resultSet.getInt("id"));
                entity.setColor         (resultSet.getString("color"));
                entity.setDescription   (resultSet.getString("description"));    

                entities.add(entity);
            }
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return entities;
    }

    @Override
    public StudentStickersEntity create(StudentStickersEntity obj) {
        
        return null;
    }

    /* -------------------------------------------------------------------------- */
    /* Fonction : getSticker()                                                    */
    /* -------------------------------------------------------------------------- */
    /* Input    : int id                                                          */
    /* Output   : StickerEntity                                                   */
    /* -------------------------------------------------------------------------- */
    /* Get one sticker from the database with id.                                 */
    /* -------------------------------------------------------------------------- */

    public StickerEntity getSticker(int id) 
    {
        StickerEntity sticker = new StickerEntity();
    
        try 
        {
            PreparedStatement preparedStatement = this.connect.prepareStatement
            ("SELECT * FROM stickers WHERE id = ?;");
           
            preparedStatement.setInt(1, id);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            resultSet.next();
            sticker.setId             (resultSet.getInt("id"));
            sticker.setColor          (resultSet.getString("color"));
            sticker.setDescription    (resultSet.getString("description"));

        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return sticker;
    }

    /* -------------------------------------------------------------------------- */
    /* Fonction : createSticker()                                                 */
    /* -------------------------------------------------------------------------- */
    /* Input    : StickerEntity sticker                                           */
    /* Output   : void                                                            */
    /* -------------------------------------------------------------------------- */
    /* Create a new sticker.                                                      */
    /* -------------------------------------------------------------------------- */

    public void createSticker(StickerEntity sticker) {

        Connection connection = _Connector.getInstance();
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement("INSERT INTO stickers(color, description) VALUES(?, ?);");
            statement.setString(1, sticker.getColor());
            statement.setString(2, sticker.getDescription());
            statement.executeUpdate();

        } catch (Exception e){
            System.out.println(e.toString());
            throw new RuntimeException("Error database !");
        }
    }
    
    /* -------------------------------------------------------------------------- */
    /* Fonction : deleteSticker()                                                 */
    /* -------------------------------------------------------------------------- */
    /* Input    : Integer (Sticker Id)                                            */
    /* Output   : void                                                            */
    /* -------------------------------------------------------------------------- */
    /* Delete a sticker from the database using the id.                           */
    /* -------------------------------------------------------------------------- */

    public void deleteSticker(int id) 
    {
        try 
        {
            PreparedStatement preparedStatement = this.connect.prepareStatement
            ("DELETE FROM stickers WHERE id = ?;");

            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }

    /* -------------------------------------------------------------------------- */
    /* Fonction : updateSticker()                                                 */
    /* -------------------------------------------------------------------------- */
    /* Input    : Integer (Sticker Id), Request req                               */
    /* Output   : void                                                            */
    /* -------------------------------------------------------------------------- */
    /* Update a sticker in the database using the id.                             */
    /* -------------------------------------------------------------------------- */

    public void updateSticker(int id, Request req) 
    {
        try 
        {
            PreparedStatement preparedStatement = this.connect.prepareStatement
            ("UPDATE stickers SET color = ?, description = ? WHERE id = ?;");
            
            String color        = req.queryParams("color");
            String description  = req.queryParams("description");

            preparedStatement.setString(1, color);
            preparedStatement.setString(2, description);
            preparedStatement.setInt(3, id);
            preparedStatement.execute();
            
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }

    /* -------------------------------------------------------------------------- */
    /* Fonction : deleteStudentSticker()                                          */
    /* -------------------------------------------------------------------------- */
    /* Input    : Integer (StudentSticker Id)                                     */
    /* Output   : void                                                            */
    /* -------------------------------------------------------------------------- */
    /* Remove a sticker from a student in the database using the id.              */
    /* -------------------------------------------------------------------------- */

    public void deleteStudentSticker(int id) 
    {
        try 
        {
            PreparedStatement preparedStatement = this.connect.prepareStatement
            ("DELETE FROM studentStickers WHERE id = ?;");

            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }

    /* -------------------------------------------------------------------------- */
    /* Fonction : giveStudentSticker()                                            */
    /* -------------------------------------------------------------------------- */
    /* Input    : Request req                                                     */
    /* Output   : void                                                            */
    /* -------------------------------------------------------------------------- */
    /* Assign a new sticker to a student passed in parameter.                     */
    /* -------------------------------------------------------------------------- */

    public void giveStudentSticker(Request req) {

        int    student = Integer.parseInt(req.params(":id"));
        int    sticker = Integer.parseInt(req.queryParams("color"));
        int    teacher = Integer.parseInt(req.queryParams("idTeacher"));
        String reason  = req.queryParams("reason");
        
        LocalDate today = LocalDate.now();

        Connection connection = _Connector.getInstance();
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement("INSERT INTO studentStickers(idStudent, idSticker, idTeacher, reason, date) VALUES(?, ?, ?, ?, ?);");
            statement.setInt(1, student);
            statement.setInt(2, sticker);
            statement.setInt(3, teacher);
            statement.setString(4, reason);
            statement.setString(5, "" + today);
            statement.executeUpdate();

        } catch (Exception e){
            System.out.println(e.toString());
            throw new RuntimeException("Error database !");
        }
    }

    @Override
    public void delete(StudentStickersEntity obj) {
    }
}
