/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fib;

/**
 *
 * @author Jeanette
 */
public class Fib {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       Fib Fi=new Fib();
        int n=14;
        int f=Fi.fibonacci(n);
        System.out.println(f);
    }
    public int fibonacci(int n)
    {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return fibonacci(n-1)+fibonacci(n-2);
    }
    
}
