package cn.tedu.shoot;//小飞机

import java.awt.image.BufferedImage;

//小敌机类
public class Airplane extends FlyingObject{
	//
	private static BufferedImage[] images;//int[]images
	//
	static {
		images=new BufferedImage[5];
		//为数组元素赋值
					//BufferedImage
		images[0]=readImage("airplane0.png");//图片
		//变量名 []=
		for(int i=1;i<images.length;i++) {
			images[i]=readImage("bom"+i+".png");
		}
	}
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
	int index=1;//4
	//重写父类的抽象方法
	public BufferedImage getImage() {
		BufferedImage img=null;
		//如果小敌机活着
		if(isLife()) {
			//返回小敌机图片
			img=images[0];
		} else if(isDead()) {//判断是否死了
			//获得一张爆炸图片
			img=images[index];
			//准备获得下一张爆炸图片
			index++;
			//如果是最后一张爆炸图片
			if(index>=images.length) {
				//将当前状态移除
				state=REMOVE;
			}
		}else if(isRemove()) {
			img=null;
		}		
		return img;
	}
	//重写父类的抽象方法
	public void step(){
		y+=step;
}
	
	
	
	
	
	
	
	
	

}























