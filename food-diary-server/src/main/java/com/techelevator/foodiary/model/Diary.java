package com.techelevator.foodiary.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

public class Diary {

    private int diaryId;
    @NotBlank(message = "The field 'diaryName' is required.")
    private String diaryName;
    @Min(value = 1, message = "The field 'userId' is required.")
    private int userId;

    public Diary() {

    }

    public Diary(int diaryId, String diaryName, int userId) {
        this.diaryId = diaryId;
        this.diaryName = diaryName;
        this.userId = userId;
    }

    public int getDiaryId() {
        return diaryId;
    }

    public void setDiaryId(int diaryId) {
        this.diaryId = diaryId;
    }

    public String getDiaryName() {
        return diaryName;
    }

    public void setDiaryName(String diaryName) {
        this.diaryName = diaryName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Diary diary = (Diary) o;
        return diaryId == diary.diaryId && userId == diary.userId && Objects.equals(diaryName, diary.diaryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(diaryId, diaryName, userId);
    }

    @Override
    public String toString() {
        return "Diary{" +
                "diaryId=" + diaryId +
                ", diaryName='" + diaryName + '\'' +
                ", userId=" + userId +
                '}';
    }
}
