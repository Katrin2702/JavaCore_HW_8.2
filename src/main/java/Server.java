import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server start");
        Socket clientSocket = serverSocket.accept();
        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out.println("Write your name");
            String userName = in.readLine();
            out.println("Are you child? (yes/no)");
            String answer = in.readLine();
            if (answer.equals("yes")) {
                out.println("Welcome to the kids area, " +  userName + " Let's play!");
                } if (answer.equals("no")) {
                    out.println("Welcome to the adult zone, " +  userName + " Have a good rest, or a good working day!");
                    } else {
                       out.println("invalid input");
                    }
        } catch (IOException ex) {
            ex.printStackTrace();
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

    }

}

