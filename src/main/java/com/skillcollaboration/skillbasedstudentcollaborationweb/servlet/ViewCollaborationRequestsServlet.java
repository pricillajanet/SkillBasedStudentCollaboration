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
import java.util.List;

@WebServlet("/viewCollaborationRequests")
public class ViewCollaborationRequestsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        // Only Admin can access this page
        if (session == null ||
                !"ADMIN".equals(session.getAttribute("role"))) {

            response.sendRedirect("login.jsp");
            return;
        }

        RequestDAO dao = new RequestDAO();

        List<CollaborationRequest> requests =
                dao.getAllRequests();

        request.setAttribute("requests", requests);

        request.getRequestDispatcher(
                "viewCollaborationRequests.jsp"
        ).forward(request, response);
    }
}