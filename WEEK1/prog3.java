import java.util.Random;

public class prog3 {
    public static void main(String[] args) {
        int teamSize = 10;
        double[] heights = new double[teamSize];
        double[] weights = new double[teamSize];
        
        Random random = new Random();
        
        for (int i = 0; i < teamSize; i++) {
            // Generate random heights between 1.50m and 2.00m
            heights[i] = 1.50 + (random.nextDouble() * 0.50);
            // Generate random weights between 50kg and 120kg
            weights[i] = 50 + (random.nextDouble() * 70);
        }
        
        printWellnessReport(heights, weights);
    }

    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi <= 24.9) {
            return "Normal";
        } else if (bmi <= 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("Person | Height (m) | Weight (kg) | BMI | Status");
        System.out.println("--------------------------------------------------");
        
        for (int i = 0; i < heights.length; i++) {
            double height = heights[i];
            double weight = weights[i];
            double bmi = weight / (height * height);
            String status = getBmiStatus(bmi);
            
            System.out.printf("Person %-2d — Height: %.2f m, Weight: %.2f kg | BMI: %.2f | Status: %s\n", 
                    (i + 1), height, weight, bmi, status);
        }
    }
}
