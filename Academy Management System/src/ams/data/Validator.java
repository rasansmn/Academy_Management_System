/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ams.data;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;

/**
 *
 * @author Rasan
 */
public class Validator {

    public static boolean validateLogin(JFrame ui, JTextField email, JTextField password){
        if(email.getText().trim().length() < 1){
            JOptionPane.showMessageDialog(ui, "Email is required");
            email.requestFocus();
            return false;
        }else if(password.getText().trim().length() < 1){
            JOptionPane.showMessageDialog(ui, "Password is required");
            password.requestFocus();
            return false;
        }
        return true;
    }
    
    public static boolean validateDepartment(JInternalFrame jinternalframe, JTextField departmentid, JTextField departmentname, JTextField description){
        if(departmentid.getText().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Department ID is required");
            departmentid.requestFocus();
            return false;
        }else if(departmentname.getText().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Department Name is required");
            departmentname.requestFocus();
            return false;
        }else if(description.getText().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Description is required");
            description.requestFocus();
            return false;
        }
        return true;
    }
    
    public static boolean validateLecturer(JInternalFrame jinternalframe, JTextField lecturerid, JTextField lecturername, JTextField address, JTextField email, JTextField phone){
        if(lecturerid.getText().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Lecturer ID is required");
            lecturerid.requestFocus();
            return false;
        }else if(lecturername.getText().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Lecturer Name is required");
            lecturername.requestFocus();
            return false;
        }else if(address.getText().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Address is required");
            address.requestFocus();
            return false;
        }else if(email.getText().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Email is required");
            email.requestFocus();
            return false;
        }else if(phone.getText().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Phone is required");
            phone.requestFocus();
            return false;
        }
        return true;
    }
    
    public static boolean validateCourse(JInternalFrame jinternalframe, JTextField courseid, JTextField coursename, JTextField duration, JTextField fee, JTextField level, JComboBox departmentid, JComboBox coordinatorid){
        if(courseid.getText().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Course ID is required");
            courseid.requestFocus();
            return false;
        }else if(coursename.getText().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Course Name is required");
            coursename.requestFocus();
            return false;
        }else if(duration.getText().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Duration is required");
            duration.requestFocus();
            return false;
        }else if(fee.getText().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Fee is required");
            fee.requestFocus();
            return false;
        }else if(level.getText().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Level is required");
            level.requestFocus();
            return false;
        }else if(departmentid.getSelectedItem().toString().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Department ID is required");
            departmentid.requestFocus();
            return false;
        }else if(coordinatorid.getSelectedItem().toString().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Coordinator ID is required");
            coordinatorid.requestFocus();
            return false;
        }
        return true;
    }
    
    public static boolean validateStudent(JInternalFrame jinternalframe, JTextField studentid, JTextField studentname, JTextField address, JComboBox gender, JDateChooser birthday, JTextField email, JTextField phone, JTextField background,  JDateChooser regdate){
        if(studentid.getText().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Student ID is required");
            studentid.requestFocus();
            return false;
        }else if(studentname.getText().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Student Name is required");
            studentname.requestFocus();
            return false;
        }else if(address.getText().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Address is required");
            address.requestFocus();
            return false;
        }else if(gender.getSelectedItem().toString().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Gender is required");
            gender.requestFocus();
            return false;
        }else if(birthday.getDate() == null){
            JOptionPane.showMessageDialog(jinternalframe, "Birthday is required");
            birthday.requestFocus();
            return false;
        }else if(email.getText().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Email is required");
            email.requestFocus();
            return false;
        }else if(phone.getText().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Phone number is required");
            phone.requestFocus();
            return false;
        }else if(background.getText().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Background is required");
            background.requestFocus();
            return false;
        }else if(regdate.getDate() == null){
            JOptionPane.showMessageDialog(jinternalframe, "Reg. Date is required");
            regdate.requestFocus();
            return false;
        }
        return true;
    }
    
