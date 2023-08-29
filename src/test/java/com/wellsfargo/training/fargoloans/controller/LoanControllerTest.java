package com.wellsfargo.training.fargoloans.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.wellsfargo.training.fargoloans.model.Loan;
import com.wellsfargo.training.fargoloans.repository.LoanRepository;
import com.wellsfargo.training.fargoloans.service.LoanService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(LoanController.class)
public class LoanControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LoanService loanService;

    @InjectMocks
    private LoanController loanController;
    
	@MockBean
	private LoanRepository loanRepository;

//    private Loan loan;
//    
//    @BeforeEach
//    void setup() {
//    	loan = new Loan(1,"Test Loan", 1);
////    	Mockito.when(loanService.saveLoans(loan).thenReturn(loan);
//    }
//    
//    
//    
//    @Test
//    public void testSaveLoan() throws Exception {
//        Loan loanToSave = new Loan();
//        loanToSave.setLoanId(1L);
//        loanToSave.setLoanType("Test Loan");
//        loanToSave.setDurationInYears(1);
//
//        when(loanService.saveLoans(loanToSave)).thenReturn(loan);
//
//        mockMvc.perform(MockMvcRequestBuilders.post("/api/loan/")
//                .content("{\n" +
//                        "  \"id\": 1,\n" +
//                        "  \"loanType\": \"Test Loan\",\n" +
//                        "  \"durationInYears\": 1\n" +
//                        "}")
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.loanType").value("Test Loan"));
//    }
	
	@Test
    public void testSaveLoan() throws Exception {
        Loan loanToSave = new Loan();
        loanToSave.setLoanId(1L);
        loanToSave.setLoanType("Test Loan");
        loanToSave.setDurationInYears(2);

        when(loanService.saveLoans(loanToSave)).thenReturn(loanToSave);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/loan/")
                .content("{\n" +
                        "  \"id\": 1,\n" +
                        "  \"loanType\": \"Test Loan\",\n" +
                        "  \"durationInYears\": 2\n" +
                        "}")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.loanType").value("Test Loan"));
    }

    @Test
    public void testGetAllLoans() throws Exception {
        List<Loan> loanList = new ArrayList<>();
        Loan loan1 = new Loan(1L, "Loan A", 3);
        Loan loan2 = new Loan(2L, "Loan B", 5);
        loanList.add(loan1);
        loanList.add(loan2);

        when(loanService.getAllLoans()).thenReturn(loanList);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/loan/all"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].loanType").value("Loan A"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].loanType").value("Loan B"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2));
    }

    @Test
    public void testGetLoanById() throws Exception {
        Loan loan = new Loan(1L, "Loan C", 4);

        when(loanService.getSingleLoan(1L)).thenReturn(Optional.of(loan));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/loan/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.loanType").value("Loan C"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.durationInYears").value(4));
    }

    @Test
    public void testUpdateLoan() throws Exception {
        Loan existingLoan = new Loan(1L, "Loan X", 10);
        Loan updatedLoan = new Loan(1L, "Updated Loan X", 15);

        when(loanService.getSingleLoan(1L)).thenReturn(Optional.of(existingLoan));
        when(loanService.saveLoans(updatedLoan)).thenReturn(updatedLoan);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/loan/1")
                .content("{\n" +
                        "  \"id\": 1,\n" +
                        "  \"loanType\": \"Updated Loan X\",\n" +
                        "  \"durationInYears\": 15\n" +
                        "}")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.loanType").value("Updated Loan X"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.durationInYears").value(15));
    }

    @Test
    public void testDeleteLoan() throws Exception {
        doNothing().when(loanService).deleteLoan(1L);

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/loan/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.Deleted").value(true));
    }
}


