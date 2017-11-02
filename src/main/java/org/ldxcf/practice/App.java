package org.ldxcf.practice;

/**
 * Hello world!
 *
 */
public class App 
{
	public App(){
		
	}
	public void anonmousClass(){
//		new Thread(new Runnable(){
//
//			public void run() {
//				// TODO Auto-generated method stub
//				System.out.println("anonmousClass");
//			}
//			
//		}).start();
		new Thread(() -> {System.out.println("lambda");}).start();
	}
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
