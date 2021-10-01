package com.company;

import java.sql.*;
import java.util.Scanner;

public class Method {

    Scanner in = new Scanner(System.in);

    public void user() {
        int chooce = -1;
        while (chooce != 4) {
            System.out.println("Select one of following items: ");
            System.out.println("1: Watch news");
            System.out.println("2: Filter news by category");
            System.out.println("3: Sort news by title");
            System.out.println("4: Exit");
            chooce = in.nextInt();

            String choose;
            switch (chooce) {
                case 1:
                    try {
                        Class.forName("com.mysql.jdbc.Driver");

                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab11", "root", "");
                        Statement statement = connection.createStatement();

                        ResultSet resultSet = statement.executeQuery("SELECT * FROM news");
                        System.out.println(resultSet);
                    } catch (ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default: choose = "You haven't chosen correctly!";
                    System.out.println(choose);
                    break;
            }
        }
    }
}
