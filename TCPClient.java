import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) {
        try {
            Socket clientSocket = new Socket("localhost", 6799);
            PrintWriter outToServer = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String messageToServer = "Hello, Server!";
            outToServer.println(messageToServer);

            String serverResponse = inFromServer.readLine();
            System.out.println("Response from server: " + serverResponse);

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}