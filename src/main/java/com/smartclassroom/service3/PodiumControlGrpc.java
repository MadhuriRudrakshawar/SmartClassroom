package com.smartclassroom.service3;

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
    comments = "Source: PodiumService.proto")
public final class PodiumControlGrpc {

  private PodiumControlGrpc() {}

  public static final String SERVICE_NAME = "PodiumControl";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.smartclassroom.service3.LoginRequest,
      com.smartclassroom.service3.LoginResponse> getPodiumLoginMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PodiumLogin",
      requestType = com.smartclassroom.service3.LoginRequest.class,
      responseType = com.smartclassroom.service3.LoginResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.smartclassroom.service3.LoginRequest,
      com.smartclassroom.service3.LoginResponse> getPodiumLoginMethod() {
    io.grpc.MethodDescriptor<com.smartclassroom.service3.LoginRequest, com.smartclassroom.service3.LoginResponse> getPodiumLoginMethod;
    if ((getPodiumLoginMethod = PodiumControlGrpc.getPodiumLoginMethod) == null) {
      synchronized (PodiumControlGrpc.class) {
        if ((getPodiumLoginMethod = PodiumControlGrpc.getPodiumLoginMethod) == null) {
          PodiumControlGrpc.getPodiumLoginMethod = getPodiumLoginMethod = 
              io.grpc.MethodDescriptor.<com.smartclassroom.service3.LoginRequest, com.smartclassroom.service3.LoginResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "PodiumControl", "PodiumLogin"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartclassroom.service3.LoginRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartclassroom.service3.LoginResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new PodiumControlMethodDescriptorSupplier("PodiumLogin"))
                  .build();
          }
        }
     }
     return getPodiumLoginMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.smartclassroom.service3.ProjectorRequest,
      com.smartclassroom.service3.ProjectorResponse> getProjectorIntegrationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ProjectorIntegration",
      requestType = com.smartclassroom.service3.ProjectorRequest.class,
      responseType = com.smartclassroom.service3.ProjectorResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.smartclassroom.service3.ProjectorRequest,
      com.smartclassroom.service3.ProjectorResponse> getProjectorIntegrationMethod() {
    io.grpc.MethodDescriptor<com.smartclassroom.service3.ProjectorRequest, com.smartclassroom.service3.ProjectorResponse> getProjectorIntegrationMethod;
    if ((getProjectorIntegrationMethod = PodiumControlGrpc.getProjectorIntegrationMethod) == null) {
      synchronized (PodiumControlGrpc.class) {
        if ((getProjectorIntegrationMethod = PodiumControlGrpc.getProjectorIntegrationMethod) == null) {
          PodiumControlGrpc.getProjectorIntegrationMethod = getProjectorIntegrationMethod = 
              io.grpc.MethodDescriptor.<com.smartclassroom.service3.ProjectorRequest, com.smartclassroom.service3.ProjectorResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "PodiumControl", "ProjectorIntegration"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartclassroom.service3.ProjectorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartclassroom.service3.ProjectorResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new PodiumControlMethodDescriptorSupplier("ProjectorIntegration"))
                  .build();
          }
        }
     }
     return getProjectorIntegrationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.smartclassroom.service3.IODeviceRequest,
      com.smartclassroom.service3.IODeviceResponse> getIOInterfaceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "IOInterface",
      requestType = com.smartclassroom.service3.IODeviceRequest.class,
      responseType = com.smartclassroom.service3.IODeviceResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.smartclassroom.service3.IODeviceRequest,
      com.smartclassroom.service3.IODeviceResponse> getIOInterfaceMethod() {
    io.grpc.MethodDescriptor<com.smartclassroom.service3.IODeviceRequest, com.smartclassroom.service3.IODeviceResponse> getIOInterfaceMethod;
    if ((getIOInterfaceMethod = PodiumControlGrpc.getIOInterfaceMethod) == null) {
      synchronized (PodiumControlGrpc.class) {
        if ((getIOInterfaceMethod = PodiumControlGrpc.getIOInterfaceMethod) == null) {
          PodiumControlGrpc.getIOInterfaceMethod = getIOInterfaceMethod = 
              io.grpc.MethodDescriptor.<com.smartclassroom.service3.IODeviceRequest, com.smartclassroom.service3.IODeviceResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "PodiumControl", "IOInterface"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartclassroom.service3.IODeviceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartclassroom.service3.IODeviceResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new PodiumControlMethodDescriptorSupplier("IOInterface"))
                  .build();
          }
        }
     }
     return getIOInterfaceMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PodiumControlStub newStub(io.grpc.Channel channel) {
    return new PodiumControlStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PodiumControlBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PodiumControlBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PodiumControlFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PodiumControlFutureStub(channel);
  }

  /**
   */
  public static abstract class PodiumControlImplBase implements io.grpc.BindableService {

