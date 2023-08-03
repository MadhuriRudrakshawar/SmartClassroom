package model;


public class Student {
	
	private String studentId;
	
	private String rfid;
	
	public Student() {
	}

	public Student(String studentId, String rfid) {
		// TODO Auto-generated constructor stub
		this.studentId = studentId;
		this.rfid = rfid;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", rfid=" + rfid + "]";
	}
}
