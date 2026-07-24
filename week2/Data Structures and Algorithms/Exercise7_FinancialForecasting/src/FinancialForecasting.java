package forecasting;

public class FinancialForecasting {

    // Recursive method to calculate future value
    // futureValue = presentValue * (1 + growthRate)^periods
    public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
        // Base case: if periods is 0, the future value is just the present value
        if (periods == 0) {
            return presentValue;
        }
        
        // Recursive case
        return (1 + growthRate) * calculateFutureValue(presentValue, growthRate, periods - 1);
    }
    
    // Optimized approach using Memoization to avoid redundant calculations (if there are overlapping subproblems in a more complex scenario)
    // For simple future value, simple iteration or Math.pow is O(1) or O(log n) compared to O(n) recursion.
    // Standard iterative way (Optimization):
    public static double calculateFutureValueIterative(double presentValue, double growthRate, int periods) {
        double futureValue = presentValue;
        for (int i = 0; i < periods; i++) {
            futureValue *= (1 + growthRate);
        }
        return futureValue;
    }

    public static void main(String[] args) {
        double presentValue = 1000.0;
        double growthRate = 0.05; // 5% growth
        int periods = 10; // 10 years
        
        double futureValueRecursive = calculateFutureValue(presentValue, growthRate, periods);
        System.out.printf("Future Value (Recursive) after %d years: $%.2f%n", periods, futureValueRecursive);
        
        double futureValueIterative = calculateFutureValueIterative(presentValue, growthRate, periods);
        System.out.printf("Future Value (Iterative) after %d years: $%.2f%n", periods, futureValueIterative);
    }
}
