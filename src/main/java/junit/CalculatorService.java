package junit;

public class CalculatorService {
    private final DataService dataService;

    // We pass the dependency through the constructor
    public CalculatorService(DataService dataService) {
        this.dataService = dataService;
    }

    public int addAllNumbers() {
        int[] numbers = dataService.fetchNumbers();
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }
}
