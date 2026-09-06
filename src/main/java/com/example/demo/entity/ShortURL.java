package com.example.demo.entity;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;


@Entity
public class ShortURL{

    @Id @GeneratedValue
    private long id;
    private String shortCode;
    private String originalURL;
    private LocalDateTime createdAt;

    public ShortURL(){

    }
    public ShortURL(long id, String shortCode, String originalURL, LocalDateTime createdAt){
        this.id = id;
        this.shortCode = shortCode;
        this.originalURL = originalURL;
        this.createdAt = createdAt; 

    }
    public long getId(){
        return id;
    }
    public String getShortCode(){
        return shortCode;
    }
    public String getOriginalURL(){
        return originalURL;
    }
    public LocalDateTime getCreatedAt(){
        return createdAt;
    }
    public void setId(long id){
        this.id = id;
    }
    public void setShortCode(String shortCode){
        this.shortCode = shortCode;
    }
    public void setOriginalURL(String originalURL){
        this.originalURL = originalURL;
    }
    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt = createdAt;
    }


}