package cn.tedu.shoot;

public class Bee extends FlyingObject{
	

	int xStep;
	int yStep;
	
	public Bee() {
		super(60,51);
		xStep=2;
		yStep=2;
		
	}

	public void show() {
		System.out.println("宽:"+width+",高:"+height);
		System.out.println("x:"+x+",y:"+y);
		System.out.println("速度"+xStep+",速度"+yStep);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
