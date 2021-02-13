package o.oo.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import o.oo.grpc.fortunes.FortuneGrpc;
import o.oo.grpc.fortunes.FortuneRequest;
import o.oo.grpc.fortunes.FortuneResponse;

/**
 * Server that manages startup/shutdown of a server.
 */
public class FortuneServer {
  private static final Logger logger = Logger.getLogger(FortuneServer.class.getName());

  private Server server;

  private void start() throws IOException {
    /* The port on which the server should run */
    int port = 50051;
    server = ServerBuilder.forPort(port)
        .addService(new FortuneServiceImpl())
        .build()
        .start();
    logger.info("Server started, listening on " + port);
    Runtime.getRuntime().addShutdownHook(new Thread() {
      @Override
      public void run() {
        // Use stderr here since the logger may have been reset by its JVM shutdown hook.
        System.err.println("*** shutting down gRPC server since JVM is shutting down");
        try {
          FortuneServer.this.stop();
        } catch (InterruptedException e) {
          e.printStackTrace(System.err);
        }
        System.err.println("*** server shut down");
      }
    });
  }

  private void stop() throws InterruptedException {
    if (server != null) {
      server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
    }
  }

  /**
   * Await termination on the main thread since the grpc library uses daemon threads.
   */
  private void blockUntilShutdown() throws InterruptedException {
    if (server != null) {
      server.awaitTermination();
    }
  }

  /**
   * Main launches the server from the command line.
   */
  public static void main(String[] args) throws IOException, InterruptedException {
    final FortuneServer server = new FortuneServer();
    server.start();
    server.blockUntilShutdown();
  }

  static class FortuneServiceImpl extends FortuneGrpc.FortuneImplBase {
    @Override
    public void retrieve(FortuneRequest req, StreamObserver<FortuneResponse> responseObserver) {
      FortuneResponse reply = FortuneResponse.newBuilder().setMessage("wisdom: " + req.getName()).build();
      responseObserver.onNext(reply);
      responseObserver.onCompleted();
    }
  }
}