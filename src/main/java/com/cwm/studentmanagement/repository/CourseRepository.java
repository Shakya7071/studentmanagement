package com.cwm.studentmanagement.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cwm.studentmanagement.model.Courses;

public interface CourseRepository extends JpaRepository<Courses, Long> {
	
	
	boolean existsByCourseCodeIgnoreCase(String code);
	
	boolean existsByCourseCodeIgnoreCaseAndIdNot(String code, Long id);
	
	Page<Courses> findByActiveTrue(Pageable pageable);

}
