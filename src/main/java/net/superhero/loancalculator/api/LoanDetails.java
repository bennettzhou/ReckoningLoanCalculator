package net.superhero.loancalculator.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import net.superhero.loancalculator.calculators.LoanType;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * This class represents the JSON format that is return from the Loan Calculator.
 */
public class LoanDetails {

    /** Money Formatter */
    @JsonIgnore
    private static DecimalFormat moneyFormat = new DecimalFormat("$#,###.00");

    /** Type of Loan */
    private LoanType type;

    /** Dollar amount of Monthly Payments */
    private BigDecimal monthlyPayment;

    /** Dollar amount of Total Interest Payments */
    private BigDecimal totalInterest;

    /** Dollar amount of Total Payments */
    private BigDecimal totalPayment;

    /** Dollar amount of Eligible Loan Amount */
    private BigDecimal eligibleLoanAmount;

    /** Dollar amount of interest rate */
    private BigDecimal interest;

    /**
     * Default Constructor - Bean required for Jackson Serialization
     */
    public LoanDetails() {
        /* Bean - Default Constructor */
    }

    /**
     * Creates new <code>LoanDetails</code> with the given type and monthly payment.
     *
     * @param type           type of loan
     * @param monthlyPayment monthly payment of this loan
     * @param totalInterest total Interest of this loan
     * @param totalPayment total Payment of this loan
     */
    public LoanDetails(LoanType type, BigDecimal monthlyPayment, BigDecimal totalInterest, BigDecimal totalPayment, BigDecimal eligibleLoanAmount, BigDecimal interest) {
        this.type = type;
        this.monthlyPayment = monthlyPayment;
        this.totalInterest = totalInterest;
        this.totalPayment = totalPayment;
        this.eligibleLoanAmount = eligibleLoanAmount;
        this.interest = interest;
    }

    /**
     * Returns the type of loan <i>this</i> is.
     *
     * @return this loans type
     */
    public LoanType getType() {

        return type;
    }

    /**
     * Sets the type of loan this loan is.
     *
     * @param type loan type
     */
    public void setType(LoanType type) {
        this.type = type;
    }

    /**
     * Returns this loans monthly payment in the Dollar format (i.e $##.##)
     *
     * @return monthly payment in dollars
     */
    public String getMonthlyPayment() {
        return moneyFormat.format(monthlyPayment);
    }

    /**
     * Sets this loan's monthly payment
     *
     * @param monthlyPayment monthly payment for this loan
     */
    public void setMonthlyPayment(BigDecimal monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public String getTotalInterest() {
        return moneyFormat.format(totalInterest);
    }

    public void setTotalInterest(BigDecimal totalInterest) {
        this.totalInterest = totalInterest;
    }

    public String getTotalPayment() {
        return moneyFormat.format(totalPayment);
    }

    public void setTotalPayment(BigDecimal totalPayment) {
        this.totalPayment = totalPayment;
    }

    public String getEligibleLoanAmount() {
        return moneyFormat.format(eligibleLoanAmount);
    }

    public void setEligibleLoanAmount(BigDecimal eligibleLoanAmount) {
        this.eligibleLoanAmount = eligibleLoanAmount;
    }

    public String getInterest() {
        return interest.toString().concat("%");
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }
}
