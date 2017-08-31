//meinz015

public class LinkedList<T extends Comparable<T>> implements List<T>{
	private Node<T> startList;
	private int numElements;
	/**
	initiate a new linked list
	sets number of elements in the list to 0
	sets a marker that keeps the head of the list as header (includes head in the headed list)
	*/
	public LinkedList(){
		this.startList = null;
		numElements = 0;
	}
	
	/**
	checks if the first element is null
	if it is, then it sets that data to the element since the list is empty
	if not, it iterates through list until the next element is null
	once it reaches that point, the spot currently null is set to the element and points to a new null spot
	*/
	public boolean add(T element){
		if (startList == null){
			startList = new Node<T>(element,null);
			numElements = 1;
			return true;
		}
		Node<T> firstNode = startList;
		while (firstNode.getNext() != null){
			firstNode = firstNode.getNext();
		}
		Node<T> elem = new Node<T>(element, null);
		firstNode.setNext(elem);
		numElements++;
		return false;
	}
	
	/**
	first I check to make sure the index given is in bounds and the element given is not null
	if the index given is 0, a new Node is created with the element pointing to the start of the list, and then setting that to the original startList
	if the index is not 0, then the list is iterated through the linked list until it gets to the spot right before the index given
	the rest of the list is saved at the index and onward to a temporary variable
	a new node is created with the element being added pointing to the temporary variable
	from the original node right before the index, I set the next node to be the new node created
	the number of elements is the increased by 1
	*/
	public boolean add(int index, T element){
		Node<T> firstNode = startList;
		int count = 0; 
		if ((element == null) && (index>size())){
			return false;
		}
		if (element != null && index < size()){
			if (index == 0){
				Node<T> newNode = new Node<T>(element, startList);
				startList = newNode;
				return true;
			}
			while (count < index-1){
				firstNode = firstNode.getNext();
				count++;
			}
			Node<T> restOfList = firstNode.getNext();
			Node<T> elem1 = new Node<>(element, restOfList);
			firstNode.setNext(elem1);
			numElements++;
			return true;
		}
		return false;
	}
	
	/**
	the linked list is reset to being null and total elements in list is 0
	*/

	public void clear(){
		startList = null;
		numElements = 0;
	}

	/**
	the linked list was iterated through until the node was null (end of list)
	if any of the elements in the list equaled the element wanted, flag was changed to true
	*/
	public boolean contains(T element){
		Node<T> firstNode = startList;
		boolean flag = false;
		while(firstNode.getNext() != null){
			if (firstNode.getData().compareTo(element) == 0){
				flag = true;
			}
			firstNode = firstNode.getNext();
		}
		return flag;
	}
  
	/**
	the linked list was iterated through until it reached the index
	once the index was reached, the element at that index is returned
	*/

	public T get(int index){
		Node<T> firstNode = startList;
		int count = 0;
		T idx = null;
		if (index < size()){
			while (count<index){
				firstNode = firstNode.getNext();
				count++;
			}
			idx = (T)firstNode.getData();
		}
		return idx;	
	}
  
	/**
	the linked list is iterated through as many elements as there are in the list
	if any of the elements equals the elements wanted, then the first index that the element is at is returned, 
	which equals the count that the element is at
	the first index is found by using boolean flag, and once it turns true, the while loop stops
	*/
	public int indexOf(T element){
		Node<T> firstNode = startList;
		int count = 0;
		int idx = -1;
		boolean flag = false;
		while (flag == false && count<size()){
			if (firstNode.getData() == element){
				idx = count;
				flag = true;
			}
			count++;
			firstNode = firstNode.getNext();
		}
		return idx;
	}
  
	/**
	iterates through linked list, and checks to see if each element is null
	if any element is not null, false is returned
	*/
	public boolean isEmpty(){
		Node<T> firstNode = startList;
		boolean flag = true;
		int count = 0;
		while (count<size()){
			if (firstNode.getData() !=null){
				flag = false;
			}
			firstNode = firstNode.getNext();
			count++;
		}
		return flag;
	}
	
	/**
	the same thing is done to lastIndexOf as indexOf, 
	except no boolean flags are set, which means the last instance of the element
	is found and that index is saved instead of the first index
	*/
	public int lastIndexOf(T element){
		Node<T> firstNode = startList;
		int count = 0;
		int idx = -1;
		while (count<size()){
			if (firstNode.getData().compareTo(element) == 0){
				idx = count;
			}
			count++;
			firstNode = firstNode.getNext();
		}
		return idx;
	}
  
