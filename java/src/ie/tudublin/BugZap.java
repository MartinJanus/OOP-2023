package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet
{

	//player values
	float playerX;
	float playerY; 
	float playerWidth;
	float playerHeight;
	float playerSpeed;

	//bug values 
	float bugX;
	float bugY;
	float bugWidth;


	
	int score;
	int frame;


	public void settings()
	{
		size(1000, 1000);
		// fullScreen();
	}

	public void setup() 
	{
		colorMode(RGB);
		background(0);
		
		//player Settings
		playerX = 10; 
		playerY = 10; 
		playerWidth = 40;
		playerSpeed = 3;  
		playerHeight = playerWidth / 2;

		playerX = (width / 2) - (playerWidth / 2); 
		playerY = height - playerWidth;

		bugX = 10;
		bugY = 10;
		bugWidth = 40;


		frame = 60;
	}



	public void draw()
	{	
		background(0);
		// circle(mouseX, mouseY, 10);
		drawPlayer();
		drawBug();


	}

	// float x, float y, float w
	public void drawPlayer()
	{

		strokeWeight(2);
		stroke(57, 255, 20);
		fill(0);
		playerHeight = playerWidth / 2;
		rect(playerX, playerY, playerWidth, playerHeight);
		ellipse(playerX + playerWidth / 2, playerY, playerWidth, playerHeight);


	}
	//float x, float y, float w
	public void drawBug()
	{
		strokeWeight(2);
		stroke(57, 255, 20);
		fill(0);
		line(bugX, bugY, bugX + bugWidth, bugY + bugWidth);
		line(bugX, bugY + bugWidth, bugX + bugWidth, bugY);

	}

	public void resetBug()
	{
		bugX = random(0,width);
		bugY = 10;
	}
	
	
	public void keyPressed()
	{
		if(keyCode == LEFT)
		{
			System.out.println("Left arrow pressed");
			playerX -= playerSpeed; 
		}
		if(keyCode == RIGHT)
		{
			System.out.println("Right arrow pressed");
			playerX += playerSpeed;
		}
		if(keyCode == ' ')
		{
			System.out.println("Space key pressed");
			//to shoot 
			float x = (int) playerX + playerWidth / 2;
			float y = 0;
			line(x, playerY, x, y);
			if((x>=bugX) &&( x <= bugX + bugWidth))
			{
				y = bugY + bugWidth;
				resetBug();
				score++;
			}
		}
		
		if((frameCount % frame) == 0)
		{
			bugX += random(-100, 100);
			bugY += 30;
			frame -= 1;
		}

		if(playerX < 0)
		{
			playerX = 0;
		}
		if(playerX + playerWidth > width)
		{
			playerX = width - playerWidth;
		}

		if(bugX < 0)
		{
			bugX = 0;
		}
		if(bugX + bugWidth > width)
		{
			bugX = width - bugWidth;
		}
		if(bugY + bugWidth > height)
		{
			resetBug();
		}
	}

	// public void game()
	// {
		

	// }

}
