package com.company;

import java.sql.*;
import java.util.Scanner;

public class Method {

    Scanner in = new Scanner(System.in);

    public void login() {
        System.out.print("Enter the username: ");
        String username = in.nextLine();
        System.out.print("Enter the password: ");
        String password = in.nextLine();
        System.out.print("Enter the name: ");
        String name = in.nextLine();
        Admin admin = new Admin(username, password, name);
        if (username.contains("admin") && password.contains("123456")) {
            int chooce = -1;
            while (chooce != 6) {
                System.out.println("Select one of following items: ");
                System.out.println("1: Add news");
                System.out.println("2: Delete news");
                System.out.println("3: List news");
                System.out.println("4: Add category");
                System.out.println("5: Change news category: ");
                System.out.println("6: Exit");

                chooce = in.nextInt();
                String choose;
                switch (chooce) {
                    case 1:
                        try {
                            System.out.print("Enter the id: ");
                            int id = in.nextInt();
                            System.out.print("Enter the title: ");
                            String titleNew = in.next();
                            System.out.print("Enter the content: ");
                            String content = in.next();
                            System.out.print("Enter the ID of category: ");
                            int categoryID = in.nextInt();
                            System.out.print("Enter the data: ");
                            int createdData = in.nextInt();
                            New news = new New(id, titleNew, content, categoryID, createdData);

                            Class.forName("com.mysql.jdbc.Driver");

                            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab11", "root", "");

                            Statement statement = connection.createStatement();
                            statement.execute("INSERT INTO news(title, content, category_id, created_data)" + "Values(" + titleNew + content + categoryID + createdData + ")");
                        } catch (ClassNotFoundException | SQLException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 2:
                        System.out.print("Enter the title for delete: ");
                        String deleteTitle = in.next();
                        try {
                            Class.forName("com.mysql.jdbc.Driver");

                            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab11", "root", "");

                            Statement statement = connection.createStatement();
                            statement.execute("DELETE FROM news WHERE title = " + deleteTitle);
                            connection.close();
                        } catch (ClassNotFoundException | SQLException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 3:
                        System.out.print("Enter the title: ");
                        String title = in.next();
                        System.out.print("Enter the content: ");
                        String contentNews = in.next();
                        try {
                            Class.forName("com.mysql.jdbc.Driver");

                            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab11", "root", "");

                            Statement statement = connection.createStatement();
                            ResultSet resultSet = statement.executeQuery("SELECT * FROM news");

                            while (resultSet.next()) {
                                System.out.println(resultSet.getString(title) + " " + resultSet.getString(contentNews));
                            }
                        } catch (ClassNotFoundException | SQLException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 4:
                        System.out.print("Enter the ID: ");
                        int idCategory = in.nextInt();
                        System.out.print("Enter the title: ");
                        String titleCategory = in.next();
                        Category category = new Category(idCategory, titleCategory);
                        try {
                            Class.forName("com.mysql.jdbc.Driver");

                            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab11", "root", "");

                            Statement statement = connection.createStatement();
                            statement.execute("INSERT INTO categories(title)" + "Values(" + titleCategory + ")");
                        } catch (ClassNotFoundException | SQLException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 5:
                        System.out.print("Enter the ID of: ");
                        int idChangeCategory = in.nextInt();
                        try {
                            Class.forName("com.mysql.jdbc.Driver");

                            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab11", "root", "");
                            
                            Statement statement = connection.createStatement();
                            statement.execute("UPDATE SET news(category_id)" + "Values(" + idChangeCategory + ")");
                        } catch (ClassNotFoundException | SQLException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 6:
                        break;
                    default:
                        choose = "You haven't chosen correctly!";
                        System.out.println(choose);
                        break;
                }

            }
        } else {
            System.out.println("You entered username or password incorrectly!");
        }
    }
}
