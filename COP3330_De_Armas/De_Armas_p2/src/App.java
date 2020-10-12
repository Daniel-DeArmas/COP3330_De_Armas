import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }

    public static double getUserHeight() {
        double heightInput=0;
        boolean doubleEntered=true;
        boolean isNegative=true;

        Scanner scan = new Scanner(System.in);

        do {
            try
            {
                System.out.println("Enter your height in inches: ");
                doubleEntered = false;
                heightInput = scan.nextDouble();

                if(heightInput>0){
                    isNegative = false;
                }else{
                    System.out.println("You cannot enter a negative number. Try Again.");
                    isNegative = true;
                }
            }
            catch (InputMismatchException e)
            {
                scan.next();
                doubleEntered = true;
                System.out.println("You didn't enter a number. Try Again.");
            }
        }while (doubleEntered || isNegative);

        System.out.println("You entered: "+ heightInput +" inches.");

        return heightInput;
    }

    public static double getUserWeight() {
        double weightInput=0;
        boolean doubleEntered=false;
        boolean isNegative=false;

        Scanner scan = new Scanner(System.in);

        do {
            try
            {
                System.out.println("Enter your weight in inches: ");
                doubleEntered = false;
                weightInput = scan.nextDouble();

                if(weightInput>0){
                    isNegative = false;
                }else{
                    System.out.println("You cannot enter a negative number. Try Again.");
                    isNegative = true;
                }
            }
            catch (InputMismatchException e)
            {
                scan.next();
                doubleEntered = true;
                System.out.println("You didn't enter a number. Try Again.");
            }
        }while (doubleEntered || isNegative);

        System.out.println("You entered: "+ weightInput +" pounds.");

        return weightInput;
    }

    public static Boolean moreInput() {
        Boolean continueInputting = true;
        String input = "Y";
        Boolean inputNotEntered = true;

        Scanner scan = new Scanner(System.in);

        while(inputNotEntered==true) {
            System.out.println("Enter \"Y\" if you choose to continue.");
            System.out.println("Enter \"N\" if you don't choose to continue.");

            input = scan.next();

            if (input.equals("Y")) {
                System.out.println("You have chosen to continue.");
                continueInputting = true;
                inputNotEntered=false;
            } else if (input.equals("N")) {
                System.out.println("You have chosen not to continue.");
                continueInputting = false;
                inputNotEntered=false;
            } else {
                System.out.println("Input is unacceptable. Try Again.");
            }
        }
        return continueInputting;
    }

    public static void displayBmiInfo(BodyMassIndex bmi) {
        System.out.println("The BMI of the data just entered is: " + bmi.bmi);
        System.out.println("The BMI Category of the data just entered is: " + bmi.category);
        System.out.println("");
    }

    public static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData) {
        Double avgBMI = 0.0;

        for(int i=0;i < bmiData.size();i++){
            avgBMI = avgBMI + bmiData.get(i).bmi;
        }

        avgBMI = avgBMI / bmiData.size();
        System.out.println("The average BMI of the data is: " + avgBMI);
    }

}
