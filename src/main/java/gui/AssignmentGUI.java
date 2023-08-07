package gui;

import com.smartclassroom.service2.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

public class AssignmentGUI extends JFrame {

    private static final String SERVICE_TYPE = "_grpc._tcp.local.";
    private static final String SERVICE_NAME = "Assignment";

    private final JTextField subjectNameField;
    private final JTextField assignmentField;
    private final JTextField attachmentField;
    private final JTextField subjectField;
    private final JTextField dateField;
    private final JTextArea responseAreaDetail;
    private final JTextArea responseAreaSubmission;
    private final List<SubmitRequest> assignmentSubmissions;

    private final JTextArea remindersArea;
    private final JTextField reminderSubjectField;


    public AssignmentGUI() {

        this.assignmentSubmissions = new ArrayList<>();

        JTabbedPane tabbedPane = new JTabbedPane();

        setTitle("Assignment Client");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Details
        JPanel mainDetailPanel = new JPanel(new BorderLayout());
        subjectNameField = new JTextField(20);
        responseAreaDetail = new JTextArea(10, 30);
        responseAreaDetail.setEditable(false);

        JButton sendButton = new JButton("Get Detail");
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getAssignmentDetail();
            }
        });

        JPanel detailPanel = new JPanel();
        detailPanel.setLayout(new FlowLayout());
        detailPanel.add(new JLabel("Subject Name:"));
        detailPanel.add(subjectNameField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(sendButton);

        JScrollPane scrollPane = new JScrollPane(responseAreaDetail);

        mainDetailPanel.add(detailPanel, BorderLayout.NORTH);
        mainDetailPanel.add(buttonPanel, BorderLayout.CENTER);
        mainDetailPanel.add(scrollPane, BorderLayout.SOUTH);

        // Submission
        JPanel submissionPanel = new JPanel(new BorderLayout());
        subjectField = new JTextField(20);
        assignmentField = new JTextField(20);
        attachmentField = new JTextField(20);
        dateField = new JTextField(10);
        responseAreaSubmission = new JTextArea(10, 30);
        responseAreaSubmission.setEditable(false);

        JButton addButton = new JButton("Add Assignment");
        addButton.addActionListener(e -> {
            String subject = subjectField.getText().trim();
            String assignment = assignmentField.getText().trim();
            String attachment = attachmentField.getText().trim();
            String date = dateField.getText().trim();

            SubmitRequest request = SubmitRequest.newBuilder()
                    .setSubjectName(subject)
                    .setAssignment(assignment)
                    .setAttachment(attachment)
                    .setCurrentDate(date)
                    .build();
            assignmentSubmissions.add(request);

            responseAreaSubmission.append("Added: " + assignment + "\n");
        });

        JButton submitButton = new JButton("Submit All");
        submitButton.addActionListener(e -> submitAssignments(assignmentSubmissions));


        JPanel assignmentPanel = new JPanel();
        assignmentPanel.setLayout(new FlowLayout());

        assignmentPanel.add(new JLabel("Subject:"));
        assignmentPanel.add(subjectField);
        assignmentPanel.add(new JLabel("Assignment:"));
        assignmentPanel.add(assignmentField);
        assignmentPanel.add(new JLabel("Attachment:"));
        assignmentPanel.add(attachmentField);
        assignmentPanel.add(new JLabel("Date:"));
        assignmentPanel.add(dateField);
        assignmentPanel.add(addButton);
        assignmentPanel.add(submitButton);

        JScrollPane scrollPane2 = new JScrollPane(responseAreaSubmission);

        BoxLayout boxLayout = new BoxLayout(submissionPanel, BoxLayout.Y_AXIS);
        submissionPanel.setLayout(boxLayout);
        submissionPanel.add(assignmentPanel);
        submissionPanel.add(scrollPane2);


        // Reminder
        JPanel reminderPanel = new JPanel(new BorderLayout());
        reminderSubjectField = new JTextField(20);
        remindersArea = new JTextArea(10, 30);
        remindersArea.setEditable(false);

        JButton reminderButton = new JButton("Get Reminder");
        reminderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                assignmentReminder();
            }
        });

        JPanel reminderDetailPanel = new JPanel();
        reminderDetailPanel.setLayout(new FlowLayout());
        reminderDetailPanel.add(new JLabel("Subject Name:"));
        reminderDetailPanel.add(reminderSubjectField);

        JPanel reminderButtonPanel = new JPanel();
        reminderButtonPanel.setLayout(new FlowLayout());
        reminderButtonPanel.add(reminderButton);

        JScrollPane scrollReminderPane = new JScrollPane(remindersArea);

        reminderPanel.add(reminderDetailPanel, BorderLayout.NORTH);
        reminderPanel.add(reminderButtonPanel, BorderLayout.CENTER);
        reminderPanel.add(scrollReminderPane, BorderLayout.SOUTH);

        // tabbed pane
        tabbedPane.addTab("Detail", mainDetailPanel);
        tabbedPane.addTab("Submission", submissionPanel);
        tabbedPane.addTab("Reminder", reminderPanel);
        setLayout(new BorderLayout());
        add(tabbedPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AssignmentGUI clientGUI = new AssignmentGUI();
            clientGUI.setVisible(true);
        });
    }

    public void getAssignmentDetail() {
        responseAreaDetail.setText("");
        String subjectName = subjectNameField.getText();

        if (subjectName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Subject name.");
            return;
        }

        try {
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            ServiceInfo serviceInfo = jmdns.getServiceInfo(SERVICE_TYPE, SERVICE_NAME);
            if (serviceInfo == null) {
                JOptionPane.showMessageDialog(this, "Assignment service not found.");
                return;
            }

            String host = serviceInfo.getHostAddresses()[0];
            int port = serviceInfo.getPort();
            ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
                    .usePlaintext()
                    .build();

            AssignmentSubmissionGrpc.AssignmentSubmissionBlockingStub blockingStub = AssignmentSubmissionGrpc.newBlockingStub(channel);

            DetailRequest request = DetailRequest.newBuilder()
                    .setSubjectName(subjectName)
                    .build();

            DetailResponse response = blockingStub.assignmentDetail(request);

            if (response == null || response.getAssignmentNo().isEmpty()) {
                responseAreaDetail.setText("No assignment exists for given subject OR Assignment already submitted OR Invalid Subject name.");
            } else {
                responseAreaDetail.setText(response.toString());
            }

            channel.shutdown();
        } catch (IOException ex) {
            ex.printStackTrace();
            responseAreaDetail.setText("Error connecting to the Assignment service.");
        }
    }

    public void submitAssignments(List<SubmitRequest> assignmentSubmissions) {
        try {
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            ServiceInfo serviceInfo = jmdns.getServiceInfo(SERVICE_TYPE, SERVICE_NAME);
            if (serviceInfo == null) {
                JOptionPane.showMessageDialog(this, "Assignment service not found.");
                return;
            }

            String host = serviceInfo.getHostAddresses()[0];
            int port = serviceInfo.getPort();
            ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
                    .usePlaintext()
                    .build();

            AssignmentSubmissionGrpc.AssignmentSubmissionStub stub = AssignmentSubmissionGrpc.newStub(channel);

            StreamObserver<SubmitRequest> requestObserver = stub.assignmentSubmission(new StreamObserver<SubmitResponse>() {
                @Override
                public void onNext(SubmitResponse response) {
                    for (String status : response.getStatusList()) {
                        responseAreaSubmission.append(status + "\n");
                    }
                }

                @Override
                public void onError(Throwable t) {
                    responseAreaSubmission.append("Error: " + t.getMessage() + "\n");
                }

                @Override
                public void onCompleted() {
                    responseAreaSubmission.append("Submission complete.\n");
                }
            });

            for (SubmitRequest request : assignmentSubmissions) {
                requestObserver.onNext(request);
            }
            requestObserver.onCompleted();
        } catch (IOException ex) {
            ex.printStackTrace();
            responseAreaSubmission.setText("Error connecting to the Attendance service.");
        }
    }


    public void assignmentReminder() {
        String subjectName = reminderSubjectField.getText();

        if (subjectName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Subject name.");
            return;
        }

        try {
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            ServiceInfo serviceInfo = jmdns.getServiceInfo(SERVICE_TYPE, SERVICE_NAME);
            if (serviceInfo == null) {
                JOptionPane.showMessageDialog(this, "Assignment service not found.");
                return;
            }

            String host = serviceInfo.getHostAddresses()[0];
            int port = serviceInfo.getPort();
            ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
                    .usePlaintext()
                    .build();

            AssignmentSubmissionGrpc.AssignmentSubmissionStub asyncStub = AssignmentSubmissionGrpc.newStub(channel);


            StreamObserver<ReminderRequest> requestObserver = asyncStub.assignmentReminder(new StreamObserver<ReminderResponse>() {
                @Override
                public void onNext(ReminderResponse response) {
                    remindersArea.append(response.getReminder() + "\n");
                }

                @Override
                public void onError(Throwable t) {
                    remindersArea.append("Error: " + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    remindersArea.append("Completed.\n");
                }
            });

            requestObserver.onNext(ReminderRequest.newBuilder().setSubject(subjectName).build());

        } catch (IOException ex) {
            ex.printStackTrace();
            remindersArea.setText("Error connecting to the Assignment service.");
        }
    }

}
