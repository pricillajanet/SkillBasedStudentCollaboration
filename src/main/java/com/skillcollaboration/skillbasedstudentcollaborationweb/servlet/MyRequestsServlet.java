package com.skillcollaboration.skillbasedstudentcollaborationweb.servlet;

import com.skillcollaboration.skillbasedstudentcollaborationweb.dao.RequestDAO;
import com.skillcollaboration.skillbasedstudentcollaborationweb.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/myRequests")
public class MyRequestsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        Student student = (Student) session.getAttribute("student");

        RequestDAO dao = new RequestDAO();

        request.setAttribute("requests",
                dao.getRequestsByReceiver(student.getId()));

        request.getRequestDispatcher("myRequests.jsp")
                .forward(request, response);
    }
}