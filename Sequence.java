//meinz015

public class Sequence extends Star{
	/** 
	the two methods below initilize the sequence star
	*/
	public Sequence(){
		this("",0,0);
	}
	public Sequence(String name, double mass, double size){
		super(name, mass, size);
	}
	
	/**
	if the mass and size was within the specifications, 
	the sequence star is a Sun and it sets the flag to true
	*/
	public boolean isSun(){
		boolean flag = false;
		if ((getMass() == 2) && (getSize() == 430)){
			flag = true;
		}
		return flag;
	}
	
	/**
	I found the method roundOffTo2DecPlaces online and used it to
	round the doubles mass and size
	*/
	
	
	public String roundOffTo2DecPlaces(float val){
		return String.format("%.2f", val);
	}
	
	/**
	toString used for debugging and testing
	*/
	public String toString(){
		String str = "<";
		String nameOne = getName();
		double massOne = getMass();
		double sizeOne = getSize();
		String strMass = roundOffTo2DecPlaces((float) massOne);
		String strSize = roundOffTo2DecPlaces((float) sizeOne);
		str = str+nameOne+">: A Sequence Star with mass <"+strMass+">KG and size = <"+strSize+"> miles.";
		return str;
	}
	
	/**
	if the mass and size was within the specifications, 
	the sequence star is a black hole and a flag is set to true
	*/
	public boolean isBlackHole(){
		boolean flag = false;
		if ((getMass()> 1000) && (getSize()< 50)){
			flag = true;
		}
		return flag;
	}
	
	public static void main(String[] args){
		Sequence s1 = new Sequence("myStar", 1.3490, 2.34);
		System.out.println(s1);
		System.out.println("Black Hole? :"+s1.isBlackHole());
		System.out.println("Sun?:"+s1.isSun());
	}
}