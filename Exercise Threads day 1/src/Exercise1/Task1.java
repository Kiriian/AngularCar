/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise1;

/**
 *
 * @author Jeanette
 */
public class Task1
{

    public static class Thread1 extends Thread
    {
        @Override
        public void run()
        {
            long sum = 0;

            for (long i = 0; i <= 1000000000; i++)
            {
                sum = sum + i;
                System.out.println("Sum " +  sum);
            }
        }
        
        public static void main(String[] args)
        {
            Thread1 t1 = new Thread1();
            
            t1.start();
        }
    }

}
