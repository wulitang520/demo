package cn.tedu.shoot;//С�ɻ�

import java.awt.image.BufferedImage;

//С�л���
public class Airplane extends FlyingObject{
	//
	private static BufferedImage[] images;//int[]images
	//
	static {
		images=new BufferedImage[5];
		//Ϊ����Ԫ�ظ�ֵ
					//BufferedImage
		images[0]=readImage("airplane0.png");//ͼƬ
		//������ []=
		for(int i=1;i<images.length;i++) {
			images[i]=readImage("bom"+i+".png");
		}
	}
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
	int index=1;//4
	//��д����ĳ��󷽷�
	public BufferedImage getImage() {
		BufferedImage img=null;
		//���С�л�����
		if(isLife()) {
			//����С�л�ͼƬ
			img=images[0];
		} else if(isDead()) {//�ж��Ƿ�����
			//���һ�ű�ըͼƬ
			img=images[index];
			//׼�������һ�ű�ըͼƬ
			index++;
			//��������һ�ű�ըͼƬ
			if(index>=images.length) {
				//����ǰ״̬�Ƴ�
				state=REMOVE;
			}
		}else if(isRemove()) {
			img=null;
		}		
		return img;
	}
	//��д����ĳ��󷽷�
	public void step(){
		y+=step;
}
	
	
	
	
	
	
	
	
	

}























