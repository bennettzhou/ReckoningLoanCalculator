package net.superhero.loancalculator.calculators;

import lombok.Getter;
import net.superhero.loancalculator.api.LoanDetails;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
public abstract class AbstractLoanCalculator {

    /** Number of Months to use for Loan Calculation - Cannot be Null */
    protected int numYears;

    /** Total Loan Amount for Loan Calculation - Cannot be Null */
    protected BigDecimal loanAmount;

    /** Interest to use for Calculation - Cannot be Null */
    protected BigDecimal interest;

    /** Interest to use for Calculation - Cannot be Null */
    protected LoanType type;

    /**
     * Creates a new Abstract Loan Calculator with the below given values to use during calculation.
     *
     * @param numYears  number of months until loan matures
     * @param loanAmount amount of loan
     * @param interest   interest to charge
     */
    public AbstractLoanCalculator(int numYears, int loanAmount, BigDecimal interest, LoanType type) {
        this.numYears = numYears;
        this.loanAmount = new BigDecimal(loanAmount).setScale(2, BigDecimal.ROUND_HALF_UP);
        this.interest = interest;
        this.type = type;
    }

    /**
     * This method should return the loan details for this loan
     *
     * @return loan details
     */
    public abstract LoanDetails calculateLoanDetails();

    /**
     * This method will return the base monthly payment for this loan
     *
     * @return dollar amount with no interest
     */
    protected BigDecimal calculateBaseMonthlyPayment() {
        return loanAmount.divide(BigDecimal.valueOf(numYears * 12), RoundingMode.HALF_UP);
    }

    /**
     * THis method will return the monthly interest payment distributed evenly over the life of this loan
     *
     * @return monthly interest
     */
    protected BigDecimal calculateEvenlyDispersedInterestPayments() {
        return loanAmount.multiply(interest.movePointLeft(2)).setScale(2, RoundingMode.HALF_UP)
                .divide(new BigDecimal(numYears * 12), RoundingMode.HALF_UP);
    }
}
