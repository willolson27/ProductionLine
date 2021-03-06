import java.util.LinkedList;
import java.util.Queue;
/**
 * 
 * @author willolson27
 * Date Due -  December 14, 2017
 *
 */
public class ProductionLine {

	//Create fields
	private Queue<Disk> inputQueue;
	private Queue<Tower> outputQueue;
	private Tower robotTower;
	
	
	/**
	 * creates a new ProductionLine object with a new inputQueue and new outputQueue
	 * @return new ProductionLine object
	 * 
	 */
	public ProductionLine() {
		
		inputQueue  = new LinkedList<Disk>();
		outputQueue  = new LinkedList<Tower>();
		robotTower = new Tower();
	}
	
	/**
	 * adds a given Disk to the input queue
	 * @param d - disk to be added
	 * 
	 */
	public void addDisk(Disk d) {
		
		inputQueue.add(d);
	
	}
	
	/**
	 * unloads the robot stack and puts it onto the output queue 
	 * 
	 */
	public void unloadRobot () {
		
		//Create an outputTower from what is on the robot and put it in the outputQueue
		Tower outputTower = (Tower) robotTower.clone();
		outputTower.flip();
		outputQueue.add(outputTower);
		
		//Unload the robot
		robotTower.clear();
	
	}
	
	/**
	 * runs through the input queue and processes each disk, deciding whether to put the disk on the robot or to empty the robot 
	 * 
	 */
	public void process() {
		
		while (!inputQueue.isEmpty()) {
			Disk d = inputQueue.peek();
			//Add to tower if it is empty
			if (robotTower.isEmpty()) {
				d = inputQueue.remove();
				robotTower.push(d);
			}
			//Add to tower if current disk is bigger than the one on the tower
			else if (robotTower.top().compareTo(d) <= 0) {
				d = inputQueue.remove();
				robotTower.push(d);
			}
			//unload the robot if the current disk is smaller than the one on the tower
			else
				unloadRobot();	
		}
		unloadRobot();
	}
	
	/**
	 * removes a tower from the outputQueue
	 * @return - Tower removed from the outputQueue
	 * 
	 */
	public Tower removeTower() {
		
		Tower t = outputQueue.remove();
		return t;
	}
	
	/**
	 * returns the inputQueue
	 * @return this ProductionLine's inputQueue
	 * 
	 */
	public Queue<Disk> getInput() {
		
		return inputQueue;
	
	}
	
	/**
	 * returns the outputQueue 
	 * @return this ProductionLine's outputQueue
	 * 
	 */
	public Queue<Tower> getOutput() {
		return outputQueue;
	}
	
	
	
}
