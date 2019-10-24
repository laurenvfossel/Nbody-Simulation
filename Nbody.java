/**
 * Represents a planet
 * @author laurenfossel
 * @date 9-29-17
 */
public class Planet {
	
	private double mass;
	private String name;
	private double velX;
	private double velY;
	private double posX;
	private double posY;
	private double forceX;
	private double forceY;

	/**
	 * Constructor with 6 parameters
	 * @param planetName the name of the planet
	 * @param m the mass of the planet
	 * @param vX the x velocity
	 * @param vY the y velocity
	 * @param pX the x position
	 * @param pY the y position
	 */
	public Planet(String planetName, double m, double vX, double vY, double pX, double pY) {
		mass = m;
		name = planetName;
		velX = vX;
		velY = vY;
		posX = pX;
		posY = pY;
		forceX = 0;
		forceY = 0;
	}
	
	/**
	 * Adds to the x velocity
	 * @param num the number to add to the x velocity
	 */
	public void addToVelX(double num){
		velX+=num;
	}
	
	/**
	 * Adds to the y velocity
	 * @param num the number to add to the y velocity
	 */
	public void addToVelY(double num){
		velY+=num;
	}
	
	/**
	 * Adds to the x position
	 * @param num the number to add to the x position
	 */
	public void addToPosX(double num){
		posX+=num;
	}
	
	/**
	 * Adds to the y position
	 * @param num the number to add to the y position
	 */
	public void addToPosY(double num){
		posY+=num;
	}
	
	/**
	 * Adds to the x force
	 * @param num the number to add to the x force
	 */
	public void addToForceX(double num){
		forceX+=num;
	}
	
	/**
	 * Adds to the y force
	 * @param num the number to add to the y force
	 */
	public void addToForceY(double num){
		forceY+=num;
	}

	public String toString(){
		return posX + " " + posY + " " + velX + " " + velY + " " + mass + " " + name ;
	}

	/** Returns the mass
	 * @return the mass
	 */
	public double getMass() {
		return mass;
	}

	/** Sets the mass
	 * @param mass the mass of the planet
	 */
	public void setMass(double mass) {
		this.mass = mass;
	}

	/** Returns the name of the planet
	 * @return the name of the planet
	 */
	public String getName() {
		return name;
	}

	/** Sets the name of the planet
	 * @param name the name of the planet
	 */
	public void setName(String name) {
		this.name = name;
	}

	/** Returns the x velocity
	 * @return the x velocity
	 */
	public double getVelX() {
		return velX;
	}

	/** Sets the x velocity
	 * @param velX the x velocity
	 */
	public void setVelX(double velX) {
		this.velX = velX;
	}

	/** Returns the y velocity
	 * @return the y velocity
	 */
	public double getVelY() {
		return velY;
	}

	/** Sets the y velocity
	 * @param velY the y velocity
	 */
	public void setVelY(double velY) {
		this.velY = velY;
	}

	/** Returns the x position
	 * @return the x position
	 */
	public double getPosX() {
		return posX;
	}

	/** Sets the x position
	 * @param posX the x position
	 */
	public void setPosX(double posX) {
		this.posX = posX;
	}

	/** Returns the y position
	 * @return the y position
	 */
	public double getPosY() {
		return posY;
	}

	/** Sets the y position
	 * @param posY sets the y position
	 */
	public void setPosY(double posY) {
		this.posY = posY;
	}

	/** Returns the x force
	 * @return x force
	 */
	public double getForceX() {
		return forceX;
	}

	/** Sets the x force
	 * @param forceX the x force
	 */
	public void setForceX(double forceX) {
		this.forceX = forceX;
	}

	/** Returns the y force
	 * @return the y force
	 */
	public double getForceY() {
		return forceY;
	}

	/** Sets the y force
	 * @param forceY the y force
	 */
	public void setForceY(double forceY) {
		this.forceY = forceY;
	}
}


import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Represents a universe with planets orbiting each other
 * @author laurenfossel
 * @date 9-29-17
 */
public class NBody {
	
	private File planetFile;
	private double uniRad;
	private int numPlanets;
	private double timeDur;
	private double timeInc;
	private Planet planetArr[];
	private final double G = 6.67e-11;

