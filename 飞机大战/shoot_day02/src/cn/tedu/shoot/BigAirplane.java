package cn.tedu.shoot;
//��ɻ�
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
		System.out.println("��:"+width+",��:"+height);
		System.out.println("x:"+x+",y:"+y);
		System.out.println("�ٶ�"+step);
	}

}








