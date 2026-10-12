package com.skillcollaboration.skillbasedstudentcollaborationweb.servlet;

import com.skillcollaboration.skillbasedstudentcollaborationweb.dao.StudentDAO;
import com.skillcollaboration.skillbasedstudentcollaborationweb.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/editStudent")
public class EditStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get student ID from URL
        int id = Integer.parseInt(request.getParameter("id"));

        // Create DAO object
        StudentDAO dao = new StudentDAO();

        // Fetch student details
        Student student = dao.getStudentById(id);

        // Send student object to JSP
        request.setAttribute("student", student);

        // Open updateStudent.jsp
        request.getRequestDispatcher("updateStudent.jsp").forward(request, response);
    }
}