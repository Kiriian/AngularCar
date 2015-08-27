/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise3Textwriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author Jeanette
 */
public class Controller
{
    
    public static void Save(List<String> lines)
    {
        String userDir = new JFileChooser().getFileSystemView().getDefaultDirectory().toString();
        File textfile = new File(userDir);
        if (lines == null)
        {
            System.out.println("array is empty");
        }

        try
        {
            FileWriter writer = new FileWriter("textfile", false);
            PrintWriter out = new PrintWriter(writer);
            for (String line : lines)
            {
                out.println(line.toString() + ("\r\n"));
            }
            out.close();
        } catch (IOException ex)
        {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
