/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ams.ui;
import ams.db.Log;
import ams.data.UserType;
import ams.data.Validator;
import ams.db.Backup;
import ams.db.VectorModel;
import ams.db.DB;
import ams.db.ComboBox;
import ams.email.EmailClass;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
/**
 *
 * @author Rasan
 */
public class MainUI extends javax.swing.JFrame {
    private Connection con;
    private static UserType usertype;
    private static int userid;
    /**
     * Creates new form MainUI
     */
    
    public MainUI(UserType usertype, int userid) {
        this.usertype = usertype;
        this.userid = userid;
        initComponents();
        if(usertype == UserType.receptionist){
            TabbedPane.remove(ModulesPanel);
            TabbedPane.remove(DepartmentsPanel);
            TabbedPane.remove(CoursesPanel);
            TabbedPane.remove(ExamsPanel);
            TabbedPane.remove(AssignmentsPanel);
            TabbedPane.remove(LecturesPanel);
            TabbedPane.remove(LecturersPanel);
            TabbedPane.remove(UsersPanel);
            TabbedPane.remove(LogsPanel);
            TabbedPane.remove(ReportsPanel);
            TabbedPane.remove(ToolsPanel);
            TabbedPane.remove(ClassroomsPanel);
            TabbedPane.remove(BatchesPanel);
        }else if(usertype == UserType.coordinator){
            TabbedPane.remove(UsersPanel);
            TabbedPane.remove(LogsPanel);
            TabbedPane.remove(ReportsPanel);
            TabbedPane.remove(ToolsPanel);
        }
        this.setLocationRelativeTo(null);
        showDepartments(null, null);
        showStudents(null, null);
        showLecturers(null, null);
        showCourses(null, null);
        showClassrooms(null, null);
        showPracticals(null, null);
        showPayments(null, null);
        showModules(null, null);
        showExams(null, null);
        showAssignments(null, null);
        showLectures(null, null);
        showUsers(null, null);
        showLogs(null, null);
        showBatches(null, null);
        showStAss(null, null);
        showStExams(null, null);
        showCourseModules(null, null);
        showStAttendance(null, null);
        showStCourses(null, null);
        showStBatches(null, null);
        showCourseBatches(null, null);
        stateInsertDepartment();
        stateInsertStudent();
        stateInsertLecturer();
        stateInsertCourse();
        stateInsertClassroom();
        stateInsertPractical();
        stateInsertPayment();
        stateInsertModule();
        stateInsertExam();
        stateInsertAssignment();
        stateInsertLecture();
        stateInsertUser();
        stateInsertBatch();
        stateInsertStAss();
        stateInsertStExam();
        stateInsertCourseModule();
        stateInsertStAttendance();
        stateInsertStCourse();
        stateInsertStBatch();
        stateInsertCourseBatch();
    }
    
    //Department
    private void clearDepartmentForm(){
        txtDepartmentid.setText(null);
        txtDepartmentname.setText(null);
        txtDepartmentdescription.setText(null);
        txtDepartmentid.requestFocus();
    }
    
    private void stateInsertDepartment(){
        btnUpdateDepartment.setEnabled(false);
        btnDeleteDepartment.setEnabled(false);
        btnInsertDepartment.setText("Insert");
    }
    
    private void stateUpdateDepartment(){
        btnUpdateDepartment.setEnabled(true);
        btnDeleteDepartment.setEnabled(true);
        btnInsertDepartment.setText("New Department...");
    }
    
    private void showDepartments(String where, String what){
        Vector<Vector<String>> data = null;
        Vector<String> header = new Vector<String>();
        header.add("Department ID");
        header.add("Name");
        header.add("Description");
        header.add("User ID");
        try{
            if(where == null && what==null){
                data = new VectorModel().getDepartments();
            }else{
                data = new VectorModel().getDepartments(where, what);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane, "Exception in searchDepartments: " + ex.getMessage());
        }
        tblDepartments.setModel(new javax.swing.table.DefaultTableModel(data, header));
        jScrollPane1.setViewportView(tblDepartments);
    }
    //Department
    
    //Student 
    private void clearStudentForm(){
        txtStudentid.setText(null);
        txtStudentname.setText(null);
        txtStudentaddress.setText(null);
        cmbStudentgender.setSelectedItem(null);
        dteStudentbirthday.setDate(null);
        txtStudentemail.setText(null);
        txtStudentphone.setText(null);
        txtStudentbackground.setText(null);
        dteStudentregdate.setDate(null);
        txtStudentid.requestFocus();
    }
    
    private void stateInsertStudent(){
        btnUpdatestudent.setEnabled(false);
        btnDeletestudent.setEnabled(false);
        btnInsertstudent.setText("Insert");
        ComboBox.bindCombo(cmbStudentbatchid, "tblbatch", "batchid");
    }
    
    private void stateUpdateStudent(){
        btnUpdatestudent.setEnabled(true);
        btnDeletestudent.setEnabled(true);
        btnInsertstudent.setText("New Student...");
        ComboBox.bindCombo(cmbStudentbatchid, "tblbatch", "batchid");
    }
    
    private void showStudents(String where, String what){
        Vector<Vector<String>> data = null;
        Vector<String> header = new Vector<String>();
        header.add("Student ID");
        header.add("Name");
        header.add("Address");
        header.add("Gender");
        header.add("Birthday");
        header.add("Email");
        header.add("Phone");
        header.add("Background");
        header.add("Reg Date");
        header.add("Batch ID");
        header.add("User ID");
        try{
            if(where == null && what==null){
                data = new VectorModel().getStudents();
            }else{
                data = new VectorModel().getStudents(where, what);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane, "Exception in searchStudents: " + ex.getMessage());
        }
        tblStudents.setModel(new javax.swing.table.DefaultTableModel(data, header));
        jScrollPane15.setViewportView(tblStudents);
    }
    //Student
    
    //Lecturer 
    private void clearLecturerForm(){
        txtLecturerid.setText(null);
        txtLecturername.setText(null);
        txtLectureraddress.setText(null);
        txtLectureremail.setText(null);
        txtLecturerphone.setText(null);
        txtLecturerdescription.setText(null);
        txtLecturerid.requestFocus();
    }
    
    private void stateInsertLecturer(){
        btnUpdatelecturer.setEnabled(false);
        btnDeletelecturer.setEnabled(false);
        btnInsertlecturer.setText("Insert");
    }
    
    private void stateUpdateLecturer(){
        btnUpdatelecturer.setEnabled(true);
        btnDeletelecturer.setEnabled(true);
        btnInsertlecturer.setText("New Lecturer...");
    }
    
    private void showLecturers(String where, String what){
        Vector<Vector<String>> data = null;
        Vector<String> header = new Vector<String>();
        header.add("Lecturer ID");
        header.add("Name");
        header.add("Address");;
        header.add("Email");
        header.add("Phone");
        header.add("Description");
        header.add("User ID");
        try{
            if(where == null && what==null){
                data = new VectorModel().getLecturers();
            }else{
                data = new VectorModel().getLecturers(where, what);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane, "Exception in showLecturers: " + ex.getMessage());
        }
        tblLecturers.setModel(new javax.swing.table.DefaultTableModel(data, header));
        jScrollPane4.setViewportView(tblLecturers);
    }
    //Lecturer
    
    //Course 
    private void clearCourseForm(){
        txtCourseid.setText(null);
        txtCoursename.setText(null);
        txtCourseduration.setText(null);
        txtCoursefee.setText(null);
        txtCourselevel.setText(null);
        txtCourseid.requestFocus();
    }
    
    private void stateInsertCourse(){
        btnUpdatecourse.setEnabled(false);
        btnDeletecourse.setEnabled(false);
        btnInsertcourse.setText("Insert");
        ComboBox.bindCombo(cmbCoursedepartmentid, "tbldepartment", "departmentid");
        ComboBox.bindCombo(cmbCoursecoordinatorid, "tbllecturer", "lecturerid");
    }
    
    private void stateUpdateCourse(){
        btnUpdatecourse.setEnabled(true);
        btnDeletecourse.setEnabled(true);
        btnInsertcourse.setText("New Course...");
        ComboBox.bindCombo(cmbCoursedepartmentid, "tbldepartment", "departmentid");
        ComboBox.bindCombo(cmbCoursecoordinatorid, "tbllecturer", "lecturerid");
    }
    
    private void showCourses(String where, String what){
        Vector<Vector<String>> data = null;
        Vector<String> header = new Vector<String>();
        header.add("Course ID");
        header.add("Name");
        header.add("Duration");;
        header.add("Fee");
        header.add("Level");
        header.add("Department ID");
        header.add("Coordinator ID");
        header.add("User ID");
        try{
            if(where == null && what==null){
                data = new VectorModel().getCourses();
            }else{
                data = new VectorModel().getCourses(where, what);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane, "Exception in showCourses: " + ex.getMessage());
        }
        tblCourses.setModel(new javax.swing.table.DefaultTableModel(data, header));
        jScrollPane3.setViewportView(tblCourses);
    }
    //Course
    
    //Practical 
    private void clearPracticalForm(){
        txtPracticalid.setText(null);
        txtCoursename.setText(null);
        dtePracticalstartdate.setDate(null);
        dtePracticalenddate.setDate(null);
        txtPracticalid.requestFocus();
    }
    
    private void stateInsertPractical(){
        btnUpdatepractical.setEnabled(false);
        btnDeletepractical.setEnabled(false);
        btnInsertpractical.setText("Insert");
        ComboBox.bindCombo(cmbPracticalstudentid, "tblstudent", "studentid");
        ComboBox.bindCombo(cmbPracticalclassroomid, "tblclassroom", "classroomid");
    }
    
    private void stateUpdatePractical(){
        btnUpdatepractical.setEnabled(true);
        btnDeletepractical.setEnabled(true);
        btnInsertpractical.setText("New Practical...");
        ComboBox.bindCombo(cmbPracticalstudentid, "tblstudent", "studentid");
        ComboBox.bindCombo(cmbPracticalclassroomid, "tblclassroom", "classroomid");
    }
    
    private void showPracticals(String where, String what){
        Vector<Vector<String>> data = null;
        Vector<String> header = new Vector<String>();
        header.add("Practical ID");
        header.add("Start Time");
        header.add("End Time");;
        header.add("Student ID");
        header.add("Classroom ID");
        header.add("User ID");
        try{
            if(where == null && what==null){
                data = new VectorModel().getPracticals();
            }else{
                data = new VectorModel().getPracticals(where, what);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane, "Exception in showPracticals: " + ex.getMessage());
        }
        tblPracticals.setModel(new javax.swing.table.DefaultTableModel(data, header));
        jScrollPane5.setViewportView(tblPracticals);
    }
    //Practical
    
    //Classroom 
    private void clearClassroomForm(){
        txtClassroomid.setText(null);
        txtClassroomname.setText(null);
        txtClassroomdescription.setText(null);
        txtClassroomid.requestFocus();
    }
    
    private void stateInsertClassroom(){
        btnUpdateClassroom.setEnabled(false);
        btnDeleteClassroom.setEnabled(false);
        btnInsertClassroom.setText("Insert");
    }
    
    private void stateUpdateClassroom(){
        btnUpdateClassroom.setEnabled(true);
        btnDeleteClassroom.setEnabled(true);
        btnInsertClassroom.setText("New Classroom...");
    }
    
    private void showClassrooms(String where, String what){
        Vector<Vector<String>> data = null;
        Vector<String> header = new Vector<String>();
        header.add("Classroom ID");
        header.add("Classroom Name");
        header.add("Description");;
        header.add("User ID");
        try{
            if(where == null && what==null){
                data = new VectorModel().getClassrooms();
            }else{
                data = new VectorModel().getClassrooms(where, what);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane, "Exception in showClassrooms: " + ex.getMessage());
        }
        tblClassrooms.setModel(new javax.swing.table.DefaultTableModel(data, header));
        jScrollPane13.setViewportView(tblClassrooms);
    }
    //Classroom
    
    //Payment 
    private void clearPaymentForm(){
        txtPaymentid.setText(null);
        txtPaymentamount.setText(null);
        dtePaymentdate.setDate(null);
        txtPaymentid.requestFocus();
    }
    
    private void stateInsertPayment(){
        btnUpdatepayment.setEnabled(false);
        btnDeletepayment.setEnabled(false);
        btnInsertpayment.setText("Insert");
        ComboBox.bindCombo(cmbPaymentstudentid, "tblstudent", "studentid");
    }
    
    private void stateUpdatePayment(){
        btnUpdatepayment.setEnabled(true);
        btnDeletepayment.setEnabled(true);
        btnInsertpayment.setText("New Payment...");
        ComboBox.bindCombo(cmbPaymentstudentid, "tblstudent", "studentid");
    }
    
    private void showPayments(String where, String what){
        Vector<Vector<String>> data = null;
        Vector<String> header = new Vector<String>();
        header.add("Payment ID");
        header.add("Amount");
        header.add("Time");
        header.add("Student ID");
        header.add("User ID");
        try{
            if(where == null && what==null){
                data = new VectorModel().getPayments();
            }else{
                data = new VectorModel().getPayments(where, what);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane, "Exception in showPayments: " + ex.getMessage());
        }
        tblPayments.setModel(new javax.swing.table.DefaultTableModel(data, header));
        jScrollPane6.setViewportView(tblPayments);
    }
    //Payment
    
    //Module 
    private void clearModuleForm(){
        txtModuleid.setText(null);
        txtModulename.setText(null);
        txtModuledescription.setText(null);
        txtModuleid.requestFocus();
    }
    
    private void stateInsertModule(){
        btnUpdatemodule.setEnabled(false);
        btnDeletemodule.setEnabled(false);
        btnInsertmodule.setText("Insert");
        ComboBox.bindCombo(cmbModulelecturerid, "tbllecturer", "lecturerid");
    }
    
    private void stateUpdateModule(){
        btnUpdatemodule.setEnabled(true);
        btnDeletemodule.setEnabled(true);
        btnInsertmodule.setText("New Module...");
        ComboBox.bindCombo(cmbModulelecturerid, "tbllecturer", "lecturerid");
    }
    
    private void showModules(String where, String what){
        Vector<Vector<String>> data = null;
        Vector<String> header = new Vector<String>();
        header.add("Module ID");
        header.add("Name");
        header.add("Description");
        header.add("Lecturer ID");
        header.add("User ID");
        try{
            if(where == null && what==null){
                data = new VectorModel().getModules();
            }else{
                data = new VectorModel().getModules(where, what);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane, "Exception in showModules: " + ex.getMessage());
        }
        tblModules.setModel(new javax.swing.table.DefaultTableModel(data, header));
        jScrollPane7.setViewportView(tblModules);
    }
    //Module
    
    //Exam 
    private void clearExamForm(){
        txtExamid.setText(null);
        dteExamstartdate.setDate(null);
        dteExamenddate.setDate(null);
        txtExamid.requestFocus();
    }
    
    private void stateInsertExam(){
        btnUpdateexam.setEnabled(false);
        btnDeleteexam.setEnabled(false);
        btnInsertexam.setText("Insert");
        ComboBox.bindCombo(cmbExammoduleid, "tblmodule", "moduleid");
    }
    
    private void stateUpdateExam(){
        btnUpdateexam.setEnabled(true);
        btnDeleteexam.setEnabled(true);
        btnInsertexam.setText("New Exam...");
        ComboBox.bindCombo(cmbExammoduleid, "tblmodule", "moduleid");
    }
    
    private void showExams(String where, String what){
        Vector<Vector<String>> data = null;
        Vector<String> header = new Vector<String>();
        header.add("Exam ID");
        header.add("Start Time");
        header.add("End Time");
        header.add("Module ID");
        header.add("User ID");
        try{
            if(where == null && what==null){
                data = new VectorModel().getExams();
            }else{
                data = new VectorModel().getExams(where, what);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane, "Exception in showExams: " + ex.getMessage());
        }
        tblExams.setModel(new javax.swing.table.DefaultTableModel(data, header));
        jScrollPane8.setViewportView(tblExams);
    }
    //Exam
    
    //Assignment 
    private void clearAssignmentForm(){
        txtAssignmentid.setText(null);
        txtAssignmentname.setText(null);
        txtAssignmentdescription.setText(null);
        dteAssignmentduedate.setDate(null);
        txtAssignmentid.requestFocus();
    }
    
    private void stateInsertAssignment(){
        btnUpdateassignment.setEnabled(false);
        btnDeleteassignment.setEnabled(false);
        btnInsertassignment.setText("Insert");
        ComboBox.bindCombo(cmbAssignmentmoduleid, "tblmodule", "moduleid");
    }
    
    private void stateUpdateAssignment(){
        btnUpdateassignment.setEnabled(true);
        btnDeleteassignment.setEnabled(true);
        btnInsertassignment.setText("New Assignment...");
        ComboBox.bindCombo(cmbAssignmentmoduleid, "tblmodule", "moduleid");
    }
    
    private void showAssignments(String where, String what){
        Vector<Vector<String>> data = null;
        Vector<String> header = new Vector<String>();
        header.add("Assignment ID");
        header.add("Assignment Name");
        header.add("Description");
        header.add("Module ID");
        header.add("Due Date");
        header.add("User ID");
        try{
            if(where == null && what==null){
                data = new VectorModel().getAssignments();
            }else{
                data = new VectorModel().getAssignments(where, what);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane, "Exception in showAssignment: " + ex.getMessage());
        }
        tblAssignments.setModel(new javax.swing.table.DefaultTableModel(data, header));
        jScrollPane9.setViewportView(tblAssignments);
    }
    //Assignment
    
    //Lecture 
    private void clearLectureForm(){
        txtLectureid.setText(null);
        dteLecturestartdate.setDate(null);
        dteLectureenddate.setDate(null);
        txtLecturedescription.setText(null);
        txtLectureclassroomid.setText(null);
        txtLectureid.requestFocus();
    }
    
    private void stateInsertLecture(){
        btnUpdatelecture.setEnabled(false);
        btnDeletelecture.setEnabled(false);
        btnInsertlecture.setText("Insert");
        ComboBox.bindCombo(cmbLecturemoduleid, "tblmodule", "moduleid");
    }
    
    private void stateUpdateLecture(){
        btnUpdatelecture.setEnabled(true);
        btnDeletelecture.setEnabled(true);
        btnInsertlecture.setText("New Lecture...");
        ComboBox.bindCombo(cmbLecturemoduleid, "tblmodule", "moduleid");
    }
    
    private void showLectures(String where, String what){
        Vector<Vector<String>> data = null;
        Vector<String> header = new Vector<String>();
        header.add("Lecure ID");
        header.add("Start Time");
        header.add("End Time");
        header.add("Description");
         header.add("Classroom ID");
        header.add("Module ID");
        header.add("User ID");
        try{
            if(where == null && what==null){
                data = new VectorModel().getLectures();
            }else{
                data = new VectorModel().getLectures(where, what);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane, "Exception in showLectures: " + ex.getMessage());
        }
        tblLectures.setModel(new javax.swing.table.DefaultTableModel(data, header));
        jScrollPane10.setViewportView(tblLectures);
    }
    //Lecture
    
    //User
    private void clearUserForm(){
        txtUserid.setText(null);
        txtUsername.setText(null);
        txtUseremail.setText(null);
        txtUserpassword.setText(null);
        txtUserid.requestFocus();
    }
    
    private void stateInsertUser(){
        btnUpdateuser.setEnabled(false);
        btnDeleteuser.setEnabled(false);
        btnInsertuser.setText("Insert");
    }
    
    private void stateUpdateUser(){
        btnUpdateuser.setEnabled(true);
        btnDeleteuser.setEnabled(true);
        btnInsertuser.setText("New User...");
    }
    
    private void showUsers(String where, String what){
        Vector<Vector<String>> data = null;
        Vector<String> header = new Vector<String>();
        header.add("User ID");
        header.add("User Name");
        header.add("Email");
        header.add("Type");
        header.add("Status");
        try{
            if(where == null && what==null){
                data = new VectorModel().getUsers();
            }else{
                data = new VectorModel().getUsers(where, what);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane, "Exception in showUsers: " + ex.getMessage());
        }
        tblUsers.setModel(new javax.swing.table.DefaultTableModel(data, header));
        jScrollPane11.setViewportView(tblUsers);
    }
    //User
    
    //Log
    private void showLogs(String where, String what){
        Vector<Vector<String>> data = null;
        Vector<String> header = new Vector<String>();
        header.add("Log ID");
        header.add("Entity");
        header.add("Action");
        header.add("Time");
        header.add("User ID");
        try{
            if(where == null && what==null){
                data = new VectorModel().getLogs();
            }else{
                data = new VectorModel().getLogs(where, what);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane, "Exception in showLogs: " + ex.getMessage());
        }
        tblLogs.setModel(new javax.swing.table.DefaultTableModel(data, header));
        jScrollPane12.setViewportView(tblLogs);
    }
    //Log
    
    //Batch
    private void clearBatchForm(){
        txtBatchid.setText(null);
        txtBatchname.setText(null);
        dteBatchstartdate.setDate(null);
        txtBatchid.requestFocus();
    }
    
    private void stateInsertBatch(){
        btnUpdateBatch.setEnabled(false);
        btnDeleteBatch.setEnabled(false);
        btnInsertBatch.setText("Insert");
    }
    
    private void stateUpdateBatch(){
        btnUpdateBatch.setEnabled(true);
        btnDeleteBatch.setEnabled(true);
        btnInsertBatch.setText("New Batch...");
    }
    
    private void showBatches(String where, String what){
        Vector<Vector<String>> data = null;
        Vector<String> header = new Vector<String>();
        header.add("Batch ID");
        header.add("Batch Name");
        header.add("Start Date");
        header.add("User ID");
        try{
            if(where == null && what==null){
                data = new VectorModel().getBatches();
            }else{
                data = new VectorModel().getBatches(where, what);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane, "Exception in showBatches: " + ex.getMessage());
        }
        tblBatches.setModel(new javax.swing.table.DefaultTableModel(data, header));
        jScrollPane14.setViewportView(tblBatches);
    }
    //Batch
    
    //Student Assignment
    private void clearStAssForm(){
        txtStAssMarks.setText(null);
        txtStAssMarks.requestFocus();
    }
    
    private void stateInsertStAss(){
        btnUpdateStAss.setEnabled(false);
        btnDeleteStAss.setEnabled(false);
        btnInsertStAss.setText("Insert");
        ComboBox.bindCombo(cmbStAssStudentid, "tblstudent", "studentid");
        ComboBox.bindCombo(cmbStAssAssignmentid, "tblassignment", "assignmentid");
    }
    
    private void stateUpdateStAss(){
        btnUpdateStAss.setEnabled(true);
        btnDeleteStAss.setEnabled(true);
        btnInsertStAss.setText("New Record...");
        ComboBox.bindCombo(cmbStAssStudentid, "tblstudent", "studentid");
        ComboBox.bindCombo(cmbStAssAssignmentid, "tblassignment", "assignmentid");
    }
    
    private void showStAss(String where, String what){
        Vector<Vector<String>> data = null;
        Vector<String> header = new Vector<String>();
        header.add("Student ID");
        header.add("Assignment ID");
        header.add("Marks");
        header.add("User ID");
        try{
            if(where == null && what==null){
                data = new VectorModel().getStudentAssignments();
            }else{
                data = new VectorModel().getStudentAssignments(where, what);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane, "Exception in showStAss: " + ex.getMessage());
        }
        tblStAss.setModel(new javax.swing.table.DefaultTableModel(data, header));
        jScrollPane16.setViewportView(tblStAss);
    }
    //student assignment
    
    //Student Exam
    private void clearStExamForm(){
        txtStExamMarks.setText(null);
        txtStExamMarks.requestFocus();
    }
    
    private void stateInsertStExam(){
        btnUpdateStExam.setEnabled(false);
        btnDeleteStExam.setEnabled(false);
        btnInsertStExam.setText("Insert");
        ComboBox.bindCombo(cmbStExamStudentid, "tblstudent", "studentid");
        ComboBox.bindCombo(cmbStExamExamid, "tblexam", "examid");
    }
    
    private void stateUpdateStExam(){
        btnUpdateStExam.setEnabled(true);
        btnDeleteStExam.setEnabled(true);
        btnInsertStExam.setText("New Record...");
        ComboBox.bindCombo(cmbStExamStudentid, "tblstudent", "studentid");
        ComboBox.bindCombo(cmbStExamExamid, "tblexam", "examid");
    }
    
    private void showStExams(String where, String what){
        Vector<Vector<String>> data = null;
        Vector<String> header = new Vector<String>();
        header.add("Student ID");
        header.add("Exam ID");
        header.add("Marks");
        header.add("User ID");
        try{
            if(where == null && what==null){
                data = new VectorModel().getStudentExams();
            }else{
                data = new VectorModel().getStudentExams(where, what);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane, "Exception in showStExams: " + ex.getMessage());
        }
        tblStExam.setModel(new javax.swing.table.DefaultTableModel(data, header));
        jScrollPane17.setViewportView(tblStExam);
    }
    //student exam
    
    //Course Module
    private void clearCourseModuleForm(){
        cmbCourseModuleCourseid.requestFocus();
    }
    
    private void stateInsertCourseModule(){
        btnDeleteCourseModule.setEnabled(false);
        btnInsertCourseModule.setText("Insert");
        ComboBox.bindCombo(cmbCourseModuleCourseid, "tblcourse", "courseid");
        ComboBox.bindCombo(cmbCourseModuleModuleid, "tblmodule", "moduleid");
    }
    
    private void stateUpdateCourseModule(){
        btnDeleteCourseModule.setEnabled(true);
        btnInsertCourseModule.setText("New Record...");
        ComboBox.bindCombo(cmbCourseModuleCourseid, "tblcourse", "courseid");
        ComboBox.bindCombo(cmbCourseModuleModuleid, "tblmodule", "moduleid");
    }
    
    private void showCourseModules(String where, String what){
        Vector<Vector<String>> data = null;
        Vector<String> header = new Vector<String>();
        header.add("Course ID");
        header.add("Module ID");
        header.add("User ID");
        try{
            if(where == null && what==null){
                data = new VectorModel().getCourseModules();
            }else{
                data = new VectorModel().getCourseModules(where, what);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane, "Exception in showCourseModules: " + ex.getMessage());
        }
        tblCourseModules.setModel(new javax.swing.table.DefaultTableModel(data, header));
        jScrollPane18.setViewportView(tblCourseModules);
    }
    //course modules
    
    //attendance
    private void clearStAttendanceForm(){
        dteStAttendancedate.cleanup();
        cmbStAttendanceStudentid.requestFocus();
    }
    
    private void stateInsertStAttendance(){
        btnUpdateStAttendance.setEnabled(false);
        btnDeleteStAttendance.setEnabled(false);
        btnInsertStAttendance.setText("Insert");
        ComboBox.bindCombo(cmbStAttendanceStudentid, "tblstudent", "studentid");
        ComboBox.bindCombo(cmbStAttendanceLectureid, "tbllecture", "lectureid");
    }
    
    private void stateUpdateStAttendance(){
        btnUpdateStAttendance.setEnabled(true);
        btnDeleteStAttendance.setEnabled(true);
        btnInsertStAttendance.setText("New Record...");
        ComboBox.bindCombo(cmbStAttendanceStudentid, "tblstudent", "studentid");
        ComboBox.bindCombo(cmbStAttendanceLectureid, "tbllecture", "lectureid");
    }
    
