package cn.tedu.shoot;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class World extends JPanel{
	
	//宽和高的常量
	public static final int WIDTH=400;
	public static final int HEIGHT=700;
	
	Hero hero=new Hero();
	Sky sky=new Sky();
	FlyingObject[] enemy= {
			new Airplane(),
			new BigAirplane(),
			new Bee()
	};
	Bullet[] bls= {
			new Bullet(200,300),
			new Bullet(200,360)
	};                 
	
	public void start() {

		
	}
	//绘制窗体的最终方法
	//方法名必须叫paint
	public void paint(Graphics g) {
		//必须先画背景
		sky.paintObject(g);
		hero.paintObject(g);
		for(int i=0;i<enemy.length;i++) {
			enemy[i].paintObject(g);
		}
		for(int i=0;i<bls.length;i++) {
			bls[i].paintObject(g);
		}
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
