/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ams.db;
import ams.db.DB;
import java.util.Vector;
import java.sql.*;

/**
 *
 * @author Rasan
 */
public class VectorModel {
    private Connection con;
    
    public Vector getDepartments() throws Exception {
        Vector<Vector<String>>DepartmentVector = null;
        con = DB.getConnection();
        try{
            Statement stmt = con.createStatement();
            String query = "select * from tbldepartment"; 
            ResultSet rs = stmt.executeQuery(query);
            DepartmentVector = new Vector<Vector<String>>();
            while(rs.next()) {
                Vector<String> D = new Vector<String>();
                D.add(rs.getString(1)); 
                D.add(rs.getString(2));
                D.add(rs.getString(3));
                D.add(rs.getString(4));
                DepartmentVector.add(D);
            }
            con.close();
        }catch(Exception ex){
            throw ex;
        }
        return DepartmentVector;
    }
    
    public Vector getDepartments(String where, String what) throws Exception {
        Vector<Vector<String>>DepartmentVector = null;
        con = DB.getConnection();
        try{
            PreparedStatement pstmt = con.prepareStatement("select * from tbldepartment where " + where + " like ?");
            pstmt.setString(1, "%" + what + "%");
            ResultSet rs = pstmt.executeQuery();
            DepartmentVector= new Vector<Vector<String>>();
            while(rs.next()) {
                Vector<String> V = new Vector<String>();
                V.add(rs.getString(1)); 
                V.add(rs.getString(2));
                V.add(rs.getString(3));
                V.add(rs.getString(4));
                DepartmentVector.add(V);
            }
            con.close();
        }catch(Exception ex){
            throw ex;
        }
        return DepartmentVector;
    }
    
    public Vector getStudents() throws Exception {
        Vector<Vector<String>>StudentVector = null;
        con = DB.getConnection();
        try{
            Statement stmt = con.createStatement();
            String query = "select * from tblstudent"; 
            ResultSet rs = stmt.executeQuery(query);
            StudentVector = new Vector<Vector<String>>();
            while(rs.next()) {
                Vector<String> V = new Vector<String>();
                V.add(rs.getString(1)); 
                V.add(rs.getString(2));
                V.add(rs.getString(3));
                V.add(rs.getString(4));
                V.add(rs.getString(5));
                V.add(rs.getString(6));
                V.add(rs.getString(7));
                V.add(rs.getString(8));
                V.add(rs.getString(9));
                V.add(rs.getString(10));
                V.add(rs.getString(11));
                StudentVector.add(V);
            }
            con.close();
        }catch(Exception ex){
            throw ex;
        }
        return StudentVector;
    }
    
    public Vector getStudents(String where, String what) throws Exception {
        Vector<Vector<String>>StudentVector = null;
        con = DB.getConnection();
        try{
            PreparedStatement pstmt = con.prepareStatement("select * from tblstudent where " + where + " like ?");
            pstmt.setString(1, "%" + what + "%");
            ResultSet rs = pstmt.executeQuery();
            StudentVector= new Vector<Vector<String>>();
            while(rs.next()) {
                Vector<String> V = new Vector<String>();
                V.add(rs.getString(1)); 
                V.add(rs.getString(2));
                V.add(rs.getString(3));
                V.add(rs.getString(4));
                V.add(rs.getString(5));
                V.add(rs.getString(6));
                V.add(rs.getString(7));
                V.add(rs.getString(8));
                V.add(rs.getString(9));
                V.add(rs.getString(10));
                V.add(rs.getString(11));
                StudentVector.add(V);
            }
            con.close();
        }catch(Exception ex){
            throw ex;
        }
        return StudentVector;
    }
    
        public Vector getLecturers() throws Exception {
        Vector<Vector<String>>LecturerVector = null;
        con = DB.getConnection();
        try{
            Statement stmt = con.createStatement();
            String query = "select * from tbllecturer"; 
            ResultSet rs = stmt.executeQuery(query);
            LecturerVector = new Vector<Vector<String>>();
            while(rs.next()) {
                Vector<String> V = new Vector<String>();
                V.add(rs.getString(1)); 
                V.add(rs.getString(2));
                V.add(rs.getString(3));
                V.add(rs.getString(4));
                V.add(rs.getString(5));
                V.add(rs.getString(6));
                V.add(rs.getString(7));
                LecturerVector.add(V);
            }
            con.close();
        }catch(Exception ex){
            throw ex;
        }
        return LecturerVector;
    }
    
