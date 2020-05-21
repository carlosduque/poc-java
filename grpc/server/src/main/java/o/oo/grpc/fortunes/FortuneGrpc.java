package o.oo.grpc.fortunes;

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
    value = "by gRPC proto compiler (version 1.29.0)",
    comments = "Source: fortunes.proto")
public final class FortuneGrpc {

  private FortuneGrpc() {}

  public static final String SERVICE_NAME = "o.oo.grpc.fortunes.Fortune";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<o.oo.grpc.fortunes.FortuneRequest,
      o.oo.grpc.fortunes.FortuneResponse> getRetrieveMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "retrieve",
      requestType = o.oo.grpc.fortunes.FortuneRequest.class,
      responseType = o.oo.grpc.fortunes.FortuneResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<o.oo.grpc.fortunes.FortuneRequest,
      o.oo.grpc.fortunes.FortuneResponse> getRetrieveMethod() {
    io.grpc.MethodDescriptor<o.oo.grpc.fortunes.FortuneRequest, o.oo.grpc.fortunes.FortuneResponse> getRetrieveMethod;
    if ((getRetrieveMethod = FortuneGrpc.getRetrieveMethod) == null) {
      synchronized (FortuneGrpc.class) {
        if ((getRetrieveMethod = FortuneGrpc.getRetrieveMethod) == null) {
          FortuneGrpc.getRetrieveMethod = getRetrieveMethod =
              io.grpc.MethodDescriptor.<o.oo.grpc.fortunes.FortuneRequest, o.oo.grpc.fortunes.FortuneResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "retrieve"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  o.oo.grpc.fortunes.FortuneRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  o.oo.grpc.fortunes.FortuneResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FortuneMethodDescriptorSupplier("retrieve"))
              .build();
        }
      }
    }
    return getRetrieveMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FortuneStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FortuneStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FortuneStub>() {
        @java.lang.Override
        public FortuneStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FortuneStub(channel, callOptions);
        }
      };
    return FortuneStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FortuneBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FortuneBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FortuneBlockingStub>() {
        @java.lang.Override
        public FortuneBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FortuneBlockingStub(channel, callOptions);
        }
      };
    return FortuneBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FortuneFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FortuneFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FortuneFutureStub>() {
        @java.lang.Override
        public FortuneFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FortuneFutureStub(channel, callOptions);
        }
      };
    return FortuneFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class FortuneImplBase implements io.grpc.BindableService {

    /**
     */
    public void retrieve(o.oo.grpc.fortunes.FortuneRequest request,
        io.grpc.stub.StreamObserver<o.oo.grpc.fortunes.FortuneResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRetrieveMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRetrieveMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                o.oo.grpc.fortunes.FortuneRequest,
                o.oo.grpc.fortunes.FortuneResponse>(
                  this, METHODID_RETRIEVE)))
          .build();
    }
  }

  /**
   */
  public static final class FortuneStub extends io.grpc.stub.AbstractAsyncStub<FortuneStub> {
    private FortuneStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FortuneStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FortuneStub(channel, callOptions);
    }

    /**
     */
    public void retrieve(o.oo.grpc.fortunes.FortuneRequest request,
        io.grpc.stub.StreamObserver<o.oo.grpc.fortunes.FortuneResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRetrieveMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class FortuneBlockingStub extends io.grpc.stub.AbstractBlockingStub<FortuneBlockingStub> {
    private FortuneBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FortuneBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FortuneBlockingStub(channel, callOptions);
    }

    /**
     */
    public o.oo.grpc.fortunes.FortuneResponse retrieve(o.oo.grpc.fortunes.FortuneRequest request) {
      return blockingUnaryCall(
          getChannel(), getRetrieveMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class FortuneFutureStub extends io.grpc.stub.AbstractFutureStub<FortuneFutureStub> {
    private FortuneFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FortuneFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FortuneFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<o.oo.grpc.fortunes.FortuneResponse> retrieve(
        o.oo.grpc.fortunes.FortuneRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRetrieveMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_RETRIEVE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FortuneImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FortuneImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_RETRIEVE:
          serviceImpl.retrieve((o.oo.grpc.fortunes.FortuneRequest) request,
              (io.grpc.stub.StreamObserver<o.oo.grpc.fortunes.FortuneResponse>) responseObserver);
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

  private static abstract class FortuneBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FortuneBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return o.oo.grpc.fortunes.FortuneService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Fortune");
    }
  }

  private static final class FortuneFileDescriptorSupplier
      extends FortuneBaseDescriptorSupplier {
    FortuneFileDescriptorSupplier() {}
  }

  private static final class FortuneMethodDescriptorSupplier
      extends FortuneBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FortuneMethodDescriptorSupplier(String methodName) {
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
      synchronized (FortuneGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FortuneFileDescriptorSupplier())
              .addMethod(getRetrieveMethod())
              .build();
        }
      }
    }
    return result;
  }
}
