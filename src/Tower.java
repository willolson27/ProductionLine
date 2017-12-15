import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 
 * @author willolson27
 * Date Due -  December 14, 2017
 *
 */

public class Tower extends Stack<Disk>{

	
	/**
	 * creates a new tower with no disks
	 * 
	 */
	public Tower() {
		
	}
	
	/**
	 * used to get the top value of the Tower, implemented to avoid errors
	 * @return Disk located at top
	 * 
	 */
	public Disk top() {
		if (this.isEmpty() == false)
			return this.peek();
		return null;
	}
	
	/**
	 * flips over this Tower
	 * 
	 * 
	 */
	public void flip() {
		
		//Create a queue for temporary storage of the disks
		Queue<Disk> a = new LinkedList<Disk>();
		while (!this.isEmpty()) {
			a.add(this.peek());
			this.pop();
			}
		//Add the disks from the queue back into the stack
		while (!a.isEmpty()) {
			this.push(a.peek());
			a.remove();
			}
	
	}
	
	/**
	 * returns a representation of this Tower in lines of asterisks
	 * @return String representation of this Tower
	 * 
	 */
	public String toString() {
		Tower copy = new Tower();
		String toOutput = "";
		Tower a = (Tower) this.clone();
		while (!a.isEmpty())
			copy.push(a.pop());
		copy.flip();
	
		while (copy.isEmpty() == false)
			toOutput += copy.pop() + "\n";
		return toOutput;
	}
	
}
