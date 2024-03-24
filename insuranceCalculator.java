import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

// Define the PatientInterface related to patient information and calculations
interface PatientInterface {
    double calculateBMI(double weight, double height);
    String determineBMICategory(double bmi);
    String determineInsuranceCategory(String bmiCategory);
}
// Main class implementing the PatientInterface for calculating insurance based on BMI
public class InsuranceCalculator implements PatientInterface {

    // Main method - entry point of the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner object for reading user input
        String filePath = "patient_info.txt"; // File path where patient information will be saved
        InsuranceCalculator calculator = new InsuranceCalculator(); // Creating an instance of InsuranceCalculator

        // Try resources to handle file writing
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            while (true) {  // Infinite loop to continuously accept user input until 'Q' is entered

                try {
                    System.out.println("\nProvide patients name or enter 'Q' to close application:");
                    String name = scanner.nextLine();
                    if ("q".equalsIgnoreCase(name)) {
                        System.out.println("\nSee you next time!"); break;  // Exit loop if user enters 'Q'
                    }

                    System.out.println("\nPatients weight[kg]:");
                    double weight = scanner.nextDouble(); // Read weight

                    System.out.println("\nPatients height[m]:");
                    double height = scanner.nextDouble(); // Read height
                    scanner.nextLine(); // Consume newline left over

                    System.out.println("\nPatients DOB [Date of Birth YYYY-MM-DD]:");
                    String dateOfBirth = scanner.nextLine(); // Read DOB

                    // Calculate BMI and determine BMI and insurance categories
                    double bmi = calculator.calculateBMI(weight, height);
                    String bmiCategory = calculator.determineBMICategory(bmi);
                    String insuranceCategory = calculator.determineInsuranceCategory(bmiCategory);

                    // Display patient details
                    System.out.println("\nName: " + name + ", \nDate of Birth: " + dateOfBirth + ", \nBMI Category: " + bmiCategory + "\nInsurance Payment Category: " + insuranceCategory);

                    // Write patient details to file
                    writer.write("\nName: " + name + ", \nDate of Birth: " + dateOfBirth + ", \nBMI Category: " + bmiCategory + ", \nInsurance Payment Category: " + insuranceCategory);
                    writer.newLine();   // Move to next line after writing details
                    System.out.println("\nInformation saved."); // Confirmation for data being saved
                } catch (InputMismatchException e) {
                    System.err.println("Input error. Please enter the correct data types.");    // Handle mismatch input exceptions
                    scanner.next(); // Clear scanners buffer to prevent infinite loop
                }
            }
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file."); // Handle IO exceptions
            e.printStackTrace();
        } finally {
            scanner.close();    // Ensure scanner is closed to prevent resource leak
        }
    }

    // Method to calculate BMI
    @Override
    public double calculateBMI(double weight, double height) {
        return weight / (height * height);
    }

    // Method to determine the category of BMI
    @Override
    public String determineBMICategory(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi <= 24.9) return "Normal";
        else if (bmi <= 29.9) return "Overweight";
        else return "Obesity";  // Determine BMI category based on BMI value
    }

    // Method to determine insurance payment category based on BMI category
    @Override
    public String determineInsuranceCategory(String bmiCategory) {
        switch (bmiCategory) {  // Map BMI category to insurance payment category
            case "Underweight":
            case "Normal":
                return "Low";       // Low insurance payment for underweight and normal weight
            case "Overweight":
                return "High";      // High insurance payment for overweight
            case "Obesity":
                return "Highest";   // Highest insurance payment for obesity
            default:
                return "Unknown";   // Unknown category for any other cases
        }
    }
}
