import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void  main(String[] arv) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 2000);
        BufferedReader in;
        PrintStream out;

        in =  new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintStream(socket.getOutputStream());

        String str = "";
        while (str.compareTo("end") != 0){

            Scanner scanner = new Scanner(System.in);
            str = scanner.nextLine();
            out.println(str);

            System.out.println(in.readLine());
        }
    }
}
