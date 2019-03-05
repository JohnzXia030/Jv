package fr.xjz.solar;

import java.awt.Graphics;
import java.awt.Image;

import Util.Constant;
import Util.GameUtil;
import Util.MyFrame;

public class SolarFrame extends MyFrame{
	 Image bg = GameUtil.getImage("photo\\images.jpg");
	 FixedStar sun = new FixedStar("photo\\sun.png",Constant.GAME_WIDTH/2,Constant.GAME_HEIGHT/2,100,100);
	 //FixedStar shuixing = new FixedStar("photo\\shuixing.png",Constant.GAME_WIDTH/2+65,Constant.GAME_HEIGHT/2-15,30,30,80,60);
	 Planet shuixing = new Planet(sun,20,20, "photo\\shuixing.png", 100, 50, 1);
	 Planet jinxing = new Planet(sun,20,20,"photo\\jinxing.png",130,80,0.8);
	 Planet earth = new Planet(sun,25,25,"photo\\earth.png",200,120,0.7);
	 Planet mars = new Planet(sun,20,20,"photo\\Mars.png",240,150,0.6);
	 Planet muxing = new Planet(sun,50,50,"photo\\muxing.png",350,250,0.45);
	 Planet tuxing = new Planet(sun,50,50,"photo\\tuxing.png",400,300,0.3);
	 Planet t = new Planet(sun,20,20,"photo\\tianwangxing.png",430,340,0.2);
	 Planet h = new Planet(sun,20,20,"photo\\earth.png",550,400,0.1);
	//Planet moon = new Planet(earth,10,10,"photo\\moon.png",20,20,1.5);
	 
	 public void paint(Graphics g) {
		 g.drawImage(bg, 0,0,Constant.GAME_WIDTH,Constant.GAME_HEIGHT,null);
		 sun.draw(g);
		 shuixing.draw(g);
		 jinxing.draw(g);
		 earth.draw(g);
		 mars.draw(g);
		// moon.draw(g);
		 muxing.draw(g);
		 tuxing.draw(g);
		 t.draw(g);
		 h.draw(g);
	 }
	 public static void main(String[] args) {
		new SolarFrame().launchFrame(); 
	}
}
