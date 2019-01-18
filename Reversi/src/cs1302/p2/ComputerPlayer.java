package cs1302.p2;

/**
 * This class represents a ComputerPlayer.
 *
 * @author JOSEPH KWON <josephsk@uga.edu>
 */
public abstract class ComputerPlayer extends Player {
	
	/**
	 * Creates a time delay for ComputerPlayer class and its sub classes for a certain amount of time in milliseconds
	 * @param millis the number of milliseconds in delay
	 */
	public void createTimeDelay(int millis) {
		try {
			Thread.sleep(millis);
		} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
	
}
