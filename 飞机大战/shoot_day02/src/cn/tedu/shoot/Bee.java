package cn.tedu.shoot;

public class Bee {
	
	int width;
	int height;
	int x;
	int y;
	int xStep;
	int yStep;
	
	public Bee() {
		
	}
	public Bee(int width,int height,int x,int y,int xStep,int yStep) {
		this.width=width;
		this.height=height;
		this.x=x;
		this.y=y;
		this.xStep=xStep;
		this.yStep=yStep;
	}
	public void show() {
		System.out.println("��:"+width+",��:"+height);
		System.out.println("x:"+x+",y:"+y);
		System.out.println("�ٶ�"+xStep+",�ٶ�"+yStep);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
