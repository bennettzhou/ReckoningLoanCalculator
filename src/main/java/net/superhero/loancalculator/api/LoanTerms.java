package net.superhero.loancalculator.api;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.superhero.loancalculator.calculators.LoanType;

import java.math.BigDecimal;

/**
 * This class is a set of Loan Terms that the Loan Calculator will used to calculate monthly payments.
 */
@Getter
@Setter
@NoArgsConstructor
public class LoanTerms {

    /** Current monthly income */
    private double totalMonthlyIncome;

    /** Current monthly debt */
    private double totalMonthlyDebt;

    /** Current Age of borrower */
    private int currentAge;

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
                return BigDecimal.valueOf(1.22);
            case CITI:
                return BigDecimal.valueOf(1.23);
            case HSBC:
                return BigDecimal.valueOf(1.24);
            case OCBC:
                return BigDecimal.valueOf(1.25);
            case SCB:
                return BigDecimal.valueOf(1.27);
            default:
                return null;
        }

    }


}
