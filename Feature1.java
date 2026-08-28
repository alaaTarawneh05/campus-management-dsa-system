package FinalCode;

//Singly Linked List:



// space complexity: o(n) for allocation


public class Feature1 {
	
	
	 public  class Item {
		 String name, descr , loca, date;
		 int id;
		
		public Item(int id, String name, String descr , String loca, String date) {
			this.id=id;
			this.name=name;
			this.descr=descr;
			this.loca=loca;
			this.date=date;
		}
		
		
// to make Item return these values instead of its address
		public String toString() {
		  return "ID: "+id+", NAME: "+name+" ,Description: "+descr+"Location "+loca+", date "+ date; }
		
	         }


	 
	 
	 
	 
	 class Node{
		 Item data;
		 Node next;
		 // constructor to initialize the node by creating an item object using these data
		public Node(int id, String name, String desc, String loc, String date) {
			//obj
            this.data= new Item(id,name,desc,loc,date);
            this.next = null; }}
	 
	
	

	private Node head;
	
	// 1. add lost items
	// 2. display all the lost items
	// 3. remove a lost item by id
	// 4. search for an item by description or name
	
	
	
	
	// 1
	// O( 1 )
	public void addItem(int id, String name, String desc, String loc, String date){

		// add to head
		Node newNode=new Node(id,name,desc,loc,date);
		newNode.next=head;
		head=newNode;		
	}
	
	
	
	
	//2 
	// o(n)
	public void displayAllItems() {
		if(head ==null) {System.out.println("Empty"); return;}
	
	    Node temp = head;
	    while(temp!=null){
	     	System.out.println(temp.data);
		    temp=temp.next; }}
	
	
	
	//3
	// o(n)
	public void removeItem(int id) {
		
		if (head==null) {
			System.out.println("No items to remove");
			return; }
		
		// if it is the head
		if(head.data.id == id) {
			head=head.next;
			return;
		}
	
		
		
		Node prev = head;
		Node current = head.next;
		
		while(current!=null) {
			
			if ( current.data.id == id  ){
				prev.next=current.next;
				return;
			} 
			
			// update statement
			prev=current;
			current= current.next;
			}}
	
	
	
	//4
	// o(n)
	
	public Item search(String key) {
		//**********error handling
		if(key == null || key.isEmpty() ) {
			System.out.println("Invalid search key");
			return null;
		}
		
		
		Node temp = head;
		while(temp!=null) {
		  if ( (temp.data.name.toLowerCase().contains(key.toLowerCase())) || ( temp.data.descr.toLowerCase().contains(key.toLowerCase())) ) {
			  
				return temp.data;
		  }temp= temp.next;
	      }
		
		
		System.out.println("Item not found");
		return null;
		
	}
	
	
	
	
	
	
}
