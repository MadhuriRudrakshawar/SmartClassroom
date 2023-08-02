package user;


import com.yrrDemo.grpc.User.APIResponse;
import com.yrrDemo.grpc.User.Empty;
import com.yrrDemo.grpc.User.LoginRequest;
import com.yrrDemo.grpc.userGrpc.userImplBase;

import io.grpc.stub.StreamObserver;

public class UserService extends userImplBase{
	
	

	@Override
	public void login(LoginRequest request, StreamObserver<APIResponse> responseObserver) {
		System.out.println("Inside Login ");
		
		String username = request.getUsername();
		String password = request.getPassword();
		
		APIResponse.Builder responce = APIResponse.newBuilder();
		if(username.equals(password)) {
			
			//return success message
			responce.setResponseCode(0).setResponseMessage("SUCCESS");
			} else {
			responce.setResponseCode(100).setResponseMessage("Invalid Password");

			}
		
		responseObserver.onNext(responce.build());
		responseObserver.onCompleted();
	}
	
	@Override
	public void logout(Empty request, StreamObserver<APIResponse> responseObserver) {
		
	}
		
	
	
	
}