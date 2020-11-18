public class VideoStore {
    Video[] store;
    static int numOfvideo=0;
    
    public VideoStore(){
        store=new Video[100];
	}
	public void addVideo(String name){
		store[numOfvideo]=new Video(name);
        System.err.println("Video "+'"'+store[numOfvideo].getName()+'"'+" added successfully");
        numOfvideo++;
	}
	public void doCheckout(String name){
        for(int i=0; i<numOfvideo; i++){
		    if(store[i].videoName.equals(name)){
                store[i].doCheckout();
            }
		}
	}
	public void doReturn(String name){
        for(int i=0; i<numOfvideo; i++){
		    if(store[i].videoName.equals(name)){
                store[i].doReturn();
            }
		}
	}
	public void receiveRating(String name, int rating) {
        int temp=0;
        for(int i=0; i<numOfvideo; i++){
		    if(store[i].videoName.equals(name)){
                store[i].receiveRating(rating);
                temp=i;
            }
            System.out.println("1");
        }
		System.err.println("Rating "+'"'+store[temp].getRating()+'"'+" has been mapped to the Video "+'"'+store[temp].getName()+'"');

	}
	public void listInventory() {
        System.out.println("------------------------------------------");
        for(int i=0; i<numOfvideo; i++){
            System.out.println("Video Name :"+store[i].getName());
            System.out.println("Checkout Status :"+store[i].getCheckout());
            System.out.println("Rating :"+store[i].getRating());
            System.out.println();
        }
        System.out.println("------------------------------------------");
	}
}