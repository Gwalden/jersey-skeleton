package fr.iutinfo.skeleton.api;

public class Derp extends Entity {
	final int type = 7;
	
	public Derp(){
	}

	public Derp(int x, int y, int id){
		this.x = x;
		this.y = y;
		this.id = id;
		this.dep = 1;
		this.att = 1;
		this.vie = 1;
		this.cout = 1;
		this.rAtt = 1;
		this.point = 10;
		this.peutAttaquer = false;
	}
}
