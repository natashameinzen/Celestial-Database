//meinz015

public class WhiteDwarf extends Star{
	/** 
	the two methods below initilize the White Dwarf star
	*/
	public WhiteDwarf(){
		this("",0,0);
	}
	
	public WhiteDwarf(String name, double mass, double size){
		super(name, mass, size);
	}
	
	/**
	the white dwarf is always a black hole
	*/
	public boolean isBlackHole(){
		boolean flag = false;
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
		str = str+nameOne+">: Is a White Dwarf with mass = <"+strMass+">KG and size = <"+strSize+"> miles.";
		return str;
	}
	
	public static void main(String[] args){
		Sequence s1 = new Sequence("myStar", 1.0, 2.0);
		System.out.println(s1);
		System.out.println("Black Hole?: "+s1.isBlackHole());
	}
}