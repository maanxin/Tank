package com.tkv1;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyTank1 extends JFrame{
	MyPanel mp=null;

	public MyTank1(){
		mp=new MyPanel();
		this.add(mp);
		this.setSize(400, 300);
		this.setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		MyTank1 mtk=new MyTank1();
		// TODO Auto-generated method stub

	}

}


class MyPanel extends JPanel{
	Hero hero=null;
	
	public MyPanel(){
		hero=new Hero(100, 100);
	}
	
	public void paint (Graphics g){
		super.paint(g);
		//g.setColor(Color.black);
		g.fillRect(0, 0, 400, 300);
		this.drawTank(hero.getX(), hero.getY(), g, 1, 0);
		
	}
	
	public void drawTank(int x, int y, Graphics g, int drct, int typ){
		switch(typ){
		case 0:
			g.setColor(Color.CYAN);
			break;
		case 1:
			g.setColor(Color.yellow);
			break;
		}
		
		switch(drct){
		case 0:
			g.fill3DRect(x, y, 5, 30,false);
			g.fill3DRect(x+15, y, 5, 30,false);
			g.fill3DRect(x+5, y+5, 10, 20,false);
			g.fillOval(x+5, y+10, 10, 10);
			g.drawLine(x+10, y+15, x+10, y);
			break;
		case 1:
			g.fill3DRect(x, y, 5, 30,false);
			g.fill3DRect(x+15, y, 5, 30,false);
			g.fill3DRect(x+5, y+5, 10, 20,false);
			g.fillOval(x+5, y+10, 10, 10);
			g.drawLine(x+10, y+15, x+10, y+30);
			break;

		}
		
	}
	
}


class Tank{
	int x=0;
	int y=0;
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


class Hero extends Tank{
	public Hero(int x, int y){
		super(x,y);
	}
}