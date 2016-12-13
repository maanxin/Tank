package com.tk_ma_v1;

import java.util.Random;

class TankFather{
	int x=0;
	int y=0;
	int direction;
	int speed=5;
	int color;
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	public int getspeed() {
		return speed;
	}
	public void setspeed(int speed) {
		this.speed = speed;
	}
	public int getdirection() {
		return direction;
	}
	public void setdirection(int direction) {
		this.direction = direction;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public TankFather(int x, int y, int color, int direction){
		this.x=x;
		this.y=y;
		this.color=color;
		this.direction=direction;
	}
	
}



//Tanks's tank
class TankAs extends TankFather{
	public TankAs(int x, int y, int color, int direction){
		super(x,y,color,direction);
	}
	public void updateUp(int direct){
		y-=speed;
		direction=direct;
	}
	public void updateDown(int direct){
		y+=speed;
		direction=direct;
	}
	public void updateLeft(int direct){
		x-=speed;
		direction=direct;
	}
	public void updateRight(int direct){
		x+=speed;
		direction=direct;
	}
}
//Tanks's tank
class TankBs extends TankFather implements Runnable{
	public TankBs(int x, int y, int color, int direction){
		super(x,y,color,direction);
	}
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Random nrdm=new Random();
//			direction = (nrdm.nextInt(100)+1)/25; // random number from 0 t0 3
			direction = (int)(Math.random()*4); // random number from 0 t0 3

			
			System.out.println("direction is "+direction);

            switch(direction){
            case 0:
            	y-=speed;
            	if(y<0){y=0;}
            case 1:
            	x+=speed;
            	if(x>400){y=400;}
            case 2:
            	y+=speed;
            	if(y>300){y=300;}
            case 3:
            	x-=speed;
            	if(x<0){x=0;}
            }
            
		}
	}
	

}
