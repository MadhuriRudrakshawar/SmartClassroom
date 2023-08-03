import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import services.SCService1;;

public class GRPCServer{
	
	public static void main(String[] args) throws IOException, InterruptedException {
	
		
		Server server = ServerBuilder.forPort(9090).addService
				(new SCService1()).build();
		
		server.start();
		
		System.out.println("Server started at " + server.getPort());
		
		server.awaitTermination();
	
		
		
		
		
		
	}	
}