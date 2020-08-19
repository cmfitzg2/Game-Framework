

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;

public class GameState extends State implements LineListener
{
	private ScreenFade screenFade;
	private long startTime;
	private World world1, world2;
	private Rectangle loadZone1;
	private boolean oneToTwo = false, twoToOne = false;
	public static boolean playStarted = false;
	static AudioClip overworldMusic;
	static AudioClip overworldMusicLoop;
	boolean switcher = false;
	
	public GameState(Handler handler)
	{
		super(handler);
		world1 = new World(handler,"world1.txt");
		world2 = new World(handler,"world2.txt");
		screenFade = new ScreenFade(handler);
		handler.setWorld(world1);
	}
	
	
	
	@Override
	public void tick() 
	{
		/*
		if(!playStarted)
		{
			playMusic();
			playStarted = true;
		}
		*/
		
		
		if(handler.getWorld() == world1)
		{
			/*
			if(twoToOne)
			{
				handler.getWorld().getEntityManager().getPlayer().setX(11);
				handler.getWorld().getEntityManager().getPlayer().setY(304);
				twoToOne = false;
			}
			*/
			world1.tick();
			/*
			getLoadZones(1);

			if(Player.playerRec.intersects(loadZone1))
			{
				handler.setWorld(world2);
				oneToTwo = true;
			}
			*/
			
		}
		
		
		else if(handler.getWorld() == world2)
		{
			/*
			if(oneToTwo)
			{
				handler.getWorld().getEntityManager().getPlayer().setX(1130);
				handler.getWorld().getEntityManager().getPlayer().setY(304);
				oneToTwo = false;
			}
			*/
			world2.tick();
			/*
			getLoadZones(2);
			
			if(Player.playerRec.intersects(loadZone1))
			{
				handler.setWorld(world1);
				twoToOne = true;
			}
			*/
		}
		
		
	}
	private boolean firstTime = true, secondTime = true;
	private long now;
	private int alpha = 255;
	@Override
	public void render(Graphics g) 
	{
		g.setColor(Color.RED);
		
		if(handler.getWorld() == world1)
			world1.render(g);
		else if(handler.getWorld() == world2)
			world2.render(g);
		g.fillRect((int) -handler.getGameCamera().getxOffset(),(int) (320 - handler.getGameCamera().getyOffset()),10,64);
	}
	
	private void getLoadZones(int worldNumber)
	{
		if(worldNumber == 1)
		{
			loadZone1 = new Rectangle((int) -handler.getGameCamera().getxOffset(),(int) (320 - handler.getGameCamera().getyOffset()),45,64);
		}
		else if(worldNumber == 2)
		{
			loadZone1 = new Rectangle((int) (1200 - handler.getGameCamera().getxOffset()),(int) (320 - handler.getGameCamera().getyOffset()),10,64);
		}
		
	}
	
	public void playMusic()
	{
		playStarted = true;
		overworldMusic = Applet.newAudioClip(getClass().getResource("ocean.au"));
		overworldMusicLoop = Applet.newAudioClip(getClass().getResource("ocean.au"));
		
		overworldMusic.play();
		startTime = System.currentTimeMillis();
	}
	
	public static void stopMusic()
	{
		playStarted = false;
		overworldMusic.stop();
	}



	@Override
	public void update(LineEvent event) {
		// TODO Auto-generated method stub
		
	}
	
}
