package com.capstone.museumapi.controller;

import com.capstone.museumapi.model.Museum;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Sql("classpath:test-data.sql")
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(properties = {"spring.sql.init.mode=never"})
public class MuseumTestsWithMockHttpRequest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;
    ResultActions resultActions;

    @Test
    public void testGettingAllMuseums() throws Exception {
        int expectedLength = 3;
        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/museums")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsAString = result.getResponse().getContentAsString();

        Museum[] museums = mapper.readValue(contentAsAString, Museum[].class);
        assertAll("Testing from a test-data.sql file",
                () -> assertEquals(expectedLength, museums.length),
                () -> assertEquals("Victoria and Albert Museum", museums[0].getMuseumName()),
                () -> assertEquals("The National Gallery", museums[1].getMuseumName()),
                () -> assertEquals("National Portrait Gallery", museums[2].getMuseumName()));

    }
    @Test
    public void testCreateMuseum() throws Exception{
        Museum museum = new Museum();
        museum.setMuseumName("New Museum");

        mapper = new ObjectMapper();

        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.post("/museum")
                        .content(mapper.writeValueAsString(museum))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        museum = mapper.readValue(contentAsString, Museum.class);
        assertEquals(1, museum.getId());
    }
    @Test
    public void testDeleteMuseum() throws Exception{
        Museum museum = new Museum();
        museum.setMuseumName("New Museum");

        mapper = new ObjectMapper();

        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.delete("/museum/1")
                        .content(mapper.writeValueAsString(museum))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Museum deleted successfully"));;
    }
}
