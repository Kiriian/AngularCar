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
public class Task3
{

    public static class Thread1 extends Thread
    {

        public volatile boolean finished = false;

        @Override
        public void run()
        {
            for (int i = 10; i < 1000; i++)
            {
                if (finished)
                {
                    break;
                }
                System.out.println(i);
                try
                {
                    Thread.sleep(3000);
                } catch (InterruptedException ex)
                {
                    Logger.getLogger(Task3.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    public static void main(String[] args)
    {
        Thread1 t1 = new Thread1();

        t1.start();

        try
        {
            Thread.sleep(10000);
        } catch (InterruptedException ex)
        {
            Logger.getLogger(Task3.class.getName()).log(Level.SEVERE, null, ex);
        }
        t1.finished = true;
    }
}
