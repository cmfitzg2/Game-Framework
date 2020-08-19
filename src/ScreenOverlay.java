package src;

import java.awt.Color;
import java.awt.Graphics;

public class ScreenOverlay
{
	int gameWidth = 0;
	int gameHeight = 0;
	Handler handler; 
	
	public ScreenOverlay(Handler handler)
	{
		this.handler = handler;
		gameWidth = handler.getGame().getWidth();
		gameHeight = handler.getGame().getHeight();
	}
	
	void overlayScreen(Graphics graphics, Color c)
	{
		graphics.setColor(c);
		graphics.fillRect(0, 0, gameWidth, gameHeight);
	}
	
	
}
