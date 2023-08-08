//Madhuri Rudrakshawar (22231579)

package allServices;

import com.smartclassroom.service3.*;
import com.smartclassroom.service3.PodiumControlGrpc.PodiumControlImplBase;
import io.grpc.stub.StreamObserver;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PodiumService extends PodiumControlImplBase {

    static Map<String, String> staffDetails = new HashMap<>();
    static Map<String, String> deviceDetails = new HashMap<>();
    static Map<String, String> projectorDetails = new HashMap<>();

    static {
        staffDetails.put("Joseph", "1234");
        staffDetails.put("Jenifer", "5555");
        staffDetails.put("Kathrine", "2323");
        staffDetails.put("Rohan", "2468");
    }

    static {
        deviceDetails.put("Keyboard", "Disconnected");
        deviceDetails.put("Mouse", "Disconnected");
        deviceDetails.put("USB", "Disconnected");
        deviceDetails.put("Speakers", "Disconnected");
    }

    static {
        projectorDetails.put("p1", "3214");
        projectorDetails.put("p2", "3412");
    }

    @Override
    public void podiumLogin(LoginRequest request, StreamObserver<LoginResponse> responseObserver) {

        String teacherId = request.getTeacherID();
        String passCode = request.getPassCode();

        LoginResponse.Builder loginResponseBuilder = LoginResponse.newBuilder();

        if (staffDetails.containsKey(teacherId)) {
            if (!passCode.isEmpty() && passCode.equals(staffDetails.get(teacherId))) {
                loginResponseBuilder.setMessage("Login Successful.");
            } else {
                loginResponseBuilder.setMessage("Invalid login details!");
            }

        } else {
            loginResponseBuilder.setMessage("Invalid teacher Id!");
        }
        responseObserver.onNext(loginResponseBuilder.build());

    }

    @Override
    public void projectorIntegration(ProjectorRequest request, StreamObserver<ProjectorResponse> responseObserver) {

        String deviceName = request.getProjectorId();
        String devicePin = request.getAccessPin();

        ProjectorResponse.Builder projectorResponseBuilder = ProjectorResponse.newBuilder();

        if (projectorDetails.containsKey(deviceName)) {
            if (!devicePin.isEmpty() && devicePin.equals(projectorDetails.get(deviceName))) {
                projectorResponseBuilder.setStatus("You may use projector " + deviceName);
            } else {
                projectorResponseBuilder.setStatus("Enter correct pin for projector " + deviceName);
            }

        } else {
            projectorResponseBuilder.setStatus("Invalid Projector Id!");
        }
        responseObserver.onNext(projectorResponseBuilder.build());

    }

    @Override
    public StreamObserver<IODeviceRequest> iOInterface(StreamObserver<IODeviceResponse> responseObserver) {

        return new StreamObserver<IODeviceRequest>() {
            @Override
            public void onNext(IODeviceRequest request) {
                String deviceName = request.getDeviceName();
                boolean requestConnect = deviceDetails.get(deviceName).equals("Disconnected");


                IODeviceResponse.Builder ioResponseBuilder = IODeviceResponse.newBuilder();

                Random rand = new Random();
                int randomValue = rand.nextInt(3);

                if (requestConnect) {
                    if (deviceDetails.containsKey(deviceName) && deviceDetails.get(deviceName).equals("Disconnected")) {
                        if (randomValue == 0) {
                            deviceDetails.put(deviceName, "Connected");
                            ioResponseBuilder.setDeviceStatus(deviceName + " - Device connected successfully.");
                        } else if (randomValue == 1) {
                            ioResponseBuilder.setDeviceStatus(deviceName + " - Device connection failed.");
                        } else {
                            ioResponseBuilder.setDeviceStatus(deviceName + " - Device connection timed out.");
                        }
                    }
                } else {
                    deviceDetails.put(deviceName, "Disconnected");
                    ioResponseBuilder.setDeviceStatus(deviceName + " - Device disconnected successfully.");
                }

                responseObserver.onNext(ioResponseBuilder.build());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("Server Error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }

}