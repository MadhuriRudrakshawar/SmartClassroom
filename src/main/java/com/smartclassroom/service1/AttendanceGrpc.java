package com.smartclassroom.service1;

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
 * Service 1: Attendance
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: AttendanceService.proto")
public final class AttendanceGrpc {

  private AttendanceGrpc() {}

  public static final String SERVICE_NAME = "Attendance";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.smartclassroom.service1.TrackRequest,
      com.smartclassroom.service1.TrackResponse> getAttendanceTrackingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AttendanceTracking",
      requestType = com.smartclassroom.service1.TrackRequest.class,
      responseType = com.smartclassroom.service1.TrackResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.smartclassroom.service1.TrackRequest,
      com.smartclassroom.service1.TrackResponse> getAttendanceTrackingMethod() {
    io.grpc.MethodDescriptor<com.smartclassroom.service1.TrackRequest, com.smartclassroom.service1.TrackResponse> getAttendanceTrackingMethod;
    if ((getAttendanceTrackingMethod = AttendanceGrpc.getAttendanceTrackingMethod) == null) {
      synchronized (AttendanceGrpc.class) {
        if ((getAttendanceTrackingMethod = AttendanceGrpc.getAttendanceTrackingMethod) == null) {
          AttendanceGrpc.getAttendanceTrackingMethod = getAttendanceTrackingMethod = 
              io.grpc.MethodDescriptor.<com.smartclassroom.service1.TrackRequest, com.smartclassroom.service1.TrackResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Attendance", "AttendanceTracking"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartclassroom.service1.TrackRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartclassroom.service1.TrackResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new AttendanceMethodDescriptorSupplier("AttendanceTracking"))
                  .build();
          }
        }
     }
     return getAttendanceTrackingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.smartclassroom.service1.ReportRequest,
      com.smartclassroom.service1.ReportResponse> getAttendanceReportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AttendanceReport",
      requestType = com.smartclassroom.service1.ReportRequest.class,
      responseType = com.smartclassroom.service1.ReportResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.smartclassroom.service1.ReportRequest,
      com.smartclassroom.service1.ReportResponse> getAttendanceReportMethod() {
    io.grpc.MethodDescriptor<com.smartclassroom.service1.ReportRequest, com.smartclassroom.service1.ReportResponse> getAttendanceReportMethod;
    if ((getAttendanceReportMethod = AttendanceGrpc.getAttendanceReportMethod) == null) {
      synchronized (AttendanceGrpc.class) {
        if ((getAttendanceReportMethod = AttendanceGrpc.getAttendanceReportMethod) == null) {
          AttendanceGrpc.getAttendanceReportMethod = getAttendanceReportMethod = 
              io.grpc.MethodDescriptor.<com.smartclassroom.service1.ReportRequest, com.smartclassroom.service1.ReportResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "Attendance", "AttendanceReport"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartclassroom.service1.ReportRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartclassroom.service1.ReportResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new AttendanceMethodDescriptorSupplier("AttendanceReport"))
                  .build();
          }
        }
     }
     return getAttendanceReportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.smartclassroom.service1.NotificationRequest,
      com.smartclassroom.service1.NotificationResponse> getAttendanceNotificationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AttendanceNotification",
      requestType = com.smartclassroom.service1.NotificationRequest.class,
      responseType = com.smartclassroom.service1.NotificationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.smartclassroom.service1.NotificationRequest,
      com.smartclassroom.service1.NotificationResponse> getAttendanceNotificationMethod() {
    io.grpc.MethodDescriptor<com.smartclassroom.service1.NotificationRequest, com.smartclassroom.service1.NotificationResponse> getAttendanceNotificationMethod;
    if ((getAttendanceNotificationMethod = AttendanceGrpc.getAttendanceNotificationMethod) == null) {
      synchronized (AttendanceGrpc.class) {
        if ((getAttendanceNotificationMethod = AttendanceGrpc.getAttendanceNotificationMethod) == null) {
          AttendanceGrpc.getAttendanceNotificationMethod = getAttendanceNotificationMethod = 
              io.grpc.MethodDescriptor.<com.smartclassroom.service1.NotificationRequest, com.smartclassroom.service1.NotificationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "Attendance", "AttendanceNotification"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartclassroom.service1.NotificationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.smartclassroom.service1.NotificationResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new AttendanceMethodDescriptorSupplier("AttendanceNotification"))
                  .build();
          }
        }
     }
     return getAttendanceNotificationMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AttendanceStub newStub(io.grpc.Channel channel) {
    return new AttendanceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AttendanceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AttendanceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AttendanceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AttendanceFutureStub(channel);
  }

  /**
   * <pre>
   * Service 1: Attendance
   * </pre>
   */
  public static abstract class AttendanceImplBase implements io.grpc.BindableService {

    /**
     */
    public void attendanceTracking(com.smartclassroom.service1.TrackRequest request,
        io.grpc.stub.StreamObserver<com.smartclassroom.service1.TrackResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAttendanceTrackingMethod(), responseObserver);
    }

    /**
     */
    public void attendanceReport(com.smartclassroom.service1.ReportRequest request,
        io.grpc.stub.StreamObserver<com.smartclassroom.service1.ReportResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAttendanceReportMethod(), responseObserver);
    }

