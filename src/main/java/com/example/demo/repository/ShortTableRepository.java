package com.example.demo.repository;


import com.example.demo.enitity.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortTableRepository extends JpaRepository<ShortUrl, Long> {

    ShortUrl findByShortUrl(String url);
}
