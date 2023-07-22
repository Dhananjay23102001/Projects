package in.skilltech.enquiry_management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.skilltech.enquiry_management.entity_classes.AitAdminDetails;

public interface AdminDtlsRepo extends JpaRepository<AitAdminDetails,Integer> {

	public AitAdminDetails findByAdminEmailAndAdminPassword(String adminEmail,String adminPassword);

}
