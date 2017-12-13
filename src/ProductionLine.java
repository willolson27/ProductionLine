import java.util.LinkedList;
import java.util.Queue;

public class ProductionLine {

	private Queue<Disk> inputQueue;
	private Queue<Tower> outputQueue;
	private Tower robotTower;
	
	private int i = 0;
	
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
	 * @method - unloadRobot
	 */
	public void unloadRobot () {
		
		Tower outputTower = new Tower();
		while (robotTower.top() != null) {
			Disk d = robotTower.pop();
			outputTower.push(d);
		}
	//	outputTower.flip();
		outputQueue.add(outputTower);
		
	}
	
	/**
	 * 
	 * @username - willolson27
	 * @date - Dec 7, 2017
	 * @method - process
	 * 		-takes the next value in the inputQueue and processes whether it should be placed on the robot or
	 * 		if the robot should be unloaded
	 */
	public void process() {
		while (!inputQueue.isEmpty()) {
			Disk d = inputQueue.peek();
			if (robotTower.isEmpty()) {
				d = inputQueue.remove();
				robotTower.push(d);
				i++;
			}
			else if (robotTower.top().compareTo(d) <= 0) {
				d = inputQueue.remove();
				robotTower.push(d);
			}
			else
				unloadRobot();	
		}
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
	
	public Queue<Disk> getInput() {
		return inputQueue;
	}
	
	public Queue<Tower> getOutput() {
		return outputQueue;
	}
	
	
	
}
