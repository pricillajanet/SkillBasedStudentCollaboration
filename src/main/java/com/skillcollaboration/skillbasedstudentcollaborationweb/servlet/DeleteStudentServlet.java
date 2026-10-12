package com.skillcollaboration.skillbasedstudentcollaborationweb.servlet;

import com.skillcollaboration.skillbasedstudentcollaborationweb.dao.StudentDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/deleteStudent")
public class DeleteStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        StudentDAO dao = new StudentDAO();

        boolean status = dao.deleteStudent(id);

        if (status) {

            request.setAttribute("message", "Student Deleted Successfully!");

            request.getRequestDispatcher("success.jsp").forward(request, response);

        } else {

            request.setAttribute("message", "Student ID Not Found!");

            request.getRequestDispatcher("success.jsp").forward(request, response);

        }
    }
}