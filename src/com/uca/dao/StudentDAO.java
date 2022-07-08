package com.uca.dao;
import com.uca.entity.StudentEntity;
import java.sql.*;
import java.util.ArrayList;
import spark.Request;

public class StudentDAO extends _Generic<StudentEntity> 
{

    /* -------------------------------------------------------------------------- */
    /* Fonction : getAllStudents()                                                */
    /* -------------------------------------------------------------------------- */
    /* Input    : void                                                            */
    /* Output   : ArrayList<StudentEntity>                                        */
    /* -------------------------------------------------------------------------- */
    /* Get all students from database.                                            */
    /* -------------------------------------------------------------------------- */

    public ArrayList<StudentEntity> getAllStudents() 
    {
        ArrayList<StudentEntity> entities = new ArrayList<>();
        
        try 
        {
            PreparedStatement preparedStatement = this.connect.prepareStatement
            ("SELECT * FROM students ORDER BY id ASC;");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                StudentEntity entity = new StudentEntity();
                
                entity.setId            (resultSet.getInt("id"));
                entity.setFirstName     (resultSet.getString("firstname"));
                entity.setLastName      (resultSet.getString("lastname"));
                entity.setClassroom     (resultSet.getString("classroom"));
                entity.setBirthDate     (resultSet.getString("birthdate"));

                entities.add(entity);
            }
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return entities;
    }

    /* -------------------------------------------------------------------------- */
    /* Fonction : getStudent()                                                    */
    /* -------------------------------------------------------------------------- */
    /* Input    : Integer (Student Id)                                            */
    /* Output   : StudentEntity                                                   */
    /* -------------------------------------------------------------------------- */
    /* Get one student from database using ID.                                    */
    /* -------------------------------------------------------------------------- */

    public StudentEntity getStudent(int id) 
    {
        StudentEntity student = new StudentEntity();
    
        try 
        {
            PreparedStatement preparedStatement = this.connect.prepareStatement
            ("SELECT * FROM students WHERE id = ?;");
           
            preparedStatement.setInt(1, id);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            resultSet.next();

            student.setId            (resultSet.getInt("id"));
            student.setFirstName     (resultSet.getString("firstname"));
            student.setLastName      (resultSet.getString("lastname"));
            student.setClassroom     (resultSet.getString("classroom"));
            student.setBirthDate     (resultSet.getString("birthdate"));
            
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return student;
    }

    /* -------------------------------------------------------------------------- */
    /* Fonction : deleteStudent()                                                 */
    /* -------------------------------------------------------------------------- */
    /* Input    : Integer (Student Id)                                            */
    /* Output   : void                                                            */
    /* -------------------------------------------------------------------------- */
    /* Remove a student from the database using the id.                           */
    /* -------------------------------------------------------------------------- */

    public void deleteStudent(int id) 
    {
        try 
        {
            PreparedStatement preparedStatement = this.connect.prepareStatement
            ("DELETE FROM students WHERE id = ?;");

            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }

    /* -------------------------------------------------------------------------- */
    /* Fonction : createStudent()                                                 */
    /* -------------------------------------------------------------------------- */
    /* Input    : StudentEntity student                                           */
    /* Output   : void                                                            */
    /* -------------------------------------------------------------------------- */
    /* Create new student.                                                        */
    /* -------------------------------------------------------------------------- */

    public void createStudent(StudentEntity student) 
    {
        try 
        {
            PreparedStatement preparedStatement = this.connect.prepareStatement
            ("INSERT INTO students (firstname, lastname, birthdate, classroom) values (?, ?, ?, ?);");

            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setString(3, student.getBirthDate());
            preparedStatement.setString(4, student.getClassroom());
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }

    /* -------------------------------------------------------------------------- */
    /* Fonction : updateStudent()                                                 */
    /* -------------------------------------------------------------------------- */
    /* Input    : Integer (Student Id), Request req                               */
    /* Output   : void                                                            */
    /* -------------------------------------------------------------------------- */
    /* Update student information using the id.                                   */
    /* -------------------------------------------------------------------------- */

    public void updateStudent(int id, Request req) 
    {
        try 
        {
            PreparedStatement preparedStatement = this.connect.prepareStatement
            ("UPDATE students SET firstname = ?, lastname = ?, birthdate = ?, classroom = ? WHERE id = ?;");
            
            String firstName  = req.queryParams("firstName");
            String lastName   = req.queryParams("lastName");
            String birthdate  = req.queryParams("birthdate");
            String classroom  = req.queryParams("classroom");


            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, birthdate);
            preparedStatement.setString(4, classroom);
            preparedStatement.setInt(5, id);
            preparedStatement.execute();
            
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }

    @Override
    public StudentEntity create(StudentEntity obj) {
        return null;
    }

    @Override
    public void delete(StudentEntity obj) {
    }
}
