package cn.tedu.shoot;

public class Hero extends FlyingObject{

	int life;//生命值
	int doubleFire;//火力值
	
	public Hero() {
		//152是(400/2-97/2)得来的
		//410是游戏界面靠下的位置估算
		super(97,139,152,410);
		life=3;
		//doubleFire默认为0
	}
	
	
	public void show() {
		System.out.println("宽:"+width+",高:"+height);
		System.out.println("x:"+x+",y"+y);
		System.out.println("生命值:"+life);
		System.out.println("火力值:"+doubleFire);
	}
	
	
	
	
	
	
	
	
	

}
