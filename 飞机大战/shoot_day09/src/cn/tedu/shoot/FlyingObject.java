package cn.tedu.shoot;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;

public abstract class FlyingObject {
	//ÿ��������������״̬
	//���ţ����˺��Ƴ�
	public static final int LIFE=0;//����
	public static final int DEAD=1;//����
	public static final int REMOVE=2;//�Ƴ�
	//���浱ǰ�����������
	protected int state=LIFE;//��ʼ״̬����
	
	//�������๲�õ�����
	protected int width;
	protected int height;
	protected int x;
	protected int y;
	//С�л�����л����������Ĺ���
	public FlyingObject(int width, int height) {
		Random ran=new Random();
		this.width = width;
		this.height = height;
		x=ran.nextInt(400-width);
		y=-height;
	}
	//sky ,hero,bullet
	public FlyingObject(int width, int height, int x, int y) {
		super();
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
	}
	
	public void show() {
		System.out.println("��:"+width+",��:"+height);
		System.out.println("x:"+x+",y:"+y);
	}
	;
	//����������ڶ�ȡͼƬ��java����
	public static BufferedImage readImage(String fileName) {
		try {
			//��ȡӲ���ϵ�ͼƬ��img����
			BufferedImage img=ImageIO.read(FlyingObject.class.getResource(fileName));
		    return img;
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	//�жϷ������Ƿ����
	public boolean isLife() {
		return state==LIFE;
	}//�жϷ������Ƿ�����
	public boolean isDead() {
		return state==DEAD;
	}
	//�жϷ������Ƿ��Ƴ�
	public boolean isRemove() {
		return state==REMOVE;
	}
	
	//��д���󷽷�
	//���ͼƬ(�������л��)
	public abstract BufferedImage getImage();
	
	//���ƻ�õ�ͼƬ
	public void paintObject(Graphics g) {//���
		//����õ�ͼƬ���Ƶ�����(g)
		g.drawImage(getImage(),x,y,null);
	}
	
	//��дһ�����󷽷�
	public abstract void step();
	
	//��дС�ɻ�,��ɻ�,�������ĳ��緽��
	public boolean outOfBounds() {
		//y�������Ļ�߶Ⱦ��ǳ�����
		return y>World.HEIGHT;
	}
	//�޸ĵ�ǰ������״̬ΪDEAD�ķ���
	public void goDead() {
		state=DEAD;//������ȥ��
	}
	//�жϷ������Ƿ���ײ�ķ���
	//this����Ϊ�ӵ�,f����Ϊ�л�
	public boolean hit(FlyingObject f) {
		//���������Ҳ�x����
		int x1=f.x-this.width;
		int x2=f.x+f.width;
		//�����Ϸ����·�y����
		int y1=f.y-this.height;
		int y2=f.y+f.height;
		//�ж�this��x��y�ǲ���ͬʱ�ڽ��޷�Χ��
		return this.x>x1 && this.x<x2 && this.y>y1 && this.y<y2;
				
	}

}











