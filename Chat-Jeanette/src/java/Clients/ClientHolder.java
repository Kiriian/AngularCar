/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jeanette
 */
public class ClientHolder extends Thread
{
    private Socket socket;
    private String userName;
    private final PrintWriter writer;
    BufferedReader input;

    public ClientHolder(Socket socket, String userName) throws IOException
    {
        this.socket = socket;
        this.userName = userName;
        writer = new PrintWriter(socket.getOutputStream(), true);
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void sendMSG(String msg)
    {
        writer.println(msg);
    }

    @Override
    public void run()
    {
        try
        {
            String msg = input.readLine();
            while (msg != null && !msg.isEmpty())
            {
                
            }
        } catch (IOException ex)
        {
            Logger.getLogger(ClientHolder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
