package com.example.nh.recyclerview;

public class Item {


    private String name;
    private String team;
    private String createdby;
    private String firstappearance;
    private String bio;
    private String image1;



    public String getImage1() {
        return image1;
    }

    public String getTeam() {
        return team;
    }

    public String getCreatedby() {
        return createdby;
    }

    public String getFirstappearance() {
        return firstappearance;
    }

    public String getBio() {
        return bio;
    }

    public String getName() {
        return name;
    }

    public Item(String name, String team, String createdby, String firstappearance, String bio, String image1) {
        this.name = name;
        this.team = team;
        this.createdby = createdby;
        this.firstappearance = firstappearance;
        this.bio = bio;
        this.image1 = image1;
    }




}
