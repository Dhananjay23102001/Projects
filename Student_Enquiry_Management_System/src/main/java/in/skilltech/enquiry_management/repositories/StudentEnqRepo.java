package in.skilltech.enquiry_management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.skilltech.enquiry_management.entity_classes.AitStudentEnquiries;

public interface StudentEnqRepo extends JpaRepository<AitStudentEnquiries, Integer>{

	
}
