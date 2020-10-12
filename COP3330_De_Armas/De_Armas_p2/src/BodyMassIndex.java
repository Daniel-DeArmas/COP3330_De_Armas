import java.util.ArrayList;

public class BodyMassIndex {
    double bmi;
    String category;

    public BodyMassIndex(double height, double weight) {
        calcBMI(height, weight);
        categoryBMI(height, weight);
    }

    public double calcBMI(double height, double weight){
        return this.bmi = (703*weight)/(height*height);
    }

    public String categoryBMI(double height, double weight) {
        double BMI = (703*weight)/(height*height);

        if(BMI < 18.5){
            return this.category = "Underweight";
        }else if(BMI < 25){
            return this.category = "Normal weight";
        }else if(BMI < 30){
            return this.category = "Overweight";
        }else{
            return this.category = "Obesity";
        }

    }
}
