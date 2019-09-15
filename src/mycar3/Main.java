/* 
 * Author: Theodore Pollock
 * Email: pollockt@tulsapretech.com // pollock@nsu.edu
 * File name: Main.java
 * File Description: main starter file
 */	

package mycar3;
import java.util.Scanner;


public class Main {

   public static void main(String[] args) {
        runSplash();
        MyCar car1 = new MyCar(28421,"Lexus","RC 200t");//int odometer, string make, string model
        System.out.println("Welcome to your car, would you like to turn it on? [Y]es or [N]o:");
        Scanner input = new Scanner(System.in);
        String action = input.next();
        car1.useIgnition();

        while(!action.equals("QUIT") || !action.equals("quit")) {

            System.out.println("\nWhat would you like to do now?");
            mainMenu();
            action = input.next();
            if(action.equals("I") || action.equals("i")){
                car1.useIgnition();
            }else if(action.equals("C") || action.equals("c")){
                car1.toStringSpeed();
            }else if(action.equals("A") || action.equals("a")){
                System.out.println("How fast do you want to accelerate (in mph)? ");
                int accelerate = input.nextInt();
                car1.accelerateSpeed(accelerate);
            }else if(action.equals("B") || action.equals("b")){
                System.out.println("How much do you want to brake (in mph)? ");
                int brake = input.nextInt();
                car1.brakeSpeed(brake);
            }else if(action.equals("G") || action.equals("g")){
                car1.toStringGear();
            }else if(action.equals("O") || action.equals("o")){
                car1.toStringOdometer();
            }else if(action.equals("S") || action.equals("s")){
                car1.carStatus();
            }else if(action.equals("T") || action.equals("t")){
            	
            }else if(action.equals("H") || action.equals("h")){
            	car1.headingCheck();
            }
        }
        input.close();
	}
	
	 /**
     * Method that gives a console menu in order to control car. NOTE: the gears are automatically controlled.
     */
    public static void mainMenu(){
        System.out.println("You can turn your car Ignition off by pressing [I]");
        System.out.println("You can Accelerate by pressing [A]");
        System.out.println("You can Brake by pressing [B]");
        System.out.println("You can Turn the car by pressing [T]");
        System.out.println("You can check your direction by typing [H]");
        System.out.println("You can check your speed by pressing [C]");
        System.out.println("You can look at your odometer by pressing [O](not the number 0)");
        System.out.println("You can check your gear by pressing [G]");
        System.out.println("You can check your car's status by typing [S]");
        System.out.println("You can quit by typing [QUIT]");
    }
    
    public static void runSplash(){
        Splash splash = new Splash();
        
        splash.setVisible(true);
        try{
            for(int i = 0; i <= 100; i++){
                Thread.sleep(45);
                if(i == 100){
                    splash.dispose();
                }
            }
        }catch(Exception e){
            
        }
    }
    
}
