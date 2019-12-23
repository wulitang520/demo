package cn.tedu.shoot;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class World extends JPanel {

	// 宽和高的常量
	public static final int WIDTH = 400;
	public static final int HEIGHT = 700;

	Hero hero = new Hero();
	Sky sky = new Sky();
	FlyingObject[] enemy = {};
	Bullet[] bls = {};

	public void start() {
		//定义一个监听鼠标操作的匿名内部类对象
		MouseAdapter l=new MouseAdapter() {
			//鼠标移动时触发的方法
			public void mouseMoved(MouseEvent e) {
				//获得鼠标的x和y轴坐标位置
				int x=e.getX();
				int y=e.getY();
				hero.moveTo(x,y);
			}
		};
		//注册鼠标移动事件和鼠标滑动事件
		this.addMouseListener(l);
		this.addMouseMotionListener(l);
		// 编写计时器
		Timer timer = new Timer();
		// 定义间隔时间
		int interval = 30;
		// 编写计时器周期运行内容
		// 匿名内部类来实现
		TimerTask task = new TimerTask() {
			public void run() {
				// 由计时器周期调用的方法
				moveAction();
				enemyEnterAction();
				bulletEnterAction();
				//checkOutAction();
				// 重绘窗体,自动调用paint方法
				repaint();

			}
		};
		timer.schedule(task, interval, interval);

	}
	//检测敌机和子弹出界的方法
	public void checkOutAction() {
		//声明一个运算过程中需要的索引变量
		
		int index=0;
		//定义一个和源数组长度一致的新数组
		//这个新数组存放没有出界的敌机
		FlyingObject[] flive=new FlyingObject[enemy.length];
		//遍历敌机数组
		for(int i=0;i<enemy.length;i++) {
			//取出当前敌机
			FlyingObject f=enemy[i];
			//检查这架敌机是否没出界并且没移除
			if(!f.outOfBounds() && !f.isRemove()) {
				//将这架敌机放入新数组
				flive[index]=f;
				//为下一个敌机进入数组做准备
				index++;
				
			}
		}
		//将新数组按照存活的敌机输出缩容
		enemy=Arrays.copyOf(flive, index);
		//开始编写子弹越界的检查
		index=0;
		Bullet[] blive=new Bullet[bls.length];
		for(int i=0;i<bls.length;i++) {
			Bullet b=bls[i];
			if(!b.outOfBounds()&&!b.isRemove()) {
				blive[index]=b;
				index++;
			}
		}
		bls=Arrays.copyOf(blive, index);
		//System.out.println(bls.length);
	}

	int bulletIndex = 1;

	// 子弹进场的方法
	public void bulletEnterAction() {
		if (bulletIndex % 15 == 0) {
			// 英雄机开炮,接收子弹的数组
			Bullet[] bs = hero.shoot();
			// 对当前子弹数组扩容
			// 扩容长度是bs的长度
			bls = Arrays.copyOf(bls, bls.length + bs.length);
			// 将bs中的子弹赋值到bls中最后的位置,考虑bs长度为1或2的情况
			// 使用System.arraycopy();
			System.arraycopy(bs, 0, bls, bls.length - bs.length, bs.length);

		}
		bulletIndex++;
	}

	// 飞行物移动
	public void moveAction() {
		sky.step();// 天空动
		// 所有敌机动
		for (int i = 0; i < enemy.length; i++) {
			enemy[i].step();
		}
		// 所有子弹动
		for (int i = 0; i < bls.length; i++) {
			bls[i].step();
		}
	}

	int enemyIndex = 1;
 
	// 敌机进场的方法
	public void enemyEnterAction() {
		if (enemyIndex % 30 == 0) {
			// 生成一架敌机
			FlyingObject f = makeEnemy();
			// 把当前敌机数组扩容1
			enemy = Arrays.copyOf(enemy, enemy.length + 1);
			// 将生成的敌机放入扩容后数组的最后位置
			enemy[enemy.length - 1] = f;
		}
		enemyIndex++;
	}

	// 随机生成一架敌机的方法
	public FlyingObject makeEnemy() {
		FlyingObject fly = null;
		// 生成一个0~99的随机数
		Random ran = new Random();
		int num = ran.nextInt(100);
		if (num < 40) {
			fly = new Airplane();
		} else if (num < 80) {
			fly = new BigAirplane();
		} else {
			fly = new Bee();
		}
		return fly;
	}

	// 绘制窗体的最终方法
	// 方法名必须叫paint
	public void paint(Graphics g) {
		// 必须先画背景
		sky.paintObject(g);
		hero.paintObject(g);
		for (int i = 0; i < enemy.length; i++) {
			enemy[i].paintObject(g);
		}
		for (int i = 0; i < bls.length; i++) {
			bls[i].paintObject(g);
		}
	}

	public static void main(String[] args) {
		World w = new World();
		// 实例化一个窗口对象
		JFrame jf = new JFrame("飞机大战");
		// 将world类对象放入窗体管理
		jf.add(w);
		// 设置窗体的宽高
		jf.setSize(400, 700);
		// 点右上角的叉时，同时结束程序
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 设置出现位置居中
		jf.setLocationRelativeTo(null);
		// 显示窗体,同时调用paint方法
		jf.setVisible(true);
		w.start();

	}

}
