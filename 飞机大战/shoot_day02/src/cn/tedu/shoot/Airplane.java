package cn.tedu.shoot;//С�ɻ�
//С�л���
public class Airplane {
	//С�л�
	int width;//��
	int height;//��
	int x;//x��
	int y;//y��
	int step;//�ٶ�
	//
	public Airplane() {//�޲ι���
		
	}
	public Airplane(int width,int height,int x,int y,int step) {
		//Ϊ���Ը�ֵ
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