	/**
	 * Constructor with 3 parameters
	 * @param fileName The name of the file to be read
	 * @param duration The duration of the simulation
	 * @param increment The time increment 
	 */
	public NBody(String fileName, double duration, double increment) {
		timeDur = duration;
		timeInc = increment;
		planetFile = new File(fileName);
		
		try{
			Scanner scan = new Scanner(planetFile);
			numPlanets = scan.nextInt();
			uniRad = scan.nextDouble();
			planetArr = new Planet[numPlanets];
			
			//Makes the planet array
			for (int x = 0; x<numPlanets; x++){
				double xCoord = scan.nextDouble();
				double yCoord = scan.nextDouble();
				double xVel = scan.nextDouble();
				double yVel = scan.nextDouble();
				double mass = scan.nextDouble();
				String name = scan.next();
				planetArr[x] = new Planet(name, mass, xVel, yVel, xCoord, yCoord);
			}
		} 
		
		catch(IOException e) 
		{
			System.out.println("Error: File not found.");
		}
	}
	
	/**
	 * Sets up the initial conditions of the universe
	 */
	public void setUpUni(){
		StdDraw.setXscale(-uniRad, uniRad);
		StdDraw.setYscale(-uniRad, uniRad);
		StdDraw.enableDoubleBuffering();
		StdDraw.picture(0,0, "starfield.jpg");
		StdDraw.show();
		StdAudio.play("2001.wav");
		drawPlanets();
		StdDraw.pause(2);
	}
	
	/**
	 * Draws each planet
	 */
	public void drawPlanets(){
		StdDraw.picture(0,0, "starfield.jpg");
		for (Planet planet: planetArr){
			StdDraw.picture(planet.getPosX(), planet.getPosY(), planet.getName());
		}
		StdDraw.show();
		StdDraw.pause(2);
	}
	
	/**
	 * Calculates the new forces, accelerations, velocities, and positions. 
	 * Displays the planets
	 */
	public void doSimulation(){
		setUpUni();
		double time = 0;
		
		while (time<timeDur){
			
			
			//Calculate Forces
			double sumXForce;
			double sumYForce;
			
			for (int i=0; i<numPlanets; i++){
				sumXForce = 0;
				sumYForce = 0;
				for (int j=0; j<numPlanets; j++ ){
					if (j!=i){
						double deltaX = planetArr[j].getPosX()-planetArr[i].getPosX();
						double deltaY = planetArr[j].getPosY()-planetArr[i].getPosY();
						sumXForce += (G*planetArr[i].getMass()*planetArr[j].getMass()*deltaX)/(Math.pow(Math.pow(deltaX, 2)+Math.pow(deltaY, 2), 1.5));
						sumYForce += (G*planetArr[i].getMass()*planetArr[j].getMass()*deltaY)/(Math.pow(Math.pow(deltaX, 2)+Math.pow(deltaY, 2), 1.5));
					}
				planetArr[i].setForceX(sumXForce);
				planetArr[i].setForceY(sumYForce);
				}	
			}
			
			//Calculate acceleration, velocity, position
			for (Planet planet: planetArr){
				
				double accelX = planet.getForceX()/planet.getMass();
				double accelY = planet.getForceY()/planet.getMass();
				
				planet.addToVelX(accelX*timeInc);
				planet.addToVelY(accelY*timeInc);
				
				planet.addToPosX(planet.getVelX()*timeInc);
				planet.addToPosY(planet.getVelY()*timeInc);
			}
			
			time+=timeInc;
			drawPlanets();
		}
		
		printPlanetStats();
	}
	
	/** Prints out each planet's conditions
	 * 
	 */
	public void printPlanetStats(){
		for (int i=0; i<numPlanets; i++ )
			System.out.println(planetArr[i]);
	}
}


/**Tests the NBody class
 * @author laurenfossel
 * @date 9-29-17
 */
public class Driver {

	public static void main(String[] args) {
		NBody body = new NBody("PlanetFile.txt", 157788000.0, 25000.0);
		body.doSimulation();
	}
}
