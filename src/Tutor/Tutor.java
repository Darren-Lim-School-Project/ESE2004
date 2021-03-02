package Tutor;

import MainFrame.Login;

public class Tutor {

	private String tutorAdminNo;
	public Login login;
	private String department;

	public String getTutorAdminNo() {
		return tutorAdminNo;
	}

	public void setTutorAdminNo(String tutorAdminNo) {
		this.tutorAdminNo = tutorAdminNo;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
