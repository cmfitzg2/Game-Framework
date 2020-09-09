package src;

public class GrayTile extends Tile {

	public GrayTile(int id) 
	{
		super(Assets.gray, id);
	}
	
	@Override
	public boolean isSolid()
	{
		return false;
	}

}
