package grpcholamundo.cliente;

import com.proto.saludo.SaludoServiceGrpc;
import com.proto.saludo.Holamundo.SaludoRequest;
import com.proto.saludo.Holamundo.SaludoResponse;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Cliente {

    public static void main(String[] args) {
        
    String host = "localhost";
    int PUERTO = 9000;

    ManagedChannel ch = ManagedChannelBuilder.forAddress(host, PUERTO).usePlaintext().build();

    SaludoServiceGrpc.SaludoServiceBlockingStub stub = SaludoServiceGrpc.newBlockingStub(ch);

    SaludoRequest petition = SaludoRequest.newBuilder().setNombre("Tristan").build();
    SaludoResponse response = stub.saludo(petition);
    
    System.out.println("Response RPC : "+ response.getResultado());
    System.out.println("Apagando");

    ch.shutdown();

    }
}