    public static boolean validatePractical(JInternalFrame jinternalframe, JTextField practicalid, JDateChooser starttime, JDateChooser endtime, JComboBox studentid, JComboBox classroomid){
        if(practicalid.getText().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Practical ID is required");
            studentid.requestFocus();
            return false;
        }else if(starttime.getDate() == null){
            JOptionPane.showMessageDialog(jinternalframe, "Start time is required");
            starttime.requestFocus();
            return false;
        }else if(endtime.getDate() == null){
            JOptionPane.showMessageDialog(jinternalframe, "End time is required");
            endtime.requestFocus();
            return false;
        }else if(studentid.getSelectedItem().toString().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Student ID is required");
            studentid.requestFocus();
            return false;
        }else if(classroomid.getSelectedItem().toString().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Classroom ID is required");
            classroomid.requestFocus();
            return false;
        }
        return true;
    }
    
    public static boolean validateClassroom(JInternalFrame jinternalframe, JTextField classroomid, JTextField classroomname){
        if(classroomid.getText().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Classroom ID is required");
            classroomid.requestFocus();
            return false;
        }else if(classroomname.getText().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Classroom name is required");
            classroomname.requestFocus();
            return false;
        }
        return true;
    }
    
    public static boolean validatePayment(JInternalFrame jinternalframe, JTextField paymentid, JTextField amount, JDateChooser time, JComboBox studentid){
        if(paymentid.getText().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Payment ID is required");
            paymentid.requestFocus();
            return false;
        }else if(amount.getText().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Amount is required");
            amount.requestFocus();
            return false;
        }else if(time.getDate() ==  null){
            JOptionPane.showMessageDialog(jinternalframe, "Time is required");
            time.requestFocus();
            return false;
        }else if(studentid.getSelectedItem().toString().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Student ID is required");
            studentid.requestFocus();
            return false;
        }
        return true;
    }
    
    public static boolean validateModule(JInternalFrame jinternalframe, JTextField moduleid, JTextField modulename, JComboBox lecturerid){
        if(moduleid.getText().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Module ID is required");
            moduleid.requestFocus();
            return false;
        }else if(modulename.getText().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Module Name is required");
            modulename.requestFocus();
            return false;
        }else if(lecturerid.getSelectedItem().toString().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Lecturer ID is required");
            lecturerid.requestFocus();
            return false;
        }
        return true;
    }
    
    public static boolean validateExam(JInternalFrame jinternalframe, JTextField examid, JDateChooser starttime, JDateChooser endtime, JComboBox moduleid){
        if(examid.getText().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Exam ID is required");
            examid.requestFocus();
            return false;
        }else if(starttime.getDate() == null){
            JOptionPane.showMessageDialog(jinternalframe, "Start Time is required");
            starttime.requestFocus();
            return false;
        }else if(endtime.getDate() == null){
            JOptionPane.showMessageDialog(jinternalframe, "End Time is required");
            endtime.requestFocus();
            return false;
        }else if(moduleid.getSelectedItem().toString().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Module ID is required");
            moduleid.requestFocus();
            return false;
        }
        return true;
    }
    
    public static boolean validateAssignment(JInternalFrame jinternalframe, JTextField assignmentid, JTextField assignmentname, JComboBox moduleid){
        if(assignmentid.getText().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Assignment ID is required");
            assignmentid.requestFocus();
            return false;
        }else if(assignmentname.getText().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Assignment Name is required");
            assignmentname.requestFocus();
            return false;
        }else if(moduleid.getSelectedItem().toString().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Module ID is required");
            moduleid.requestFocus();
            return false;
        }
        return true;
    }
    
    public static boolean validateLecture(JInternalFrame jinternalframe, JTextField lectureid, JDateChooser starttime, JDateChooser endtime, JTextField description, JTextField classroomid, JComboBox moduleid){
        if(lectureid.getText().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Lecture ID is required");
            lectureid.requestFocus();
            return false;
        }else if(starttime.getDate() == null){
            JOptionPane.showMessageDialog(jinternalframe, "Start Time is required");
            starttime.requestFocus();
            return false;
        }else if(endtime.getDate() == null){
            JOptionPane.showMessageDialog(jinternalframe, "End Time is required");
            endtime.requestFocus();
            return false;
        }else if(description.getText().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Description is required");
            description.requestFocus();
            return false;
        }else if(classroomid.getText().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Classroom ID is required");
            classroomid.requestFocus();
            return false;
        }else if(moduleid.getSelectedItem().toString().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Module ID is required");
            moduleid.requestFocus();
            return false;
        }
        return true;
    }
    
