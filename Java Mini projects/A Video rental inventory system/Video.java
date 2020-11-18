public class Video {
    String videoName;
	boolean checkout;
	int rating=0;
	
	Video(String name){
		videoName=name;
	}
	public String getName(){
		return videoName;
	}
	public void doCheckout(){
		if(checkout!=true){
			System.err.println("Video "+'"'+ getName()+'"' +" checked out successfully.");
			checkout=true;
		}
		else	
			System.out.println("Video "+'"'+ getName()+'"'+" is not available in store");
	}
	public void doReturn(){
		checkout=false;
		System.err.println("Video "+'"'+ getName()+'"' +" returned successfully.");
	}
	public void receiveRating(int rating){
		this.rating=rating;
	}
	public int getRating(){
		return rating;
	}
	public boolean getCheckout(){
		return checkout;
	}
}