    private void showStAttendance(String where, String what){
        Vector<Vector<String>> data = null;
        Vector<String> header = new Vector<String>();
        header.add("Student ID");
        header.add("Lecture ID");
        header.add("Time");
        header.add("User ID");
        try{
            if(where == null && what==null){
                data = new VectorModel().getStudentAttendance();
            }else{
                data = new VectorModel().getStudentAttendance(where, what);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane, "Exception in showStAttendance: " + ex.getMessage());
        }
        tblStAttendance.setModel(new javax.swing.table.DefaultTableModel(data, header));
        jScrollPane19.setViewportView(tblStAttendance);
    }
    //attendance
    
    //Student course
    private void clearStCourseForm(){
        txtStCourseFee.setText(null);
        txtStCourseFee.requestFocus();
    }
    
    private void stateInsertStCourse(){
        btnUpdateStCourse.setEnabled(false);
        btnDeleteStCourse.setEnabled(false);
        btnInsertStCourse.setText("Insert");
        ComboBox.bindCombo(cmbStCourseStudentid, "tblstudent", "studentid");
        ComboBox.bindCombo(cmbStCourseCourseid, "tblcourse", "courseid");
    }
    
    private void stateUpdateStCourse(){
        btnUpdateStCourse.setEnabled(true);
        btnDeleteStCourse.setEnabled(true);
        btnInsertStCourse.setText("New Record...");
        ComboBox.bindCombo(cmbStCourseStudentid, "tblstudent", "studentid");
        ComboBox.bindCombo(cmbStCourseCourseid, "tblcourse", "courseid");
    }
    
    private void showStCourses(String where, String what){
        Vector<Vector<String>> data = null;
        Vector<String> header = new Vector<String>();
        header.add("Course ID");
        header.add("Student ID");
        header.add("Fee");
        header.add("User ID");
        try{
            if(where == null && what==null){
                data = new VectorModel().getStudentCourses();
            }else{
                data = new VectorModel().getStudentCourses(where, what);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane, "Exception in showStCourses: " + ex.getMessage());
        }
        tblStCourse.setModel(new javax.swing.table.DefaultTableModel(data, header));
        jScrollPane20.setViewportView(tblStCourse);
    }
    //student course
    
    //Student batch
    private void clearStBatchForm(){
        cmbStBatchStudentid.requestFocus();
    }
    
    private void stateInsertStBatch(){
        btnDeleteStBatch.setEnabled(false);
        btnInsertStBatch.setText("Insert");
        ComboBox.bindCombo(cmbStBatchStudentid, "tblstudent", "studentid");
        ComboBox.bindCombo(cmbStBatchBatchid, "tblbatch", "batchid");
    }
    
    private void stateUpdateStBatch(){
        btnDeleteStBatch.setEnabled(true);
        btnInsertStBatch.setText("New Record...");
        ComboBox.bindCombo(cmbStBatchStudentid, "tblstudent", "studentid");
        ComboBox.bindCombo(cmbStBatchBatchid, "tblbatch", "batchid");
    }
    
    private void showStBatches(String where, String what){
        Vector<Vector<String>> data = null;
        Vector<String> header = new Vector<String>();
        header.add("Batch ID");
        header.add("Student ID");
        header.add("User ID");
        try{
            if(where == null && what==null){
                data = new VectorModel().getStudentBatches();
            }else{
                data = new VectorModel().getStudentBatches(where, what);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane, "Exception in showStBatches: " + ex.getMessage());
        }
        tblStBatch.setModel(new javax.swing.table.DefaultTableModel(data, header));
        jScrollPane21.setViewportView(tblStBatch);
    }
    //student batch
    
    //course batch
    private void clearCourseBatchForm(){
        cmbCourseBatchCourseid.requestFocus();
    }
    
    private void stateInsertCourseBatch(){
        btnDeleteCourseBatch.setEnabled(false);
        btnInsertCourseBatch.setText("Insert");
        ComboBox.bindCombo(cmbCourseBatchCourseid, "tblcourse", "courseid");
        ComboBox.bindCombo(cmbCourseBatchBatchid, "tblbatch", "batchid");
    }
    
    private void stateUpdateCourseBatch(){
        btnDeleteCourseBatch.setEnabled(true);
        btnInsertCourseBatch.setText("New Record...");
        ComboBox.bindCombo(cmbCourseBatchCourseid, "tblcourse", "courseid");
        ComboBox.bindCombo(cmbCourseBatchBatchid, "tblbatch", "batchid");
    }
    
    private void showCourseBatches(String where, String what){
        Vector<Vector<String>> data = null;
        Vector<String> header = new Vector<String>();
        header.add("Course ID");
        header.add("Batch ID");
        header.add("User ID");
        try{
            if(where == null && what==null){
                data = new VectorModel().getCourseBatches();
            }else{
                data = new VectorModel().getCourseBatches(where, what);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane, "Exception in showCourseBatches: " + ex.getMessage());
        }
        tblCourseBatches.setModel(new javax.swing.table.DefaultTableModel(data, header));
        jScrollPane22.setViewportView(tblCourseBatches);
    }
    //course batch
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TabbedPane = new javax.swing.JTabbedPane();
        StudentsPanel = new javax.swing.JPanel();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel44 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        tblStudents = new javax.swing.JTable();
        txtSearchstudent = new javax.swing.JTextField();
        cmbStudentsearchin = new javax.swing.JComboBox();
        jLabel81 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtStudentid = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtStudentname = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtStudentaddress = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtStudentemail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtStudentphone = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtStudentbackground = new javax.swing.JTextField();
        dteStudentbirthday = new com.toedter.calendar.JDateChooser();
        cmbStudentgender = new javax.swing.JComboBox();
        cmbStudentbatchid = new javax.swing.JComboBox();
        jLabel76 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        dteStudentregdate = new com.toedter.calendar.JDateChooser();
        btnUpdatestudent = new javax.swing.JButton();
        btnDeletestudent = new javax.swing.JButton();
        btnInsertstudent = new javax.swing.JButton();
        jPanel45 = new javax.swing.JPanel();
        jPanel46 = new javax.swing.JPanel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        txtStCourseFee = new javax.swing.JTextField();
        cmbStCourseStudentid = new javax.swing.JComboBox();
        cmbStCourseCourseid = new javax.swing.JComboBox();
        btnUpdateStCourse = new javax.swing.JButton();
        btnDeleteStCourse = new javax.swing.JButton();
        btnInsertStCourse = new javax.swing.JButton();
        jPanel47 = new javax.swing.JPanel();
        jScrollPane20 = new javax.swing.JScrollPane();
        tblStCourse = new javax.swing.JTable();
        txtSearchstcourse = new javax.swing.JTextField();
        cmbStCoursesearchin = new javax.swing.JComboBox();
        jLabel90 = new javax.swing.JLabel();
        jPanel54 = new javax.swing.JPanel();
        jPanel55 = new javax.swing.JPanel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        cmbStBatchStudentid = new javax.swing.JComboBox();
        cmbStBatchBatchid = new javax.swing.JComboBox();
        jPanel56 = new javax.swing.JPanel();
        jScrollPane21 = new javax.swing.JScrollPane();
        tblStBatch = new javax.swing.JTable();
        txtSearchstbatch = new javax.swing.JTextField();
        cmbStBatchsearchin = new javax.swing.JComboBox();
        jLabel121 = new javax.swing.JLabel();
        btnDeleteStBatch = new javax.swing.JButton();
        btnInsertStBatch = new javax.swing.JButton();
        DepartmentsPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDepartments = new javax.swing.JTable();
        txtSearchdepartment = new javax.swing.JTextField();
        cmbDepartmentsearchin = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDepartmentid = new javax.swing.JTextField();
        txtDepartmentname = new javax.swing.JTextField();
        txtDepartmentdescription = new javax.swing.JTextField();
        btnInsertDepartment = new javax.swing.JButton();
        btnUpdateDepartment = new javax.swing.JButton();
        btnDeleteDepartment = new javax.swing.JButton();
        PracticalsPanel = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblPracticals = new javax.swing.JTable();
        txtSearchpractical = new javax.swing.JTextField();
        cmbPracticalsearchin = new javax.swing.JComboBox();
        jLabel30 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        txtPracticalid = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        cmbPracticalstudentid = new javax.swing.JComboBox();
        cmbPracticalclassroomid = new javax.swing.JComboBox();
        cmbPracticalstarttime = new javax.swing.JComboBox();
        dtePracticalstartdate = new com.toedter.calendar.JDateChooser();
        cmbPracticalendtime = new javax.swing.JComboBox();
        dtePracticalenddate = new com.toedter.calendar.JDateChooser();
        btnUpdatepractical = new javax.swing.JButton();
        btnDeletepractical = new javax.swing.JButton();
        btnInsertpractical = new javax.swing.JButton();
        PaymentsPanel = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblPayments = new javax.swing.JTable();
        txtSearchpayment = new javax.swing.JTextField();
        cmbPaymentsearchin = new javax.swing.JComboBox();
        jLabel31 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        txtPaymentid = new javax.swing.JTextField();
        txtPaymentamount = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        cmbPaymentstudentid = new javax.swing.JComboBox();
        cmbPaymenttime = new javax.swing.JComboBox();
        dtePaymentdate = new com.toedter.calendar.JDateChooser();
        btnUpdatepayment = new javax.swing.JButton();
        btnDeletepayment = new javax.swing.JButton();
        btnInsertpayment = new javax.swing.JButton();
        ModulesPanel = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblModules = new javax.swing.JTable();
        txtSearchmodule = new javax.swing.JTextField();
        cmbModulesearchin = new javax.swing.JComboBox();
        jLabel32 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        txtModuleid = new javax.swing.JTextField();
        txtModulename = new javax.swing.JTextField();
        txtModuledescription = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        cmbModulelecturerid = new javax.swing.JComboBox();
        btnUpdatemodule = new javax.swing.JButton();
        btnDeletemodule = new javax.swing.JButton();
        btnInsertmodule = new javax.swing.JButton();
        CoursesPanel = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel36 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCourses = new javax.swing.JTable();
        txtSearchcourse = new javax.swing.JTextField();
        cmbCoursesearchin = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtCourseid = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtCoursename = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtCourseduration = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtCoursefee = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtCourselevel = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        cmbCoursedepartmentid = new javax.swing.JComboBox();
        cmbCoursecoordinatorid = new javax.swing.JComboBox();
        btnUpdatecourse = new javax.swing.JButton();
        btnDeletecourse = new javax.swing.JButton();
        btnInsertcourse = new javax.swing.JButton();
        jPanel37 = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        cmbCourseModuleCourseid = new javax.swing.JComboBox();
        cmbCourseModuleModuleid = new javax.swing.JComboBox();
        jPanel39 = new javax.swing.JPanel();
        jScrollPane18 = new javax.swing.JScrollPane();
        tblCourseModules = new javax.swing.JTable();
        txtSearchcoursemodule = new javax.swing.JTextField();
        cmbCourseModulesearchin = new javax.swing.JComboBox();
        jLabel88 = new javax.swing.JLabel();
        btnDeleteCourseModule = new javax.swing.JButton();
        btnInsertCourseModule = new javax.swing.JButton();
        jPanel57 = new javax.swing.JPanel();
        jPanel58 = new javax.swing.JPanel();
        jLabel120 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        cmbCourseBatchCourseid = new javax.swing.JComboBox();
        cmbCourseBatchBatchid = new javax.swing.JComboBox();
        btnDeleteCourseBatch = new javax.swing.JButton();
        btnInsertCourseBatch = new javax.swing.JButton();
        jPanel59 = new javax.swing.JPanel();
        jScrollPane22 = new javax.swing.JScrollPane();
        tblCourseBatches = new javax.swing.JTable();
        txtSearchcoursebatch = new javax.swing.JTextField();
        cmbCourseBatchsearchin = new javax.swing.JComboBox();
        jLabel123 = new javax.swing.JLabel();
        ExamsPanel = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel31 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblExams = new javax.swing.JTable();
        txtSearchexam = new javax.swing.JTextField();
        cmbExamsearchin = new javax.swing.JComboBox();
        jLabel33 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        txtExamid = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        cmbExammoduleid = new javax.swing.JComboBox();
        cmbExamstarttime = new javax.swing.JComboBox();
        dteExamstartdate = new com.toedter.calendar.JDateChooser();
        cmbExamendtime = new javax.swing.JComboBox();
        dteExamenddate = new com.toedter.calendar.JDateChooser();
        btnUpdateexam = new javax.swing.JButton();
        btnDeleteexam = new javax.swing.JButton();
        btnInsertexam = new javax.swing.JButton();
        jPanel32 = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        txtStExamMarks = new javax.swing.JTextField();
        cmbStExamStudentid = new javax.swing.JComboBox();
        cmbStExamExamid = new javax.swing.JComboBox();
        btnUpdateStExam = new javax.swing.JButton();
        btnDeleteStExam = new javax.swing.JButton();
        btnInsertStExam = new javax.swing.JButton();
        jPanel35 = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        tblStExam = new javax.swing.JTable();
        txtSearchstexam = new javax.swing.JTextField();
        cmbStExamsearchin = new javax.swing.JComboBox();
        jLabel87 = new javax.swing.JLabel();
        AssignmentsPanel = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblAssignments = new javax.swing.JTable();
        txtSearchassignment = new javax.swing.JTextField();
        cmbAssignmentsearchin = new javax.swing.JComboBox();
        jLabel34 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        txtAssignmentid = new javax.swing.JTextField();
        txtAssignmentname = new javax.swing.JTextField();
        txtAssignmentdescription = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        dteAssignmentduedate = new com.toedter.calendar.JDateChooser();
        jLabel64 = new javax.swing.JLabel();
        cmbAssignmentmoduleid = new javax.swing.JComboBox();
        cmbAssignmentduetime = new javax.swing.JComboBox();
        btnUpdateassignment = new javax.swing.JButton();
        btnDeleteassignment = new javax.swing.JButton();
        btnInsertassignment = new javax.swing.JButton();
        jPanel29 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        tblStAss = new javax.swing.JTable();
        txtSearchstass = new javax.swing.JTextField();
        cmbStAsssearchin = new javax.swing.JComboBox();
        jLabel86 = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        txtStAssMarks = new javax.swing.JTextField();
        cmbStAssStudentid = new javax.swing.JComboBox();
        cmbStAssAssignmentid = new javax.swing.JComboBox();
        btnUpdateStAss = new javax.swing.JButton();
        btnDeleteStAss = new javax.swing.JButton();
        btnInsertStAss = new javax.swing.JButton();
        LecturesPanel = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel40 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblLectures = new javax.swing.JTable();
        txtSearchlecture = new javax.swing.JTextField();
        cmbLecturessearchin = new javax.swing.JComboBox();
        jLabel35 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        txtLectureid = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        txtLecturedescription = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        txtLectureclassroomid = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        cmbLecturemoduleid = new javax.swing.JComboBox();
        cmbLecturestarttime = new javax.swing.JComboBox();
        dteLecturestartdate = new com.toedter.calendar.JDateChooser();
        cmbLectureendtime = new javax.swing.JComboBox();
        dteLectureenddate = new com.toedter.calendar.JDateChooser();
        btnUpdatelecture = new javax.swing.JButton();
        btnDeletelecture = new javax.swing.JButton();
        btnInsertlecture = new javax.swing.JButton();
        jPanel41 = new javax.swing.JPanel();
        jPanel42 = new javax.swing.JPanel();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        cmbStAttendanceStudentid = new javax.swing.JComboBox();
        cmbStAttendanceLectureid = new javax.swing.JComboBox();
        cmbStAttendancetime = new javax.swing.JComboBox();
        dteStAttendancedate = new com.toedter.calendar.JDateChooser();
        btnUpdateStAttendance = new javax.swing.JButton();
        btnDeleteStAttendance = new javax.swing.JButton();
        btnInsertStAttendance = new javax.swing.JButton();
        jPanel43 = new javax.swing.JPanel();
        jScrollPane19 = new javax.swing.JScrollPane();
        tblStAttendance = new javax.swing.JTable();
        txtSearchstattendance = new javax.swing.JTextField();
        cmbStAttendancesearchin = new javax.swing.JComboBox();
        jLabel89 = new javax.swing.JLabel();
        LecturersPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblLecturers = new javax.swing.JTable();
        txtSearchlecturer = new javax.swing.JTextField();
        cmbLecturersearchin = new javax.swing.JComboBox();
        jLabel23 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        txtLecturerid = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtLecturername = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtLectureraddress = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtLectureremail = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txtLecturerphone = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txtLecturerdescription = new javax.swing.JTextField();
        btnUpdatelecturer = new javax.swing.JButton();
        btnDeletelecturer = new javax.swing.JButton();
        btnInsertlecturer = new javax.swing.JButton();
        ClassroomsPanel = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tblClassrooms = new javax.swing.JTable();
        txtSearchclassroom = new javax.swing.JTextField();
        cmbClassroomsearchin = new javax.swing.JComboBox();
        jLabel70 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        txtClassroomid = new javax.swing.JTextField();
        txtClassroomname = new javax.swing.JTextField();
        txtClassroomdescription = new javax.swing.JTextField();
        btnInsertClassroom = new javax.swing.JButton();
        btnDeleteClassroom = new javax.swing.JButton();
        btnUpdateClassroom = new javax.swing.JButton();
        BatchesPanel = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        tblBatches = new javax.swing.JTable();
        txtSearchbatch = new javax.swing.JTextField();
        cmbBatchsearchin = new javax.swing.JComboBox();
        jLabel77 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        txtBatchid = new javax.swing.JTextField();
        txtBatchname = new javax.swing.JTextField();
        dteBatchstartdate = new com.toedter.calendar.JDateChooser();
        jLabel80 = new javax.swing.JLabel();
        btnUpdateBatch = new javax.swing.JButton();
        btnDeleteBatch = new javax.swing.JButton();
        btnInsertBatch = new javax.swing.JButton();
        UsersPanel = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblUsers = new javax.swing.JTable();
        txtSearchuser = new javax.swing.JTextField();
        cmbUsersearchin = new javax.swing.JComboBox();
        jLabel36 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        txtUserid = new javax.swing.JTextField();
        txtUsername = new javax.swing.JTextField();
        txtUseremail = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        txtUserpassword = new javax.swing.JTextField();
        cmbUsertype = new javax.swing.JComboBox();
        cmbUserstatus = new javax.swing.JComboBox();
        btnUpdateuser = new javax.swing.JButton();
        btnDeleteuser = new javax.swing.JButton();
        btnInsertuser = new javax.swing.JButton();
        LogsPanel = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tblLogs = new javax.swing.JTable();
        txtSearchlog = new javax.swing.JTextField();
        cmbLogsearchin = new javax.swing.JComboBox();
        jLabel37 = new javax.swing.JLabel();
        btnRefreshlog = new javax.swing.JButton();
        btnClearLog = new javax.swing.JButton();
        ReportsPanel = new javax.swing.JPanel();
        jPanel48 = new javax.swing.JPanel();
        btnAllStudentsReport = new javax.swing.JButton();
        btnStudentAssignmentsReport = new javax.swing.JButton();
        btnStudentExamsReport = new javax.swing.JButton();
        txtAssignmentReportStudentid = new javax.swing.JTextField();
        btnStudentAssignmentReport2 = new javax.swing.JButton();
        jLabel91 = new javax.swing.JLabel();
        btnStudentExamsReport2 = new javax.swing.JButton();
        jPanel51 = new javax.swing.JPanel();
        btnStudentPaymentsReport = new javax.swing.JButton();
        jLabel92 = new javax.swing.JLabel();
        txtPaymentReportStudentid = new javax.swing.JTextField();
        btnAllPaymentsReport1 = new javax.swing.JButton();
        jPanel53 = new javax.swing.JPanel();
        btnStudentBatchReport = new javax.swing.JButton();
        jLabel115 = new javax.swing.JLabel();
        txtBatchReportStudentid = new javax.swing.JTextField();
        btnAllCoursesReport = new javax.swing.JButton();
        btnAllBatchesReport = new javax.swing.JButton();
        jLabel116 = new javax.swing.JLabel();
        txtCourseStudentReportCourseid = new javax.swing.JTextField();
        btnCourseStudentsReport = new javax.swing.JButton();
        ToolsPanel = new javax.swing.JPanel();
        jPanel49 = new javax.swing.JPanel();
        txtSenderEmail = new javax.swing.JTextField();
        txtSubject = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMessage = new javax.swing.JTextArea();
        txtSenderEmailPassword = new javax.swing.JPasswordField();
        btnSendMail = new javax.swing.JButton();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel50 = new javax.swing.JPanel();
        btnBackup = new javax.swing.JButton();
        jPanel52 = new javax.swing.JPanel();
        btnRestore = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtSqlDump = new javax.swing.JTextField();
        AboutPanel = new javax.swing.JPanel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Academy Management System");

        TabbedPane.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Students"));

