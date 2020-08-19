package src;

import java.awt.Color;
import java.awt.Graphics;

public class Hud 
{
	private ScreenOverlay screenOverlay;
	private Handler handler;
	private SurvivalStatus survivalStatus;
	
	public Hud(Handler handler) 
	{
		this.handler = handler;
		screenOverlay = new ScreenOverlay(handler);
		survivalStatus = new SurvivalStatus();
	}
	
	public void tick()
	{
		if(handler.getKeyManager().one)
		{
			if(!handler.getKeyManager().isStillHolding1())
			{
				handler.getKeyManager().setStillHolding1(true);
				survivalStatus.setCurrentTime(survivalStatus.getCurrentTime()+1);
				if(survivalStatus.getCurrentTime()>=7)
					survivalStatus.setCurrentTime(0);
			}
		}

		if(handler.getKeyManager().three)
		{
			if(!handler.getKeyManager().isStillHolding3())
			{
				handler.getKeyManager().setStillHolding3(true);
				survivalStatus.setCurrentThreat(survivalStatus.getCurrentThreat()+1);
				if(survivalStatus.getCurrentThreat()>=12)
					survivalStatus.setCurrentThreat(0);
			}
		}
		
		if(handler.getKeyManager().four)
		{
			if(!handler.getKeyManager().isStillHolding4())
			{
				handler.getKeyManager().setStillHolding4(true);
				survivalStatus.setCurrentFear(survivalStatus.getCurrentFear()+1);
				if(survivalStatus.getCurrentFear()>=12)
					survivalStatus.setCurrentFear(0);
			}
		}

		if(handler.getKeyManager().five)
		{
			if(!handler.getKeyManager().isStillHolding5())
			{
				handler.getKeyManager().setStillHolding5(true);
				survivalStatus.setCurrentHunger(survivalStatus.getCurrentHunger()+1);
				if(survivalStatus.getCurrentHunger()>=12)
					survivalStatus.setCurrentHunger(0);
			}
		}
		if(handler.getKeyManager().six)
		{
			if(!handler.getKeyManager().isStillHolding6())
			{
				handler.getKeyManager().setStillHolding6(true);
				survivalStatus.setCurrentThirst(survivalStatus.getCurrentThirst()+1);
				if(survivalStatus.getCurrentThirst()>=12)
					survivalStatus.setCurrentThirst(0);
			}
		}
	}
	