    public Vector getLecturers(String where, String what) throws Exception {
        Vector<Vector<String>>LecturerVector = null;
        con = DB.getConnection();
        try{
            PreparedStatement pstmt = con.prepareStatement("select * from tbllecturer where " + where + " like ?");
            pstmt.setString(1, "%" + what + "%");
            ResultSet rs = pstmt.executeQuery();
            LecturerVector= new Vector<Vector<String>>();
            while(rs.next()) {
                Vector<String> V = new Vector<String>();
                V.add(rs.getString(1)); 
                V.add(rs.getString(2));
                V.add(rs.getString(3));
                V.add(rs.getString(4));
                V.add(rs.getString(5));
                V.add(rs.getString(6));
                V.add(rs.getString(7));
                LecturerVector.add(V);
            }
            con.close();
        }catch(Exception ex){
            throw ex;
        }
        return LecturerVector;
    }
    
    public Vector getCourses() throws Exception {
        Vector<Vector<String>>CoursesVector = null;
        con = DB.getConnection();
        try{
            Statement stmt = con.createStatement();
            String query = "select * from tblcourse"; 
            ResultSet rs = stmt.executeQuery(query);
            CoursesVector = new Vector<Vector<String>>();
            while(rs.next()) {
                Vector<String> V = new Vector<String>();
                V.add(rs.getString(1)); 
                V.add(rs.getString(2));
                V.add(rs.getString(3));
                V.add(rs.getString(4));
                V.add(rs.getString(5));
                V.add(rs.getString(6));
                V.add(rs.getString(7));
                V.add(rs.getString(8));
                CoursesVector.add(V);
            }
            con.close();
        }catch(Exception ex){
            throw ex;
        }
        return CoursesVector;
    }
    
    public Vector getCourses(String where, String what) throws Exception {
        Vector<Vector<String>>CourseVector = null;
        con = DB.getConnection();
        try{
            PreparedStatement pstmt = con.prepareStatement("select * from tblcourse where " + where + " like ?");
            pstmt.setString(1, "%" + what + "%");
            ResultSet rs = pstmt.executeQuery();
            CourseVector = new Vector<Vector<String>>();
            while(rs.next()) {
                Vector<String> V = new Vector<String>();
                V.add(rs.getString(1)); 
                V.add(rs.getString(2));
                V.add(rs.getString(3));
                V.add(rs.getString(4));
                V.add(rs.getString(5));
                V.add(rs.getString(6));
                V.add(rs.getString(7));
                V.add(rs.getString(8));
                CourseVector.add(V);
            }
            con.close();
        }catch(Exception ex){
            throw ex;
        }
        return CourseVector;
    }
    
    public Vector getPracticals() throws Exception {
        Vector<Vector<String>>PracticalVector = null;
        con = DB.getConnection();
        try{
            Statement stmt = con.createStatement();
            String query = "select * from tblpractical"; 
            ResultSet rs = stmt.executeQuery(query);
            PracticalVector = new Vector<Vector<String>>();
            while(rs.next()) {
                Vector<String> V = new Vector<String>();
                V.add(rs.getString(1)); 
                V.add(rs.getString(2));
                V.add(rs.getString(3));
                V.add(rs.getString(4));
                V.add(rs.getString(5));
                V.add(rs.getString(6));
                PracticalVector.add(V);
            }
            con.close();
        }catch(Exception ex){
            throw ex;
        }
        return PracticalVector;
    }
    
    public Vector getPracticals(String where, String what) throws Exception {
        Vector<Vector<String>>PracticalVector = null;
        con = DB.getConnection();
        try{
            PreparedStatement pstmt = con.prepareStatement("select * from tblpractical where " + where + " like ?");
            pstmt.setString(1, "%" + what + "%");
            ResultSet rs = pstmt.executeQuery();
            PracticalVector = new Vector<Vector<String>>();
            while(rs.next()) {
                Vector<String> V = new Vector<String>();
                V.add(rs.getString(1)); 
                V.add(rs.getString(2));
                V.add(rs.getString(3));
                V.add(rs.getString(4));
                V.add(rs.getString(5));
                V.add(rs.getString(6));
                PracticalVector.add(V);
            }
            con.close();
        }catch(Exception ex){
            throw ex;
        }
        return PracticalVector;
    }
    
