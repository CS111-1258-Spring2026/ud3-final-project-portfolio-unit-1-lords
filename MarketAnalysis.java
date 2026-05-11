/******************************************************************************
* DESCRIPTION: This class represents a VR Market Analysis model.
* It encapsulates market data and growth projection logic.
** AUTHORS: Jonathan Smith
* LAST MODIFIED: 05/10/2026
* * UML CLAS DIAGRAM:
* -----------------------------------------------------------------------------
* MARKET ANALYSIS
* -----------------------------------------------------------------------------
* - topic : String
* - growthRate : double
* - currentMarketValue: double
* - historicalData : double[]
* -----------------------------------------------------------------------------
* + MarketAnalysis(topic : String, growthRate : double, currentMarketValue : double)
* + setTopic(topic : String) : void
* + setGrowthRate(rate : double) : void
* + setCurrentMarketValue(value : double) : void
* + setAll(topic : String, rate : double, value : double) : void
* + getTopic() : String
* + getGrowthRate() : double
* + getCurrentMarketValue() : double
* + calculateForecast(years : int) : double
* + estimatUsers(marketValue : double) : double
* + printHistoricalData() : void
* + equals(other : MarketAnalysis) : boolean
* + toString() : String
* -----------------------------------------------------------------------------
******************************************************************************/
public class MarketAnalysis {

// Instance Variables
private String topic;
private double growthRate;
private double currentMarketValue;
private double[] historicalData;

/**
* Constructor to initialize the MarketAnalysis object.
*/
public MarketAnalysis(String topic, double growthRate, double currentMarketValue){
setAll(topic, growthRate, currentMarketValue);
    this.historicalData = new double[]{59.96, 79.36, 88.10, 95.50};
}
// SETTERS
public void setTopic(String topic){
    this.topic = topic;
}

public void setGrowthRate(double rate){
    this.growthRate = (rate >=0) ? rate : 0.0;
}

public void setCurrentMarketValue(double value){
    this.currentMarketValue = (value >=0) ? value : 0.0;
}
public void setAll(String topic, double rate, double value) {
    setTopic(topic);
    setGrowthRate(rate);
    setCurrentMarketValue(value);
}

// GETTERS
public String getTopic(){
    return topic;
}
public double getGrowthRate(){
    return growthRate;
}
public double getCurrentMarketValue(){
    return currentMarketValue;
}


/***** METHODS *****/    
/**
 * Calculates future value using : base + (base * rate * years)
 * @param years Number of years from baseline (2025).
 * @return Projected maket value.
 */
public double calculateForecast(int years) {
    return currentMarketValue + (currentMarketValue * growthRate * years);
}
/**
 *  @param marketValue Value in Billions.
 * @return Estimated users in Millions.
 */
public double estimateUsers(double marketValue){
    return marketValue * 3;
}

/**
 * Loops through the historicalData array to display values.
 */
public void printHistoricalData(){
    System.out.println("\n--- Historical Market Data (2022-2025) ---");
    for (int i = 0; i < historicalData.length; i++){
        System.out.printf("Year %d: $%.2f Billion\n", (2022 + i), historicalData[i]);
    }
}

/*****OVERRIDDEN METHOD *****/

/**
 * 
 * 
 */
//@Override
    public String toString() {
        return String.format("Topic: %s\n" + 
        "Growth Rate: %.1f%%\n" + 
        "Current Market Value: $%,.2f Billion", 
        topic, (growthRate * 100), currentMarketValue);

    }
}
