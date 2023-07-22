package in.skilltech.enquiry_management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.skilltech.enquiry_management.entity_classes.AitEnquiryStatus;

public interface EnqStatusRepo extends JpaRepository<AitEnquiryStatus, Integer> {

}
