package cn.tedu.shoot;//子弹

public class Bullet extends FlyingObject{

	int step;
	public Bullet(int x,int y) {
		super(8,20);
		step=2;
	}

	public void show() {
		System.out.println("宽:"+width+",高:"+height);
		System.out.println("x:"+x+",y:"+y);
		System.out.println("速度"+step);
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
