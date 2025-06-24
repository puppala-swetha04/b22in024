package com.abc;

import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.*;

@SuppressWarnings("serial")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("username");
        String pass = request.getParameter("password");

        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO users(username, password) VALUES(?, ?)");
            ps.setString(1, name);
            ps.setString(2, pass);
            ps.executeUpdate();

            response.sendRedirect("login.html");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
