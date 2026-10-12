package com.skillcollaboration.skillbasedstudentcollaborationweb.servlet;

import com.skillcollaboration.skillbasedstudentcollaborationweb.dao.StudentDAO;
import com.skillcollaboration.skillbasedstudentcollaborationweb.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/searchSkill")
public class SearchSkillServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String skill = request.getParameter("skill");

        StudentDAO dao = new StudentDAO();

        ArrayList<Student> students = dao.searchBySkill(skill);

        // Send the search results to the JSP
        request.setAttribute("students", students);

        // Forward to the result page
        request.getRequestDispatcher("searchSkillResult.jsp").forward(request, response);
    }
}