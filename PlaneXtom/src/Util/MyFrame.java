package Util;


import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



public class MyFrame extends Frame{

	private Image iBuffer;
	private Graphics gBuffer;
	
	public void launchFrame() {  //����λ���Դ������Ͻ�Ϊ׼������Ϸ����ײ������������ľ�����������
		setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);			//û����д���࣬����ֱ��д������super
		setLocation (100,100);
		setVisible(true);
		
		new PaintThread().start();//�����ػ��߳�
		addWindowListener/*���ڼ��� */(new WindowAdapter() {/*//�����ڲ���*/
			public void windowClosing (WindowEvent e) {
				System.exit(0);//�������������
			}
		});
	}
	class PaintThread extends Thread{
		public void run () {
			while(true) {
				repaint();
				try {
					Thread.sleep(40);//һ�뻭25��
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
		}
	}

	public void update(Graphics scr){//˫����
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
