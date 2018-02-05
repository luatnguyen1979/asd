package asd.framework.booking.discount.calculation;

import java.time.LocalDate;

public class CalculationByAmount extends ICalculation {

    private Double amountOff;

    public CalculationByAmount(LocalDate bd, LocalDate ed, Double amountOff) {
        super(bd, ed);
        this.amountOff = amountOff;
    }

    @Override
    public Double calculate(Double regularPrice) {
        return regularPrice - amountOff;
    }
}
