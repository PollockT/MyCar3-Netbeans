/* 
 * Author: Theodore Pollock
 * Email: pollockt@tulsapretech.com // pollock@nsu.edu
 * File name: MyCar.java
 * File Description: Class for creating object MyCar
 */	

package mycar3;
import java.util.Scanner;

public class MyCar {
		
	
	    private boolean engineRunning = false;
	    private int speedCurrent = 0;
	    private int odometer;
	    private int currentGear;
	    private String make;
	    private String model;
	    private String heading = "North";
	    

	    /**
	     * Constructor for MyCar Class, requires following attributes
	     * @param odometer the amount of miles on the car
	     * @param make the make of the car, ie Ford, or Chevy
	     * @param model the type of car, like F150 or C320
	     */
	    public MyCar(int odometer, String make, String model) {
	        this.odometer = odometer;
	        this.make = make;
	        this.model = model;}
	    
	    /*
	     * Default constructor if no information is fed into object when it is being created.
	     */
	    public MyCar() {}

	    /**
	     * Method prints out the car's heading
	     */
	    public void headingCheck() {
                //TODO: grab the degree angle and convert it to N,S,E,W, or inbetween
	    	System.out.println(getHeading());
	    }
	    
	    public String initiateTurn(String x) {
                //TODO: CREATE METHOD TO KEEP TRACK OF DEGREES ON HEADING
	    	System.out.println("[L] for turning left and [R] for turning right.");
	    	Scanner action2 = new Scanner(System.in);
	    	String turn = action2.next();
	    	if(turn.equals("L") || turn.equals("l")){
                        //TODO: Subtract degree amount
	    		System.out.println("[H]ard or [E]asy turn(90 degree or 45 degree turn)?");
	    		turn = action2.next();
	    		if(turn.equals("H") || turn.equals("h")){
                            //TODO: Subtract 90
                            System.out.println("Turning 90 degrees to the left.");
	    		}else if(turn.contentEquals("E") || turn.contentEquals("e")){
                            //TODO: Subtract 45
                            System.out.println("Turning 45 degrees to the left.");
	    		}
	    	}else if(turn.equals("R") || turn.equals("r")){
                        //TODO: Add degree amount
	    		System.out.println("[H]ard or [E]asy turn(90 degree or 45 degree turn)?");
	    		turn = action2.next();
	    		if(turn.equals("H") || turn.equals("h")){
                            //TODO: Add 90 degrees
	    		    System.out.println("Turning 90 degrees to the right.");
	    		}else if(turn.contentEquals("E") || turn.contentEquals("e")){
                            //TODO: Add 45 degrees
                            System.out.println("Turning 45 degrees to the right.");
	    		}
	    	}
	    	action2.close();
	    	return x;
	    }
	    /**
	     * Method directly controls what gear the car is in, like an automatic car.
	     * @param x is the current speed
	     * @return the current gear
	     */
	    public int checkGear(int x){
	        final int FIRST_GEAR_START = 0;
	        final int FIRST_GEAR_END = 30;
	        final int SECOND_GEAR_START = 31;
	        final int SECOND_GEAR_END = 45;
	        final int THIRD_GEAR_START = 46;
	        final int THIRD_GEAR_END = 60;
	        final int FOURTH_GEAR_START = 61;
	        final int FOURTH_GEAR_END = 73;
	        final int FIFTH_GEAR_START = 74;
	        final int FIFTH_GEAR_END = 89;
	        final int SIX_GEAR_START = 90;
	        final int SIX_GEAR_END = 120;

	        if(getSpeedCurrent() >= FIRST_GEAR_START  && getSpeedCurrent() <= FIRST_GEAR_END){
	            setCurrentGear(1);
	        }if(getSpeedCurrent() >= SECOND_GEAR_START && getSpeedCurrent() <= SECOND_GEAR_END){
	            setCurrentGear(2);
	        }if(getSpeedCurrent() >= THIRD_GEAR_START && getSpeedCurrent() <= THIRD_GEAR_END){
	            setCurrentGear(3);
	        }if(getSpeedCurrent() >= FOURTH_GEAR_START && getSpeedCurrent() <= FOURTH_GEAR_END){
	            setCurrentGear(4);
	        }if(getSpeedCurrent() >= FIFTH_GEAR_START && getSpeedCurrent() <= FIFTH_GEAR_END){
	            setCurrentGear(5);
	        }if(getSpeedCurrent() >= SIX_GEAR_START && getSpeedCurrent() <= SIX_GEAR_END){
	            setCurrentGear(6);
	        }
	       return x;
	       }

