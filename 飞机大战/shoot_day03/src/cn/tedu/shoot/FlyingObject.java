package cn.tedu.shoot;

import java.util.Random;

public class FlyingObject {
	
	int width;
	int height;
	int x;
	int y;
	public FlyingObject(int width, int height) {
		Random ran=new Random();
		this.width = width;
		this.height = height;
		x=ran.nextInt(400-width);
		y=-height;
	}
	public FlyingObject(int width, int height, int x, int y) {
		super();
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
	}
	
	public void show() {
		System.out.println("¿í:"+width+",¸ß:"+height);
		System.out.println("x:"+x+",y:"+y);
	}
	
	
	
	
	
	
	
	
	
	

}
