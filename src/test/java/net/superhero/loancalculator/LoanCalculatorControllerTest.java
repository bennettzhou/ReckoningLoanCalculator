package net.superhero.loancalculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LoanCalculatorControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getWelcome() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/loan-calculator")
        .accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("This is Home Loan Calculator! Thanks for visiting!")));
    }

    @Test
    public void getMonthlyPaymentForAutoLoanTest() throws Exception {

//        mvc.perform(MockMvcRequestBuilders.post("/loan-calculator").contentType(MediaType.APPLICATION_JSON)
//                .content(new LoanTerms(5, 500, BigDecimal.valueOf(10), LoanType.AUTO))
//        .accept(MediaType.APPLICATION_JSON))
//        .andExpect(status().isOk());
    }
}