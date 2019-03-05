package fr.xjz.plane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;

import Util.GameUtil;
import Util.MyFrame;

public class PlaneGameFrame extends MyFrame {
	Image bg = GameUtil.getImage("photo\\images.jpg");
	Plane p = new Plane("photo\\plane.png",250,440,30,30);
	Explode boom ;
	Date start;
	Date end;
	ArrayList bulletlist = new ArrayList();//������ʱû���Ͳ�����
	public void paint(Graphics g) {
		g.drawImage(bg, 0, 0, 500,500,null);
		p.draw(g);
		
		for(int i=0;i<bulletlist.size();i++) {
			Bullet b = (Bullet)bulletlist.get(i);
			b.draw(g);
			
			//�����ɻ�����ײ
			if(b.getRect().intersects(p.getRect())|p.outofRange()) {
				System.out.println("gameover");
				p.setAlive(false);
				if(end ==null) {
				end = new Date();
				}
				if(boom==null) {
				Explode boom = new Explode(p.x,p.y);
				boom.draw(g);
				}
				
			} 
			if(!p.isAlive()){
				this.printInfo(g,"YOU HAVE BEEN SLAIN",60,250,40);
				int periode = (int)(end.getTime() - start.getTime())/100;
				printInfo(g, "������"+ periode+"", 60, 280, 20);
				if(periode<50) {
					printInfo(g, "����", 60, 310, 20);
				}else if(periode<100) {
					printInfo(g, "�ճ�", 60, 310, 20);
				}else if(periode<150) {
					printInfo(g, "����Ա", 60, 310, 20);
				}else if(periode<300) {
					printInfo(g, "����", 60, 310, 20);
				}else  {
				printInfo(g, "�Ա", 60, 310, 20);
				}
				
				
			}
			
			//printGameOver(g, "points:",30, 50, 15);
			
			
		}
	}
	public void printInfo(Graphics g,String str,int x ,int y,int size) {
	
		Font f = new Font("����", Font.ITALIC, size);
		
		g.setFont(f);
		g.drawString(str,x, y);
			
	}
	public void launchFrame() {
		//���Ӽ��̵ļ���
		super.launchFrame();
		addKeyListener(new keyMonitor());
		//bullet production
		for (int i = 0; i<50;i++) {
			Bullet b = new Bullet();
			bulletlist.add(b);
			
		}
		start = new Date(); 
	}
	public static void main(String[] args) {
		new PlaneGameFrame().launchFrame();
	}
	//����Ϊ�ڲ��࣬��������ⲿ�����ͨ����
	class keyMonitor extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			//System.out.println("press��"+e.getKeyCode());
			p.directionChange(e);
		}
			
			
		

		@Override
		public void keyReleased(KeyEvent e) {
			//System.out.println("release��"+e.getKeyCode());
			p.stopMouvement(e);
		}
	}
		
		
	
}
