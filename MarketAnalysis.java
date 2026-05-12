/******************************************************************************
** AUTHOR: Jonathan Smith
* CS 111 1258
* LAST MODIFIED: 05/12/2026
* -----------------------------------------------------------------------------
* DESCRIPTION: This class represents a VR Market Analysis model.
* It encapsulates market data and growth projection logic.
* -----------------------------------------------------------------------------
* * UML CLAS DIAGRAM:
* -----------------------------------------------------------------------------
* MARKET ANALYSIS
* -----------------------------------------------------------------------------
* - topic : String
* - growthRate : double
* - currentMarketValue: double
* - historicalData : double[]
* -----------------------------------------------------------------------------
* + MarketAnalysis() (Default Constructor)
* + MarketAnalysis(topic : String, growthRate : double, currentMarketValue : double)
* + setTopic(topic : String) : void
* + setGrowthRate(rate : double) : void
* + setCurrentMarketValue(value : double) : void
* + setAll(topic : String, rate : double, value : double) : void
* + getTopic() : String
* + getGrowthRate() : double
* + getCurrentMarketValue() : double
* + calculateForecast(years : int) : double
* + estimateUsers(marketValue : double) : double
* + printHistoricalData() : void
* + equals(other : MarketAnalysis) : boolean
* + toString() : String
* + BOLD : String -> ANSI ecapse code for bold text (\u001B[1m)
* * RESET : String -> ANSI escape code to return text to default (\u001B[0m)
* -----------------------------------------------------------------------------
******************************************************************************/
public class MarketAnalysis {

// Instance Variables
private String topic;
private double growthRate;
private double currentMarketValue;
private double[] historicalData;

// DEFAULT CONSTRUCTOR
public MarketAnalysis(){
    this.topic = "General Market";
    this.growthRate = 0.0;
    this.currentMarketValue = 0.0;
    this.historicalData = new double[]{0.0, 0.0, 0.0, 0.00};
}
// FULL CONSTRUCTOR to initialize the MarketAnalysis object.
public MarketAnalysis(String topic, double growthRate, double currentMarketValue){
setAll(topic, growthRate, currentMarketValue);
    this.historicalData = new double[]{59.96, 79.36, 88.10, 95.50};
}
//MUTATOR (SETTERS)
public void setTopic(String topic){
    this.topic = topic;
}

public void setGrowthRate(double rate){
    this.growthRate = (rate >=0) ? rate : 0.0;
}

public void setCurrentMarketValue(double value){
    this.currentMarketValue = (value >=0) ? value : 0.0;
}
/**
 * SET ALL METHOD
 *  UPDATES the topic, growth rate, and market value.
 */
public void setAll(String topic, double rate, double value) {
    setTopic(topic);
    setGrowthRate(rate);
    setCurrentMarketValue(value);
}

// ACCESSORS (GETTERS)
public String getTopic(){
    return topic;
}
public double getGrowthRate(){
    return growthRate;
}
public double getCurrentMarketValue(){
    return currentMarketValue;
}


/***** LOGIC METHODS *****/    
/**
 * Calculates future value using : base + (base * rate * years)
 * @param years Number of years from baseline (2025).
 * @return Projected maket value.
 */
public double calculateForecast(int years) {
    return currentMarketValue + (currentMarketValue * growthRate * years);
}
/**
 * @param marketValue Value in Billions.
 * @return Estimated users in Millions.
 */
public double estimateUsers(double marketValue){
    return marketValue * 3;
}

/**
 * Loops through the historicalData array to display values.
 */
public void printHistoricalData(){
    String BOLD = "\u001B[1m";
    String RESET = "\u001B[0m";

    System.out.println("\n--- " + BOLD + "Historical Market Data (2022-2025)" + RESET + " ---");
    for (int i = 0; i < historicalData.length; i++){
        System.out.printf("Year %d: $%.2f Billion\n", (2022 + i), historicalData[i]);
    }
}

/*****OVERRIDE METHOD *****/
/**
 * EQUALS METHOD
 * Compares two MarketAnalysis objects for equality
 */
public boolean equals(MarketAnalysis other){
    if (other == null) {
        return false;
    }
    return this.topic.equalsIgnoreCase(other.getTopic()) &&
    this.currentMarketValue == other.getCurrentMarketValue() &&
    this.growthRate == other.getGrowthRate();
}

/**
 * TOSTRING METHOD
 * Creates a formatted summary.
 */
@Override
    public String toString() {
        return String.format("Topic: %s\n" + 
        "Growth Rate: %.1f%%\n" + 
        "Current Market Value: $%,.2f Billion", 
        topic, (growthRate * 100), currentMarketValue);
    }
}
