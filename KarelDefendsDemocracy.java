/* Filename: KarelDefendsDemocracy.java
	pick beepers 
*/
package week1;
import stanford.karel.*;

public class KarelDefendsDemocracy extends SuperKarel {

	public void run() {
		move();
		while(frontIsClear()) {
			if(beepersPresent()) { 
				move();
				move();
			}
			if(noBeepersPresent()) {
				pickBeeperTop();		//moves up and picks beeper from top if any
				pickBeeperBottom();		//from top moves to bottom & picks beeper if any
				moveToNextBallotRect();	//from bottom moves to center & then to next ballot rectangle
				if(frontIsClear()) {
					move();
				}
			} 
		}
	}
	
	//Function to check and pick beepers from top
	private void pickBeeperTop() {
		turnLeft();
		while(frontIsClear()) {
			move();
			while(beepersPresent()) {	//while loop so that n number of beepers can be picked
				pickBeeper();
			}
		}
		turnAround();
	}
	
	//function to check and pick beepers from bottom
	private void pickBeeperBottom() {
		while(frontIsClear()) {
			move();
			while(beepersPresent()) {
				pickBeeper();
			}
		}
		turnAround();
	}
	
	//function to move to next ballot
	private void moveToNextBallotRect() {
		while(rightIsBlocked()) {		//while loop to consider ballot rectangles of different height
			move();
		}
		turnRight();
		move();
	}
}					
					
					
					
				
					