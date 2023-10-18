import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8080)) {
            System.out.println("Сервер запущен");
            while (true) {
                try (
                        Socket clientSocket = server.accept();
                        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
                ) {
                    System.out.println("Новый клиент");
                    out.println("Как ваше имя?");
                    String nameClient = in.readLine();
                    out.println("Вы ребенок? (да/нет)");
                    String isChildTextInput = in.readLine();
                    if (isChildTextInput.equals("да")) {
                        out.println(String.format("%s, добро пожаловать в детскую комнату! Давай играть!", nameClient));
                    } else if (isChildTextInput.equals("нет")) {
                        out.println(String.format("%s, добро пожаловать в наше заведение! " +
                                "Хорошего отдыха или хорошего рабочего дня!", nameClient));
                    } else {
                        out.println(String.format("%s, простите! " +
                                "К сожалению, мне не удалось понять ваш ответ!" +
                                " пожалуйста обратитесь к Администратору", nameClient));
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
