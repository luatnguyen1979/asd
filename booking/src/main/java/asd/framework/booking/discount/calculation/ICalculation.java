package asd.framework.booking.discount.calculation;

import java.time.LocalDate;

public abstract class ICalculation {

    private LocalDate bd;
    private LocalDate ed;

    public ICalculation(LocalDate bd, LocalDate ed) {
        this.bd = bd;
        this.ed = ed;
    }

    public final Double getDiscount(Double regularPrice) {
        if (bd == null && ed == null) return 0.0;
        LocalDate now = LocalDate.now();
        if (bd != null && !bd.isBefore(now)) return 0.0;
        if (ed != null && !ed.isAfter(now)) return 0.0;
        Double ret = calculate(regularPrice);
        if (ret < 0) ret = 0.0;
        if (ret > regularPrice) ret = regularPrice;
        return ret;
    }

    public abstract Double calculate(Double regularPrice);
}
