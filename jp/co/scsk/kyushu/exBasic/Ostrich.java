package jp.co.scsk.kyushu.exBasic;

public class Ostrich extends Animal {

	@Override
	public void cry() {
		System.out.println("「ブフォー」と鳴く");
		
	}

	@Override
	public void run() {
		System.out.println("２本足で歩く");
		super.run();
	}
}
