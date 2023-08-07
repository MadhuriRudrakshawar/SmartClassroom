package com.smartclassroom.service2;

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
 * <pre>
 * Service 2: Assignment Submission
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: AssignmentService.proto")
public final class AssignmentSubmissionGrpc {

  private AssignmentSubmissionGrpc() {}

  public static final String SERVICE_NAME = "AssignmentSubmission";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.smartclassroom.service2.DetailRequest,
      com.smartclassroom.service2.DetailResponse> getAssignmentDetailMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AssignmentDetail",
      requestType = com.smartclassroom.service2.DetailRequest.class,
      responseType = com.smartclassroom.service2.DetailResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.smartclassroom.service2.DetailRequest,
      com.smartclassroom.service2.DetailResponse> getAssignmentDetailMethod() {
    io.grpc.MethodDescriptor<com.smartclassroom.service2.DetailRequest, com.smartclassroom.service2.DetailResponse> getAssignmentDetailMethod;
    if ((getAssignmentDetailMethod = AssignmentSubmissionGrpc.getAssignmentDetailMethod) == null) {
      synchronized (AssignmentSubmissionGrpc.class) {
        if ((getAssignmentDetailMethod = AssignmentSubmissionGrpc.getAssignmentDetailMethod) == null) {
          AssignmentSubmissionGrpc.getAssignmentDetailMethod = getAssignmentDetailMethod = 
              io.grpc.MethodDescriptor.<com.smartclassroom.service2.DetailRequest, com.smartclassroom.service2.DetailResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "AssignmentSubmission", "AssignmentDetail"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartclassroom.service2.DetailRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartclassroom.service2.DetailResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new AssignmentSubmissionMethodDescriptorSupplier("AssignmentDetail"))
                  .build();
          }
        }
     }
     return getAssignmentDetailMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.smartclassroom.service2.SubmitRequest,
      com.smartclassroom.service2.SubmitResponse> getAssignmentSubmissionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AssignmentSubmission",
      requestType = com.smartclassroom.service2.SubmitRequest.class,
      responseType = com.smartclassroom.service2.SubmitResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.smartclassroom.service2.SubmitRequest,
      com.smartclassroom.service2.SubmitResponse> getAssignmentSubmissionMethod() {
    io.grpc.MethodDescriptor<com.smartclassroom.service2.SubmitRequest, com.smartclassroom.service2.SubmitResponse> getAssignmentSubmissionMethod;
    if ((getAssignmentSubmissionMethod = AssignmentSubmissionGrpc.getAssignmentSubmissionMethod) == null) {
      synchronized (AssignmentSubmissionGrpc.class) {
        if ((getAssignmentSubmissionMethod = AssignmentSubmissionGrpc.getAssignmentSubmissionMethod) == null) {
          AssignmentSubmissionGrpc.getAssignmentSubmissionMethod = getAssignmentSubmissionMethod = 
              io.grpc.MethodDescriptor.<com.smartclassroom.service2.SubmitRequest, com.smartclassroom.service2.SubmitResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "AssignmentSubmission", "AssignmentSubmission"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartclassroom.service2.SubmitRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartclassroom.service2.SubmitResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new AssignmentSubmissionMethodDescriptorSupplier("AssignmentSubmission"))
                  .build();
          }
        }
     }
     return getAssignmentSubmissionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.smartclassroom.service2.ReminderRequest,
      com.smartclassroom.service2.ReminderResponse> getAssignmentReminderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AssignmentReminder",
      requestType = com.smartclassroom.service2.ReminderRequest.class,
      responseType = com.smartclassroom.service2.ReminderResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.smartclassroom.service2.ReminderRequest,
      com.smartclassroom.service2.ReminderResponse> getAssignmentReminderMethod() {
    io.grpc.MethodDescriptor<com.smartclassroom.service2.ReminderRequest, com.smartclassroom.service2.ReminderResponse> getAssignmentReminderMethod;
    if ((getAssignmentReminderMethod = AssignmentSubmissionGrpc.getAssignmentReminderMethod) == null) {
      synchronized (AssignmentSubmissionGrpc.class) {
        if ((getAssignmentReminderMethod = AssignmentSubmissionGrpc.getAssignmentReminderMethod) == null) {
          AssignmentSubmissionGrpc.getAssignmentReminderMethod = getAssignmentReminderMethod = 
              io.grpc.MethodDescriptor.<com.smartclassroom.service2.ReminderRequest, com.smartclassroom.service2.ReminderResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "AssignmentSubmission", "AssignmentReminder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartclassroom.service2.ReminderRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartclassroom.service2.ReminderResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new AssignmentSubmissionMethodDescriptorSupplier("AssignmentReminder"))
                  .build();
          }
        }
     }
     return getAssignmentReminderMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AssignmentSubmissionStub newStub(io.grpc.Channel channel) {
    return new AssignmentSubmissionStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AssignmentSubmissionBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AssignmentSubmissionBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AssignmentSubmissionFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AssignmentSubmissionFutureStub(channel);
  }

  /**
   * <pre>
   * Service 2: Assignment Submission
   * </pre>
   */
  public static abstract class AssignmentSubmissionImplBase implements io.grpc.BindableService {

    /**
     */
    public void assignmentDetail(com.smartclassroom.service2.DetailRequest request,
        io.grpc.stub.StreamObserver<com.smartclassroom.service2.DetailResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAssignmentDetailMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.smartclassroom.service2.SubmitRequest> assignmentSubmission(
        io.grpc.stub.StreamObserver<com.smartclassroom.service2.SubmitResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getAssignmentSubmissionMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.smartclassroom.service2.ReminderRequest> assignmentReminder(
        io.grpc.stub.StreamObserver<com.smartclassroom.service2.ReminderResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getAssignmentReminderMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAssignmentDetailMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.smartclassroom.service2.DetailRequest,
                com.smartclassroom.service2.DetailResponse>(
                  this, METHODID_ASSIGNMENT_DETAIL)))
          .addMethod(
            getAssignmentSubmissionMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                com.smartclassroom.service2.SubmitRequest,
                com.smartclassroom.service2.SubmitResponse>(
                  this, METHODID_ASSIGNMENT_SUBMISSION)))
          .addMethod(
            getAssignmentReminderMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.smartclassroom.service2.ReminderRequest,
                com.smartclassroom.service2.ReminderResponse>(
                  this, METHODID_ASSIGNMENT_REMINDER)))
          .build();
    }
  }

  /**
   * <pre>
   * Service 2: Assignment Submission
   * </pre>
   */
  public static final class AssignmentSubmissionStub extends io.grpc.stub.AbstractStub<AssignmentSubmissionStub> {
    private AssignmentSubmissionStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AssignmentSubmissionStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AssignmentSubmissionStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AssignmentSubmissionStub(channel, callOptions);
    }

    /**
     */
    public void assignmentDetail(com.smartclassroom.service2.DetailRequest request,
        io.grpc.stub.StreamObserver<com.smartclassroom.service2.DetailResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAssignmentDetailMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.smartclassroom.service2.SubmitRequest> assignmentSubmission(
        io.grpc.stub.StreamObserver<com.smartclassroom.service2.SubmitResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getAssignmentSubmissionMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.smartclassroom.service2.ReminderRequest> assignmentReminder(
        io.grpc.stub.StreamObserver<com.smartclassroom.service2.ReminderResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getAssignmentReminderMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * Service 2: Assignment Submission
   * </pre>
   */
  public static final class AssignmentSubmissionBlockingStub extends io.grpc.stub.AbstractStub<AssignmentSubmissionBlockingStub> {
    private AssignmentSubmissionBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AssignmentSubmissionBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AssignmentSubmissionBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AssignmentSubmissionBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.smartclassroom.service2.DetailResponse assignmentDetail(com.smartclassroom.service2.DetailRequest request) {
      return blockingUnaryCall(
          getChannel(), getAssignmentDetailMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Service 2: Assignment Submission
   * </pre>
   */
  public static final class AssignmentSubmissionFutureStub extends io.grpc.stub.AbstractStub<AssignmentSubmissionFutureStub> {
    private AssignmentSubmissionFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AssignmentSubmissionFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AssignmentSubmissionFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AssignmentSubmissionFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.smartclassroom.service2.DetailResponse> assignmentDetail(
        com.smartclassroom.service2.DetailRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAssignmentDetailMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ASSIGNMENT_DETAIL = 0;
  private static final int METHODID_ASSIGNMENT_SUBMISSION = 1;
  private static final int METHODID_ASSIGNMENT_REMINDER = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AssignmentSubmissionImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AssignmentSubmissionImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ASSIGNMENT_DETAIL:
          serviceImpl.assignmentDetail((com.smartclassroom.service2.DetailRequest) request,
              (io.grpc.stub.StreamObserver<com.smartclassroom.service2.DetailResponse>) responseObserver);
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
        case METHODID_ASSIGNMENT_SUBMISSION:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.assignmentSubmission(
              (io.grpc.stub.StreamObserver<com.smartclassroom.service2.SubmitResponse>) responseObserver);
        case METHODID_ASSIGNMENT_REMINDER:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.assignmentReminder(
              (io.grpc.stub.StreamObserver<com.smartclassroom.service2.ReminderResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class AssignmentSubmissionBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AssignmentSubmissionBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.smartclassroom.service2.AssignmentService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AssignmentSubmission");
    }
  }

  private static final class AssignmentSubmissionFileDescriptorSupplier
      extends AssignmentSubmissionBaseDescriptorSupplier {
    AssignmentSubmissionFileDescriptorSupplier() {}
  }

  private static final class AssignmentSubmissionMethodDescriptorSupplier
      extends AssignmentSubmissionBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AssignmentSubmissionMethodDescriptorSupplier(String methodName) {
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
      synchronized (AssignmentSubmissionGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AssignmentSubmissionFileDescriptorSupplier())
              .addMethod(getAssignmentDetailMethod())
              .addMethod(getAssignmentSubmissionMethod())
              .addMethod(getAssignmentReminderMethod())
              .build();
        }
      }
    }
    return result;
  }
}
