package ie.tudublin;

import processing.core.PApplet;
import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.Minim;
import ddf.minim.AudioPlayer;

public class Audio2 extends PApplet 
{

    Minim m;
    AudioInput ai;
    AudioPlayer ap;
    AudioBuffer ab;


    public void settings()
    {
        size(1024, 1024, P3D);
    }

    public void setup()
    {
        m = new Minim(this);
        ai = m.getLineIn(Minim.MONO, width, 44100, 16);
        ab = ai.mix; 
        lerpedBuffer = new float[width];
    }

    float[] lerpedBuffer;

    public void draw()
    {
        background(0);
        colorMode(HSB);
        stroke(255);
        float half = height / 2;
        for(int i = 0; i < ab.size(); i++ )
        {
            stroke(map(i,0,ab.size(), 0,255),255,255);
            lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.1f); // 2.0f for more delay latency 
            float f = abs(lerpedBuffer[i] * half);
            line(i, half + f, i, half - f);
        }

        // println(map(5,0,10,1000,2000));
        // println(map1(5,2,10,1000,2000));

    }

    float map1(float a, float b, float c, float d, float e)
    {
        float range1 = c - b; //finding the lower range
        float range2 = e - d; //finding the upper range
        float howFar = a - b; //finding the value you want to convert


        return d + (howFar / range1) * range2;

    }

}