    public Vector getClassrooms() throws Exception {
        Vector<Vector<String>>ClassroomVector = null;
        con = DB.getConnection();
        try{
            Statement stmt = con.createStatement();
            String query = "select * from tblclassroom"; 
            ResultSet rs = stmt.executeQuery(query);
            ClassroomVector = new Vector<Vector<String>>();
            while(rs.next()) {
                Vector<String> V = new Vector<String>();
                V.add(rs.getString(1)); 
                V.add(rs.getString(2));
                V.add(rs.getString(3));
                V.add(rs.getString(4));
                ClassroomVector.add(V);
            }
            con.close();
        }catch(Exception ex){
            throw ex;
        }
        return ClassroomVector;
    }
    
    public Vector getClassrooms(String where, String what) throws Exception {
        Vector<Vector<String>>ClassroomVector = null;
        con = DB.getConnection();
        try{
            PreparedStatement pstmt = con.prepareStatement("select * from tblclassroom where " + where + " like ?");
            pstmt.setString(1, "%" + what + "%");
            ResultSet rs = pstmt.executeQuery();
            ClassroomVector = new Vector<Vector<String>>();
            while(rs.next()) {
                Vector<String> V = new Vector<String>();
                V.add(rs.getString(1)); 
                V.add(rs.getString(2));
                V.add(rs.getString(3));
                V.add(rs.getString(4));
                ClassroomVector.add(V);
            }
            con.close();
        }catch(Exception ex){
            throw ex;
        }
        return ClassroomVector;
    }
    
    public Vector getPayments() throws Exception {
        Vector<Vector<String>>PaymentVector = null;
        con = DB.getConnection();
        try{
            Statement stmt = con.createStatement();
            String query = "select * from tblpayment"; 
            ResultSet rs = stmt.executeQuery(query);
            PaymentVector = new Vector<Vector<String>>();
            while(rs.next()) {
                Vector<String> V = new Vector<String>();
                V.add(rs.getString(1)); 
                V.add(rs.getString(2));
                V.add(rs.getString(3));
                V.add(rs.getString(4));
                V.add(rs.getString(5));
                PaymentVector.add(V);
            }
            con.close();
        }catch(Exception ex){
            throw ex;
        }
        return PaymentVector;
    }
    
    public Vector getPayments(String where, String what) throws Exception {
        Vector<Vector<String>>PaymentVector = null;
        con = DB.getConnection();
        try{
            PreparedStatement pstmt = con.prepareStatement("select * from tblpayment where " + where + " like ?");
            pstmt.setString(1, "%" + what + "%");
            ResultSet rs = pstmt.executeQuery();
            PaymentVector = new Vector<Vector<String>>();
            while(rs.next()) {
                Vector<String> V = new Vector<String>();
                V.add(rs.getString(1)); 
                V.add(rs.getString(2));
                V.add(rs.getString(3));
                V.add(rs.getString(4));
                V.add(rs.getString(5));
                PaymentVector.add(V);
            }
            con.close();
        }catch(Exception ex){
            throw ex;
        }
        return PaymentVector;
    }
    
    public Vector getModules() throws Exception {
        Vector<Vector<String>>ModuleVector = null;
        con = DB.getConnection();
        try{
            Statement stmt = con.createStatement();
            String query = "select * from tblmodule"; 
            ResultSet rs = stmt.executeQuery(query);
            ModuleVector = new Vector<Vector<String>>();
            while(rs.next()) {
                Vector<String> V = new Vector<String>();
                V.add(rs.getString(1)); 
                V.add(rs.getString(2));
                V.add(rs.getString(3));
                V.add(rs.getString(4));
                V.add(rs.getString(5));
                ModuleVector.add(V);
            }
            con.close();
        }catch(Exception ex){
            throw ex;
        }
        return ModuleVector;
    }
    
