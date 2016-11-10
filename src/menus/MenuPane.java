package menus;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import utilities.GButton;
import utilities.GraphicsPane;
import utilities.MainApplication;

public class MenuPane extends GraphicsPane {
	private MainApplication program; //you will use program to get access to all of the GraphicsProgram calls
	private GImage background;
	private GButton playButton;
	private GButton settingsButton;
	private GButton controlsButton;
	private static final double WIDTH_FACTOR = 25.6;
	private static final double PLAY_HEIGHT_FACTOR = 24;
	private static final double SETTINGS_HEIGHT_FACTOR = 5.49;
	private static final double CONTROLS_HEIGHT_FACTOR = 4.27;
	private static final double PLAY_SIZE_WIDTH = 4.68;
	private static final double PLAY_SIZE_HEIGHT = 10.97;
	
	private final double WIDTH_OFFSET= program.WINDOW_WIDTH/WIDTH_FACTOR;
	private final double PLAY_HEIGHT_OFFSET = program.WINDOW_HEIGHT/PLAY_HEIGHT_FACTOR;
	
	
	
	public MenuPane(MainApplication app) {
		program = app;
		background = new GImage("images/Main Menu.png", 0, 0);
		playButton = new GButton(WIDTH_OFFSET, PLAY_HEIGHT_OFFSET, 
						program.WINDOW_WIDTH/4.68,program.WINDOW_HEIGHT/10.97, true);
		
	}
	
	@Override
	public void showContents() {
		program.add(background);
		program.add(playButton);
	}

	@Override
	public void hideContents() {
		program.remove(background);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if(obj == background) {
			program.switchToSome();
		}
	}
}
