package com.skillcollaboration.skillbasedstudentcollaborationweb.servlet;

import com.skillcollaboration.skillbasedstudentcollaborationweb.dao.RequestDAO;
import com.skillcollaboration.skillbasedstudentcollaborationweb.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/studentHome")
public class StudentHomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("student") == null) {

            response.sendRedirect("login.jsp");
            return;
        }

        Student student = (Student) session.getAttribute("student");

        RequestDAO requestDAO = new RequestDAO();

        int pendingCount =
                requestDAO.getPendingRequestCount(student.getId());

        request.setAttribute("pendingCount", pendingCount);

        request.getRequestDispatcher("studentHome.jsp")
                .forward(request, response);
    }
}