package allServices;

import com.smartclassroom.service1.AttendanceGrpc.AttendanceImplBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.smartclassroom.service1.NotificationRequest;
import com.smartclassroom.service1.NotificationResponse;
import com.smartclassroom.service1.ReportRequest;
import com.smartclassroom.service1.ReportResponse;
import com.smartclassroom.service1.StudentAttendance;
import com.smartclassroom.service1.TrackRequest;
import com.smartclassroom.service1.TrackResponse;

import io.grpc.stub.StreamObserver;

public class AttendanceService extends AttendanceImplBase {
	
	
	
	static Map<String, StudentAttendance> attendanceRecord = new HashMap<>();
    static {
        attendanceRecord.put("1", StudentAttendance.newBuilder().setStudentID("1")
                .setStudentName("John")
                .setPresent(false).build());
        attendanceRecord.put("2", StudentAttendance.newBuilder().setStudentID("2")
                .setStudentName("Ram")
                .setPresent(false).build());
        attendanceRecord.put("3", StudentAttendance.newBuilder().setStudentID("3")
                .setStudentName("Ted")
                .setPresent(false).build());
        attendanceRecord.put("4", StudentAttendance.newBuilder().setStudentID("4")
                .setStudentName("Raj")
                .setPresent(false).build());
        attendanceRecord.put("5", StudentAttendance.newBuilder().setStudentID("5")
                .setStudentName("Lee")
                .setPresent(false).build());
    }

	@Override
	public void attendanceTracking(TrackRequest request, StreamObserver<TrackResponse> responseObserver) {
		
		  String studentID = request.getStudentID();
	        String RFID = request.getRFID();

	        if (attendanceRecord.containsKey(studentID)) {
	            StudentAttendance.Builder studentBuilder = attendanceRecord.get(studentID).toBuilder();
	            studentBuilder.setPresent(true);
	            attendanceRecord.put(studentID, studentBuilder.build());

	            boolean success = true;
	            String message = "Student details received for Student ID: " + studentID;

	            TrackResponse response = TrackResponse.newBuilder()
	                    .setSuccess(success)
	                    .setMessage(message)
	                    .build();

	            responseObserver.onNext(response);
	            responseObserver.onCompleted();
	        } else {
	            boolean success = false;
	            String message = "Student ID not found: " + studentID;

	            TrackResponse response = TrackResponse.newBuilder()
	                    .setSuccess(success)
	                    .setMessage(message)
	                    .build();

	            responseObserver.onNext(response);
	            responseObserver.onCompleted();
	        }
	
	}

	@Override
	public void attendanceReport(ReportRequest request, StreamObserver<ReportResponse> responseObserver) {
		ReportResponse.Builder responseBuilder = ReportResponse.newBuilder();
        List<StudentAttendance> studentAttendances = new ArrayList<>();

        for (Map.Entry<String, StudentAttendance> entry : attendanceRecord.entrySet()) {
            studentAttendances.add(entry.getValue());

        }
        
        responseBuilder.addAllStudentAttendances(studentAttendances);
        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
	}

	@Override
	public void attendanceNotification(NotificationRequest request,
			StreamObserver<NotificationResponse> responseObserver) {
		List<String> messages = new ArrayList<>();

        for (Map.Entry<String, StudentAttendance> entry : attendanceRecord.entrySet()) {
            if (!entry.getValue().getPresent()) {
                String message = "Email sent to parent for student ID: " + entry.getValue().getStudentID();
                messages.add(message);
            }
        }

        NotificationResponse response = NotificationResponse.newBuilder()
                .addAllMessages(messages)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();

	}
	
	
	
	
	
}