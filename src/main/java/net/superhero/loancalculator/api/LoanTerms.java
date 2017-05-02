package net.superhero.loancalculator.api;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.superhero.loancalculator.calculators.LoanType;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * This class is a set of Loan Terms that the Loan Calculator will used to calculate monthly payments.
 */
@Getter
@Setter
@NoArgsConstructor
public class LoanTerms {

    /** Current monthly income */
    private double totalMonthlyIncome = 0.00;

    /** Current monthly debt */
    private double totalMonthlyDebt = 0.00;

    /** Current Age of borrower */
    private int currentAge = 0;

    /** Number of Months this loan is for */
    private int numYears;

    /** Total Loan Amount */
    private int loanAmount;

    /** Total interest for this Loan */
    private BigDecimal interest;

    /** Type of Loan */
    private LoanType type;

    public LoanTerms(int numYears, int loanAmount, LoanType type, int currentAge, double totalMonthlyDebt, double totalMonthlyIncome) {
        this.numYears = numYears;
        this.loanAmount = loanAmount;
        this.type = type;
        this.currentAge = currentAge;
        this.totalMonthlyDebt = totalMonthlyDebt;
        this.totalMonthlyIncome = totalMonthlyIncome;
        this.interest = calculateInterest();
    }

    public BigDecimal getInterest() {
        return calculateInterest();
    }

    public BigDecimal calculateInterest(){
        /** interest calculation logic here, to be defined */
        switch (type) {
            case ING:
                return rateAdjustment(new BigDecimal(3.12), new BigDecimal(0.42), new BigDecimal(0.43));
            case CITI:
                return rateAdjustment(new BigDecimal(3.63), new BigDecimal(0.64), new BigDecimal(0.97));
            case HSBC:
                return rateAdjustment(new BigDecimal(3.64), new BigDecimal(0.43), new BigDecimal(1.04));
            case OCBC:
                return rateAdjustment(new BigDecimal(4.25), new BigDecimal(0.23), new BigDecimal(0.88));
            case SCB:
                return rateAdjustment(new BigDecimal(5.27), new BigDecimal(0.75), new BigDecimal(0.735));
            default:
                return null;
        }

    }

    private BigDecimal rateAdjustment(BigDecimal rate, BigDecimal ageAdj, BigDecimal incomeAdj){
        if(40 - currentAge > numYears)
            rate = rate.subtract(ageAdj);
        if(55 - currentAge < numYears)
            rate = rate.add(ageAdj);
        if(loanAmount/(numYears*12) > (totalMonthlyIncome - totalMonthlyDebt)*0.66)
            rate = rate.add(incomeAdj);
        if(loanAmount/(numYears*12) < (totalMonthlyIncome - totalMonthlyDebt)*0.33)
            rate = rate.subtract(incomeAdj);
        return rate.setScale(4, RoundingMode.HALF_UP);
    }


}
