package com.skillcollaboration.skillbasedstudentcollaborationweb.dao;

import com.skillcollaboration.skillbasedstudentcollaborationweb.model.Student;
import com.skillcollaboration.skillbasedstudentcollaborationweb.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentDAO {

    public boolean addStudent(Student student) {
        try {
            Connection con = DatabaseConnection.getConnection();

            String sql = "INSERT INTO students(name, skills, interest) VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, student.getName());
            ps.setString(2, student.getSkills());
            ps.setString(3, student.getInterest());

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Student> getAllStudents() {

        ArrayList<Student> students = new ArrayList<>();

        try {
            Connection con = DatabaseConnection.getConnection();

            String sql = "SELECT * FROM students";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Student student = new Student();

                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setSkills(rs.getString("skills"));
                student.setInterest(rs.getString("interest"));

                students.add(student);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }

    public ArrayList<Student> searchBySkill(String skill) {

        ArrayList<Student> students = new ArrayList<>();

        try {
            Connection con = DatabaseConnection.getConnection();

            String sql = "SELECT * FROM students WHERE skills LIKE ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, "%" + skill + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Student student = new Student();

                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setSkills(rs.getString("skills"));
                student.setInterest(rs.getString("interest"));

                students.add(student);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }

    public ArrayList<Student> searchByInterest(String interest) {

        ArrayList<Student> students = new ArrayList<>();

        try {
            Connection con = DatabaseConnection.getConnection();

            String sql = "SELECT * FROM students WHERE interest LIKE ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, "%" + interest + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Student student = new Student();

                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setSkills(rs.getString("skills"));
                student.setInterest(rs.getString("interest"));

                students.add(student);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }

    public boolean updateStudent(Student student) {

        try {
            Connection con = DatabaseConnection.getConnection();

            String sql =
                    "UPDATE students SET name=?, skills=?, interest=? WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, student.getName());
            ps.setString(2, student.getSkills());
            ps.setString(3, student.getInterest());
            ps.setInt(4, student.getId());

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteStudent(int id) {

        try {
            Connection con = DatabaseConnection.getConnection();

            String sql = "DELETE FROM students WHERE id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getStudentCount() {

        int count = 0;

        try {
            Connection con = DatabaseConnection.getConnection();

            String query = "SELECT COUNT(*) FROM students";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                count = rs.getInt(1);
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    public Student getStudentById(int id) {

        Student student = null;

        try {
            Connection con = DatabaseConnection.getConnection();

            String sql = "SELECT * FROM students WHERE id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                student = new Student();

                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setSkills(rs.getString("skills"));
                student.setInterest(rs.getString("interest"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return student;
    }

    public Student login(String username, String password) {

        Student student = null;

        try {
            Connection con = DatabaseConnection.getConnection();

            String sql =
                    "SELECT * FROM students WHERE username=? AND password=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                student = new Student();

                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setUsername(rs.getString("username"));
                student.setPassword(rs.getString("password"));
                student.setRole(rs.getString("role"));
                student.setSkills(rs.getString("skills"));
                student.setInterest(rs.getString("interest"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return student;
    }

    public Student validateStudent(int id, String password) {

        Student student = null;

        try {
            Connection con = DatabaseConnection.getConnection();

            String sql =
                    "SELECT * FROM students WHERE id=? AND password=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                student = new Student();

                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setPassword(rs.getString("password"));
                student.setRole(rs.getString("role"));
                student.setSkills(rs.getString("skills"));
                student.setInterest(rs.getString("interest"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return student;
    }

    // ================================
    // STUDENT REGISTRATION
    // ================================

    public int registerStudent(Student student) {

        try {
            Connection con = DatabaseConnection.getConnection();

            String sql =
                    "INSERT INTO students(name, password, role, skills, interest) " +
                            "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(
                    sql,
                    java.sql.Statement.RETURN_GENERATED_KEYS
            );

            ps.setString(1, student.getName());
            ps.setString(2, student.getPassword());
            ps.setString(3, "STUDENT");
            ps.setString(4, student.getSkills());
            ps.setString(5, student.getInterest());

            int rows = ps.executeUpdate();

            if (rows > 0) {

                ResultSet rs = ps.getGeneratedKeys();

                if (rs.next()) {
                    return rs.getInt(1);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1;
    }
}