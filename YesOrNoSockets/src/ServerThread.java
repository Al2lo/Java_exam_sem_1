import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServerThread extends  Thread{
    BufferedReader in;
    PrintStream out;
    private Integer yes = 0;
    private Integer no = 0;

    private static int count;
    public ServerThread(Socket socket) throws IOException {
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintStream(socket.getOutputStream());
        count = ++count;
    }

    public  void run(){
        try {
            String str = in.readLine();
            while (str.compareTo("end") != 0){
            switch (str){
                case "/yes":{
                    yes = ++yes;
                    out.println(str);
                    break;
                }
                case "/no":{
                    no = ++no;
                    out.println(str);
                    break;
                }
                case "/help":{
                    System.out.println("/yes - увеличить yes /no - увеличить no /getall - вывести кол-воn /help - help");
                    out.println(str+" "+"/yes - увеличить yes /no - увеличить no /getall - вывести кол-воn /help - help");
                    break;
                }
                case "/getall":{
                    System.out.println("count of yes:" + yes.toString());
                    System.out.println("count of no:" + no.toString());
                    out.println("count of yes: " + yes.toString()+" count of no: " + no.toString());
                    break;
                }
                default:break;

            }
                str = in.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public  void disconnect(){

    }
}