        tblStudents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblStudents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStudentsMouseClicked(evt);
            }
        });
        jScrollPane15.setViewportView(tblStudents);

        txtSearchstudent.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchstudentKeyReleased(evt);
            }
        });

        cmbStudentsearchin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "studentid", "student_name", "address", "gender", "birthday", "email", "phone", "background", "reg_date", "batchid" }));

        jLabel81.setText("Search In:");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 1403, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel81)
                .addGap(18, 18, 18)
                .addComponent(cmbStudentsearchin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSearchstudent, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchstudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbStudentsearchin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel81))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Student Record"));
        jPanel16.setPreferredSize(new java.awt.Dimension(445, 298));

        jLabel9.setText("Student ID:");

        txtStudentid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtStudentidKeyPressed(evt);
            }
        });

        jLabel10.setText("Name:");

        jLabel11.setText("Address:");

        jLabel12.setText("Gender:");

        jLabel13.setText("Birthday:");

        jLabel6.setText("Email:");

        jLabel7.setText("Phone:");

        jLabel8.setText("Background:");

        dteStudentbirthday.setDateFormatString("yyyy-MM-dd");

        cmbStudentgender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));

        jLabel76.setText("Batch ID:");

        jLabel14.setText("Reg. date:");

        dteStudentregdate.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel76, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(38, 38, 38)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dteStudentregdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(txtStudentbackground, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtStudentphone, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtStudentemail, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dteStudentbirthday, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbStudentgender, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtStudentaddress, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtStudentname, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtStudentid, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmbStudentbatchid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtStudentid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStudentname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStudentaddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cmbStudentgender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(dteStudentbirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStudentemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStudentphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(8, 8, 8)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStudentbackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14)
                    .addComponent(dteStudentregdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbStudentbatchid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel76))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnUpdatestudent.setText("Update");
        btnUpdatestudent.setEnabled(false);
        btnUpdatestudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdatestudentActionPerformed(evt);
            }
        });

        btnDeletestudent.setText("Delete");
        btnDeletestudent.setEnabled(false);
        btnDeletestudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletestudentActionPerformed(evt);
            }
        });

        btnInsertstudent.setText("Insert");
        btnInsertstudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertstudentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel44Layout.createSequentialGroup()
                        .addComponent(btnUpdatestudent)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeletestudent)
                        .addGap(18, 18, 18)
                        .addComponent(btnInsertstudent))
                    .addComponent(jPanel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 970, Short.MAX_VALUE))
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertstudent)
                    .addComponent(btnDeletestudent)
                    .addComponent(btnUpdatestudent))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Students", jPanel44);

        jPanel46.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Student Course Record"));
        jPanel46.setPreferredSize(new java.awt.Dimension(445, 116));

        jLabel104.setText("Student ID:");

        jLabel105.setText("Course ID: ");

        jLabel106.setText("Fee:");

        cmbStCourseStudentid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbStCourseCourseid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel104, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel105, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addComponent(jLabel106, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtStCourseFee, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                    .addComponent(cmbStCourseStudentid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbStCourseCourseid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel104)
                    .addComponent(cmbStCourseStudentid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel105)
                    .addComponent(cmbStCourseCourseid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel106)
                    .addComponent(txtStCourseFee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnUpdateStCourse.setText("Update");
        btnUpdateStCourse.setEnabled(false);
        btnUpdateStCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateStCourseActionPerformed(evt);
            }
        });

        btnDeleteStCourse.setText("Delete");
        btnDeleteStCourse.setEnabled(false);
        btnDeleteStCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteStCourseActionPerformed(evt);
            }
        });

        btnInsertStCourse.setText("Insert");
        btnInsertStCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertStCourseActionPerformed(evt);
            }
        });

        jPanel47.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Student Courses"));

        tblStCourse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblStCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStCourseMouseClicked(evt);
            }
        });
        jScrollPane20.setViewportView(tblStCourse);

        txtSearchstcourse.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchstcourseKeyReleased(evt);
            }
        });

        cmbStCoursesearchin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "studentid", "courseid", "fee", "userid" }));

        jLabel90.setText("Search In:");

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane20, javax.swing.GroupLayout.DEFAULT_SIZE, 952, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel47Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel90)
                .addGap(18, 18, 18)
                .addComponent(cmbStCoursesearchin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSearchstcourse, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel47Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchstcourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbStCoursesearchin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel90))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel45Layout.createSequentialGroup()
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addComponent(btnUpdateStCourse)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteStCourse)
                        .addGap(18, 18, 18)
                        .addComponent(btnInsertStCourse)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel45Layout.createSequentialGroup()
                        .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnInsertStCourse)
                            .addComponent(btnDeleteStCourse)
                            .addComponent(btnUpdateStCourse))))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Student Courses", jPanel45);

        jPanel55.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Student Batch Record"));
        jPanel55.setPreferredSize(new java.awt.Dimension(445, 116));

        jLabel118.setText("Student ID:");

        jLabel119.setText("Batch ID: ");

        cmbStBatchStudentid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbStBatchBatchid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel55Layout = new javax.swing.GroupLayout(jPanel55);
        jPanel55.setLayout(jPanel55Layout);
        jPanel55Layout.setHorizontalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel118, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel119, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbStBatchStudentid, 0, 289, Short.MAX_VALUE)
                    .addComponent(cmbStBatchBatchid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel55Layout.setVerticalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel118)
                    .addComponent(cmbStBatchStudentid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel119)
                    .addComponent(cmbStBatchBatchid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel56.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Student Batches"));

        tblStBatch.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblStBatch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStBatchMouseClicked(evt);
            }
        });
        jScrollPane21.setViewportView(tblStBatch);

        txtSearchstbatch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchstbatchKeyReleased(evt);
            }
        });

        cmbStBatchsearchin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "studentid", "batchid", "userid" }));

        jLabel121.setText("Search In:");

        javax.swing.GroupLayout jPanel56Layout = new javax.swing.GroupLayout(jPanel56);
        jPanel56.setLayout(jPanel56Layout);
        jPanel56Layout.setHorizontalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane21, javax.swing.GroupLayout.DEFAULT_SIZE, 952, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel56Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel121)
                .addGap(18, 18, 18)
                .addComponent(cmbStBatchsearchin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSearchstbatch, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel56Layout.setVerticalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel56Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchstbatch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbStBatchsearchin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel121))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnDeleteStBatch.setText("Delete");
        btnDeleteStBatch.setEnabled(false);
        btnDeleteStBatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteStBatchActionPerformed(evt);
            }
        });

        btnInsertStBatch.setText("Insert");
        btnInsertStBatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertStBatchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel54Layout = new javax.swing.GroupLayout(jPanel54);
        jPanel54.setLayout(jPanel54Layout);
        jPanel54Layout.setHorizontalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel54Layout.createSequentialGroup()
                        .addComponent(btnDeleteStBatch)
                        .addGap(18, 18, 18)
                        .addComponent(btnInsertStBatch)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel54Layout.setVerticalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel56, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel54Layout.createSequentialGroup()
                        .addComponent(jPanel55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnInsertStBatch)
                            .addComponent(btnDeleteStBatch))))
                .addGap(0, 335, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Student Batches", jPanel54);

        javax.swing.GroupLayout StudentsPanelLayout = new javax.swing.GroupLayout(StudentsPanel);
        StudentsPanel.setLayout(StudentsPanelLayout);
        StudentsPanelLayout.setHorizontalGroup(
            StudentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane5)
        );
        StudentsPanelLayout.setVerticalGroup(
            StudentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane5)
        );

        TabbedPane.addTab("Students", new javax.swing.ImageIcon(getClass().getResource("/res/studenticon.jpg")), StudentsPanel, "Manage Students Information"); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Departments"));

        tblDepartments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDepartments.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDepartmentsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDepartments);

        txtSearchdepartment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchdepartmentKeyReleased(evt);
            }
        });

        cmbDepartmentsearchin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "departmentid", "department_name", "description", "userid" }));

        jLabel4.setText("Search In:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(cmbDepartmentsearchin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSearchdepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchdepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDepartmentsearchin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Department Record"));
        jPanel15.setPreferredSize(new java.awt.Dimension(445, 116));

        jLabel1.setText("Department ID:");

        jLabel2.setText("Department Name: ");

        jLabel3.setText("Description:");

        txtDepartmentid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDepartmentidKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDepartmentdescription, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                    .addComponent(txtDepartmentid)
                    .addComponent(txtDepartmentname, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDepartmentid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtDepartmentname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtDepartmentdescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnInsertDepartment.setText("Insert");
        btnInsertDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertDepartmentActionPerformed(evt);
            }
        });

        btnUpdateDepartment.setText("Update");
        btnUpdateDepartment.setEnabled(false);
        btnUpdateDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateDepartmentActionPerformed(evt);
            }
        });

        btnDeleteDepartment.setText("Delete");
        btnDeleteDepartment.setEnabled(false);
        btnDeleteDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteDepartmentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DepartmentsPanelLayout = new javax.swing.GroupLayout(DepartmentsPanel);
        DepartmentsPanel.setLayout(DepartmentsPanelLayout);
        DepartmentsPanelLayout.setHorizontalGroup(
            DepartmentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(DepartmentsPanelLayout.createSequentialGroup()
                .addGroup(DepartmentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(DepartmentsPanelLayout.createSequentialGroup()
                        .addComponent(btnUpdateDepartment)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteDepartment)
                        .addGap(18, 18, 18)
                        .addComponent(btnInsertDepartment))
                    .addComponent(jPanel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 975, Short.MAX_VALUE))
        );
        DepartmentsPanelLayout.setVerticalGroup(
            DepartmentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DepartmentsPanelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(DepartmentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertDepartment)
                    .addComponent(btnDeleteDepartment)
                    .addComponent(btnUpdateDepartment))
                .addGap(0, 210, Short.MAX_VALUE))
        );

        TabbedPane.addTab("Departments", new javax.swing.ImageIcon(getClass().getResource("/res/departments.png")), DepartmentsPanel, "Manage Departments Information"); // NOI18N

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Practicals"));

        tblPracticals.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPracticals.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPracticalsMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblPracticals);

        txtSearchpractical.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchpracticalKeyReleased(evt);
            }
        });

        cmbPracticalsearchin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "practicalid", "starttime", "endtime", "studentid", "classroomid", "userid" }));

        jLabel30.setText("Search In:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1408, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel30)
                .addGap(18, 18, 18)
                .addComponent(cmbPracticalsearchin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSearchpractical, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchpractical, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbPracticalsearchin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Practical Record"));
        jPanel19.setPreferredSize(new java.awt.Dimension(445, 186));

        jLabel38.setText("Practical ID:");

        jLabel39.setText("Start Time: ");

        jLabel40.setText("End Time:");

        txtPracticalid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPracticalidKeyPressed(evt);
            }
        });

        jLabel59.setText("Student ID:");

        jLabel60.setText("Classroom ID:");

        cmbPracticalstarttime.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00" }));

        dtePracticalstartdate.setDateFormatString("yyyy-MM-dd");

        cmbPracticalendtime.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00" }));

        dtePracticalenddate.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                        .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbPracticalclassroomid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dtePracticalenddate, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                            .addComponent(dtePracticalstartdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbPracticalstarttime, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbPracticalendtime, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(txtPracticalid)
                    .addComponent(cmbPracticalstudentid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(txtPracticalid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbPracticalstarttime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtePracticalstartdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel40)
                    .addComponent(dtePracticalenddate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbPracticalendtime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel59))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbPracticalstudentid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel60)
                    .addComponent(cmbPracticalclassroomid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnUpdatepractical.setText("Update");
        btnUpdatepractical.setEnabled(false);
        btnUpdatepractical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdatepracticalActionPerformed(evt);
            }
        });

        btnDeletepractical.setText("Delete");
        btnDeletepractical.setEnabled(false);
        btnDeletepractical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletepracticalActionPerformed(evt);
            }
        });

        btnInsertpractical.setText("Insert");
        btnInsertpractical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertpracticalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PracticalsPanelLayout = new javax.swing.GroupLayout(PracticalsPanel);
        PracticalsPanel.setLayout(PracticalsPanelLayout);
        PracticalsPanelLayout.setHorizontalGroup(
            PracticalsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PracticalsPanelLayout.createSequentialGroup()
                .addGroup(PracticalsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PracticalsPanelLayout.createSequentialGroup()
                        .addComponent(btnUpdatepractical)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeletepractical)
                        .addGap(18, 18, 18)
                        .addComponent(btnInsertpractical))
                    .addComponent(jPanel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PracticalsPanelLayout.setVerticalGroup(
            PracticalsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PracticalsPanelLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PracticalsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertpractical)
                    .addComponent(btnDeletepractical)
                    .addComponent(btnUpdatepractical))
                .addGap(0, 155, Short.MAX_VALUE))
        );

        TabbedPane.addTab("Practicals", new javax.swing.ImageIcon(getClass().getResource("/res/practicals.jpg")), PracticalsPanel, "Manage Practicals Information"); // NOI18N

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Payments"));

        tblPayments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPayments.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPaymentsMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblPayments);

        txtSearchpayment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchpaymentKeyReleased(evt);
            }
        });

        cmbPaymentsearchin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "paymentid", "amount", "time", "studentid", "userid" }));

        jLabel31.setText("Search In:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1408, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel31)
                .addGap(18, 18, 18)
                .addComponent(cmbPaymentsearchin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSearchpayment, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchpayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbPaymentsearchin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Payment Record"));
        jPanel20.setPreferredSize(new java.awt.Dimension(445, 142));

        jLabel41.setText("Payment ID:");

        jLabel42.setText("Amount: ");

        jLabel43.setText("Time:");

        txtPaymentid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPaymentidKeyPressed(evt);
            }
        });

        jLabel61.setText("Student ID:");

        cmbPaymenttime.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00" }));

        dtePaymentdate.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                        .addComponent(dtePaymentdate, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbPaymenttime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtPaymentamount, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPaymentid, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmbPaymentstudentid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(txtPaymentid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel42)
                    .addComponent(txtPaymentamount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbPaymenttime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43)
                    .addComponent(dtePaymentdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel61)
                    .addComponent(cmbPaymentstudentid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnUpdatepayment.setText("Update");
        btnUpdatepayment.setEnabled(false);
        btnUpdatepayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdatepaymentActionPerformed(evt);
            }
        });

        btnDeletepayment.setText("Delete");
        btnDeletepayment.setEnabled(false);
        btnDeletepayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletepaymentActionPerformed(evt);
            }
        });

        btnInsertpayment.setText("Insert");
        btnInsertpayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertpaymentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PaymentsPanelLayout = new javax.swing.GroupLayout(PaymentsPanel);
        PaymentsPanel.setLayout(PaymentsPanelLayout);
        PaymentsPanelLayout.setHorizontalGroup(
            PaymentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PaymentsPanelLayout.createSequentialGroup()
                .addGroup(PaymentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PaymentsPanelLayout.createSequentialGroup()
                        .addComponent(btnUpdatepayment)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeletepayment)
                        .addGap(18, 18, 18)
                        .addComponent(btnInsertpayment))
                    .addComponent(jPanel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(975, Short.MAX_VALUE))
        );
        PaymentsPanelLayout.setVerticalGroup(
            PaymentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PaymentsPanelLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PaymentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertpayment)
                    .addComponent(btnDeletepayment)
                    .addComponent(btnUpdatepayment))
                .addGap(0, 184, Short.MAX_VALUE))
        );

        TabbedPane.addTab("Payments", new javax.swing.ImageIcon(getClass().getResource("/res/payments.jpg")), PaymentsPanel, "Manage Payments Information"); // NOI18N

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Modules"));

        tblModules.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblModules.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblModulesMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblModules);

        txtSearchmodule.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchmoduleKeyReleased(evt);
            }
        });

        cmbModulesearchin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "moduleid", "module_name", "description", "lecturerid", "userid" }));

        jLabel32.setText("Search In:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 1408, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel32)
                .addGap(18, 18, 18)
                .addComponent(cmbModulesearchin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSearchmodule, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchmodule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbModulesearchin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Module Record"));
        jPanel21.setPreferredSize(new java.awt.Dimension(445, 160));

        jLabel44.setText("Module ID:");

        jLabel45.setText("Module Name: ");

        jLabel46.setText("Description:");

        txtModuleid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtModuleidKeyPressed(evt);
            }
        });

        jLabel62.setText("Lecturer ID:");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbModulelecturerid, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtModuledescription, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                        .addComponent(txtModulename, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtModuleid, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(txtModuleid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel45)
                    .addComponent(txtModulename, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel46)
                    .addComponent(txtModuledescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62)
                    .addComponent(cmbModulelecturerid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnUpdatemodule.setText("Update");
        btnUpdatemodule.setEnabled(false);
        btnUpdatemodule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdatemoduleActionPerformed(evt);
            }
        });

        btnDeletemodule.setText("Delete");
        btnDeletemodule.setEnabled(false);
        btnDeletemodule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletemoduleActionPerformed(evt);
            }
        });

        btnInsertmodule.setText("Insert");
        btnInsertmodule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertmoduleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ModulesPanelLayout = new javax.swing.GroupLayout(ModulesPanel);
        ModulesPanel.setLayout(ModulesPanelLayout);
        ModulesPanelLayout.setHorizontalGroup(
            ModulesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(ModulesPanelLayout.createSequentialGroup()
                .addGroup(ModulesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ModulesPanelLayout.createSequentialGroup()
                        .addComponent(btnUpdatemodule)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeletemodule)
                        .addGap(18, 18, 18)
                        .addComponent(btnInsertmodule))
                    .addComponent(jPanel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        ModulesPanelLayout.setVerticalGroup(
            ModulesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ModulesPanelLayout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(ModulesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertmodule)
                    .addComponent(btnDeletemodule)
                    .addComponent(btnUpdatemodule))
                .addGap(0, 184, Short.MAX_VALUE))
        );

        TabbedPane.addTab("Modules", new javax.swing.ImageIcon(getClass().getResource("/res/modules.png")), ModulesPanel, "Manage Modules Information"); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Courses"));

        tblCourses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblCourses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCoursesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblCourses);

        txtSearchcourse.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchcourseKeyReleased(evt);
            }
        });

        cmbCoursesearchin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "courseid", "course_name", "duration", "fee", "level", "departmentid", "coordinatorid", "userid" }));

        jLabel15.setText("Search In:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1403, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(cmbCoursesearchin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSearchcourse, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchcourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCoursesearchin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Course Record"));
        jPanel17.setPreferredSize(new java.awt.Dimension(445, 261));

        jLabel16.setText("Course ID:");

        txtCourseid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCourseidKeyPressed(evt);
            }
        });

        jLabel17.setText("Course Name:");

        jLabel18.setText("Duration:");

        jLabel19.setText("Fee:");

        jLabel20.setText("Level:");

        jLabel21.setText("Department ID:");

        jLabel22.setText("Coordinator ID:");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cmbCoursedepartmentid, javax.swing.GroupLayout.Alignment.LEADING, 0, 305, Short.MAX_VALUE)
                    .addComponent(txtCourselevel, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCoursefee, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCourseduration, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbCoursecoordinatorid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCourseid)
                    .addComponent(txtCoursename))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtCourseid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(txtCoursename, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(txtCourseduration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCoursefee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(txtCourselevel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(cmbCoursedepartmentid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(cmbCoursecoordinatorid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnUpdatecourse.setText("Update");
        btnUpdatecourse.setEnabled(false);
        btnUpdatecourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdatecourseActionPerformed(evt);
            }
        });

        btnDeletecourse.setText("Delete");
        btnDeletecourse.setEnabled(false);
        btnDeletecourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletecourseActionPerformed(evt);
            }
        });

        btnInsertcourse.setText("Insert");
        btnInsertcourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertcourseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(btnUpdatecourse)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeletecourse)
                        .addGap(18, 18, 18)
                        .addComponent(btnInsertcourse))
                    .addComponent(jPanel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 970, Short.MAX_VALUE))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertcourse)
                    .addComponent(btnDeletecourse)
                    .addComponent(btnUpdatecourse))
                .addGap(0, 68, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Courses", jPanel36);

        jPanel38.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Course Module Record"));
        jPanel38.setPreferredSize(new java.awt.Dimension(445, 116));

        jLabel99.setText("Course ID:");

        jLabel100.setText("Module ID: ");

        cmbCourseModuleCourseid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbCourseModuleModuleid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel99, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel100, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbCourseModuleCourseid, 0, 289, Short.MAX_VALUE)
                    .addComponent(cmbCourseModuleModuleid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel99)
                    .addComponent(cmbCourseModuleCourseid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel100)
                    .addComponent(cmbCourseModuleModuleid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel39.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Course Modules"));

        tblCourseModules.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblCourseModules.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCourseModulesMouseClicked(evt);
            }
        });
        jScrollPane18.setViewportView(tblCourseModules);

        txtSearchcoursemodule.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchcoursemoduleKeyReleased(evt);
            }
        });

        cmbCourseModulesearchin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "courseid", "moduleid", "userid" }));

        jLabel88.setText("Search In:");

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 952, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel39Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel88)
                .addGap(18, 18, 18)
                .addComponent(cmbCourseModulesearchin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSearchcoursemodule, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel39Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchcoursemodule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCourseModulesearchin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel88))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnDeleteCourseModule.setText("Delete");
        btnDeleteCourseModule.setEnabled(false);
        btnDeleteCourseModule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCourseModuleActionPerformed(evt);
            }
        });

        btnInsertCourseModule.setText("Insert");
        btnInsertCourseModule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertCourseModuleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addComponent(btnDeleteCourseModule)
                        .addGap(18, 18, 18)
                        .addComponent(btnInsertCourseModule)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnInsertCourseModule)
                            .addComponent(btnDeleteCourseModule))))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Course Modules", jPanel37);

        jPanel58.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Course Batch Record"));
        jPanel58.setPreferredSize(new java.awt.Dimension(445, 116));

        jLabel120.setText("Course ID:");

        jLabel122.setText("Batch ID: ");

        cmbCourseBatchCourseid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbCourseBatchBatchid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel58Layout = new javax.swing.GroupLayout(jPanel58);
        jPanel58.setLayout(jPanel58Layout);
        jPanel58Layout.setHorizontalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel120, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel122, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbCourseBatchCourseid, 0, 289, Short.MAX_VALUE)
                    .addComponent(cmbCourseBatchBatchid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel58Layout.setVerticalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel120)
                    .addComponent(cmbCourseBatchCourseid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel122)
                    .addComponent(cmbCourseBatchBatchid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnDeleteCourseBatch.setText("Delete");
        btnDeleteCourseBatch.setEnabled(false);
        btnDeleteCourseBatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCourseBatchActionPerformed(evt);
            }
        });

        btnInsertCourseBatch.setText("Insert");
        btnInsertCourseBatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertCourseBatchActionPerformed(evt);
            }
        });

        jPanel59.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Course Batches"));

        tblCourseBatches.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblCourseBatches.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCourseBatchesMouseClicked(evt);
            }
        });
        jScrollPane22.setViewportView(tblCourseBatches);

        txtSearchcoursebatch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchcoursebatchKeyReleased(evt);
            }
        });

        cmbCourseBatchsearchin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "courseid", "moduleid", "userid" }));

        jLabel123.setText("Search In:");

        javax.swing.GroupLayout jPanel59Layout = new javax.swing.GroupLayout(jPanel59);
        jPanel59.setLayout(jPanel59Layout);
        jPanel59Layout.setHorizontalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane22, javax.swing.GroupLayout.DEFAULT_SIZE, 952, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel59Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel123)
                .addGap(18, 18, 18)
                .addComponent(cmbCourseBatchsearchin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSearchcoursebatch, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel59Layout.setVerticalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel59Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchcoursebatch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCourseBatchsearchin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel123))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel57Layout = new javax.swing.GroupLayout(jPanel57);
        jPanel57.setLayout(jPanel57Layout);
        jPanel57Layout.setHorizontalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel57Layout.createSequentialGroup()
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel58, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel57Layout.createSequentialGroup()
                        .addComponent(btnDeleteCourseBatch)
                        .addGap(18, 18, 18)
                        .addComponent(btnInsertCourseBatch)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel57Layout.setVerticalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel59, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel57Layout.createSequentialGroup()
                        .addComponent(jPanel58, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnInsertCourseBatch)
                            .addComponent(btnDeleteCourseBatch))))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Course Batches", jPanel57);

        javax.swing.GroupLayout CoursesPanelLayout = new javax.swing.GroupLayout(CoursesPanel);
        CoursesPanel.setLayout(CoursesPanelLayout);
        CoursesPanelLayout.setHorizontalGroup(
            CoursesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3)
        );
        CoursesPanelLayout.setVerticalGroup(
            CoursesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3)
        );

        TabbedPane.addTab("Courses", new javax.swing.ImageIcon(getClass().getResource("/res/courses.png")), CoursesPanel, "Manage Courses Information"); // NOI18N

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Exams"));

        tblExams.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblExams.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblExamsMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tblExams);

        txtSearchexam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchexamKeyReleased(evt);
            }
        });

        cmbExamsearchin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "examid", "starttime", "endtime", "moduleid", "userid" }));

        jLabel33.setText("Search In:");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 1403, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel33)
                .addGap(18, 18, 18)
                .addComponent(cmbExamsearchin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSearchexam, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchexam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbExamsearchin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Exam Record"));
        jPanel22.setPreferredSize(new java.awt.Dimension(445, 160));

        jLabel47.setText("Exam ID:");

        jLabel48.setText("Start Time: ");

        jLabel49.setText("End Time:");

        txtExamid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtExamidKeyPressed(evt);
            }
        });

        jLabel63.setText("Module ID:");

        cmbExamstarttime.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00" }));

        dteExamstartdate.setDateFormatString("yyyy-MM-dd");

        cmbExamendtime.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00" }));

        dteExamenddate.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel63)
                            .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dteExamenddate, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                            .addComponent(dteExamstartdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbExamstarttime, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbExamendtime, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(txtExamid)
                    .addComponent(cmbExammoduleid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(txtExamid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel48)
                        .addComponent(dteExamstartdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmbExamstarttime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(dteExamenddate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel49))
                    .addComponent(cmbExamendtime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbExammoduleid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel63))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnUpdateexam.setText("Update");
        btnUpdateexam.setEnabled(false);
        btnUpdateexam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateexamActionPerformed(evt);
            }
        });

        btnDeleteexam.setText("Delete");
        btnDeleteexam.setEnabled(false);
        btnDeleteexam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteexamActionPerformed(evt);
            }
        });

        btnInsertexam.setText("Insert");
        btnInsertexam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertexamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(btnUpdateexam)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteexam)
                        .addGap(18, 18, 18)
                        .addComponent(btnInsertexam))
                    .addComponent(jPanel22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(970, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertexam)
                    .addComponent(btnDeleteexam)
                    .addComponent(btnUpdateexam))
                .addGap(0, 146, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Exams", jPanel31);

        jPanel34.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Student Exam Record"));
        jPanel34.setPreferredSize(new java.awt.Dimension(445, 116));

        jLabel96.setText("Student ID:");

        jLabel97.setText("Exam ID: ");

        jLabel98.setText("Marks:");

        cmbStExamStudentid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbStExamExamid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel96, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel97, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addComponent(jLabel98, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtStExamMarks, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                    .addComponent(cmbStExamStudentid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbStExamExamid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel96)
                    .addComponent(cmbStExamStudentid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel97)
                    .addComponent(cmbStExamExamid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel98)
                    .addComponent(txtStExamMarks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnUpdateStExam.setText("Update");
        btnUpdateStExam.setEnabled(false);
        btnUpdateStExam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateStExamActionPerformed(evt);
            }
        });

        btnDeleteStExam.setText("Delete");
        btnDeleteStExam.setEnabled(false);
        btnDeleteStExam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteStExamActionPerformed(evt);
            }
        });

        btnInsertStExam.setText("Insert");
        btnInsertStExam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertStExamActionPerformed(evt);
            }
        });

        jPanel35.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Student Exams"));

        tblStExam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblStExam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStExamMouseClicked(evt);
            }
        });
        jScrollPane17.setViewportView(tblStExam);

        txtSearchstexam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchstexamKeyReleased(evt);
            }
        });

        cmbStExamsearchin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "studentid", "examid", "marks", "userid" }));

        jLabel87.setText("Search In:");

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 952, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel35Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel87)
                .addGap(18, 18, 18)
                .addComponent(cmbStExamsearchin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSearchstexam, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel35Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchstexam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbStExamsearchin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel87))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addComponent(btnUpdateStExam)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteStExam)
                        .addGap(18, 18, 18)
                        .addComponent(btnInsertStExam)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnInsertStExam)
                            .addComponent(btnDeleteStExam)
                            .addComponent(btnUpdateStExam))))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Student Exams", jPanel32);

        javax.swing.GroupLayout ExamsPanelLayout = new javax.swing.GroupLayout(ExamsPanel);
        ExamsPanel.setLayout(ExamsPanelLayout);
        ExamsPanelLayout.setHorizontalGroup(
            ExamsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        ExamsPanelLayout.setVerticalGroup(
            ExamsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        TabbedPane.addTab("Exams", new javax.swing.ImageIcon(getClass().getResource("/res/exams.png")), ExamsPanel, "Manage Exams Information"); // NOI18N

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Assignments"));

        tblAssignments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblAssignments.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAssignmentsMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tblAssignments);

        txtSearchassignment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchassignmentKeyReleased(evt);
            }
        });

        cmbAssignmentsearchin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "assignmentid", "assignment_name", "description", "moduleid", "userid" }));

        jLabel34.setText("Search In:");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 1403, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel34)
                .addGap(18, 18, 18)
                .addComponent(cmbAssignmentsearchin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSearchassignment, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchassignment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbAssignmentsearchin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Assignment Record"));
        jPanel23.setPreferredSize(new java.awt.Dimension(445, 188));
        jPanel23.setRequestFocusEnabled(false);

        jLabel50.setText("Assignment ID:");

        jLabel51.setText("Assignment Name: ");

        jLabel52.setText("Description:");

        txtAssignmentid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAssignmentidKeyPressed(evt);
            }
        });

        jLabel75.setText("Due Date:");

        dteAssignmentduedate.setDateFormatString("yyyy-MM-dd");

        jLabel64.setText("Module ID:");

        cmbAssignmentduetime.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00" }));

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                            .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jLabel64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)))
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(dteAssignmentduedate, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbAssignmentduetime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cmbAssignmentmoduleid, javax.swing.GroupLayout.Alignment.TRAILING, 0, 297, Short.MAX_VALUE)
                        .addComponent(txtAssignmentdescription, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtAssignmentname, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtAssignmentid, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(txtAssignmentid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel51)
                    .addComponent(txtAssignmentname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel52)
                    .addComponent(txtAssignmentdescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbAssignmentmoduleid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel64))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addComponent(jLabel75)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbAssignmentduetime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dteAssignmentduedate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        btnUpdateassignment.setText("Update");
        btnUpdateassignment.setEnabled(false);
        btnUpdateassignment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateassignmentActionPerformed(evt);
            }
        });

        btnDeleteassignment.setText("Delete");
        btnDeleteassignment.setEnabled(false);
        btnDeleteassignment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteassignmentActionPerformed(evt);
            }
        });

        btnInsertassignment.setText("Insert");
        btnInsertassignment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertassignmentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnUpdateassignment)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteassignment)
                        .addGap(18, 18, 18)
                        .addComponent(btnInsertassignment))
                    .addComponent(jPanel23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertassignment)
                    .addComponent(btnDeleteassignment)
                    .addComponent(btnUpdateassignment))
                .addGap(0, 120, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Assignments", jPanel2);

        jPanel30.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Student Assignments"));

        tblStAss.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblStAss.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStAssMouseClicked(evt);
            }
        });
        jScrollPane16.setViewportView(tblStAss);

        txtSearchstass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchstassKeyReleased(evt);
            }
        });

        cmbStAsssearchin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "studentid", "assignmentid", "marks", "userid" }));

        jLabel86.setText("Search In:");

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 952, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel86)
                .addGap(18, 18, 18)
                .addComponent(cmbStAsssearchin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSearchstass, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchstass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbStAsssearchin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel86))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel33.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Student Assignment Record"));
        jPanel33.setPreferredSize(new java.awt.Dimension(445, 116));

        jLabel93.setText("Student ID:");

        jLabel94.setText("Assignment ID: ");

        jLabel95.setText("Marks:");

        cmbStAssStudentid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbStAssAssignmentid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel93, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel94, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addComponent(jLabel95, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtStAssMarks, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                    .addComponent(cmbStAssStudentid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbStAssAssignmentid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel93)
                    .addComponent(cmbStAssStudentid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel94)
                    .addComponent(cmbStAssAssignmentid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel95)
                    .addComponent(txtStAssMarks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnUpdateStAss.setText("Update");
        btnUpdateStAss.setEnabled(false);
        btnUpdateStAss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateStAssActionPerformed(evt);
            }
        });

        btnDeleteStAss.setText("Delete");
        btnDeleteStAss.setEnabled(false);
        btnDeleteStAss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteStAssActionPerformed(evt);
            }
        });

        btnInsertStAss.setText("Insert");
        btnInsertStAss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertStAssActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addComponent(btnUpdateStAss)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteStAss)
                        .addGap(18, 18, 18)
                        .addComponent(btnInsertStAss)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnInsertStAss)
                            .addComponent(btnDeleteStAss)
                            .addComponent(btnUpdateStAss))))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Student Assignments", jPanel29);

        javax.swing.GroupLayout AssignmentsPanelLayout = new javax.swing.GroupLayout(AssignmentsPanel);
        AssignmentsPanel.setLayout(AssignmentsPanelLayout);
        AssignmentsPanelLayout.setHorizontalGroup(
            AssignmentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        AssignmentsPanelLayout.setVerticalGroup(
            AssignmentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        TabbedPane.addTab("Assignments", new javax.swing.ImageIcon(getClass().getResource("/res/assignments.jpg")), AssignmentsPanel, "Manage Assignments Information"); // NOI18N

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Lectures"));

        tblLectures.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblLectures.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLecturesMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tblLectures);

        txtSearchlecture.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchlectureKeyReleased(evt);
            }
        });

        cmbLecturessearchin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "lectureid", "starttime", "endtime", "description", "classroomid", "moduleid", "userid" }));

        jLabel35.setText("Search In:");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 1403, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel35)
                .addGap(18, 18, 18)
                .addComponent(cmbLecturessearchin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSearchlecture, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchlecture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbLecturessearchin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel24.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Lecture Record"));
        jPanel24.setPreferredSize(new java.awt.Dimension(445, 234));

        jLabel53.setText("Lecture ID:");

        jLabel54.setText("Start Time: ");

        jLabel55.setText("End Time:");

        txtLectureid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLectureidKeyPressed(evt);
            }
        });

        jLabel65.setText("Description:");

        jLabel66.setText("Classroom ID: ");

        jLabel67.setText("Module ID:");

        cmbLecturestarttime.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00" }));

        dteLecturestartdate.setDateFormatString("yyyy-MM-dd");

        cmbLectureendtime.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00" }));

        dteLectureenddate.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(55, 55, Short.MAX_VALUE)
                .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmbLecturemoduleid, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel53, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel55, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(dteLectureenddate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dteLecturestartdate, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbLecturestarttime, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbLectureendtime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtLectureid, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel66, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtLecturedescription)
                            .addComponent(txtLectureclassroomid, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(txtLectureid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dteLecturestartdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54)
                    .addComponent(cmbLecturestarttime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel55)
                    .addComponent(dteLectureenddate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbLectureendtime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel65)
                    .addComponent(txtLecturedescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLectureclassroomid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel66))
                .addGap(83, 83, 83)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel67)
                    .addComponent(cmbLecturemoduleid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnUpdatelecture.setText("Update");
        btnUpdatelecture.setEnabled(false);
        btnUpdatelecture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdatelectureActionPerformed(evt);
            }
        });

        btnDeletelecture.setText("Delete");
        btnDeletelecture.setEnabled(false);
        btnDeletelecture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletelectureActionPerformed(evt);
            }
        });

        btnInsertlecture.setText("Insert");
        btnInsertlecture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertlectureActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addComponent(btnUpdatelecture)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeletelecture)
                        .addGap(18, 18, 18)
                        .addComponent(btnInsertlecture))
                    .addComponent(jPanel24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(970, Short.MAX_VALUE))
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertlecture)
                    .addComponent(btnDeletelecture)
                    .addComponent(btnUpdatelecture))
                .addGap(0, 120, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Lectures", jPanel40);

        jPanel42.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Student Attendance Record"));
        jPanel42.setPreferredSize(new java.awt.Dimension(445, 116));

        jLabel101.setText("Student ID:");

        jLabel102.setText("Lecture ID: ");

        jLabel103.setText("Time:");

        cmbStAttendanceStudentid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbStAttendanceLectureid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbStAttendancetime.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00" }));

        dteStAttendancedate.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel101, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel102, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addComponent(jLabel103, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbStAttendanceStudentid, 0, 289, Short.MAX_VALUE)
                            .addComponent(cmbStAttendanceLectureid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addComponent(dteStAttendancedate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbStAttendancetime, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel101)
                    .addComponent(cmbStAttendanceStudentid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel102)
                    .addComponent(cmbStAttendanceLectureid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel103)
                        .addComponent(cmbStAttendancetime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dteStAttendancedate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnUpdateStAttendance.setText("Update");
        btnUpdateStAttendance.setEnabled(false);
        btnUpdateStAttendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateStAttendanceActionPerformed(evt);
            }
        });

        btnDeleteStAttendance.setText("Delete");
        btnDeleteStAttendance.setEnabled(false);
        btnDeleteStAttendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteStAttendanceActionPerformed(evt);
            }
        });

        btnInsertStAttendance.setText("Insert");
        btnInsertStAttendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertStAttendanceActionPerformed(evt);
            }
        });

        jPanel43.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Student Attendance"));

        tblStAttendance.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblStAttendance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStAttendanceMouseClicked(evt);
            }
        });
        jScrollPane19.setViewportView(tblStAttendance);

        txtSearchstattendance.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchstattendanceKeyReleased(evt);
            }
        });

        cmbStAttendancesearchin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "studentid", "lectureid", "time", "userid" }));

        jLabel89.setText("Search In:");

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 951, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel43Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel89)
                .addGap(18, 18, 18)
                .addComponent(cmbStAttendancesearchin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSearchstattendance, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel43Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchstattendance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbStAttendancesearchin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel89))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel41Layout.createSequentialGroup()
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addComponent(btnUpdateStAttendance)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteStAttendance)
                        .addGap(18, 18, 18)
                        .addComponent(btnInsertStAttendance)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnInsertStAttendance)
                            .addComponent(btnDeleteStAttendance)
                            .addComponent(btnUpdateStAttendance))))
                .addGap(0, 335, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Student Attendance", jPanel41);

        javax.swing.GroupLayout LecturesPanelLayout = new javax.swing.GroupLayout(LecturesPanel);
        LecturesPanel.setLayout(LecturesPanelLayout);
        LecturesPanelLayout.setHorizontalGroup(
            LecturesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane4)
        );
        LecturesPanelLayout.setVerticalGroup(
            LecturesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane4)
        );

        TabbedPane.addTab("Lectures", new javax.swing.ImageIcon(getClass().getResource("/res/lectures.png")), LecturesPanel, "Manage Lectures Information"); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Lecturers"));

        tblLecturers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblLecturers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLecturersMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblLecturers);

        txtSearchlecturer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchlecturerKeyReleased(evt);
            }
        });

        cmbLecturersearchin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "lecturerid", "lecturer_name", "address", "email", "phone", "description", "userid" }));

        jLabel23.setText("Search In:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1408, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel23)
                .addGap(18, 18, 18)
                .addComponent(cmbLecturersearchin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSearchlecturer, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchlecturer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbLecturersearchin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Lecturer Record"));
        jPanel18.setPreferredSize(new java.awt.Dimension(445, 229));

        jLabel24.setText("Lecturer ID:");

        txtLecturerid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLectureridKeyPressed(evt);
            }
        });

        jLabel25.setText("Name:");

        jLabel26.setText("Address:");

        jLabel27.setText("Email:");

        jLabel28.setText("Phone:");

        jLabel29.setText("Description:");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtLecturerphone, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtLectureremail, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtLectureraddress, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtLecturername, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtLecturerdescription)
                    .addComponent(txtLecturerid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtLecturerid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(txtLecturername, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(txtLectureraddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLectureremail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addComponent(txtLecturerphone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addComponent(txtLecturerdescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnUpdatelecturer.setText("Update");
        btnUpdatelecturer.setEnabled(false);
        btnUpdatelecturer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdatelecturerActionPerformed(evt);
            }
        });

        btnDeletelecturer.setText("Delete");
        btnDeletelecturer.setEnabled(false);
        btnDeletelecturer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletelecturerActionPerformed(evt);
            }
        });

        btnInsertlecturer.setText("Insert");
        btnInsertlecturer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertlecturerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LecturersPanelLayout = new javax.swing.GroupLayout(LecturersPanel);
        LecturersPanel.setLayout(LecturersPanelLayout);
        LecturersPanelLayout.setHorizontalGroup(
            LecturersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(LecturersPanelLayout.createSequentialGroup()
                .addGroup(LecturersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(LecturersPanelLayout.createSequentialGroup()
                        .addComponent(btnUpdatelecturer)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeletelecturer)
                        .addGap(18, 18, 18)
                        .addComponent(btnInsertlecturer))
                    .addComponent(jPanel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 975, Short.MAX_VALUE))
        );
        LecturersPanelLayout.setVerticalGroup(
            LecturersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LecturersPanelLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(LecturersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertlecturer)
                    .addComponent(btnDeletelecturer)
                    .addComponent(btnUpdatelecturer))
                .addGap(0, 132, Short.MAX_VALUE))
        );

        TabbedPane.addTab("Lecturers", new javax.swing.ImageIcon(getClass().getResource("/res/lecuturer.jpg")), LecturersPanel, "Manage Lecturers Information"); // NOI18N

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Classrooms"));

        tblClassrooms.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblClassrooms.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClassroomsMouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(tblClassrooms);

        txtSearchclassroom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchclassroomKeyReleased(evt);
            }
        });

        cmbClassroomsearchin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "classroomid", "room_name", "description", "userid" }));

        jLabel70.setText("Search In:");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 1408, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel70)
                .addGap(18, 18, 18)
                .addComponent(cmbClassroomsearchin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSearchclassroom, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchclassroom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbClassroomsearchin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel70))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel26.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Classroom Record"));
        jPanel26.setPreferredSize(new java.awt.Dimension(445, 126));

        jLabel71.setText("Classroom ID:");

        jLabel72.setText("Classroom Name: ");

        jLabel73.setText("Description:");

        txtClassroomid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtClassroomidKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel71, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel72, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                    .addComponent(jLabel73, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtClassroomid, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                    .addComponent(txtClassroomname)
                    .addComponent(txtClassroomdescription))
                .addContainerGap())
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel71)
                    .addComponent(txtClassroomid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel72)
                    .addComponent(txtClassroomname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel73)
                    .addComponent(txtClassroomdescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnInsertClassroom.setText("Insert");
        btnInsertClassroom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertClassroomActionPerformed(evt);
            }
        });

        btnDeleteClassroom.setText("Delete");
        btnDeleteClassroom.setEnabled(false);
        btnDeleteClassroom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteClassroomActionPerformed(evt);
            }
        });

        btnUpdateClassroom.setText("Update");
        btnUpdateClassroom.setEnabled(false);
        btnUpdateClassroom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateClassroomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ClassroomsPanelLayout = new javax.swing.GroupLayout(ClassroomsPanel);
        ClassroomsPanel.setLayout(ClassroomsPanelLayout);
        ClassroomsPanelLayout.setHorizontalGroup(
            ClassroomsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(ClassroomsPanelLayout.createSequentialGroup()
                .addGroup(ClassroomsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ClassroomsPanelLayout.createSequentialGroup()
                        .addComponent(btnUpdateClassroom)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteClassroom)
                        .addGap(18, 18, 18)
                        .addComponent(btnInsertClassroom))
                    .addComponent(jPanel26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        ClassroomsPanelLayout.setVerticalGroup(
            ClassroomsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ClassroomsPanelLayout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(ClassroomsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertClassroom)
                    .addComponent(btnDeleteClassroom)
                    .addComponent(btnUpdateClassroom))
                .addGap(0, 210, Short.MAX_VALUE))
        );

        TabbedPane.addTab("Classrooms", new javax.swing.ImageIcon(getClass().getResource("/res/classrooms.png")), ClassroomsPanel, "Manage Classrooms Information"); // NOI18N

        jPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Batches"));

        tblBatches.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblBatches.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBatchesMouseClicked(evt);
            }
        });
        jScrollPane14.setViewportView(tblBatches);

        txtSearchbatch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchbatchKeyReleased(evt);
            }
        });

        cmbBatchsearchin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "batchid", "batch_name", "startdate", "userid" }));

        jLabel77.setText("Search In:");

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 1408, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel77)
                .addGap(18, 18, 18)
                .addComponent(cmbBatchsearchin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSearchbatch, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchbatch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbBatchsearchin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel77))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel28.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Batch Record"));
        jPanel28.setPreferredSize(new java.awt.Dimension(445, 126));

        jLabel78.setText("Batch ID:");

        jLabel79.setText("Batch Name: ");

        txtBatchid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBatchidKeyPressed(evt);
            }
        });

        dteBatchstartdate.setDateFormatString("yyyy-MM-dd");

        jLabel80.setText("Start Date:");

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel78, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel79, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                    .addComponent(jLabel80, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(37, 37, 37)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dteBatchstartdate, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtBatchname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                        .addComponent(txtBatchid, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel78)
                    .addComponent(txtBatchid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel79)
                    .addComponent(txtBatchname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dteBatchstartdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel80))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnUpdateBatch.setText("Update");
        btnUpdateBatch.setEnabled(false);
        btnUpdateBatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateBatchActionPerformed(evt);
            }
        });

        btnDeleteBatch.setText("Delete");
        btnDeleteBatch.setEnabled(false);
        btnDeleteBatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteBatchActionPerformed(evt);
            }
        });

        btnInsertBatch.setText("Insert");
        btnInsertBatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertBatchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BatchesPanelLayout = new javax.swing.GroupLayout(BatchesPanel);
        BatchesPanel.setLayout(BatchesPanelLayout);
        BatchesPanelLayout.setHorizontalGroup(
            BatchesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(BatchesPanelLayout.createSequentialGroup()
                .addGroup(BatchesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(BatchesPanelLayout.createSequentialGroup()
                        .addComponent(btnUpdateBatch)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteBatch)
                        .addGap(18, 18, 18)
                        .addComponent(btnInsertBatch))
                    .addComponent(jPanel28, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        BatchesPanelLayout.setVerticalGroup(
            BatchesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BatchesPanelLayout.createSequentialGroup()
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(BatchesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertBatch)
                    .addComponent(btnDeleteBatch)
                    .addComponent(btnUpdateBatch))
                .addGap(0, 210, Short.MAX_VALUE))
        );

        TabbedPane.addTab("Batches", new javax.swing.ImageIcon(getClass().getResource("/res/batches.png")), BatchesPanel, "Manage Batches Information"); // NOI18N

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Users"));

        tblUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsersMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tblUsers);

        txtSearchuser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchuserKeyReleased(evt);
            }
        });

        cmbUsersearchin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "userid", "user_name", "email", "password", "type", "status" }));

        jLabel36.setText("Search In:");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 1408, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel36)
                .addGap(18, 18, 18)
                .addComponent(cmbUsersearchin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSearchuser, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbUsersearchin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel25.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "User Record"));
        jPanel25.setPreferredSize(new java.awt.Dimension(445, 225));

        jLabel56.setText("User ID:");

        jLabel57.setText("User Name: ");

        jLabel58.setText("Email:");

        txtUserid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUseridKeyPressed(evt);
            }
        });

        jLabel68.setText("Type:");

        jLabel69.setText("Status:");

        jLabel74.setText("Password:");

        cmbUsertype.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "admin", "coordinator", "receptionist" }));

        cmbUserstatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "active", "deactive" }));

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                                .addComponent(jLabel58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel68, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel69, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
                        .addGap(42, 42, 42)))
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbUserstatus, 0, 300, Short.MAX_VALUE)
                    .addComponent(cmbUsertype, 0, 300, Short.MAX_VALUE)
                    .addComponent(txtUserpassword)
                    .addComponent(txtUsername, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtUserid, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtUseremail))
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(txtUserid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel57)
                    .addComponent(txtUsername, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel58)
                    .addComponent(txtUseremail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUserpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel74))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel68)
                    .addComponent(cmbUsertype, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel69)
                    .addComponent(cmbUserstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnUpdateuser.setText("Update");
        btnUpdateuser.setEnabled(false);
        btnUpdateuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateuserActionPerformed(evt);
            }
        });

        btnDeleteuser.setText("Delete");
        btnDeleteuser.setEnabled(false);
        btnDeleteuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteuserActionPerformed(evt);
            }
        });

        btnInsertuser.setText("Insert");
        btnInsertuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertuserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout UsersPanelLayout = new javax.swing.GroupLayout(UsersPanel);
        UsersPanel.setLayout(UsersPanelLayout);
        UsersPanelLayout.setHorizontalGroup(
            UsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(UsersPanelLayout.createSequentialGroup()
                .addGroup(UsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(UsersPanelLayout.createSequentialGroup()
                        .addComponent(btnUpdateuser)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteuser)
                        .addGap(18, 18, 18)
                        .addComponent(btnInsertuser))
                    .addComponent(jPanel25, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 975, Short.MAX_VALUE))
        );
        UsersPanelLayout.setVerticalGroup(
            UsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UsersPanelLayout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(UsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertuser)
                    .addComponent(btnDeleteuser)
                    .addComponent(btnUpdateuser))
                .addGap(0, 132, Short.MAX_VALUE))
        );

        TabbedPane.addTab("Users", new javax.swing.ImageIcon(getClass().getResource("/res/users.png")), UsersPanel, "Manage Users Information"); // NOI18N

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Logs"));

        tblLogs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane12.setViewportView(tblLogs);

        txtSearchlog.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchlogKeyReleased(evt);
            }
        });

        cmbLogsearchin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "logid", "entity", "action", "userid" }));

        jLabel37.setText("Search In:");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 1408, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel37)
                .addGap(18, 18, 18)
                .addComponent(cmbLogsearchin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSearchlog, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchlog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbLogsearchin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnRefreshlog.setText("Refresh");
        btnRefreshlog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshlogActionPerformed(evt);
            }
        });

        btnClearLog.setText("Clear Log");
        btnClearLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearLogActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LogsPanelLayout = new javax.swing.GroupLayout(LogsPanel);
        LogsPanel.setLayout(LogsPanelLayout);
        LogsPanelLayout.setHorizontalGroup(
            LogsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LogsPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnClearLog)
                .addGap(18, 18, 18)
                .addComponent(btnRefreshlog)
                .addContainerGap())
        );
        LogsPanelLayout.setVerticalGroup(
            LogsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogsPanelLayout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(LogsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefreshlog)
                    .addComponent(btnClearLog))
                .addGap(0, 332, Short.MAX_VALUE))
        );

        TabbedPane.addTab("Logs", new javax.swing.ImageIcon(getClass().getResource("/res/logs.png")), LogsPanel, "Manage Logs Information"); // NOI18N

        jPanel48.setBorder(javax.swing.BorderFactory.createTitledBorder("Students Reports"));

        btnAllStudentsReport.setText("All Students Report");
        btnAllStudentsReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllStudentsReportActionPerformed(evt);
            }
        });

        btnStudentAssignmentsReport.setText("All Student Assignments Report");
        btnStudentAssignmentsReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentAssignmentsReportActionPerformed(evt);
            }
        });

        btnStudentExamsReport.setText("All Student Exams Report");
        btnStudentExamsReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentExamsReportActionPerformed(evt);
            }
        });

        btnStudentAssignmentReport2.setText("Student Assignments Report");
        btnStudentAssignmentReport2.setActionCommand("Studnet Assignments Report");
        btnStudentAssignmentReport2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentAssignmentReport2ActionPerformed(evt);
            }
        });

        jLabel91.setText("Student ID:");
        jLabel91.setToolTipText("");

        btnStudentExamsReport2.setText("Student Exams Report");
        btnStudentExamsReport2.setActionCommand("Studnet Exams Report");
        btnStudentExamsReport2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentExamsReport2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnStudentExamsReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnStudentAssignmentsReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAllStudentsReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel48Layout.createSequentialGroup()
                        .addComponent(jLabel91)
                        .addGap(18, 18, 18)
                        .addComponent(txtAssignmentReportStudentid))
                    .addComponent(btnStudentAssignmentReport2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnStudentExamsReport2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAllStudentsReport)
                .addGap(18, 18, 18)
                .addComponent(btnStudentAssignmentsReport)
                .addGap(18, 18, 18)
                .addComponent(btnStudentExamsReport)
                .addGap(18, 18, 18)
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAssignmentReportStudentid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel91))
                .addGap(18, 18, 18)
                .addComponent(btnStudentAssignmentReport2)
                .addGap(18, 18, 18)
                .addComponent(btnStudentExamsReport2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel51.setBorder(javax.swing.BorderFactory.createTitledBorder("Payments Reports"));

        btnStudentPaymentsReport.setText("Student Payments Report");
        btnStudentPaymentsReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentPaymentsReportActionPerformed(evt);
            }
        });

        jLabel92.setText("Student ID:");
        jLabel92.setToolTipText("");

        btnAllPaymentsReport1.setText("All Payments Report");
        btnAllPaymentsReport1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllPaymentsReport1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel51Layout = new javax.swing.GroupLayout(jPanel51);
        jPanel51.setLayout(jPanel51Layout);
        jPanel51Layout.setHorizontalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAllPaymentsReport1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnStudentPaymentsReport, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel51Layout.createSequentialGroup()
                            .addComponent(jLabel92)
                            .addGap(18, 18, 18)
                            .addComponent(txtPaymentReportStudentid, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel51Layout.setVerticalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAllPaymentsReport1)
                .addGap(18, 18, 18)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPaymentReportStudentid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel92))
                .addGap(18, 18, 18)
                .addComponent(btnStudentPaymentsReport)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel53.setBorder(javax.swing.BorderFactory.createTitledBorder("Courses Reports"));

        btnStudentBatchReport.setText("Batch Students Report");
        btnStudentBatchReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentBatchReportActionPerformed(evt);
            }
        });

        jLabel115.setText("Batch ID:");
        jLabel115.setToolTipText("");

        btnAllCoursesReport.setText("All Courses Report");
        btnAllCoursesReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllCoursesReportActionPerformed(evt);
            }
        });

        btnAllBatchesReport.setText("All Batches Report");
        btnAllBatchesReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllBatchesReportActionPerformed(evt);
            }
        });

        jLabel116.setText("Course ID:");
        jLabel116.setToolTipText("");

        btnCourseStudentsReport.setText("Course Students Report");
        btnCourseStudentsReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCourseStudentsReportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel53Layout = new javax.swing.GroupLayout(jPanel53);
        jPanel53.setLayout(jPanel53Layout);
        jPanel53Layout.setHorizontalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCourseStudentsReport, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel53Layout.createSequentialGroup()
                            .addComponent(jLabel116)
                            .addGap(18, 18, 18)
                            .addComponent(txtCourseStudentReportCourseid))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAllBatchesReport, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnAllCoursesReport, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnStudentBatchReport, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel53Layout.createSequentialGroup()
                                        .addComponent(jLabel115)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtBatchReportStudentid, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel53Layout.setVerticalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAllCoursesReport)
                .addGap(18, 18, 18)
                .addComponent(btnAllBatchesReport)
                .addGap(18, 18, 18)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBatchReportStudentid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel115))
                .addGap(18, 18, 18)
                .addComponent(btnStudentBatchReport)
                .addGap(18, 18, 18)
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCourseStudentReportCourseid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel116))
                .addGap(18, 18, 18)
                .addComponent(btnCourseStudentsReport)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ReportsPanelLayout = new javax.swing.GroupLayout(ReportsPanel);
        ReportsPanel.setLayout(ReportsPanelLayout);
        ReportsPanelLayout.setHorizontalGroup(
            ReportsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReportsPanelLayout.createSequentialGroup()
                .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 753, Short.MAX_VALUE))
        );
        ReportsPanelLayout.setVerticalGroup(
            ReportsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReportsPanelLayout.createSequentialGroup()
                .addGroup(ReportsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ReportsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel53, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel48, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(421, Short.MAX_VALUE))
        );

        TabbedPane.addTab("Reports", new javax.swing.ImageIcon(getClass().getResource("/res/reports.png")), ReportsPanel, "View Reports"); // NOI18N

        jPanel49.setBorder(javax.swing.BorderFactory.createTitledBorder("Send Email Notification"));

        txtSenderEmail.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        txtSubject.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        txtMessage.setColumns(20);
        txtMessage.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtMessage.setRows(5);
        jScrollPane2.setViewportView(txtMessage);

        txtSenderEmailPassword.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        btnSendMail.setText("Send");
        btnSendMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendMailActionPerformed(evt);
            }
        });

        jLabel107.setText("Email Address:");

        jLabel108.setText("Password:");

        jLabel109.setText("Subject:");

        jLabel110.setText("Message:");

        jLabel111.setText("Send To:");

        jTextField1.setText("All Students");

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel49Layout.createSequentialGroup()
                        .addComponent(jLabel107)
                        .addGap(24, 24, 24)
                        .addComponent(txtSenderEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel49Layout.createSequentialGroup()
                        .addComponent(jLabel111, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSendMail, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1)))
                    .addGroup(jPanel49Layout.createSequentialGroup()
                        .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel49Layout.createSequentialGroup()
                                .addComponent(jLabel108, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(37, 37, 37))
                            .addGroup(jPanel49Layout.createSequentialGroup()
                                .addComponent(jLabel109)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel49Layout.createSequentialGroup()
                                .addComponent(jLabel110, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(24, 24, 24)))
                        .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSenderEmailPassword)
                            .addComponent(txtSubject)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(25, 25, 25))
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSenderEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel107))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSenderEmailPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel108))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel109))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel49Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel110)))
                .addGap(13, 13, 13)
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel111)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSendMail)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel50.setBorder(javax.swing.BorderFactory.createTitledBorder("Database Backup"));

        btnBackup.setText("Backup Database");
        btnBackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackupActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBackup)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBackup)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel52.setBorder(javax.swing.BorderFactory.createTitledBorder("Database Restore"));

        btnRestore.setText("Restore Database");
        btnRestore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestoreActionPerformed(evt);
            }
        });

        jLabel5.setText("SQL Dump File:");

        javax.swing.GroupLayout jPanel52Layout = new javax.swing.GroupLayout(jPanel52);
        jPanel52.setLayout(jPanel52Layout);
        jPanel52Layout.setHorizontalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel52Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(txtSqlDump, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRestore)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel52Layout.setVerticalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRestore)
                    .addComponent(jLabel5)
                    .addComponent(txtSqlDump, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ToolsPanelLayout = new javax.swing.GroupLayout(ToolsPanel);
        ToolsPanel.setLayout(ToolsPanelLayout);
        ToolsPanelLayout.setHorizontalGroup(
            ToolsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ToolsPanelLayout.createSequentialGroup()
                .addComponent(jPanel49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ToolsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 565, Short.MAX_VALUE))
        );
        ToolsPanelLayout.setVerticalGroup(
            ToolsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ToolsPanelLayout.createSequentialGroup()
                .addGroup(ToolsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ToolsPanelLayout.createSequentialGroup()
                        .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 379, Short.MAX_VALUE))
        );

        jPanel50.getAccessibleContext().setAccessibleName("Backup Database");
        jPanel52.getAccessibleContext().setAccessibleName("Restore Database");

        TabbedPane.addTab("Tools", new javax.swing.ImageIcon(getClass().getResource("/res/tools.png")), ToolsPanel, "Tools and Options"); // NOI18N

        jLabel82.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel82.setText("Europa Developers (Pvt) Ltd.");

        jLabel83.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel83.setText("Rasan Samarasinghe");

        jLabel84.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel84.setText("Ubaidulla Mueen");

        jLabel85.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel85.setText("Kushan Ranasinghe");

        jLabel112.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel112.setText("Sayona Perera");

        jLabel113.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel113.setText("Kavindya Baddegama");

        jLabel114.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel114.setText("Binara Navaratne");

        jLabel117.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/europalogo.jpg"))); // NOI18N

        javax.swing.GroupLayout AboutPanelLayout = new javax.swing.GroupLayout(AboutPanel);
        AboutPanel.setLayout(AboutPanelLayout);
        AboutPanelLayout.setHorizontalGroup(
            AboutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AboutPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AboutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel85)
                    .addComponent(jLabel84)
                    .addComponent(jLabel83)
                    .addComponent(jLabel82)
                    .addComponent(jLabel114)
                    .addComponent(jLabel113)
                    .addComponent(jLabel112)
                    .addComponent(jLabel117))
                .addContainerGap(1044, Short.MAX_VALUE))
        );
        AboutPanelLayout.setVerticalGroup(
            AboutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AboutPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel117)
                .addGap(18, 18, 18)
                .addComponent(jLabel82)
                .addGap(18, 18, 18)
                .addComponent(jLabel83)
                .addGap(18, 18, 18)
                .addComponent(jLabel84)
                .addGap(18, 18, 18)
                .addComponent(jLabel85)
                .addGap(18, 18, 18)
                .addComponent(jLabel112)
                .addGap(18, 18, 18)
                .addComponent(jLabel113)
                .addGap(18, 18, 18)
                .addComponent(jLabel114)
                .addContainerGap(329, Short.MAX_VALUE))
        );

        TabbedPane.addTab("About", new javax.swing.ImageIcon(getClass().getResource("/res/europaicon.png")), AboutPanel); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabbedPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDepartmentidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDepartmentidKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyChar()=='\n'){
            try{
                con = DB.getConnection();
                PreparedStatement pstmt = con.prepareStatement("select * from tbldepartment where departmentid=?");
                pstmt.setInt(1, Integer.parseInt(txtDepartmentid.getText()));
                ResultSet rs = pstmt.executeQuery();
                if(rs.next()){
                    txtDepartmentname.setText(rs.getString("department_name"));
                    txtDepartmentdescription.setText(rs.getString("description"));
                    stateUpdateDepartment();
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Record not found!");
                }
                con.close();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Exception in txtDepartmentidKeyPressed: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_txtDepartmentidKeyPressed

    private void btnInsertDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertDepartmentActionPerformed
        // TODO add your handling code here:
        if(btnInsertDepartment.getText() == "Insert"){
            if(Validator.validateDepartment(null, txtDepartmentid, txtDepartmentname, txtDepartmentdescription)){
                try{
                    con = DB.getConnection();
                    PreparedStatement pstmt = con.prepareStatement("insert into tbldepartment values(?, ?, ?, ?)");
                    pstmt.setInt(1, Integer.parseInt(txtDepartmentid.getText()));
                    pstmt.setString(2, txtDepartmentname.getText());
                    pstmt.setString(3, txtDepartmentdescription.getText());
                    pstmt.setInt(4, userid);
                    int n = pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(this, n + " record inserted successfully!");
                    con.close();
                    clearDepartmentForm();
                    showDepartments(null, null);
                    Log.insert("Department", "Inserted", userid);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(this, "Exception in btnInsertActionPerformed: " + ex.getMessage());
                }
            }
        }else{
            clearDepartmentForm();
            stateInsertDepartment();
        }
    }//GEN-LAST:event_btnInsertDepartmentActionPerformed

    private void btnUpdateDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateDepartmentActionPerformed
        // TODO add your handling code here:
        if(Validator.validateDepartment(null, txtDepartmentid, txtDepartmentname, txtDepartmentdescription)){
            try{
                con = DB.getConnection();
                PreparedStatement pstmt = con.prepareStatement("update tbldepartment set department_name=?, description=? where departmentid=?");
                pstmt.setString(1, txtDepartmentname.getText());
                pstmt.setString(2, txtDepartmentdescription.getText());
                pstmt.setInt(3, Integer.parseInt(txtDepartmentid.getText()));
                int n = pstmt.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, n + " record updated successfully!");
                showDepartments(null, null);
                con.close();
                Log.insert("Department", "Updated", userid);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Exception in btnUpdateActionPerformed: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnUpdateDepartmentActionPerformed

    private void btnDeleteDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteDepartmentActionPerformed
        // TODO add your handling code here:
        int respond = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to delete this record?", "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if(respond == 0){
            try{
                con = DB.getConnection();
                PreparedStatement pstmt = con.prepareStatement("delete from tbldepartment where departmentid=?");
                pstmt.setInt(1, Integer.parseInt(txtDepartmentid.getText()));
                int n = pstmt.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, n + " record deleted successfully!");
                clearDepartmentForm();
                showDepartments(null, null);
                con.close();
                stateInsertDepartment();
                Log.insert("Department", "Deleted", userid);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Exception in btnDeleteActionPerformed: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnDeleteDepartmentActionPerformed

    private void tblDepartmentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDepartmentsMouseClicked
        // TODO add your handling code here:
        try{
            con = DB.getConnection();
            int row = tblDepartments.getSelectedRow();
            String selectedid = tblDepartments.getModel().getValueAt(row, 0).toString();  
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from tbldepartment where departmentid = " + selectedid);
            if(rs.next()){
                txtDepartmentid.setText(rs.getString("departmentid"));
                txtDepartmentname.setText(rs.getString("department_name"));
                txtDepartmentdescription.setText(rs.getString("description"));
                stateUpdateDepartment();
            }else{
                JOptionPane.showMessageDialog(this, "No record found");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Exception in jTable1MouseClicked: " + ex.getMessage());
        }
    }//GEN-LAST:event_tblDepartmentsMouseClicked

    private void txtSearchdepartmentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchdepartmentKeyReleased
        // TODO add your handling code here:
        showDepartments(cmbDepartmentsearchin.getSelectedItem().toString(), txtSearchdepartment.getText());
    }//GEN-LAST:event_txtSearchdepartmentKeyReleased

    private void txtStudentidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStudentidKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyChar()=='\n'){
            try{
                con = DB.getConnection();
                PreparedStatement pstmt = con.prepareStatement("select * from tblstudent where studentid=?");
                pstmt.setInt(1, Integer.parseInt(txtStudentid.getText()));
                ResultSet rs = pstmt.executeQuery();
                if(rs.next()){
                    stateUpdateStudent();
                    txtStudentname.setText(rs.getString("student_name"));
                    txtStudentaddress.setText(rs.getString("address"));
                    cmbStudentgender.setSelectedItem(rs.getString("gender"));
                    dteStudentbirthday.setDate(rs.getDate("birthday"));
                    txtStudentemail.setText(rs.getString("email"));
                    txtStudentphone.setText(rs.getString("phone"));
                    txtStudentbackground.setText(rs.getString("background"));
                    dteStudentregdate.setDate(rs.getDate("reg_date"));
                    cmbStudentbatchid.setSelectedItem(rs.getString("batchid"));
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Record not found!");
                }
                con.close();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Exception in txtStudentidKeyPressed: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_txtStudentidKeyPressed

    private void btnUpdatestudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdatestudentActionPerformed
        // TODO add your handling code here:
        if(Validator.validateStudent(null, txtStudentid, txtStudentname, txtStudentaddress, cmbStudentgender, dteStudentbirthday, txtStudentemail, txtStudentphone, txtStudentbackground, dteStudentregdate)){
            try{
                con = DB.getConnection();
                PreparedStatement pstmt = con.prepareStatement("update tblstudent set student_name=?, address=?, gender=?, birthday=?, email=?, phone=?, background=?, reg_date=?, batchid=? where studentid=?");
                SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
                pstmt.setString(1, txtStudentname.getText());
                pstmt.setString(2, txtStudentaddress.getText());
                pstmt.setString(3, cmbStudentgender.getSelectedItem().toString());
                pstmt.setString(4, dt.format(dteStudentbirthday.getDate()));
                pstmt.setString(5, txtStudentemail.getText());
                pstmt.setString(6, txtStudentphone.getText());
                pstmt.setString(7, txtStudentbackground.getText());
                pstmt.setString(8, dt.format(dteStudentregdate.getDate()));
                pstmt.setString(9, cmbStudentbatchid.getSelectedItem().toString());
                pstmt.setInt(10, Integer.parseInt(txtStudentid.getText()));
                int n = pstmt.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, n + " record updated successfully!");
                showStudents(null, null);
                con.close();
                Log.insert("Student", "Updated", userid);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Exception in btnUpdatestudentActionPerformed: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnUpdatestudentActionPerformed

    private void btnDeletestudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletestudentActionPerformed
        // TODO add your handling code here:
        int respond = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to delete this record?", "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if(respond == 0){
            try{
                con = DB.getConnection();
                PreparedStatement pstmt = con.prepareStatement("delete from tblstudent where studentid=?");
                pstmt.setInt(1, Integer.parseInt(txtStudentid.getText()));
                int n = pstmt.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, n + " record deleted successfully!");
                clearStudentForm();
                showStudents(null, null);
                con.close();
                stateInsertStudent();
                Log.insert("Student", "Deleted", userid);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Exception in btnDeletestudentActionPerformed: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnDeletestudentActionPerformed

    private void btnInsertstudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertstudentActionPerformed
        // TODO add your handling code here:
        if(btnInsertstudent.getText() == "Insert"){
            if(Validator.validateStudent(null, txtStudentid, txtStudentname, txtStudentaddress, cmbStudentgender, dteStudentbirthday, txtStudentemail, txtStudentphone, txtStudentbackground, dteStudentregdate)){
                try{
                    con = DB.getConnection();
                    PreparedStatement pstmt = con.prepareStatement("insert into tblstudent values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                    SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
                    pstmt.setInt(1, Integer.parseInt(txtStudentid.getText()));
                    pstmt.setString(2, txtStudentname.getText());
                    pstmt.setString(3, txtStudentaddress.getText());
                    pstmt.setString(4, cmbStudentgender.getSelectedItem().toString());
                    pstmt.setString(5, dt.format(dteStudentbirthday.getDate()).toString());
                    pstmt.setString(6, txtStudentemail.getText());
                    pstmt.setString(7, txtStudentphone.getText());
                    pstmt.setString(8, txtStudentbackground.getText());
                    pstmt.setString(9, dt.format(dteStudentregdate.getDate()));
                    pstmt.setString(10, cmbStudentbatchid.getSelectedItem().toString());
                    pstmt.setInt(11, userid);
                    int n = pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(this, n + " record inserted successfully!");
                    con.close();
                    clearStudentForm();
                    showStudents(null, null);
                    Log.insert("Student", "Inserted", userid);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(this, "Exception in btnInsertstudentActionPerformed(): " + ex.getMessage());
                }
            }
        }else{
            clearStudentForm();
            stateInsertStudent();
        }
    }//GEN-LAST:event_btnInsertstudentActionPerformed

    private void tblCoursesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCoursesMouseClicked
        // TODO add your handling code here:
        try{
            con = DB.getConnection();
            int row = tblCourses.getSelectedRow();
            String selectedid = tblCourses.getModel().getValueAt(row, 0).toString();  
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from tblcourse where courseid = " + selectedid);
            if(rs.next()){
                stateUpdateCourse();
                txtCourseid.setText(rs.getString("courseid"));
                txtCoursename.setText(rs.getString("course_name"));
                txtCourseduration.setText(rs.getString("duration"));
                txtCoursefee.setText(rs.getString("fee"));
                txtCourselevel.setText(rs.getString("level"));
                cmbCoursedepartmentid.setSelectedItem(rs.getString("departmentid"));
                cmbCoursecoordinatorid.setSelectedItem(rs.getString("coordinatorid"));
            }else{
                JOptionPane.showMessageDialog(this, "No record found");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Exception in tblCoursesMouseClicked: " + ex.getMessage());
        }
    }//GEN-LAST:event_tblCoursesMouseClicked

    private void txtSearchcourseKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchcourseKeyReleased
        // TODO add your handling code here:
        showCourses(cmbCoursesearchin.getSelectedItem().toString(), txtSearchcourse.getText());
    }//GEN-LAST:event_txtSearchcourseKeyReleased

    private void txtCourseidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCourseidKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyChar()=='\n'){
            try{
                con = DB.getConnection();
                PreparedStatement pstmt = con.prepareStatement("select * from tblcourse where courseid=?");
                pstmt.setInt(1, Integer.parseInt(txtCourseid.getText()));
                ResultSet rs = pstmt.executeQuery();
                if(rs.next()){
                    stateUpdateCourse();
                    txtCoursename.setText(rs.getString("course_name"));
                    txtCourseduration.setText(rs.getString("duration"));
                    txtCoursefee.setText(rs.getString("fee"));
                    txtCourselevel.setText(rs.getString("level"));
                    cmbCoursedepartmentid.setSelectedItem(rs.getString("departmentid"));
                    cmbCoursecoordinatorid.setSelectedItem(rs.getString("coordinatorid"));
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Record not found!");
                }
                con.close();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Exception in txtCourseidKeyPressed: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_txtCourseidKeyPressed

    private void btnInsertcourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertcourseActionPerformed
        // TODO add your handling code here:
        if(btnInsertcourse.getText() == "Insert"){
            if(Validator.validateCourse(null, txtCourseid, txtCoursename, txtCourseduration, txtCoursefee, txtCourselevel, cmbCoursedepartmentid, cmbCoursecoordinatorid)){
                try{
                    con = DB.getConnection();
                    PreparedStatement pstmt = con.prepareStatement("insert into tblCourse values(?, ?, ?, ?, ?, ?, ?, ?)");
                    pstmt.setInt(1, Integer.parseInt(txtCourseid.getText()));
                    pstmt.setString(2, txtCoursename.getText());
                    pstmt.setString(3, txtCourseduration.getText());
                    pstmt.setString(4, txtCoursefee.getText());
                    pstmt.setString(5, txtCourselevel.getText());
                    pstmt.setString(6, cmbCoursedepartmentid.getSelectedItem().toString());
                    pstmt.setString(7, cmbCoursecoordinatorid.getSelectedItem().toString());
                    pstmt.setInt(8, userid);
                    int n = pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(this, n + " record inserted successfully!");
                    con.close();
                    clearCourseForm();
                    showCourses(null, null);
                    Log.insert("Course", "Inserted", userid);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(this, "Exception in btnInsertcourseActionPerformed: " + ex.getMessage());
                }
            }
        }else{
            clearCourseForm();
            stateInsertCourse();
        }
    }//GEN-LAST:event_btnInsertcourseActionPerformed

    private void btnDeletecourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletecourseActionPerformed
        // TODO add your handling code here:
        int respond = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to delete this record?", "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if(respond == 0){
            try{
                con = DB.getConnection();
                PreparedStatement pstmt = con.prepareStatement("delete from tblcourse where courseid=?");
                pstmt.setInt(1, Integer.parseInt(txtCourseid.getText()));
                int n = pstmt.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, n + " record deleted successfully!");
                clearCourseForm();
                showCourses(null, null);
                con.close();
                stateInsertCourse();
                Log.insert("Course", "Deleted", userid);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Exception in btnDeletecourseActionPerformed: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnDeletecourseActionPerformed

    private void btnUpdatecourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdatecourseActionPerformed
        // TODO add your handling code here:
        if(Validator.validateCourse(null, txtCourseid, txtCoursename, txtCourseduration, txtCoursefee, txtCourselevel, cmbCoursedepartmentid, cmbCoursecoordinatorid)){
            try{
                con = DB.getConnection();
                PreparedStatement pstmt = con.prepareStatement("update tblcourse set course_name=?, duration=?, fee=?, level=?, departmentid=?, coordinatorid=? where courseid=?");
                pstmt.setString(1, txtCoursename.getText());
                pstmt.setString(2, txtCourseduration.getText());
                pstmt.setString(3, txtCoursefee.getText());
                pstmt.setString(4, txtCourselevel.getText());
                pstmt.setString(5, cmbCoursedepartmentid.getSelectedItem().toString());
                pstmt.setString(6, cmbCoursecoordinatorid.getSelectedItem().toString());
                pstmt.setInt(7, Integer.parseInt(txtCourseid.getText()));
                int n = pstmt.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, n + " record updated successfully!");
                showCourses(null, null);
                con.close();
                Log.insert("Course", "Updated", userid);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Exception in btnUpdatecourseActionPerformed: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnUpdatecourseActionPerformed

    private void tblLecturersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLecturersMouseClicked
        // TODO add your handling code here:
        try{
            con = DB.getConnection();
            int row = tblLecturers.getSelectedRow();
            String selectedid = tblLecturers.getModel().getValueAt(row, 0).toString();  
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from tbllecturer where lecturerid = " + selectedid);
            if(rs.next()){
                txtLecturerid.setText(rs.getString("lecturerid"));
                txtLecturername.setText(rs.getString("lecturer_name"));
                txtLectureraddress.setText(rs.getString("address"));
                txtLectureremail.setText(rs.getString("email"));
                txtLecturerphone.setText(rs.getString("phone"));
                txtLecturerdescription.setText(rs.getString("description"));
                stateUpdateLecturer();
            }else{
                JOptionPane.showMessageDialog(this, "No record found");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Exception in tblLecturersMouseClicked: " + ex.getMessage());
        }
    }//GEN-LAST:event_tblLecturersMouseClicked

    private void txtSearchlecturerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchlecturerKeyReleased
        // TODO add your handling code here:
        showLecturers(cmbLecturersearchin.getSelectedItem().toString(), txtSearchlecturer.getText());
    }//GEN-LAST:event_txtSearchlecturerKeyReleased

    private void txtLectureridKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLectureridKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyChar()=='\n'){
            try{
                con = DB.getConnection();
                PreparedStatement pstmt = con.prepareStatement("select * from tbllecturer where lecturerid=?");
                pstmt.setInt(1, Integer.parseInt(txtLecturerid.getText()));
                ResultSet rs = pstmt.executeQuery();
                if(rs.next()){
                    txtLecturername.setText(rs.getString("lecturer_name"));
                    txtLectureraddress.setText(rs.getString("address"));
                    txtLectureremail.setText(rs.getString("email"));
                    txtLecturerphone.setText(rs.getString("phone"));
                    txtLecturerdescription.setText(rs.getString("description"));
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Record not found!");
                }
                con.close();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Exception in txtLectureridKeyPressed: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_txtLectureridKeyPressed

    private void btnUpdatelecturerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdatelecturerActionPerformed
        // TODO add your handling code here:
        if(Validator.validateLecturer(null, txtLecturerid, txtLecturername, txtLectureraddress, txtLectureremail, txtLecturerphone)){
            try{
                con = DB.getConnection();
                PreparedStatement pstmt = con.prepareStatement("update tbllecturer set lecturer_name=?, address=?, email=?, phone=?, description=? where lecturerid=?");
                pstmt.setString(1, txtLecturername.getText());
                pstmt.setString(2, txtLectureraddress.getText());
                pstmt.setString(3, txtLectureremail.getText());
                pstmt.setString(4, txtLecturerphone.getText());
                pstmt.setString(5, txtLecturerdescription.getText());
                pstmt.setInt(6, Integer.parseInt(txtLecturerid.getText()));
                int n = pstmt.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, n + " record updated successfully!");
                showLecturers(null, null);
                con.close();
                Log.insert("Lecturer", "Updated", userid);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Exception in btnUpdatelecturerActionPerformed: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnUpdatelecturerActionPerformed

    private void btnDeletelecturerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletelecturerActionPerformed
        // TODO add your handling code here:
        int respond = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to delete this record?", "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if(respond == 0){
            try{
                con = DB.getConnection();
                PreparedStatement pstmt = con.prepareStatement("delete from tbllecturer where lecturerid=?");
                pstmt.setInt(1, Integer.parseInt(txtLecturerid.getText()));
                int n = pstmt.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, n + " record deleted successfully!");
                clearLecturerForm();
                showLecturers(null, null);
                con.close();
                stateInsertLecturer();
                Log.insert("Lecturer", "Deleted", userid);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Exception in btnDeletelecturerActionPerformed: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnDeletelecturerActionPerformed

    private void btnInsertlecturerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertlecturerActionPerformed
        // TODO add your handling code here:
        if(btnInsertlecturer.getText() == "Insert"){
            if(Validator.validateLecturer(null, txtLecturerid, txtLecturername, txtLectureraddress, txtLectureremail, txtLecturerphone)){
                try{
                    con = DB.getConnection();
                    PreparedStatement pstmt = con.prepareStatement("insert into tbllecturer values(?, ?, ?, ?, ?, ?, ?)");
                    pstmt.setInt(1, Integer.parseInt(txtLecturerid.getText()));
                    pstmt.setString(2, txtLecturername.getText());
                    pstmt.setString(3, txtLectureraddress.getText());
                    pstmt.setString(4, txtLectureremail.getText());
                    pstmt.setString(5, txtLecturerphone.getText());
                    pstmt.setString(6, txtLecturerdescription.getText());
                    pstmt.setInt(7, userid);
                    int n = pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(this, n + " record inserted successfully!");
                    con.close();
                    clearLecturerForm();
                    showLecturers(null, null);
                    Log.insert("Lecturer", "Inserted", userid);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(this, "Exception in btnInsertlecturerActionPerformed(): " + ex.getMessage());
                }
            }
        }else{
            clearLecturerForm();
            stateInsertLecturer();
        }
    }//GEN-LAST:event_btnInsertlecturerActionPerformed

    private void tblPracticalsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPracticalsMouseClicked
        // TODO add your handling code here:
        try{
            con = DB.getConnection();
            int row = tblPracticals.getSelectedRow();
            String selectedid = tblPracticals.getModel().getValueAt(row, 0).toString();  
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from tblpractical where practicalid = " + selectedid);
            if(rs.next()){
                stateUpdatePractical();
                txtPracticalid.setText(rs.getString("practicalid"));
                dtePracticalstartdate.setDate(rs.getDate("starttime"));
                dtePracticalenddate.setDate(rs.getDate("endtime"));
                cmbPracticalstudentid.setSelectedItem(rs.getString("studentid"));
                cmbPracticalclassroomid.setSelectedItem(rs.getString("classroomid"));
            }else{
                JOptionPane.showMessageDialog(this, "No record found");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Exception in tblPracticalsMouseClicked: " + ex.getMessage());
        }
    }//GEN-LAST:event_tblPracticalsMouseClicked

    private void txtSearchpracticalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchpracticalKeyReleased
        // TODO add your handling code here:
        showPracticals(cmbPracticalsearchin.getSelectedItem().toString(), txtSearchpractical.getText());
    }//GEN-LAST:event_txtSearchpracticalKeyReleased

    private void tblPaymentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPaymentsMouseClicked
        // TODO add your handling code here:
        try{
            con = DB.getConnection();
            int row = tblPayments.getSelectedRow();
            String selectedid = tblPayments.getModel().getValueAt(row, 0).toString();  
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from tblpayment where paymentid = " + selectedid);
            if(rs.next()){
                stateUpdatePayment();
                txtPaymentid.setText(rs.getString("paymentid"));
                txtPaymentamount.setText(rs.getString("amount"));
                dtePaymentdate.setDate(rs.getDate("time"));
                cmbPaymentstudentid.setSelectedItem(rs.getString("studentid"));
            }else{
                JOptionPane.showMessageDialog(this, "No record found");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Exception in tblPaymentsMouseClicked: " + ex.getMessage());
        }
    }//GEN-LAST:event_tblPaymentsMouseClicked

    private void txtSearchpaymentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchpaymentKeyReleased
        // TODO add your handling code here:
        showPayments(cmbPaymentsearchin.getSelectedItem().toString(), txtSearchpayment.getText());
    }//GEN-LAST:event_txtSearchpaymentKeyReleased

    private void tblModulesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblModulesMouseClicked
        // TODO add your handling code here:
        try{
            con = DB.getConnection();
            int row = tblModules.getSelectedRow();
            String selectedid = tblModules.getModel().getValueAt(row, 0).toString();  
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from tblmodule where moduleid = " + selectedid);
            if(rs.next()){
                stateUpdateModule();
                txtModuleid.setText(rs.getString("moduleid"));
                txtModulename.setText(rs.getString("module_name"));
                txtModuledescription.setText(rs.getString("description"));
                cmbModulelecturerid.setSelectedItem(rs.getString("lecturerid"));
            }else{
                JOptionPane.showMessageDialog(this, "No record found");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Exception in tblModulesMouseClicked: " + ex.getMessage());
        }
    }//GEN-LAST:event_tblModulesMouseClicked

    private void txtSearchmoduleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchmoduleKeyReleased
        // TODO add your handling code here:
        showModules(cmbModulesearchin.getSelectedItem().toString(), txtSearchmodule.getText());
    }//GEN-LAST:event_txtSearchmoduleKeyReleased

    private void tblExamsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblExamsMouseClicked
        // TODO add your handling code here:
        try{
            con = DB.getConnection();
            int row = tblExams.getSelectedRow();
            String selectedid = tblExams.getModel().getValueAt(row, 0).toString();  
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from tblexam where examid = " + selectedid);
            if(rs.next()){
                stateUpdateExam();
                txtExamid.setText(rs.getString("examid"));
                dteExamstartdate.setDate(rs.getDate("starttime"));
                dteExamenddate.setDate(rs.getDate("endtime"));
                cmbExammoduleid.setSelectedItem(rs.getString("moduleid"));
            }else{
                JOptionPane.showMessageDialog(this, "No record found");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Exception in tblExamsMouseClicked: " + ex.getMessage());
        }
    }//GEN-LAST:event_tblExamsMouseClicked

    private void txtSearchexamKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchexamKeyReleased
        // TODO add your handling code here:
        showExams(cmbExamsearchin.getSelectedItem().toString(), txtSearchexam.getText());
    }//GEN-LAST:event_txtSearchexamKeyReleased

    private void tblAssignmentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAssignmentsMouseClicked
        // TODO add your handling code here:
        try{
            con = DB.getConnection();
            int row = tblAssignments.getSelectedRow();
            String selectedid = tblAssignments.getModel().getValueAt(row, 0).toString();  
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from tblassignment where assignmentid = " + selectedid);
            if(rs.next()){
                stateUpdateAssignment();
                txtAssignmentid.setText(rs.getString("assignmentid"));
                txtAssignmentname.setText(rs.getString("assignment_name"));
                txtAssignmentdescription.setText(rs.getString("description"));
                cmbAssignmentmoduleid.setSelectedItem(rs.getString("moduleid"));
                dteAssignmentduedate.setDate(rs.getDate("duedate"));
            }else{
                JOptionPane.showMessageDialog(this, "No record found");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Exception in tblAssignmentsMouseClicked: " + ex.getMessage());
        }
    }//GEN-LAST:event_tblAssignmentsMouseClicked

    private void txtSearchassignmentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchassignmentKeyReleased
        // TODO add your handling code here:
        showAssignments(cmbAssignmentsearchin.getSelectedItem().toString(), txtSearchassignment.getText());
    }//GEN-LAST:event_txtSearchassignmentKeyReleased

    private void tblLecturesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLecturesMouseClicked
        // TODO add your handling code here:
        try{
            con = DB.getConnection();
            int row = tblLectures.getSelectedRow();
            String selectedid = tblLectures.getModel().getValueAt(row, 0).toString();  
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from tbllecture where lectureid = " + selectedid);
            if(rs.next()){
                stateUpdateLecture();
                txtLectureid.setText(rs.getString("lectureid"));
                dteLecturestartdate.setDate(rs.getDate("starttime"));
                dteLectureenddate.setDate(rs.getDate("endtime"));
                txtLecturedescription.setText(rs.getString("description"));
                txtLectureclassroomid.setText(rs.getString("classroomid"));
                cmbLecturemoduleid.setSelectedItem(rs.getString("moduleid"));
            }else{
                JOptionPane.showMessageDialog(this, "No record found");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Exception in tblLecturesMouseClicked: " + ex.getMessage());
        }
    }//GEN-LAST:event_tblLecturesMouseClicked

    private void txtSearchlectureKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchlectureKeyReleased
        // TODO add your handling code here:
        showLectures(cmbLecturessearchin.getSelectedItem().toString(), txtSearchlecture.getText());
    }//GEN-LAST:event_txtSearchlectureKeyReleased

    private void tblUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsersMouseClicked
        // TODO add your handling code here:
        try{
            con = DB.getConnection();
            int row = tblUsers.getSelectedRow();
            String selectedid = tblUsers.getModel().getValueAt(row, 0).toString();  
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from tbluser where userid = " + selectedid);
            if(rs.next()){
                stateUpdateUser();
                txtUserid.setText(rs.getString("userid"));
                txtUsername.setText(rs.getString("user_name"));
                txtUseremail.setText(rs.getString("email"));
                cmbUsertype.setSelectedItem(rs.getString("type"));
                cmbUserstatus.setSelectedItem(rs.getString("status"));
            }else{
                JOptionPane.showMessageDialog(this, "No record found");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Exception in tblUsersMouseClicked: " + ex.getMessage());
        }
    }//GEN-LAST:event_tblUsersMouseClicked

    private void txtSearchuserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchuserKeyReleased
        // TODO add your handling code here:
        showUsers(cmbUsersearchin.getSelectedItem().toString(), txtSearchuser.getText());
    }//GEN-LAST:event_txtSearchuserKeyReleased

    private void txtSearchlogKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchlogKeyReleased
        // TODO add your handling code here:
        showLogs(cmbLogsearchin.getSelectedItem().toString(), txtSearchlog.getText());
    }//GEN-LAST:event_txtSearchlogKeyReleased

    private void txtPracticalidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPracticalidKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyChar()=='\n'){
            try{
                con = DB.getConnection();
                PreparedStatement pstmt = con.prepareStatement("select * from tblpractical where practicalid=?");
                pstmt.setInt(1, Integer.parseInt(txtPracticalid.getText()));
                ResultSet rs = pstmt.executeQuery();
                if(rs.next()){
                    stateUpdatePractical();
                    dtePracticalstartdate.setDate(rs.getDate("starttime"));
                    dtePracticalenddate.setDate(rs.getDate("endtime"));
                    cmbPracticalstudentid.setSelectedItem(rs.getString("studentid"));
                    cmbPracticalclassroomid.setSelectedItem(rs.getString("classroomid"));
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Record not found!");
                }
                con.close();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Exception in txtPracticalidKeyPressed: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_txtPracticalidKeyPressed

    private void txtPaymentidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaymentidKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyChar()=='\n'){
            try{
                con = DB.getConnection();
                PreparedStatement pstmt = con.prepareStatement("select * from tblpayment where paymentid=?");
                pstmt.setInt(1, Integer.parseInt(txtPaymentid.getText()));
                ResultSet rs = pstmt.executeQuery();
                if(rs.next()){
                    stateUpdatePayment();
                    txtPaymentamount.setText(rs.getString("amount"));
                    dtePaymentdate.setDate(rs.getDate("time"));
                    cmbPaymentstudentid.setSelectedItem(rs.getString("studentid"));
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Record not found!");
                }
                con.close();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Exception in txtPaymentidKeyPressed: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_txtPaymentidKeyPressed

    private void txtModuleidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtModuleidKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyChar()=='\n'){
            try{
                con = DB.getConnection();
                PreparedStatement pstmt = con.prepareStatement("select * from tblmodule where moduleid=?");
                pstmt.setInt(1, Integer.parseInt(txtModuleid.getText()));
                ResultSet rs = pstmt.executeQuery();
                if(rs.next()){
                    stateUpdateModule();
                    txtModulename.setText(rs.getString("module_name"));
                    txtModuledescription.setText(rs.getString("description"));
                    cmbModulelecturerid.setSelectedItem(rs.getString("lecturerid"));
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Record not found!");
                }
                con.close();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Exception in txtModuleidKeyPressed: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_txtModuleidKeyPressed

    private void txtExamidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtExamidKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyChar()=='\n'){
            try{
                con = DB.getConnection();
                PreparedStatement pstmt = con.prepareStatement("select * from tblexam where examid=?");
                pstmt.setInt(1, Integer.parseInt(txtExamid.getText()));
                ResultSet rs = pstmt.executeQuery();
                if(rs.next()){
                    stateUpdateExam();
                    dteExamstartdate.setDate(rs.getDate("starttime"));
                    dteExamenddate.setDate(rs.getDate("endtime"));
                    cmbExammoduleid.setSelectedItem(rs.getString("moduleid"));
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Record not found!");
                }
                con.close();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Exception in txtExamidKeyPressed: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_txtExamidKeyPressed

    private void txtAssignmentidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAssignmentidKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyChar()=='\n'){
            try{
                con = DB.getConnection();
                PreparedStatement pstmt = con.prepareStatement("select * from tblassignment where assignmentid=?");
                pstmt.setInt(1, Integer.parseInt(txtAssignmentid.getText()));
                ResultSet rs = pstmt.executeQuery();
                if(rs.next()){
                    stateUpdateAssignment();
                    txtAssignmentname.setText(rs.getString("assignment_name"));
                    txtAssignmentdescription.setText(rs.getString("description"));
                    cmbAssignmentmoduleid.setSelectedItem(rs.getString("moduleid"));
                    dteAssignmentduedate.setDate(rs.getDate("duedate"));
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Record not found!");
                }
                con.close();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Exception in txtAssignmentidKeyPressed: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_txtAssignmentidKeyPressed

    private void txtLectureidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLectureidKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyChar()=='\n'){
            try{
                con = DB.getConnection();
                PreparedStatement pstmt = con.prepareStatement("select * from tbllecture where lectureid=?");
                pstmt.setInt(1, Integer.parseInt(txtLectureid.getText()));
                ResultSet rs = pstmt.executeQuery();
                if(rs.next()){
                    stateUpdateLecture();
                    dteLecturestartdate.setDate(rs.getDate("starttime"));
                    dteLectureenddate.setDate(rs.getDate("endtime"));
                    txtLecturedescription.setText(rs.getString("description"));
                    txtLectureclassroomid.setText(rs.getString("classroomid"));
                    cmbLecturemoduleid.setSelectedItem(rs.getString("moduleid"));
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Record not found!");
                }
                con.close();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Exception in txtLectureidKeyPressed: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_txtLectureidKeyPressed

    private void txtUseridKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUseridKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyChar()=='\n'){
            try{
                con = DB.getConnection();
                PreparedStatement pstmt = con.prepareStatement("select * from tbluser where userid=?");
                pstmt.setInt(1, Integer.parseInt(txtUserid.getText()));
                ResultSet rs = pstmt.executeQuery();
                if(rs.next()){
                    stateUpdateUser();
                    txtUsername.setText(rs.getString("user_name"));
                    txtUseremail.setText(rs.getString("email"));
                    cmbUsertype.setSelectedItem(rs.getString("type"));
                    cmbUserstatus.setSelectedItem(rs.getString("status"));
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Record not found!");
                }
                con.close();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Exception in txtUseridKeyPressed: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_txtUseridKeyPressed

    private void btnUpdatepracticalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdatepracticalActionPerformed
        // TODO add your handling code here:
        if(Validator.validatePractical(null, txtPracticalid, dtePracticalstartdate, dtePracticalenddate, cmbPracticalstudentid, cmbPracticalclassroomid)){
            try{
                con = DB.getConnection();
                PreparedStatement pstmt = con.prepareStatement("update tblpractical set starttime=?, endtime=?, studentid=?, classroomid=? where practicalid=?");
                SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
                pstmt.setString(1, dt.format(dtePracticalstartdate.getDate()).toString()+ " " + cmbPracticalstarttime.getSelectedItem());
                pstmt.setString(2, dt.format(dtePracticalenddate.getDate()).toString()+ " " + cmbPracticalendtime.getSelectedItem());
                pstmt.setString(3, cmbPracticalstudentid.getSelectedItem().toString());
                pstmt.setString(4, cmbPracticalclassroomid.getSelectedItem().toString());
                pstmt.setInt(5, Integer.parseInt(txtPracticalid.getText()));
                int n = pstmt.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, n + " record updated successfully!");
                showPracticals(null, null);
                con.close();
                Log.insert("Practical", "Updated", userid);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Exception in btnUpdatepracticalActionPerformed: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnUpdatepracticalActionPerformed

    private void btnDeletepracticalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletepracticalActionPerformed
        // TODO add your handling code here:
        int respond = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to delete this record?", "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if(respond == 0){
            try{
                con = DB.getConnection();
                PreparedStatement pstmt = con.prepareStatement("delete from tblpractical where practicalid=?");
                pstmt.setInt(1, Integer.parseInt(txtPracticalid.getText()));
                int n = pstmt.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, n + " record deleted successfully!");
                clearPracticalForm();
                showPracticals(null, null);
                con.close();
                stateInsertPractical();
                Log.insert("Practical", "Deleted", userid);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Exception in btnDeletepracticalActionPerformed: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnDeletepracticalActionPerformed

    private void btnInsertpracticalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertpracticalActionPerformed
        // TODO add your handling code here:
        if(btnInsertpractical.getText() == "Insert"){
            if(Validator.validatePractical(null, txtPracticalid, dtePracticalstartdate, dtePracticalenddate, cmbPracticalstudentid, cmbPracticalclassroomid)){
                try{
                    con = DB.getConnection();
                    PreparedStatement pstmt = con.prepareStatement("insert into tblpractical values(?, ?, ?, ?, ?, ?)");
                    SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
                    pstmt.setInt(1, Integer.parseInt(txtPracticalid.getText()));
                    pstmt.setString(2, dt.format(dtePracticalstartdate.getDate()).toString()+ " " + cmbPracticalstarttime.getSelectedItem());
                    pstmt.setString(3, dt.format(dtePracticalenddate.getDate()).toString()+ " " + cmbPracticalendtime.getSelectedItem());
                    pstmt.setString(4, cmbPracticalstudentid.getSelectedItem().toString());
                    pstmt.setString(5, cmbPracticalclassroomid.getSelectedItem().toString());
                    pstmt.setInt(6, userid);
                    int n = pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(this, n + " record inserted successfully!");
                    con.close();
                    clearPracticalForm();
                    showPracticals(null, null);
                    Log.insert("Practical", "Inserted", userid);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(this, "Exception in btnInsertpracticalActionPerformed(): " + ex.getMessage());
                }
            }
        }else{
            clearPracticalForm();
            stateInsertPractical();
        }
    }//GEN-LAST:event_btnInsertpracticalActionPerformed

    private void btnUpdatepaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdatepaymentActionPerformed
        // TODO add your handling code here:
        if(Validator.validatePayment(null, txtPaymentid, txtPaymentamount, dtePaymentdate, cmbPaymentstudentid)){
            try{
                con = DB.getConnection();
                PreparedStatement pstmt = con.prepareStatement("update tblpayment set amount=?, time=?, studentid=? where paymentid=?");
                SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
                pstmt.setString(1, txtPaymentamount.getText());
                pstmt.setString(2, dt.format(dtePaymentdate.getDate()).toString()+ " " + cmbPaymenttime.getSelectedItem());
                pstmt.setString(3, cmbPaymentstudentid.getSelectedItem().toString());
                pstmt.setInt(4, Integer.parseInt(txtPaymentid.getText()));
                int n = pstmt.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, n + " record updated successfully!");
                showPayments(null, null);
                con.close();
                Log.insert("Payment", "Updated", userid);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Exception in btnUpdatepaymentActionPerformed: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnUpdatepaymentActionPerformed

    private void btnDeletepaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletepaymentActionPerformed
        // TODO add your handling code here:
        int respond = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to delete this record?", "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if(respond == 0){
            try{
                con = DB.getConnection();
                PreparedStatement pstmt = con.prepareStatement("delete from tblpayment where paymentid=?");
                pstmt.setInt(1, Integer.parseInt(txtPaymentid.getText()));
                int n = pstmt.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, n + " record deleted successfully!");
                clearPaymentForm();
                showPayments(null, null);
                con.close();
                stateInsertPayment();
                Log.insert("Payment", "Deleted", userid);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Exception in btnDeletepaymentActionPerformed: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnDeletepaymentActionPerformed

    private void btnInsertpaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertpaymentActionPerformed
        // TODO add your handling code here:
        if(btnInsertpayment.getText() == "Insert"){
            if(Validator.validatePayment(null, txtPaymentid, txtPaymentamount, dtePaymentdate, cmbPaymentstudentid)){
                try{
                    con = DB.getConnection();
                    PreparedStatement pstmt = con.prepareStatement("insert into tblpayment values(?, ?, ?, ?, ?)");
                    SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
                    pstmt.setInt(1, Integer.parseInt(txtPaymentid.getText()));
                    pstmt.setString(2, txtPaymentamount.getText());
                    pstmt.setString(3, dt.format(dtePaymentdate.getDate()).toString()+ " " + cmbPaymenttime.getSelectedItem());
                    pstmt.setString(4, cmbPaymentstudentid.getSelectedItem().toString());
                    pstmt.setInt(5, userid);
                    int n = pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(this, n + " record inserted successfully!");
                    con.close();
                    clearPaymentForm();
                    showPayments(null, null);
                    Log.insert("Payment", "Inserted", userid);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(this, "Exception in btnInsertpaymentActionPerformed(): " + ex.getMessage());
                }
            }
        }else{
            clearPaymentForm();
            stateInsertPayment();
        }
    }//GEN-LAST:event_btnInsertpaymentActionPerformed

    private void btnUpdatemoduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdatemoduleActionPerformed
        // TODO add your handling code here:
        if(Validator.validateModule(null, txtModuleid, txtModulename, cmbModulelecturerid)){
            try{
                con = DB.getConnection();
                PreparedStatement pstmt = con.prepareStatement("update tblmodule set module_name=?, description=?, lecturerid=? where moduleid=?");
                pstmt.setString(1, txtModulename.getText());
                pstmt.setString(2, txtModuledescription.getText());
                pstmt.setString(3, cmbModulelecturerid.getSelectedItem().toString());
                pstmt.setInt(4, Integer.parseInt(txtModuleid.getText()));
                int n = pstmt.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, n + " record updated successfully!");
                showModules(null, null);
                con.close();
                Log.insert("Module", "Updated", userid);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Exception in btnUpdatemoduleActionPerformed: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnUpdatemoduleActionPerformed

    private void btnDeletemoduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletemoduleActionPerformed
        // TODO add your handling code here:
        int respond = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to delete this record?", "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if(respond == 0){
            try{
                con = DB.getConnection();
                PreparedStatement pstmt = con.prepareStatement("delete from tblmodule where moduleid=?");
                pstmt.setInt(1, Integer.parseInt(txtModuleid.getText()));
                int n = pstmt.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, n + " record deleted successfully!");
                clearModuleForm();
                showModules(null, null);
                con.close();
                stateInsertModule();
                Log.insert("Module", "Deleted", userid);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Exception in btnDeletemoduleActionPerformed: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnDeletemoduleActionPerformed

    private void btnInsertmoduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertmoduleActionPerformed
        // TODO add your handling code here:
        if(btnInsertmodule.getText() == "Insert"){
            if(Validator.validateModule(null, txtModuleid, txtModulename, cmbModulelecturerid)){
                try{
                    con = DB.getConnection();
                    PreparedStatement pstmt = con.prepareStatement("insert into tblmodule values(?, ?, ?, ?, ?)");
                    pstmt.setInt(1, Integer.parseInt(txtModuleid.getText()));
                    pstmt.setString(2, txtModulename.getText());
                    pstmt.setString(3, txtModuledescription.getText());
                    pstmt.setString(4, cmbModulelecturerid.getSelectedItem().toString());
                    pstmt.setInt(5, userid);
                    int n = pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(this, n + " record inserted successfully!");
                    con.close();
                    clearModuleForm();
                    showModules(null, null);
                    Log.insert("Module", "Inserted", userid);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(this, "Exception in btnInsertmoduleActionPerformed(): " + ex.getMessage());
                }
            }
        }else{
            clearModuleForm();
            stateInsertModule();
        }
    }//GEN-LAST:event_btnInsertmoduleActionPerformed

    private void btnUpdateexamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateexamActionPerformed
        // TODO add your handling code here:
        if(Validator.validateExam(null, txtExamid, dteExamstartdate, dteExamenddate, cmbExammoduleid)){
            try{
                con = DB.getConnection();
                PreparedStatement pstmt = con.prepareStatement("update tblexam set starttime=?, endtime=?, moduleid=? where examid=?");
                SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
                pstmt.setString(1, dt.format(dteExamstartdate.getDate()).toString()+ " " + cmbExamstarttime.getSelectedItem());
                pstmt.setString(2, dt.format(dteExamenddate.getDate()).toString()+ " " + cmbExamendtime.getSelectedItem());
                pstmt.setString(3, cmbExammoduleid.getSelectedItem().toString());
                pstmt.setInt(4, Integer.parseInt(txtExamid.getText()));
                int n = pstmt.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, n + " record updated successfully!");
                showExams(null, null);
                con.close();
                Log.insert("Exam", "Updated", userid);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Exception in btnUpdateexamActionPerformed: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnUpdateexamActionPerformed

    private void btnDeleteexamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteexamActionPerformed
        // TODO add your handling code here:
        int respond = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to delete this record?", "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if(respond == 0){
            try{
                con = DB.getConnection();
                PreparedStatement pstmt = con.prepareStatement("delete from tblexam where examid=?");
                pstmt.setInt(1, Integer.parseInt(txtExamid.getText()));
                int n = pstmt.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, n + " record deleted successfully!");
                clearExamForm();
                showExams(null, null);
                con.close();
                stateInsertExam();
                Log.insert("Exam", "Deleted", userid);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Exception in btnDeleteexamActionPerformed: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnDeleteexamActionPerformed

    private void btnInsertexamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertexamActionPerformed
        // TODO add your handling code here:
        if(btnInsertexam.getText() == "Insert"){
            if(Validator.validateExam(null, txtExamid, dteExamstartdate, dteExamenddate, cmbExammoduleid)){
                try{
                    con = DB.getConnection();
                    PreparedStatement pstmt = con.prepareStatement("insert into tblexam values(?, ?, ?, ?, ?)");
                    SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
                    pstmt.setInt(1, Integer.parseInt(txtExamid.getText()));
                    pstmt.setString(2, dt.format(dteExamstartdate.getDate()).toString()+ " " + cmbExamstarttime.getSelectedItem());
                    pstmt.setString(3, dt.format(dteExamenddate.getDate()).toString()+ " " + cmbExamendtime.getSelectedItem());
                    pstmt.setString(4, cmbExammoduleid.getSelectedItem().toString());
                    pstmt.setInt(5, userid);
                    int n = pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(this, n + " record inserted successfully!");
                    con.close();
                    clearExamForm();
                    showExams(null, null);
                    Log.insert("Exam", "Inserted", userid);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(this, "Exception in btnInsertexamActionPerformed(): " + ex.getMessage());
                }
            }
        }else{
            clearExamForm();
            stateInsertExam();
        }
    }//GEN-LAST:event_btnInsertexamActionPerformed

    private void btnUpdateassignmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateassignmentActionPerformed
        // TODO add your handling code here:
        if(Validator.validateAssignment(null, txtAssignmentid, txtAssignmentname, cmbAssignmentmoduleid)){
            try{
                con = DB.getConnection();
                PreparedStatement pstmt = con.prepareStatement("update tblassignment set assignment_name=?, description=?, moduleid=?, duedate=? where assignmentid=?");
                SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
                pstmt.setString(1, txtAssignmentname.getText());
                pstmt.setString(2, txtAssignmentdescription.getText());
                pstmt.setString(3, cmbAssignmentmoduleid.getSelectedItem().toString());
                pstmt.setString(4, dt.format(dteAssignmentduedate.getDate()).toString()+ " " + cmbAssignmentduetime.getSelectedItem());
                pstmt.setInt(5, Integer.parseInt(txtAssignmentid.getText()));
                int n = pstmt.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, n + " record updated successfully!");
                showAssignments(null, null);
                con.close();
                Log.insert("Assignment", "Updated", userid);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Exception in btnUpdateassignmentActionPerformed: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnUpdateassignmentActionPerformed

    private void btnDeleteassignmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteassignmentActionPerformed
        // TODO add your handling code here:
        int respond = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to delete this record?", "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if(respond == 0){
            try{
                con = DB.getConnection();
                PreparedStatement pstmt = con.prepareStatement("delete from tblassignment where examid=?");
                pstmt.setInt(1, Integer.parseInt(txtAssignmentid.getText()));
                int n = pstmt.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, n + " record deleted successfully!");
                clearAssignmentForm();
                showAssignments(null, null);
                con.close();
                stateInsertAssignment();
                Log.insert("Assignment", "Deleted", userid);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Exception in btnDeleteassignmentActionPerformed: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnDeleteassignmentActionPerformed

    private void btnInsertassignmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertassignmentActionPerformed
        // TODO add your handling code here:
        if(btnInsertassignment.getText() == "Insert"){
            if(Validator.validateAssignment(null, txtAssignmentid, txtAssignmentname, cmbAssignmentmoduleid)){
                try{
                    con = DB.getConnection();
                    PreparedStatement pstmt = con.prepareStatement("insert into tblassignment values(?, ?, ?, ?, ?, ?)");
                    SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
                    pstmt.setInt(1, Integer.parseInt(txtAssignmentid.getText()));
                    pstmt.setString(2, txtAssignmentname.getText());
                    pstmt.setString(3, txtAssignmentdescription.getText());
                    pstmt.setString(4, cmbAssignmentmoduleid.getSelectedItem().toString());
                    pstmt.setString(5, dt.format(dteAssignmentduedate.getDate()).toString()+ " " + cmbAssignmentduetime.getSelectedItem());
                    pstmt.setInt(6, userid);
                    int n = pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(this, n + " record inserted successfully!");
                    con.close();
                    clearAssignmentForm();
                    showAssignments(null, null);
                    Log.insert("Assignment", "Inserted", userid);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(this, "Exception in btnInsertassignmentActionPerformed(): " + ex.getMessage());
                }
            }
        }else{
            clearAssignmentForm();
            stateInsertAssignment();
        }
    }//GEN-LAST:event_btnInsertassignmentActionPerformed

    private void btnUpdatelectureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdatelectureActionPerformed
        // TODO add your handling code here:
        if(Validator.validateLecture(null, txtLectureid, dteLecturestartdate, dteLectureenddate, txtLecturedescription, txtLectureclassroomid, cmbLecturemoduleid)){
            try{
                con = DB.getConnection();
                PreparedStatement pstmt = con.prepareStatement("update tbllecture set starttime=?, endtime=?, description=?, classroomid=?, moduleid=? where lectureid=?");
                SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
                pstmt.setString(1, dt.format(dteLecturestartdate.getDate()).toString()+ " " + cmbLecturestarttime.getSelectedItem());
               pstmt.setString(2, dt.format(dteLectureenddate.getDate()).toString()+ " " + cmbLectureendtime.getSelectedItem());
                pstmt.setString(3, txtLecturedescription.getText());
                pstmt.setString(4, txtLectureclassroomid.getText());
                pstmt.setString(5, cmbLecturemoduleid.getSelectedItem().toString());
                pstmt.setInt(6, Integer.parseInt(txtLectureid.getText()));
                int n = pstmt.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, n + " record updated successfully!");
                showLectures(null, null);
                con.close();
                Log.insert("Lecture", "Updated", userid);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Exception in btnUpdatelectureActionPerformed: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnUpdatelectureActionPerformed

    private void btnDeletelectureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletelectureActionPerformed
        // TODO add your handling code here:
        int respond = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to delete this record?", "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if(respond == 0){
            try{
                con = DB.getConnection();
                PreparedStatement pstmt = con.prepareStatement("delete from tbllecture where lectureid=?");
                pstmt.setInt(1, Integer.parseInt(txtLectureid.getText()));
                int n = pstmt.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, n + " record deleted successfully!");
                clearLectureForm();
                showLectures(null, null);
                con.close();
                stateInsertLecture();
                Log.insert("Lecture", "Deleted", userid);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Exception in btnDeletelectureActionPerformed: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnDeletelectureActionPerformed

    private void btnInsertlectureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertlectureActionPerformed
        // TODO add your handling code here:
        if(btnInsertlecture.getText() == "Insert"){
            if(Validator.validateLecture(null, txtLectureid, dteLecturestartdate, dteLectureenddate, txtLecturedescription, txtLectureclassroomid, cmbLecturemoduleid)){
                try{
                    con = DB.getConnection();
                    PreparedStatement pstmt = con.prepareStatement("insert into tbllecture values(?, ?, ?, ?, ?, ?, ?)");
                    SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
                    pstmt.setInt(1, Integer.parseInt(txtLectureid.getText()));
                    pstmt.setString(2, dt.format(dteLecturestartdate.getDate()).toString()+ " " + cmbLecturestarttime.getSelectedItem());
                    pstmt.setString(3, dt.format(dteLectureenddate.getDate()).toString()+ " " + cmbLectureendtime.getSelectedItem());
                    pstmt.setString(4, txtLecturedescription.getText());
                    pstmt.setString(5, txtLectureclassroomid.getText());
                    pstmt.setString(6, cmbLecturemoduleid.getSelectedItem().toString());
                    pstmt.setInt(7, userid);
                    int n = pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(this, n + " record inserted successfully!");
                    con.close();
                    clearLectureForm();
                    showLectures(null, null);
                    Log.insert("Lecture", "Inserted", userid);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(this, "Exception in btnInsertlectureActionPerformed(): " + ex.getMessage());
                }
            }
        }else{
            clearLectureForm();
            stateInsertLecture();
        }
    }//GEN-LAST:event_btnInsertlectureActionPerformed

    private void btnUpdateuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateuserActionPerformed
        // TODO add your handling code here:
        if(Validator.validateUser(null, txtUserid, txtUsername, txtUseremail, txtUserpassword, cmbUsertype, cmbUserstatus)){
            try{
                con = DB.getConnection();
                PreparedStatement pstmt = con.prepareStatement("update tbluser set user_name=?, email=?, password=?, type=?, status=? where userid=?");
                pstmt.setString(1, txtUsername.getText());
                pstmt.setString(2, txtUseremail.getText());
                pstmt.setString(3, txtUserpassword.getText());
                pstmt.setString(4, cmbUsertype.getSelectedItem().toString());
                pstmt.setString(5, cmbUserstatus.getSelectedItem().toString());
                pstmt.setInt(6, Integer.parseInt(txtUserid.getText()));
                int n = pstmt.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, n + " record updated successfully!");
                showUsers(null, null);
                con.close();
                Log.insert("User", "Updated", userid);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Exception in btnUpdateuserActionPerformed: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnUpdateuserActionPerformed

    private void btnDeleteuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteuserActionPerformed
        // TODO add your handling code here:
        int respond = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to delete this record?", "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if(respond == 0){
            try{
                con = DB.getConnection();
                PreparedStatement pstmt = con.prepareStatement("delete from tbluser where userid=?");
                pstmt.setInt(1, Integer.parseInt(txtUserid.getText()));
                int n = pstmt.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, n + " record deleted successfully!");
                clearUserForm();
                showUsers(null, null);
                con.close();
                stateInsertUser();
                Log.insert("User", "Deleted", userid);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Exception in btnDeleteuserActionPerformed: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnDeleteuserActionPerformed

    private void btnInsertuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertuserActionPerformed
        // TODO add your handling code here:
        if(btnInsertuser.getText() == "Insert"){
            if(Validator.validateUser(null, txtUserid, txtUsername, txtUseremail, txtUserpassword, cmbUsertype, cmbUserstatus)){
                try{
                    con = DB.getConnection();
                    PreparedStatement pstmt = con.prepareStatement("insert into tbluser values(?, ?, ?, ?, ?, ?)");
                    pstmt.setInt(1, Integer.parseInt(txtUserid.getText()));
                    pstmt.setString(2, txtUsername.getText());
                    pstmt.setString(3, txtUseremail.getText());
                    pstmt.setString(4, txtUserpassword.getText());
                    pstmt.setString(5, cmbUsertype.getSelectedItem().toString());
                    pstmt.setString(6, cmbUserstatus.getSelectedItem().toString());
                    int n = pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(this, n + " record inserted successfully!");
                    con.close();
                    clearUserForm();
                    showUsers(null, null);
                    Log.insert("User", "Inserted", userid);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(this, "Exception in btnInsertuserActionPerformed(): " + ex.getMessage());
                }
            }
        }else{
            clearUserForm();
            stateInsertUser();
        }
    }//GEN-LAST:event_btnInsertuserActionPerformed

    private void tblClassroomsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClassroomsMouseClicked
        // TODO add your handling code here:
        try{
            con = DB.getConnection();
            int row = tblClassrooms.getSelectedRow();
            String selectedid = tblClassrooms.getModel().getValueAt(row, 0).toString();  
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from tblclassroom where classroomid = " + selectedid);
            if(rs.next()){
                txtClassroomid.setText(rs.getString("classroomid"));
                txtClassroomname.setText(rs.getString("room_name"));
                txtClassroomdescription.setText(rs.getString("description"));
                stateUpdateClassroom();
            }else{
                JOptionPane.showMessageDialog(this, "No record found");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Exception in tblClassroomsMouseClicked: " + ex.getMessage());
        }
    }//GEN-LAST:event_tblClassroomsMouseClicked

    private void txtSearchclassroomKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchclassroomKeyReleased
        // TODO add your handling code here:
        showClassrooms(cmbClassroomsearchin.getSelectedItem().toString(), txtSearchclassroom.getText());
    }//GEN-LAST:event_txtSearchclassroomKeyReleased

    private void txtClassroomidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClassroomidKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyChar()=='\n'){
            try{
                con = DB.getConnection();
                PreparedStatement pstmt = con.prepareStatement("select * from tblclassroom where classroomid=?");
                pstmt.setInt(1, Integer.parseInt(txtClassroomid.getText()));
                ResultSet rs = pstmt.executeQuery();
                if(rs.next()){
                    txtClassroomname.setText(rs.getString("room_name"));
                    txtClassroomdescription.setText(rs.getString("description"));
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Record not found!");
                }
                con.close();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Exception in txtClassroomidKeyPressed: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_txtClassroomidKeyPressed

    private void btnInsertClassroomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertClassroomActionPerformed
        // TODO add your handling code here:
        if(btnInsertClassroom.getText() == "Insert"){
            if(Validator.validateClassroom(null, txtClassroomid, txtClassroomname)){
                try{
                    con = DB.getConnection();
                    PreparedStatement pstmt = con.prepareStatement("insert into tblclassroom values(?, ?, ?, ?)");
                    pstmt.setInt(1, Integer.parseInt(txtClassroomid.getText()));
                    pstmt.setString(2, txtClassroomname.getText());
                    pstmt.setString(3, txtClassroomdescription.getText());
                    pstmt.setInt(4, userid);
                    int n = pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(this, n + " record inserted successfully!");
                    con.close();
                    clearClassroomForm();
                    showClassrooms(null, null);
                    Log.insert("Classroom", "Inserted", userid);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(this, "Exception in btnInsertClassroomActionPerformed(): " + ex.getMessage());
                }
            }
        }else{
            clearClassroomForm();
            stateInsertClassroom();
        }
    }//GEN-LAST:event_btnInsertClassroomActionPerformed

    private void btnDeleteClassroomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteClassroomActionPerformed
        // TODO add your handling code here:
        int respond = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to delete this record?", "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if(respond == 0){
            try{
                con = DB.getConnection();
                PreparedStatement pstmt = con.prepareStatement("delete from tblclassroom where classroomid=?");
                pstmt.setInt(1, Integer.parseInt(txtClassroomid.getText()));
                int n = pstmt.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, n + " record deleted successfully!");
                clearClassroomForm();
                showClassrooms(null, null);
                con.close();
                stateInsertClassroom();
                Log.insert("Classroom", "Deleted", userid);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Exception in btnDeleteClassroomActionPerformed: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnDeleteClassroomActionPerformed

    private void btnUpdateClassroomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateClassroomActionPerformed
        // TODO add your handling code here:
        if(Validator.validateClassroom(null, txtClassroomid, txtClassroomname)){
            try{
                con = DB.getConnection();
                PreparedStatement pstmt = con.prepareStatement("update tblclassroom set room_name=?, description=? where classroomid=?");
                pstmt.setString(1, txtClassroomname.getText());
                pstmt.setString(2, txtClassroomdescription.getText());
                pstmt.setInt(3, Integer.parseInt(txtClassroomid.getText()));
                int n = pstmt.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, n + " record updated successfully!");
                showClassrooms(null, null);
                con.close();
                Log.insert("Classroom", "updated", userid);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Exception in btnUpdateClassroomActionPerformed: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnUpdateClassroomActionPerformed

    private void btnRefreshlogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshlogActionPerformed
        // TODO add your handling code here:
        showLogs(null, null);
    }//GEN-LAST:event_btnRefreshlogActionPerformed

    private void tblBatchesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBatchesMouseClicked
        // TODO add your handling code here:
        try{
            con = DB.getConnection();
            int row = tblBatches.getSelectedRow();
            String selectedid = tblBatches.getModel().getValueAt(row, 0).toString();  
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from tblbatch where batchid = " + selectedid);
            if(rs.next()){
                stateUpdateBatch();
                txtBatchid.setText(rs.getString("batchid"));
                txtBatchname.setText(rs.getString("batch_name"));
                dteBatchstartdate.setDate(rs.getDate("startdate"));
            }else{
                JOptionPane.showMessageDialog(this, "No record found");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Exception in tblBatchesMouseClicked: " + ex.getMessage());
        }
    }//GEN-LAST:event_tblBatchesMouseClicked

    private void txtSearchbatchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchbatchKeyReleased
        // TODO add your handling code here:
        showBatches(cmbBatchsearchin.getSelectedItem().toString(), txtSearchbatch.getText());
    }//GEN-LAST:event_txtSearchbatchKeyReleased

    private void txtBatchidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBatchidKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyChar()=='\n'){
            try{
                con = DB.getConnection();
                PreparedStatement pstmt = con.prepareStatement("select * from tblbatch where batchid=?");
                pstmt.setInt(1, Integer.parseInt(txtBatchid.getText()));
                ResultSet rs = pstmt.executeQuery();
                if(rs.next()){
                    txtBatchname.setText(rs.getString("batch_name"));
                    dteBatchstartdate.setDate(rs.getDate("startdate"));
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Record not found!");
                }
                con.close();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Exception in txtBatchidKeyPressed: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_txtBatchidKeyPressed

    private void btnUpdateBatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateBatchActionPerformed
        // TODO add your handling code here:
        if(Validator.validateBatch(null, txtBatchid, txtBatchname, dteBatchstartdate)){
            try{
                con = DB.getConnection();
                PreparedStatement pstmt = con.prepareStatement("update tblbatch set batch_name=?, startdate=? where batchid=?");
                SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
                pstmt.setString(1, txtBatchname.getText());
                pstmt.setString(2, dt.format(dteBatchstartdate.getDate()).toString());
                pstmt.setInt(3, Integer.parseInt(txtBatchid.getText()));
                int n = pstmt.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, n + " record updated successfully!");
                showBatches(null, null);
                con.close();
                Log.insert("Batch", "updated", userid);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Exception in btnUpdateBatchActionPerformed: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnUpdateBatchActionPerformed

    private void btnDeleteBatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteBatchActionPerformed
        // TODO add your handling code here:
        int respond = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to delete this record?", "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if(respond == 0){
            try{
                con = DB.getConnection();
                PreparedStatement pstmt = con.prepareStatement("delete from tblbatch where batchid=?");
                pstmt.setInt(1, Integer.parseInt(txtBatchid.getText()));
                int n = pstmt.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, n + " record deleted successfully!");
                clearBatchForm();
                showBatches(null, null);
                con.close();
                stateInsertBatch();
                Log.insert("Batch", "Deleted", userid);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Exception in btnDeleteBatchActionPerformed: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnDeleteBatchActionPerformed

    private void btnInsertBatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertBatchActionPerformed
        // TODO add your handling code here:
        if(btnInsertBatch.getText() == "Insert"){
            if(Validator.validateBatch(null, txtBatchid, txtBatchname, dteBatchstartdate)){
                try{
                    con = DB.getConnection();
                    PreparedStatement pstmt = con.prepareStatement("insert into tblbatch values(?, ?, ?, ?)");
                    SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
                    pstmt.setInt(1, Integer.parseInt(txtBatchid.getText()));
                    pstmt.setString(2, txtBatchname.getText());
                    pstmt.setString(3, dt.format(dteBatchstartdate.getDate()).toString());
                    pstmt.setInt(4, userid);
                    int n = pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(this, n + " record inserted successfully!");
                    con.close();
                    clearBatchForm();
                    showBatches(null, null);
                    Log.insert("Batch", "Inserted", userid);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(this, "Exception in btnInsertBatchActionPerformed(): " + ex.getMessage());
                }
            }
        }else{
            clearBatchForm();
            stateInsertBatch();
        }
    }//GEN-LAST:event_btnInsertBatchActionPerformed

    private void tblStudentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStudentsMouseClicked
        // TODO add your handling code here:
        try{
            con = DB.getConnection();
            int row = tblStudents.getSelectedRow();
            String selectedid = tblStudents.getModel().getValueAt(row, 0).toString();  
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from tblstudent where studentid = " + selectedid);
            if(rs.next()){
                stateUpdateStudent();
                txtStudentid.setText(rs.getString("studentid"));
                txtStudentname.setText(rs.getString("student_name"));
                txtStudentaddress.setText(rs.getString("address"));
                cmbStudentgender.setSelectedItem(rs.getString("gender"));
                dteStudentbirthday.setDate(rs.getDate("birthday"));
                txtStudentemail.setText(rs.getString("email"));
                txtStudentphone.setText(rs.getString("phone"));
                txtStudentbackground.setText(rs.getString("background"));
                cmbStudentbatchid.setSelectedItem(rs.getString("batchid"));
                dteStudentregdate.setDate(rs.getDate("reg_date"));
            }else{
                JOptionPane.showMessageDialog(this, "No record found");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Exception in tblStudentsMouseClicked: " + ex.getMessage());
        }
    }//GEN-LAST:event_tblStudentsMouseClicked

    private void txtSearchstudentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchstudentKeyReleased
        // TODO add your handling code here:
        showStudents(cmbStudentsearchin.getSelectedItem().toString(), txtSearchstudent.getText());
    }//GEN-LAST:event_txtSearchstudentKeyReleased

    private void btnSendMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendMailActionPerformed
        String email, pwd, subject, msg;
        email= txtSenderEmail.getText();
        ResultSet to = null;
ResultSet rs = null;
     Connection con = DB.getConnection();
    PreparedStatement pst = null;
        try{
            String sql="SELECT email FROM tblstudent";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next())
            {
                to=rs;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        pwd= new String (txtSenderEmailPassword.getPassword());
        subject= txtSubject.getText();
        msg= txtMessage.getText();
        try {
            EmailClass.sendFromGMail(email, pwd, to, subject, msg);
        } catch (MessagingException ex) {
            Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSendMailActionPerformed

    private void tblStAssMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStAssMouseClicked
        // TODO add your handling code here:
        try{
            con = DB.getConnection();
            int row = tblStAss.getSelectedRow();
            String selectedid1 = tblStAss.getModel().getValueAt(row, 0).toString();  
            String selectedid2 = tblStAss.getModel().getValueAt(row, 1).toString();  
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from tblstudent_assignment where studentid = " + selectedid1 + " and assignmentid = " + selectedid2);
            if(rs.next()){
                stateUpdateStAss();
                cmbStAssStudentid.setSelectedItem(rs.getString("studentid"));
                cmbStAssAssignmentid.setSelectedItem(rs.getString("assignmentid"));
                txtStAssMarks.setText(rs.getString("marks"));
            }else{
                JOptionPane.showMessageDialog(this, "No record found");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Exception in tblStAssMouseClicked: " + ex.getMessage());
        }
    }//GEN-LAST:event_tblStAssMouseClicked

    private void txtSearchstassKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchstassKeyReleased
        // TODO add your handling code here:
        showStAss(cmbStAsssearchin.getSelectedItem().toString(), txtSearchstass.getText());
    }//GEN-LAST:event_txtSearchstassKeyReleased

    private void btnUpdateStAssActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateStAssActionPerformed
        // TODO add your handling code here:
        if(Validator.validateStAss(null, txtStAssMarks)){
            try{
                con = DB.getConnection();
                PreparedStatement pstmt = con.prepareStatement("update tblstudent_assignment set marks=? where studentid=? and assignmentid=?");
                pstmt.setInt(1, Integer.parseInt(txtStAssMarks.getText()));
                pstmt.setInt(2, Integer.parseInt(cmbStAssStudentid.getSelectedItem().toString()));
                pstmt.setInt(3, Integer.parseInt(cmbStAssAssignmentid.getSelectedItem().toString()));
                int n = pstmt.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, n + " record updated successfully!");
                showStAss(null, null);
                con.close();
                Log.insert("Student Assignment", "updated", userid);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Exception in btnUpdateStAssActionPerformed: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnUpdateStAssActionPerformed

    private void btnDeleteStAssActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteStAssActionPerformed
        // TODO add your handling code here:
        int respond = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to delete this record?", "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if(respond == 0){
            try{
                con = DB.getConnection();
                PreparedStatement pstmt = con.prepareStatement("delete from tblstudent_assignment where studentid=? and assignmentid=?");
                pstmt.setInt(1, Integer.parseInt(cmbStAssStudentid.getSelectedItem().toString()));
                pstmt.setInt(2, Integer.parseInt(cmbStAssAssignmentid.getSelectedItem().toString()));
                int n = pstmt.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, n + " record deleted successfully!");
                clearStAssForm();
                showStAss(null, null);
                con.close();
                stateInsertStAss();
                Log.insert("Student Assignment", "Deleted", userid);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Exception in btnDeleteStAssActionPerformed: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnDeleteStAssActionPerformed

    private void btnInsertStAssActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertStAssActionPerformed
        // TODO add your handling code here:
        if(btnInsertStAss.getText() == "Insert"){
            if(Validator.validateStAss(null, txtStAssMarks)){
                try{
                    con = DB.getConnection();
                    PreparedStatement pstmt = con.prepareStatement("insert into tblstudent_assignment values(?, ?, ?, ?)");
                    pstmt.setInt(1, Integer.parseInt(cmbStAssStudentid.getSelectedItem().toString()));
                    pstmt.setInt(2, Integer.parseInt(cmbStAssAssignmentid.getSelectedItem().toString()));
                    pstmt.setDouble(3, Integer.parseInt(txtStAssMarks.getText()));
                    pstmt.setInt(4, userid);
                    int n = pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(this, n + " record inserted successfully!");
                    con.close();
                    clearStAssForm();
                    showStAss(null, null);
                    Log.insert("Student Assignment", "Inserted", userid);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(this, "Exception in btnInsertStAssActionPerformed(): " + ex.getMessage());
                }
            }
        }else{
            clearStAssForm();
            stateInsertStAss();
        }
    }//GEN-LAST:event_btnInsertStAssActionPerformed

    private void btnUpdateStExamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateStExamActionPerformed
        // TODO add your handling code here:
        if(Validator.validateStExam(null, txtStExamMarks)){
            try{
                con = DB.getConnection();
                PreparedStatement pstmt = con.prepareStatement("update tblstudent_exam set marks=? where studentid=? and examid=?");
                pstmt.setInt(1, Integer.parseInt(txtStExamMarks.getText()));
                pstmt.setInt(2, Integer.parseInt(cmbStExamStudentid.getSelectedItem().toString()));
                pstmt.setInt(3, Integer.parseInt(cmbStExamExamid.getSelectedItem().toString()));
                int n = pstmt.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, n + " record updated successfully!");
                showStExams(null, null);
                con.close();
                Log.insert("Student Exam", "updated", userid);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Exception in btnUpdateStExamActionPerformed: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnUpdateStExamActionPerformed

    private void btnDeleteStExamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteStExamActionPerformed
        // TODO add your handling code here:
        int respond = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to delete this record?", "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if(respond == 0){
            try{
                con = DB.getConnection();
                PreparedStatement pstmt = con.prepareStatement("delete from tblstudent_exam where studentid=? and examid=?");
                pstmt.setInt(1, Integer.parseInt(cmbStExamStudentid.getSelectedItem().toString()));
                pstmt.setInt(2, Integer.parseInt(cmbStExamExamid.getSelectedItem().toString()));
                int n = pstmt.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, n + " record deleted successfully!");
                clearStExamForm();
                showStExams(null, null);
                con.close();
                stateInsertStExam();
                Log.insert("Student Exam", "Deleted", userid);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Exception in btnDeleteStExamActionPerformed: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnDeleteStExamActionPerformed

    private void btnInsertStExamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertStExamActionPerformed
        // TODO add your handling code here:
        if(btnInsertStExam.getText() == "Insert"){
            if(Validator.validateStExam(null, txtStExamMarks)){
                try{
                    con = DB.getConnection();
                    PreparedStatement pstmt = con.prepareStatement("insert into tblstudent_exam values(?, ?, ?, ?)");
                    pstmt.setInt(1, Integer.parseInt(cmbStExamStudentid.getSelectedItem().toString()));
                    pstmt.setInt(2, Integer.parseInt(cmbStExamExamid.getSelectedItem().toString()));
                    pstmt.setDouble(3, Integer.parseInt(txtStExamMarks.getText()));
                    pstmt.setInt(4, userid);
                    int n = pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(this, n + " record inserted successfully!");
                    con.close();
                    clearStExamForm();
                    showStExams(null, null);
                    Log.insert("Student Exam", "Inserted", userid);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(this, "Exception in btnInsertStExamActionPerformed(): " + ex.getMessage());
                }
            }
        }else{
            clearStExamForm();
            stateInsertStExam();
        }
    }//GEN-LAST:event_btnInsertStExamActionPerformed

    private void tblStExamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStExamMouseClicked
        // TODO add your handling code here:
        try{
            con = DB.getConnection();
            int row = tblStExam.getSelectedRow();
            String selectedid1 = tblStExam.getModel().getValueAt(row, 0).toString();  
            String selectedid2 = tblStExam.getModel().getValueAt(row, 1).toString();  
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from tblstudent_exam where studentid = " + selectedid1 + " and examid = " + selectedid2);
            if(rs.next()){
                stateUpdateStExam();
                cmbStExamStudentid.setSelectedItem(rs.getString("studentid"));
                cmbStExamExamid.setSelectedItem(rs.getString("examid"));
                txtStExamMarks.setText(rs.getString("marks"));
            }else{
                JOptionPane.showMessageDialog(this, "No record found");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Exception in tblStExamMouseClicked: " + ex.getMessage());
        }
    }//GEN-LAST:event_tblStExamMouseClicked

    private void txtSearchstexamKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchstexamKeyReleased
        // TODO add your handling code here:
        showStExams(cmbStExamsearchin.getSelectedItem().toString(), txtSearchstexam.getText());
    }//GEN-LAST:event_txtSearchstexamKeyReleased

    private void tblCourseModulesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCourseModulesMouseClicked
        // TODO add your handling code here:
        try{
            con = DB.getConnection();
            int row = tblCourseModules.getSelectedRow();
            String selectedid1 = tblCourseModules.getModel().getValueAt(row, 0).toString();  
            String selectedid2 = tblCourseModules.getModel().getValueAt(row, 1).toString();  
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from tblcourse_module where courseid = " + selectedid1 + " and moduleid = " + selectedid2);
            if(rs.next()){
                stateUpdateCourseModule();
                cmbCourseModuleCourseid.setSelectedItem(rs.getString("courseid"));
                cmbCourseModuleModuleid.setSelectedItem(rs.getString("moduleid"));
            }else{
                JOptionPane.showMessageDialog(this, "No record found");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Exception in tblCourseModulesMouseClicked: " + ex.getMessage());
        }
    }//GEN-LAST:event_tblCourseModulesMouseClicked

    private void txtSearchcoursemoduleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchcoursemoduleKeyReleased
        // TODO add your handling code here:
        showCourseModules(cmbCourseModulesearchin.getSelectedItem().toString(), txtSearchcoursemodule.getText());
    }//GEN-LAST:event_txtSearchcoursemoduleKeyReleased

    private void btnDeleteCourseModuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCourseModuleActionPerformed
        // TODO add your handling code here:
        int respond = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to delete this record?", "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if(respond == 0){
            try{
                con = DB.getConnection();
                PreparedStatement pstmt = con.prepareStatement("delete from tblcourse_module where courseid=? and moduleid=?");
                pstmt.setInt(1, Integer.parseInt(cmbCourseModuleCourseid.getSelectedItem().toString()));
                pstmt.setInt(2, Integer.parseInt(cmbCourseModuleModuleid.getSelectedItem().toString()));
                int n = pstmt.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, n + " record deleted successfully!");
                clearCourseModuleForm();
                showCourseModules(null, null);
                con.close();
                stateInsertCourseModule();
                Log.insert("Course Module", "Deleted", userid);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Exception in btnDeleteCourseModuleActionPerformed: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnDeleteCourseModuleActionPerformed

    private void btnInsertCourseModuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertCourseModuleActionPerformed
        // TODO add your handling code here:
        if(btnInsertCourseModule.getText() == "Insert"){
            if(Validator.validateCourseModule(null, cmbCourseModuleCourseid, cmbCourseModuleModuleid)){
                try{
                    con = DB.getConnection();
                    PreparedStatement pstmt = con.prepareStatement("insert into tblcourse_module values(?, ?, ?)");
                    pstmt.setInt(1, Integer.parseInt(cmbCourseModuleCourseid.getSelectedItem().toString()));
                    pstmt.setInt(2, Integer.parseInt(cmbCourseModuleModuleid.getSelectedItem().toString()));
                    pstmt.setInt(3, userid);
                    int n = pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(this, n + " record inserted successfully!");
                    con.close();
                    clearCourseModuleForm();
                    showCourseModules(null, null);
                    Log.insert("Course Module", "Inserted", userid);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(this, "Exception in btnInsertCourseModuleActionPerformed(): " + ex.getMessage());
                }
            }
        }else{
            clearCourseModuleForm();
            stateInsertCourseModule();
        }
    }//GEN-LAST:event_btnInsertCourseModuleActionPerformed

    private void btnUpdateStAttendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateStAttendanceActionPerformed
        // TODO add your handling code here:
        if(Validator.validateAttendance(null, cmbStAttendanceStudentid, cmbStAttendanceLectureid, dteStAttendancedate)){
            try{
                con = DB.getConnection();
                PreparedStatement pstmt = con.prepareStatement("update tblattendance set time=? where studentid=? and lectureid=?");
                SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
                pstmt.setString(1, dt.format(dteStAttendancedate.getDate()).toString()+ " " + cmbStAttendancetime.getSelectedItem());
                pstmt.setString(2, cmbStAttendanceStudentid.getSelectedItem().toString());
                pstmt.setString(3, cmbStAttendanceLectureid.getSelectedItem().toString());
                int n = pstmt.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, n + " record updated successfully!");
                showStAttendance(null, null);
                con.close();
                Log.insert("Student Attendance", "updated", userid);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Exception in btnUpdateStAttendanceActionPerformed: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnUpdateStAttendanceActionPerformed

    private void btnDeleteStAttendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteStAttendanceActionPerformed
        // TODO add your handling code here:
        int respond = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to delete this record?", "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if(respond == 0){
            try{
                con = DB.getConnection();
                PreparedStatement pstmt = con.prepareStatement("delete from tblattendance where studentid=? and lectureid=?");
                pstmt.setInt(1, Integer.parseInt(cmbStAttendanceStudentid.getSelectedItem().toString()));
                pstmt.setInt(2, Integer.parseInt(cmbStAttendanceLectureid.getSelectedItem().toString()));
                int n = pstmt.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, n + " record deleted successfully!");
                clearStAttendanceForm();
                showStAttendance(null, null);
                con.close();
                stateInsertStAttendance();
                Log.insert("Student Attendance", "Deleted", userid);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Exception in btnDeleteStAttendanceActionPerformed: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnDeleteStAttendanceActionPerformed

    private void btnInsertStAttendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertStAttendanceActionPerformed
        // TODO add your handling code here:
        if(btnInsertStAttendance.getText() == "Insert"){
            if(Validator.validateAttendance(null, cmbStAttendanceStudentid, cmbStAttendanceLectureid, dteStAttendancedate)){
                try{
                    con = DB.getConnection();
                    PreparedStatement pstmt = con.prepareStatement("insert into tblattendance values(?, ?, ?, ?)");
                    SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
                    pstmt.setInt(1, Integer.parseInt(cmbStAttendanceStudentid.getSelectedItem().toString()));
                    pstmt.setInt(2, Integer.parseInt(cmbStAttendanceLectureid.getSelectedItem().toString()));
                    pstmt.setString(3, dt.format(dteStAttendancedate.getDate()).toString()+ " " + cmbStAttendancetime.getSelectedItem());
                    pstmt.setInt(4, userid);
                    int n = pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(this, n + " record inserted successfully!");
                    con.close();
                    clearStAttendanceForm();
                    showStAttendance(null, null);
                    Log.insert("Student Attendance", "Inserted", userid);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(this, "Exception in btnInsertStAttendanceActionPerformed(): " + ex.getMessage());
                }
            }
        }else{
            clearStAttendanceForm();
            stateInsertStAttendance();
        }
    }//GEN-LAST:event_btnInsertStAttendanceActionPerformed

    private void tblStAttendanceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStAttendanceMouseClicked
        // TODO add your handling code here:
        try{
            con = DB.getConnection();
            int row = tblStAttendance.getSelectedRow();
            String selectedid1 = tblStAttendance.getModel().getValueAt(row, 0).toString();  
            String selectedid2 = tblStAttendance.getModel().getValueAt(row, 1).toString();  
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from tblattendance where studentid = " + selectedid1 + " and lectureid = " + selectedid2);
            if(rs.next()){
                stateUpdateStAttendance();
                cmbStAttendanceStudentid.setSelectedItem(rs.getString("studentid"));
                cmbStAttendanceLectureid.setSelectedItem(rs.getString("lectureid"));
                dteStAttendancedate.setDate(rs.getDate("time"));
            }else{
                JOptionPane.showMessageDialog(this, "No record found");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Exception in tblStAttendanceMouseClicked: " + ex.getMessage());
        }
    }//GEN-LAST:event_tblStAttendanceMouseClicked

    private void txtSearchstattendanceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchstattendanceKeyReleased
        // TODO add your handling code here:
        showStAttendance(cmbStAttendancesearchin.getSelectedItem().toString(), txtSearchstattendance.getText());
    }//GEN-LAST:event_txtSearchstattendanceKeyReleased

    private void btnUpdateStCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateStCourseActionPerformed
        // TODO add your handling code here:
        if(Validator.validateStCourse(null, txtStCourseFee)){
            try{
                con = DB.getConnection();
                PreparedStatement pstmt = con.prepareStatement("update tblstudent_course set fee=? where studentid=? and courseid=?");
                pstmt.setInt(1, Integer.parseInt(txtStCourseFee.getText()));
                pstmt.setInt(2, Integer.parseInt(cmbStCourseStudentid.getSelectedItem().toString()));
                pstmt.setInt(3, Integer.parseInt(cmbStCourseCourseid.getSelectedItem().toString()));
                int n = pstmt.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, n + " record updated successfully!");
                showStCourses(null, null);
                con.close();
                Log.insert("Student Course", "updated", userid);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Exception in btnUpdateStCourseActionPerformed: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnUpdateStCourseActionPerformed

    private void btnDeleteStCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteStCourseActionPerformed
        // TODO add your handling code here:
        int respond = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to delete this record?", "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if(respond == 0){
            try{
                con = DB.getConnection();
                PreparedStatement pstmt = con.prepareStatement("delete from tblstudent_course where studentid=? and courseid=?");
                pstmt.setInt(1, Integer.parseInt(cmbStCourseStudentid.getSelectedItem().toString()));
                pstmt.setInt(2, Integer.parseInt(cmbStCourseCourseid.getSelectedItem().toString()));
                int n = pstmt.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, n + " record deleted successfully!");
                clearStCourseForm();
                showStCourses(null, null);
                con.close();
                stateInsertStCourse();
                Log.insert("Student Course", "Deleted", userid);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Exception in btnDeleteStCourseActionPerformed: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnDeleteStCourseActionPerformed

    private void btnInsertStCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertStCourseActionPerformed
        // TODO add your handling code here:
        if(btnInsertStCourse.getText() == "Insert"){
            if(Validator.validateStCourse(null, txtStCourseFee)){
                try{
                    con = DB.getConnection();
                    PreparedStatement pstmt = con.prepareStatement("insert into tblstudent_course values(?, ?, ?, ?)");
                    pstmt.setInt(1, Integer.parseInt(cmbStCourseCourseid.getSelectedItem().toString()));
                    pstmt.setInt(2, Integer.parseInt(cmbStCourseStudentid.getSelectedItem().toString()));
                    pstmt.setDouble(3, Integer.parseInt(txtStCourseFee.getText()));
                    pstmt.setInt(4, userid);
                    int n = pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(this, n + " record inserted successfully!");
                    con.close();
                    clearStCourseForm();
                    showStCourses(null, null);
                    Log.insert("Student Course", "Inserted", userid);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(this, "Exception in btnInsertStCourseActionPerformed(): " + ex.getMessage());
                }
            }
        }else{
            clearStCourseForm();
            stateInsertStCourse();
        }
    }//GEN-LAST:event_btnInsertStCourseActionPerformed

    private void tblStCourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStCourseMouseClicked
        // TODO add your handling code here:
        try{
            con = DB.getConnection();
            int row = tblStCourse.getSelectedRow();
            String selectedid1 = tblStCourse.getModel().getValueAt(row, 0).toString();  
            String selectedid2 = tblStCourse.getModel().getValueAt(row, 1).toString();  
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from tblstudent_course where courseid = " + selectedid1 + " and studentid = " + selectedid2);
            if(rs.next()){
                stateUpdateStCourse();
                cmbStCourseStudentid.setSelectedItem(rs.getString("studentid"));
                cmbStCourseCourseid.setSelectedItem(rs.getString("courseid"));
                txtStCourseFee.setText(rs.getString("fee"));
            }else{
                JOptionPane.showMessageDialog(this, "No record found");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Exception in tblStCourseMouseClicked: " + ex.getMessage());
        }
    }//GEN-LAST:event_tblStCourseMouseClicked

    private void txtSearchstcourseKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchstcourseKeyReleased
        // TODO add your handling code here:
        showStCourses(cmbStCoursesearchin.getSelectedItem().toString(), txtSearchstcourse.getText());
    }//GEN-LAST:event_txtSearchstcourseKeyReleased

    private void btnAllStudentsReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllStudentsReportActionPerformed
        // TODO add your handling code here:
        //getClass().getResource("/res/lectures.png")
        ViewReport r = new ViewReport("C:\\Users\\koshila\\Documents\\NetBeansProjects\\Academy Management System\\src\\jreport\\rptAllStudents.jasper");
        r.setVisible(true); 
    }//GEN-LAST:event_btnAllStudentsReportActionPerformed

    private void btnStudentAssignmentsReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentAssignmentsReportActionPerformed
        // TODO add your handling code here:
        ViewReport r = new ViewReport("C:\\Users\\koshila\\Documents\\NetBeansProjects\\Academy Management System\\src\\jreport\\rptStudentAssignments.jasper");
        r.setVisible(true); 
    }//GEN-LAST:event_btnStudentAssignmentsReportActionPerformed
 
    private void btnStudentExamsReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentExamsReportActionPerformed
        // TODO add your handling code here:
        ViewReport r = new ViewReport("C:\\Users\\koshila\\Documents\\NetBeansProjects\\Academy Management System\\src\\jreport\\rptStudentExams.jasper");
        r.setVisible(true); 
    }//GEN-LAST:event_btnStudentExamsReportActionPerformed

    private void btnStudentAssignmentReport2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentAssignmentReport2ActionPerformed
        // TODO add your handling code here:
        HashMap para = new HashMap();
        para.put("studentid", txtAssignmentReportStudentid.getText());
        ViewReport r = new ViewReport("C:\\Users\\koshila\\Documents\\NetBeansProjects\\Academy Management System\\src\\jreport\\rptStudentAssignment2.jasper", para);
        r.setVisible(true); 
    }//GEN-LAST:event_btnStudentAssignmentReport2ActionPerformed

    private void btnStudentExamsReport2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentExamsReport2ActionPerformed
        // TODO add your handling code here:
        HashMap para = new HashMap();
        para.put("studentid", txtAssignmentReportStudentid.getText());
        ViewReport r = new ViewReport("C:\\Users\\koshila\\Documents\\NetBeansProjects\\Academy Management System\\src\\jreport\\StudentExamsReport2.jasper", para);
        r.setVisible(true); 
    }//GEN-LAST:event_btnStudentExamsReport2ActionPerformed

    private void btnStudentPaymentsReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentPaymentsReportActionPerformed
        // TODO add your handling code here:
        HashMap para = new HashMap();
        para.put("studentid", txtPaymentReportStudentid.getText());
        ViewReport r = new ViewReport("C:\\Users\\koshila\\Documents\\NetBeansProjects\\Academy Management System\\src\\jreport\\rptStudentPayments.jasper", para);
        r.setVisible(true); 
    }//GEN-LAST:event_btnStudentPaymentsReportActionPerformed

    private void btnAllPaymentsReport1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllPaymentsReport1ActionPerformed
        // TODO add your handling code here:
        ViewReport r = new ViewReport("C:\\Users\\koshila\\Documents\\NetBeansProjects\\Academy Management System\\src\\jreport\\rptAllPayments.jasper");
        r.setVisible(true); 
    }//GEN-LAST:event_btnAllPaymentsReport1ActionPerformed

    private void btnBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackupActionPerformed
        // TODO add your handling code here:
        Backup.Backupdbtosql();
    }//GEN-LAST:event_btnBackupActionPerformed

    private void btnRestoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestoreActionPerformed
        // TODO add your handling code here:
        Backup.Restoredbfromsql(txtSqlDump.getText());
    }//GEN-LAST:event_btnRestoreActionPerformed

    private void btnStudentBatchReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentBatchReportActionPerformed
        // TODO add your handling code here:
        HashMap para = new HashMap();
        para.put("batchid", txtBatchReportStudentid.getText());
        ViewReport r = new ViewReport("C:\\Users\\koshila\\Documents\\NetBeansProjects\\Academy Management System\\src\\jreport\\rptBatchStudents.jasper", para);
        r.setVisible(true); 
    }//GEN-LAST:event_btnStudentBatchReportActionPerformed

    private void btnAllCoursesReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllCoursesReportActionPerformed
        // TODO add your handling code here:
        ViewReport r = new ViewReport("C:\\Users\\koshila\\Documents\\NetBeansProjects\\Academy Management System\\src\\jreport\\rptAllCourses.jasper");
        r.setVisible(true); 
    }//GEN-LAST:event_btnAllCoursesReportActionPerformed

    private void btnAllBatchesReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllBatchesReportActionPerformed
        // TODO add your handling code here:
        ViewReport r = new ViewReport("C:\\Users\\koshila\\Documents\\NetBeansProjects\\Academy Management System\\src\\jreport\\rptAllBatches.jasper");
        r.setVisible(true); 
    }//GEN-LAST:event_btnAllBatchesReportActionPerformed

    private void btnCourseStudentsReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCourseStudentsReportActionPerformed
        // TODO add your handling code here:
        HashMap para = new HashMap();
        para.put("courseid", txtCourseStudentReportCourseid.getText());
        ViewReport r = new ViewReport("C:\\Users\\koshila\\Documents\\NetBeansProjects\\Academy Management System\\src\\jreport\\rptCourseStudents.jasper", para);
        r.setVisible(true); 
    }//GEN-LAST:event_btnCourseStudentsReportActionPerformed

    private void tblStBatchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStBatchMouseClicked
        // TODO add your handling code here:
        try{
            con = DB.getConnection();
            int row = tblStBatch.getSelectedRow();
            String selectedid1 = tblStBatch.getModel().getValueAt(row, 0).toString();  
            String selectedid2 = tblStBatch.getModel().getValueAt(row, 1).toString();  
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from tblstudent_batch where batchid = " + selectedid1 + " and studentid = " + selectedid2);
            if(rs.next()){
                stateUpdateStBatch();
                cmbStBatchStudentid.setSelectedItem(rs.getString("studentid"));
                cmbStBatchBatchid.setSelectedItem(rs.getString("batchid"));
            }else{
                JOptionPane.showMessageDialog(this, "No record found");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Exception in tblStBatchMouseClicked: " + ex.getMessage());
        }
    }//GEN-LAST:event_tblStBatchMouseClicked

    private void txtSearchstbatchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchstbatchKeyReleased
        // TODO add your handling code here:
        showStBatches(cmbStBatchsearchin.getSelectedItem().toString(), txtSearchstbatch.getText());
    }//GEN-LAST:event_txtSearchstbatchKeyReleased

    private void btnDeleteStBatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteStBatchActionPerformed
        // TODO add your handling code here:
        int respond = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to delete this record?", "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if(respond == 0){
            try{
                con = DB.getConnection();
                PreparedStatement pstmt = con.prepareStatement("delete from tblstudent_batch where studentid=? and batchid=?");
                pstmt.setInt(1, Integer.parseInt(cmbStBatchStudentid.getSelectedItem().toString()));
                pstmt.setInt(2, Integer.parseInt(cmbStBatchBatchid.getSelectedItem().toString()));
                int n = pstmt.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, n + " record deleted successfully!");
                clearStBatchForm();
                showStBatches(null, null);
                con.close();
                stateInsertStBatch();
                Log.insert("Student Batch", "Deleted", userid);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Exception in btnDeleteStBatchActionPerformed: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnDeleteStBatchActionPerformed

    private void btnInsertStBatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertStBatchActionPerformed
        // TODO add your handling code here:
        if(btnInsertStBatch.getText() == "Insert"){
            if(Validator.validateStudentBatch(null, cmbStBatchStudentid, cmbStBatchBatchid)){
                try{
                    con = DB.getConnection();
                    PreparedStatement pstmt = con.prepareStatement("insert into tblstudent_batch values(?, ?, ?)");
                    pstmt.setInt(1, Integer.parseInt(cmbStBatchBatchid.getSelectedItem().toString()));
                    pstmt.setInt(2, Integer.parseInt(cmbStBatchStudentid.getSelectedItem().toString()));
                    pstmt.setInt(3, userid);
                    int n = pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(this, n + " record inserted successfully!");
                    con.close();
                    clearStBatchForm();
                    showStBatches(null, null);
                    Log.insert("Student Batch", "Inserted", userid);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(this, "Exception in btnInsertStBatchActionPerformed(): " + ex.getMessage());
                }
            }
        }else{
            clearStBatchForm();
            stateInsertStBatch();
        }
    }//GEN-LAST:event_btnInsertStBatchActionPerformed

    private void btnDeleteCourseBatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCourseBatchActionPerformed
        // TODO add your handling code here:
        int respond = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to delete this record?", "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if(respond == 0){
            try{
                con = DB.getConnection();
                PreparedStatement pstmt = con.prepareStatement("delete from tblcourse_batch where courseid=? and batchid=?");
                pstmt.setInt(1, Integer.parseInt(cmbCourseBatchCourseid.getSelectedItem().toString()));
                pstmt.setInt(2, Integer.parseInt(cmbCourseBatchBatchid.getSelectedItem().toString()));
                int n = pstmt.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, n + " record deleted successfully!");
                clearCourseBatchForm();
                showCourseBatches(null, null);
                con.close();
                stateInsertCourseBatch();
                Log.insert("Course Batch", "Deleted", userid);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Exception in btnDeleteCourseBatchActionPerformed: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnDeleteCourseBatchActionPerformed

    private void btnInsertCourseBatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertCourseBatchActionPerformed
        // TODO add your handling code here:
        if(btnInsertCourseBatch.getText() == "Insert"){
            if(Validator.validateCourseBatch(null, cmbCourseBatchCourseid, cmbCourseBatchBatchid)){
                try{
                    con = DB.getConnection();
                    PreparedStatement pstmt = con.prepareStatement("insert into tblcourse_batch values(?, ?, ?)");
                    pstmt.setInt(1, Integer.parseInt(cmbCourseBatchCourseid.getSelectedItem().toString()));
                    pstmt.setInt(2, Integer.parseInt(cmbCourseBatchBatchid.getSelectedItem().toString()));
                    pstmt.setInt(3, userid);
                    int n = pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(this, n + " record inserted successfully!");
                    con.close();
                    clearCourseBatchForm();
                    showCourseBatches(null, null);
                    Log.insert("Course Batch", "Inserted", userid);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(this, "Exception in btnInsertCourseBatchActionPerformed(): " + ex.getMessage());
                }
            }
        }else{
            clearCourseBatchForm();
            stateInsertCourseBatch();
        }
    }//GEN-LAST:event_btnInsertCourseBatchActionPerformed

    private void tblCourseBatchesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCourseBatchesMouseClicked
        // TODO add your handling code here:
        try{
            con = DB.getConnection();
            int row = tblCourseBatches.getSelectedRow();
            String selectedid1 = tblCourseBatches.getModel().getValueAt(row, 0).toString();  
            String selectedid2 = tblCourseBatches.getModel().getValueAt(row, 1).toString();  
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from tblcourse_batch where courseid = " + selectedid1 + " and batchid = " + selectedid2);
            if(rs.next()){
                stateUpdateCourseBatch();
                cmbCourseBatchCourseid.setSelectedItem(rs.getString("courseid"));
                cmbCourseBatchBatchid.setSelectedItem(rs.getString("batchid"));
            }else{
                JOptionPane.showMessageDialog(this, "No record found");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Exception in tblCourseBatchesMouseClicked: " + ex.getMessage());
        }
    }//GEN-LAST:event_tblCourseBatchesMouseClicked

    private void txtSearchcoursebatchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchcoursebatchKeyReleased
        // TODO add your handling code here:
        showCourseBatches(cmbCourseBatchsearchin.getSelectedItem().toString(), txtSearchcoursebatch.getText());
    }//GEN-LAST:event_txtSearchcoursebatchKeyReleased

    private void btnClearLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearLogActionPerformed
        // TODO add your handling code here:
        int respond = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to delete this record?", "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if(respond == 0){
            try{
                con = DB.getConnection();
                PreparedStatement pstmt = con.prepareStatement("delete from tbllog");
                int n = pstmt.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, n + " record deleted successfully!");
                showLogs(null, null);
                con.close();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane, "Exception in btnClearLogActionPerformed: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnClearLogActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        
        /*try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
        //</editor-fold> 

        /* Create and display the form */
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainUI(usertype, userid).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AboutPanel;
    private javax.swing.JPanel AssignmentsPanel;
    private javax.swing.JPanel BatchesPanel;
    private javax.swing.JPanel ClassroomsPanel;
    private javax.swing.JPanel CoursesPanel;
    private javax.swing.JPanel DepartmentsPanel;
    private javax.swing.JPanel ExamsPanel;
    private javax.swing.JPanel LecturersPanel;
    private javax.swing.JPanel LecturesPanel;
    private javax.swing.JPanel LogsPanel;
    private javax.swing.JPanel ModulesPanel;
    private javax.swing.JPanel PaymentsPanel;
    private javax.swing.JPanel PracticalsPanel;
    private javax.swing.JPanel ReportsPanel;
    private javax.swing.JPanel StudentsPanel;
    private javax.swing.JTabbedPane TabbedPane;
    private javax.swing.JPanel ToolsPanel;
    private javax.swing.JPanel UsersPanel;
    private javax.swing.JButton btnAllBatchesReport;
    private javax.swing.JButton btnAllCoursesReport;
    private javax.swing.JButton btnAllPaymentsReport1;
    private javax.swing.JButton btnAllStudentsReport;
    private javax.swing.JButton btnBackup;
    private javax.swing.JButton btnClearLog;
    private javax.swing.JButton btnCourseStudentsReport;
    private javax.swing.JButton btnDeleteBatch;
    private javax.swing.JButton btnDeleteClassroom;
    private javax.swing.JButton btnDeleteCourseBatch;
    private javax.swing.JButton btnDeleteCourseModule;
    private javax.swing.JButton btnDeleteDepartment;
    private javax.swing.JButton btnDeleteStAss;
    private javax.swing.JButton btnDeleteStAttendance;
    private javax.swing.JButton btnDeleteStBatch;
    private javax.swing.JButton btnDeleteStCourse;
    private javax.swing.JButton btnDeleteStExam;
    private javax.swing.JButton btnDeleteassignment;
    private javax.swing.JButton btnDeletecourse;
    private javax.swing.JButton btnDeleteexam;
    private javax.swing.JButton btnDeletelecture;
    private javax.swing.JButton btnDeletelecturer;
    private javax.swing.JButton btnDeletemodule;
    private javax.swing.JButton btnDeletepayment;
    private javax.swing.JButton btnDeletepractical;
    private javax.swing.JButton btnDeletestudent;
    private javax.swing.JButton btnDeleteuser;
    private javax.swing.JButton btnInsertBatch;
    private javax.swing.JButton btnInsertClassroom;
    private javax.swing.JButton btnInsertCourseBatch;
    private javax.swing.JButton btnInsertCourseModule;
    private javax.swing.JButton btnInsertDepartment;
    private javax.swing.JButton btnInsertStAss;
    private javax.swing.JButton btnInsertStAttendance;
    private javax.swing.JButton btnInsertStBatch;
    private javax.swing.JButton btnInsertStCourse;
    private javax.swing.JButton btnInsertStExam;
    private javax.swing.JButton btnInsertassignment;
    private javax.swing.JButton btnInsertcourse;
    private javax.swing.JButton btnInsertexam;
    private javax.swing.JButton btnInsertlecture;
    private javax.swing.JButton btnInsertlecturer;
    private javax.swing.JButton btnInsertmodule;
    private javax.swing.JButton btnInsertpayment;
    private javax.swing.JButton btnInsertpractical;
    private javax.swing.JButton btnInsertstudent;
    private javax.swing.JButton btnInsertuser;
    private javax.swing.JButton btnRefreshlog;
    private javax.swing.JButton btnRestore;
    private javax.swing.JButton btnSendMail;
    private javax.swing.JButton btnStudentAssignmentReport2;
    private javax.swing.JButton btnStudentAssignmentsReport;
    private javax.swing.JButton btnStudentBatchReport;
    private javax.swing.JButton btnStudentExamsReport;
    private javax.swing.JButton btnStudentExamsReport2;
    private javax.swing.JButton btnStudentPaymentsReport;
    private javax.swing.JButton btnUpdateBatch;
    private javax.swing.JButton btnUpdateClassroom;
    private javax.swing.JButton btnUpdateDepartment;
    private javax.swing.JButton btnUpdateStAss;
    private javax.swing.JButton btnUpdateStAttendance;
    private javax.swing.JButton btnUpdateStCourse;
    private javax.swing.JButton btnUpdateStExam;
    private javax.swing.JButton btnUpdateassignment;
    private javax.swing.JButton btnUpdatecourse;
    private javax.swing.JButton btnUpdateexam;
    private javax.swing.JButton btnUpdatelecture;
    private javax.swing.JButton btnUpdatelecturer;
    private javax.swing.JButton btnUpdatemodule;
    private javax.swing.JButton btnUpdatepayment;
    private javax.swing.JButton btnUpdatepractical;
    private javax.swing.JButton btnUpdatestudent;
    private javax.swing.JButton btnUpdateuser;
    private javax.swing.JComboBox cmbAssignmentduetime;
    private javax.swing.JComboBox cmbAssignmentmoduleid;
    private javax.swing.JComboBox cmbAssignmentsearchin;
    private javax.swing.JComboBox cmbBatchsearchin;
    private javax.swing.JComboBox cmbClassroomsearchin;
    private javax.swing.JComboBox cmbCourseBatchBatchid;
    private javax.swing.JComboBox cmbCourseBatchCourseid;
    private javax.swing.JComboBox cmbCourseBatchsearchin;
    private javax.swing.JComboBox cmbCourseModuleCourseid;
    private javax.swing.JComboBox cmbCourseModuleModuleid;
    private javax.swing.JComboBox cmbCourseModulesearchin;
    private javax.swing.JComboBox cmbCoursecoordinatorid;
    private javax.swing.JComboBox cmbCoursedepartmentid;
    private javax.swing.JComboBox cmbCoursesearchin;
    private javax.swing.JComboBox cmbDepartmentsearchin;
    private javax.swing.JComboBox cmbExamendtime;
    private javax.swing.JComboBox cmbExammoduleid;
    private javax.swing.JComboBox cmbExamsearchin;
    private javax.swing.JComboBox cmbExamstarttime;
    private javax.swing.JComboBox cmbLectureendtime;
    private javax.swing.JComboBox cmbLecturemoduleid;
    private javax.swing.JComboBox cmbLecturersearchin;
    private javax.swing.JComboBox cmbLecturessearchin;
    private javax.swing.JComboBox cmbLecturestarttime;
    private javax.swing.JComboBox cmbLogsearchin;
    private javax.swing.JComboBox cmbModulelecturerid;
    private javax.swing.JComboBox cmbModulesearchin;
    private javax.swing.JComboBox cmbPaymentsearchin;
    private javax.swing.JComboBox cmbPaymentstudentid;
    private javax.swing.JComboBox cmbPaymenttime;
    private javax.swing.JComboBox cmbPracticalclassroomid;
    private javax.swing.JComboBox cmbPracticalendtime;
    private javax.swing.JComboBox cmbPracticalsearchin;
    private javax.swing.JComboBox cmbPracticalstarttime;
    private javax.swing.JComboBox cmbPracticalstudentid;
    private javax.swing.JComboBox cmbStAssAssignmentid;
    private javax.swing.JComboBox cmbStAssStudentid;
    private javax.swing.JComboBox cmbStAsssearchin;
    private javax.swing.JComboBox cmbStAttendanceLectureid;
    private javax.swing.JComboBox cmbStAttendanceStudentid;
    private javax.swing.JComboBox cmbStAttendancesearchin;
    private javax.swing.JComboBox cmbStAttendancetime;
    private javax.swing.JComboBox cmbStBatchBatchid;
    private javax.swing.JComboBox cmbStBatchStudentid;
    private javax.swing.JComboBox cmbStBatchsearchin;
    private javax.swing.JComboBox cmbStCourseCourseid;
    private javax.swing.JComboBox cmbStCourseStudentid;
    private javax.swing.JComboBox cmbStCoursesearchin;
    private javax.swing.JComboBox cmbStExamExamid;
    private javax.swing.JComboBox cmbStExamStudentid;
    private javax.swing.JComboBox cmbStExamsearchin;
    private javax.swing.JComboBox cmbStudentbatchid;
    private javax.swing.JComboBox cmbStudentgender;
    private javax.swing.JComboBox cmbStudentsearchin;
    private javax.swing.JComboBox cmbUsersearchin;
    private javax.swing.JComboBox cmbUserstatus;
    private javax.swing.JComboBox cmbUsertype;
    private com.toedter.calendar.JDateChooser dteAssignmentduedate;
    private com.toedter.calendar.JDateChooser dteBatchstartdate;
    private com.toedter.calendar.JDateChooser dteExamenddate;
    private com.toedter.calendar.JDateChooser dteExamstartdate;
    private com.toedter.calendar.JDateChooser dteLectureenddate;
    private com.toedter.calendar.JDateChooser dteLecturestartdate;
    private com.toedter.calendar.JDateChooser dtePaymentdate;
    private com.toedter.calendar.JDateChooser dtePracticalenddate;
    private com.toedter.calendar.JDateChooser dtePracticalstartdate;
    private com.toedter.calendar.JDateChooser dteStAttendancedate;
    private com.toedter.calendar.JDateChooser dteStudentbirthday;
    private com.toedter.calendar.JDateChooser dteStudentregdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tblAssignments;
    private javax.swing.JTable tblBatches;
    private javax.swing.JTable tblClassrooms;
    private javax.swing.JTable tblCourseBatches;
    private javax.swing.JTable tblCourseModules;
    private javax.swing.JTable tblCourses;
    private javax.swing.JTable tblDepartments;
    private javax.swing.JTable tblExams;
    private javax.swing.JTable tblLecturers;
    private javax.swing.JTable tblLectures;
    private javax.swing.JTable tblLogs;
    private javax.swing.JTable tblModules;
    private javax.swing.JTable tblPayments;
    private javax.swing.JTable tblPracticals;
    private javax.swing.JTable tblStAss;
    private javax.swing.JTable tblStAttendance;
    private javax.swing.JTable tblStBatch;
    private javax.swing.JTable tblStCourse;
    private javax.swing.JTable tblStExam;
    private javax.swing.JTable tblStudents;
    private javax.swing.JTable tblUsers;
    private javax.swing.JTextField txtAssignmentReportStudentid;
    private javax.swing.JTextField txtAssignmentdescription;
    private javax.swing.JTextField txtAssignmentid;
    private javax.swing.JTextField txtAssignmentname;
    private javax.swing.JTextField txtBatchReportStudentid;
    private javax.swing.JTextField txtBatchid;
    private javax.swing.JTextField txtBatchname;
    private javax.swing.JTextField txtClassroomdescription;
    private javax.swing.JTextField txtClassroomid;
    private javax.swing.JTextField txtClassroomname;
    private javax.swing.JTextField txtCourseStudentReportCourseid;
    private javax.swing.JTextField txtCourseduration;
    private javax.swing.JTextField txtCoursefee;
    private javax.swing.JTextField txtCourseid;
    private javax.swing.JTextField txtCourselevel;
    private javax.swing.JTextField txtCoursename;
    private javax.swing.JTextField txtDepartmentdescription;
    private javax.swing.JTextField txtDepartmentid;
    private javax.swing.JTextField txtDepartmentname;
    private javax.swing.JTextField txtExamid;
    private javax.swing.JTextField txtLectureclassroomid;
    private javax.swing.JTextField txtLecturedescription;
    private javax.swing.JTextField txtLectureid;
    private javax.swing.JTextField txtLectureraddress;
    private javax.swing.JTextField txtLecturerdescription;
    private javax.swing.JTextField txtLectureremail;
    private javax.swing.JTextField txtLecturerid;
    private javax.swing.JTextField txtLecturername;
    private javax.swing.JTextField txtLecturerphone;
    private javax.swing.JTextArea txtMessage;
    private javax.swing.JTextField txtModuledescription;
    private javax.swing.JTextField txtModuleid;
    private javax.swing.JTextField txtModulename;
    private javax.swing.JTextField txtPaymentReportStudentid;
    private javax.swing.JTextField txtPaymentamount;
    private javax.swing.JTextField txtPaymentid;
    private javax.swing.JTextField txtPracticalid;
    private javax.swing.JTextField txtSearchassignment;
    private javax.swing.JTextField txtSearchbatch;
    private javax.swing.JTextField txtSearchclassroom;
    private javax.swing.JTextField txtSearchcourse;
    private javax.swing.JTextField txtSearchcoursebatch;
    private javax.swing.JTextField txtSearchcoursemodule;
    private javax.swing.JTextField txtSearchdepartment;
    private javax.swing.JTextField txtSearchexam;
    private javax.swing.JTextField txtSearchlecture;
    private javax.swing.JTextField txtSearchlecturer;
    private javax.swing.JTextField txtSearchlog;
    private javax.swing.JTextField txtSearchmodule;
    private javax.swing.JTextField txtSearchpayment;
    private javax.swing.JTextField txtSearchpractical;
    private javax.swing.JTextField txtSearchstass;
    private javax.swing.JTextField txtSearchstattendance;
    private javax.swing.JTextField txtSearchstbatch;
    private javax.swing.JTextField txtSearchstcourse;
    private javax.swing.JTextField txtSearchstexam;
    private javax.swing.JTextField txtSearchstudent;
    private javax.swing.JTextField txtSearchuser;
    private javax.swing.JTextField txtSenderEmail;
    private javax.swing.JPasswordField txtSenderEmailPassword;
    private javax.swing.JTextField txtSqlDump;
    private javax.swing.JTextField txtStAssMarks;
    private javax.swing.JTextField txtStCourseFee;
    private javax.swing.JTextField txtStExamMarks;
    private javax.swing.JTextField txtStudentaddress;
    private javax.swing.JTextField txtStudentbackground;
    private javax.swing.JTextField txtStudentemail;
    private javax.swing.JTextField txtStudentid;
    private javax.swing.JTextField txtStudentname;
    private javax.swing.JTextField txtStudentphone;
    private javax.swing.JTextField txtSubject;
    private javax.swing.JTextField txtUseremail;
    private javax.swing.JTextField txtUserid;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JTextField txtUserpassword;
    // End of variables declaration//GEN-END:variables
}
