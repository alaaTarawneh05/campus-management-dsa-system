package FinalCode;

public class Feature2 {
	
	// Queue circular array
	
	
	//space complexity o(n)
	

	private static class Booking {
		String name;
		int id;
		float hour;
		
		Booking(String name, int id, float hour){
			this.name=name;
			this.id=id;
			this.hour=hour; }
		
	} 
	
	
	
	
	private static final int MAX =100;
	private Booking[] queue;
	private int front;
	private int rear;
	private int size;
	
	
	
	
	// constructor
	public Feature2() {
		queue =new Booking[MAX];
		front=0;
		rear=-1;
		size=0;
	}
	
	
	// 1. add booking.
	// 2. process the first booking > dequeue.
	// 3. show all bookings.
	// 4. show the first book.
	
	
	
	//  1
	// o(1) we add to the rear
	public void addBooking(String name, int id, float hour) {

		if(size == MAX) {
			System.out.println("FULL bookings");
			return;  }
		
		rear = (rear+1)%MAX;
		// queue an array of type booking, each element contains name, id and hours
		// in this line I created a booking object that has user data 
		// and store it at the current rear position in the queue
		queue[rear]=new Booking(name,id,hour);
		size++;
		}
	
	
	
	
	// 2
	// o(1) remove from front
	public void processBookings() {
		if(size==0) {  System.out.println("Empty"); return; }
		
		
		Booking first= queue[front];
		System.out.println("the booking of "+first.hour+" hours for student: "+first.name+" has been processed");
		
		front = (front+1) %MAX;
		size--;
	
	}
	
	
	
	
	// 3
	// o(n) 
	public void displayAllBookings() {
		if(size==0) {  System.out.println("Empty"); return; }

		System.out.println("All student's Bookings: ");
		for(int j=0; j<size ; j++) {
			Booking first =queue[(front+j) %MAX];
			System.out.println((j+1)+" Student id: "+first.id+" Name: "+first.name +" hours :"+first.hour);
		}}
	
	
	
	
	
	
	
	// 4
	// o(1) it just show the front without any removals
	public void peek() {
		if(size==0) {  System.out.println("Empty"); return; }

		Booking first = queue[front];
		System.out.println("Next booking for student : "+ first.name+" id: "+first.id);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
