package com.techelevator.foodiary.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

public class Tag {

    @JsonProperty("tag_id")
    private int tagId;
    @JsonProperty("tag_type")
    @Min(value = 1, message = "The tag types range from 1 to 7.")
    @Max(value = 7, message = "The tag types range from 1 to 7.")
    private int tagType;
    @JsonProperty("tag_name")
    @NotBlank(message = "The field 'tagName' is required.")
    private String tagName;

    public Tag() {

    }

    public Tag(int tagId, int tagType, String tagName) {
        this.tagId = tagId;
        this.tagType = tagType;
        this.tagName = tagName;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public int getTagType() {
        return tagType;
    }

    public void setTagType(int tagType) {
        this.tagType = tagType;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return tagId == tag.tagId && tagType == tag.tagType && Objects.equals(tagName, tag.tagName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tagId, tagType, tagName);
    }

    @Override
    public String toString() {
        return "Tag{" +
                "tagId=" + tagId +
                ", tagType=" + tagType +
                ", tagName='" + tagName + '\'' +
                '}';
    }

}
