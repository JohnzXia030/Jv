package fr.xjz.plane;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import Util.Constant;

public class Bullet extends GameObject {
	
	double speed = 6;
	double degree;
	
	public Bullet() {
		degree = Math.random()*Math.PI*2;
		x = Constant.GAME_WIDTH/2;
		y = Constant.GAME_HEIGHT/2;
		width = 5;
		height = 5;
	}
	public Rectangle getRect() {
		return new Rectangle(x,y,width,height);
		
	}
	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.YELLOW);
		g.fillOval((int)x, (int)y, width, height);
		x += speed * Math.cos(degree);
		
		y += speed * Math.sin(degree);
		if (y>=Constant.GAME_HEIGHT-height||y<0) {
			degree = -degree;
			
			
		}
		
		if (x<=0||x>=Constant.GAME_WIDTH-width) {
			degree = Math.PI-degree;
			
		}
		
		g.setColor(c);
	}
}
