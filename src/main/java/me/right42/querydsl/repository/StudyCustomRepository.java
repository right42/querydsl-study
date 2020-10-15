package me.right42.querydsl.repository;

import me.right42.querydsl.domain.Study;
import me.right42.querydsl.repository.dto.StudyUsersDto;

import java.util.List;

public interface StudyCustomRepository {

    List<Study> findByName(String name);

    List<Study> findContainsName(String name);

    List<Study> findByUsersId(Long usersId);

    List<Study> findAllNameDesc();

    List<Study> findByNameWithSubQuery(String name);

    StudyUsersDto findByStudyIdWithCustomDto(Long studyId);
}
