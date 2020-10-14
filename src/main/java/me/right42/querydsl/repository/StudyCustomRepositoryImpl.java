package me.right42.querydsl.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class StudyCustomRepositoryImpl implements StudyCustomRepository {

    private final JPAQueryFactory query;

    public StudyCustomRepositoryImpl(EntityManager entityManager) {
        query = new JPAQueryFactory(entityManager);
    }



}
