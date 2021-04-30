package acme.utils;

import java.util.List;

public class StandardDeviation {

	private StandardDeviation() {
	    throw new IllegalStateException("Utility class");
	  }

    public static double calculateSD(final List<Double> values)
    {
        double sum = 0.0, standardDeviation = 0.0;
        final int length = values.size();

        for(final double num : values) {
            sum += num;
        }

        final double mean = sum/length;

        for(final double num: values) {
            standardDeviation += Math.pow(num - mean, 2);
        }

        return Math.sqrt(standardDeviation/length);
    }
}