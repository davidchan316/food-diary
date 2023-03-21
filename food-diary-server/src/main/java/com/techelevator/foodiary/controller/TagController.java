package com.techelevator.foodiary.controller;

import com.techelevator.foodiary.model.Tag;
import com.techelevator.foodiary.service.TagService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
public class TagController {

    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping("/tags")
    @PreAuthorize("permitAll")
    public List<Tag> getTags() {
        return tagService.getTags();
    }

}
