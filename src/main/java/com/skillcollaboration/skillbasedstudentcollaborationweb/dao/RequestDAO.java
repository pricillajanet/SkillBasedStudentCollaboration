package com.skillcollaboration.skillbasedstudentcollaborationweb.dao;

import com.skillcollaboration.skillbasedstudentcollaborationweb.model.CollaborationRequest;
import com.skillcollaboration.skillbasedstudentcollaborationweb.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RequestDAO {

    public boolean sendRequest(CollaborationRequest request) {
        try {
            Connection con = DatabaseConnection.getConnection();

            // Check if request already exists
            String checkSql =
                    "SELECT * FROM collaboration_requests " +
                            "WHERE sender_id=? AND receiver_id=?";

            PreparedStatement checkPs = con.prepareStatement(checkSql);
            checkPs.setInt(1, request.getSenderId());
            checkPs.setInt(2, request.getReceiverId());

            ResultSet rs = checkPs.executeQuery();

            if (rs.next()) {
                return false;
            }

            // Insert new request
            String sql =
                    "INSERT INTO collaboration_requests" +
                            "(sender_id, receiver_id, status) VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, request.getSenderId());
            ps.setInt(2, request.getReceiverId());
            ps.setString(3, "PENDING");

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // ==========================
    // GET RECEIVED REQUESTS
    // ==========================

    public List<CollaborationRequest> getRequestsByReceiver(int receiverId) {

        List<CollaborationRequest> requests = new ArrayList<>();

        try {
            Connection con = DatabaseConnection.getConnection();

            String sql =
                    "SELECT cr.*, s.name AS sender_name " +
                            "FROM collaboration_requests cr " +
                            "JOIN students s ON cr.sender_id = s.id " +
                            "WHERE cr.receiver_id=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, receiverId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                CollaborationRequest request =
                        new CollaborationRequest();

                request.setRequestId(
                        rs.getInt("request_id"));

                request.setSenderId(
                        rs.getInt("sender_id"));

                request.setReceiverId(
                        rs.getInt("receiver_id"));

                request.setSenderName(
                        rs.getString("sender_name"));

                request.setStatus(
                        rs.getString("status"));

                request.setRequestDate(
                        rs.getString("request_date"));

                requests.add(request);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return requests;
    }

    // ==========================
    // ACCEPT REQUEST
    // ==========================

    public boolean acceptRequest(int requestId) {

        try {
            Connection con = DatabaseConnection.getConnection();

            String sql =
                    "UPDATE collaboration_requests " +
                            "SET status='ACCEPTED' " +
                            "WHERE request_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, requestId);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // ==========================
    // REJECT REQUEST
    // ==========================

    public boolean rejectRequest(int requestId) {

        try {
            Connection con = DatabaseConnection.getConnection();

            String sql =
                    "UPDATE collaboration_requests " +
                            "SET status='REJECTED' " +
                            "WHERE request_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, requestId);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // ==========================
    // GET SENT REQUESTS
    // ==========================

    public List<CollaborationRequest> getRequestsBySender(int senderId) {

        List<CollaborationRequest> requests = new ArrayList<>();

        try {
            Connection con = DatabaseConnection.getConnection();

            String sql =
                    "SELECT cr.*, s.name AS receiver_name " +
                            "FROM collaboration_requests cr " +
                            "JOIN students s ON cr.receiver_id = s.id " +
                            "WHERE cr.sender_id=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, senderId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                CollaborationRequest request =
                        new CollaborationRequest();

                request.setRequestId(
                        rs.getInt("request_id"));

                request.setSenderId(
                        rs.getInt("sender_id"));

                request.setReceiverId(
                        rs.getInt("receiver_id"));

                request.setReceiverName(
                        rs.getString("receiver_name"));

                request.setStatus(
                        rs.getString("status"));

                request.setRequestDate(
                        rs.getString("request_date"));

                requests.add(request);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return requests;
    }

    // ==========================
    // GET PENDING REQUEST COUNT
    // ==========================

    public int getPendingRequestCount(int receiverId) {

        int count = 0;

        try {
            Connection con = DatabaseConnection.getConnection();

            String sql =
                    "SELECT COUNT(*) " +
                            "FROM collaboration_requests " +
                            "WHERE receiver_id=? AND status='PENDING'";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, receiverId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    // ==========================
    // GET COLLABORATORS
    // ==========================

    public List<com.skillcollaboration.skillbasedstudentcollaborationweb.model.Student>
    getCollaborators(int studentId) {

        List<com.skillcollaboration.skillbasedstudentcollaborationweb.model.Student>
                collaborators = new ArrayList<>();

        try {
            Connection con = DatabaseConnection.getConnection();

            String sql =
                    "SELECT DISTINCT s.id, s.name, s.skills, s.interest " +
                            "FROM students s " +
                            "JOIN collaboration_requests cr " +
                            "ON ((cr.sender_id = s.id AND cr.receiver_id = ?) " +
                            "OR (cr.receiver_id = s.id AND cr.sender_id = ?)) " +
                            "WHERE cr.status='ACCEPTED'";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, studentId);
            ps.setInt(2, studentId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                com.skillcollaboration.skillbasedstudentcollaborationweb.model.Student
                        student =
                        new com.skillcollaboration.skillbasedstudentcollaborationweb.model.Student();

                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setSkills(rs.getString("skills"));
                student.setInterest(rs.getString("interest"));

                collaborators.add(student);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return collaborators;
    }

    // ==========================
    // GET ALL COLLABORATION REQUESTS
    // FOR ADMIN
    // ==========================

    public List<CollaborationRequest> getAllRequests() {

        List<CollaborationRequest> requests =
                new ArrayList<>();

        try {
            Connection con =
                    DatabaseConnection.getConnection();

            String sql =
                    "SELECT cr.*, " +
                            "s1.name AS sender_name, " +
                            "s2.name AS receiver_name " +
                            "FROM collaboration_requests cr " +
                            "JOIN students s1 " +
                            "ON cr.sender_id = s1.id " +
                            "JOIN students s2 " +
                            "ON cr.receiver_id = s2.id " +
                            "ORDER BY cr.request_date DESC";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery();

            while (rs.next()) {

                CollaborationRequest request =
                        new CollaborationRequest();

                request.setRequestId(
                        rs.getInt("request_id"));

                request.setSenderId(
                        rs.getInt("sender_id"));

                request.setReceiverId(
                        rs.getInt("receiver_id"));

                request.setSenderName(
                        rs.getString("sender_name"));

                request.setReceiverName(
                        rs.getString("receiver_name"));

                request.setStatus(
                        rs.getString("status"));

                request.setRequestDate(
                        rs.getString("request_date"));

                requests.add(request);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return requests;
    }
}