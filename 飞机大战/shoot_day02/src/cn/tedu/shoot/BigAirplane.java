package cn.tedu.shoot;
//大飞机
public class BigAirplane {
	int width;
	int height;
	int x;
	int y;
	int step;
	public BigAirplane() {
		
	}
	public BigAirplane(int width,int height,int x,int y,int step) {
		this.width=width;
		this.height=height;
		this.x=x;
		this.y=y;
		this.step=step;
	}
	
	public void show() {
		System.out.println("宽:"+width+",高:"+height);
		System.out.println("x:"+x+",y:"+y);
		System.out.println("速度"+step);
	}

}








