//meinz015

public class CelestialDatabase{
	private List<Star> list;
	/**
	instantiates a new list depending if user would like the underlying
	list to be either an ArrayList or LinkedList
	*/
	public CelestialDatabase(String type){
		if (type.equals("array")){
			list = new ArrayList<Star>();
		}
		else if (type.equals("linked")){
			list = new LinkedList<Star>();
		}
		else{
			System.out.println("Option not available.");
		}
	}
	
	/**
	the add method is called on the list depending on the underlying type of list
	the add method utilizes the adding of a single element method
	*/
	public boolean add(Star s){
		return list.add(s);
	}
	
	/**
	the list is interated through
	it checks to see what type of star each element in the list is an instance of
	if the name matches any of the elements, the Star element is saved and returned
	if no element is found that contains name, then null is returned
	*/
	public Star find(String name){
		for (int i=0; i< list.size(); i++){
			Star s1 = list.get(i);
			if (s1 instanceof Sequence){
				Sequence s2 = (Sequence)s1;
				String n1 = s2.getName();
				if (n1.contains(name)){
					return (s1);
				}
			}
			if (s1 instanceof RedGiant){
				RedGiant s2 = (RedGiant)s1;
				String n1 = s2.getName();
				if (n1.contains(name)){
					return (s1);
				}
			}
			if (s1 instanceof WhiteDwarf){
				WhiteDwarf s2 = (WhiteDwarf)s1;
				String n1 = s2.getName();
				if (n1.contains(name)){
					return (s1);
				}
			}
		}
		return null;
	}
	
	/**
	the list is iterated through and each element is checked to see if it is an instance of a Sequence
	if it is a sequence, it is casted to a sequence star, so that the isSun() method can be accessed
	if the element is a sun, that element is returned
	if no elements are suns, null is returned
	*/
	public Star findSun(){
		if (list.size() != 0){
			for (int i=0; i< list.size(); i++){
				Star s1 = list.get(i);
				if ((s1 != null) && (s1 instanceof Sequence)){
					Sequence s2 = (Sequence)s1;
					if ((s2 != null)&&(s2.isSun()==(true))){
						return s1;
					}
				}
			}
		}
		return null;		
	}
	
	/**
	if the index is within the parameters of the list,
	the remove method is called and returned depending on the underlying type of list
	if the index is out of range, null is returned
	*/
	public Star remove(int index){
		if ((index>=0) &&(index < list.size())){
			return list.remove(index);
		}
		return null;
	}
	
	/**
	if the index is within the parameters of the list,
	the get method is called and returned depending on the underlying type of list
	if the index is out of range, null is returned
	*/
	public Star get(int index){
		if (index < list.size()){
			return list.get(index);
		}
		return null;
	}
	
	/**
	depending what the list's underlying list is, the sort method of that list is called on the list
	true is entered into the method since the list is supposed to be sorted in increasing order
	*/
	public void sort(){
		if (list instanceof ArrayList){
			ArrayList<Star> l2 = (ArrayList<Star>)list;
			l2.sort(true);
		}
		else if(list instanceof LinkedList){
			LinkedList<Star> l2 = (LinkedList<Star>) list;
			l2.sort(true);
		}
	}
	
	/**
	the list is iterated through, and the instance of each element is determined
	if the instance of matches the string type, the count is increased
	a new array is created with size count
	the list is then iterated through again, and each instance of the star that matches the type
	is added to the list
	the list is then returned
	*/
	public Star[] getStarsByType(String type){
		int count = 0;
		for (int i=0; i< list.size(); i++){
			Star s1 = list.get(i);
			if (type.equals("sequence")&& s1 instanceof Sequence){
				count++;
			}
			if (type.equals("redgiant")&& s1 instanceof RedGiant){
				count++;
			}
			if (type.equals("whitedwarf")&& s1 instanceof WhiteDwarf){
				count++;
			}
		}
		int countType = 0;
		Star[] starType = new Star[count];
		for (int i=0; i< list.size(); i++){
			Star s2 = list.get(i);
			if (type.equals("sequence")&& s2 instanceof Sequence){
				starType[countType] = s2;
				countType++;
			}
			if (type.equals("redgiant")&& s2 instanceof RedGiant){
				starType[countType] = s2;
				countType++;
			}
			if (type.equals("whitedwarf")&& s2 instanceof WhiteDwarf){
				starType[countType] = s2;
				countType++;
			}
		}
		return starType;
	}
	
