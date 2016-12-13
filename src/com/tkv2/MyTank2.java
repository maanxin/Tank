package com.tkv2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyTank2 extends JFrame{
	MyPanel mp=null;

	public MyTank2(){
		mp=new MyPanel();
		this.add(mp);
		this.addKeyListener(mp);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 300);
		this.setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		MyTank2 mtk=new MyTank2();
		// TODO Auto-generated method stub

	}

}


class MyPanel extends JPanel implements KeyListener{
	Hero hero=null;
	
	Vector<Enemy> ets=new Vector<Enemy>();
	int enSize=3;
	
	public MyPanel(){
		hero=new Hero(100, 100);
		for (int i=0; i<enSize; i++){
			Enemy et=new Enemy((i+1)*50,0);
			et.setColor(0);
			et.setdirection(2);
			ets.add(et);
		}
	}
	
	public void paint (Graphics g){
		super.paint(g);
		//g.setColor(Color.black);
		g.fillRect(0, 0, 400, 300);
		this.drawTank(hero.getX(), hero.getY(), g, hero.getdirection(), 0);
		for (int i=0; i<ets.size(); i++){
			this.drawTank(ets.get(i).getX(), ets.get(i).getY(), g, ets.get(i).getdirection(), 1);
		 	
		}
		
	}
	
	public void drawTank(int x, int y, Graphics g, int direction, int type){
		switch(type){
		case 0:
			g.setColor(Color.CYAN);
			break;
		case 1:
			g.setColor(Color.yellow);
			break;
		}
		
		switch(direction){
		case 0:
			g.fill3DRect(x,    y,    5,    30, false);
			g.fill3DRect(x+15, y,    5,    30, false);
			g.fill3DRect(x+5,  y+5,  10,   20, false);
			g.fillOval  (x+5,  y+10, 10,   10       );
			g.drawLine  (x+10, y+10, x+10, y        );
			break;
		case 1:
			g.fill3DRect(x,    y,    30,    5,  false);
			g.fill3DRect(x,    y+15, 30,    5,  false);
			g.fill3DRect(x+5,  y+5,  20,   10,  false);
			g.fillOval  (x+10, y+5,  10,   10        );
			g.drawLine  (x+10, y+10,  x+30, y+10      );
			break;
		case 2:
			g.fill3DRect(x,    y,    5,    30, false);
			g.fill3DRect(x+15, y,    5,    30, false);
			g.fill3DRect(x+5,  y+5,  10,   20, false);
			g.fillOval  (x+5,  y+10, 10,   10       );
			g.drawLine  (x+10, y+10, x+10, y+30     );
			break;
		case 3:
			g.fill3DRect(x,    y,    30,    5,  false);
			g.fill3DRect(x,    y+15, 30,    5,  false);
			g.fill3DRect(x+5,  y+5,  20,   10,  false);
			g.fillOval  (x+10, y+5,  10,   10        );
			g.drawLine  (x+10, y+10, x-5, y+10      );
			break;

		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_W){
			this.hero.setdirection(0);
			this.hero.moveUp();
		}else if(e.getKeyCode()==KeyEvent.VK_D){
			this.hero.setdirection(1);
			this.hero.moveRight();
		}else if(e.getKeyCode()==KeyEvent.VK_S){
			this.hero.setdirection(2);
			this.hero.moveDown();
		}else if(e.getKeyCode()==KeyEvent.VK_A){
			this.hero.setdirection(3);
			this.hero.moveLeft();
		}
		this.repaint();
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}


