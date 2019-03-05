package fr.xjz.solar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import Util.Constant;
import Util.GameUtil;
/**
 * 除了图片，坐标。行星还要延椭圆轨迹飞行：长轴短轴速度：绕着某个恒星飞。
 * @author 51924
 *
 */
public class Planet extends FixedStar {
	double longAlix,ShortAlix;
	double degree ;
	double speed;
	FixedStar center;
	public void draw(Graphics g){
		//super.draw(g);
		x = center.x  - this.width/2 + longAlix*Math.cos(degree);
		y = center.y  - this.length/2 + ShortAlix*Math.sin(degree);
		g.drawImage(img,(int)x,(int)y,(int)width,(int)length,null);
		
		degree += 0.1*speed;
		this.trace(g);
	}
	public void trace(Graphics g) {
		Color c= g.getColor();
		g.setColor(Color.blue);
		g.drawOval((int)center.x -(int)longAlix,(int)center.y - (int)ShortAlix, (int)longAlix*2,(int) ShortAlix*2);
		g.setColor(c);
		
	}

	public Planet(FixedStar center,double width,double length,String imgpath,double longAlix, double shortAlix,
			 double speed ) {
		super(GameUtil.getImage(imgpath), shortAlix, speed, width, length);
		this.longAlix = longAlix;
		ShortAlix = shortAlix;
		this.width=width;
		this.length=length;
		
		this.speed = speed;
		this.center = center;
		this.x = center.x + longAlix;
		this.y = center.y;
		
	}

	/*public Planet(Image img,double x,double y,double width,double length) {
		
		super(img,x,y,width,length);
		
	}
	public Planet(String imgpath,double x,double y,double width,double length) {
		
		super(imgpath,x,y,width,length);
		
	}*/
}
