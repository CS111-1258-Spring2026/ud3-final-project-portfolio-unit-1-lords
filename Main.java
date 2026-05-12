/********************************************
*	AUTHORS:	Jonathan Smith, Zen Davis, Prashanna Zhanka
* COLLABORATORS: 
*	LAST MODIFIED:	05/10/2026
********************************************/

/********************************************
*	VR Market Analysis
*********************************************
*	PROGRAM DESCRIPTION:
*	This program preforms a growth analysis of the Virtual Reality (VR)
* market. It displays historical market data (2022-2025), calculates 5-year 
* projections, and provides an interactive tool for users to forcast market value.
*********************************************
*	ALGORITHM:
* 1. Initialize MarketAnalysis object with baseline growth rates and values.
* 2. Preform background checks for object equality and default states.
* 3. Display formatted headers and historical data to the console.
* 4. Calculate and display the 2030 projected market value and user count.
* 5. Prompt user if they wish to perform a custom year search.
* 6. If 'yes', enter a loop:
*   a. Prompt user for a target year (validated 2020-4000).
*   b. Calculate the difference from the 2025 baseline.
*   c. Compute the forecast using the MarketAnalysis object.
*   d. If value >= 1000, convert to Trillions; otherwise, keep in Billions.
*   e. Print formatted result.
*   f. Print BOLD for emphasis.
*   g. Ask user if they would like to search another year.
* 7. If 'no', exit loop and display final closing message.
*********************************************
*	STATIC METHODS:
* main(args : String[]) : void
*********************************************
*	ALL IMPORTED PACKAGES NEEDED AND PURPOSE:
* UtilityBelt = used for console input and validation (integers and characters).
*********************************************/

public class Main 
{
  public static void main(String[] args)
  {
  String BOLD = "\u001B[1m";
  String RESET = "\u001B[0m";

    MarketAnalysis vrProject = new MarketAnalysis("VR Market Growth", 0.25, 105.0);
    MarketAnalysis secondaryStudy = new MarketAnalysis();
    secondaryStudy.setAll("Test", 0.10, 50.00);

    System.out.println("System Check: Comparison complete. Match = " + vrProject.equals(secondaryStudy));

    System.out.println("\n========================================");
    System.out.println(vrProject);
    System.out.println("========================================");


    vrProject.printHistoricalData();

    double fiveYearValue = vrProject.calculateForecast(5);
    double fiveYearUsers = vrProject.estimateUsers(fiveYearValue);

    System.out.println("-------------------------------");
    System.out.printf("%-24s $%,.2f Billion\n", "Total Projected Value in 2030: ", fiveYearValue);
    System.out.printf("%-24s %,.0f Million\n", "Estimated Future Users in 2030: ", fiveYearUsers);
    System.out.println("----------------------------------------");

    // INTERACTIVE SECTION (UtilityBelt)
    char choice = UtilityBelt.readChar("Would you like to search for a specific year? (y/n): ", "yYnN");

    if (choice == 'y' || choice == 'Y') {
      do {
           int targetYear = UtilityBelt.readInt("\nAwesome! Please enter a year between 2020-4000: ", 2020, 4000);
  
        //Basline year is 2025
        int yearDiff = targetYear - 2025;
        double customForecast = vrProject.calculateForecast(yearDiff);

        // If value is 1000 Billion or more, convert to Trillions.
        if (customForecast >= 1000.0){
        double trillionValue = customForecast / 1000.0;
        System.out.printf("\nIn the year %d, the potential market value is: " + BOLD +  "$%,.2f Trillion" + RESET + "\n",
          targetYear,trillionValue);
          
        }
        else {
          System.out.printf("\nIn the year %d, the potential market value is: " + BOLD + "$%,.2f Billion" + RESET + "\n", targetYear, customForecast);
        }
    
        choice = UtilityBelt.readChar("\nWould you like to chack another year? (y/n): ", "yYnN");
      } while (choice == 'y' || choice == 'Y');
    }
    System.out.println("\nThanks for checking out our program!");
    
  
  }
}

