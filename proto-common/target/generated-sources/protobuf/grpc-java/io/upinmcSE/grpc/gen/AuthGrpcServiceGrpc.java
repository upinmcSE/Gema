package io.upinmcSE.grpc.gen;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class AuthGrpcServiceGrpc {

  private AuthGrpcServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "AuthGrpcService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<io.upinmcSE.grpc.gen.CreateAccountRequest,
      io.upinmcSE.grpc.gen.CreateAccountResponse> getCreateAccountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAccount",
      requestType = io.upinmcSE.grpc.gen.CreateAccountRequest.class,
      responseType = io.upinmcSE.grpc.gen.CreateAccountResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.upinmcSE.grpc.gen.CreateAccountRequest,
      io.upinmcSE.grpc.gen.CreateAccountResponse> getCreateAccountMethod() {
    io.grpc.MethodDescriptor<io.upinmcSE.grpc.gen.CreateAccountRequest, io.upinmcSE.grpc.gen.CreateAccountResponse> getCreateAccountMethod;
    if ((getCreateAccountMethod = AuthGrpcServiceGrpc.getCreateAccountMethod) == null) {
      synchronized (AuthGrpcServiceGrpc.class) {
        if ((getCreateAccountMethod = AuthGrpcServiceGrpc.getCreateAccountMethod) == null) {
          AuthGrpcServiceGrpc.getCreateAccountMethod = getCreateAccountMethod =
              io.grpc.MethodDescriptor.<io.upinmcSE.grpc.gen.CreateAccountRequest, io.upinmcSE.grpc.gen.CreateAccountResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAccount"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.upinmcSE.grpc.gen.CreateAccountRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.upinmcSE.grpc.gen.CreateAccountResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AuthGrpcServiceMethodDescriptorSupplier("CreateAccount"))
              .build();
        }
      }
    }
    return getCreateAccountMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.upinmcSE.grpc.gen.CreateSessionRequest,
      io.upinmcSE.grpc.gen.CreateSessionResponse> getCreateSessionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSession",
      requestType = io.upinmcSE.grpc.gen.CreateSessionRequest.class,
      responseType = io.upinmcSE.grpc.gen.CreateSessionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.upinmcSE.grpc.gen.CreateSessionRequest,
      io.upinmcSE.grpc.gen.CreateSessionResponse> getCreateSessionMethod() {
    io.grpc.MethodDescriptor<io.upinmcSE.grpc.gen.CreateSessionRequest, io.upinmcSE.grpc.gen.CreateSessionResponse> getCreateSessionMethod;
    if ((getCreateSessionMethod = AuthGrpcServiceGrpc.getCreateSessionMethod) == null) {
      synchronized (AuthGrpcServiceGrpc.class) {
        if ((getCreateSessionMethod = AuthGrpcServiceGrpc.getCreateSessionMethod) == null) {
          AuthGrpcServiceGrpc.getCreateSessionMethod = getCreateSessionMethod =
              io.grpc.MethodDescriptor.<io.upinmcSE.grpc.gen.CreateSessionRequest, io.upinmcSE.grpc.gen.CreateSessionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateSession"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.upinmcSE.grpc.gen.CreateSessionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.upinmcSE.grpc.gen.CreateSessionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AuthGrpcServiceMethodDescriptorSupplier("CreateSession"))
              .build();
        }
      }
    }
    return getCreateSessionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.upinmcSE.grpc.gen.VerifySessionRequest,
      io.upinmcSE.grpc.gen.VerifySessionResponse> getVerifySessionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "VerifySession",
      requestType = io.upinmcSE.grpc.gen.VerifySessionRequest.class,
      responseType = io.upinmcSE.grpc.gen.VerifySessionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.upinmcSE.grpc.gen.VerifySessionRequest,
      io.upinmcSE.grpc.gen.VerifySessionResponse> getVerifySessionMethod() {
    io.grpc.MethodDescriptor<io.upinmcSE.grpc.gen.VerifySessionRequest, io.upinmcSE.grpc.gen.VerifySessionResponse> getVerifySessionMethod;
    if ((getVerifySessionMethod = AuthGrpcServiceGrpc.getVerifySessionMethod) == null) {
      synchronized (AuthGrpcServiceGrpc.class) {
        if ((getVerifySessionMethod = AuthGrpcServiceGrpc.getVerifySessionMethod) == null) {
          AuthGrpcServiceGrpc.getVerifySessionMethod = getVerifySessionMethod =
              io.grpc.MethodDescriptor.<io.upinmcSE.grpc.gen.VerifySessionRequest, io.upinmcSE.grpc.gen.VerifySessionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "VerifySession"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.upinmcSE.grpc.gen.VerifySessionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.upinmcSE.grpc.gen.VerifySessionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AuthGrpcServiceMethodDescriptorSupplier("VerifySession"))
              .build();
        }
      }
    }
    return getVerifySessionMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AuthGrpcServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuthGrpcServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AuthGrpcServiceStub>() {
        @java.lang.Override
        public AuthGrpcServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AuthGrpcServiceStub(channel, callOptions);
        }
      };
    return AuthGrpcServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static AuthGrpcServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuthGrpcServiceBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AuthGrpcServiceBlockingV2Stub>() {
        @java.lang.Override
        public AuthGrpcServiceBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AuthGrpcServiceBlockingV2Stub(channel, callOptions);
        }
      };
    return AuthGrpcServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AuthGrpcServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuthGrpcServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AuthGrpcServiceBlockingStub>() {
        @java.lang.Override
        public AuthGrpcServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AuthGrpcServiceBlockingStub(channel, callOptions);
        }
      };
    return AuthGrpcServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AuthGrpcServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuthGrpcServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AuthGrpcServiceFutureStub>() {
        @java.lang.Override
        public AuthGrpcServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AuthGrpcServiceFutureStub(channel, callOptions);
        }
      };
    return AuthGrpcServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void createAccount(io.upinmcSE.grpc.gen.CreateAccountRequest request,
        io.grpc.stub.StreamObserver<io.upinmcSE.grpc.gen.CreateAccountResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateAccountMethod(), responseObserver);
    }

    /**
     */
    default void createSession(io.upinmcSE.grpc.gen.CreateSessionRequest request,
        io.grpc.stub.StreamObserver<io.upinmcSE.grpc.gen.CreateSessionResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateSessionMethod(), responseObserver);
    }

    /**
     */
    default void verifySession(io.upinmcSE.grpc.gen.VerifySessionRequest request,
        io.grpc.stub.StreamObserver<io.upinmcSE.grpc.gen.VerifySessionResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getVerifySessionMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AuthGrpcService.
   */
  public static abstract class AuthGrpcServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return AuthGrpcServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AuthGrpcService.
   */
  public static final class AuthGrpcServiceStub
      extends io.grpc.stub.AbstractAsyncStub<AuthGrpcServiceStub> {
    private AuthGrpcServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthGrpcServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuthGrpcServiceStub(channel, callOptions);
    }

    /**
     */
    public void createAccount(io.upinmcSE.grpc.gen.CreateAccountRequest request,
        io.grpc.stub.StreamObserver<io.upinmcSE.grpc.gen.CreateAccountResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAccountMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createSession(io.upinmcSE.grpc.gen.CreateSessionRequest request,
        io.grpc.stub.StreamObserver<io.upinmcSE.grpc.gen.CreateSessionResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSessionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void verifySession(io.upinmcSE.grpc.gen.VerifySessionRequest request,
        io.grpc.stub.StreamObserver<io.upinmcSE.grpc.gen.VerifySessionResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getVerifySessionMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AuthGrpcService.
   */
  public static final class AuthGrpcServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<AuthGrpcServiceBlockingV2Stub> {
    private AuthGrpcServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthGrpcServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuthGrpcServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     */
    public io.upinmcSE.grpc.gen.CreateAccountResponse createAccount(io.upinmcSE.grpc.gen.CreateAccountRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateAccountMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.upinmcSE.grpc.gen.CreateSessionResponse createSession(io.upinmcSE.grpc.gen.CreateSessionRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateSessionMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.upinmcSE.grpc.gen.VerifySessionResponse verifySession(io.upinmcSE.grpc.gen.VerifySessionRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getVerifySessionMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service AuthGrpcService.
   */
  public static final class AuthGrpcServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AuthGrpcServiceBlockingStub> {
    private AuthGrpcServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthGrpcServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuthGrpcServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public io.upinmcSE.grpc.gen.CreateAccountResponse createAccount(io.upinmcSE.grpc.gen.CreateAccountRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAccountMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.upinmcSE.grpc.gen.CreateSessionResponse createSession(io.upinmcSE.grpc.gen.CreateSessionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSessionMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.upinmcSE.grpc.gen.VerifySessionResponse verifySession(io.upinmcSE.grpc.gen.VerifySessionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getVerifySessionMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AuthGrpcService.
   */
  public static final class AuthGrpcServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<AuthGrpcServiceFutureStub> {
    private AuthGrpcServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthGrpcServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuthGrpcServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.upinmcSE.grpc.gen.CreateAccountResponse> createAccount(
        io.upinmcSE.grpc.gen.CreateAccountRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAccountMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.upinmcSE.grpc.gen.CreateSessionResponse> createSession(
        io.upinmcSE.grpc.gen.CreateSessionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSessionMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.upinmcSE.grpc.gen.VerifySessionResponse> verifySession(
        io.upinmcSE.grpc.gen.VerifySessionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getVerifySessionMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_ACCOUNT = 0;
  private static final int METHODID_CREATE_SESSION = 1;
  private static final int METHODID_VERIFY_SESSION = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_ACCOUNT:
          serviceImpl.createAccount((io.upinmcSE.grpc.gen.CreateAccountRequest) request,
              (io.grpc.stub.StreamObserver<io.upinmcSE.grpc.gen.CreateAccountResponse>) responseObserver);
          break;
        case METHODID_CREATE_SESSION:
          serviceImpl.createSession((io.upinmcSE.grpc.gen.CreateSessionRequest) request,
              (io.grpc.stub.StreamObserver<io.upinmcSE.grpc.gen.CreateSessionResponse>) responseObserver);
          break;
        case METHODID_VERIFY_SESSION:
          serviceImpl.verifySession((io.upinmcSE.grpc.gen.VerifySessionRequest) request,
              (io.grpc.stub.StreamObserver<io.upinmcSE.grpc.gen.VerifySessionResponse>) responseObserver);
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getCreateAccountMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              io.upinmcSE.grpc.gen.CreateAccountRequest,
              io.upinmcSE.grpc.gen.CreateAccountResponse>(
                service, METHODID_CREATE_ACCOUNT)))
        .addMethod(
          getCreateSessionMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              io.upinmcSE.grpc.gen.CreateSessionRequest,
              io.upinmcSE.grpc.gen.CreateSessionResponse>(
                service, METHODID_CREATE_SESSION)))
        .addMethod(
          getVerifySessionMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              io.upinmcSE.grpc.gen.VerifySessionRequest,
              io.upinmcSE.grpc.gen.VerifySessionResponse>(
                service, METHODID_VERIFY_SESSION)))
        .build();
  }

  private static abstract class AuthGrpcServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AuthGrpcServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.upinmcSE.grpc.gen.AuthProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AuthGrpcService");
    }
  }

  private static final class AuthGrpcServiceFileDescriptorSupplier
      extends AuthGrpcServiceBaseDescriptorSupplier {
    AuthGrpcServiceFileDescriptorSupplier() {}
  }

  private static final class AuthGrpcServiceMethodDescriptorSupplier
      extends AuthGrpcServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AuthGrpcServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (AuthGrpcServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AuthGrpcServiceFileDescriptorSupplier())
              .addMethod(getCreateAccountMethod())
              .addMethod(getCreateSessionMethod())
              .addMethod(getVerifySessionMethod())
              .build();
        }
      }
    }
    return result;
  }
}
