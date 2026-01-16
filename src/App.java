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

        // -------------------------------------------------------------
        // TODO 1: Create a Scanner for user input
        // -------------------------------------------------------------
        Scanner scanner = new Scanner(System.in);

        // -------------------------------------------------------------
        // TODO 2: Give information about your program
        //         Ask the user about their goals (if applicable)
        // -------------------------------------------------------------
        System.out.println("This program collects and analyzes your weekly data! \nOn a scale from 1-5, how would you rate your mood this week?");

        // -------------------------------------------------------------
        // TODO 3: Create an array to hold 7 days of data
        //         Use an appropriate data type (int or double)
        //         Name the array weekData
        // -------------------------------------------------------------
        int[] weekData = new int[7];

        // -------------------------------------------------------------
        // TODO 4: Use a for loop to collect data for each day of the week
        //         Prompt example:
        //         "Enter <data type> for day X: "
        //
        //         Include input validation:
        //         - Use a while loop to prevent negative values
        //         - Re-prompt if the value is invalid
        // -------------------------------------------------------------
        for (int i = 0; i < weekData.length; i++) {
            System.out.print("Enter your mood rating for day " + (i + 1) + " (On a scale of 1-5): ");
            int moodInput = scanner.nextInt();
            while (moodInput < 1 || moodInput > 5) {
                System.out.print("Invalid input. Please enter a mood rating between 1 and 5 for day " + (i + 1) + ": ");
                moodInput = scanner.nextInt();
            }
            weekData[i] = moodInput;
        }

        // -------------------------------------------------------------
        // TODO 5: Create a WeeklyData object
        //         Pass the weekData array into the constructor
        // -------------------------------------------------------------
        WeeklyData weeklyData = new WeeklyData(weekData);

        // -------------------------------------------------------------
        // TODO 6: Display the results of the analysis
        //         Call methods from WeeklyData to display:
        //         - Total
        //         - Average
        //         - Minimum
        //         - Maximum
        //
        //         Use clear labels and formatted output if needed
        // -------------------------------------------------------------
        System.out.println("\nWeekly Data Analysis:");
        System.out.println("Total Mood Score: " + weeklyData.getTotal());
        System.out.printf("Average Mood Score: %.2f%n", weeklyData.getAverage());
        System.out.println("Minimum Mood Score: " + weeklyData.getMin());
        System.out.println("Maximum Mood Score: " + weeklyData.getMax());  

        // -------------------------------------------------------------
        // TODO 7: Display the full week of data
        //         Use the toString() method from WeeklyData
        // -------------------------------------------------------------
        System.out.println("\nFull Week Data: " + weeklyData.toString());

        // -------------------------------------------------------------
        // TODO 8: Give the user insights about their week
        //         --> "You need to drink more water next week!"
        //         --> "You were very hydrated this week!"
        //         --> etc.
        // -------------------------------------------------------------
        if (weeklyData.getAverage() >= 4) {
            System.out.println("Great job! You had a very positive week!");
        } else if (weeklyData.getAverage() >= 2) {
            System.out.println("Not bad, but there's always room for improvement next week.");
        } else {
            System.out.println("It seems like you had a tough week. Consider focusing on self-care next week.");
        }

    }
}
