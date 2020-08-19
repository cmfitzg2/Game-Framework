

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class ScreenFade 
{
	int gameWidth = 0, gameHeight = 0, xVal = 0, yVal = 0, playerX = 0, playerY = 0;
	String playerDir = "";
	Handler handler;
	
	public ScreenFade(Handler handler)
	{
		this.handler = handler;
		gameWidth = handler.getGame().getWidth();
		gameHeight = handler.getGame().getHeight();
	}
	
	void fadeScreen(Graphics g, int alpha)
	{
		Color c = new Color(0, 0, 0, alpha);
		g.setColor(c);
		g.fillRect(0, 0, gameWidth, gameHeight);
	}
	
	void lightScreen(Graphics g)
	{
		/*
		 * top left to bottom left
		 * top right to bottom right
		 * bottom left to bottom right
		 * top left to top right 
		 */
		Color c = Color.BLACK;
		playerDir = Player.getDirection();
		g.setColor(c);
		if(playerDir.equals("up"))
		{
			g.fillRect(0, 0, (int) (handler.getWorld().getEntityManager().getPlayer().x + handler.getWorld().getEntityManager().getPlayer().bounds.x - handler.getGameCamera().getxOffset()) - 32, gameHeight);
			g.fillRect((int) (handler.getWorld().getEntityManager().getPlayer().x + handler.getWorld().getEntityManager().getPlayer().bounds.x - handler.getGameCamera().getxOffset()) + 32, 0, gameWidth, gameHeight);
			g.fillRect(0, (int) (handler.getWorld().getEntityManager().getPlayer().y + handler.getWorld().getEntityManager().getPlayer().bounds.y - handler.getGameCamera().getyOffset()) + 64, gameWidth, gameHeight);
		}
			
		else if(playerDir.equals("down"))
		{
			g.fillRect(0, 0, (int) (handler.getWorld().getEntityManager().getPlayer().x + handler.getWorld().getEntityManager().getPlayer().bounds.x - handler.getGameCamera().getxOffset()) - 32, gameHeight);
			g.fillRect((int) (handler.getWorld().getEntityManager().getPlayer().x + handler.getWorld().getEntityManager().getPlayer().bounds.x - handler.getGameCamera().getxOffset()) + 64, 0, gameWidth, gameHeight);
			g.fillRect(0, 0, gameWidth, (int) (handler.getWorld().getEntityManager().getPlayer().y + handler.getWorld().getEntityManager().getPlayer().bounds.y - handler.getGameCamera().getyOffset()) - 32);
		}
		else if(playerDir.equals("left"))
		{
			g.fillRect((int) (handler.getWorld().getEntityManager().getPlayer().x + handler.getWorld().getEntityManager().getPlayer().bounds.x - handler.getGameCamera().getxOffset()) + 64, 0, gameWidth, gameHeight);
			g.fillRect(0, (int) (handler.getWorld().getEntityManager().getPlayer().y + handler.getWorld().getEntityManager().getPlayer().bounds.y - handler.getGameCamera().getyOffset()) + 32, gameWidth, gameHeight);
			g.fillRect(0, 0, gameWidth, (int) (handler.getWorld().getEntityManager().getPlayer().y + handler.getWorld().getEntityManager().getPlayer().bounds.y - handler.getGameCamera().getyOffset()) - 32);
		}
			
		else if(playerDir.equals("right"))
		{
			g.fillRect(0, 0, (int) (handler.getWorld().getEntityManager().getPlayer().x + handler.getWorld().getEntityManager().getPlayer().bounds.x - handler.getGameCamera().getxOffset()) - 32, gameHeight);
			g.fillRect(0, (int) (handler.getWorld().getEntityManager().getPlayer().y + handler.getWorld().getEntityManager().getPlayer().bounds.y - handler.getGameCamera().getyOffset()) + 32, gameWidth, gameHeight);
			g.fillRect(0, 0, gameWidth, (int) (handler.getWorld().getEntityManager().getPlayer().y + handler.getWorld().getEntityManager().getPlayer().bounds.y - handler.getGameCamera().getyOffset()) - 32);
		}
	}	
}
