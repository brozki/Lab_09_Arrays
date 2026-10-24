import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Random rnd = new Random();

        // Step 1: declare the array (100 int values)
        int[] dataPoints = new int[100];

        // Step 2: fill with random values from 1 to 100
        for (int i = 0; i < dataPoints.length; i++)
        {
            dataPoints[i] = rnd.nextInt(100) + 1;
        }

        // Step 3: display values on one line separated by " | "
        System.out.println("The values in dataPoints are:");
        for (int i = 0; i < dataPoints.length; i++)
        {
            System.out.print(dataPoints[i]);
            if (i < dataPoints.length - 1)
            {
                System.out.print(" | ");
            }
        }
        System.out.println();

        // Step 4: sum and average (average stored as a double to keep precision)
        int sum = 0;
        for (int i = 0; i < dataPoints.length; i++)
        {
            sum += dataPoints[i];
        }
        double average = (double) sum / dataPoints.length;
        System.out.println("The sum of the random array dataPoints is: " + sum);
        System.out.printf("The average of the random array dataPoints is: %.2f%n", average);

        // Step 5: get a value from the user
        int userValue = SafeInput.getRangedInt(in, "Enter an integer to search for", 1, 100);

        // Step 6: count how many times the value appears
        int count = 0;
        for (int i = 0; i < dataPoints.length; i++)
        {
            if (dataPoints[i] == userValue)
            {
                count++;
            }
        }
        System.out.println("The value " + userValue + " was found " + count + " time(s) in the array.");

        // Step 7: find the first position, then break
        int searchValue = SafeInput.getRangedInt(in, "Enter another integer to search for", 1, 100);
        int foundIndex = -1;
        for (int i = 0; i < dataPoints.length; i++)
        {
            if (dataPoints[i] == searchValue)
            {
                foundIndex = i;
                break;
            }
        }
        if (foundIndex != -1)
        {
            System.out.println("The value " + searchValue + " was found at array index " + foundIndex + ".");
        }
        else
        {
            System.out.println("The value " + searchValue + " was not found in the array.");
        }

        // Step 8: minimum and maximum in a single loop
        int min = dataPoints[0];
        int max = dataPoints[0];
        for (int i = 1; i < dataPoints.length; i++)
        {
            if (dataPoints[i] < min)
            {
                min = dataPoints[i];
            }
            if (dataPoints[i] > max)
            {
                max = dataPoints[i];
            }
        }
        System.out.println("The minimum value in dataPoints is: " + min);
        System.out.println("The maximum value in dataPoints is: " + max);
    }
}