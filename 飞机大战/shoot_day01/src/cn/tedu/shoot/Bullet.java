package cn.tedu.shoot;//�ӵ�

public class Bullet {
	
	int width;
	int height;
	int x;
	int y;
	int step;
	public Bullet() {
		
	}
	public Bullet(int width,int height,int x,int y,int step) {
		this.width=width;
		this.height=height;
		this.x=x;
		this.y=y;
		this.step=step;
	}
	public void show() {
		System.out.println("��:"+width+",��:"+height);
		System.out.println("x:"+x+",y:"+y);
		System.out.println("�ٶ�"+step);
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
