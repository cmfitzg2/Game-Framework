

//import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Player extends Creature
{
	private static boolean down = false, up = false, left = false, right = false;
	private boolean interactedWith = false;
	//Animations	
	private Animation animDown, animUp, animLeft, animRight;
	public static Rectangle playerRec;
	private ScreenFade screenFade;
	
	public Player(Handler handler, float x, float y) 
	{
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		bounds.x = 16;
		bounds.y = 32;
		bounds.width = 32;
		bounds.height = 32;
		
		//Animations
		animDown = new Animation(250, Assets.player_down);
		animLeft = new Animation(250, Assets.player_left);
		animUp = new Animation(250, Assets.player_up);
		animRight = new Animation(250, Assets.player_right);
		
		//Menu
		
		//ScreenFade
		screenFade = new ScreenFade(handler);

	}

	@Override
	public void tick() 
	{
		System.out.println("current x: " + x + "       current y: " + y);
		if(handler.getPlayerFrozen())
			return;
		
		//Animations
				animDown.tick();
				animLeft.tick();
				animUp.tick();
				animRight.tick();
			
		//Movement
		currentPlayerRectangle();
		if(handler.getGameFlag() != 9 && handler.getGameFlag() != 10)
			getInput();
		else
			autoMove();
		move();
		handler.getGameCamera().centerOnEntity(this);
		checkInteraction();
	}
	
	private void currentPlayerRectangle()
	{
		playerRec = new Rectangle((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
				(int) (y + bounds.y - handler.getGameCamera().getyOffset()),
				bounds.width, bounds.height);
	}
	
	private void checkInteraction()
	{
		Rectangle collisionBounds = getCollisionBounds(0,0);
		Rectangle ir = new Rectangle();
		int interactionSize = 20;
		ir.width = interactionSize;
		ir.height = interactionSize;
		
		if(handler.getKeyManager().z)
		{
			if(!handler.getKeyManager().isStillHoldingZ())
			{
				handler.getKeyManager().setStillHoldingZ(true);
				if(up)
				{
					ir.x = collisionBounds.x + collisionBounds.width/2 - interactionSize/2;
					ir.y = collisionBounds.y - interactionSize;
				}
				else if(down)
				{
					ir.x = collisionBounds.x + collisionBounds.width/2 - interactionSize/2;
					ir.y = collisionBounds.y + collisionBounds.height;
				}
				else if(left)
				{
					ir.x = collisionBounds.x - interactionSize;
					ir.y = collisionBounds.y + collisionBounds.height/2 - interactionSize/2;
				}
				else if(right)
				{
					ir.x = collisionBounds.x + collisionBounds.width;
					ir.y = collisionBounds.y + collisionBounds.height/2 - interactionSize/2;
				}
				else return;
			
			}
			
			for(Entity e : handler.getWorld().getEntityManager().getEntities())
			{
				if(e.equals(this))					//an entity cannot interact with itself
					continue;
				if(e.getCollisionBounds(0, 0).intersects(ir))
				{
					if(e.isInteracting())
						return;
					else e.interactedWith();				//call interaction function specified by any class extending entity
					return;
				}
			}
		}
	}
	
	@Override
	public void die()
	{
		System.out.println("you lose");
	}
	
	private void getInput()
	{
		xMove = 0;
		yMove = 0;
		runSpeed = 7.5f;
		speed = 5.0f;
		
		if(handler.getKeyManager().up)
			if(handler.getKeyManager().shift)
				yMove = -runSpeed;
			else 
				yMove = -speed;
		if(handler.getKeyManager().down)
			if(handler.getKeyManager().shift)
				yMove = runSpeed;
			else 
				yMove = speed;
		if(handler.getKeyManager().left)
			if(handler.getKeyManager().shift)
				xMove = -runSpeed;
			else 
				xMove = -speed;
		if(handler.getKeyManager().right)
			if(handler.getKeyManager().shift)
				xMove = runSpeed;
			else 
				xMove = speed;
	}

	private void autoMove()
	{

	}
	int alpha = 0;
	@Override
	public void render(Graphics g) 
	{

	}
	
	public void renderPlayer(Graphics g)
	{
		if(handler.getPlayerFrozen())
		{
			if(up)
				g.drawImage(Assets.playerUpNormal, (int) (x - handler.getGameCamera().getxOffset()),  (int) (y-handler.getGameCamera().getyOffset()), width, height, null);
			if(down)
				g.drawImage(Assets.playerDownNormal, (int) (x - handler.getGameCamera().getxOffset()),  (int) (y-handler.getGameCamera().getyOffset()), width, height, null);
			if(left)
				g.drawImage(Assets.playerLeftNormal, (int) (x - handler.getGameCamera().getxOffset()),  (int) (y-handler.getGameCamera().getyOffset()), width, height, null);
			if(right)
				g.drawImage(Assets.playerRightNormal, (int) (x - handler.getGameCamera().getxOffset()),  (int) (y-handler.getGameCamera().getyOffset()), width, height, null);
		}
		else
		{
			
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()),  (int) (y-handler.getGameCamera().getyOffset()), width, height, null);
		
		/*
		g.setColor(Color.RED);
		g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
				(int) (y + bounds.y - handler.getGameCamera().getyOffset()),
				bounds.width, bounds.height);
		*/
		
		}
	}

	private BufferedImage getCurrentAnimationFrame()
	{
		if(xMove<0)
		{
			left = true; right = false; up = false; down = false;
			return animLeft.getCurrentFrame();
		}
		else if(xMove>0)
		{
			right = true; left = false; up = false; down = false;
			return animRight.getCurrentFrame();
		}
		else if(yMove<0)
		{
			up = true; left = false; right = false; down = false;
			return animUp.getCurrentFrame();
		}
		else if(yMove>0)
		{
			down = true; left = false; up = false; right = false;
			return animDown.getCurrentFrame();
		}
		//not moving
		else if(right)
			return Assets.playerRightNormal;
		else if(up)
			return Assets.playerUpNormal;
		else if(left)
			return Assets.playerLeftNormal;
		else
			return Assets.playerDownNormal;
			
	}
	
	public void interactedWith()
	{
		//Player should never be interacted with
		interactedWith = true;
		System.out.println("Interaction with " + this);
		interactedWith = false;
	}
	
	public boolean isInteracting()
	{
		return interactedWith;
	}
	public Rectangle getPlayerRec() {
		return playerRec;
	}

	@Override
	public boolean isFirstRender() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public static String getDirection()
	{
		if(up)
			return "up";
		if(down)
			return "down";
		if(left)
			return "left";
		else return "right";
	}
	
	public float playerX()
	{
		return getX();
	}
	
	public float playerY()
	{
		return getY();
	}

}
