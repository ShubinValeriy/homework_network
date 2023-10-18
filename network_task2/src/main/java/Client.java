import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (
                Socket clientSocket = new Socket("netology.homework", 8080);
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
        ) {
            System.out.println(in.readLine());
            out.println(userWork());
            System.out.println(in.readLine());
            out.println(userWork());
            System.out.println(in.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static String userWork() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
