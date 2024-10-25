import java.util.ArrayList;
import java.util.List;

public class Student implements Comparable<Student>{
    private String name;
    private List<Double> rates;

    public Student(String name, List<Double> rates) {
        this.name = name;
        this.rates = rates;
    }

    @Override
    public String toString() {
        return String.format("%s %.1f", name, calcAverageScore());
    }

    public String getName() {
        return name;
    }

    public List<Double> getRates() {
        return new ArrayList<>(rates);
    }

    private double ratesSum () {
        double result = 0;
        if (rates == null) {
            return result;
        }
        for (Double element : rates) {
            if (element != null) {
                result += element;
            }
        }
        return result;
    }

    private int ratesNumber () {
        int result = 0;
        if (rates == null) {
            return result;
        }
        for (Double element : rates) {
            if (element != null) {
                result++;
            }
        }
        return result;
    }

    public double calcAverageScore () {
        return ratesSum()/ratesNumber();
    }

    @Override
    public int compareTo(Student o) {
        return Double.compare(calcAverageScore(), o.calcAverageScore());
       /*
       if (calcAverageScore() > o.calcAverageScore()) {
           return 1;
       } else if (calcAverageScore() == o.calcAverageScore()) {
           return 0;
       } else {
           return -1;
       }
       */
    }
}
