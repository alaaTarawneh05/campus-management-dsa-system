package FinalCode;


// stack in doubly linked list


public class Feature4 {
	
	
	private class Node{
		String action;
		Node prev;
		Node next;
		
	    public Node(String action) {
			this.action=action;
			this.prev=null;
			this.next=null;  }
	    }
	
	
	
	private Node undoTop=null;
	
	private Node redoTop=null;

	
	
	// adding action to the stack undo
	// if we want to undo we pop and move it to the redo stack
	// if we want to redo we pop and move it back to undo stack
	
	
	
	
	// push o(1)
	// pop o(1)
	// peek o(1)
	// show all o(n)
	
	
	public void doAction(String action) {
		
		Node newNode = new Node(action);
		
		// add the action to the top of stack (head)
		
		newNode.prev=undoTop;
		
		if(undoTop != null) {
			undoTop.next = newNode; }
		
		
		undoTop = newNode;
		
		
	// redo = null when we add a new action so that the previous action is deleted    
   // we only redo the last added action
		redoTop=null;
		
		System.out.println("Action performed :) --> "+ action);
	}
	
	
	
	
	
	
	
	
	// undo last action >> by pop it and push to the redo stack
	//o(1)
	public void undo() {
		
		if(undoTop ==null) {
			System.out.println("There is no action to undo");
			return;
		}
		
		
		System.out.println("Undo: "+ undoTop.action);

		Node lastAct = undoTop;
		
		undoTop = undoTop.prev ;
		
		
		if(undoTop!= null) {
			
			undoTop.next=null;
			
		}
		
		
		// adding the last action to the Redo stack
		
		lastAct.prev = redoTop;
		
		if(redoTop != null) {
			redoTop.next=lastAct;}
		
		  redoTop = lastAct;
		  
	}
	
	
	
	
	
	// redo 
	//o(1)
	
	public void redo() {
		
		if (redoTop == null) {
			System.out.println("There is no action to redo");
		}
		
		System.out.println("Redo: "+ redoTop.action);
		
		Node lastRedo = redoTop;
		
		redoTop = redoTop.prev;
		
		
		// delete the bond between the last two actions
		if(redoTop != null) {
			redoTop.next = null;
		}
		
		undoTop=lastRedo;

	}
	
	
	
	
	

	
	
	// o(n)
	
	public void showActions() {
		if (undoTop == null) {
			System.out.println("There is no added actions !");
			return;
		}
		
		
		System.out.println("All actions:");
		
		Node current = undoTop;
		
		while(current != null) {
			
			System.out.println(" "+current.action);
			current=current.prev;
		}
		
	}
	
	
	
}
