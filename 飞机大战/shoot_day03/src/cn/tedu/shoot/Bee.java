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
		System.out.println("��:"+width+",��:"+height);
		System.out.println("x:"+x+",y:"+y);
		System.out.println("�ٶ�"+xStep+",�ٶ�"+yStep);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