    /**
     */
    public void podiumLogin(com.smartclassroom.service3.LoginRequest request,
        io.grpc.stub.StreamObserver<com.smartclassroom.service3.LoginResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getPodiumLoginMethod(), responseObserver);
    }

    /**
     */
    public void projectorIntegration(com.smartclassroom.service3.ProjectorRequest request,
        io.grpc.stub.StreamObserver<com.smartclassroom.service3.ProjectorResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getProjectorIntegrationMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.smartclassroom.service3.IODeviceRequest> iOInterface(
        io.grpc.stub.StreamObserver<com.smartclassroom.service3.IODeviceResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getIOInterfaceMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getPodiumLoginMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.smartclassroom.service3.LoginRequest,
                com.smartclassroom.service3.LoginResponse>(
                  this, METHODID_PODIUM_LOGIN)))
          .addMethod(
            getProjectorIntegrationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.smartclassroom.service3.ProjectorRequest,
                com.smartclassroom.service3.ProjectorResponse>(
                  this, METHODID_PROJECTOR_INTEGRATION)))
          .addMethod(
            getIOInterfaceMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.smartclassroom.service3.IODeviceRequest,
                com.smartclassroom.service3.IODeviceResponse>(
                  this, METHODID_IOINTERFACE)))
          .build();
    }
  }

  /**
   */
  public static final class PodiumControlStub extends io.grpc.stub.AbstractStub<PodiumControlStub> {
    private PodiumControlStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PodiumControlStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PodiumControlStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PodiumControlStub(channel, callOptions);
    }

    /**
     */
    public void podiumLogin(com.smartclassroom.service3.LoginRequest request,
        io.grpc.stub.StreamObserver<com.smartclassroom.service3.LoginResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPodiumLoginMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void projectorIntegration(com.smartclassroom.service3.ProjectorRequest request,
        io.grpc.stub.StreamObserver<com.smartclassroom.service3.ProjectorResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getProjectorIntegrationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.smartclassroom.service3.IODeviceRequest> iOInterface(
        io.grpc.stub.StreamObserver<com.smartclassroom.service3.IODeviceResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getIOInterfaceMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class PodiumControlBlockingStub extends io.grpc.stub.AbstractStub<PodiumControlBlockingStub> {
    private PodiumControlBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PodiumControlBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PodiumControlBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PodiumControlBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.smartclassroom.service3.LoginResponse podiumLogin(com.smartclassroom.service3.LoginRequest request) {
      return blockingUnaryCall(
          getChannel(), getPodiumLoginMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.smartclassroom.service3.ProjectorResponse projectorIntegration(com.smartclassroom.service3.ProjectorRequest request) {
      return blockingUnaryCall(
          getChannel(), getProjectorIntegrationMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class PodiumControlFutureStub extends io.grpc.stub.AbstractStub<PodiumControlFutureStub> {
    private PodiumControlFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PodiumControlFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PodiumControlFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PodiumControlFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.smartclassroom.service3.LoginResponse> podiumLogin(
        com.smartclassroom.service3.LoginRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getPodiumLoginMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.smartclassroom.service3.ProjectorResponse> projectorIntegration(
        com.smartclassroom.service3.ProjectorRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getProjectorIntegrationMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PODIUM_LOGIN = 0;
  private static final int METHODID_PROJECTOR_INTEGRATION = 1;
  private static final int METHODID_IOINTERFACE = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PodiumControlImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PodiumControlImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PODIUM_LOGIN:
          serviceImpl.podiumLogin((com.smartclassroom.service3.LoginRequest) request,
              (io.grpc.stub.StreamObserver<com.smartclassroom.service3.LoginResponse>) responseObserver);
          break;
        case METHODID_PROJECTOR_INTEGRATION:
          serviceImpl.projectorIntegration((com.smartclassroom.service3.ProjectorRequest) request,
              (io.grpc.stub.StreamObserver<com.smartclassroom.service3.ProjectorResponse>) responseObserver);
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
        case METHODID_IOINTERFACE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.iOInterface(
              (io.grpc.stub.StreamObserver<com.smartclassroom.service3.IODeviceResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class PodiumControlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PodiumControlBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.smartclassroom.service3.PodiumService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PodiumControl");
    }
  }

  private static final class PodiumControlFileDescriptorSupplier
      extends PodiumControlBaseDescriptorSupplier {
    PodiumControlFileDescriptorSupplier() {}
  }

  private static final class PodiumControlMethodDescriptorSupplier
      extends PodiumControlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PodiumControlMethodDescriptorSupplier(String methodName) {
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
      synchronized (PodiumControlGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PodiumControlFileDescriptorSupplier())
              .addMethod(getPodiumLoginMethod())
              .addMethod(getProjectorIntegrationMethod())
              .addMethod(getIOInterfaceMethod())
              .build();
        }
      }
    }
    return result;
  }
}
