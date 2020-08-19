package src;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Assets {
	
	private static final int width = 32, height = 32;
	public static final int textboxWidth = 228, textboxHeight = 96;
	
	public static BufferedImage dirt, grass, stone, tree, water,
								playerDownNormal, playerUpNormal, playerLeftNormal, playerRightNormal;
	public static BufferedImage textbox, textbox_player;
	public static BufferedImage[] player_down, player_up, player_left, player_right;
	public static BufferedImage[] player_sit_right;
	public static BufferedImage[] btn_start;
	public static BufferedImage[] currentTime;
	public static BufferedImage[] currentTemperature;
	public static BufferedImage[] currentThreat;
	public static BufferedImage[] currentFear;	
	public static BufferedImage[] currentHunger;	
	public static BufferedImage[] currentThirst;	
	public static Font philosopher;
	public static void init(){
		try {
		    //create the font to use. Specify the size!
		    philosopher = Font.createFont(Font.TRUETYPE_FONT, new File("philosopher.ttf")).deriveFont(72f);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    //register the font
		    ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("philosopher.ttf")));
		} catch (IOException e) {
		    e.printStackTrace();
		} catch(FontFormatException e) {
		    e.printStackTrace();
		}
		
		SpriteSheet dedaf = new SpriteSheet(ImageLoader.loadImage("/res/textures/dedaf.png"));
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/res/textures/sheet.png"));
		SpriteSheet playerSheet = new SpriteSheet(ImageLoader.loadImage("/res/textures/newcharactersheet.png"));
		SpriteSheet menuSheet = new SpriteSheet(ImageLoader.loadImage("/res/textures/Start.png"));
		SpriteSheet daynightSheet = new SpriteSheet(ImageLoader.loadImage("/res/textures/daynightHud.png"));
		SpriteSheet temperatureSheet = new SpriteSheet(ImageLoader.loadImage("/res/textures/temperatureHud.png"));
		SpriteSheet threatSheet = new SpriteSheet(ImageLoader.loadImage("/res/textures/threatHud.png"));
		SpriteSheet fearSheet = new SpriteSheet(ImageLoader.loadImage("/res/textures/fearHud.png"));
		SpriteSheet hungerSheet = new SpriteSheet(ImageLoader.loadImage("/res/textures/hungerHud.png"));
		SpriteSheet thirstSheet = new SpriteSheet(ImageLoader.loadImage("/res/textures/thirstHud.png"));
		
		textbox_player = ImageLoader.loadImage("/res/textures/tb1.png");
		textbox = ImageLoader.loadImage("/res/textures/tb.png");
		
		btn_start = new BufferedImage[2];
		btn_start[0] = menuSheet.crop(0,0,width*2,height);
		btn_start[1] = menuSheet.crop(width*2, 0, width, height);
		
		currentTime		= new BufferedImage[7];
		currentTime[0] 	= daynightSheet.crop(0, 0, 48, 48);
		currentTime[1] 	= daynightSheet.crop(48, 0, 48, 48);
		currentTime[2] 	= daynightSheet.crop(96, 0, 48, 48);
		currentTime[3] 	= daynightSheet.crop(144, 0, 48, 48);
		currentTime[4] 	= daynightSheet.crop(0, 48, 48, 48);
		currentTime[5] 	= daynightSheet.crop(48, 48, 48, 48);
		currentTime[6] 	= daynightSheet.crop(96, 48, 48, 48);
		
		currentTemperature 		= new BufferedImage[12];
		currentTemperature[0]	= temperatureSheet.crop(0, 0, 128, 24);
		currentTemperature[1]	= temperatureSheet.crop(128, 0, 128, 24);
		currentTemperature[2]	= temperatureSheet.crop(256, 0, 128, 24);
		currentTemperature[3]	= temperatureSheet.crop(0, 24, 128, 24);
		currentTemperature[4]	= temperatureSheet.crop(128, 24, 128, 24);
		currentTemperature[5]	= temperatureSheet.crop(256, 24, 128, 24);
		currentTemperature[6]	= temperatureSheet.crop(0, 48, 128, 24);
		currentTemperature[7]	= temperatureSheet.crop(128, 48, 128, 24);
		currentTemperature[8]	= temperatureSheet.crop(256, 48, 128, 24);
		currentTemperature[9]	= temperatureSheet.crop(0, 72, 128, 24);
		currentTemperature[10]	= temperatureSheet.crop(128, 72, 128, 24);
		currentTemperature[11]	= temperatureSheet.crop(256, 72, 128, 24);
		
		currentThreat	 	= new BufferedImage[12];
		currentThreat[0]	= threatSheet.crop(0, 0, 128, 24);
		currentThreat[1]	= threatSheet.crop(128, 0, 128, 24);
		currentThreat[2]	= threatSheet.crop(256, 0, 128, 24);
		currentThreat[3]	= threatSheet.crop(0, 24, 128, 24);
		currentThreat[4]	= threatSheet.crop(128, 24, 128, 24);
		currentThreat[5]	= threatSheet.crop(256, 24, 128, 24);
		currentThreat[6]	= threatSheet.crop(0, 48, 128, 24);
		currentThreat[7]	= threatSheet.crop(128, 48, 128, 24);
		currentThreat[8]	= threatSheet.crop(256, 48, 128, 24);
		currentThreat[9]	= threatSheet.crop(0, 72, 128, 24);
		currentThreat[10]	= threatSheet.crop(128, 72, 128, 24);
		currentThreat[11]	= threatSheet.crop(256, 72, 128, 24);
		
		currentFear 	 	= new BufferedImage[12];
		currentFear[0]		= fearSheet.crop(0, 0, 128, 24);
		currentFear[1]		= fearSheet.crop(128, 0, 128, 24);
		currentFear[2]		= fearSheet.crop(256, 0, 128, 24);
		currentFear[3]		= fearSheet.crop(0, 24, 128, 24);
		currentFear[4]		= fearSheet.crop(128, 24, 128, 24);
		currentFear[5]		= fearSheet.crop(256, 24, 128, 24);
		currentFear[6]		= fearSheet.crop(0, 48, 128, 24);
		currentFear[7]		= fearSheet.crop(128, 48, 128, 24);
		currentFear[8]		= fearSheet.crop(256, 48, 128, 24);
		currentFear[9]		= fearSheet.crop(0, 72, 128, 24);
		currentFear[10]		= fearSheet.crop(128, 72, 128, 24);
		currentFear[11]		= fearSheet.crop(256, 72, 128, 24);
		
		currentThirst	 	= new BufferedImage[12];
		currentThirst[0]	= thirstSheet.crop(0, 0, 128, 24);
		currentThirst[1]	= thirstSheet.crop(128, 0, 128, 24);
		currentThirst[2]	= thirstSheet.crop(256, 0, 128, 24);
		currentThirst[3]	= thirstSheet.crop(0, 24, 128, 24);
		currentThirst[4]	= thirstSheet.crop(128, 24, 128, 24);
		currentThirst[5]	= thirstSheet.crop(256, 24, 128, 24);
		currentThirst[6]	= thirstSheet.crop(0, 48, 128, 24);
		currentThirst[7]	= thirstSheet.crop(128, 48, 128, 24);
		currentThirst[8]	= thirstSheet.crop(256, 48, 128, 24);
		currentThirst[9]	= thirstSheet.crop(0, 72, 128, 24);
		currentThirst[10]	= thirstSheet.crop(128, 72, 128, 24);
		currentThirst[11]	= thirstSheet.crop(256, 72, 128, 24);
		
		currentHunger	 	= new BufferedImage[12];
		currentHunger[0]	= hungerSheet.crop(0, 0, 128, 24);
		currentHunger[1]	= hungerSheet.crop(128, 0, 128, 24);
		currentHunger[2]	= hungerSheet.crop(256, 0, 128, 24);
		currentHunger[3]	= hungerSheet.crop(0, 24, 128, 24);
		currentHunger[4]	= hungerSheet.crop(128, 24, 128, 24);
		currentHunger[5]	= hungerSheet.crop(256, 24, 128, 24);
		currentHunger[6]	= hungerSheet.crop(0, 48, 128, 24);
		currentHunger[7]	= hungerSheet.crop(128, 48, 128, 24);
		currentHunger[8]	= hungerSheet.crop(256, 48, 128, 24);
		currentHunger[9]	= hungerSheet.crop(0, 72, 128, 24);
		currentHunger[10]	= hungerSheet.crop(128, 72, 128, 24);
		currentHunger[11]	= hungerSheet.crop(256, 72, 128, 24);
		
		player_down = new BufferedImage[4]; 		//4 = frame count
		player_up = new BufferedImage[4];
		player_left = new BufferedImage[6];
		player_right = new BufferedImage[6];
		
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
		player_left[4] = playerSheet.crop(width*4, height*2, width, height);
		player_left[5] = playerSheet.crop(width*5, height*2, width, height);
		
		player_right[0] = playerSheet.crop(0, height*3, width, height);
		player_right[1] = playerSheet.crop(width, height*3, width, height);
		player_right[2] = playerSheet.crop(width*2, height*3, width, height);
		player_right[3] = playerSheet.crop(width*3, height*3, width, height);
		player_right[4] = playerSheet.crop(width*4, height*3, width, height);
		player_right[5] = playerSheet.crop(width*5, height*3, width, height);
		
		player_sit_right = new BufferedImage[4];
		
		player_sit_right[0] = dedaf.crop(0, 0, width, height);
		player_sit_right[1] = dedaf.crop(width, 0, width, height);
		player_sit_right[2] = dedaf.crop(width*2, 0, width, height);
		player_sit_right[3] = dedaf.crop(width*3, 0, width, height);		
		
		playerDownNormal = player_down[0];
		playerLeftNormal = player_left[5];
		playerRightNormal = player_right[5];
		playerUpNormal = player_up[0];
				
		dirt = sheet.crop(0,0,width,height);
		grass = sheet.crop(width, 0, width, height);
		stone = sheet.crop(width*2, 0, width, height);
		tree = sheet.crop(width*3, 0, width, height);
		water = sheet.crop(0, height*2, width, height);
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
