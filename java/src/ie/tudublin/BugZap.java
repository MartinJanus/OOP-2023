package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet
{

	//player values
	float playerX, playerY;
	float playerWidth = 40;
	float playerHeight = playerWidth / 2;
	float playerSpeed = 5;

	//bug values 
	float bugX, bugY;
	float bugWidth = 40;
	float halfBugWidth = bugWidth / 2;


	//game
	int score = 0;
	int frame = 30;
	int gameMode = 0; 


	public void settings()
	{
		size(1000, 1000);
	}

	public void setup() 
	{
		colorMode(RGB);
		background(0);

		playerX = (width / 2) - (playerWidth / 2); 
		playerY = height - playerWidth;

		bugX = random(halfBugWidth,width - halfBugWidth);
		bugY = 50;
	}



	public void draw()
	{	
		background(0);
		fill(255);
		text("Score: " + score, 50, 100);
		drawPlayer(playerX, playerY, playerWidth);
		drawBug(bugX, bugY, bugWidth);
	}

	public void drawPlayer(float x, float y, float w)
	{

		strokeWeight(2);
		stroke(57, 255, 20);
		fill(0);
		playerHeight = w / 2;
		rect(x, y, w, playerHeight);
		ellipse(x + w / 2, y, w, playerHeight);


	}

	public void drawBug(float x, float y, float w)
	{
		strokeWeight(2);
		stroke(57, 255, 20);
		fill(0);
		line(x, y, x + w, y + w);
		line(x, y + w, x + w, y);

	}

	public void resetBug()
	{
		bugX = random(halfBugWidth,width - halfBugWidth);
		bugY = 50;
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
				score++;
				resetBug();
			}
		}
		
		if((frameCount % frame) == 0)
		{
			bugX += random(-100, 100);
			bugY += 40;
			// frame -= 1;
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
			score = 0;
		}
	}

	public void splashScreen()
	{
		background(0); 
		fill(255);
		// if(gameMode == 0)
		// {
		// 	textAlign(CENTER, CENTER);
		// 	text("BUGZAP! \n PRESS SPACE TO START", width / 2, height / 2);
		// 	if(keyCode == ' ')
		// 	{
		// 		gameMode = 1;
		// 	}
		// }
	}

}
