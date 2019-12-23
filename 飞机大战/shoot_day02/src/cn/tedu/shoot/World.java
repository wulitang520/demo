package cn.tedu.shoot;

public class World {
	
	Hero hero=new Hero();
	Sky sky=new Sky();
	Airplane[] as=new Airplane[3];
	BigAirplane[] bis=new BigAirplane[3];
	Bee[] bee=new Bee[3];
	Bullet[] bt=new Bullet[3];
	
	public void start() {
		as[0]=new Airplane(50,50,120,62,2);
		as[1]=new Airplane(51,6,15,5,5);
		for(int i=0;i<as.length;i++) {
			if(as[i]!=null) {
				as[i].show();
			}
		}
		bis[0]=new BigAirplane(50,62,52,2,4);
		bis[1]=new BigAirplane(51,98,42,2,6);
		for(int i=0;i<bis.length;i++) {
			if(bis[i]!=null) {
				bis[i].show();
			}
		}
		bee[0]=new Bee(54,98,52,65,41,6);
		bee[1]=new Bee(54,62,35,54,26,7);
		for(int i=0;i<bee.length;i++) {
			if(bee[i]!=null) {
				bee[i].show();		
			}
		}
		bt[0]=new Bullet(54,61,554,62,3);
		bt[1]=new Bullet(51,65,484,51,6);
		for(int i=0;i<bt.length;i++) {
			if(bt[i]!=null) {
				bt[i].show();
			}
		}
	}

	public static void main(String[] args) {
		World w=new World();
		w.start();
		
	}

}
