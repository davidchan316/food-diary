package com.techelevator.foodiary.service;

import com.techelevator.foodiary.dao.TagDao;
import com.techelevator.foodiary.model.Tag;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    private TagDao tagDao;

    public TagService(TagDao tagDao) {
        this.tagDao = tagDao;
    }

    public List<Tag> listAllTags() {
        return tagDao.listAllTags();
    }

}
