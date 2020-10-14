package me.right42.querydsl.repository;

import me.right42.querydsl.domain.Study;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyRepository extends JpaRepository<Study, Long>, StudyCustomRepository {
}
