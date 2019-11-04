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
