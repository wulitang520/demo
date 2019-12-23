package cn.tedu.shoot;//子弹

import java.awt.image.BufferedImage;

public class Bullet extends FlyingObject{
	private static BufferedImage image;
	static {
		image=readImage("bullet.png");
	}

	private int step;
	public Bullet(int x,int y) {
		super(8,20,x,y);
		step=10;
	}

	public void show() {
		System.out.println("宽:"+width+",高:"+height);
		System.out.println("x:"+x+",y:"+y);
		System.out.println("速度"+step);
	}
	
	public BufferedImage getImage() {
		BufferedImage img=null;
		//如果子弹活着返回图片
		if(isLife()) {
			img=image;
		}else if(isDead()) {
			//如果死了直接移除
			state=REMOVE;
		}
		return img;
	}
	
	public void step() {
		y-=step;
		
	}
	//子弹出界的方法不同
	//所以重写父类中的出界方法
	public boolean outOfBounds() {
		//子弹的y轴小于了负的自身的高度
		return y<-height;
	}
	
	
	
	
	
	
	

}
