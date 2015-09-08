/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Clients.ClientHolder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Utils;

/**
 *
 * @author Jeanette
 */
public class ChatServer
{

    private static final Properties properties = Utils.initProperties("server.properties");
    private static boolean keepRunning = true;
    private ServerSocket serverSocket;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private ClientHolder ch;
    private ConcurrentHashMap<String, ClientHolder> userMap = new ConcurrentHashMap<String, ClientHolder>();

    public void runServer()
    {
        int port = Integer.parseInt(properties.getProperty("port"));
        String ip = properties.getProperty("serverIp");
        String userName;

        try
        {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(ip, port));

            while (keepRunning)
            {
                socket = serverSocket.accept(); //Important Blocking call
                Logger.getLogger(ChatServer.class.getName()).log(Level.INFO, "Connected to a client");
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
                
                userName = in.readLine();
                while (true)
                {
                    userMap.putIfAbsent(userName, ch = new ClientHolder(socket, userName));
                    ch.sendMSG(in.readLine());
                }
            }

        } catch (IOException ex)
        {
            Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args)
    {
        String logFile = properties.getProperty("logFile");
        Utils.setLogFile(logFile, ChatServer.class.getName());

        try
        {
            new ChatServer().runServer();
        } finally
        {
            Utils.closeLogger(ChatServer.class.getName());
        }
    }
}
