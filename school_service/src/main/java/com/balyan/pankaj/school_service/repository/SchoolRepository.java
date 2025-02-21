package com.balyan.pankaj.school_service.repository;

import com.balyan.pankaj.school_service.model.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {
}
