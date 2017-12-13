import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ProductionLineTest {

	private final static String INPUT = "Input disks";
	private final static String OUTPUT = "output towers";
	
	/**
	 * 
	 * @user willolson27
	 * @date December 12, 2017
	 * @method printQueue
	 *
	 * @param q
	 */
	public static void printQueue (Queue<Disk> q) {
		
		
		Queue<Disk> reversed  = new LinkedList<Disk>();
		Stack<Disk> temp = new Stack<Disk>();
		while (q.peek() != null) {
			temp.push(q.remove());
		}
		while (temp.isEmpty() == false) {
			reversed.add(temp.pop());
		}
		for (Disk disk: reversed) {
			System.out.print(disk + "\t");
		}
	}
	
	/**
	 * 
	 */
	public static void go() {
		
		
		
		ProductionLine p = new ProductionLine();
		
		int[] nums = {1,7,3,9,11,12,4,4,4,4,4,4,3,5,1,2,2,22,4465};
		
		for (int a : nums)
			p.addDisk(new Disk(a));
		
		//Print out the input queue
		
		SOP(INPUT);
		Queue<Disk> inputCopy = new LinkedList<Disk>(p.getInput());
		printQueue(inputCopy);
		
		p.process();
			
		//Print the output results
		SOP("\n" + OUTPUT);
		Queue<Tower> output = p.getOutput();
		
		while(output.isEmpty() == false)
			SOP(output.remove() + "");
		
		System.out.println("done");
	 
	}
	
	
	public static void main (String [] args) {
		
		go();
		
	}
	
	public static void SOP (String s) {
		System.out.println(s);
	}
	
}
