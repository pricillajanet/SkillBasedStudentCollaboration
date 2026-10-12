package com.skillcollaboration.skillbasedstudentcollaborationweb.servlet;

import com.skillcollaboration.skillbasedstudentcollaborationweb.dao.StudentDAO;
import com.skillcollaboration.skillbasedstudentcollaborationweb.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String skills = request.getParameter("skills");
        String interest = request.getParameter("interest");

        Student student = new Student();

        student.setName(name);
        student.setPassword(password);
        student.setSkills(skills);
        student.setInterest(interest);

        StudentDAO dao = new StudentDAO();

        int studentId = dao.registerStudent(student);

        if (studentId != -1) {

            request.setAttribute("studentId", studentId);

            request.getRequestDispatcher("success.jsp")
                    .forward(request, response);

        } else {

            response.getWriter()
                    .println("<h2>Registration Failed!</h2>");
        }
    }
}