package net.superhero.loancalculator.api;

import net.superhero.loancalculator.calculators.HomeLoanCalculator;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is the controller for the Loan Calculators Restful endpoints.
 */
@RestController
@RequestMapping(value = "/")
public class LoanCalculatorController {

    /**
     * This endpoint is really just a test end point to make sure the Loan Calculator is ready to calculate.
     *
     * @return Loan Calculator Greeting
     */
    @RequestMapping(value = "/loan-calculator", method = RequestMethod.GET, produces = {"text/plain"})
    public String getGreeting() {
        return "This is Home Loan Calculator! Thanks for visiting!";
    }

    /**
     * This methods is the endpoint for POST into the calculator that will be requesting monthly payment information.
     *
     * @param loanTerms Loan Terms from which to calculate Loan Details.
     * @return Calculated loan details.
     */
    @RequestMapping(value = "/loan-calculator", method = RequestMethod.POST,
            consumes = {"application/json"}, produces = {"application/json"})
    public LoanDetails getMonthlyPayment(@RequestBody LoanTerms loanTerms) {
        return new HomeLoanCalculator(loanTerms).calculateLoanDetails();
    }
}
