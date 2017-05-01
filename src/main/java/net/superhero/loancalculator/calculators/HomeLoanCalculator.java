package net.superhero.loancalculator.calculators;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import net.superhero.loancalculator.api.LoanDetails;
import net.superhero.loancalculator.api.LoanTerms;

/**
 * This class represents a Home Loan Calculator and contains the details of what it takes to Calculate a the monthly
 * payment for a Home Loan.
 */
public class HomeLoanCalculator extends AbstractLoanCalculator
{
    /**
     * Creates a new Abstract Loan Calculator with the below given values to use during calculation.
     */
    public HomeLoanCalculator(LoanTerms loanTerms)
    {
        super(loanTerms.getNumYears(), loanTerms.getLoanAmount(), loanTerms.getInterest(), loanTerms.getType());
    }

    @Override
    public LoanDetails calculateLoanDetails()
    {
        BigDecimal monthlyInterest = interest.movePointLeft(2).divide(BigDecimal.valueOf(12), 6, RoundingMode.HALF_UP);
        BigDecimal one = loanAmount.multiply(monthlyInterest);
        BigDecimal two = monthlyInterest.add(BigDecimal.valueOf(1)).pow(-numYears*12, new MathContext(6));
        BigDecimal three = BigDecimal.valueOf(1).subtract(two);

        BigDecimal monthlyPayment = one.divide(three, 6, RoundingMode.HALF_UP);
        BigDecimal totalPaid = monthlyPayment.multiply(BigDecimal.valueOf(numYears*12));
        BigDecimal totalInterest = totalPaid.subtract(loanAmount);

        return new LoanDetails(type, monthlyPayment, totalInterest, totalPaid, loanAmount, interest);
    }

}
