package com.skillcollaboration.skillbasedstudentcollaborationweb.servlet;

import com.skillcollaboration.skillbasedstudentcollaborationweb.dao.StudentDAO;
import com.skillcollaboration.skillbasedstudentcollaborationweb.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/updateProfile")
public class UpdateProfileServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
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

        if (dao.updateStudent(student)) {

            // Update the session with the new values
            HttpSession session = request.getSession();

            session.setAttribute("student", student);

            response.sendRedirect("studentHome");

        } else {

            response.getWriter().println("<h2>Profile Update Failed!</h2>");

        }
    }
}