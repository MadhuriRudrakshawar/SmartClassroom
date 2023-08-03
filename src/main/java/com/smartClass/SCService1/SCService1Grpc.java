package com.smartClass.SCService1;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: SCService1.proto")
public final class SCService1Grpc {

  private SCService1Grpc() {}

  public static final String SERVICE_NAME = "SCService1";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.smartClass.SCService1.setStudentAttendanceRequest,
      com.smartClass.SCService1.setStudentAttendanceResponse> getSetStudentAttendanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "setStudentAttendance",
      requestType = com.smartClass.SCService1.setStudentAttendanceRequest.class,
      responseType = com.smartClass.SCService1.setStudentAttendanceResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.smartClass.SCService1.setStudentAttendanceRequest,
      com.smartClass.SCService1.setStudentAttendanceResponse> getSetStudentAttendanceMethod() {
    io.grpc.MethodDescriptor<com.smartClass.SCService1.setStudentAttendanceRequest, com.smartClass.SCService1.setStudentAttendanceResponse> getSetStudentAttendanceMethod;
    if ((getSetStudentAttendanceMethod = SCService1Grpc.getSetStudentAttendanceMethod) == null) {
      synchronized (SCService1Grpc.class) {
        if ((getSetStudentAttendanceMethod = SCService1Grpc.getSetStudentAttendanceMethod) == null) {
          SCService1Grpc.getSetStudentAttendanceMethod = getSetStudentAttendanceMethod = 
              io.grpc.MethodDescriptor.<com.smartClass.SCService1.setStudentAttendanceRequest, com.smartClass.SCService1.setStudentAttendanceResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "SCService1", "setStudentAttendance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartClass.SCService1.setStudentAttendanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartClass.SCService1.setStudentAttendanceResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SCService1MethodDescriptorSupplier("setStudentAttendance"))
                  .build();
          }
        }
     }
     return getSetStudentAttendanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.smartClass.SCService1.getStudentAttendanceRequest,
      com.smartClass.SCService1.getStudentAttendanceResponse> getGetStudentAttendanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getStudentAttendance",
      requestType = com.smartClass.SCService1.getStudentAttendanceRequest.class,
      responseType = com.smartClass.SCService1.getStudentAttendanceResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.smartClass.SCService1.getStudentAttendanceRequest,
      com.smartClass.SCService1.getStudentAttendanceResponse> getGetStudentAttendanceMethod() {
    io.grpc.MethodDescriptor<com.smartClass.SCService1.getStudentAttendanceRequest, com.smartClass.SCService1.getStudentAttendanceResponse> getGetStudentAttendanceMethod;
    if ((getGetStudentAttendanceMethod = SCService1Grpc.getGetStudentAttendanceMethod) == null) {
      synchronized (SCService1Grpc.class) {
        if ((getGetStudentAttendanceMethod = SCService1Grpc.getGetStudentAttendanceMethod) == null) {
          SCService1Grpc.getGetStudentAttendanceMethod = getGetStudentAttendanceMethod = 
              io.grpc.MethodDescriptor.<com.smartClass.SCService1.getStudentAttendanceRequest, com.smartClass.SCService1.getStudentAttendanceResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "SCService1", "getStudentAttendance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartClass.SCService1.getStudentAttendanceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartClass.SCService1.getStudentAttendanceResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SCService1MethodDescriptorSupplier("getStudentAttendance"))
                  .build();
          }
        }
     }
     return getGetStudentAttendanceMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SCService1Stub newStub(io.grpc.Channel channel) {
    return new SCService1Stub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SCService1BlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SCService1BlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SCService1FutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SCService1FutureStub(channel);
  }

  /**
   */
  public static abstract class SCService1ImplBase implements io.grpc.BindableService {

    /**
     */
    public void setStudentAttendance(com.smartClass.SCService1.setStudentAttendanceRequest request,
        io.grpc.stub.StreamObserver<com.smartClass.SCService1.setStudentAttendanceResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSetStudentAttendanceMethod(), responseObserver);
    }

    /**
     * <pre>
     * Retrieves a user's profile.
     * </pre>
     */
    public void getStudentAttendance(com.smartClass.SCService1.getStudentAttendanceRequest request,
        io.grpc.stub.StreamObserver<com.smartClass.SCService1.getStudentAttendanceResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetStudentAttendanceMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSetStudentAttendanceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.smartClass.SCService1.setStudentAttendanceRequest,
                com.smartClass.SCService1.setStudentAttendanceResponse>(
                  this, METHODID_SET_STUDENT_ATTENDANCE)))
          .addMethod(
            getGetStudentAttendanceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.smartClass.SCService1.getStudentAttendanceRequest,
                com.smartClass.SCService1.getStudentAttendanceResponse>(
                  this, METHODID_GET_STUDENT_ATTENDANCE)))
          .build();
    }
  }

  /**
   */
  public static final class SCService1Stub extends io.grpc.stub.AbstractStub<SCService1Stub> {
    private SCService1Stub(io.grpc.Channel channel) {
      super(channel);
    }

    private SCService1Stub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SCService1Stub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SCService1Stub(channel, callOptions);
    }

    /**
     */
    public void setStudentAttendance(com.smartClass.SCService1.setStudentAttendanceRequest request,
        io.grpc.stub.StreamObserver<com.smartClass.SCService1.setStudentAttendanceResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetStudentAttendanceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Retrieves a user's profile.
     * </pre>
     */
    public void getStudentAttendance(com.smartClass.SCService1.getStudentAttendanceRequest request,
        io.grpc.stub.StreamObserver<com.smartClass.SCService1.getStudentAttendanceResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetStudentAttendanceMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SCService1BlockingStub extends io.grpc.stub.AbstractStub<SCService1BlockingStub> {
    private SCService1BlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SCService1BlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SCService1BlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SCService1BlockingStub(channel, callOptions);
    }

    /**
     */
    public com.smartClass.SCService1.setStudentAttendanceResponse setStudentAttendance(com.smartClass.SCService1.setStudentAttendanceRequest request) {
      return blockingUnaryCall(
          getChannel(), getSetStudentAttendanceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Retrieves a user's profile.
     * </pre>
     */
    public com.smartClass.SCService1.getStudentAttendanceResponse getStudentAttendance(com.smartClass.SCService1.getStudentAttendanceRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetStudentAttendanceMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SCService1FutureStub extends io.grpc.stub.AbstractStub<SCService1FutureStub> {
    private SCService1FutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SCService1FutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SCService1FutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SCService1FutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.smartClass.SCService1.setStudentAttendanceResponse> setStudentAttendance(
        com.smartClass.SCService1.setStudentAttendanceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSetStudentAttendanceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Retrieves a user's profile.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.smartClass.SCService1.getStudentAttendanceResponse> getStudentAttendance(
        com.smartClass.SCService1.getStudentAttendanceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetStudentAttendanceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SET_STUDENT_ATTENDANCE = 0;
  private static final int METHODID_GET_STUDENT_ATTENDANCE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SCService1ImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SCService1ImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SET_STUDENT_ATTENDANCE:
          serviceImpl.setStudentAttendance((com.smartClass.SCService1.setStudentAttendanceRequest) request,
              (io.grpc.stub.StreamObserver<com.smartClass.SCService1.setStudentAttendanceResponse>) responseObserver);
          break;
        case METHODID_GET_STUDENT_ATTENDANCE:
          serviceImpl.getStudentAttendance((com.smartClass.SCService1.getStudentAttendanceRequest) request,
              (io.grpc.stub.StreamObserver<com.smartClass.SCService1.getStudentAttendanceResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class SCService1BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SCService1BaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.smartClass.SCService1.SCService1Impl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SCService1");
    }
  }

  private static final class SCService1FileDescriptorSupplier
      extends SCService1BaseDescriptorSupplier {
    SCService1FileDescriptorSupplier() {}
  }

  private static final class SCService1MethodDescriptorSupplier
      extends SCService1BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SCService1MethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (SCService1Grpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SCService1FileDescriptorSupplier())
              .addMethod(getSetStudentAttendanceMethod())
              .addMethod(getGetStudentAttendanceMethod())
              .build();
        }
      }
    }
    return result;
  }
}
