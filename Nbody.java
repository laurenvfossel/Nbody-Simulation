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
