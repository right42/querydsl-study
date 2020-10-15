package me.right42.querydsl.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import me.right42.querydsl.domain.QStudy;
import me.right42.querydsl.domain.QUser;
import me.right42.querydsl.domain.Study;
import me.right42.querydsl.repository.dto.QStudyUsersDto;
import me.right42.querydsl.repository.dto.StudyUsersDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class StudyCustomRepositoryImpl implements StudyCustomRepository {

    private final JPAQueryFactory query;

    public StudyCustomRepositoryImpl(EntityManager entityManager) {
        query = new JPAQueryFactory(entityManager);
    }


    @Override
    public List<Study> findByName(String name) {
        QStudy study = QStudy.study;

        return query
                .selectFrom(study)
                .where(study.name.eq(name))
                .fetch()
            ;
    }

    @Override
    public List<Study> findContainsName(String name) {
        QStudy study = QStudy.study;

        return query
                .selectFrom(study)
                .where(study.name.like(name))
                .fetch()
            ;
    }

    @Override
    public List<Study> findByUsersId(Long usersId) {
        QStudy study = QStudy.study;
        QUser user = QUser.user;

        return query
            .selectFrom(study)
                .join(study.user, user)
                .fetchJoin()
            .where(user.id.eq(usersId))
            .fetch();
    }

    @Override
    public List<Study> findAllNameDesc() {
        QStudy study = QStudy.study;

        return query
            .selectFrom(study)
                .orderBy(study.name.desc())
            .fetch()
        ;
    }

    @Override
    public List<Study> findByNameWithSubQuery(String name) {
        QStudy study = QStudy.study;

        return query
            .selectFrom(study)
                .where(study.id.in(
                    JPAExpressions
                        .select(study.id)
                        .from(study)
                        .where(study.name.eq(name))
                ))
            .fetch();
    }

    @Override
    public StudyUsersDto findByStudyIdWithCustomDto(Long studyId) {
        QStudy study = QStudy.study;
        QUser user = QUser.user;

        return query
                .select(
                    new QStudyUsersDto(user.name, study.name, study.maximumNumber)
                )
                .from(study)
                    .innerJoin(user)
                    .on(user.id.eq(study.user.id))
                .where(study.id.eq(studyId))
                .fetchOne();

//        return query
//                .select(
//                    Projections.fields(StudyUsersDto.class, user.name.as("userName"), study.name.as("studyName"), study.maximumNumber)
//                )
//                .from(study)
//                    .innerJoin(user)
//                    .on(user.id.eq(study.user.id))
//                .where(study.id.eq(studyId))
//                .fetchOne();

//        return query
//            .select(
//                Projections.bean(StudyUsersDto.class, user.name, study.maximumNumber)
//            )
//            .from(study)
//                .innerJoin(user)
//                .on(user.id.eq(study.user.id))
//            .where(study.id.eq(studyId))
//            .fetchOne();
    }
}
