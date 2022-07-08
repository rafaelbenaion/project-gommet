package com.uca.dao;
import com.uca.entity.TeacherEntity;
import java.sql.*;
import java.util.ArrayList;

public class TeacherDAO extends _Generic<TeacherEntity> 
{

    /* -------------------------------------------------------------------------- */
    /* Fonction : getAllTeachers()                                                */
    /* -------------------------------------------------------------------------- */
    /* Input    : void                                                            */
    /* Output   : ArrayList = TeacherEntity                                       */
    /* -------------------------------------------------------------------------- */
    /* Get all teachers from the database.                                        */
    /* -------------------------------------------------------------------------- */


    public ArrayList<TeacherEntity> getAllTeachers() 
    {
        ArrayList<TeacherEntity> entities = new ArrayList<>();
        
        try 
        {
            PreparedStatement preparedStatement = this.connect.prepareStatement
            ("SELECT * FROM teachers ORDER BY id ASC;");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                TeacherEntity entity = new TeacherEntity();
                
                entity.setId            (resultSet.getInt("id"));
                entity.setFirstName     (resultSet.getString("firstname"));
                entity.setLastName      (resultSet.getString("lastname"));
                entity.setUsername      (resultSet.getString("username"));
                entity.setPassword      (resultSet.getString("password"));

                entities.add(entity);
            }
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return entities;
    }

    /* -------------------------------------------------------------------------- */
    /* Fonction : getTeacher()                                                    */
    /* -------------------------------------------------------------------------- */
    /* Input    : String username                                                 */
    /* Output   : TeacherEntity                                                   */
    /* -------------------------------------------------------------------------- */
    /* Get teacher from database using username passed in parameter.              */
    /* -------------------------------------------------------------------------- */

    public TeacherEntity getTeacher(String username) 
    {
        TeacherEntity teacher = new TeacherEntity();
    
        try 
        {
            PreparedStatement preparedStatement = this.connect.prepareStatement
            ("SELECT * FROM teachers WHERE username = ?;");
           
            preparedStatement.setString(1, username);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
                
            teacher.setId          (resultSet.getInt("id"));
            teacher.setFirstName   (resultSet.getString("firstname"));
            teacher.setLastName    (resultSet.getString("lastname"));
            teacher.setUsername    (resultSet.getString("username"));
            teacher.setPassword    (resultSet.getString("password"));
            
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return teacher;
    }

    /* -------------------------------------------------------------------------- */
    /* Fonction : getTeacher()                                                    */
    /* -------------------------------------------------------------------------- */
    /* Input    : int id                                                          */
    /* Output   : TeacherEntity                                                   */
    /* -------------------------------------------------------------------------- */
    /* Get teacher from database using ID passed in parameter.                    */
    /* -------------------------------------------------------------------------- */

    public TeacherEntity getTeacherId(int id) 
    {
        TeacherEntity teacher = new TeacherEntity();
    
        try 
        {
            PreparedStatement preparedStatement = this.connect.prepareStatement
            ("SELECT * FROM teachers WHERE id = ?;");
           
            preparedStatement.setInt(1, id);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
                
            teacher.setId          (resultSet.getInt("id"));
            teacher.setFirstName   (resultSet.getString("firstname"));
            teacher.setLastName    (resultSet.getString("lastname"));
            teacher.setUsername    (resultSet.getString("username"));
            teacher.setPassword    (resultSet.getString("password"));
            
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return teacher;
    }

    /* -------------------------------------------------------------------------- */
    /* Fonction : createTeacher()                                                 */
    /* -------------------------------------------------------------------------- */
    /* Input    : TeacherEntity teacher                                           */
    /* Output   : void                                                            */
    /* -------------------------------------------------------------------------- */
    /* Create new teacher.                                                        */
    /* -------------------------------------------------------------------------- */

    public void createTeacher(TeacherEntity teacher) 
    {
        try 
        {
            PreparedStatement preparedStatement = this.connect.prepareStatement
            ("INSERT INTO teachers (firstname, lastname, username, password) values (?, ?, ?, ?);");

            preparedStatement.setString(1, teacher.getFirstName());
            preparedStatement.setString(2, teacher.getLastName());
            preparedStatement.setString(3, teacher.getUsername());
            preparedStatement.setString(4, teacher.getPassword());
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }

    @Override
    public TeacherEntity create(TeacherEntity obj) {
        return null;
    }

    @Override
    public void delete(TeacherEntity obj) {
    }
}
