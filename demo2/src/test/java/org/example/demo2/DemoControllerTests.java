package org.example.demo2;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(DemoController.class)
class DemoControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeRepo employeeRepo;

    @BeforeEach
    void setUp() {
        // You can set up some initial data here if needed
    }

    @Test
    void testShowForm() throws Exception {
        mockMvc.perform(get("/employee/form"))
                .andExpect(status().isOk())
                .andExpect(view().name("employeeForm"))
                .andExpect(model().attributeExists("employee"));
    }

    /*@Test
    void testSubmitForm() throws Exception {
        mockMvc.perform(post("/employee/submit")
                        .param("firstName", "John")
                        .param("lastName", "Doe")
                        .param("email", "john.doe@example.com")
                        .param("phone", "1234567890")
                        .param("gender", "Male")
                        .param("department", "Engineering"))
                .andExpect(status().isOk())
                .andExpect(view().name("employeeSuccess"))
                .andExpect(model().attribute("firstName", "John"))
                .andExpect(model().attribute("lastName", "Doe"))
                .andExpect(model().attribute("email", "john.doe@example.com"))
                .andExpect(model().attribute("phone", "1234567890"))
                .andExpect(model().attribute("gender", "Male"))
                .andExpect(model().attribute("department", "Engineering"));
    }*/
}
