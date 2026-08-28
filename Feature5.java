package FinalCode;

// queue singly linked list

public class Feature5 {

	// Node : to register each student registration data

	private class Node{
		String name;
		int id;
		Node next;
		
		
		public Node(String name, int id ) {
			this.name=name;
			this.id=id;
			this.next=null; }
		
	}
	
	
	
	
	private Node front;
	private Node rear;
	
	public Feature5() {
		front=null;
		rear=null;
	}
	
	
	// 1 for registrations  - enqueue
	// 2 for process next registration - dequeue
	// 3 to display all registrations
	
	
	
	public void register(String name, int id) {
		Node newNode = new Node(name,id);
		
		if(rear==null) {
			front = rear = newNode;
		}else {
			rear.next = newNode;
			rear=newNode;
        }System.out.println("New registerd added succesfully for student : "+rear.name+" id: "+rear.id);
	}
	
	
	
	public void processRegisteration() {
		if(rear==null) { 
			System.out.println("No registration to preocess !");
			return ;
		}
		System.out.println("processing for student: "+ rear.name +" id: "+rear.id );
		front = front.next;
		
	}
	
	
	
	
	public void displayAllRegistration() {
		if(front==null) { 
			System.out.println("No registration to display !");
			return ;
		}
		System.out.println("Registrations in order:");
		Node curr = front;
		int i=1;
		
		while(curr!=null) {
			System.out.println(i+" Student:  "+curr.name +" , id: "+curr.id);
			i++;
			curr=curr.next;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
