//meinz015

public class RedGiant extends Star{
	/** 
	the two methods below initilize the Red Giant star
	*/
	public RedGiant(){
		this("",0,0);
	}
	
	public RedGiant(String name, double mass, double size){
		super(name, mass, size);
	}
	
	/*
	if the mass and size was within the specifications, 
	the red giant is a super giant and a flag is set to true
	*/
	public boolean isSuperGiant(){
		boolean flag = false;
		if ((getMass() >100) && (getSize()>100)){
			flag = true;
		}
		return flag;
	}
	
	/**
	if the mass and size was within the specifications, 
	the red giant is a black hole and a flag is set to true
	*/
	public boolean isBlackHole(){
		boolean flag = false;
		if (isSuperGiant() == true){
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
		String nameOne;
		if (isSuperGiant() == true){
			nameOne = "SuperGiant";
		}
		else{
			nameOne = "Red Giant";
		}
		String nameTwo = getName();
		double massOne = getMass();
		double sizeOne = getSize();
		String strMass = roundOffTo2DecPlaces((float) massOne);
		String strSize = roundOffTo2DecPlaces((float) sizeOne);
		str = str+nameTwo+"> Is a "+nameOne+" Star with mass = <"+strMass+">KG and size = <"+strSize+"> miles.";
		return str;
	}
	
	public static void main(String[] args){
		RedGiant s1 = new RedGiant("myStar1", 1.0, 2.0);
		RedGiant s2 = new RedGiant("myStar2", 150.0, 200.0);
		System.out.println("s1: "+s1);
		System.out.println("s2: "+s2);
		System.out.println("s1 black hole: "+s1.isBlackHole());
		System.out.println("s1 supergiant: "+s1.isSuperGiant());
		System.out.println("s2 black hole: "+s2.isBlackHole());
		System.out.println("s2 supergiant: "+s2.isSuperGiant());
	}
}