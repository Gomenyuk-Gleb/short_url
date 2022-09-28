package com.example.demo.service;

import com.example.demo.controller.ShortNameController;
import com.example.demo.enitity.PostCreate;
import com.example.demo.enitity.ShortUrl;
import com.example.demo.repository.ShortTableRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ShortTableService {

    private final ShortTableRepository shortTableRepository;

    public ShortTableService(ShortTableRepository shortTableRepository) {
        this.shortTableRepository = shortTableRepository;
    }

    public String create(PostCreate postCreate) {
        int count = 0;
        while (count < 3) {
            try {
                ShortUrl shortUrl = new ShortUrl();
                shortUrl.setTitle(postCreate.getTittle());
                shortUrl.setOriginalUrl(postCreate.getUrl());
                shortTableRepository.save(shortUrl);
                return shortUrl.getShortUrl();
            } catch (Exception e) {
                count++;
            }
        }
        return "";
    }

    @Cacheable("shortUrl")
    public String redirect(String shortUrl) {
        return shortTableRepository.findByShortUrl(shortUrl).getOriginalUrl();
    }
}
