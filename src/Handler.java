package src;

public class Handler
{
	private Game game;
	private World world;
	private boolean playerFrozen = false, isInMenu = false;
	private int worldNumber = 1;

	public Handler(Game game)
	{
		this.game = game;
	}

	public KeyManager getKeyManager()
	{
		return game.getKeyManager();
	}

	public MouseManager getMouseManager()
	{
		return game.getMouseManager();
	}

	public GameCamera getGameCamera()
	{
		return game.getGameCamera();
	}

	public int getWidth()
	{
		return game.getWidth();
	}

	public int getHeight()
	{
		return game.getHeight();
	}

	public Game getGame() {
		return game;
	}

	public boolean getPlayerFrozen()
	{
		return playerFrozen;
	}

	public void setPlayerFrozen(boolean playerFrozen)
	{
		this.playerFrozen = playerFrozen;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public int getWorldNumber()
	{
		return worldNumber;
	}

	public void setWorldNumber(int worldNumber)
	{
		this.worldNumber = worldNumber;
	}
}
