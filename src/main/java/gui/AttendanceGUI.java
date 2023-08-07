package gui;


import com.smartclassroom.service1.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import javax.swing.*;

import com.smartclassroom.service1.AttendanceGrpc;
import com.smartclassroom.service1.ReportRequest;
import com.smartclassroom.service1.StudentAttendance;
import com.smartclassroom.service1.TrackRequest;
import com.smartclassroom.service1.TrackResponse;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AttendanceGUI extends JFrame {

    private static final String SERVICE_TYPE = "_grpc._tcp.local.";
    private static final String SERVICE_NAME = "Attendance";

    private final JTextField studentIDField;
    private final JTextField rfidField;
    private final JTextArea resultArea;

    public AttendanceGUI() {
        setTitle("Attendance Client");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        studentIDField = new JTextField(20);
        rfidField = new JTextField(20);
        resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false);

        JButton trackingButton = new JButton("Track Attendance");
        trackingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trackAttendance();
            }
        });

        JButton reportButton = new JButton("Attendance Report");
        reportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getAttendanceReport();
            }
        });

        JButton notificationButton = new JButton("Notification");
        notificationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendAttendanceNotification();
            }
        });

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        inputPanel.add(new JLabel("Student ID: "));
        inputPanel.add(studentIDField);
        inputPanel.add(new JLabel("RFID: "));
        inputPanel.add(rfidField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(trackingButton);
        buttonPanel.add(reportButton);
        buttonPanel.add(notificationButton);

        JScrollPane scrollPane = new JScrollPane(resultArea);

        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AttendanceGUI clientGUI = new AttendanceGUI();
            clientGUI.setVisible(true);
        });
    }

    public void trackAttendance() {
        resultArea.setText("");
        String studentID = studentIDField.getText();
        String rfid = rfidField.getText();

        if (studentID.isEmpty() || rfid.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Student ID and RFID.");
            return;
        }

        try {
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            ServiceInfo serviceInfo = jmdns.getServiceInfo(SERVICE_TYPE, SERVICE_NAME);
            if (serviceInfo == null) {
                JOptionPane.showMessageDialog(this, "Attendance service not found.");
                return;
            }

            String host = serviceInfo.getHostAddresses()[0];
            int port = serviceInfo.getPort();
            ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
                    .usePlaintext()
                    .build();

            AttendanceGrpc.AttendanceBlockingStub blockingStub = AttendanceGrpc.newBlockingStub(channel);

            TrackRequest request = TrackRequest.newBuilder()
                    .setStudentID(studentID)
                    .setRFID(rfid)
                    .build();

            TrackResponse response = blockingStub.attendanceTracking(request);

            if (response.getSuccess()) {
                resultArea.setText("Student details received: " + response.getMessage());
            } else {
                resultArea.setText("Absent: " + response.getMessage());
            }

            channel.shutdown();
        } catch (IOException ex) {
            ex.printStackTrace();
            resultArea.setText("Error connecting to the Attendance service.");
        }
    }

    public void getAttendanceReport() {
        resultArea.setText("");
        try {
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            ServiceInfo serviceInfo = jmdns.getServiceInfo(SERVICE_TYPE, SERVICE_NAME);
            if (serviceInfo == null) {
                JOptionPane.showMessageDialog(this, "Attendance service not found.");
                return;
            }

            String host = serviceInfo.getHostAddresses()[0];
            int port = serviceInfo.getPort();
            ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
                    .usePlaintext()
                    .build();

            AttendanceGrpc.AttendanceBlockingStub blockingStub = AttendanceGrpc.newBlockingStub(channel);

            ReportRequest request = ReportRequest.newBuilder()
                    .build();

            blockingStub.attendanceReport(request).forEachRemaining(response -> {
                for (StudentAttendance studentAttendance : response.getStudentAttendancesList()) {
                    String studentID = studentAttendance.getStudentID();
                    String studentName = studentAttendance.getStudentName();
                    boolean present = studentAttendance.getPresent();

                    String resultText = "Student ID: " + studentID + "\n"
                            + "Student Name: " + studentName + "\n"
                            + "Present: " + present + "\n"
                            + "---------------------------------\n";
                    resultArea.append(resultText);
                }


            });

            channel.shutdown();
        } catch (IOException ex) {
            ex.printStackTrace();
            resultArea.setText("Error connecting to the Attendance service.");
        }
    }


    public void sendAttendanceNotification() {
        resultArea.setText("");
        try {
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            ServiceInfo serviceInfo = jmdns.getServiceInfo(SERVICE_TYPE, SERVICE_NAME);
            if (serviceInfo == null) {
                JOptionPane.showMessageDialog(this, "Attendance service not found.");
                return;
            }

            String host = serviceInfo.getHostAddresses()[0];
            int port = serviceInfo.getPort();
            ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
                    .usePlaintext()
                    .build();

            AttendanceGrpc.AttendanceBlockingStub blockingStub = AttendanceGrpc.newBlockingStub(channel);

            NotificationRequest request = NotificationRequest.newBuilder().build();

            blockingStub.attendanceNotification(request).forEachRemaining(response -> {
                List<String> emailStatuses = response.getMessagesList();
                for (String emailStatus : emailStatuses) {
                    resultArea.append(emailStatus + "\n");
                }
            });

            channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
            resultArea.setText("Error connecting to the Attendance service.");
        }
    }

}
