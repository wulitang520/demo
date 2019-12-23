package cn.tedu.shoot;

import java.awt.image.BufferedImage;

public class Hero extends FlyingObject{
	
	private static BufferedImage[] images;
	static {
		images=new BufferedImage[2];
		images[0]=readImage("hero0.png");
		images[1]=readImage("hero1.png");
	}
	

	private int life;//生命值
	private int doubleFire;//火力值
	
	public Hero() {
		//152是(400/2-97/2)得来的
		//410是游戏界面靠下的位置估算
		super(97,139,152,410);
		life=3;
		//doubleFire默认为0
	}
	
	
	public void show() {
		System.out.println("宽:"+width+",高:"+height);
		System.out.println("x:"+x+",y"+y);
		System.out.println("生命值:"+life);
		System.out.println("火力值:"+doubleFire);
	}
	
	int index=0;
	//英雄机两张图片切换的效果
	public BufferedImage getImage() {
		return images[index++%images.length];
	}
	
	public void step() {
		//因为英雄机跟着鼠标走
		//所以都什么不用写
	}
	//英雄机开炮方法
	public Bullet[] shoot() {
		Bullet[] bs=null;
		
		//声明一个变量接收英雄的1/4机宽
		//方便今后的计算
		int w=this.width/4-2;//-2是修正子弹的宽度
		int h=20;//保存的是子弹的高
		//如果没有火力值
		if(doubleFire<=0) {
			//单管炮
			bs=new Bullet[1];
			bs[0]=new Bullet(x+2*w,y-h);
		
        }else {
			//双管炮
			bs=new Bullet[2];
			bs[0]=new Bullet(x+w,y-h);
			bs[1]=new Bullet(x+3*w,y-h);
			doubleFire--;//双管炮减双管炮
		}
		return bs;
	}
	//英雄机移动的方法
	public void moveTo(int x,int y) {
		//因为鼠标的坐标在英雄机的中心
		//所以英雄机的x和y要向左上移动
		//分别是宽和高的一半
		this.x=x-this.width/2;
		this.y=y-this.height/2;
		
	}
	
	
	

}
