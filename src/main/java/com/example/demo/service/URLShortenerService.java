package com.example.demo.service;
import java.util.Random;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.entity.ShortURL;
import com.example.demo.repository.ShortURLRepository;
import java.time.LocalDateTime;
import java.security.SecureRandom;



@Service
public class URLShortenerService{
    private ShortURLRepository shortURLRepository;
    private final Random random = new Random();

    @Autowired
    public URLShortenerService(ShortURLRepository shortURLRepository){
        this.shortURLRepository = shortURLRepository;


    }
    private String generateShortCode(){
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder(6);

        for (int i=0; i<6; i++){
            sb.append(chars.charAt(random.nextInt(chars.length())));

        }
        String shortURL = sb.toString();

        return shortURL;


    }
    public ShortURL shortenURL(String originalURL){
        ShortURL shortURL = new ShortURL();

        String shortCode = generateShortCode();

        shortURL.setShortCode(shortCode);
        shortURL.setOriginalURL(originalURL);
        shortURL.setCreatedAt(LocalDateTime.now());

        return shortURLRepository.save(shortURL);



    }

    public String getOriginalURL(String shortCode){


        return shortURLRepository.findByShortCode(shortCode).orElseThrow().getOriginalURL(); 
    


    }


}