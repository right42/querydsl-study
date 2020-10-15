package me.right42.querydsl.repository;

import me.right42.querydsl.domain.Study;
import me.right42.querydsl.repository.dto.StudyUsersDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.io.UnsupportedEncodingException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Sql(scripts = "classpath:data-test.sql")
class StudyCustomRepositoryImplTest {

    @Autowired
    StudyRepository studyRepository;

    @Test
    void find(){
        Study study = studyRepository.findById(1L).get();

        assertThat(study).isNotNull();
        assertThat(study.getName()).isEqualTo("JPA1");
        assertThat(study.getMaximumNumber()).isEqualTo(1);
    }

    @Test
    void findByName(){
        String name = "JPA2";

        List<Study> byNames = studyRepository.findByName(name);

        assertThat(byNames).isNotNull();
        assertThat(byNames.size()).isEqualTo(1);
    }

    @Test
    void findContainsName() throws UnsupportedEncodingException {
        String name = "JPA";

        List<Study> byNames = studyRepository.findContainsName(name);

        assertThat(byNames).isNotNull();

    }

    @Test
    void findByUsersId(){
        Long usersId = 1L;

        List<Study> byUsersId = studyRepository.findByUsersId(usersId);

        assertThat(byUsersId).isNotNull();
        assertThat(byUsersId.size()).isEqualTo(2);
        assertThat(byUsersId.get(0).getUser().getName()).isEqualTo("TEST1");
    }

    @Test
    void findAllNameDesc(){

        List<Study> allNameDesc = studyRepository.findAllNameDesc();

        assertThat(allNameDesc).isNotNull();
        assertThat(allNameDesc.size()).isEqualTo(7);
        assertThat(allNameDesc.get(0).getName()).isEqualTo("JPA7");

    }

    @Test
    void findByNameWithSubQuery(){
        String name = "JPA1";

        List<Study> byNameWithSubQuery = studyRepository.findByNameWithSubQuery(name);

        assertThat(byNameWithSubQuery).isNotNull();
    }

    @Test
    void findByUsersIdWithCustomDto(){
        Long studyId = 1L;

        StudyUsersDto studyUsersDto = studyRepository.findByStudyIdWithCustomDto(studyId);

        assertThat(studyUsersDto).isNotNull();
        assertThat(studyUsersDto.getUserName()).isEqualTo("TEST1");
        assertThat(studyUsersDto.getStudyName()).isEqualTo("JPA1");

    }
}