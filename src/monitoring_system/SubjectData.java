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
public class SubjectData {

    private Integer id;
    private String subjectCode;
    private String subject;
    private String course;
    private Date dateInsert;
    private Date dateUpdate;
    private Date dateDelete;
    private String status;
    private String teacherID;
    private Double firstSem;
    private Double secondSem;
    private Double finals;

    public SubjectData(Integer id, String subjectCode, String subject, String course,
            Date dateInsert, Date dateUpdate, Date dateDelete, String status) {
        this.id = id;
        this.subjectCode = subjectCode;
        this.subject = subject;
        this.course = course;
        this.dateInsert = dateInsert;
        this.dateUpdate = dateUpdate;
        this.dateDelete = dateDelete;
        this.status = status;
    }

    public SubjectData(String subjectCode, String subject, String teacherID) {
        this.subjectCode = subjectCode;
        this.subject = subject;
        this.teacherID = teacherID;
    }

    public SubjectData(String teacherID, String subjectCode, String subject, Double firstSem, Double secondSem, Double finals) {
        this.teacherID = teacherID;
        this.subjectCode = subjectCode;
        this.subject = subject;
        this.firstSem = firstSem;
        this.secondSem = secondSem;
        this.finals = finals;
    }

    SubjectData(String string, String string0, String string1, String string2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getId() {
        return id;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public String getSubject() {
        return subject;
    }

    public String getCourse() {
        return course;
    }

    public Date getDateInsert() {
        return dateInsert;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public Date getDateDelete() {
        return dateDelete;
    }

    public String getStatus() {
        return status;
    }

    public String teacherID() {
        return teacherID;
    }
    public Double getFirstSem(){
        return firstSem;
    
    }
    public Double getSecondSem(){
        return secondSem;
    
    }
    public Double getFinals(){
        return finals;
    
    }
}
