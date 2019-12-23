package cn.tedu.shoot;//小飞机
//小敌机类
public class Airplane extends FlyingObject{
	//小敌机
	private int step;//速度
	//构造方法
	public Airplane() {
		super(48,50);
		step=4;
	}
	
	public void show() {
		System.out.println("宽:"+width+",高:"+height);
		System.out.println("x:"+x+",y:"+y);
		System.out.println("速度"+step);
	}

}























