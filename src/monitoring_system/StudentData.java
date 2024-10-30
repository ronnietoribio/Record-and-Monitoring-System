/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitoring_system;

import java.util.Date;

/**
 *
 * @author admin
 */
public class StudentData {
    
    private Integer id;
    private String studentID;
    private String fullName;
    private String gender;
    private Date birthDate;
    private String year;
    private String course;
    private String section;
    private String image;
    private Date dateInsert;
    private Date dateUpdate;
    private String status;
    private String semester;
    private Double first_sem;
    private Double second_sem;
    private Double finals;
    private Integer studentNum;
    private Date birth_date;
    
    
    public StudentData(Integer id,Integer studentNum, String studentID, String fullName, String gender,
                       Date birthDate, String year, String course, 
                       String section, String image, Date dateInsert, 
                       Date dateUpdate, String status){
        this.id=id;
        this.studentNum=studentNum;
        this.studentID=studentID;
        this.fullName=fullName;
        this.gender=gender;
        this.birthDate=birthDate;
        this.year=year;
        this.course=course;
        this.section=section;
        this.image=image;
        this.dateInsert=dateInsert;
        this.dateUpdate=dateUpdate;
        this.status=status;
        
    }
    public StudentData(Integer id, String studentID, String fullName, String year, String course, String semester, String section, Date dateInsert, String status ){
        this.id=id;
        this.studentID=studentID;
        this.fullName=fullName;
        this.year=year;
        this.course=course;
        this.section=section;
        this.dateInsert=dateInsert;
        this.status=status;
        this.semester = semester;
    
    }
     public StudentData(Integer StudentNum, String year, String course, Double first_sem, Double second_sem, Double finals) {
        this.studentNum = StudentNum;
        this.year = year;
        this.course = course;
        this.first_sem = first_sem;
        this.second_sem = second_sem;
        this.finals = finals;
    }
        public StudentData(Integer studentNum, String year, String course,String fullName, String gender, java.sql.Date birth_date, String status, String image) {
        this.studentNum = studentNum;
        this.year = year;
        this.course = course;
        this.fullName = fullName;
        this.gender = gender;
        this.birth_date = birth_date;
        this.status = status;
        this.image = image;
    }
    
    public Integer getID(){
        return id;
    }
    public String getStudentID(){
        return studentID;    
    }
    public String getFullName(){
        return fullName;
    }
    public String getGender(){
        return gender;
    }
    public Date getBirthDate(){
        return birthDate;
    }
    public String getYear(){
        return year;
    }
    public String getCourse(){
        return course;
    }
    public String getSection(){
        return section;
    }
    public String getImage(){
        return image;
    }
    public Date getDateInsert(){
        return dateInsert;
    }
    public Date getDateUpdate(){
        return dateUpdate;
    }
    public String getStatus(){
        return status;
    }
     public String getSemester() {
        return semester;
    }
    public Integer getStudentNum() {
        return studentNum;
    }
    public Double getFirstSem() {
        return first_sem;
    }

    public Double getSecondSem() {
        return second_sem;
    }

    public Double getFinals() {
        return finals;
    }
}

