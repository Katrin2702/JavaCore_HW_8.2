import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {

        Socket clientSocket = new Socket("netology.homework", 8080);
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()), true);
             Scanner scanner = new Scanner(System.in)) {
            System.out.println(in.readLine());
            out.println(scanner.nextLine());
            System.out.println(in.readLine());
            out.println(scanner.nextLine());
            System.out.println(in.readLine());
        }

    }
}