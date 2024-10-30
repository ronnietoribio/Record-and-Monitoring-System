/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitoring_system;

import java.sql.Date;

/**
 *
 * @author WINDOWS 10
 */
public class DataStudentHandle {

    private String teacherID;
    private String studentID;
    private String name;
    private String gender;
    private String course;
    private String subject;
    private String year;
    private String semester;
    private Date dateInsert;
    private Date dateDelete;
    private String status;
    private String firstSem;
    private String secondSem;
    private String finals;
    private String subjectCode;

    public DataStudentHandle(String studentID, String name, String gender,
            String course, String year, String semester, Date dateInsert,
            Date dateDelete, String status) {
        this.studentID = studentID;
        this.name = name;
        this.gender = gender;
        this.course = course;
        this.year = year;
        this.semester = semester;
        this.dateInsert = dateInsert;
        this.dateDelete = dateDelete;
        this.status = status;
    }

    public DataStudentHandle(String teacherID, 
            String name, String gender,  Date dateInsert) {
        this.teacherID = teacherID;
        this.name = name;
        this.gender = gender;
        this.dateInsert = dateInsert;
    }
    public DataStudentHandle(String teacherID , String studentID, String name, String gender, Date dateInsert){
        this.studentID=studentID;
        this.name=name;
        this.gender=gender;
        this.dateInsert=dateInsert;
    }
    public DataStudentHandle(String teacherID, String subjectCode, String subject, String firstSem, String secondSem, String finals) {
        this.teacherID = teacherID;
        this.subjectCode = subjectCode;
        this.subject = subject;
        this.firstSem = firstSem;
        this.secondSem = secondSem;
        this.finals = finals;
    }
     public DataStudentHandle(String subjectCode, String subject, String teacherID) {
        this.subjectCode = subjectCode;
        this.subject = subject;
        this.teacherID = teacherID;
     }
     
     public DataStudentHandle (String subjectCode, String subject) {
      
        this.subjectCode = subjectCode;
        this.subject = subject;
     }
     
    public String getTeacherID() {
        return teacherID;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getCourse() {
        return course;
    }

    public String getYear() {
        return year;
    }

    public String getSemester() {
        return semester;
    }

    public Date getDateInsert() {
        return dateInsert;
    }

    public Date getDateDelete() {
        return dateDelete;
    }

    public String getStatus() {
        return status;
    }
    public String DataStudentHandle(){
         return subject;
    
    }
    
}
