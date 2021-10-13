package com.oconte.david.firestoretuto;

public class Restaurant {

    public String urlPhoto;
    public String userName;
    public String idUser;


    public Restaurant(String urlPhoto, String userName, String idUser) {
        this.urlPhoto = urlPhoto;
        this.userName = userName;
        this.idUser = idUser;
    }

    public Restaurant() {

    }


    // GETTERS
    public String getUrlPhoto() {
        return urlPhoto;
    }

    public String getUserName() {
        return userName;
    }

    public String getIdUser() {
        return idUser;
    }


    //SETTERS
    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }
}
