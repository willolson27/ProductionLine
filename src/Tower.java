import java.util.Stack;

public class Tower extends Stack<Disk>{

	private Stack<Disk> disks;
	
	/**
	 * 
	 * @method Tower
	 * 	- creates a new tower with no disks
	 */
	public Tower() {
		
	}
	
	
	public Disk top() {
		if (this.isEmpty() == false)
			return this.peek();
		return null;
	}
	
	public Stack<Disk> flip() {
		
		Stack<Disk> flipped = new Stack<Disk>();
		
		while (!this.isEmpty()) {
			flipped.push(this.pop());
		}
		
		
		return flipped;
	}
	
	public String toString() {
		Stack<Disk> copy = this;
		String toOutput = "";
		/*	Stack<Disk> reversed = flip(copy);
		while (reversed.isEmpty() == false)
				toOutput += reversed.pop() + "\n";
	*/
		while (copy.isEmpty() == false)
			toOutput += copy.pop() + "\n";
		return toOutput;
	}
	
}
