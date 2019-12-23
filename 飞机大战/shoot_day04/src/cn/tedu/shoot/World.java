package cn.tedu.shoot;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class World extends JPanel{
	
	Hero hero=new Hero();
	Sky sky=new Sky();
	FlyingObject[] enemy=new FlyingObject[6];
	Bullet[] bt=new Bullet[3];                  
	
	public void start() {

		
	}
	
	
	

	public static void main(String[] args) {
		World w=new World();
		//实例化一个窗口对象
		JFrame jf=new JFrame("飞机大战");
		//将world类对象放入窗体管理
		jf.add(w);
		//设置窗体的宽高
		jf.setSize(400,700);
		//点右上角的叉时，同时结束程序
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置出现位置居中
	    jf.setLocationRelativeTo(null);
	    //显示窗体
	    jf.setVisible(true);
		w.start();
		
	}

}
