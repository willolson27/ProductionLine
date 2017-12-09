import java.util.LinkedList;
import java.util.Queue;

public class ProductionLine {

	private Queue<Disk> inputQueue;
	private Queue<Tower> outputQueue;
	private Tower robotTower;
	
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
		robotTower = new Tower();
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
	
		Tower outputTower = new Tower();
		while (robotTower.top() != null) {
			Disk d = robotTower.removeDisk();
			outputTower.addDisk(d);
		}
		outputQueue.add(outputTower);
		
	}
	
	/**
	 * 
	 * @username - willolson27
	 * @date - Dec 7, 2017
	 */
	public void process() {
		if (inputQueue.isEmpty()) {
			unloadRobot();
			return;
		}
		Disk d = inputQueue.remove();
		if (robotTower.getDisks().empty()) {
			robotTower.addDisk(d);
			return;
		}
		Disk a = robotTower.top();
		if (a.compareTo(d) < 0)
			robotTower.addDisk(d);
		else
			unloadRobot();
			
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
	
	public Queue getInput() {
		return inputQueue;
	}
	
	public Queue getOutput() {
		return outputQueue;
	}
	
	
	
}
