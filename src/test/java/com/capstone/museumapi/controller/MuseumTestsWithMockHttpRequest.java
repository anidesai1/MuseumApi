package com.capstone.museumapi.controller;

import com.capstone.museumapi.model.Museum;
import com.capstone.museumapi.repository.MuseumRepository;
import com.capstone.museumapi.service.MuseumServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@Sql("classpath:test-data.sql")
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@TestPropertySource(properties = {"spring.sql.init.mode=never"})
class MuseumTestsWithMockHttpRequest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;
    ResultActions resultActions;
    @Mock
    private MuseumRepository museumRepository;

    @InjectMocks
    private MuseumServiceImpl museumService;

    @Test
    void testGettingAllMuseums() throws Exception {
        int expectedLength = 2;
        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/museums")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsAString = result.getResponse().getContentAsString();

        Museum[] museums = mapper.readValue(contentAsAString, Museum[].class);
        assertAll("Testing from a test-data.sql file",
                () -> assertEquals(expectedLength, museums.length),
                () -> assertEquals("The National Gallery", museums[0].getMuseumName()),
                () -> assertEquals("National Portrait Gallery", museums[1].getMuseumName()));

    }
    @Test
    void testCreateMuseum() throws Exception{
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
    void testDeleteMuseum() throws Exception{
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
    @Test
    void testFindByMuseumNameContains() {
        // Mock data
        String filter = "someFilter";
        List<Museum> mockArtists = Arrays.asList(
                new Museum("Museum1"),
                new Museum("Museum2")
                // Add more mock data as needed
        );

        // Set up the mock behavior for your repository method
        when(museumRepository.findByMuseumNameContainingIgnoreCase(eq(filter))).thenReturn(mockArtists);

        // Call the service method
        List<Museum> result = museumService.findByMuseumNameContains(filter);

        // Verify the interactions and assertions
        Mockito.verify(museumRepository, times(1)).findByMuseumNameContainingIgnoreCase(filter);
        assertThat(result).isNotNull().hasSize(2); // Adjust based on your mock data
    }
}