	    /**
	     * Method prints out the current gear the class is in.
	     */
	    public void toStringGear() {
	        checkGear(getSpeedCurrent());
	        System.out.println("Your in gear " + getCurrentGear());
	    }
	    
	    /**
	     * Method that prints the speed the car is currently traveling at.
	     */
	    public void toStringSpeed(){
	        System.out.println("Your current speed is " + getSpeedCurrent() + "mph!");
	    }

	    /**
	     * Method to print out the current mileage on the car.
	     */
	    public void toStringOdometer(){
	        System.out.println("The current mileage on the car is " + getOdometer() + " miles.");
	    }

	    /**
	     * Method allows the object to de-accelerate speed, and then adds it to the current speed while
	     * printing to the screen only the amount of the de-acceleration. It will then check the current
	     * speed and update the gear accordingly
	     * @param x brake amount
	     * @return final speed
	     */
	    public int brakeSpeed(int x){
	        System.out.println("Braking down " + x + "mph!");
	        setSpeedCurrent(getSpeedCurrent() - x);
	        checkGear(getSpeedCurrent());
	        return x;
	    }

	    /**
	     * Method allows the object to accelerate speed, and then adds it to the current speed while
	     * printing to the screen only the amount of the acceleration. It will then check the current
	     * speed and update the gear accordingly
	     * @param x acceleration
	     * @return final speed
	     */
	    public int accelerateSpeed(int x){
	        System.out.println("Accelerating up " + x + "mph!");
	        setSpeedCurrent(getSpeedCurrent() + x);
	        checkGear(getSpeedCurrent());
	        return x;
	    }

	    /**
	     * Method to turn car on and off using boolean types. Each call will flip the method's value
	     */
	    public void useIgnition(){
	        if (engineRunning == false){
	            engineRunning = true;
	            System.out.println("Vrrooommm! Car is on!");

	        }else if(engineRunning){
	            engineRunning = false;
	            System.out.println("Putter putter! Car is off!");

	        } 
	    }

	    /**
	     * Prints out the car's status in one method, the speed, gear, odometer, make, and model
	     */
	    public void carStatus(){
	        System.out.println("Your car is traveling at " + getSpeedCurrent() + "mph.");
	        System.out.println("Your car is in gear " + getCurrentGear() + ".");
	        System.out.println("You have " + getOdometer() + " miles on the car.");
	        System.out.println("The car is a " + getModel() + " made by " + getMake());
	    }

	    //public boolean isEngineRunning() {return engineRunning;}
	    //public void setEngineRunning(boolean engineRunning){this.engineRunning = engineRunning;}
	    //public int setOdometer(int odometer){this.odometer = odometer;}
	    public int getOdometer(){return odometer;}
	    public int getSpeedCurrent(){return speedCurrent;}
	    public void setSpeedCurrent(int speedCurrent){this.speedCurrent = speedCurrent;}
	    public void setCurrentGear(int currentGear){this.currentGear = currentGear;}
	    public int getCurrentGear(){return currentGear;}
	    public String getMake(){return make;}
	    public String getHeading(){return heading;}
	    public void setHeading(String heading){this.heading = heading;}
	    //public String setMake(String make){this.make = make;}
	    public String getModel(){return model;}
	    //public String setModel(String model){this.model = model;}
	}
