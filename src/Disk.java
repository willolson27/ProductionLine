
public class Disk implements Comparable {

	private int radius;
	
	/**
	 * 
	 * @method - Disk
	 * 		-creates a new Disk with given radius r
	 * @param r - given radius to be set to this radius
	 */
	public Disk (int r) {
		radius = r;
	}

	/**
	 * 
	 * @param otherD - other disk to be compared t o
	 * @return - integer difference between this radius and another radius
	 */
	public int compareTo(Disk otherD) {
		return (this.getRadius() - otherD.getRadius());
	}

	/**
	 * 
	 * @return the radius of this disk
	 */
	public int getRadius() {
		return radius;
	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public String toString() {
		String toOutput = "";
		for (int i = 0; i < radius; i++)
			toOutput += "*";
		return toOutput;
	}

	
}



