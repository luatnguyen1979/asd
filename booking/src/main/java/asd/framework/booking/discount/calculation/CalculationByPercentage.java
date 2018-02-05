package asd.framework.booking.discount.calculation;

import java.time.LocalDate;

public class CalculationByPercentage extends ICalculation {

    private Double percentageOff;

    public CalculationByPercentage(LocalDate bd, LocalDate ed, Double percentageOff) {
        super(bd, ed);
        this.percentageOff = percentageOff;
    }

    @Override
    public Double calculate(Double regularPrice) {
        return regularPrice / 100 * percentageOff;
    }
}
