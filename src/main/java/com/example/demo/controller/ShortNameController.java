package com.example.demo.controller;

import com.example.demo.enitity.PostCreate;
import com.example.demo.service.ShortTableService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class ShortNameController {

    private final ShortTableService shortTableService;

    public ShortNameController(ShortTableService shortTableService) {
        this.shortTableService = shortTableService;
    }

    @PostMapping
    public String createShortUrl(@RequestBody PostCreate postCreate) {
        return shortTableService.create(postCreate);
    }

    @GetMapping("{postCreate}")
    public RedirectView redirect(@PathVariable String postCreate) {
        return new RedirectView(shortTableService.redirect(postCreate));
    }
}
