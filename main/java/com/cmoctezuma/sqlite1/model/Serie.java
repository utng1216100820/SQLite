package com.own.sqlite1.model;

/**
 * Created by Carolina on 25/03/2018.
 */

public class serie {
    private String idserie;
    private String name;
    private String creator;
    private String gender;
    private String year;
    private String chapters;

    //Constructor
    public serie(String idserie, String name, String creator, String gender, String  year, String chapters) {
        this.idserie = idserie;
        this.name = name;
        this.creator = creator;
        this.gender = gender;
        this.year = year;
        this.chapters = chapters;
    }

    //Constructor empty
    public serie(){
        this("", "", "", "", "","");
    }

    //Generated getters and setters
    public String getIdserie() {return idserie;}

    public void setIdserie(String idserie) {this.idserie = idserie;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getCreator() {return creator;}

    public void setCreator(String creator) {this.creator = creator;}

    public String getGender() {return gender;}

    public void setGender(String gender) {this.gender = gender;}

    public String getYear() {return year;}

    public void setYear(String year) {this.year = year;}

    public String getChapters() {return chapters;}

    public void setChapters(String chapters) {this.chapters = chapters;}

    //Generated toString
    @Override
    public String toString() {
        return "series{" +
                "idserie='" + idserie + '\'' +
                ", name='" + name + '\'' +
                ", creator='" + creator + '\'' +
                ", gender='" + gender + '\'' +
                ", year=" + year +
                ", chapters=" + chapters +
                '}';
    }

}//End
