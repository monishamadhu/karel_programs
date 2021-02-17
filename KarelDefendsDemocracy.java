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
				turnLeft();
				pickBeeperTopBottom();		//moves up and picks beeper from top if any
				pickBeeperTopBottom();		//from top moves to bottom & picks beeper if any
				moveToNextBallotRect();	   //from bottom moves to center & then to next ballot rectangle
				if(frontIsClear()) {
					move();
				}
			} 
		}
	}
	
	//function to check and pick beepers 
	private void pickBeeperTopBottom() {
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
					
					
					
				
					