    public Vector getModules(String where, String what) throws Exception {
        Vector<Vector<String>>ModuleVector = null;
        con = DB.getConnection();
        try{
            PreparedStatement pstmt = con.prepareStatement("select * from tblmodule where " + where + " like ?");
            pstmt.setString(1, "%" + what + "%");
            ResultSet rs = pstmt.executeQuery();
            ModuleVector = new Vector<Vector<String>>();
            while(rs.next()) {
                Vector<String> V = new Vector<String>();
                V.add(rs.getString(1)); 
                V.add(rs.getString(2));
                V.add(rs.getString(3));
                V.add(rs.getString(4));
                V.add(rs.getString(5));
                ModuleVector.add(V);
            }
            con.close();
        }catch(Exception ex){
            throw ex;
        }
        return ModuleVector;
    }
    
    public Vector getExams() throws Exception {
        Vector<Vector<String>>ExamVector = null;
        con = DB.getConnection();
        try{
            Statement stmt = con.createStatement();
            String query = "select * from tblexam"; 
            ResultSet rs = stmt.executeQuery(query);
            ExamVector = new Vector<Vector<String>>();
            while(rs.next()) {
                Vector<String> V = new Vector<String>();
                V.add(rs.getString(1)); 
                V.add(rs.getString(2));
                V.add(rs.getString(3));
                V.add(rs.getString(4));
                V.add(rs.getString(5));
                ExamVector.add(V);
            }
            con.close();
        }catch(Exception ex){
            throw ex;
        }
        return ExamVector;
    }
    
    public Vector getExams(String where, String what) throws Exception {
        Vector<Vector<String>>ExamVector = null;
        con = DB.getConnection();
        try{
            PreparedStatement pstmt = con.prepareStatement("select * from tblexam where " + where + " like ?");
            pstmt.setString(1, "%" + what + "%");
            ResultSet rs = pstmt.executeQuery();
            ExamVector = new Vector<Vector<String>>();
            while(rs.next()) {
                Vector<String> V = new Vector<String>();
                V.add(rs.getString(1)); 
                V.add(rs.getString(2));
                V.add(rs.getString(3));
                V.add(rs.getString(4));
                V.add(rs.getString(5));
                ExamVector.add(V);
            }
            con.close();
        }catch(Exception ex){
            throw ex;
        }
        return ExamVector;
    }
    
    public Vector getAssignments() throws Exception {
        Vector<Vector<String>>AssignmentVector = null;
        con = DB.getConnection();
        try{
            Statement stmt = con.createStatement();
            String query = "select * from tblassignment"; 
            ResultSet rs = stmt.executeQuery(query);
            AssignmentVector = new Vector<Vector<String>>();
            while(rs.next()) {
                Vector<String> V = new Vector<String>();
                V.add(rs.getString(1)); 
                V.add(rs.getString(2));
                V.add(rs.getString(3));
                V.add(rs.getString(4));
                V.add(rs.getString(5));
                V.add(rs.getString(6));
                AssignmentVector.add(V);
            }
            con.close();
        }catch(Exception ex){
            throw ex;
        }
        return AssignmentVector;
    }
    
    public Vector getAssignments(String where, String what) throws Exception {
        Vector<Vector<String>>AssignmentVector = null;
        con = DB.getConnection();
        try{
            PreparedStatement pstmt = con.prepareStatement("select * from tblassignment where " + where + " like ?");
            pstmt.setString(1, "%" + what + "%");
            ResultSet rs = pstmt.executeQuery();
            AssignmentVector = new Vector<Vector<String>>();
            while(rs.next()) {
                Vector<String> V = new Vector<String>();
                V.add(rs.getString(1)); 
                V.add(rs.getString(2));
                V.add(rs.getString(3));
                V.add(rs.getString(4));
                V.add(rs.getString(5));
                V.add(rs.getString(6));
                AssignmentVector.add(V);
            }
            con.close();
        }catch(Exception ex){
            throw ex;
        }
        return AssignmentVector;
    }
    
