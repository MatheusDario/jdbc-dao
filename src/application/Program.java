package application;

import db.DB;
import model.entities.Department;

import java.sql.Connection;

public class Program {
    public static void main(String[] args) {

        Department obj = new Department(1, "books");

        System.out.println(obj);

        Connection conn = DB.getConnection();
        DB.closeConnection();
    }
}