	public void render(Graphics graphics)
	{
		//check time of day
		if(survivalStatus.getCurrentTime() == 0)		//dawn
		{
			screenOverlay.overlayScreen(graphics, new Color(255, 81, 58, 60));
			graphics.drawImage(Assets.currentTime[0], handler.getWidth()/2 - 48,  0, 96, 96, null);
		}
		else if(survivalStatus.getCurrentTime() == 1)	//morning
		{
			screenOverlay.overlayScreen(graphics, new Color(255, 162, 0, 60));
			graphics.drawImage(Assets.currentTime[1], handler.getWidth()/2 - 48,  0, 96, 96, null);
		}
		else if(survivalStatus.getCurrentTime() == 2)	//midday
		{
			//screenOverlay.overlayScreen(g, new Color(204, 208, 52, 60));
			graphics.drawImage(Assets.currentTime[2], handler.getWidth()/2 - 48,  0, 96, 96, null);
		}
		else if(survivalStatus.getCurrentTime() == 3)	//afternoon
		{
			graphics.drawImage(Assets.currentTime[3], handler.getWidth()/2 - 48,  0, 96, 96, null);
		}
		else if(survivalStatus.getCurrentTime() == 4)	//night
		{
			screenOverlay.overlayScreen(graphics, new Color(0, 12, 255, 85));
			graphics.drawImage(Assets.currentTime[4], handler.getWidth()/2 - 48,  0, 96, 96, null);
		}
		else if(survivalStatus.getCurrentTime() == 5)	//midnight
		{
			screenOverlay.overlayScreen(graphics, new Color(0, 2, 45, 175));
			graphics.drawImage(Assets.currentTime[5], handler.getWidth()/2 - 48,  0, 96, 96, null);
		}
		else if(survivalStatus.getCurrentTime() == 6)	//twilight
		{
			screenOverlay.overlayScreen(graphics, new Color(57, 37, 124, 100));
			graphics.drawImage(Assets.currentTime[6], handler.getWidth()/2 - 48,  0, 96, 96, null);
		}
		
		//check player temperature
		if(survivalStatus.getCurrentTemperature() == 0)						//freezing
			graphics.drawImage(Assets.currentTemperature[0], 24,  16, null);
		else if(survivalStatus.getCurrentTemperature() == 1)	
			graphics.drawImage(Assets.currentTemperature[1], 24,  16, null);
		else if(survivalStatus.getCurrentTemperature() == 2)	
			graphics.drawImage(Assets.currentTemperature[2], 24,  16, null);
		else if(survivalStatus.getCurrentTemperature() == 3)	
			graphics.drawImage(Assets.currentTemperature[3], 24,  16, null);
		else if(survivalStatus.getCurrentTemperature() == 4)	
			graphics.drawImage(Assets.currentTemperature[4], 24,  16, null);
		else if(survivalStatus.getCurrentTemperature() == 5)	
			graphics.drawImage(Assets.currentTemperature[5], 24,  16, null);
		else if(survivalStatus.getCurrentTemperature() == 6)	
			graphics.drawImage(Assets.currentTemperature[6], 24,  16, null);
		else if(survivalStatus.getCurrentTemperature() == 7)	
			graphics.drawImage(Assets.currentTemperature[7], 24,  16, null);
		else if(survivalStatus.getCurrentTemperature() == 8)	
			graphics.drawImage(Assets.currentTemperature[8], 24,  16, null);
		else if(survivalStatus.getCurrentTemperature() == 9)	
			graphics.drawImage(Assets.currentTemperature[9], 24,  16, null);
		else if(survivalStatus.getCurrentTemperature() == 10)	
			graphics.drawImage(Assets.currentTemperature[10], 24,  16, null);
		else if(survivalStatus.getCurrentTemperature() == 11)					//burning 
			graphics.drawImage(Assets.currentTemperature[11], 24,  16, null);
		
		//check current threat level
		if(survivalStatus.getCurrentThreat() == 0)						
			graphics.drawImage(Assets.currentThreat[0], 200,  16, null);
		else if(survivalStatus.getCurrentThreat() == 1)	
			graphics.drawImage(Assets.currentThreat[1], 200,  16, null);
		else if(survivalStatus.getCurrentThreat() == 2)	
			graphics.drawImage(Assets.currentThreat[2], 200,  16, null);
		else if(survivalStatus.getCurrentThreat() == 3)	
			graphics.drawImage(Assets.currentThreat[3], 200,  16, null);
		else if(survivalStatus.getCurrentThreat() == 4)	
			graphics.drawImage(Assets.currentThreat[4], 200,  16, null);
		else if(survivalStatus.getCurrentThreat() == 5)	
			graphics.drawImage(Assets.currentThreat[5], 200,  16, null);
		else if(survivalStatus.getCurrentThreat() == 6)	
			graphics.drawImage(Assets.currentThreat[6], 200,  16, null);
		else if(survivalStatus.getCurrentThreat() == 7)	
			graphics.drawImage(Assets.currentThreat[7], 200,  16, null);
		else if(survivalStatus.getCurrentThreat() == 8)	
			graphics.drawImage(Assets.currentThreat[8], 200,  16, null);
		else if(survivalStatus.getCurrentThreat() == 9)	
			graphics.drawImage(Assets.currentThreat[9], 200,  16, null);
		else if(survivalStatus.getCurrentThreat() == 10)	
			graphics.drawImage(Assets.currentThreat[10], 200,  16, null);
		else if(survivalStatus.getCurrentThreat() == 11)					 
			graphics.drawImage(Assets.currentThreat[11], 200,  16, null);
		
		//check current fear level
		if(survivalStatus.getCurrentFear() == 0)						
			graphics.drawImage(Assets.currentFear[0], 24,  48, null);
		else if(survivalStatus.getCurrentFear() == 1)	
			graphics.drawImage(Assets.currentFear[1], 24,  48, null);
		else if(survivalStatus.getCurrentFear() == 2)	
			graphics.drawImage(Assets.currentFear[2], 24,  48, null);
		else if(survivalStatus.getCurrentFear() == 3)	
			graphics.drawImage(Assets.currentFear[3], 24,  48, null);
		else if(survivalStatus.getCurrentFear() == 4)	
			graphics.drawImage(Assets.currentFear[4], 24,  48, null);
		else if(survivalStatus.getCurrentFear() == 5)	
			graphics.drawImage(Assets.currentFear[5], 24,  48, null);
		else if(survivalStatus.getCurrentFear() == 6)	
			graphics.drawImage(Assets.currentFear[6], 24,  48, null);
		else if(survivalStatus.getCurrentFear() == 7)	
			graphics.drawImage(Assets.currentFear[7], 24,  48, null);
		else if(survivalStatus.getCurrentFear() == 8)	
			graphics.drawImage(Assets.currentFear[8], 24,  48, null);
		else if(survivalStatus.getCurrentFear() == 9)	
			graphics.drawImage(Assets.currentFear[9], 24,  48, null);
		else if(survivalStatus.getCurrentFear() == 10)	
			graphics.drawImage(Assets.currentFear[10], 24,  48, null);
		else if(survivalStatus.getCurrentFear() == 11)					 
			graphics.drawImage(Assets.currentFear[11], 24,  48, null);
		
		//check current hunger level
		if(survivalStatus.getCurrentHunger() == 0)						
			graphics.drawImage(Assets.currentHunger[0], 200,  48, null);
		else if(survivalStatus.getCurrentHunger() == 1)	
			graphics.drawImage(Assets.currentHunger[1], 200,  48, null);
		else if(survivalStatus.getCurrentHunger() == 2)	
			graphics.drawImage(Assets.currentHunger[2], 200,  48, null);
		else if(survivalStatus.getCurrentHunger() == 3)	
			graphics.drawImage(Assets.currentHunger[3], 200,  48, null);
		else if(survivalStatus.getCurrentHunger() == 4)	
			graphics.drawImage(Assets.currentHunger[4], 200,  48, null);
		else if(survivalStatus.getCurrentHunger() == 5)	
			graphics.drawImage(Assets.currentHunger[5], 200,  48, null);
		else if(survivalStatus.getCurrentHunger() == 6)	
			graphics.drawImage(Assets.currentHunger[6], 200,  48, null);
		else if(survivalStatus.getCurrentHunger() == 7)	
			graphics.drawImage(Assets.currentHunger[7], 200,  48, null);
		else if(survivalStatus.getCurrentHunger() == 8)	
			graphics.drawImage(Assets.currentHunger[8], 200,  48, null);
		else if(survivalStatus.getCurrentHunger() == 9)	
			graphics.drawImage(Assets.currentHunger[9], 200,  48, null);
		else if(survivalStatus.getCurrentHunger() == 10)	
			graphics.drawImage(Assets.currentHunger[10], 200,  48, null);
		else if(survivalStatus.getCurrentHunger() == 11)					 
			graphics.drawImage(Assets.currentHunger[11], 200,  48, null);
		
		//check current thirst level
		if(survivalStatus.getCurrentThirst() == 0)						
			graphics.drawImage(Assets.currentThirst[0], 24,  80, null);
		else if(survivalStatus.getCurrentThirst() == 1)	
			graphics.drawImage(Assets.currentThirst[1], 24,  80, null);
		else if(survivalStatus.getCurrentThirst() == 2)	
			graphics.drawImage(Assets.currentThirst[2], 24,  80, null);
		else if(survivalStatus.getCurrentThirst() == 3)	
			graphics.drawImage(Assets.currentThirst[3], 24,  80, null);
		else if(survivalStatus.getCurrentThirst() == 4)	
			graphics.drawImage(Assets.currentThirst[4], 24,  80, null);
		else if(survivalStatus.getCurrentThirst() == 5)	
			graphics.drawImage(Assets.currentThirst[5], 24,  80, null);
		else if(survivalStatus.getCurrentThirst() == 6)	
			graphics.drawImage(Assets.currentThirst[6], 24,  80, null);
		else if(survivalStatus.getCurrentThirst() == 7)	
			graphics.drawImage(Assets.currentThirst[7], 24,  80, null);
		else if(survivalStatus.getCurrentThirst() == 8)	
			graphics.drawImage(Assets.currentThirst[8], 24,  80, null);
		else if(survivalStatus.getCurrentThirst() == 9)	
			graphics.drawImage(Assets.currentThirst[9], 24,  80, null);
		else if(survivalStatus.getCurrentThirst() == 10)	
			graphics.drawImage(Assets.currentThirst[10], 24,  80, null);
		else if(survivalStatus.getCurrentThirst() == 11)					 
			graphics.drawImage(Assets.currentThirst[11], 24,  80, null);
	}

}
