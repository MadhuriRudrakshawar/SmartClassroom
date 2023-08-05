import com.smartclassrooms.services.AttendanceServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.IOException;
import java.net.InetAddress;

public class GRPCServer {

    public static void main(String[] args) throws IOException, InterruptedException {

        Server server = ServerBuilder.forPort(9090)
                .addService(new AttendanceServiceImpl())
                .build();

        server.start();

        System.out.println("Server started at " + server.getPort());

        registerService();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down the server");
            server.shutdown();
            System.out.println("Server shut down successfully");
        }));

        server.awaitTermination();
    }

    private static void registerService() {
        try {
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            ServiceInfo serviceInfo = ServiceInfo.create("_grpc._tcp.local.", "Attendance", 9090,
                    "Attendance Service for handling attendance records.");
            jmdns.registerService(serviceInfo);

            System.out.println("Service registered with jmDNS. Discover using service name 'Attendance'.");

        } catch (IOException e) {
            System.err.println("Error occurred while registering the service with jmDNS: " + e.getMessage());
        }
    }
}