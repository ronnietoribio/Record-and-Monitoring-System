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
public class TeacherData {

    private Integer id;
    private String teacherID;
    private String fullName;
    private String gender;
    private String yearExperience;
    private String experience;
    private String department;
    private String image;
    private Date dateInsert;
    private Date dateUpdate;
    private Date dateDelete;
    private String status;

    public TeacherData(Integer id, String teacherID, String fullName, String gender,
            String yearExperience, String experience, String department,
            String image, Date dateInsert, Date dateUpdate, Date dateDelete, String status) {
        this.id = id;
        this.teacherID = teacherID;
        this.fullName = fullName;
        this.gender = gender;
        this.yearExperience = yearExperience;
        this.experience = experience;
        this.department = department;
        this.image = image;
        this.dateInsert = dateInsert;
        this.dateUpdate = dateUpdate;
        this.dateDelete = dateDelete;
        this.status = status;
    }

    public TeacherData(Integer id, String teacherID, String fullName,
            String gender, Date dateInsert,
            Date dateUpdate, String status) {
        this.id = id;
        this.teacherID = teacherID;
        this.fullName = fullName;
        this.gender = gender;
        this.dateInsert = dateInsert;
        this.dateUpdate = dateUpdate;
        this.status = status;
    }

    public TeacherData(Integer id, String teacherID, String fullName,
            String gender, String yearExperience, Date dateInsert) {
        this.id = id;
        this.teacherID = teacherID;
        this.fullName = fullName;
        this.gender = gender;
        this.yearExperience = yearExperience;
        this.dateInsert = dateInsert;
    }


    public Integer getId() {
        return id;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public String getFullName() {
        return fullName;
    }

    public String getGender() {
        return gender;
    }

    public String getYearExperience() {
        return yearExperience;
    }

    public String getExperience() {
        return experience;
    }

    public String getDepartment() {
        return department;
    }
    public String getImage() {
        return image;
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

}
