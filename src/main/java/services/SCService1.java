package services;

import java.util.ArrayList;
import java.util.List;

import com.smartClass.SCService1.SCService1Grpc.SCService1ImplBase;
import com.smartClass.SCService1.getStudentAttendanceRequest;
import com.smartClass.SCService1.getStudentAttendanceResponse;
import com.smartClass.SCService1.setStudentAttendanceRequest;
import com.smartClass.SCService1.setStudentAttendanceResponse;

import io.grpc.stub.StreamObserver;
import model.Student;

public class SCService1 extends SCService1ImplBase {
	
	private List<Student> students = new ArrayList<>();

	@Override
	public void setStudentAttendance(setStudentAttendanceRequest request,
			StreamObserver<setStudentAttendanceResponse> responseObserver) {
		
		String studentId = request.getStudentID();
		String rfid = request.getStudentRFIDstatus();
		
		setStudentAttendanceResponse.Builder response = setStudentAttendanceResponse.newBuilder();
	
		Student student = new Student(studentId, rfid);
		students.add(student);
		
		response.setResponseCode(0).setResponseMessage("SUCCESS");
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	
	
	}

	@Override
	public void getStudentAttendance(getStudentAttendanceRequest request,
			StreamObserver<getStudentAttendanceResponse> responseObserver) {
		
		getStudentAttendanceResponse.Builder response = getStudentAttendanceResponse.newBuilder();
		
		response.setResponseCode(0).setResponseMessage(students.get(0).toString());
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	
	}
	
	
	
}