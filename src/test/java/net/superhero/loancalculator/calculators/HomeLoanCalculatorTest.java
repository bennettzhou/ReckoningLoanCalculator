package net.superhero.loancalculator.calculators;

import net.superhero.loancalculator.api.LoanDetails;
import net.superhero.loancalculator.api.LoanTerms;
import net.superhero.loancalculator.calculators.HomeLoanCalculator;
import net.superhero.loancalculator.calculators.LoanType;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HomeLoanCalculatorTest {

    @Test
    public void testHomeLoanCalculator() {

        /* Create Loan Terms */
        LoanTerms loanTerms = new LoanTerms(10, 50000, LoanType.ING, 28, 1000, 8000);

        /* Get Loan Details */
        LoanDetails details = new HomeLoanCalculator(loanTerms).calculateLoanDetails();

        /* Check Values */
        assertThat(details.getMonthlyPayment(), is("$2,771.81"));
    }

    @Test
    public void testDecimalAutoLoan() {

        /* Create Loan Terms */
        LoanTerms loanTerms = new LoanTerms(30, 500000, LoanType.SCB, 40, 3000, 21000);

        /* Get Loan Details */
        LoanDetails details = new HomeLoanCalculator(loanTerms).calculateLoanDetails();

        /* Check Values */
        assertThat(details.getMonthlyPayment(), is("$466.15"));
    }
}