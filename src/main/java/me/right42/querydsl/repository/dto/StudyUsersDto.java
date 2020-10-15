package me.right42.querydsl.repository.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class StudyUsersDto {

    private final String userName;

    private final String studyName;

    private final Integer maximumNumber;

    @QueryProjection
    public StudyUsersDto(String userName, String studyName, Integer maximumNumber) {
        this.userName = userName;
        this.studyName = studyName;
        this.maximumNumber = maximumNumber;
    }
}
