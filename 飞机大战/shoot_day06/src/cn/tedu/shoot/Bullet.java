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
		step=2;
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
	
	
	
	
	
	
	
	
	

}
