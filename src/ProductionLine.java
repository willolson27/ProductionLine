import java.util.LinkedList;
import java.util.Queue;

public class ProductionLine {

	Queue<Disk> inputQueue;
	Queue<Tower> outputQueue;
	
	
	public ProductionLine() {
		inputQueue  = new LinkedList<Disk>();
		outputQueue  = new LinkedList<Tower>();
	}
	
	public void addDisk(Disk d) {
		
		inputQueue.add(d);
	
	}
	
	
	public void unloadRobot () {
	
		
		
	}
	
	public void process() {
		
		
	}
	
	public Tower removeTower() {
		
		Tower t = outputQueue.remove();
		return t;
	}
	
}
