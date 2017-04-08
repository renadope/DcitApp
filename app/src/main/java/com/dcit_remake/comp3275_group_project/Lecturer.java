package com.dcit_remake.comp3275_group_project;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Renado_Paria on 4/7/2017 at 2:38 AM for DcitApp.
 */

class Lecturer implements Serializable
{
    private String name;
    private String position;
    private ArrayList<String> education;
    private String academicRole;
    private ArrayList<String> areasOfInterest;
    private String officecontact;
    private String contactextension;
    private String smsContact;
    private String room;
    private String email;
    private String mUrlToProfilePicture;

    Lecturer()
    {
    }

    Lecturer(String name, String position, ArrayList<String> education, String academicRole, ArrayList<String> areasOfInterest, String officecontact, String contactextension, String smsContact, String room, String email, String urlToProfilePicture)
    {
        this.name = name;
        this.position = position;
        this.education = education;
        this.academicRole = academicRole;
        this.areasOfInterest = areasOfInterest;
        this.officecontact = officecontact;
        this.contactextension = contactextension;
        this.smsContact = smsContact;
        this.room = room;
        this.email = email;
        mUrlToProfilePicture = urlToProfilePicture;
    }

    public Lecturer(String name, String position, ArrayList<String> education, String academicRole, ArrayList<String> areasOfInterest, String contactextension, String smsContact, String room, String email, String urlToProfilePicture)
    {
        this.name = name;
        this.position = position;
        this.education = education;
        this.academicRole = academicRole;
        this.areasOfInterest = areasOfInterest;
        this.officecontact = "+1(868) 662-2002";
        this.contactextension = contactextension;
        this.smsContact = smsContact;
        this.room = room;
        this.email = email;
        mUrlToProfilePicture = urlToProfilePicture;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPosition()
    {
        return position;
    }

    public void setPosition(String position)
    {
        this.position = position;
    }

    public ArrayList<String> getEducation()
    {
        return education;
    }

    public void setEducation(ArrayList<String> education)
    {
        this.education = education;
    }

    public String getAcademicRole()
    {
        return academicRole;
    }

    public void setAcademicRole(String academicRole)
    {
        this.academicRole = academicRole;
    }

    public ArrayList<String> getAreasOfInterest()
    {
        return areasOfInterest;
    }

    public void setAreasOfInterest(ArrayList<String> areasOfInterest)
    {
        this.areasOfInterest = areasOfInterest;
    }

    public String getOfficecontact()
    {
        return officecontact;
    }

    public void setOfficecontact(String officecontact)
    {
        this.officecontact = officecontact;
    }

    public String getContactextension()
    {
        return contactextension;
    }

    public void setContactextension(String contactextension)
    {
        this.contactextension = contactextension;
    }

    public String getSmsContact()
    {
        return smsContact;
    }

    public void setSmsContact(String smsContact)
    {
        this.smsContact = smsContact;
    }

    public String getRoom()
    {
        return room;
    }

    public void setRoom(String room)
    {
        this.room = room;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getUrlToProfilePicture()
    {
        return mUrlToProfilePicture;
    }

    public void setUrlToProfilePicture(String urlToProfilePicture)
    {
        mUrlToProfilePicture = urlToProfilePicture;
    }

    @Override
    public String toString()
    {
        return "Lecturer{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", education=" + education +
                ", academicRole='" + academicRole + '\'' +
                ", areasOfInterest=" + areasOfInterest +
                ", officecontact='" + officecontact + '\'' +
                ", contactextension='" + contactextension + '\'' +
                ", smsContact='" + smsContact + '\'' +
                ", room='" + room + '\'' +
                ", email='" + email + '\'' +
                ", mUrlToProfilePicture='" + mUrlToProfilePicture + '\'' +
                '}';
    }
}
