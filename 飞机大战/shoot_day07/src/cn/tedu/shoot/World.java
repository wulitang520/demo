package cn.tedu.shoot;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class World extends JPanel {

	// ��͸ߵĳ���
	public static final int WIDTH = 400;
	public static final int HEIGHT = 700;

	Hero hero = new Hero();
	Sky sky = new Sky();
	FlyingObject[] enemy = {};
	Bullet[] bls = {};

	public void start() {
		//����һ�������������������ڲ������
		MouseAdapter l=new MouseAdapter() {
			//����ƶ�ʱ�����ķ���
			public void mouseMoved(MouseEvent e) {
				//�������x��y������λ��
				int x=e.getX();
				int y=e.getY();
				hero.moveTo(x,y);
			}
		};
		//ע������ƶ��¼�����껬���¼�
		this.addMouseListener(l);
		this.addMouseMotionListener(l);
		// ��д��ʱ��
		Timer timer = new Timer();
		// ������ʱ��
		int interval = 30;
		// ��д��ʱ��������������
		// �����ڲ�����ʵ��
		TimerTask task = new TimerTask() {
			public void run() {
				// �ɼ�ʱ�����ڵ��õķ���
				moveAction();
				enemyEnterAction();
				bulletEnterAction();
				//checkOutAction();
				// �ػ洰��,�Զ�����paint����
				repaint();

			}
		};
		timer.schedule(task, interval, interval);

	}
	//���л����ӵ�����ķ���
	public void checkOutAction() {
		//����һ�������������Ҫ����������
		
		int index=0;
		//����һ����Դ���鳤��һ�µ�������
		//�����������û�г���ĵл�
		FlyingObject[] flive=new FlyingObject[enemy.length];
		//�����л�����
		for(int i=0;i<enemy.length;i++) {
			//ȡ����ǰ�л�
			FlyingObject f=enemy[i];
			//�����ܵл��Ƿ�û���粢��û�Ƴ�
			if(!f.outOfBounds() && !f.isRemove()) {
				//����ܵл�����������
				flive[index]=f;
				//Ϊ��һ���л�����������׼��
				index++;
				
			}
		}
		//�������鰴�մ��ĵл��������
		enemy=Arrays.copyOf(flive, index);
		//��ʼ��д�ӵ�Խ��ļ��
		index=0;
		Bullet[] blive=new Bullet[bls.length];
		for(int i=0;i<bls.length;i++) {
			Bullet b=bls[i];
			if(!b.outOfBounds()&&!b.isRemove()) {
				blive[index]=b;
				index++;
			}
		}
		bls=Arrays.copyOf(blive, index);
		//System.out.println(bls.length);
	}

	int bulletIndex = 1;

	// �ӵ������ķ���
	public void bulletEnterAction() {
		if (bulletIndex % 15 == 0) {
			// Ӣ�ۻ�����,�����ӵ�������
			Bullet[] bs = hero.shoot();
			// �Ե�ǰ�ӵ���������
			// ���ݳ�����bs�ĳ���
			bls = Arrays.copyOf(bls, bls.length + bs.length);
			// ��bs�е��ӵ���ֵ��bls������λ��,����bs����Ϊ1��2�����
			// ʹ��System.arraycopy();
			System.arraycopy(bs, 0, bls, bls.length - bs.length, bs.length);

		}
		bulletIndex++;
	}

	// �������ƶ�
	public void moveAction() {
		sky.step();// ��ն�
		// ���ел���
		for (int i = 0; i < enemy.length; i++) {
			enemy[i].step();
		}
		// �����ӵ���
		for (int i = 0; i < bls.length; i++) {
			bls[i].step();
		}
	}

	int enemyIndex = 1;
 
	// �л������ķ���
	public void enemyEnterAction() {
		if (enemyIndex % 30 == 0) {
			// ����һ�ܵл�
			FlyingObject f = makeEnemy();
			// �ѵ�ǰ�л���������1
			enemy = Arrays.copyOf(enemy, enemy.length + 1);
			// �����ɵĵл��������ݺ���������λ��
			enemy[enemy.length - 1] = f;
		}
		enemyIndex++;
	}

	// �������һ�ܵл��ķ���
	public FlyingObject makeEnemy() {
		FlyingObject fly = null;
		// ����һ��0~99�������
		Random ran = new Random();
		int num = ran.nextInt(100);
		if (num < 40) {
			fly = new Airplane();
		} else if (num < 80) {
			fly = new BigAirplane();
		} else {
			fly = new Bee();
		}
		return fly;
	}

	// ���ƴ�������շ���
	// �����������paint
	public void paint(Graphics g) {
		// �����Ȼ�����
		sky.paintObject(g);
		hero.paintObject(g);
		for (int i = 0; i < enemy.length; i++) {
			enemy[i].paintObject(g);
		}
		for (int i = 0; i < bls.length; i++) {
			bls[i].paintObject(g);
		}
	}

	public static void main(String[] args) {
		World w = new World();
		// ʵ����һ�����ڶ���
		JFrame jf = new JFrame("�ɻ���ս");
		// ��world�������봰�����
		jf.add(w);
		// ���ô���Ŀ��
		jf.setSize(400, 700);
		// �����ϽǵĲ�ʱ��ͬʱ��������
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ���ó���λ�þ���
		jf.setLocationRelativeTo(null);
		// ��ʾ����,ͬʱ����paint����
		jf.setVisible(true);
		w.start();

	}

}
