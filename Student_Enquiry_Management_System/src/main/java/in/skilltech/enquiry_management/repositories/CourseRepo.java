package in.skilltech.enquiry_management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.skilltech.enquiry_management.entity_classes.AitCourses;

public interface CourseRepo extends JpaRepository<AitCourses, Integer> {

}
