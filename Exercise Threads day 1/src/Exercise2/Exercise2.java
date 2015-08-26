/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jeanette
 */
public class Exercise2
{
    private static int n = 0;
    
    public static void main(String[] args)
    {
        Thread1 t1 = new Thread1();
        Thread1 t2 = new Thread1();
        
        t1.start();
        t2.start();
        
        try
        {
            t1.join();
            t2.join();
            System.out.println("n " + n);
        } catch (InterruptedException ex)
        {
            Logger.getLogger(Exercise2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private static class Thread1 extends Thread
    {
        @Override
        public void run()
        {
            for (int i = 0; i < 5; i++)
            {
                System.out.println(next());                
            }
        }
    }
    
    public synchronized static int next()
    {
        n++;
        n++;
        return n;
    }
}
