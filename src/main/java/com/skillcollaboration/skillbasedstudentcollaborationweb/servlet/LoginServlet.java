package com.skillcollaboration.skillbasedstudentcollaborationweb.servlet;

import com.skillcollaboration.skillbasedstudentcollaborationweb.dao.StudentDAO;
import com.skillcollaboration.skillbasedstudentcollaborationweb.dao.UserDAO;
import com.skillcollaboration.skillbasedstudentcollaborationweb.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();

        // =========================
        // ADMIN LOGIN
        // =========================
        UserDAO userDAO = new UserDAO();

        if (userDAO.validateUser(username, password)) {

            session.setAttribute("username", username);
            session.setAttribute("role", "ADMIN");

            response.sendRedirect("home");
            return;
        }

        // =========================
        // STUDENT LOGIN
        // =========================
        try {

            int studentId = Integer.parseInt(username);

            StudentDAO studentDAO = new StudentDAO();

            Student student =
                    studentDAO.validateStudent(studentId, password);

            if (student != null) {

                session.setAttribute("username", username);
                session.setAttribute("student", student);
                session.setAttribute("role", "STUDENT");

                response.sendRedirect("studentHome");

            } else {

                response.getWriter().println(
                        "<h2>Invalid Username or Password</h2>"
                );
            }

        } catch (NumberFormatException e) {

            response.getWriter().println(
                    "<h2>Invalid Username or Password</h2>"
            );
        }
    }
}