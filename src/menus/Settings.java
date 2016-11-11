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

// Settings class

/*
 * Settings will hold our settings for if the game sound is on or off as well as the music. 
 * Volume will be up to the hardware of the device the user is playing on.
 */
public class Settings extends GraphicsPane {

	private boolean isMusicOn = true;
	private boolean isSoundOn = true;



	private MainApplication program; //you will use program to get access to all of the GraphicsProgram calls
	private GImage background;
	private GButton playButton;
	private GButton settingsButton;
	private GButton controlsButton;
	private static final double WIDTH_FACTOR = 25.6;
	private static final double PLAY_HEIGHT_FACTOR = 24;
	private static final double SETTINGS_HEIGHT_FACTOR = 7.45;
	private static final double CONTROLS_HEIGHT_FACTOR = 5.29;
	private static final double PLAY_SIZE_WIDTH = 4.68;
	private static final double PLAY_SIZE_HEIGHT = 10.97;
	private static final double OTHER_SIZE_HEIGHT = 19.2;
	private static final double OTHER_SIZE_WIDTH = 4.57;

	private final double WIDTH_OFFSET= program.WINDOW_WIDTH/WIDTH_FACTOR;
	private final double PLAY_HEIGHT_OFFSET = program.WINDOW_HEIGHT/PLAY_HEIGHT_FACTOR;
	private final double SETTINGS_HEIGHT_OFFSET = program.WINDOW_HEIGHT/SETTINGS_HEIGHT_FACTOR;
	private final double CONTROLS_HEIGHT_OFFSET = program.WINDOW_HEIGHT/CONTROLS_HEIGHT_FACTOR;




	public Settings(MainApplication app) {
		program = app;
		background = new GImage("images/Settings.png", 0, 0);
		playButton = new GButton(WIDTH_OFFSET, PLAY_HEIGHT_OFFSET, 
								program.WINDOW_WIDTH/PLAY_SIZE_WIDTH,
								program.WINDOW_HEIGHT/PLAY_SIZE_HEIGHT, true);
		settingsButton = new GButton(WIDTH_OFFSET, SETTINGS_HEIGHT_OFFSET,
								program.WINDOW_WIDTH/OTHER_SIZE_WIDTH,
								program.WINDOW_HEIGHT/OTHER_SIZE_HEIGHT, true);
		controlsButton = new GButton(WIDTH_OFFSET, CONTROLS_HEIGHT_OFFSET,
								program.WINDOW_WIDTH/OTHER_SIZE_WIDTH,
								program.WINDOW_HEIGHT/OTHER_SIZE_HEIGHT, true);
	}

	@Override
	public void showContents() {
		program.add(background);

	}

	@Override
	public void hideContents() {
		program.remove(background);
	
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if(obj == playButton) {
			program.switchToGame();
		}
	}



	Settings(){
	}

	public boolean getIsMusicOn(){
		return isMusicOn;
	}

	public boolean getIsSoundOn(){
		return isSoundOn;
	}

	public void setIsSoundOn(boolean s){
		isSoundOn = s;
	}

	public void setIsMusicOn(boolean m){
		isMusicOn = m;
	}

	public void getDifficultLevel(){

	}

	public void setDifficultyLevel(String s){

	}

	public void settingsMenu(){

	}

	public void settingsPause(){

	}
}
