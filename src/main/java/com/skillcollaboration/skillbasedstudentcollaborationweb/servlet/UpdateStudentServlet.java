package com.skillcollaboration.skillbasedstudentcollaborationweb.servlet;

import com.skillcollaboration.skillbasedstudentcollaborationweb.dao.StudentDAO;
import com.skillcollaboration.skillbasedstudentcollaborationweb.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/updateStudent")
public class UpdateStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String skills = request.getParameter("skills");
        String interest = request.getParameter("interest");

        Student student = new Student();

        student.setId(id);
        student.setName(name);
        student.setSkills(skills);
        student.setInterest(interest);

        StudentDAO dao = new StudentDAO();

        boolean status = dao.updateStudent(student);

        if (status) {

            request.setAttribute("message", "Student Updated Successfully!");

            request.getRequestDispatcher("success.jsp").forward(request, response);

        } else {

            request.setAttribute("message", "Failed to Update Student!");

            request.getRequestDispatcher("success.jsp").forward(request, response);

        }
    }
}