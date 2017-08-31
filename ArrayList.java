//meinz015
@SuppressWarnings("unchecked")
public class ArrayList<T extends Comparable<T>> implements List<T>{
	private Comparable<T>[] a;
	private int numElements;
	
	/**
	constructor method - instantiates new array list of size 2
	sets the number of elements within the list to be 0
	*/
	public ArrayList(){
		a = (T[]) new Comparable[2];
		numElements =0;
	}
	
	/**
	add method adds an element to the end of the array list
	since the number of elements = end of list, the element is added to the place where numElements is at
	if the arrayList is not big enough, it is doubled in size and copied over
	*/
	public boolean add(T element){
		boolean flag = false;
		if (size() <= a.length-1){
			a[size()] = element;
			numElements++;
			flag = true;
		}
		else{
			Comparable<T>[] tempArray = (T[])new Comparable[a.length*2];
			for (int i=0; i<a.length; i++){
				tempArray[i] = a[i];
			}
			a = tempArray;
			a[size()] = element;
			numElements++;
			flag = true;
		}
		return flag;
	}
	
	/**
	adding an element to a specific index - finds that index in a list and shifts all elements after the index down one
	then sets the specific element into the index
	if arrayList is full, an extra space is added to the list to accomodate addition
	*/
	public boolean add(int index, T element){
		boolean flag = false;
		int count = 0;
		for (int i =0; i<a.length; i++){
			if (a[i] != null){
				count++;
			}
		}
		if ((index>0) && (index < a.length) && (element != null)){
			if (count+1<a.length){
				for (int i = count; i >= index; i--){
					a[i+1] = a[i];
				}
				a[index] = element;
				flag = true;
			}
			else{
				Comparable<T>[] tempArray = (T[]) new Comparable[a.length*2];
				for (int i=0; i<a.length; i++){
					tempArray[i] = a[i];
				}
				a = tempArray;
				for (int i = size(); i >= index; i--){
					a[i+1] = a[i];
				}
				a[index] = element;
				flag = true;
			}
		numElements++;
		}
		return flag;
	}
	
	/**
	clear takes all the elements within and sets them all to null
	*/
	public void clear(){
		a = (T[]) new Comparable[2];
		numElements = 0;
	}
	
	/**
	contains iterates through all the elements in a list and if two things are equal, it returns true
	*/
	public boolean contains(T element){
		boolean flag = false;
		for (int i =0; i<a.length; i++){
			if(a[i] == element){
				flag = true;
			}
		}
		return flag;
	}
	
	/**
	get finds the index in the arrayList and returns the object at that index
	*/
	public T get(int index){
		T idx = null;
		if (index < a.length && index>=0){
			idx = (T)a[index];
		}
		return idx;	
	}
	
	/**
	indexOf iterates through the arrayList and if two objects are equal, it finds saves the index of the object
	it then breaks the for loop at that point in case there are multiples of the object sinc we only want the first instance
	*/
	public int indexOf(T element){
		int idx = -1;
		for (int i =0; i<a.length; i++){
			if (a[i] != null){
				if(element.compareTo((T)a[i]) == 0){
					idx= i;
					return idx;
				}
			}
		}
		return idx;
	}
  
	/**
	isEmpty checks to see if everything in the arrayList is null
	if not, it returns false
	*/
	public boolean isEmpty(){
		boolean flag = true;
		for (int i =0; i<a.length; i++){
			if (a[i] != null){
				flag = false;
			}
		}
		return flag;
	}
	
	/**
	lastIndexOf does the same thing as indexOf, except it doesn't break out of the for loop.
	this means that the last instance of the object will be saved and returned
	*/
	public int lastIndexOf(T element){
		int idx = -1;
		for (int i =0; i<a.length; i++){
			if(element == a[i]){
				idx= i;
			}
		}
		return idx;
	}
	
	/**
	set finds the index that is entered in the arrayList
	As long as the index is within the arrayList, and the element entered is not null, that specific index is set to the element
	*/
	public T set(int index, T element){
		T originalElement = null;
		if((element != null) && (index>0) && (index < a.length-1)){
			originalElement = (T)a[index];
			a[index] = element;
		}
		return originalElement;
	}
	
	/**
	iterates through the arrayList and counts the number of objects within that are not null and returns that number
	*/
	public int size(){
		int count = 0;
		for (int i =0; i<a.length; i++){
			if (a[i] != null){
				count++;
			}
		}
		return count;	
	}

	/**
	depending if input is true or false, 
	sort decides if the list is ordered in increasing or decreasing alphabetical order
	from there, if one element is larger/smaller than the elements before it,
	the second element is inserted into its spot and everything else is shifted down
	*/
	
