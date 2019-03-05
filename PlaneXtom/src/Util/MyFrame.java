package Util;


import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



public class MyFrame extends Frame{

	private Image iBuffer;
	private Graphics gBuffer;
	
	public void launchFrame() {  //窗口位置以窗口左上角为准，在游戏里碰撞是以两个对象的矩形来决定的
		setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);			//没有重写父类，可以直接写而不用super
		setLocation (100,100);
		setVisible(true);
		
		new PaintThread().start();//启动重画线程
		addWindowListener/*窗口监听 */(new WindowAdapter() {/*//匿名内部类*/
			public void windowClosing (WindowEvent e) {
				System.exit(0);//结束虚拟机运行
			}
		});
	}
	class PaintThread extends Thread{
		public void run () {
			while(true) {
				repaint();
				try {
					Thread.sleep(40);//一秒画25次
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
		}
	}

	public void update(Graphics scr){//双缓冲
		if(iBuffer==null)
		{
			iBuffer=createImage(this.getSize().width,this.getSize().height);
			gBuffer=iBuffer.getGraphics();
		}
		gBuffer.setColor(getBackground());
		gBuffer.fillRect(0,0,this.getSize().width,this.getSize().height);
		paint(gBuffer);
       scr.drawImage(iBuffer,0,0,this);
	}	
}
