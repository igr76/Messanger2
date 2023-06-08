import javax.imageio.IIOException;
import java.io.*;
import java.net.Socket;
import java.nio.charset.Charset;

public class TCPConnection {
    private final Socket socket;
    private final Thread rxThread;
    private final TCPConnectionListener evenListener;
    private final BufferedReader in;
    private final BufferedWriter out;


    public TCPConnection(TCPConnectionListener evenListener,Socket socket) throws IOException {
        this.evenListener = evenListener;
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream(),Charset.forName("UTF-8")));
        out = new BufferedWriter((new OutputStreamWriter(socket.getOutputStream(), Charset.forName("UTF-8"))));
        rxThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    evenListener.onConnectionReady(TCPConnection.this);
                    while (!rxThread.isInterrupted()) {
                        evenListener.onReseiveString(TCPConnection.this,in.readLine());
                    }
                } catch (IOException e) {

                } finally {

                }
            }
        });
        rxThread.start();
    }
}
