package src;

import java.awt.Graphics;

public class World {
	private Handler handler;
	private int width, height, spawnX, spawnY;
	private int[][] tiles;
	private boolean world1_1 = false;
	private boolean world2_1 = false;
	private boolean firstTime = true;
	//Entities
	private EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public World(Handler handler, String path) {
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 625, 375));
		
		if(path.equals("world1.txt")) {
			firstTime = true;
			world1_1 = true;
			world2_1 = false;
		}
		
		if(path.equals("world2.txt")) {
			firstTime = true;
			world1_1 = false;
			world2_1 = true;
		}
		
		loadWorld(path);
		//entityManager.getPlayer().setX(spawnX);
		//entityManager.getPlayer().setY(spawnY);
		
	}
	
	public void tick() {
		if(firstTime) {
			if(world1_1) {
				//entityManager.addEntity(new Follower(handler, 875, 575));
				firstTime = false;
			}
			if(world2_1) {
				firstTime = false;
			}
		}
		entityManager.tick();
	}
	
	public void render(Graphics g) {
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);
		
		for(int y=yStart; y<yEnd; y++)
		{
			for(int x=xStart; x<xEnd; x++)
			{
				getTile(x,y).render(g, (int) (x*Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
										(int) (y*Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		entityManager.render(g);
	}
	
	public Tile getTile(int x, int y) {
		if(x<0 || y<0 || x>=width || y>=height)
			return Tile.black;
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t==null)
			return Tile.black;
		return t;
	}
	
	public void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for(int y=0; y<height; y++) {
			for(int x=0; x<width; x++) {
				tiles[x][y] = Utils.parseInt(tokens[(x + y*width) + 4]);
			}
		}
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
}
