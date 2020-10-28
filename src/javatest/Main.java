package javatest;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws BadBadValueException{
		Scanner sc = new Scanner(System.in);
		System.out.printf("Entrez la durée en seconde: ");
		int i= sc.nextInt();
		TimeDuration timeDuration=new TimeDuration(i);
		System.out.println(timeDuration.toString());
		System.out.println("Test: 6000 secondes c'est "+ new TimeDuration(6000));
		sc.close();
		
	}
}


class TimeDuration {
	int seconds;
	
	public TimeDuration(int pSeconds) throws BadBadValueException {
		if(pSeconds<0) {
			throw new BadBadValueException();
		}
	    this.seconds=pSeconds;
	  }
	
	public String toString(){
		int hours=seconds/3600;
		int minutes=(seconds-hours*3600)/60;
		int leftSeconds=seconds-hours*3600-minutes*60;
		String Hours=hours==0?"":hours+"h ";;
		String Minutes=minutes==0?hours==0?"":"0m ":minutes+"m ";
		String Seconds=leftSeconds==0?"0s":leftSeconds+"s";
		return Hours+""+Minutes+""+Seconds;
	}
	
	class RaceResults{
		String rfid;
		TimeDuration td;
		private HashMap<String, TimeDuration> raceResults = new HashMap<>();
		/*
		public RaceResults(String pRfid, TimeDuration pTd) {
			rfid=pRfid;
			td=pTd;
		}
		*/
		
		public void onNewResult(String tagNumber, TimeDuration resultTime) {
			 raceResults.put(tagNumber, resultTime);
		}
		
		public void printResults() {
			
		}
	}
	
	
	
}
