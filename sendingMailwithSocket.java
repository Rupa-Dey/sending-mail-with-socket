import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.util.Base64;
public class sendingMailwithSocket {
    private  static  DataOutputStream dos;

    public static void main(String[] args) throws Exception {
        int delay = 1000;
        String user = "s1912276130@ru.ac.bd";
        String pass = "*****";

        String userName = new String(Base64.getEncoder().encode(user.getBytes()));
        String passWord = new String(Base64.getEncoder().encode(pass.getBytes()));

        SSLSocketFactory sslSocketFactory = (SSLSocketFactory)SSLSocketFactory.getDefault();
        SSLSocket socket = (SSLSocket) sslSocketFactory.createSocket("smtp.gmail.com",465);
        final BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        dos = new DataOutputStream(socket.getOutputStream());

        send ("EHLO smtp.gmail.com \r\n");
        Thread.sleep(delay);
        System.out.println("SERVER: "+br.readLine());
        System.out.println("SERVER: "+br.readLine());
        System.out.println("SERVER: "+br.readLine());
        System.out.println("SERVER: "+br.readLine());
        System.out.println("SERVER: "+br.readLine());
        System.out.println("SERVER: "+br.readLine());
        System.out.println("SERVER: "+br.readLine());
        System.out.println("SERVER: "+br.readLine());
        System.out.println("SERVER: "+br.readLine());

        send("AUTH LOGIN \r\n");
        Thread.sleep(delay);
        System.out.println("SERVER: "+br.readLine());

        send(userName + "\r\n");
        Thread.sleep(delay);
        System.out.println("SERVER: "+br.readLine());

        send(passWord+ "\r\n");
        Thread.sleep(delay);
        System.out.println("SERVER: "+br.readLine());

        send("MAIL FROM: <s1912276130@ru.ac.bd>\r\n");
        Thread.sleep(delay);
        System.out.println("SERVER: "+br.readLine());

        send("RCPT TO: <deyrupa525@gmail.com> \r\n");
        Thread.sleep(delay);
        System.out.println("SERVER: "+br.readLine());

        send("DATA \r\n");
        Thread.sleep(delay);
        System.out.println("SERVER: "+br.readLine());
        Thread.sleep(delay);

        send("Subject: 3Y1S2021-1912276130\r\n");
        Thread.sleep(delay);
        send("Adab Sir,\r\nName : Rupa Dey.\r\nSession:2018-19 \r\n here is my code link https://ideone.com/UIrOLo\r\n");

        send(".\r\n");
        Thread.sleep(delay);
        System.out.println("SERVER: "+br.readLine());

        send("QUIT\r\n");


    }
    private static void send(String s) throws Exception{
        dos.writeBytes(s);
        System.out.println("CLIENT: "+s);
    }
}

