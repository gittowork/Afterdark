package game;
import acm.graphics.*;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.Timer;

import acm.graphics.GLabel;
import acm.graphics.GImage;
import acm.program.GraphicsProgram;
import utilities.MainApplication;

import java.awt.Rectangle;
import acm.graphics.*;

public class Bullet implements ActionListener {
	
	private GImage sprite;
	private Entity sender;
	private Direction direction;
	private int damage;
	private MainApplication program;
	private static final int DAMAGE = 1;
	private static final int SPEED = 1;
	public static final String SPRITE_PREFIX = "../media/images/";
	
	Timer someTimer = new Timer(10, this);
	
	public Bullet(String imageName, Entity se, Direction d) {
		sender = se;
		direction = d;
		damage = DAMAGE;
		this.sprite = new GImage(SPRITE_PREFIX + imageName, se.getX(), se.getY());
		this.sprite.setSize(16, 20);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (direction == Direction.EAST) {
			sprite.move(SPEED, 0);
		}
		else {
			sprite.move(-SPEED, 0);
		}
	}
	
	public GImage getSprite() {
		return sprite;
	}
	
	public void setSprite(GImage s) {
		sprite = s;
	}
	
	public Entity getSender() {
		return sender;
	}
	
	public void setDamage(int d) {
		damage = d;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public Direction getDirection() {
		return direction;
	}
	
	public void setDirection(Direction d) {
		direction = d;
	}
	
/*	private Boolean destroy(Entity e) {
		if (sprite.getElementAt(e.getX(), e.getY()) == ) {
			return true;
		}
	}
*/
	
	public void move() {
		someTimer.start();
	}
	
}
