package com.locationvoiture.location.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Voiture {
    @Id
    @GeneratedValue(strategy=  GenerationType.IDENTITY)
    private long id;
    private String marque;
    private int prix;
    
    //ctor par defaut
    public Voiture(){
    }

    public Voiture(int id, String marque, int prix) {
        this.id = id;
        this.marque = marque;
        this.prix = prix;
    }
    public long getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getMarque() {
        return marque;
    }
    public void setMarque(String marque) {
        this.marque = marque;
    }
    public int getPrix() {
        return prix;
    }
    public void setPrix(int prix) {
        this.prix = prix;
    }
    

}
