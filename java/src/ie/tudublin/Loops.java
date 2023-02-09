package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet {

	int mode = 0;

	public void settings() {
		size(1000, 1000);
		//fullScreen(SPAN);
	}

	public void setup() {
		colorMode(HSB);
	}

	public void keyPressed() {

		mode = key - '0';
		println(mode);
	}

	float off = 0;

	public void draw() {
		background(0);
		fill(255);
		noStroke();

		switch (mode) {
			case 0:
				int numCircles = (int) max(1, mouseX / 50.0f);
				float d = width / numCircles;
				for (int j = 0; j < numCircles; j++) {
					for (int i = 0; i < numCircles; i++) {
						float x = (d * 0.5f) + (d * i);
						float y = (d * 0.5f) + (d * j);
						float c = ((i + j) / ((numCircles - 1) * 2.0f)) * 255.0f;
						fill((c + off) % 256, 255, 255);
						circle(x, y, d);
					}
				}
				off += (mouseY / 50.0f);
				break;
			case 1:
				if(mouseX > 500)
				{
					fill(256, 255, 255);
					rect(0,0,500,1000);
				}
				else
				{
					fill(256, 255, 255);
					rect(500,0,500,1000);
				}
				break;
			case 2: 
				if(mouseX < 500 && mouseY < 500)
				{
					fill(256, 255, 255);
					rect(0,0,500,500);
				}
				else if(mouseX < 500 && mouseY > 500)
				{
					fill(256, 255, 255);
					rect(0,500,500,500);
				}
				else if(mouseX > 500 && mouseY > 500)
				{
					fill(256, 255, 255);
					rect(500,500,500,500);
				}
				else
				{
					fill(256, 255, 255);
					rect(500,0,500,500);
				}
				break;
			case 3: 
				if(mouseX < 750 && mouseX > 250 && mouseY < 650 && mouseY > 350)
				{
					fill(256, 255, 255);
					rect(250,350,500,300);
				}
				else
				{
					fill(0, 0, 255);
					rect(250,350,500,300);
				}



			default:
				break;
		}

	}
}
