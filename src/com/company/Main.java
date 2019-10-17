package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "Password1!!");

            Statement st = con.createStatement();
            String sql = ("SELECT * FROM student ORDER BY name DESC LIMIT 1;");
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                String name = rs.getString("name");
                System.out.println(name);
            }

            con.close();

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