    public static boolean validateUser(JInternalFrame jinternalframe, JTextField userid, JTextField username, JTextField email, JTextField password, JComboBox type, JComboBox status){
        if(userid.getText().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "User ID is required");
            userid.requestFocus();
            return false;
        }else if(username.getText().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "User Name is required");
            username.requestFocus();
            return false;
        }else if(email.getText().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Email is required");
            email.requestFocus();
            return false;
        }else if(password.getText().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Password is required");
            password.requestFocus();
            return false;
        }else if(type.getSelectedItem().toString().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Type is required");
            type.requestFocus();
            return false;
        }else if(status.getSelectedItem().toString().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Status is required");
            status.requestFocus();
            return false;
        }
        return true;
    }
    
    public static boolean validateBatch(JInternalFrame jinternalframe, JTextField batchid, JTextField batchname, JDateChooser startdate){
        if(batchid.getText().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Batch ID is required");
            batchid.requestFocus();
            return false;
        }else if(batchname.getText().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Batch Name is required");
            batchname.requestFocus();
            return false;
        }else if(startdate.getDate() == null){
            JOptionPane.showMessageDialog(jinternalframe, "Start Date is required");
            startdate.requestFocus();
            return false;
        }
        return true;
    }
    
    public static boolean validateStAss(JInternalFrame jinternalframe, JTextField marks){
        if(marks.getText().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Marks is required");
            marks.requestFocus();
            return false;
        }
        return true;
    }
    
    public static boolean validateStExam(JInternalFrame jinternalframe, JTextField marks){
        if(marks.getText().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Marks is required");
            marks.requestFocus();
            return false;
        }
        return true;
    }
    
    public static boolean validateCourseModule(JInternalFrame jinternalframe, JComboBox courseid, JComboBox moduleid){
        if(courseid.getSelectedItem().toString().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Course ID is required");
            courseid.requestFocus();
            return false;
        }else if(moduleid.getSelectedItem().toString().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Module ID is required");
            moduleid.requestFocus();
            return false;
        }
        return true;
    }
    
    public static boolean validateAttendance(JInternalFrame jinternalframe, JComboBox studentid, JComboBox lectureid, JDateChooser time){
        if(studentid.getSelectedItem().toString().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Student ID is required");
            studentid.requestFocus();
            return false;
        }else if(lectureid.getSelectedItem().toString().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Lecture ID is required");
            lectureid.requestFocus();
            return false;
        }else if(time.getDate() == null){
            JOptionPane.showMessageDialog(jinternalframe, "Time is required");
            time.requestFocus();
            return false;
        }
        return true;
    }
    
    public static boolean validateStCourse(JInternalFrame jinternalframe, JTextField fee){
        if(fee.getText().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Fee is required");
            fee.requestFocus();
            return false;
        }
        return true;
    }
    
    public static boolean validateStudentBatch(JInternalFrame jinternalframe, JComboBox batchid, JComboBox studentid){
        if(batchid.getSelectedItem().toString().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Batch ID is required");
            batchid.requestFocus();
            return false;
        }else if(studentid.getSelectedItem().toString().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Student ID is required");
            studentid.requestFocus();
            return false;
        }
        return true;
    }
    
    public static boolean validateCourseBatch(JInternalFrame jinternalframe, JComboBox courseid, JComboBox batchid){
        if(courseid.getSelectedItem().toString().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Course ID is required");
            courseid.requestFocus();
            return false;
        }else if(batchid.getSelectedItem().toString().trim().length() < 1){
            JOptionPane.showMessageDialog(jinternalframe, "Batch ID is required");
            batchid.requestFocus();
            return false;
        }
        return true;
    }
}
