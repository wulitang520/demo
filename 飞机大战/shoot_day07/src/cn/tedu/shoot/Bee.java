package cn.tedu.shoot;

import java.awt.image.BufferedImage;
import java.util.Random;

public class Bee extends FlyingObject implements Award{
	
	private static BufferedImage[] images;
	static {
		images=new BufferedImage[5];
		images[0]=readImage("bee0.png");
		for(int i=1;i<images.length;i++) {
			images[i]=readImage("bom"+i+".png");
		}
	}

	private int xStep;
	private int yStep;
	
	public Bee() {
		super(60,51);
		xStep=2;
		yStep=2;
		
	}

	public void show() {
		System.out.println("��:"+width+",��:"+height);
		System.out.println("x:"+x+",y:"+y);
		System.out.println("�ٶ�"+xStep+",�ٶ�"+yStep);
	}
	int index=1;
	public BufferedImage getImage() {
		BufferedImage img=null;
		if(isLife()){
			img=images[0];
		}else if(isDead()) {
			img=images[index];
			index++;
			if(index>=images.length) {
				state=REMOVE;
			}
		}
		
		return img;
	}
	//��д����ĳ��󷽷�
	public void step() {
		y+=yStep;
		x+=xStep;
	//����������������Ҳ�߽�
		if(x<=0 || x>=World.WIDTH-width) {
			//�ı佱�����ƶ��ķ���
			xStep*=-1;
		}
	}

	public int getAward() {
		Random ran=new Random();
		//�����������0��1
		int num=ran.nextInt(2);
		return num;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
