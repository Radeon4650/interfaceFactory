package StartDialogs;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server1 implements Runnable{

    
    // declare a server socket and a client socket for the server
    
    ServerSocket echoServer = null;
    Socket clientSocket = null;
    private boolean isOpen=false;
    int port;
    
    public Server1( int port ) {
	this.port = port;
    }
    
    
    public void isStart() throws IOException{
        
    if(!isOpen) throw new IOException("Another copy of the program openned");
}

    @Override
    public void run() {
        try {
            // Try to open a server socket on the given port
            // Note that we can't choose a port less than 1024 if we are not
            // privileged users (root)
            
            echoServer = new ServerSocket(port);
            System.out.println( "Port << "+port+" >> opens" );
            
            // Create a socket object from the ServerSocket to listen and accept connections.
            // Use Server1Connection to process the connection.
            isOpen=true;
	while ( true ) {
                        

//	    try {
//		clientSocket = echoServer.accept();
//		Server1Connection oneconnection = new Server1Connection(clientSocket, this);
//		oneconnection.run();
//	    }   
//	    catch (IOException e) {
//		System.out.println(e);
//	    }
	}
        } catch (IOException ex) {
            isOpen=false;
                Logger.getLogger(Server1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }


//class Server1Connection {
//    BufferedReader is;
//    PrintStream os;
//    Socket clientSocket;
//    Server1 server;
//    
//    public Server1Connection(Socket clientSocket, Server1 server) {
//	this.clientSocket = clientSocket;
//	this.server = server;
//	System.out.println( "Connection established with: " + clientSocket );
//	try {
//	    is = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//	    os = new PrintStream(clientSocket.getOutputStream());
//	} catch (IOException e) {
//	    System.out.println(e);
//	}
//    }
//    
//    public void run() {
//        String line;
//	try {
//	    boolean serverStop = false;
//	    
//            while (true) {
//                line = is.readLine();
//		System.out.println( "Received " + line );
//                int n = Integer.parseInt(line);
//		if ( n == -1 ) {
//		    serverStop = true;
//		    break;
//		}
//		if ( n == 0 ) break;
//                os.println("" + n*n ); 
//            }
//	    
//	    System.out.println( "Connection closed." );
//            is.close();
//            os.close();
//            clientSocket.close();
//	    
//	    if ( serverStop ) server.stopServer();
//	} catch (IOException e) {
//	    System.out.println(e);
//	}
//    }
//}}
