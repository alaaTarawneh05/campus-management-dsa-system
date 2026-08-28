package FinalCode;

public class Feature6 {

	
   // BST
	
	public class Node{
		int stdId;
		int lockerID;
		Node right, left;
		
		public Node(int stdId,int lockerID  ) {
			this.stdId=stdId;
			this.lockerID=lockerID;
			this.left=null;
			this.right=null; }
	}
	
	
	// assigning the root
		private Node root;
		
		// 1. assign a locker
		// 2. search a locker by student id
		// 3. show all lockers

		
		
		
		//1
		
		public void assignLocker( int stdId,int lockerID ) {
			if( searchLocker( stdId) != null) {
				System.out.println("The student has already a locker");
				return;
			}
			
			root = iterativeInsert(root,stdId, lockerID );
		
			System.out.println("The locker added successfully for student : "+stdId);
			
		}
		
		
		
		
		private Node iterativeInsert(Node root, int stdId, int lockerID) {
			
			Node newNode = new Node(stdId,lockerID );
			
			if ( root == null) {
				return newNode;
			}
			
			// traversing the tree
			Node current = root ;
			
			
			// to track the parent node
            Node parent= null;
			
            
			while(current != null) {
				parent = current;
				if(stdId < current.stdId) {
					current = current.left;
				}else {
					current = current.right; }
			}
			
			// after we find the correct position 	
			if (stdId < parent.stdId) {
				parent.left = newNode;
			}else {
				parent.right = newNode;
			}
			return root;	
		}
		
		
		
		
	
	
	
	//2
		// o(log n)
	public Node searchLocker(int id) {
		Node curr = root;
		
		while(curr!=null) {
			
			if ( id == curr.stdId) {
				return curr;
				
			}else if (id < curr.stdId) {
				curr=curr.left;
				
			}else {
				curr=curr.right;
			}
		}
		
		System.out.println("not found");
          return null;
	}
	
	
	
	
	
	//3
	
	//o(n)
	
	public void displayAll() {
		if(root==null) {
			System.out.println("No lockers assigned yet!");
			return;
		}
		
		System.out.println("All Lockers :");
		Node curr = root;
		printInOrder(curr);
	
	}
	
   private void printInOrder(Node node) {
		if (node == null) {
			return; }
		printInOrder(node.left);
		System.out.println("Student id: "+node.stdId+" Locker: "+ node.lockerID);
		printInOrder(node.right); }
	
	

	
	
	
	
	
	
	
	
	
}
