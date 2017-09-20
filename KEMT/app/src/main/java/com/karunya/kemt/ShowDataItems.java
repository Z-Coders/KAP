package com.karunya.kemt;





public class ShowDataItems {
    public String score1;
    public String score2;
    public String typeImage;
    public String place;

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public ShowDataItems(String team1Image, String score1, String score2, String typeImage, String type, String team2Image) {
        this.team1Image = team1Image;
        this.score1 = score1;
        this.score2 = score2;
        this.typeImage = typeImage;
        this.type = type;
        this.team2Image = team2Image;
    }

    public String getTypeImage() {

        return typeImage;
    }

    public void setTypeImage(String typeImage) {
        this.typeImage = typeImage;
    }

    public ShowDataItems(String score1, String team2Image, String team1Image, String type, String score2) {
        this.score1 = score1;
        this.team2Image = team2Image;
        this.team1Image = team1Image;
        this.type = type;
        this.score2 = score2;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String type;
    public String team1Image,team2Image;



    public ShowDataItems(){

    }

    public String getScore1() {

        return score1;
    }

    public void setScore1(String score1) {
        this.score1 = score1;
    }

    public String getScore2() {
        return score2;
    }

    public void setScore2(String score2) {
        this.score2 = score2;
    }

    public String getTeam1Image() {
        return team1Image;
    }

    public void setTeam1Image(String team1Image) {
        this.team1Image = team1Image;
    }

    public String getTeam2Image() {
        return team2Image;
    }

    public void setTeam2Image(String team2Image) {
        this.team2Image = team2Image;
    }
}