    public Vector getLectures() throws Exception {
        Vector<Vector<String>>LectureVector = null;
        con = DB.getConnection();
        try{
            Statement stmt = con.createStatement();
            String query = "select * from tbllecture"; 
            ResultSet rs = stmt.executeQuery(query);
            LectureVector = new Vector<Vector<String>>();
            while(rs.next()) {
                Vector<String> V = new Vector<String>();
                V.add(rs.getString(1)); 
                V.add(rs.getString(2));
                V.add(rs.getString(3));
                V.add(rs.getString(4));
                V.add(rs.getString(5));
                V.add(rs.getString(6));
                V.add(rs.getString(7));
                LectureVector.add(V);
            }
            con.close();
        }catch(Exception ex){
            throw ex;
        }
        return LectureVector;
    }
    
    public Vector getLectures(String where, String what) throws Exception {
        Vector<Vector<String>>LectureVector = null;
        con = DB.getConnection();
        try{
            PreparedStatement pstmt = con.prepareStatement("select * from tbllecture where " + where + " like ?");
            pstmt.setString(1, "%" + what + "%");
            ResultSet rs = pstmt.executeQuery();
            LectureVector = new Vector<Vector<String>>();
            while(rs.next()) {
                Vector<String> V = new Vector<String>();
                V.add(rs.getString(1)); 
                V.add(rs.getString(2));
                V.add(rs.getString(3));
                V.add(rs.getString(4));
                V.add(rs.getString(5));
                V.add(rs.getString(6));
                V.add(rs.getString(7));
                LectureVector.add(V);
            }
            con.close();
        }catch(Exception ex){
            throw ex;
        }
        return LectureVector;
    }
    
    public Vector getUsers() throws Exception {
        Vector<Vector<String>>UserVector = null;
        con = DB.getConnection();
        try{
            Statement stmt = con.createStatement();
            String query = "select * from tbluser"; 
            ResultSet rs = stmt.executeQuery(query);
            UserVector = new Vector<Vector<String>>();
            while(rs.next()) {
                Vector<String> V = new Vector<String>();
                V.add(rs.getString(1)); 
                V.add(rs.getString(2));
                V.add(rs.getString(3));
                V.add(rs.getString(5));
                V.add(rs.getString(6));
                UserVector.add(V);
            }
            con.close();
        }catch(Exception ex){
            throw ex;
        }
        return UserVector;
    }
    
    public Vector getUsers(String where, String what) throws Exception {
        Vector<Vector<String>>UserVector = null;
        con = DB.getConnection();
        try{
            PreparedStatement pstmt = con.prepareStatement("select * from tbluser where " + where + " like ?");
            pstmt.setString(1, "%" + what + "%");
            ResultSet rs = pstmt.executeQuery();
            UserVector = new Vector<Vector<String>>();
            while(rs.next()) {
                Vector<String> V = new Vector<String>();
                V.add(rs.getString(1)); 
                V.add(rs.getString(2));
                V.add(rs.getString(3));
                V.add(rs.getString(5));
                V.add(rs.getString(6));
                UserVector.add(V);
            }
            con.close();
        }catch(Exception ex){
            throw ex;
        }
        return UserVector;
    }
    
    public Vector getLogs() throws Exception {
        Vector<Vector<String>>LogVector = null;
        con = DB.getConnection();
        try{
            Statement stmt = con.createStatement();
            String query = "select * from tbllog"; 
            ResultSet rs = stmt.executeQuery(query);
            LogVector = new Vector<Vector<String>>();
            while(rs.next()) {
                Vector<String> V = new Vector<String>();
                V.add(rs.getString(1)); 
                V.add(rs.getString(2));
                V.add(rs.getString(3));
                V.add(rs.getString(4));
                V.add(rs.getString(5));
                LogVector.add(V);
            }
            con.close();
        }catch(Exception ex){
            throw ex;
        }
        return LogVector;
    }
    
    public Vector getLogs(String where, String what) throws Exception {
        Vector<Vector<String>>LogVector = null;
        con = DB.getConnection();
        try{
            PreparedStatement pstmt = con.prepareStatement("select * from tbllog where " + where + " like ?");
            pstmt.setString(1, "%" + what + "%");
            ResultSet rs = pstmt.executeQuery();
            LogVector = new Vector<Vector<String>>();
            while(rs.next()) {
                Vector<String> V = new Vector<String>();
                V.add(rs.getString(1)); 
                V.add(rs.getString(2));
                V.add(rs.getString(3));
                V.add(rs.getString(4));
                V.add(rs.getString(5));
                LogVector.add(V);
            }
            con.close();
        }catch(Exception ex){
            throw ex;
        }
        return LogVector;
    }
    
