package cn.tedu.shoot;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
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
	//编写游戏四种状态对应的常量
	public static final int START=0;
	public static final int RUNNING=1;
	public static final int PAUSE=2;
	public static final int GAME_OVER=3;
	//游戏当前状态
	private int state=START;
	
	//定义三张图片
	private static BufferedImage startImg;
	private static BufferedImage pauseImg;
	private static BufferedImage overImg;
	static {
		//静态初始化块
		startImg=FlyingObject.readImage("start.png");
		pauseImg=FlyingObject.readImage("pause.png");
		overImg=FlyingObject.readImage("gameover.png");
				
	}
	//游戏得分属性
	private int score=0;

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
				checkOutAction();
				bulletHitAction();
				heroHitAction();
				// 重绘窗体,自动调用paint方法
				repaint();

			}
		};
		timer.schedule(task, interval, interval);

	}
	//检测英雄机和敌机碰撞的方法
	public void heroHitAction() {
		//遍历所有敌机
		for(int i=0;i<enemy.length;i++) {
			//提取当前敌机
			FlyingObject f=enemy[i];
			//判断是否相撞
			if(f.isLife() && hero.hit(f)) {
				//减命
				hero.subLife();
				//清空火力值
				hero.clearDoubleFire();
				//敌机敌死
				f.goDead();
			}
		}
		
	}
	//检测子弹和敌机碰撞的方法
	public void bulletHitAction() {
		//循环遍历子弹数组
		for(int i=0;i<bls.length;i++) {
			Bullet b=bls[i];//取出当前子弹元素
			//遍历敌机数组
			for(int j=0;j<enemy.length;j++) {
				//取出当前敌机
				FlyingObject f=enemy[j];
				//判断子弹和敌机是否碰撞
				if(b.isLife() && f.isLife() && b.hit(f)) {
					b.goDead();//子弹死
					f.goDead();//敌机死
					if(f instanceof Score) {
						Score s=(Score)f;
						//击中敌机后增加分数
						score+=s.getScore();
					}
					if(f instanceof Award) {
						Award a=(Award)f;
						//获得奖励
						int num=a.getAward();
						switch(num) {
						case Award.DOUBLE_FIRE://奖励火力值
							hero.addDoubleFire();
							break;
						case Award.LIFE://奖励生命值
							hero.addLife();
							break;
						}
					}
				}
			}
		}
		
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
		if (bulletIndex % 3 == 0) {
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
		//将分和命显示在窗口上
		g.drawString("SCORE:"+score,10,25);
		g.drawString("LIFE:"+hero.getLife(),10,45);
		g.drawString("FIRE:"+hero.getDoubleFire(),10,65);
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
