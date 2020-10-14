package me.right42.querydsl.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class StudyCustomRepositoryImplTest {

    @Autowired
    StudyRepository studyRepository;

    @Test
    void init(){

    }

}