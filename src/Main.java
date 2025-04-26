import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int employeeId;
        float hoursWorked;
        float hourlyRate
        float grossPay;
        String employeeIds;
        String employeeHoursWorked;
        String employeeHourlyRates;
        boolean isValid = false;
        ArrayList<float[]> employees = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while(!isValid){
            System.out.println("Hello! Please enter the list of employee IDs you would like to generate gross pay for. Enter the data as a comma separated list of integers.");
            employeeIds = scanner.nextLine();
            String[] employeeIdArray = employeeIds.split(",");
            System.out.println("Done taking your employee IDs! Now, please enter another comma separated list of hours worked associated with the same order you entered employee IDs");
            employeeHoursWorked = scanner.nextLine();
            String[] employeeHoursWorkedArray = employeeHoursWorked.split(",");
            System.out.println("And lastly, please enter a comma separated list of hourly rates, again associated with the same order of employee IDs");
            employeeHourlyRates = scanner.nextLine();
            String[] employeeHourlyRatesArray = employeeHourlyRates.split(",");
            System.out.println("Now, please wait while the information is processed...");
            try {
                for(int i = 0; i < employeeIdArray.length; i++){
                    float[] employee = {Float.parseFloat(employeeIdArray[i]),
                            Float.parseFloat(employeeHourlyRatesArray[i]), Float.parseFloat(employeeHoursWorkedArray[i])};
                    employees.add(employee);
                }
            } catch (Exception ex){
                System.out.println("Error occurred, please make sure you entered the correct formatting! Restarting program." + "\n");
            }
            isValid = true;
        }
        System.out.println("Printing your employee data sheet!");
        System.out.printf("%-13s %-23s %-22s %-20s\n", "Employee ID |", "Employee Hours Worked |", "Employee Hourly Rate |", "Employee Gross Pay |");
        for(float[] employee : employees){
            employeeId = (int) employee[0];
            hourlyRate = employee[1];
            hoursWorked = employee[2];
            if(hoursWorked > 40.0){
                grossPay = hourlyRate * 40;
                grossPay = grossPay + (((hoursWorked - 40) * hourlyRate)/2);
            } else {
                grossPay = hoursWorked * hourlyRate;
            }
            System.out.printf("%-13s %-23s %-22s %-20s\n", employeeId, hoursWorked, hourlyRate, grossPay);
        }
    }
}