package fr.xjz.plane;

import java.awt.Graphics;
import java.awt.Image;

import Util.GameUtil;

public class Explode {
	double x,y;
	static Image[] imgs = new Image[3];
	int count;
	//静态代码块处理初始化
	static {
		for (int i = 0; i <2;i++) {
			imgs[i] = GameUtil.getImage("photo\\"+(i+1)+".png");
			imgs[i].getWidth(null);
		}
	}
	public void draw(Graphics g) {
		if(count<3) {
		g.drawImage(imgs[count],(int)x,(int)y,30,30,null);
		count++;
		}
	}
	public Explode(double x, double y) {
		
		this.x = x;
		this.y = y;
	}
	
}
