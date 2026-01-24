import java.util.Scanner;

/**
 * Instructions:
 * - Complete the WeeklyData.java class first.
 * - Use this App class to collect user input and test your WeeklyData methods.
 * - Follow all TODOs carefully.
 * - Do NOT hard-code values — use loops and method calls.
 */
public class App {

    public static void main(String[] args) {

        // TODO 1: Create a Scanner for user input
        // -------------------------------------------------------
        Scanner scanner = new Scanner(System.in);


        // TODO 2: Give information about your program
        //         Ask the user about their goals (if applicable)
        // -------------------------------------------------------
        System.out.println("=================================================");
        System.out.println("  Welcome to the Running Workout Time Tracker!");
        System.out.println("=================================================");
        System.out.println("\nThis program will help you analyze your running");
        System.out.println("workout times for a week of training.\n");
        System.out.println("What is your running goal for the week?");
        System.out.println("(Examples: 40 minutes average, 5K pace, etc.)\n");
        System.out.print("Your goal: ");
        String userGoal = scanner.nextLine();
        System.out.println();


        // TODO 3: Create an array to hold 7 days of data
        //         Use an appropriate data type (int or double)
        //         Name the array weekData
        // -------------------------------------------------------
        double[] weekData = new double[7];


        // TODO 4: Use a for loop to collect data for each day of the week
        //         Prompt example:
        //         "Enter <data type> for day X: "
        //
        //         Include input validation:
        //         - Use a while loop to prevent negative values
        //         - Re-prompt if the value is invalid
        // -------------------------------------------------------
        String[] dayNames = {"Monday", "Tuesday", "Wednesday", "Thursday", 
                             "Friday", "Saturday", "Sunday"};
        
        System.out.println("Enter your running workout time (in minutes) for each day.");
        System.out.println("(Enter 0 if you didn't run that day)\n");
        
        for (int i = 0; i < weekData.length; i++) {
            boolean validInput = false;
            
            while (!validInput) {
                System.out.print(dayNames[i] + ": ");
                
                // Check if input is a valid number
                if (scanner.hasNextDouble()) {
                    double input = scanner.nextDouble();
                    
                    // Validate that the value is not negative
                    if (input >= 0) {
                        weekData[i] = input;
                        validInput = true;
                    } else {
                        System.out.println("Error: Please enter a non-negative value.");
                    }
                } else {
                    System.out.println("Error: Please enter a valid number.");
                    scanner.nextLine(); // Clear the invalid input
                }
            }
        }
        scanner.nextLine(); // Clear the newline after the last double input
        System.out.println();


        // TODO 5: Create a WeeklyData object
        //         Pass the weekData array into the constructor
        // -------------------------------------------------------
        WeeklyData runningData = new WeeklyData(weekData);


        // TODO 6: Display the results of the analysis
        //         Call methods from WeeklyData to display:
        //         - Total
        //         - Average
        //         - Minimum
        //         - Maximum
        //
        //         Use clear labels and formatted output if needed
        // -------------------------------------------------------
        System.out.println("=================================================");
        System.out.println("         Weekly Running Analysis Summary");
        System.out.println("=================================================\n");
        
        System.out.printf("Total Minutes Run This Week:   %.2f minutes%n", 
                         runningData.getTotal());
        System.out.printf("Average Minutes Per Day:       %.2f minutes%n", 
                         runningData.getAverage());
        System.out.printf("Longest Workout:               %.2f minutes%n", 
                         runningData.getMax());
        System.out.printf("Shortest Workout:              %.2f minutes%n", 
                         runningData.getMin());
        System.out.println();


        // TODO 7: Display the full week of data
        //         Use the toString() method from WeeklyData
        // -------------------------------------------------------
        System.out.println("-------------------------------------------------");
        System.out.println("Daily Breakdown:");
        System.out.println("-------------------------------------------------");
        System.out.print(runningData.toString());
        System.out.println();


        // TODO 8: Give the user insights about their week
        //         --> "You need to drink more water next week!"
        //         --> "You were very hydrated this week!"
        //         --> etc.
        // -------------------------------------------------------
        System.out.println("=================================================");
        System.out.println("              Personalized Insights");
        System.out.println("=================================================\n");
        
        double totalMinutes = runningData.getTotal();
        double averageMinutes = runningData.getAverage();
        double maxMinutes = runningData.getMax();
        double minMinutes = runningData.getMin();
        
        // Provide meaningful insights based on the data
        if (totalMinutes == 0) {
            System.out.println("It looks like you didn't run this week.");
            System.out.println("Next week, try to get moving! Even short runs count!");
        } else if (totalMinutes < 60) {
            System.out.println("You ran a total of " + String.format("%.2f", totalMinutes) + 
                             " minutes this week.");
            System.out.println("That's a great start! Try to increase your volume");
            System.out.println("by 10% next week for better fitness gains.");
        } else if (totalMinutes < 150) {
            System.out.println("Nice effort! You got in " + String.format("%.2f", totalMinutes) + 
                             " minutes of running.");
            System.out.println("You're on a good pace. Keep up the consistency!");
        } else if (totalMinutes < 300) {
            System.out.println("Excellent work! You logged " + String.format("%.2f", totalMinutes) + 
                             " minutes this week.");
            System.out.println("You're maintaining great fitness levels.");
            System.out.println("Consider varying your training intensity next week.");
        } else {
            System.out.println("Outstanding dedication! You ran " + String.format("%.2f", totalMinutes) + 
                             " minutes this week.");
            System.out.println("Make sure to balance hard workouts with proper recovery!");
        }
        
        // Additional insight about consistency
        if (maxMinutes > 0 && minMinutes > 0) {
            double difference = maxMinutes - minMinutes;
            if (difference < 5) {
                System.out.println("Your workouts were very consistent this week - great!");
            } else if (difference < 15) {
                System.out.println("Your training had some variety, which is healthy.");
            } else {
                System.out.println("You had quite a range in workout times. Consider");
                System.out.println("building a more structured training plan.");
            }
        }
        
        // Motivational closing
        System.out.println("\nYour goal was: " + userGoal);
        System.out.println("Keep pushing toward that goal next week!");
        System.out.println("\n=================================================");
        System.out.println("          Thanks for using Running Tracker!");
        System.out.println("=================================================\n");
        
        scanner.close();

    }
}