    public Vector getBatches() throws Exception {
        Vector<Vector<String>>BatchVector = null;
        con = DB.getConnection();
        try{
            Statement stmt = con.createStatement();
            String query = "select * from tblbatch"; 
            ResultSet rs = stmt.executeQuery(query);
            BatchVector = new Vector<Vector<String>>();
            while(rs.next()) {
                Vector<String> V = new Vector<String>();
                V.add(rs.getString(1)); 
                V.add(rs.getString(2));
                V.add(rs.getString(3));
                V.add(rs.getString(4));
                BatchVector.add(V);
            }
            con.close();
        }catch(Exception ex){
            throw ex;
        }
        return BatchVector;
    }
    
    public Vector getBatches(String where, String what) throws Exception {
        Vector<Vector<String>>BatchVector = null;
        con = DB.getConnection();
        try{
            PreparedStatement pstmt = con.prepareStatement("select * from tblbatch where " + where + " like ?");
            pstmt.setString(1, "%" + what + "%");
            ResultSet rs = pstmt.executeQuery();
            BatchVector = new Vector<Vector<String>>();
            while(rs.next()) {
                Vector<String> V = new Vector<String>();
                V.add(rs.getString(1)); 
                V.add(rs.getString(2));
                V.add(rs.getString(3));
                V.add(rs.getString(4));
                BatchVector.add(V);
            }
            con.close();
        }catch(Exception ex){
            throw ex;
        }
        return BatchVector;
    }
    
    public Vector getStudentAssignments(String where, String what) throws Exception {
        Vector<Vector<String>>StudentAssignmentVector = null;
        con = DB.getConnection();
        try{
            PreparedStatement pstmt = con.prepareStatement("select * from tblstudent_assignment where " + where + " like ?");
            pstmt.setString(1, "%" + what + "%");
            ResultSet rs = pstmt.executeQuery();
            StudentAssignmentVector = new Vector<Vector<String>>();
            while(rs.next()) {
                Vector<String> V = new Vector<String>();
                V.add(rs.getString(1)); 
                V.add(rs.getString(2));
                V.add(rs.getString(3));
                V.add(rs.getString(4));
                StudentAssignmentVector.add(V);
            }
            con.close();
        }catch(Exception ex){
            throw ex;
        }
        return StudentAssignmentVector;
    }
    
    public Vector getStudentAssignments() throws Exception {
        Vector<Vector<String>>StudentAssignmentVector = null;
        con = DB.getConnection();
        try{
            Statement stmt = con.createStatement();
            String query = "select * from tblstudent_assignment"; 
            ResultSet rs = stmt.executeQuery(query);
            StudentAssignmentVector = new Vector<Vector<String>>();
            while(rs.next()) {
                Vector<String> V = new Vector<String>();
                V.add(rs.getString(1)); 
                V.add(rs.getString(2));
                V.add(rs.getString(3));
                V.add(rs.getString(4));
                StudentAssignmentVector.add(V);
            }
            con.close();
        }catch(Exception ex){
            throw ex;
        }
        return StudentAssignmentVector;
    }
    
    public Vector getStudentExams(String where, String what) throws Exception {
        Vector<Vector<String>>StudentExamVector = null;
        con = DB.getConnection();
        try{
            PreparedStatement pstmt = con.prepareStatement("select * from tblstudent_exam where " + where + " like ?");
            pstmt.setString(1, "%" + what + "%");
            ResultSet rs = pstmt.executeQuery();
            StudentExamVector = new Vector<Vector<String>>();
            while(rs.next()) {
                Vector<String> V = new Vector<String>();
                V.add(rs.getString(1)); 
                V.add(rs.getString(2));
                V.add(rs.getString(3));
                V.add(rs.getString(4));
                StudentExamVector.add(V);
            }
            con.close();
        }catch(Exception ex){
            throw ex;
        }
        return StudentExamVector;
    }
    