    /**
     */
    public void attendanceNotification(com.smartclassroom.service1.NotificationRequest request,
        io.grpc.stub.StreamObserver<com.smartclassroom.service1.NotificationResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAttendanceNotificationMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAttendanceTrackingMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.smartclassroom.service1.TrackRequest,
                com.smartclassroom.service1.TrackResponse>(
                  this, METHODID_ATTENDANCE_TRACKING)))
          .addMethod(
            getAttendanceReportMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.smartclassroom.service1.ReportRequest,
                com.smartclassroom.service1.ReportResponse>(
                  this, METHODID_ATTENDANCE_REPORT)))
          .addMethod(
            getAttendanceNotificationMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.smartclassroom.service1.NotificationRequest,
                com.smartclassroom.service1.NotificationResponse>(
                  this, METHODID_ATTENDANCE_NOTIFICATION)))
          .build();
    }
  }

  /**
   * <pre>
   * Service 1: Attendance
   * </pre>
   */
  public static final class AttendanceStub extends io.grpc.stub.AbstractStub<AttendanceStub> {
    private AttendanceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AttendanceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AttendanceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AttendanceStub(channel, callOptions);
    }

    /**
     */
    public void attendanceTracking(com.smartclassroom.service1.TrackRequest request,
        io.grpc.stub.StreamObserver<com.smartclassroom.service1.TrackResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAttendanceTrackingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void attendanceReport(com.smartclassroom.service1.ReportRequest request,
        io.grpc.stub.StreamObserver<com.smartclassroom.service1.ReportResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getAttendanceReportMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void attendanceNotification(com.smartclassroom.service1.NotificationRequest request,
        io.grpc.stub.StreamObserver<com.smartclassroom.service1.NotificationResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getAttendanceNotificationMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Service 1: Attendance
   * </pre>
   */
  public static final class AttendanceBlockingStub extends io.grpc.stub.AbstractStub<AttendanceBlockingStub> {
    private AttendanceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AttendanceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AttendanceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AttendanceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.smartclassroom.service1.TrackResponse attendanceTracking(com.smartclassroom.service1.TrackRequest request) {
      return blockingUnaryCall(
          getChannel(), getAttendanceTrackingMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.smartclassroom.service1.ReportResponse> attendanceReport(
        com.smartclassroom.service1.ReportRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getAttendanceReportMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.smartclassroom.service1.NotificationResponse> attendanceNotification(
        com.smartclassroom.service1.NotificationRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getAttendanceNotificationMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Service 1: Attendance
   * </pre>
   */
  public static final class AttendanceFutureStub extends io.grpc.stub.AbstractStub<AttendanceFutureStub> {
    private AttendanceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AttendanceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AttendanceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AttendanceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.smartclassroom.service1.TrackResponse> attendanceTracking(
        com.smartclassroom.service1.TrackRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAttendanceTrackingMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ATTENDANCE_TRACKING = 0;
  private static final int METHODID_ATTENDANCE_REPORT = 1;
  private static final int METHODID_ATTENDANCE_NOTIFICATION = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AttendanceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AttendanceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ATTENDANCE_TRACKING:
          serviceImpl.attendanceTracking((com.smartclassroom.service1.TrackRequest) request,
              (io.grpc.stub.StreamObserver<com.smartclassroom.service1.TrackResponse>) responseObserver);
          break;
        case METHODID_ATTENDANCE_REPORT:
          serviceImpl.attendanceReport((com.smartclassroom.service1.ReportRequest) request,
              (io.grpc.stub.StreamObserver<com.smartclassroom.service1.ReportResponse>) responseObserver);
          break;
        case METHODID_ATTENDANCE_NOTIFICATION:
          serviceImpl.attendanceNotification((com.smartclassroom.service1.NotificationRequest) request,
              (io.grpc.stub.StreamObserver<com.smartclassroom.service1.NotificationResponse>) responseObserver);
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

  private static abstract class AttendanceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AttendanceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.smartclassroom.service1.AttendanceService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Attendance");
    }
  }

  private static final class AttendanceFileDescriptorSupplier
      extends AttendanceBaseDescriptorSupplier {
    AttendanceFileDescriptorSupplier() {}
  }

  private static final class AttendanceMethodDescriptorSupplier
      extends AttendanceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AttendanceMethodDescriptorSupplier(String methodName) {
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
      synchronized (AttendanceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AttendanceFileDescriptorSupplier())
              .addMethod(getAttendanceTrackingMethod())
              .addMethod(getAttendanceReportMethod())
              .addMethod(getAttendanceNotificationMethod())
              .build();
        }
      }
    }
    return result;
  }
}
