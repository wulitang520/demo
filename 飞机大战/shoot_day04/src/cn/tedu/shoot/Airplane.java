package cn.tedu.shoot;//С�ɻ�
//С�л���
public class Airplane extends FlyingObject{
	//С�л�
	private int step;//�ٶ�
	//���췽��
	public Airplane() {
		super(48,50);
		step=4;
	}
	
	public void show() {
		System.out.println("��:"+width+",��:"+height);
		System.out.println("x:"+x+",y:"+y);
		System.out.println("�ٶ�"+step);
	}

}























