import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ProductionLineTest {

	private final static String INPUT = "Input disks";
	private final static String OUTPUT = "output towers";
	
	
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
	
	public static void go() {
		
		
		
		ProductionLine p = new ProductionLine();
		
		Disk d = new Disk(4);
		Disk d2 = new Disk(2);
		Disk d3 = new Disk(6);
		Disk d4 = new Disk(1);
		Disk d5 = new Disk(5);
		Disk d6 = new Disk(3);
		Disk d7 = new Disk(9);
		p.addDisk(d);
		p.addDisk(d2);
		p.addDisk(d3);
		p.addDisk(d4);
		p.addDisk(d5);
		p.addDisk(d6);
		p.addDisk(d7);
		
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
