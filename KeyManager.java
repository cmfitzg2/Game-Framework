

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{

	private long visionTimer, visionCooldown = 800, lastVisionTimer = visionCooldown;
	private boolean[] keys, justPressed, cantPress;
	public boolean up, down, left, right, z, shift, x, c, esc;
	private boolean stillHoldingZ = false, stillHoldingC = false;

	public KeyManager()
	{
		keys = new boolean[256];
		justPressed = new boolean[keys.length];
		cantPress = new boolean[keys.length];
	}
	
	public void tick()
	{
		for(int i = 0; i < keys.length; i++)
		{
			if(cantPress[i] && !keys[i])
				cantPress[i] = false;
			else if(justPressed[i])
			{
				cantPress[i] = true;
				justPressed[i] = false;
			}
			if(!cantPress[i] && keys[i])
				justPressed[i] = true;
		}
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
		shift = keys[KeyEvent.VK_SHIFT];
		z = keys[KeyEvent.VK_Z];
		x = keys[KeyEvent.VK_X];
		c = keys[KeyEvent.VK_C];
		esc = keys[KeyEvent.VK_ESCAPE];
	}
	
	@Override
	public void keyPressed(KeyEvent e) 
	{
		if(e.getKeyCode() >= 256)
			return;
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		if(e.getKeyCode() <= 256)
		keys[e.getKeyCode()] = false;
		if(e.getKeyCode() == KeyEvent.VK_Z)
			stillHoldingZ = false;
		if(e.getKeyCode() == KeyEvent.VK_C)
			stillHoldingC = false;
	}
	
	public boolean keyJustPressed(int keyCode)
	{
		if(keyCode < 0 || keyCode >= keys.length)
			return false;
		return justPressed[keyCode];
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{
		
	}
	
	public boolean isStillHoldingZ() 
	{
		return stillHoldingZ;
	}

	public void setStillHoldingZ(boolean stillHoldingZ) 
	{
		this.stillHoldingZ = stillHoldingZ;
	}
	
	public boolean isStillHoldingC()
	{
		return stillHoldingC;
	}

	public void setStillHoldingC(boolean stillHoldingC)
	{
		this.stillHoldingC = stillHoldingC;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public void setRight(boolean right) {
		this.right = right;
	}
}
