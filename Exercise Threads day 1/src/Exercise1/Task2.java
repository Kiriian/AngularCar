/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jeanette
 */
public class Task2
{

    public static class Thread1 extends Thread
    {
        @Override
        public void run()
        {
            for (int i = 1; i < 6; i++)
            {
                System.out.println(i);
                
                try
                {
                    Thread.sleep(2000);
                } catch (InterruptedException ex)
                {
                    Logger.getLogger(Task2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static void main(String[] args)
    {
        Thread1 t1 = new Thread1();
            
            t1.start();
    }
}
