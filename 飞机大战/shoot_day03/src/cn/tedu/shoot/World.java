package cn.tedu.shoot;

public class World {
	
	Hero hero=new Hero();
	Sky sky=new Sky();
	FlyingObject[] enemy=new FlyingObject[6];
	Bullet[] bt=new Bullet[3];                  
	
	public void start() {
		enemy[0]=new Airplane();
		enemy[1]=new Airplane();
		enemy[2]=new BigAirplane();
		enemy[3]=new BigAirplane();
		enemy[4]=new Bee();
		for(int i=0;i<enemy.length;i++) {
			if(enemy[i]!=null)
			enemy[i].show();
		}
	}
	
	
	

	public static void main(String[] args) {
		World w=new World();
		w.start();
		
	}

}
