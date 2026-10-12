package com.skillcollaboration.skillbasedstudentcollaborationweb.servlet;

import com.skillcollaboration.skillbasedstudentcollaborationweb.dao.RequestDAO;
import com.skillcollaboration.skillbasedstudentcollaborationweb.model.CollaborationRequest;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/sendRequest")
public class SendRequestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("student") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        int senderId = ((com.skillcollaboration.skillbasedstudentcollaborationweb.model.Student)
                session.getAttribute("student")).getId();

        int receiverId = Integer.parseInt(request.getParameter("receiverId"));

        CollaborationRequest collaborationRequest = new CollaborationRequest();

        collaborationRequest.setSenderId(senderId);
        collaborationRequest.setReceiverId(receiverId);

        RequestDAO dao = new RequestDAO();

        if (dao.sendRequest(collaborationRequest)) {

            response.sendRedirect("viewStudents");

        } else {

            response.getWriter().println("<h2>Request Failed!</h2>");

        }
    }
}