package com.skillcollaboration.skillbasedstudentcollaborationweb.servlet;

import com.skillcollaboration.skillbasedstudentcollaborationweb.dao.StudentDAO;
import com.skillcollaboration.skillbasedstudentcollaborationweb.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/editProfile")
public class EditProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if(session == null || session.getAttribute("student") == null){

            response.sendRedirect("login.jsp");
            return;
        }

        Student student =
                (Student) session.getAttribute("student");

        request.setAttribute("student", student);

        request.getRequestDispatcher("editProfile.jsp")
                .forward(request,response);
    }
}