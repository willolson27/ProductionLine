import java.util.LinkedList;
import java.util.Queue;

public class ProductionLineTest {

	public static void go() {
		
		
		
		ProductionLine p = new ProductionLine();
		
		Disk d = new Disk(4);
		Disk d2 = new Disk(2);
		Disk d3 = new Disk(6);
		Disk d4 = new Disk(1);
		p.addDisk(d);
		p.addDisk(d2);
		p.addDisk(d3);
		p.addDisk(d4);
		
		
		while (p.getInput().isEmpty() == false) {
			p.process();
			
		}
		
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