	/**
	the first element in the list is set to be the heaviest star for a starting point
	that element is then compared to the rest of the elements
	if any of the other elements is heavier, then the heaviest star is replaced
	once all the elements have been iterated through, the heaviest star is returned
	*/
	public Star getHeaviestStar(){
		Star heaviestStar = null;
		int startIndex = 0;
		if (list.size() != 0){
			heaviestStar = list.get(startIndex);
			while ((heaviestStar == null) && (startIndex<list.size())){
				startIndex++;
				heaviestStar = list.get(startIndex);
			}
			for (int i=startIndex; i< list.size(); i++){
				Star s2 = list.get(i);
				if ((s2 != null)&&(s2.compareTo(heaviestStar)>0)){
					heaviestStar = s2;
				}
			}
		}
		return heaviestStar;
	}
	
	/**
	the first element in the list that is a Red Giant instance is set to be the heaviest star for a starting point
	that element is then compared to the rest of the elements
	if any of the other elements that are also instances of Red Giants are heavier, then the heaviest star is replaced
	once all the elements have been iterated through, the heaviest Red Giant star is returned
	*/
	public Star getHeaviestRedGiant(){
		Star heaviestGiant = null;
		int startIndex = 0;
		if (list.size() != 0){
			while ((heaviestGiant == null)&&(startIndex< list.size())){
				startIndex++;
				if (list.get(startIndex) instanceof RedGiant){
					heaviestGiant = list.get(startIndex);
				}
			}
			for (int i = startIndex; i<list.size(); i++){
				Star s2 = list.get(i);
				if ((s2 != null) && (s2 instanceof RedGiant) && (s2.compareTo(heaviestGiant)>0)){
					heaviestGiant = s2;
				}
			}
		}
		return heaviestGiant;
	}
	
	/**
	the first element in the list is set to be the largest star for a starting point
	that element is then compared to the rest of the elements
	if any of the other elements are larger, then the largest star is replaced
	once all the elements have been iterated through, the largest star is returned
	*/
	public Star getLargestStar(){
		Star largestStar = null;
		int startIndex = 0;
		if (list.size() != 0){
			largestStar = list.get(0);
			while((largestStar == null)&&(startIndex<list.size())){
				startIndex++;
				largestStar = list.get(startIndex);
			}
			for (int i = startIndex+1; i< list.size(); i++){
				Star s2 = list.get(i);
				if ((s2!=null) &&s2.getSize()> largestStar.getSize()){
					largestStar = s2;
				}
			}
		}
		return largestStar;
	}
	
	/**
	the list is iterated and the number of black holes is found using the isBlackHole() method
	once the number is known, a new array is created using that number
	the list is then iterated through again, and each element that is also a black hole is added to the list
	the list is then returned
	*/
	public Star[] listBlackHoles(){
		if (list.size() != 0){
			int count = 0;
			for (int i=0; i< list.size(); i++){
				Star s1 = list.get(i);
				if ((s1 != null)&& (s1.isBlackHole() == true)){
					count++;
				}
			}
			int starCount = 0;
			Star[] blackHoles = new Star[count];
			for (int i=0; i< list.size(); i++){
				Star s1 = list.get(i);
				if ((s1 != null)&&(s1.isBlackHole()== true)){
					blackHoles[starCount] = s1;
					starCount++;
				}
			}
		return blackHoles;
		}		
		return null;
	}
	/**
	a temporary listHeaviest is made and set equal to list
	then the array topHeaviest is created - the size depends on which is larger, the size of the array or the size wanted
	listHeaviest is then sorted (done my mass in increasing order)
	topHeaviest is then filled starting at the last element in listHeaviest and ending when the array is full
	the array is then returned
	*/
	public Star[] getTopKHeaviestStar(int k){
		List<Star> listHeaviest = list;
		Star[] topHeaviest; 
		if (list.size()>k){
			topHeaviest = new Star[k];
		}
		else{
			topHeaviest = new Star[list.size()];
		}
		listHeaviest.sort(true);
		for (int i=0; i<topHeaviest.length; i++){
			topHeaviest[i] = listHeaviest.get(listHeaviest.size()-1-i);
		}
		return topHeaviest;
	}
	
