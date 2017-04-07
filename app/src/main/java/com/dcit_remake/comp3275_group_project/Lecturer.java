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
        this.officecontact = "+1(868)662-2002";
        this.contactextension = contactextension;
        this.smsContact = smsContact;
        this.room = room;
        this.email = email;
        mUrlToProfilePicture = urlToProfilePicture;
    }

}