    public Vector getStudentExams() throws Exception {
        Vector<Vector<String>>StudentExamVector = null;
        con = DB.getConnection();
        try{
            Statement stmt = con.createStatement();
            String query = "select * from tblstudent_exam"; 
            ResultSet rs = stmt.executeQuery(query);
            StudentExamVector = new Vector<Vector<String>>();
            while(rs.next()) {
                Vector<String> V = new Vector<String>();
                V.add(rs.getString(1)); 
                V.add(rs.getString(2));
                V.add(rs.getString(3));
                V.add(rs.getString(4));
                StudentExamVector.add(V);
            }
            con.close();
        }catch(Exception ex){
            throw ex;
        }
        return StudentExamVector;
    }
    
    public Vector getCourseModules(String where, String what) throws Exception {
        Vector<Vector<String>>CourseModuleVector = null;
        con = DB.getConnection();
        try{
            PreparedStatement pstmt = con.prepareStatement("select * from tblcourse_module where " + where + " like ?");
            pstmt.setString(1, "%" + what + "%");
            ResultSet rs = pstmt.executeQuery();
            CourseModuleVector = new Vector<Vector<String>>();
            while(rs.next()) {
                Vector<String> V = new Vector<String>();
                V.add(rs.getString(1)); 
                V.add(rs.getString(2));
                V.add(rs.getString(3));
                CourseModuleVector.add(V);
            }
            con.close();
        }catch(Exception ex){
            throw ex;
        }
        return CourseModuleVector;
    }
    
    public Vector getCourseModules() throws Exception {
        Vector<Vector<String>>CourseModuleVector = null;
        con = DB.getConnection();
        try{
            Statement stmt = con.createStatement();
            String query = "select * from tblcourse_module"; 
            ResultSet rs = stmt.executeQuery(query);
            CourseModuleVector = new Vector<Vector<String>>();
            while(rs.next()) {
                Vector<String> V = new Vector<String>();
                V.add(rs.getString(1)); 
                V.add(rs.getString(2));
                V.add(rs.getString(3));
                CourseModuleVector.add(V);
            }
            con.close();
        }catch(Exception ex){
            throw ex;
        }
        return CourseModuleVector;
    }
    
    public Vector getStudentAttendance(String where, String what) throws Exception {
        Vector<Vector<String>>StAttendanceVector = null;
        con = DB.getConnection();
        try{
            PreparedStatement pstmt = con.prepareStatement("select * from tblattendance where " + where + " like ?");
            pstmt.setString(1, "%" + what + "%");
            ResultSet rs = pstmt.executeQuery();
            StAttendanceVector = new Vector<Vector<String>>();
            while(rs.next()) {
                Vector<String> V = new Vector<String>();
                V.add(rs.getString(1)); 
                V.add(rs.getString(2));
                V.add(rs.getString(3));
                V.add(rs.getString(4));
                StAttendanceVector.add(V);
            }
            con.close();
        }catch(Exception ex){
            throw ex;
        }
        return StAttendanceVector;
    }
    
    public Vector getStudentAttendance() throws Exception {
        Vector<Vector<String>>StAttendanceVector = null;
        con = DB.getConnection();
        try{
            Statement stmt = con.createStatement();
            String query = "select * from tblattendance"; 
            ResultSet rs = stmt.executeQuery(query);
            StAttendanceVector = new Vector<Vector<String>>();
            while(rs.next()) {
                Vector<String> V = new Vector<String>();
                V.add(rs.getString(1)); 
                V.add(rs.getString(2));
                V.add(rs.getString(3));
                V.add(rs.getString(4));
                StAttendanceVector.add(V);
            }
            con.close();
        }catch(Exception ex){
            throw ex;
        }
        return StAttendanceVector;
    }
    
