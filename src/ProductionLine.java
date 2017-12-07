import java.util.LinkedList;
import java.util.Queue;

public class ProductionLine {

	Queue<Disk> inputQueue;
	Queue<Tower> outputQueue;
	Tower 
	
	/**
	 * 
	 * @username - willolson27
	 * @date - Dec 7, 2017
	 * @method - ProductionLine
	 * 		-creates a new ProductionLine object with a new inputQueue and new outputQueue
	 */
	public ProductionLine() {
		inputQueue  = new LinkedList<Disk>();
		outputQueue  = new LinkedList<Tower>();
	}
	
	/**
	 * 
	 * @username - willolson27
	 * @date - Dec 7, 2017
	 * @method - addDisk
	 * 		-adds a given Disk to the input queue
	 * @param d - disk to be added
	 */
	public void addDisk(Disk d) {
		
		inputQueue.add(d);
	
	}
	
	/**
	 * 
	 * @username - willolson27
	 * @date - Dec 7, 2017
	 * 
	 */
	public void unloadRobot () {
	
		
		
	}
	
	/**
	 * 
	 * @username - willolson27
	 * @date - Dec 7, 2017
	 */
	public void process() {
		
		
	}
	
	/**
	 * 
	 * @username - willolson27
	 * @date - Dec 7, 2017
	 * @return - 
	 */
	public Tower removeTower() {
		
		Tower t = outputQueue.remove();
		return t;
	}
	
}
