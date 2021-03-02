package MainFrame;

import Student.Module;
import Student.studentCheckIn;

public class Login {

	private String password;
	public Module module;
	private String username;
	private Boolean isStudent;

	private Login tempLogUser;

	private int userID;
	private String tempUsername;
	private String tempPassword;
	private Boolean tempIsStudent;
	private String checkInTime;

	private String imageName;
	private String imageType;

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public Login(String userName, String passWord) {
		this.username = userName;
		this.password = passWord;
	}

	public Login(int id, String userName, String passWord, Boolean isStudentOrTutor, String imageName,
			String imageType) {
		this.userID = id;
		this.tempUsername = userName;
		this.tempPassword = passWord;
		this.tempIsStudent = isStudentOrTutor;
		this.imageName = imageName;
		this.imageType = imageType;
	}

	public Login(int id, String userName, String passWord) {
		this.userID = id;
		this.username = userName;
		this.password = passWord;
	}

	public Login(int id, String userName, String passWord, String dateAndTime) {
		this.userID = id;
		this.username = userName;
		this.password = passWord;
		this.checkInTime = dateAndTime;
	}

	public Login() {

	}

	public String getTempUsername() {

		return tempUsername;
	}

	public void setUserID(int userID) {

		this.userID = userID;
	}

	public int getUserID() {

		return userID;
	}

	public void setTempUsername(String username) {

		this.tempUsername = username;
	}

	public String getTempPassword() {

		return tempPassword;
	}

	public void setTempPassword(String password) {

		this.tempPassword = password;
	}

	public Boolean getTempIsStudent() {

		return tempIsStudent;
	}

	public void setTempIsStudent(Boolean isStudent) {

		this.tempIsStudent = isStudent;
	}

	public String getPassword() {

		return password;
	}

	public void setTempLoginInfo(Login username) {
		this.tempLogUser = username;
	}

	public Login getTempLoginInfo() {
		return tempLogUser;
	}

	public void setPassword(String password) {
		this.password = password;

	}

	public Module getModule() {

		return module;
	}

	public void setModule(Module module) {

		this.module = module;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {

		this.username = username;
	}

	public Boolean getIsStudent() {

		return isStudent;
	}

	public void setIsStudent(Boolean isStudent) {

		this.isStudent = isStudent;
	}

	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
	}

	public String getCheckInTime() {
		return checkInTime;
	}

	public Login setCheckinTime(String format) {

		return null;
	}

}
