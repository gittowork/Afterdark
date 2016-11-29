package game;
import java.awt.Rectangle;

import acm.graphics.GImage;
import acm.program.GraphicsProgram;

public class Entity {
	public static final String PATH = "../media/images/";
	public static final String EXTENSION = ".png";
	public static final double MOVEMENT = 10;
	public static final double GRAVITY = 3;
	public static final double FRICTION = 3;
	public static final double JUMP_VELOCITY = 20;
	private static final double MAX_GRAVITY = 50;
	private static final double MAX_SPEED = 15;
	
	protected String imageName;
	protected boolean amIJumping;
	protected boolean amIWalking;
	protected int currentStep;
	protected int numImages;
	protected GImage sprite;
	protected double dy;
	protected double dx;
	
	public Entity(String sprite, int startX, int startY, int imagesInAnimation) {
		imageName = sprite;
		currentStep = 0;
		numImages = imagesInAnimation;
		this.sprite = new GImage(getCorrectSprite(), startX, startY);
		this.sprite.setSize(16, 16);
		amIJumping = false;
		amIWalking = false;
		dy = 0;
		dx = 0;
	}
	
	public boolean amIJumping() {
		return amIJumping;
	}

	public void setJumping(boolean amIJumpin) {
		this.amIJumping = amIJumpin;
	}

	public void move(double x, double y) {
		sprite.move(x, y);
		if(x != 0) {
			currentStep++;
		}
		sprite.setImage(getCorrectSprite());
	}
	
	private String getCorrectSprite() {
		int imgToGet = currentStep % numImages;
		return PATH + imageName+imgToGet+EXTENSION;
	}
	
	public void jump() {
		dy = -JUMP_VELOCITY;
		setJumping(true);
		move(0, -0.1);
	}
	
	public void reflectHorizontally() {
		dx = -1 * dx;
	}
	
	public void reflectVertically() {
		dy = -1 * dy;
	}
	
	public void setLocation(int x, int y) {
		sprite.setLocation(x, y);
	}
	
	public double getX() {
		return sprite.getX();
	}
	
	public double getY() {
		return sprite.getY();
	}
	
	public Rectangle getBox() {
		return new Rectangle((int) sprite.getX(), (int) sprite.getY(), (int) sprite.getWidth(), (int) sprite.getHeight());
	}

	public void fall(Scene s) {
		move(0, dy);
		
		dy += GRAVITY;
		dy = Math.min(dy, MAX_GRAVITY);
		dy = Math.max(dy, -JUMP_VELOCITY);
	}
	
	public void walk(Direction d) {
		if(d == Direction.EAST) {
			System.out.println("dx: " + dx);
			dx += MOVEMENT;
			dx = Math.min(dx, MAX_SPEED);
		}else if(d == Direction.WEST) {
			System.out.println("dx: " + dx);
			dx -= MOVEMENT;
			dx = Math.max(dx, -MAX_SPEED);
		}
		amIWalking = true;
	}
	
	public void walkMovement() {
		move(dx, 0);
		if(dx > 0) {
			System.out.println("dx: " + dx);
			dx -= FRICTION;
			dx = Math.max(dx, 0);
		}else if(dx < 0) {
			System.out.println("dx: " + dx);
			dx += FRICTION;
			dx = Math.min(dx, 0);
		}
	}
	
	public double horzCenterDifference() {
		return Game.horzCenter() - getX();
	}
	
	public double vertCenterDifference() {
		return Game.vertCenter() - getY();
	}
	
	public void horzScroll(double distance) {
		sprite.move(distance, 0);
	}
	
	public void vertScroll(double distance) {
		sprite.move(0, distance);
	}

	public double getHeight() {
		return sprite.getHeight();
	}
	
	public GImage getSprite() {
		return sprite;
	}

	public boolean isWalking() {
		return amIWalking;
	}

	public void setWalking(boolean amIWalking) {
		this.amIWalking = amIWalking;
	}
}
