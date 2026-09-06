package com.example.demo.repository;
import com.example.demo.entity.ShortURL;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface ShortURLRepository extends JpaRepository <ShortURL, Long>{

   Optional<ShortURL> findByShortCode(String shortCode);

}