	/**
	if the element wanted isnt null and the index is inside the indexes of the linked list,
	the linked list is iterated through until the index wanted is reached
	once the index is reached, the data inside is saved and then set to the new data
	the original data is then returned
	*/
	public T set(int index, T element){
		Node<T> firstNode = startList;
		int count = 0;
		T idx = null;
		if ((index< size()) && (element != null)){
			while (count<index){
				firstNode = firstNode.getNext();
				count++;
			}
			idx = (T)firstNode.getData();
			firstNode.setData(element);
		}
		return idx;	
	}
	
	/**
	the linked list is iterated through until a null is reached
	each element that is iterated though increases the count
	at the end of the itereration, the count is returned
	*/
	public int size(){
		Node<T> firstNode = startList;
		int count = 0;
		while (firstNode != null){
			count++;
			firstNode = firstNode.getNext();
		}
		return count;
	}
	
	/**
	the sort method uses the bubble sort method, a variation from Professor Dovolis's code online
	two nodes are compared to each other, and if the second is bigger/smaller (depending if order is true/false), they are swapped
	this process occurs until the entire list is iterated through and no elements are swapped
	*/
	
	public void sort(boolean order){
		boolean swapped = true;
		Node<T> current = startList;
		if (order == true){
			while(swapped == true){
				swapped = false;
				while (current != null){
					if ((current.getNext() != null) && (current.getData().compareTo(current.getNext().getData())>0)){
						T temp = current.getData();
						current.setData(current.getNext().getData());
						current.getNext().setData(temp);
						swapped = true;
					}
					current = current.getNext();
				}
				current = startList;
			}
		}
		else{
			while(swapped == true){
				swapped = false;
				while (current != null){
					if ((current.getNext() != null) && (current.getData().compareTo(current.getNext().getData())<0)){
						T temp = current.getData();
						current.setData(current.getNext().getData());
						current.getNext().setData(temp);
						swapped = true;
					}
					current = current.getNext();
				}
				current = startList;
			}
		}
	}

	/**
	first the linked list is iterated through until the first instance of the element in found, if the element is not null
	once the index of the element is found, the index directly before the element's pointer is changed to point at the element directly after the index
	this removes the single element and the number of elements is decreased by 1
	*/
	public boolean remove(T element){
		Node<T> firstNode = startList;
		boolean flag = false;
		if (element != null){
			if (firstNode.getData().compareTo(element) == 0){
				firstNode = firstNode.getNext();
				flag = true;
			}
			while (firstNode.getNext() != null){
				if (firstNode.getNext().getData().compareTo(element) == 0){
					Node<T> restOfList = firstNode.getNext().getNext();
					System.out.println("Node: "+restOfList);
					firstNode.setNext(restOfList);
					flag = true;
				}
				firstNode = firstNode.getNext();
			}
		}
		numElements = numElements-1;
		return flag;
	}
  
	/**
	the linked list is iterated through until it reaches the index before the index wanted
	that index's pointer is then pointed to the index directly after the index being removed
	the number of elements is then decreased by 1
	*/
	public T remove(int index){
		Node<T> firstNode = startList;
		T idx = null;
		int count = 0;
		if (index>0 && index<=numElements){
			while (count<index-1){
				firstNode = firstNode.getNext();
				count++;
			}
			idx = firstNode.getNext().getData();
			Node<T> restOfList = firstNode.getNext().getNext();
			firstNode.setNext(restOfList);
		}
		numElements = numElements-1;
		return idx;
	}
	/**
	the toString method is used to print out each type of linkedlist in String form
	*/
	public String toString(){
		Node<T> firstNode = startList;
		String str = "[";
		if (firstNode == null){
			str = "[ ]";
			return str;
		}
		else{
			str = "[";
			if (str.equals("[")){
				str = str+firstNode.getData();
				firstNode = firstNode.getNext();
			}
			while (firstNode != null){
				str = str+", "+firstNode.getData();
				firstNode = firstNode.getNext();
			}
		}
		return str+"]";
	}
	
	public static void main(String[] args){
		LinkedList<String> testList = new LinkedList<String>();
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