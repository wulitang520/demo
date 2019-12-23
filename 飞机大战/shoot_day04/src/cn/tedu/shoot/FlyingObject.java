package cn.tedu.shoot;

import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;

public class FlyingObject {
	
	protected int width;
	protected int height;
	protected int x;
	protected int y;
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
		System.out.println("宽:"+width+",高:"+height);
		System.out.println("x:"+x+",y:"+y);
	}
	
	//这个方法用于读取图片到java程序
	public static BufferedImage readImage(String fileName) {
		try {
			//读取硬盘上的图片到img对象
			BufferedImage img=ImageIO.read(FlyingObject.class.getResource(fileName));
		    return img;
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	
	
	
	
	
	
	

}
