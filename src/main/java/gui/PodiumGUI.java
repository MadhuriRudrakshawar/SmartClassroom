package gui;

import com.smartclassroom.service3.*;
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

public class PodiumGUI extends JFrame {

    private static final String SERVICE_TYPE = "_grpc._tcp.local.";
    private static final String SERVICE_NAME = "PodiumControl";

    private final JTextField teacherIdField;
    private final JTextField passCodeField;
    private final JTextField projectorPin;
    private final JTextField projectorId;
    private final JTextArea loginResponseArea;
    private final JTextArea projectorResponseArea;
    private final JTextArea ioResponseArea;
    private final JTextField deviceNameField;

    public PodiumGUI() {

        JTabbedPane tabbedPane = new JTabbedPane();

        setTitle("Podium Client");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Login
        JPanel loginPanel = new JPanel(new BorderLayout());
        teacherIdField = new JTextField(20);
        passCodeField = new JTextField(20);
        loginResponseArea = new JTextArea(10, 30);
        loginResponseArea.setEditable(false);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                teacherLogin();
            }
        });

        JPanel loginDetailPanel = new JPanel();
        loginDetailPanel.setLayout(new FlowLayout());
        loginDetailPanel.add(new JLabel("Teacher ID:"));
        loginDetailPanel.add(teacherIdField);
        loginDetailPanel.add(new JLabel("PassCode:"));
        loginDetailPanel.add(passCodeField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(loginButton);

        JScrollPane scrollPane = new JScrollPane(loginResponseArea);

        loginPanel.add(loginDetailPanel, BorderLayout.NORTH);
        loginPanel.add(buttonPanel, BorderLayout.CENTER);
        loginPanel.add(scrollPane, BorderLayout.SOUTH);

        // Projector
        JPanel projectorPanel = new JPanel(new BorderLayout());
        projectorId = new JTextField(20);
        projectorPin = new JTextField(20);
        projectorResponseArea = new JTextArea(10, 30);
        projectorResponseArea.setEditable(false);

        JButton accessButton = new JButton("Projector Login");
        accessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                projectorAccess();
            }
        });

        JPanel podiumPanel = new JPanel();
        podiumPanel.setLayout(new FlowLayout());

        podiumPanel.add(new JLabel("Projector ID:"));
        podiumPanel.add(projectorId);
        podiumPanel.add(new JLabel("Access Pin:"));
        podiumPanel.add(projectorPin);
        podiumPanel.add(accessButton);

        JScrollPane scrollPane2 = new JScrollPane(projectorResponseArea);

        BoxLayout boxLayout = new BoxLayout(projectorPanel, BoxLayout.Y_AXIS);
        projectorPanel.setLayout(boxLayout);
        projectorPanel.add(podiumPanel);
        projectorPanel.add(scrollPane2);


        // IO Interface
        JPanel ioPanel = new JPanel(new BorderLayout());
        deviceNameField = new JTextField(20);
        ioResponseArea = new JTextArea(10, 30);
        ioResponseArea.setEditable(false);

        JButton reminderButton = new JButton("Connect/Disconnect");
        reminderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                podiumControl();
            }
        });

        JPanel ioDetailPanel = new JPanel();
        ioDetailPanel.setLayout(new FlowLayout());
        ioDetailPanel.add(new JLabel("Device name:"));
        ioDetailPanel.add(deviceNameField);

        JPanel reminderButtonPanel = new JPanel();
        reminderButtonPanel.setLayout(new FlowLayout());
        reminderButtonPanel.add(reminderButton);

        JScrollPane scrollReminderPane = new JScrollPane(ioResponseArea);

        ioPanel.add(ioDetailPanel, BorderLayout.NORTH);
        ioPanel.add(reminderButtonPanel, BorderLayout.CENTER);
        ioPanel.add(scrollReminderPane, BorderLayout.SOUTH);

        // tabbed pane
        tabbedPane.addTab("Teacher Login", loginPanel);
        tabbedPane.addTab("Projector Access", projectorPanel);
        tabbedPane.addTab("IO Interface", ioPanel);
        setLayout(new BorderLayout());
        add(tabbedPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PodiumGUI clientGUI = new PodiumGUI();
            clientGUI.setVisible(true);
        });
    }

    public void teacherLogin() {
        loginResponseArea.setText("");
        String teacherID = teacherIdField.getText();
        String passCode = passCodeField.getText();

        if (teacherID.isEmpty() || passCode.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter teacher ID and PassCode.");
            return;
        }

        try {
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            ServiceInfo serviceInfo = jmdns.getServiceInfo(SERVICE_TYPE, SERVICE_NAME);
            if (serviceInfo == null) {
                JOptionPane.showMessageDialog(this, "Podium service not found.");
                return;
            }

            String host = serviceInfo.getHostAddresses()[0];
            int port = serviceInfo.getPort();
            ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
                    .usePlaintext()
                    .build();

            PodiumControlGrpc.PodiumControlStub asyncStub = PodiumControlGrpc.newStub(channel);

            LoginRequest request = LoginRequest.newBuilder()
                    .setTeacherID(teacherID)
                    .setPassCode(passCode)
                    .build();

            asyncStub.podiumLogin(request, new StreamObserver<LoginResponse>() {
                @Override
                public void onNext(LoginResponse response) {
                    loginResponseArea.setText(response.toString());
                }

                @Override
                public void onError(Throwable t) {
                    t.printStackTrace();
                }

                @Override
                public void onCompleted() {
                }
            });

        } catch (IOException ex) {
            ex.printStackTrace();
            loginResponseArea.setText("Error connecting to the Podium service.");
        }
    }

    public void projectorAccess() {

        projectorResponseArea.setText("");
        String projectorID = projectorId.getText();
        String projectorCode = projectorPin.getText();

        if (projectorID.isEmpty() || projectorCode.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter projector ID and projector access code.");
            return;
        }
        try {
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            ServiceInfo serviceInfo = jmdns.getServiceInfo(SERVICE_TYPE, SERVICE_NAME);
            if (serviceInfo == null) {
                JOptionPane.showMessageDialog(this, "Podium service not found.");
                return;
            }

            String host = serviceInfo.getHostAddresses()[0];
            int port = serviceInfo.getPort();
            ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
                    .usePlaintext()
                    .build();

            PodiumControlGrpc.PodiumControlStub asyncStub = PodiumControlGrpc.newStub(channel);

            ProjectorRequest request = ProjectorRequest.newBuilder()
                    .setProjectorId(projectorID)
                    .setAccessPin(projectorCode)
                    .build();

            asyncStub.projectorIntegration(request, new StreamObserver<ProjectorResponse>() {
                @Override
                public void onNext(ProjectorResponse response) {
                    projectorResponseArea.setText(response.toString());
                }

                @Override
                public void onError(Throwable t) {
                    t.printStackTrace();
                }

                @Override
                public void onCompleted() {
                }
            });

        } catch (IOException ex) {
            ex.printStackTrace();
            projectorResponseArea.setText("Error connecting to the Attendance service.");
        }
    }


    public void podiumControl() {
        String deviceName = deviceNameField.getText();

        if (deviceName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Device name.");
            return;
        }

        try {
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            ServiceInfo serviceInfo = jmdns.getServiceInfo(SERVICE_TYPE, SERVICE_NAME);
            if (serviceInfo == null) {
                JOptionPane.showMessageDialog(this, "Podium service not found.");
                return;
            }

            String host = serviceInfo.getHostAddresses()[0];
            int port = serviceInfo.getPort();
            ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
                    .usePlaintext()
                    .build();

            PodiumControlGrpc.PodiumControlStub asyncStub = PodiumControlGrpc.newStub(channel);


            StreamObserver<IODeviceRequest> requestObserver = asyncStub.iOInterface(new StreamObserver<IODeviceResponse>() {
                @Override
                public void onNext(IODeviceResponse response) {
                    ioResponseArea.append(response.getDeviceStatus() + "\n");
                }

                @Override
                public void onError(Throwable t) {
                    ioResponseArea.append("Error: " + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    ioResponseArea.append("Completed.\n");
                }
            });

            requestObserver.onNext(IODeviceRequest.newBuilder().setDeviceName(deviceName).build());

        } catch (IOException ex) {
            ex.printStackTrace();
            ioResponseArea.setText("Error connecting to the Podium service.");
        }
    }

}
