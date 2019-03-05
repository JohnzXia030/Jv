package fr.xjz.solar;

import java.awt.Graphics;
import java.awt.Image;

import Util.Constant;
import Util.GameUtil;

public class FixedStar {
	Image img;
	double x,y;
	double width,length;
	//double longAlix,ShortAlix;
	//double degree ;
	public void draw(Graphics g) {
		int x = (int)this.x;
		x -= (int)width/2;
		int y = (int)this.y;
		y -= (int)length/2;
		g.drawImage(img,(int)x,(int)y,(int)width,(int)length,null);
	}
	public FixedStar() {}
	
	public FixedStar(Image img,double x,double y,double width,double length) {
		this.img = img;
		this.x=x;
		this.y=y;
		this.width=width;
		this.length=length;
	}
	public FixedStar(String imgpath,double x,double y,double width,double length) {
		this(GameUtil.getImage(imgpath), x, y, width, length);//调用上一个构造器
		/*this.img = GameUtil.getImage(imgpath);
		this.x=x;
		this.y=y;
		this.width=width;
		this.length=length;*/
	}
	/*public FixedStar(String imgpath, double x, double y, double width, double length, double longAlix, double shortAlix) {

		this.img = GameUtil.getImage(imgpath);
		this.x = x;
		this.y = y;
		this.width = width;
		this.length = length;
		this.longAlix = longAlix;
		this.ShortAlix = shortAlix;
	}
	
	public void drawplanet(Graphics g) {
		g.drawImage(img,(int)x,(int)y,(int)width,(int)length,null);
		x = Constant.GAME_WIDTH/2 + 1.5*longAlix*Math.cos(degree);
		y = Constant.GAME_HEIGHT/2 + ShortAlix*Math.sin(degree);
		degree += 0.1;
		
	}*/
}
