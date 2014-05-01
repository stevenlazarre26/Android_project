package com.example.pra;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.View.OnTouchListener;

public class Main extends Activity implements OnTouchListener {
 private List<Sprite> sprites = new ArrayList<Sprite>();
	OurView v;
	Bitmap sherif, saloon;
	float x,y;
	Sprite sprite;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		v=new OurView(this);
		v.setOnTouchListener(this);
		sherif= BitmapFactory.decodeResource(getResources(), R.drawable.sherifs);
		saloon= BitmapFactory.decodeResource(getResources(), R.drawable.saloon);
		
		x=y=0;
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.setContentView(v);
		
	
	}

	public class OurView extends SurfaceView implements Runnable{
		
		
		Thread t=null;
		boolean isItOk= false;
		SurfaceHolder holder;
		boolean spriteLoaded= false;
		
		public OurView(Context context) {
			super(context);
			holder=getHolder();
		
			holder.addCallback(new SurfaceHolder.Callback() {
				 
                @Override
                public void surfaceDestroyed(SurfaceHolder holder) {
                }

                @SuppressLint("WrongCall")
				@Override
                public void surfaceCreated(SurfaceHolder holder) {
                       Canvas c = holder.lockCanvas(null);
                       onDraw(c);
                       holder.unlockCanvasAndPost(c);
                }

                @Override
                public void surfaceChanged(SurfaceHolder holder, int format,int width, int height) {
                }
         });
		
		
		}

		@SuppressLint("WrongCall")
		@Override
		public void run() {
			sprite= new Sprite(this,sherif);
			while (isItOk){
				
				if(!holder.getSurface().isValid()){
					continue;
				}
				Canvas c=holder.lockCanvas();
			
				onDraw(c);
				holder.unlockCanvasAndPost(c);
			}

			
	}
		@SuppressLint("WrongCall")
		public void onDraw (Canvas canvas){
			canvas.drawColor(Color.WHITE);
		sprite.onDraw(canvas);
			float cx = (canvas.getWidth()   - saloon.getWidth()) /2;
			float	cy = (canvas.getHeight() - saloon.getHeight()) /2;
			canvas.drawBitmap(saloon, cx, cy, null);
		}
		
	public void pause(){
		isItOk=false;
		while (true){
			try{
				t.join();
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
			break;
			}
		t=null;
	}
	
	public void resume(){
		isItOk=true;
		t= new Thread(this);
		t.start();
	}
		
}

  @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}



@Override
protected void onPause() {
	// TODO Auto-generated method stub
	super.onPause();
	v.pause();
}

@Override
protected void onResume() {
	// TODO Auto-generated method stub
	super.onResume();
	v.resume();
}



@Override
public boolean onTouch(View v, MotionEvent me) {

	try {
		Thread.sleep(50);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	switch(me.getAction()){
	case MotionEvent.ACTION_DOWN:
		
		x = me.getX();
		y = me.getY();
		
		break;
		
	case MotionEvent.ACTION_UP:
		
		x = me.getX();
		y = me.getY();
		break;
		
		
	case MotionEvent.ACTION_MOVE:
		
		x = me.getX();
		y = me.getY();
		break;
	}
	 
	return true;
}



}
