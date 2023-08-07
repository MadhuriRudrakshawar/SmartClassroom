package allServices;

import com.smartclassroom.service2.AssignmentSubmissionGrpc.AssignmentSubmissionImplBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.smartclassroom.service2.DetailRequest;
import com.smartclassroom.service2.DetailResponse;
import com.smartclassroom.service2.ReminderRequest;
import com.smartclassroom.service2.ReminderResponse;
import com.smartclassroom.service2.SubmitRequest;
import com.smartclassroom.service2.SubmitResponse;

import io.grpc.stub.StreamObserver;

public class AssignmentService extends AssignmentSubmissionImplBase{
	
	private final Set<String> currentReminders = new HashSet<>();
    static Map<String, DetailResponse> assignmentDetails = new HashMap<>();
    static {
        assignmentDetails.put("Physics", DetailResponse.newBuilder().setAssignmentNo("1")
                .setAssignmentDetails("Einstein's Theory of Relativity")
                .setDueDate("15-08-2023").build());
        assignmentDetails.put("Chemistry", DetailResponse.newBuilder().setAssignmentNo("2")
                .setAssignmentDetails("Atomic Structure")
                .setDueDate("20-08-2023").build());
        assignmentDetails.put("Biology", DetailResponse.newBuilder().setAssignmentNo("3")
                .setAssignmentDetails("Theories of Evolution")
                .setDueDate("25-08-2023").build());
        assignmentDetails.put("Maths", DetailResponse.newBuilder().setAssignmentNo("4")
                .setAssignmentDetails("Statistics and Probability")
                .setDueDate("30-08-2023").build());
        assignmentDetails.put("ComputerScience", DetailResponse.newBuilder().setAssignmentNo("5")
                .setAssignmentDetails("Artificial intelligence")
                .setDueDate("05-09-2023").build());
    }


	@Override
	public void assignmentDetail(DetailRequest request, StreamObserver<DetailResponse> responseObserver) {

		String subjectName = request.getSubjectName();


        if (assignmentDetails.containsKey(subjectName)) {
            DetailResponse detailsResponse = assignmentDetails.get(subjectName);

            responseObserver.onNext(detailsResponse);
            responseObserver.onCompleted();
        } else {
            responseObserver.onNext(null);
            responseObserver.onCompleted();
        }

	
	}

	@Override
	public StreamObserver<SubmitRequest> assignmentSubmission(StreamObserver<SubmitResponse> responseObserver) {
		return new StreamObserver<SubmitRequest>() {
            final List<String> statuses = new ArrayList<>();

            @Override
            public void onNext(SubmitRequest request) {
                if (assignmentDetails.containsKey(request.getSubjectName())) {
                    String status = "Assignment for subject: " + request.getSubjectName() + " submitted on " + request.getCurrentDate() + ".";
                    statuses.add(status);
                    assignmentDetails.remove(request.getSubjectName());
                } else {
                    String status = "Assignment already submitted for subject: " + request.getSubjectName() + " OR Subject doesn't exist.";
                    statuses.add(status);
                }
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error receiving request: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                SubmitResponse response = SubmitResponse.newBuilder().addAllStatus(statuses).build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }
        };

	}


	@Override
	public StreamObserver<ReminderRequest> assignmentReminder(StreamObserver<ReminderResponse> responseObserver) {
		 ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

	        executor.scheduleAtFixedRate(() -> {
	            synchronized (currentReminders) {
	                for (String subject : currentReminders) {
	                    ReminderResponse reminder = ReminderResponse.newBuilder().setReminder(subject +" assignment is due.").build();
	                    responseObserver.onNext(reminder);
	                }
	            }
	        }, 10, 10, TimeUnit.SECONDS);

	        return new StreamObserver<ReminderRequest>() {
	            @Override
	            public void onNext(ReminderRequest request) {
	                synchronized (currentReminders) {
	                    String subject = request.getSubject();
	                    if (currentReminders.contains(subject)) {
	                        currentReminders.remove(subject);
	                        responseObserver.onNext(ReminderResponse.newBuilder().setReminder(subject + ": Subject reminder removed.").build());
	                    } else if (assignmentDetails.containsKey(subject)) {
	                        currentReminders.add(subject);
	                        responseObserver.onNext(ReminderResponse.newBuilder().setReminder(subject + ": Subject reminder added.").build());
	                    } else {
	                        responseObserver.onNext(ReminderResponse.newBuilder().setReminder(subject + ": Subject not found!").build());
	                    }
	                }
	            }

	            @Override
	            public void onError(Throwable t) {
	                executor.shutdownNow();
	            }

	            @Override
	            public void onCompleted() {
	                executor.shutdownNow();
	                responseObserver.onCompleted();
	            }
	        };
	    }

	}
	