    public Vector getStudentCourses(String where, String what) throws Exception {
        Vector<Vector<String>>StudentCourseVector = null;
        con = DB.getConnection();
        try{
            PreparedStatement pstmt = con.prepareStatement("select * from tblstudent_course where " + where + " like ?");
            pstmt.setString(1, "%" + what + "%");
            ResultSet rs = pstmt.executeQuery();
            StudentCourseVector = new Vector<Vector<String>>();
            while(rs.next()) {
                Vector<String> V = new Vector<String>();
                V.add(rs.getString(1)); 
                V.add(rs.getString(2));
                V.add(rs.getString(3));
                V.add(rs.getString(4));
                StudentCourseVector.add(V);
            }
            con.close();
        }catch(Exception ex){
            throw ex;
        }
        return StudentCourseVector;
    }
    
    public Vector getStudentCourses() throws Exception {
        Vector<Vector<String>>StudentCourseVector = null;
        con = DB.getConnection();
        try{
            Statement stmt = con.createStatement();
            String query = "select * from tblstudent_course"; 
            ResultSet rs = stmt.executeQuery(query);
            StudentCourseVector = new Vector<Vector<String>>();
            while(rs.next()) {
                Vector<String> V = new Vector<String>();
                V.add(rs.getString(1)); 
                V.add(rs.getString(2));
                V.add(rs.getString(3));
                V.add(rs.getString(4));
                StudentCourseVector.add(V);
            }
            con.close();
        }catch(Exception ex){
            throw ex;
        }
        return StudentCourseVector;
    }
    
    public Vector getStudentBatches(String where, String what) throws Exception {
        Vector<Vector<String>>StudentBatchVector = null;
        con = DB.getConnection();
        try{
            PreparedStatement pstmt = con.prepareStatement("select * from tblstudent_batch where " + where + " like ?");
            pstmt.setString(1, "%" + what + "%");
            ResultSet rs = pstmt.executeQuery();
            StudentBatchVector = new Vector<Vector<String>>();
            while(rs.next()) {
                Vector<String> V = new Vector<String>();
                V.add(rs.getString(1)); 
                V.add(rs.getString(2));
                V.add(rs.getString(3));
                StudentBatchVector.add(V);
            }
            con.close();
        }catch(Exception ex){
            throw ex;
        }
        return StudentBatchVector;
    }
    
    public Vector getStudentBatches() throws Exception {
        Vector<Vector<String>>StudentBatchVector = null;
        con = DB.getConnection();
        try{
            Statement stmt = con.createStatement();
            String query = "select * from tblstudent_batch"; 
            ResultSet rs = stmt.executeQuery(query);
            StudentBatchVector = new Vector<Vector<String>>();
            while(rs.next()) {
                Vector<String> V = new Vector<String>();
                V.add(rs.getString(1)); 
                V.add(rs.getString(2));
                V.add(rs.getString(3));
                StudentBatchVector.add(V);
            }
            con.close();
        }catch(Exception ex){
            throw ex;
        }
        return StudentBatchVector;
    }
    
    public Vector getCourseBatches(String where, String what) throws Exception {
        Vector<Vector<String>>CourseBatchVector = null;
        con = DB.getConnection();
        try{
            PreparedStatement pstmt = con.prepareStatement("select * from tblcourse_batch where " + where + " like ?");
            pstmt.setString(1, "%" + what + "%");
            ResultSet rs = pstmt.executeQuery();
            CourseBatchVector = new Vector<Vector<String>>();
            while(rs.next()) {
                Vector<String> V = new Vector<String>();
                V.add(rs.getString(1)); 
                V.add(rs.getString(2));
                V.add(rs.getString(3));
                CourseBatchVector.add(V);
            }
            con.close();
        }catch(Exception ex){
            throw ex;
        }
        return CourseBatchVector;
    }
    
    public Vector getCourseBatches() throws Exception {
        Vector<Vector<String>>CourseBatchVector = null;
        con = DB.getConnection();
        try{
            Statement stmt = con.createStatement();
            String query = "select * from tblcourse_batch"; 
            ResultSet rs = stmt.executeQuery(query);
            CourseBatchVector = new Vector<Vector<String>>();
            while(rs.next()) {
                Vector<String> V = new Vector<String>();
                V.add(rs.getString(1)); 
                V.add(rs.getString(2));
                V.add(rs.getString(3));
                CourseBatchVector.add(V);
            }
            con.close();
        }catch(Exception ex){
            throw ex;
        }
        return CourseBatchVector;
    }
}
