package fr.xjz.plane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import Util.GameUtil;

public class Plane extends GameObject {

	
	
	int speed = 10 ;
	private boolean left,up,right,down;
	private boolean alive = true;
	
	public Rectangle getRect() {
		return new Rectangle(x,y,width,height);
		
	}
	public boolean outofRange() {
		if(x>=0&x<=470&y>=0&y<=470) {
			return false;
		}else {
		return true;
		}
	}
	public void draw (Graphics g) {
		if(alive) {
		g.drawImage(img, x, y, width, height, null)	;
		move();
		}
		
	}
	public boolean isAlive() {
		return alive;
	}
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	public void move() {
		
		if (left) {x -= speed;}
		if (up)  {y -= speed;}
		if(right) {x += speed;}
		if (down) {y += speed;}
		
	}
	public void directionChange(KeyEvent e) {
		
		switch (e.getKeyCode()) {
		case 37:
			left = true;
			break;
		case 38:
			up = true;
			break;
		case 39:
			right = true;
			break;	
		case 40:
			down = true;
			break;
		default:
			break;
		}
		
	}
	public void stopMouvement(KeyEvent e) {
		switch (e.getKeyCode()) {
		case 37:
			left = false;
			break;
		case 38:
			up = false;
			break;
		case 39:
			right = false;
			break;	
		case 40:
			down = false;
			break;
		default:
			break;
		}
	}
	
	public Plane(Image img, int x, int y, int width, int height) {
		super();
		this.img = img;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	public Plane(String imgpath, int x, int y, int width, int height) {
		this(GameUtil.getImage(imgpath),x, y, width, height);
		
	}
	public Plane() {
		
	}
}
