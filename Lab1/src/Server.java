import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Server  {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public Server() {
        try {
            serverSocket = new ServerSocket(1001);
            System.out.println(serverSocket);
        } catch (IOException e) {
            fail(e, "Could not start server");
        }
        System.out.println("Server is running...");
        this.run();
    }

    public static void fail(Exception e, String str) {
        System.out.println(str + ". " + e.getMessage());
    }

    public void run() {
        try {
            while (true) {
                clientSocket = serverSocket.accept();
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                System.out.println("Created new connection");
                String text = in.readLine();
                System.out.println("Received: " + text);
                if (text != null) {
                    for (String word : getMinWords(text)) {
                        out.println(word);
                    }

                    for (String word : getMaxWords(text)) {
                        out.println(word);
                    }
                }
                out.close();
                System.out.println("Connection was closed");
            }
        } catch (IOException e) {
            fail(e, "Not listening");
        }
    }

    public List<String> getMinWords(String text) {
        List<String> words = Arrays.asList(text.split(" "));

        String shortestWord = words.stream().min(Comparator.comparing(word -> word.length())).get();
        return Collections.singletonList(shortestWord);
    }

    public List<String> getMaxWords(String text) {
        List<String> words = Arrays.asList(text.split(" "));

        String maxWord = words.stream().max(Comparator.comparing(word -> word.length())).get();

        return Collections.singletonList(maxWord);
    }

    public static void main(String[] args) {
        Server server = new Server();
    }
}