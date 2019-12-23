package cn.tedu.shoot;//�ӵ�

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
		System.out.println("��:"+width+",��:"+height);
		System.out.println("x:"+x+",y:"+y);
		System.out.println("�ٶ�"+step);
	}
	
	public BufferedImage getImage() {
		BufferedImage img=null;
		//����ӵ����ŷ���ͼƬ
		if(isLife()) {
			img=image;
		}else if(isDead()) {
			//�������ֱ���Ƴ�
			state=REMOVE;
		}
		return img;
	}
	
	public void step() {
		y-=step;
		
	}
	
	
	
	
	
	
	
	
	

}
