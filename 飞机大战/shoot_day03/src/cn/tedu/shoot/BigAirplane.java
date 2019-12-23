package cn.tedu.shoot;
//大飞机
public class BigAirplane extends FlyingObject{

	int step;
	public BigAirplane() {
		super(66,89);
		step=2;
		
	}

	
	public void show() {
		System.out.println("宽:"+width+",高:"+height);
		System.out.println("x:"+x+",y:"+y);
		System.out.println("速度"+step);
	}

}








