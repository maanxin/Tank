
/**
 * this is the first branch
 * Anxin Ma
 * 14,12,2016
 * 
 */

package com.tk_ma_v1;



import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyTankGame extends JFrame{
	MyPanel mp=null;

	public MyTankGame(){
		mp=new MyPanel();
		this.add(mp);
		this.addKeyListener(mp);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 400);
		this.setVisible(true);

		Thread thrd0=new Thread(mp);
		thrd0.run();
		
	}
	
	
	public static void main(String[] args) {
		MyTankGame mtk=new MyTankGame();
		// TODO Auto-generated method stub

	}

}


class MyPanel extends JPanel implements KeyListener, Runnable{
	
	Vector<TankAs> tankAs=new Vector<TankAs>();
	Vector<TankBs> tankBs=new Vector<TankBs>();
	int enSize=3;
	
	public MyPanel(){     //==>(x, y, color, direction); direction 0-W-up, 1-D-right, 2-S-down, 3-A-left 
		TankAs et1=new TankAs(100, 100, 0, 0);
		tankAs.add(et1);
		for (int i=0; i<enSize; i++){
			TankBs et2=new TankBs((i+1)*50, 0, 1, 2);
			tankBs.add(et2);
            Thread thrd2=new Thread(et2);
            thrd2.start();
		}
	}
	
	public void paint (Graphics g){
		super.paint(g);
		g.fillRect(0, 0, 500, 400);
		for (int i=0; i<tankAs.size(); i++){
			this.drawTank(tankAs.get(i).getX(), tankAs.get(i).getY(), g, tankAs.get(i).getdirection(), tankAs.get(i).getColor());
		}
		for (int i=0; i<tankBs.size(); i++){
			this.drawTank(tankBs.get(i).getX(), tankBs.get(i).getY(), g, tankBs.get(i).getdirection(), tankBs.get(i).getColor());
		}
	}
	
	public void drawTank(int x, int y, Graphics g, int direction, int color){
		switch(color){
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
			this.tankAs.get(0).updateUp(0);
		}else if(e.getKeyCode()==KeyEvent.VK_D){
			this.tankAs.get(0).updateRight(1);
		}else if(e.getKeyCode()==KeyEvent.VK_S){
			this.tankAs.get(0).updateDown(2);
		}else if(e.getKeyCode()==KeyEvent.VK_A){
			this.tankAs.get(0).updateLeft(3);
		}
		//this.repaint();
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		while(true){
			this.repaint();
		}
		
	}
	
}


