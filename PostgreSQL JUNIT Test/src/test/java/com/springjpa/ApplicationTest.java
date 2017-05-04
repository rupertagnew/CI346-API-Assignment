package com.springjpa;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/save")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Done")));
    }
    
   
    @Test
    public void addAccount() throws Exception {
        this.mockMvc.perform(get("/addemployee?firstname=Donald&lastname=Trump")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Donald")));
    }
    
    
    @Test
    public void checkAddedAcount() throws Exception {
        this.mockMvc.perform(get("/findbylastname?lastname=Trump")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Trump")));
    }
    
    @Test
    public void deleteAccount() throws Exception {
        this.mockMvc.perform(get("/delemployee?id=1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("deleted")));
    }
    
}

