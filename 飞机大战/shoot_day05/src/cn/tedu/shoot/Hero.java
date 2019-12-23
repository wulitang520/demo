package cn.tedu.shoot;

import java.awt.image.BufferedImage;

public class Hero extends FlyingObject{
	
	private static BufferedImage[] images;
	static {
		images=new BufferedImage[2];
		images[0]=readImage("hero0.png");
		images[1]=readImage("hero1.png");
	}
	

	private int life;//����ֵ
	private int doubleFire;//����ֵ
	
	public Hero() {
		//152��(400/2-97/2)������
		//410����Ϸ���濿�µ�λ�ù���
		super(97,139,152,410);
		life=3;
		//doubleFireĬ��Ϊ0
	}
	
	
	public void show() {
		System.out.println("��:"+width+",��:"+height);
		System.out.println("x:"+x+",y"+y);
		System.out.println("����ֵ:"+life);
		System.out.println("����ֵ:"+doubleFire);
	}
	
	int index=0;
	//Ӣ�ۻ�����ͼƬ�л���Ч��
	public BufferedImage getImage() {
		return images[index++%images.length];
	}
	
	
	
	
	
	
	

}
