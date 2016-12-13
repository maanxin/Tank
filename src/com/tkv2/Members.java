package com.tkv2;

class Tank{
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
	
	public Tank(int x, int y){
		this.x=x;
		this.y=y;
	}
}


//My tank
class Hero extends Tank{
	public Hero(int x, int y){
		super(x,y);
	}
	public void moveUp(){
		y-=speed;
	}
	public void moveDown(){
		y+=speed;
	}
	public void moveLeft(){
		x-=speed;
	}
	public void moveRight(){
		x+=speed;
	}
}


//Enemy's  tank
class Enemy extends Tank{
	public Enemy(int x, int y){
		super(x,y);
	}
	public void moveUp(){
		y-=speed;
	}
	public void moveDown(){
		y+=speed;
	}
	public void moveLeft(){
		x-=speed;
	}
	public void moveRight(){
		x+=speed;
	}
}
