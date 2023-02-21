package ie.tudublin;

import ddf.minim.Minim;
import ddf.minim.AudioPlayer;
import ddf.minim.AudioInput;
import ddf.minim.AudioBuffer;
import processing.core.PApplet;


public class Audio1  extends PApplet
{

    Minim minim;
    AudioInput ai;
    AudioPlayer ap; 
    AudioBuffer ab;

	public void settings()
	{
		size(1024, 500);
	}

    int frameSize = 1024;

	public void setup() {
		colorMode(HSB);
		background(0);


        minim = new Minim(this); 

        //microphone input
        ai = minim.getLineIn(Minim.MONO, frameSize, 44100, 16);
        ab = ai.mix;

		smooth();
		
	}
	
	public void draw()
	{	
        background(0);
        stroke(255);

        float half = height / 2;
        float cgap = 255 / (float)ab.size();

        float avgAmp = 0; 

        for(int i = 0; i < ab.size(); i++)
        {
            avgAmp += abs(ab.get(i));
            stroke(cgap * i, 255, 255);
            line(i, half, i,  half + ab.get(i) * half);

            circle(width / 2, half,  (avgAmp/1024) * 1000);
        }
        float average = avgAmp / (float)ab.size();
        
        float r = average * 200;
        lerpedR = lerp(lerpedR, r, 0.1f);
        
        
        circle(100, 200, lerpedR);

    

        // lerp(1, b, t); //linear interpolation 
        // map()

	}

    float lerpedR = 0; 

    // float lerp(float a, float b, float t)
    // {
    //     return a + (b - a) * t;
    // }
}
