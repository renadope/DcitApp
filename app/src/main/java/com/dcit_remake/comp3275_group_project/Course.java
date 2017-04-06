package com.dcit_remake.comp3275_group_project;

import java.util.ArrayList;

/**
 * Created by Renado_Paria on 4/4/2017 at 1:38 PM for DcitApp.
 */

class Course
{
    private String type;
    private String courseCode;
    private String courseID;
    private String courseName;
    private int level;
    private String semeseter;
    private int credits;
    private ArrayList<String> preRequsites;
    private ArrayList<String> topics;
    private String courseDescription;
    private String lectuereName;
    private String lecturerID;

    public Course()
    {
    }

    public Course(String type, String courseCode, String courseID, String courseName, int level, String semeseter, int credits, ArrayList<String> preRequsites, ArrayList<String> topics, String courseDescription, String lectuereName, String lecturerID)
    {
        this.type = type;
        this.courseCode = courseCode;
        this.courseID = courseID;
        this.courseName = courseName;
        this.level = level;
        this.semeseter = semeseter;
        this.credits = credits;
        this.preRequsites = preRequsites;
        this.topics = topics;
        this.courseDescription = courseDescription;
        this.lectuereName = lectuereName;
        this.lecturerID = lecturerID;
    }

    public Course(String type, String courseCode, String courseID, String courseName, int level, int credits, ArrayList<String> preRequsites, ArrayList<String> topics, String courseDescription, String lectuereName, String lecturerID)
    {
        this.type = type;
        this.courseCode = courseCode;
        this.courseID = courseID;
        this.courseName = courseName;
        this.level = level;
        this.semeseter = "Both";
        this.credits = credits;
        this.preRequsites = preRequsites;
        this.topics = topics;
        this.courseDescription = courseDescription;
        this.lectuereName = lectuereName;
        this.lecturerID = lecturerID;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getCourseCode()
    {
        return courseCode;
    }

    public void setCourseCode(String courseCode)
    {
        this.courseCode = courseCode;
    }

    public String getCourseID()
    {
        return courseID;
    }

    public void setCourseID(String courseID)
    {
        this.courseID = courseID;
    }

    public String getCourseName()
    {
        return courseName;
    }

    public void setCourseName(String courseName)
    {
        this.courseName = courseName;
    }

    public int getLevel()
    {
        return level;
    }

    public void setLevel(int level)
    {
        this.level = level;
    }

    public String getSemeseter()
    {
        return semeseter;
    }

    public void setSemeseter(String semeseter)
    {
        this.semeseter = semeseter;
    }

    public int getCredits()
    {
        return credits;
    }

    public void setCredits(int credits)
    {
        this.credits = credits;
    }

    public ArrayList<String> getPreRequsites()
    {
        return preRequsites;
    }

    public void setPreRequsites(ArrayList<String> preRequsites)
    {
        this.preRequsites = preRequsites;
    }

    public ArrayList<String> getTopics()
    {
        return topics;
    }

    public void setTopics(ArrayList<String> topics)
    {
        this.topics = topics;
    }

    public String getCourseDescription()
    {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription)
    {
        this.courseDescription = courseDescription;
    }

    public String getLectuereName()
    {
        return lectuereName;
    }

    public void setLectuereName(String lectuereName)
    {
        this.lectuereName = lectuereName;
    }

    public String getLecturerID()
    {
        return lecturerID;
    }

    public void setLecturerID(String lecturerID)
    {
        this.lecturerID = lecturerID;
    }

    @Override
    public String toString()
    {
        return "Course{" +
                "type='" + type + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", courseID='" + courseID + '\'' +
                ", courseName='" + courseName + '\'' +
                ", level=" + level +
                ", semeseter='" + semeseter + '\'' +
                ", credits=" + credits +
                ", preRequsites=" + preRequsites +
                ", topics=" + topics +
                ", courseDescription='" + courseDescription + '\'' +
                ", lectuereName='" + lectuereName + '\'' +
                ", lecturerID='" + lecturerID + '\'' +
                '}';
    }
}
