package com.skillcollaboration.skillbasedstudentcollaborationweb.servlet;

import com.skillcollaboration.skillbasedstudentcollaborationweb.dao.StudentDAO;
import com.skillcollaboration.skillbasedstudentcollaborationweb.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String skills = request.getParameter("skills");
        String interest = request.getParameter("interest");

        Student student = new Student();
        student.setName(name);
        student.setSkills(skills);
        student.setInterest(interest);

        StudentDAO dao = new StudentDAO();

        boolean status = dao.addStudent(student);

        if (status) {

            request.setAttribute("message", "Student Added Successfully!");

            request.getRequestDispatcher("success.jsp").forward(request, response);

        } else {

            request.setAttribute("message", "Failed to Add Student!");

            request.getRequestDispatcher("success.jsp").forward(request, response);

        }
    }
}