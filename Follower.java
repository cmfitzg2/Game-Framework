import java.awt.Graphics;

public class Follower extends Creature
{
	private Animation animDown, animUp, animLeft, animRight;
	private boolean down = false, up = false, left = false, right = false, interactedWith = false, xFurther = false, yFurther = false;
	private int id = 0;
	private float playerX = 0, playerY = 0;
	
	public Follower(Handler handler, float x, float y)
	{
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		bounds.x = 16;
		bounds.y = 32;
		bounds.width = 32;
		bounds.height = 32;
		
		//Animations
		animDown = new Animation(250, Assets.reflection_down);
		animLeft = new Animation(250, Assets.reflection_left);
		animUp = new Animation(250, Assets.reflection_up);
		animRight = new Animation(250, Assets.reflection_right);
	}

	@Override
	public void tick() 
	{
		xFurther = false; yFurther = false;
		playerX = handler.getWorld().getEntityManager().getPlayer().playerX();
		playerY = handler.getWorld().getEntityManager().getPlayer().playerY();
		
		xMove = 0;
		yMove = 0;
		speed = 0f;
		
		//decide when to move here
		if(playerX < x)
			xMove = -speed;
		if(playerX > x)
			xMove = speed;
		if(playerY < y)
			yMove = -speed;
		if(playerY > y)
			yMove = speed;
		
		if(xMove!=0 || yMove!=0)
			{
			animDown.tick();
			animLeft.tick();
			animUp.tick();
			animRight.tick();
			
			noCollisionX();
			noCollisionY();
			}

		}

	@Override
	public void render(Graphics g) {
		if(yMove>0)
		 {
			down = true; left = false; up = false; right = false;
			g.drawImage(animDown.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()),  (int) (y-handler.getGameCamera().getyOffset()), width, height, null);
		 }
		 else if(xMove>0)
		 {
			down = false; right = true; left = false; up = false;
			g.drawImage(animRight.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()),  (int) (y-handler.getGameCamera().getyOffset()), width, height, null);

		 }
		 else if(yMove<0)
		 {
			up = true; right = false; left = false; down = false;
			g.drawImage(animUp.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()),  (int) (y-handler.getGameCamera().getyOffset()), width, height, null);
		 }
		 else if(xMove<0)
		 {
			left = true; up = false; right = false; down = false;
			g.drawImage(animLeft.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()),  (int) (y-handler.getGameCamera().getyOffset()), width, height, null);
		 }
		
		 else if(xMove == 0 && yMove == 0)
		 {
			 if(down)
				 g.drawImage(animDown.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()),  (int) (y-handler.getGameCamera().getyOffset()), width, height, null);
			 else if(left)
				 g.drawImage(animLeft.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()),  (int) (y-handler.getGameCamera().getyOffset()), width, height, null);
			 else if(up)
				 g.drawImage(animUp.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()),  (int) (y-handler.getGameCamera().getyOffset()), width, height, null);
			 else 
				 g.drawImage(animRight.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset()),  (int) (y-handler.getGameCamera().getyOffset()), width, height, null);
		 }
	}
	@Override
	public void die() 
	{
		
	}

	@Override
	public void interactedWith() 
	{
		interactedWith = true;
	}

	@Override
	public boolean isInteracting() 
	{
		return false;
	}

	@Override
	public boolean isFirstRender() 
	{
		return false;
	}

}