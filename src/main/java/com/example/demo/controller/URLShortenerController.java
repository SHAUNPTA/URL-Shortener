package com.example.demo.controller ;
import com.example.demo.entity.ShortURL;
import com.example.demo.service.URLShortenerService;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
public class URLShortenerController {

    private URLShortenerService urlShortenerService;

    @Autowired
    public URLShortenerController(URLShortenerService urlShortenerService){
        this.urlShortenerService = urlShortenerService;

    }
    @PostMapping("/api/shorten")
    public ShortURL shorten(@RequestBody String url){
        return urlShortenerService.shortenURL(url);
    }
    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> redirect(@PathVariable String shortCode){
        String originalUrl = urlShortenerService.getOriginalURL(shortCode);
        return ResponseEntity.status(302).location(URI.create(originalUrl)).build();
    }

}