package com.uca.dao;

import java.sql.*;

public class _Initializer {

    public static void Init(){
        Connection connection = _Connector.getInstance();

        try {
            PreparedStatement statement;

            //Init articles table
            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS users (id int primary key auto_increment, firstname varchar(100), lastname varchar(100));");
            statement.executeUpdate();     

            //Todo Remove me !
            statement = connection.prepareStatement("INSERT INTO users(firstname, lastname) VALUES(?, ?);");
            statement.setString(1, "Theodore");
            statement.setString(2, "Muillerez");
            statement.executeUpdate();


            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS students (id int primary key auto_increment, firstname varchar(100), lastname varchar(100), classroom varchar(100), birthdate varchar(100) );");
            statement.executeUpdate();

            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS teachers (id int primary key auto_increment, firstname varchar(100), lastname varchar(100), username varchar(100), password varchar(100));");
            statement.executeUpdate();

            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS stickers (id int primary key auto_increment, color varchar(100), description varchar(100) );");
            statement.executeUpdate();

            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS studentStickers (id int primary key auto_increment, idStudent int, foreign key (idStudent) references students ON DELETE CASCADE, idSticker int, foreign key (idSticker) references stickers ON DELETE CASCADE, idTeacher int, foreign key (idTeacher) references teachers ON DELETE CASCADE, reason varchar(100), date varchar(100));");
            statement.executeUpdate();

            // Sticker base colors

            statement = connection.prepareStatement("INSERT INTO stickers(color, description) VALUES(?, ?);");
            statement.setString(1, "#1ad1ff");
            statement.setString(2, "First description sample.");
            statement.executeUpdate();

            statement = connection.prepareStatement("INSERT INTO stickers(color, description) VALUES(?, ?);");
            statement.setString(1, "#00ff40");
            statement.setString(2, "Second description sample.");
            statement.executeUpdate();

            statement = connection.prepareStatement("INSERT INTO stickers(color, description) VALUES(?, ?);");
            statement.setString(1, "#e252ff");
            statement.setString(2, "A description sample.");
            statement.executeUpdate();

            // Teachers demo

            statement = connection.prepareStatement("INSERT INTO teachers(firstname, lastname, username, password) VALUES(?, ?, ?, ?);");
            statement.setString(1, "Natan");
            statement.setString(2, "Silva");
            statement.setString(3, "natansilva");
            statement.setString(4, "1234");
            statement.executeUpdate();

            statement = connection.prepareStatement("INSERT INTO teachers(firstname, lastname, username, password) VALUES(?, ?, ?, ?);");
            statement.setString(1, "Linda");
            statement.setString(2, "Hamdani");
            statement.setString(3, "lindahamdani");
            statement.setString(4, "1234");
            statement.executeUpdate();

            // Students demo

            statement = connection.prepareStatement("INSERT INTO students(firstname, lastname, classroom, birthdate) VALUES(?, ?, ?, ?);");
            statement.setString(1, "Rafael");
            statement.setString(2, "Baptista");
            statement.setString(3, "L2");
            statement.setString(4, "27/04/97");
            statement.executeUpdate();

            statement = connection.prepareStatement("INSERT INTO students(firstname, lastname, classroom, birthdate) VALUES(?, ?, ?, ?);");
            statement.setString(1, "Liza");
            statement.setString(2, "Toumi");
            statement.setString(3, "L2");
            statement.setString(4, "07/07/2007");
            statement.executeUpdate();

            statement = connection.prepareStatement("INSERT INTO students(firstname, lastname, classroom, birthdate) VALUES(?, ?, ?, ?);");
            statement.setString(1, "Fadi");
            statement.setString(2, "Nadal");
            statement.setString(3, "L2");
            statement.setString(4, "05/05/2005");
            statement.executeUpdate();

            // studentStickers demo

            statement = connection.prepareStatement("INSERT INTO studentStickers(idStudent, idSticker, idTeacher, reason, date) VALUES(?, ?, ?, ?, ?);");
            statement.setInt(1, 1);
            statement.setInt(2, 1);
            statement.setInt(3, 2);
            statement.setString(4, "Un motif pour avoir une gommet.");
            statement.setString(5, "2022-04-27");
            statement.executeUpdate();

            statement = connection.prepareStatement("INSERT INTO studentStickers(idStudent, idSticker, idTeacher, reason, date) VALUES(?, ?, ?, ?, ?);");
            statement.setInt(1, 1);
            statement.setInt(2, 2);
            statement.setInt(3, 1);
            statement.setString(4, "Trois motifs pour avoir une gommet.");
            statement.setString(5, "2022-03-15");
            statement.executeUpdate();

            statement = connection.prepareStatement("INSERT INTO studentStickers(idStudent, idSticker, idTeacher, reason, date) VALUES(?, ?, ?, ?, ?);");
            statement.setInt(1, 2);
            statement.setInt(2, 1);
            statement.setInt(3, 2);
            statement.setString(4, "Un deuxieme motif pour avoir une gommet.");
            statement.setString(5, "2022-03-08");
            statement.executeUpdate();

            statement = connection.prepareStatement("INSERT INTO studentStickers(idStudent, idSticker, idTeacher, reason, date) VALUES(?, ?, ?, ?, ?);");
            statement.setInt(1, 3);
            statement.setInt(2, 3);
            statement.setInt(3, 1);
            statement.setString(4, "Un troisieme motif pour avoir une gommet.");
            statement.setString(5, "2022-04-27");
            statement.executeUpdate();

        } catch (Exception e){
            System.out.println(e.toString());
            throw new RuntimeException("could not create database !");
        }
    }
}
