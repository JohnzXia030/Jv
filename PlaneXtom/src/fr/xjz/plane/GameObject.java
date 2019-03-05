package fr.xjz.plane;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class GameObject {
	Image img;
	int x,y;
	int width,height;
	int speed ;
	public GameObject() {}
	public GameObject(Image img, int x, int y, int width, int height, int speed) {
		
		this.img = img;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = speed;
	}

	public Rectangle getRect() {
		return new Rectangle(x,y,width,height);
		
	}
}
