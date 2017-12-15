/**
 * 
 * @author willolson27
 * Date Due -  December 14, 2017
 *
 */

public class Disk implements Comparable {

	private final String EMPTY_DISK = "0";
	
	private int radius;
	
	/**
	 * creates a new Disk with given radius r
	 * @param r - given radius to be set to this radius
	 * 
	 */
	public Disk (int r) {
		radius = r;
	}

	/**
	 * compares the radius of this Disk and another Disk
	 * @param otherD - other disk to be compared t o
	 * @return - integer difference between this radius and another radius
	 * 
	 */
	public int compareTo(Disk otherD) {
		return (this.getRadius() - otherD.getRadius());
	}

	/**
	 * returns the radius of the disk
	 * @return the radius of this disk
	 * 
	 */
	public int getRadius() {
		return radius;
	}

	/**
	 * compares the radius of this Disk and another Object, if that object is a Disk
	 * @param o1 - Another object, is cast to Disk if possible for comparison
	 * @return - integer difference between this radius and another radius
	 * 
	 */
	@Override
	public int compareTo(Object o1) {
		Disk otherD = new Disk(0);
		try {
			otherD = (Disk) o1;
		}
		catch (ClassCastException e) {
			return -1;
		}
		return (this.getRadius() - otherD.getRadius());
	}
	
	/**
	 * returns a String representation of this Disk in asterisks
	 * @return String representation of this Disk
	 * 
	 */
	public String toString() {
		String toOutput = "";
		if (radius == 0)
			return EMPTY_DISK;
		for (int i = 0; i < radius; i++)
			toOutput += "*";
		return toOutput;
	}

	
}



