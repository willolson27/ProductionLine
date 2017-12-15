import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * 
 * @author willolson27
 * Date Due -  December 14, 2017
 */

public class ProductionLineTest {

	//FIELDS
	
	//Constants used to replace String literals
	private final static String INPUT = "Input disks";
	private final static String OUTPUT = "output towers";
	private final static String OUTPUT_TXT = "output.txt";
	private final static String FILE_ERROR = "ERROR: no output file found";
	private final static String DONE = "done";
	private final static String ASK = "enter a bunch of disk lengths";
	private final static String EMPTY_ERROR = "no input found";

	
	/**
	 * takes in a queue, reverses it, and returns a String of its concatenated values
	 *		-the queue needs to be revered because it is processed in a FIFO order, but the representation
	 *		 of the class needs to last value in the queue to be printed first
	 * @param q - queue to be reversed to a string
	 * 
	 */
	public static String printQueue (Queue<Disk> q) {
		
		//create temporary Stack to store the values of q so it is not changed
		Stack<Disk> temp = new Stack<Disk>();
		while (q.peek() != null) {
			temp.push(q.remove());
		}
		
		//Create a reversed queue
		Queue<Disk> reversed  = new LinkedList<Disk>();
		while (temp.isEmpty() == false) {
			reversed.add(temp.pop());
		}
		
		//Add the String values of the new queue to a String and return that 
		String toOutput = "";
		for (Disk disk: reversed) {
			toOutput += (disk + "\t");
		}
		
		return toOutput;
	}
	
	/**
	 * tests the class ProductionLine
	 * @throws IOException 
	 * 
	 */
	public static void go(int[] nums) throws IOException {
		
		
		
		//Create local fields
		ProductionLine p = new ProductionLine();
		PrintWriter out = new PrintWriter(new FileWriter(OUTPUT_TXT));
		
		
		//add disks to a productionLine
		for (int a : nums)
			p.addDisk(new Disk(a));
		
		//Print out the input queue		
		out.println(INPUT + "\n");
		Queue<Disk> inputCopy = new LinkedList<Disk>(p.getInput());
		out.println(printQueue(inputCopy));
		
		//Run through and process every disk in the ProductionLine
		p.process();
			
		
		//Print the output results
		out.println("\n" + OUTPUT + "\n");
		Queue<Tower> output = new LinkedList<Tower>();
		
		while(p.getOutput().isEmpty() == false)
			output.add(p.removeTower());
		while(output.isEmpty() == false)
			out.println(output.remove() + "");
		
		
		//Finish
		SOP(DONE);
		out.close();
		
	}
	
	/**
	 * calls any methods needed to test ProductionLine
	 * @param args - given arguments for the project
	 * 
	 */
	public static void main (String [] args) {
	
		
		
		
		Scanner input = new Scanner(System.in);
		SOP(ASK);
		
		String s = input.nextLine();
		input.close();
		String [] arr = s.split("\\W+");
		int[] nums = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
		 if (!arr[i].equals(""))	
			nums[i] = Integer.parseInt(arr[i]);
		 else {
			 SOP(EMPTY_ERROR);
			 System.exit(0);
		 }
		}

		
		
	//run modular test class	
		try {
			go(nums);
		} catch (IOException e) {
			SOP(FILE_ERROR);
		} 
//		testExtras();
	}
	
	/**
	 * takes in a given String and prints it to the console to save repetitive code
	 * @param s - String value to be printed
	 * 
	 */
	public static void SOP (String s) {
		System.out.println(s);
	}
	
	/**
	 * used to test certain methods to get them working
	 *
	 */
	public static void testExtras() {
		
		//test how flip() should work
		Tower t = new Tower();
		int[] nums = {1,2,3};
		for (int i : nums)
			t.push(new Disk(i));
		SOP(t + "");
		t.flip();
		SOP(t + "");
	}
	
}