	/**
	a temporary array in made containing all the stars
	then the array topHeaviest is created - the size depends on which is larger, the size of the array or the size wanted
	listHeaviest is then sorted (done my getting size of each star and comparing them and swapping in increasing order)
	topHeaviest is then filled starting at the last element in listHeaviest and ending when the array is full
	the array is then returned
	*/
	public Star[] getTopKLargestStar(int k){
		Star[] arrayStar = new Star[list.size()];
		for (int l=0; l<list.size(); l++){
			arrayStar[l] = list.get(l);
		}
		Star[] topLargest; 
		if (list.size()>k){
			topLargest = new Star[k];
		}
		else{
			topLargest = new Star[list.size()];
		}
		int i,j;
		Star firstElement, secondElement;
		for (i = 1; i<arrayStar.length;i++){
			firstElement = arrayStar[i];
			for (j = i-1; j>=0; j--){
				secondElement = arrayStar[j];
				if ((firstElement != null) && (secondElement != null) && ((firstElement.getSize())<secondElement.getSize())){
					arrayStar[j+1] = arrayStar[j];
					arrayStar[j] = firstElement;
				}
			}
		}
		for (int h= 0; h<topLargest.length; h++){
			topLargest[h] = arrayStar[arrayStar.length-1-h];
		}
		return topLargest;
	}

	/**
	3 different counts are created, one for each instance of star
	the list is then iterated through and the count of the instance the element belongs to is increased by one
	once the list is iterated through, a new array of size 3 is created and the 3 counts are inputed
	the array is then returned
	*/
	public int[] countStars(){
		int countSequence = 0;
		int countRedGiant = 0;
		int countWhiteDwarf = 0;
		for (int i=0; i< list.size(); i++){
			Star s1 = list.get(i);
			if (s1 instanceof Sequence){
				countSequence++;
			}
			if (s1 instanceof RedGiant){
				countRedGiant++;
			}
			if (s1 instanceof WhiteDwarf){
				countWhiteDwarf++;
			}
		}
		int[] starCount = new int[3];
		starCount[0] = countSequence;
		starCount[1] = countRedGiant;
		starCount[2] = countWhiteDwarf;
		return starCount;	
	}
	
	/**
	this toString method is used if the output of a method is an array
	it sorts through th array and calls the other toString method to print the actual Stars within the array
	*/
	public String toStringArray(Star[] s){
		if (s.length == 0){
			return "No Stars in Array";
		}
		String str = "[";
		for (int i= 0; i< s.length; i++){
			if (str.equals("[")){
				str = str+s[i].toString();
			}
			else{
				str = str+", "+s[i].toString();
			}
		}
		return str+"]";
	}
		
	/**
	this toString calls upon the toString methods within the individual list classes
	it is used if the thing that toString is being called on is a Star
	*/
	public String toString(){
		return list.toString();
	}
	
	public static void main(String[] args){
		CelestialDatabase data = new CelestialDatabase("array");
		Star s1 = new WhiteDwarf("White Dwarf", 100.00, 200.00);
		Star s2 = new Sequence("Sequence", 2.0, 430.0);
		Star s3 = new RedGiant("Red Giant", 1.0, 2.0);
		Star s4 = new RedGiant("Red Giant", 150.0, 200.0);
		Star s5 = new Sequence("Sequence", 150.0, 600.0);
		data.add(s1);
		data.add(s2);
		data.add(s3);
		data.add(s4);
		System.out.println("LIST:\n"+data.toString());
		data.remove(0);
		System.out.println("\n\n\nLIST:\n"+data.toString());
		System.out.println("\n\n\nGet element 2:\n"+data.get(2).toString());
		Star s6 = data.find("NO");
		Star s7 = data.find("Red");
		if (s6 != null){
			System.out.println("\n\n"+s6.toString());
		}
		else{
			System.out.println("\n\nNo Star");
		}
		if (s7 != null){
			System.out.println("\n\n"+s7.toString());
		}
		else{
			System.out.println("\n\nNo Star");
		}
		data.add(s1);
		System.out.println("\n\nStar at index 0\n"+data.get(0).toString());
		System.out.println("\n\nLargest Star\n"+data.getLargestStar());
		System.out.println("\n\nHeaviest Star'n"+data.getHeaviestStar());
		System.out.println("\n\nAll RedGiants\n"+data.toStringArray(data.getStarsByType("redgiant")));
		if (data.findSun() != null){
			System.out.println("\n\nSuns?\n"+data.findSun().toString());
		}
		else{
			System.out.println("\\nSuns: No Sun");
		}
		data.add(s5);
		data.sort();
		System.out.println("\n\nSorted List:\n: "+data.toString());
		data.remove(7);
		System.out.println("\n\nHeaviest RedGiant:\n"+data.getHeaviestRedGiant().toString());
		System.out.println("\n\n List of Black Holes:\n"+data.toStringArray(data.listBlackHoles()));
		System.out.println("\n\n\nLIST:\n"+data.toString());
		for (int i = 0; i<3; i++){
			System.out.print(+data.countStars()[i]+"	");
		}
		
	}
}
