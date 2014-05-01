package com.example.pra;

import com.example.pra.Main.OurView;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class Sprite implements  OnTouchListener{
 
	int x,xSpeed,y, ySpeed,height, width;
	Bitmap s;
	OurView ov;
	int currentFrame = 0;
	int direction= 0;
	float xpos, ypos ;
	boolean draw = true;
	int canvasW, canvasH;
	
 public Sprite(OurView ourView, Bitmap sherif) {
		
	s=sherif;
	ov= ourView;
	ov.setOnTouchListener(this);
	
	// divide because there's four rows and 2 columns
	height=s.getHeight() / 2;
	width=s.getWidth() /4;
	
	x=y=0;
	xSpeed=5;
	ySpeed=0;
	
	
	
	}
public void update(){
   /*
	//going down
	if(x > ov.getWidth()- width-xSpeed){
		xSpeed=0;
		ySpeed=5;
		direction=0;
	}
	
	//going left
	if(y > ov.getHeight()- height-ySpeed){
		xSpeed=-5;
		ySpeed=0;
		direction=1;
	}*/
	// going up screen
	
		
	
	
	if(x==ov.getWidth()/2){
		x=ov.getWidth()/2;
		xSpeed=0;
		ySpeed=0;
		direction=1;
	}
	
	
	//going right
	if(y+ySpeed<0){
		y=0;
		xSpeed=5;
		ySpeed=0;
		direction=2;
	}
	
	
	try {
		Thread.sleep(100);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		currentFrame= ++ currentFrame % 4;
		x+=xSpeed;
		y+=ySpeed;
	}
	
	public void onDraw(Canvas canvas) {
		
		update();
		canvasH=canvas.getHeight();
		canvasW=canvas.getHeight();
		y=canvas.getHeight()-canvas.getHeight()/6;
		
		int srcY=direction * height;
		int srcX=currentFrame* width;
	
		Rect src= new Rect(srcX,srcY, srcX + width,srcY + height);
		Rect dst= new Rect(x,y,x + width, y + height);
		if(draw){
		canvas.drawBitmap(s,src,dst,null);
		}
	}
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		
	
		switch(event.getAction()){
		case MotionEvent.ACTION_DOWN:
			
			xpos=event.getX();
			ypos=event.getY();
			
	//if(xpos==o()/2&&ypos==canvasH-canvasH/6){
		//	draw=false;
			//}
		break;
		}
		return false;
	
	}
	 
	
}
