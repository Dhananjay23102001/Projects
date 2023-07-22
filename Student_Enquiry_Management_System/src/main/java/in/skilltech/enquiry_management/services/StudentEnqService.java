package in.skilltech.enquiry_management.services;

import java.util.List;

import in.skilltech.enquiry_management.bind.DashboardBindResponse;
import in.skilltech.enquiry_management.bind.EnquirySearchCriteria;
import in.skilltech.enquiry_management.bind.StudentEnquiryForm;
import in.skilltech.enquiry_management.entity_classes.AitStudentEnquiries;

public interface StudentEnqService {

	public DashboardBindResponse getDashBoardData(Integer userId);

	public List<String> getCourses();

	public List<String> getEnqStatus();

	public boolean saveEnquiries(StudentEnquiryForm form);

	public List<AitStudentEnquiries> getEnquiries();

	public List<AitStudentEnquiries> getFilterEnquiries(EnquirySearchCriteria criteria, Integer userId);

}
