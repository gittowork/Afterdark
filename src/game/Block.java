package game;
/**
 * Block.java
 * @author jackthias
 * Created 11/7/16
 * Block represents a single "tile" of terrain in a scene.
 */

import java.awt.Rectangle;

import acm.graphics.GImage;

/**
 * Block represents a single "tile" of terrain in a scene.
 * @author jackthias
 */
public class Block extends GImage {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int BUFFER_X = 0;
	private static final int BUFFER_Y = 4;

	private boolean isBlockSolid;
	
	public Block(String imageName, double x, double y) {
		super(imageName, x, y);
		isBlockSolid = true;
	}
	
	public boolean isSolid() {
		return isBlockSolid;
	}
	
	public void setSolid(boolean isSolid) {
		isBlockSolid = isSolid;
	}
	
	public Direction getDirectionComingFrom(Rectangle character) {
		//Rectangle myOwnBox = new Rectangle((int) getX(),(int) getY(),(int) getWidth(), (int) getHeight());
		if(character.intersectsLine(getX(), getY(), getX()+getWidth(), getY())) {
			System.out.println("N");
			return Direction.NORTH;
		}
		if(character.intersectsLine(getX(), getY()+getHeight(), getX()+getWidth(), getY()+getHeight())) {
			System.out.println("S");
			return Direction.SOUTH;
		}
		if(character.intersectsLine(getX()+getWidth(), getY(), getX()+getWidth(), getY()+getHeight())) {
			System.out.println("E");
			return Direction.EAST;
		}
		
		if(character.intersectsLine(getX(), getY(), getX(), getY()+getHeight())) {
			System.out.println("W");
			return Direction.WEST;
		}
		
		return Direction.NO_DIRECTION;
	}
}