	public void sort(boolean order){
		int i,j;
		T firstElement, secondElement;
		if (order == true){
			for (i = 1; i<a.length;i++){
				firstElement = (T)a[i];
				for (j = i-1; j>=0; j--){
					secondElement = (T) a[j];
					if ((firstElement != null) && (secondElement != null) &&(firstElement.compareTo(secondElement)<0)){
						a[j+1] = a[j];
						a[j] = firstElement;
					}
				}
			}
		}
		else{
			for (i = 1; i<a.length; i++){
				firstElement = (T)a[i];
				for (j = i-1; j>=0; j--){
					secondElement = (T) a[j];
					if ((firstElement != null) && (secondElement != null) && (firstElement.compareTo(secondElement)>0)){
						a[j+1] = a[j];
						a[j] = firstElement;
					}
				}
			}
		}
	}
	
	/**
	remove finds the index that the element is at, and saves the element
	once the index is found, it moves all elements after it down by one index, thereby replacing the original element
	the list is then shortened by 1
	the original element is then returned
	*/
	public boolean remove(T element){
		if (element != null){
			for (int i =0; i< size(); i++){
				if(element.compareTo((T)a[i]) == 0){
					for (int j = i; j<size()-1; j++){
						a[j] = a[j+1];
					}
					Comparable<T>[] tempArray = (T[]) new Comparable[(size())-1];
					for (int k=0; k<tempArray.length; k++){
						tempArray[k] = a[k];
					}
					a = tempArray;
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	this remove does the same thing as the remove above, except this time finds a specific index instead of a specific element
	*/
	public T remove(int index){
		T originalElement = null;
		if ((index>=0) && (index<a.length)){
			originalElement = (T)a[index];
			for (int i = index; i<size()-1; i++){
				a[i] = a[i+1];
			}
			Comparable<T>[] tempArray = (T[]) new Comparable[(size())-1];
			for (int i=0; i<tempArray.length; i++){
				tempArray[i] = a[i];
			}
			a = tempArray;
		}
		return originalElement;
	}
	
	public String toString(){
		String t =  "";
		if (size() == 0){
			t = "[ ]";
			return t;
		}
		t = "[";
		for (int i=0; i<a.length; i++) {
			if (a[i]!=null) {
				if (t.equals("[")){
					t = t+a[i].toString();
				}
				else{
					t = t + ", "+ a[i].toString();
				}
			}
		}
		return t+"]";
	}

	public static void main(String[] args){
		ArrayList<String> testList = new ArrayList<String>();
		testList.add("d");
		testList.add(1,"e");
		testList.clear();
		System.out.println("\n\nSize:	"+ testList.size());
		System.out.println("\n\nEmpty?	"+ testList.isEmpty());
		System.out.println("\n\nList: \n"+testList.toString());
		testList.add("a");
		testList.add("b");
		testList.add("c");
		testList.add("d");
		System.out.println("\n\nList: \n"+testList.toString());
		testList.add(1,"e");
		testList.add(4,"k");
		System.out.println("\n\nList: \n"+testList.toString());
		System.out.println("\n\nContains J: "+testList.contains("j"));
		System.out.println("\n\nContains A: "+testList.contains("a"));
		System.out.println("\n\nSize: "+ testList.size());
		System.out.println("\n\nEmpty? "+ testList.isEmpty());
		System.out.println("\nGET: "+testList.get(7));
		System.out.println("\nGET: "+ testList.get(2));
		System.out.println("\nSET original letter 3: "+testList.set(3,"j"));
		System.out.println("\nSET original letter 10: "+testList.set(10,"j"));
		System.out.println("\nList: \n"+testList.toString());
		System.out.println("\nRemove single element 1: "+testList.remove(1));
		System.out.println("\nList: \n"+testList.toString());
		System.out.println("\nRemove single element 7: "+testList.remove(7));
		System.out.println("\nRemove single element 1: "+testList.remove(1));
		System.out.println("\nList: \n"+testList.toString());
		testList.remove("a");
		System.out.println("\n\nRemoved?: "+testList.remove("h"));
		System.out.println("List: "+testList.toString());
		testList.add("f");
		testList.add("s");
		testList.add("r");
		testList.add("p");
		System.out.println("\nList: \n"+testList.toString());
		testList.add(2,"g");
		testList.add("d");
		System.out.println("\nList: \n"+testList.toString());
		testList.remove("f");
		System.out.println("\nList:\n "+testList.toString());
		System.out.println("\nIndex D: " +testList.indexOf("d"));
		System.out.println("\nIndex P: " +testList.indexOf("p"));
		System.out.println("\nIndex O: " +testList.indexOf("o"));
		System.out.println("\nLast index of R: "+ testList.lastIndexOf("r"));
		System.out.println("\nLast index of O: "+ testList.lastIndexOf("o"));
	}
}