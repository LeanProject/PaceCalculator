import java.util.Scanner;

class PaceCalculator {
    
    /********************************************/
    /* This method converts the input to double */
    /********************************************/
    static double convertInputTimeToMinutes(String string) {

        double timeInMinutes = 0;
        String hoursString = string.substring(0, 2);
        String minutesString = string.substring(3, 5);
        String secondsString = string.substring(6, 8);;
        double hoursDouble = 0;
        double minutesDouble = 0;
        double secondsDouble = 0;

       // Check if input is valid
        if (string.length() != 8) {
            System.out.println("Error in input. Use this format:  hh:mm:ss");
        }

        // Convert hours, minutes and seconds to variables we calculate on
        try {
            hoursDouble = Double.parseDouble(hoursString);
            minutesDouble = Double.parseDouble(minutesString);
            secondsDouble = Double.parseDouble(secondsString);
        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }
        
        // Convert time intered to muntes
        timeInMinutes = (hoursDouble * 60) + minutesDouble + (secondsDouble/60);
        
         // Let's transform the input type hh:mm:ss til seconds
        return timeInMinutes; 
    }

    /******************************************************************/
    /* This method calculates the pace for the entered finishing time */
    /******************************************************************/
    static double requiredPace(double time) {

        // Let´s calculate the pace required
        double distance = 42.195;

        double pace = 0;

        pace = time / distance;

        return pace;
    }

    static String convertPaceToString(Double paceEntered) {

        String paceInString;
        String minutes;
        String seconds;

        paceInString = String.valueOf(paceEntered);

        minutes = paceInString.substring(0,1);
    
        seconds = paceInString.substring(2,4);

        Integer m = Integer.parseInt(minutes);
        Double s = Double.parseDouble(seconds);

        //Convert seconds to time format
        s = s/100;
        s = s * 60;
        int iSec = s.intValue();

        paceInString = (String.valueOf(m) + ":" + String.valueOf(iSec));

        return paceInString; 
    }

    public static void main(String[] args) {

        double myProjectedTime = 0;
        String calculatedPace;

        // An object for the finishin time for a marathon is created
        Scanner finishingTimeEntered = new Scanner(System.in);

        // We need the finishing time for a marathon in order to calculated the pace required
        System.out.println("Enter your projected finishing time on marathon:");

        // Read the users projected finishing time
        String projectedFinishingTime = finishingTimeEntered.nextLine();

        myProjectedTime = convertInputTimeToMinutes(projectedFinishingTime);

        calculatedPace = convertPaceToString(requiredPace(myProjectedTime));

        System.out.println(calculatedPace + " is the required pace for finishing a marathon at " + projectedFinishingTime);

    }
}