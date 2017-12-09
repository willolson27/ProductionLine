import java.util.Stack;

public class Tower {

	private Stack<Disk> disks;
	
	/**
	 * 
	 * @method Tower
	 * 	- creates a new tower with no disks
	 */
	public Tower() {
		disks = new Stack<Disk>();
	}
	
	public Stack getDisks() {
		return disks;
		
	}
	
	public void addDisk(Disk d) {
		disks.push(d);
	}
	
	public Disk removeDisk() {
		return disks.pop();
	}
	
	public Disk top() {
		return disks.peek();
	}
	
}
