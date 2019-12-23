package cn.tedu.shoot;
//奖励的接口
public interface Award {
	//规定奖励对应的数值
	int DOUBLE_FIRE=0;//奖励火力值
	int LIFE=1;//奖励生命值
	//获得奖励的方法
	int getAward();

}
