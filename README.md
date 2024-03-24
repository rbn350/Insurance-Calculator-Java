# Insurance-Calculator_Java

**Program Overview**:

- The InsuranceCalculator program is designed to calculate a patient's Body Mass Index (BMI) and determine their BMI category, which is then used to ascertain their insurance payment category. It accepts user input for patient details including name, weight, height, and date of birth. The program calculates the BMI based on weight and height, determines the BMI category, and maps this category to an insurance payment category. Patient details along with the calculated BMI category and insurance payment category are saved to a file named patient_info.txt.

**Features**:

- _Calculate BMI_: Calculates the BMI based on the patient's weight and height.
- _Determine BMI Category_: Determines whether the patient's BMI falls under Underweight, Normal, Overweight, or Obesity categories.
- _Determine Insurance Category_: Determines the insurance payment category (Low, High, Highest) based on the BMI category.
- _Save Patient Details_: Saves the patient's name, date of birth, BMI category, and insurance payment category to a file.

**How to Run**:

- Ensure you have Java installed on your system.
- Save the program file with a .java extension.
- Compile the program using javac InsuranceCalculator.java.
- Run the program using java InsuranceCalculator.
- Follow the on-screen prompts to enter patient details. Enter Q to quit the application.
- The program will then calculate the BMI, determine the BMI and insurance payment categories, and display this information. The details will also be saved to patient_info.txt.

**Error Handling**:

_Input Mismatch Exception_: If the user enters an incorrect data type, the program will prompt the user to enter the correct data type.
_IO Exception_: If there is an error while writing to the file, the program will notify the user.

**Closing Resources**:

- The program ensures that the scanner and file writer resources are closed appropriately to prevent resource leaks.

**Interface and Implementation**:

- The program implements the PatientInterface interface, which defines methods for calculating BMI, determining BMI category, and determining insurance payment category based on the BMI category.
