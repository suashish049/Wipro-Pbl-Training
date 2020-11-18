class Tortoise extends Thread{
    public void run(){
        for(int i=1; i<=100; i++){
            System.out.println("Distance covered by Tortoise is "+i+"..");
        }
    }
    
}

class Hare extends Thread{
    public void run(){
        for(int i=1; i<=100; i++){
            System.out.println("Distance covered by Hare is "+i+"....");
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException e){
                System.out.println("Exception Caught");
            }
        }
    }
}

class HareAndTortoiseRace implements Runnable{
    static Tortoise tortoise;
    static Hare hare;
    public static void main(String[] args) {
        tortoise = new Tortoise();
		tortoise.setPriority(Thread.MIN_PRIORITY);
		
		hare = new Hare();
		hare.setPriority(Thread.MAX_PRIORITY);

		Thread t = new Thread(new HareAndTortoiseRace());
		
		tortoise.run();
		hare.run();
		t.run();
    }    
    @Override
    public void run(){
        while (true) {
			if (!tortoise.isAlive() && hare.isAlive()) {
				//hare.stop();
				System.out.println("Tortoise won the race!");
				break;
			}
			if (!hare.isAlive() && tortoise.isAlive()) {
                //tortoise.stop();
				System.out.println("Hare won the race!");
				break;
			}
        }
    }
}
