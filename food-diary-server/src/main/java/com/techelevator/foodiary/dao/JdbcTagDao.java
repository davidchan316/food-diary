package com.techelevator.foodiary.dao;

import com.techelevator.foodiary.model.Tag;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTagDao implements TagDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcTagDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Tag> listAllTags() {
        List<Tag> tags = new ArrayList<>();
        String sql = "SELECT tag_id, tag_type, tag_name FROM tag";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Tag tag = mapRowToTag(results);
            tags.add(tag);
        }

        return tags;
    }

    private Tag mapRowToTag(SqlRowSet rowSet) {
        Tag tag = new Tag();
        tag.setTagId(rowSet.getInt("tag_id"));
        tag.setTagType(rowSet.getInt("tag_type"));
        tag.setTagName(rowSet.getString("tag_name"));
        return tag;
    }
}
