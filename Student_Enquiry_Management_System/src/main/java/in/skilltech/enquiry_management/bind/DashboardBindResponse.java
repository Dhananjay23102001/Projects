package in.skilltech.enquiry_management.bind;

import lombok.Data;

@Data
public class DashboardBindResponse {

	private Integer totalEnqCount;

	private Integer enrolledCount;

	private Integer lostCount;

	private Integer newCount;
}
