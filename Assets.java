import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Assets {
	
	private static final int width = 32, height = 32;
	public static final int textboxWidth = 228, textboxHeight = 96;
	
	public static BufferedImage dirt, grass, stone, tree, water, black, gray,
								playerDownNormal, playerUpNormal, playerLeftNormal, playerRightNormal,
								visionCircle;
	public static BufferedImage textbox, textbox_player;
	public static BufferedImage[] player_down, player_up, player_left, player_right;
	public static BufferedImage[] player_sit_right;
	public static BufferedImage[] btn_start;
	public static BufferedImage[] reflection_down, reflection_up, reflection_left, reflection_right;
	public static Font sans, serif;
	public static void init(){
		try {
		    //create the font to use. Specify the size!
		    sans = Font.createFont(Font.TRUETYPE_FONT, new File("sans.ttf")).deriveFont(36f);
		    serif = Font.createFont(Font.TRUETYPE_FONT, new File("serif.ttf")).deriveFont(36f);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    //register the font
		    ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("sans.ttf")));
		    ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("serif.ttf")));
		} catch (IOException e) {
		    e.printStackTrace();
		} catch(FontFormatException e) {
		    e.printStackTrace();
		}
		
		SpriteSheet reflectionSheet = new SpriteSheet(ImageLoader.loadImage("/res/textures/characterclone.png"));
		SpriteSheet dedaf = new SpriteSheet(ImageLoader.loadImage("/res/textures/dedaf.png"));
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/res/textures/sheet.png"));
		SpriteSheet playerSheet = new SpriteSheet(ImageLoader.loadImage("/res/textures/Charactersheet.png"));
		SpriteSheet menuSheet = new SpriteSheet(ImageLoader.loadImage("/res/textures/Start.png"));
		
		textbox_player = ImageLoader.loadImage("/res/textures/tb1.png");
		textbox = ImageLoader.loadImage("/res/textures/tb.png");
		visionCircle = ImageLoader.loadImage("/res/textures/visioncircle.png");
		
		btn_start = new BufferedImage[2];
		btn_start[0] = menuSheet.crop(0,0,width*2,height);
		btn_start[1] = menuSheet.crop(width*2, 0, width, height);
		
		player_down = new BufferedImage[4]; 		//4 = frame count
		player_up = new BufferedImage[4];
		player_left = new BufferedImage[4];
		player_right = new BufferedImage[4];
		
		player_down[0] = playerSheet.crop(0, 0, width, height);
		player_down[1] = playerSheet.crop(width, 0, width, height);
		player_down[2] = playerSheet.crop(width*2, 0, width, height);
		player_down[3] = playerSheet.crop(width*3, 0, width, height);
		
		player_up[0] = playerSheet.crop(0, height, width, height);
		player_up[1] = playerSheet.crop(width, height, width, height);
		player_up[2] = playerSheet.crop(width*2, height, width, height);
		player_up[3] = playerSheet.crop(width*3, height, width, height);
		
		player_left[0] = playerSheet.crop(0, height*2, width, height);
		player_left[1] = playerSheet.crop(width, height*2, width, height);
		player_left[2] = playerSheet.crop(width*2, height*2, width, height);
		player_left[3] = playerSheet.crop(width*3, height*2, width, height);
		
		player_right[0] = playerSheet.crop(0, height*3, width, height);
		player_right[1] = playerSheet.crop(width, height*3, width, height);
		player_right[2] = playerSheet.crop(width*2, height*3, width, height);
		player_right[3] = playerSheet.crop(width*3, height*3, width, height);
		
		player_sit_right = new BufferedImage[4];
		
		player_sit_right[0] = dedaf.crop(0, 0, width, height);
		player_sit_right[1] = dedaf.crop(width, 0, width, height);
		player_sit_right[2] = dedaf.crop(width*2, 0, width, height);
		player_sit_right[3] = dedaf.crop(width*3, 0, width, height);		
		
		playerDownNormal = player_down[0];
		playerLeftNormal = player_left[0];
		playerRightNormal = player_right[0];
		playerUpNormal = player_up[0];
		
		reflection_down = new BufferedImage[4];
		reflection_up = new BufferedImage[4];
		reflection_left = new BufferedImage[4];
		reflection_right = new BufferedImage[4];
		
		reflection_down[0] = reflectionSheet.crop(0, 0, width, height);
		reflection_down[1] = reflectionSheet.crop(width, 0, width, height);
		reflection_down[2] = reflectionSheet.crop(width*2, 0, width, height);
		reflection_down[3] = reflectionSheet.crop(width*3, 0, width, height);
		
		reflection_up[0] = reflectionSheet.crop(0, height, width, height);
		reflection_up[1] = reflectionSheet.crop(width, height, width, height);
		reflection_up[2] = reflectionSheet.crop(width*2, height, width, height);
		reflection_up[3] = reflectionSheet.crop(width*3, height, width, height);
		
		reflection_left[0] = reflectionSheet.crop(0, height*2, width, height);
		reflection_left[1] = reflectionSheet.crop(width, height*2, width, height);
		reflection_left[2] = reflectionSheet.crop(width*2, height*2, width, height);
		reflection_left[3] = reflectionSheet.crop(width*3, height*2, width, height);
		
		reflection_right[0] = reflectionSheet.crop(0, height*3, width, height);
		reflection_right[1] = reflectionSheet.crop(width, height*3, width, height);
		reflection_right[2] = reflectionSheet.crop(width*2, height*3, width, height);
		reflection_right[3] = reflectionSheet.crop(width*3, height*3, width, height);
				
		dirt = sheet.crop(0,0,width,height);
		grass = sheet.crop(width, 0, width, height);
		stone = sheet.crop(width*2, 0, width, height);
		tree = sheet.crop(width*3, 0, width, height);
		water = sheet.crop(0, height*2, width, height);
		black = sheet.crop(width, height*2, width, height);
		gray = sheet.crop(width*2, height*2, width, height);
	}
	public static int getTextboxHeight()
	{
		return textboxHeight;
	}
	
	public static int getTextboxWidth()
	{
		return textboxWidth;
	}
}
