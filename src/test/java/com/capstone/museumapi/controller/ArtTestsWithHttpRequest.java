package com.capstone.museumapi.controller;

import com.capstone.museumapi.model.Art;
import com.capstone.museumapi.repository.ArtRepository;
import com.capstone.museumapi.service.ArtServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
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
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@Sql("classpath:test-data.sql")
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@TestPropertySource(properties = {"spring.sql.init.mode=never"})
    class ArtTestsWithHttpRequest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;
    private TestRestTemplate restTemplate;
    ResultActions resultActions;
    @Mock
    private ArtRepository artRepository;

    @InjectMocks
    private ArtServiceImpl artService;
    @Test
    void testGettingAllArt() throws Exception {
        int expectedLength = 1;
        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/art")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsAString = result.getResponse().getContentAsString();

        Art[] art = mapper.readValue(contentAsAString, Art[].class);
        assertAll("Testing from a test-data.sql file",
                () -> assertEquals(expectedLength, art.length),
                () -> assertEquals("The Day Dream", art[0].getName()));

    }
    @Test
    void testCreateArtist() throws Exception{
        Art art= new Art();
        art.setName("New Art");

        mapper = new ObjectMapper();

        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.post("/art")
                        .content(mapper.writeValueAsString(art))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        art = mapper.readValue(contentAsString, Art.class);
        assertEquals(1, art.getId());
    }
    @Test
    void testDeleteArt() throws Exception{
        Art art = new Art();
        art.setArtistName("New Art");

        mapper = new ObjectMapper();

        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.delete("/art/1")
                        .content(mapper.writeValueAsString(art))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Art deleted successfully"));;
    }
    @Test
    void testGettingAllPaintings() throws Exception {
        int expectedLength = 1;
        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/paintings")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsAString = result.getResponse().getContentAsString();

        Art[] art = mapper.readValue(contentAsAString, Art[].class);
        assertAll("Testing from a test-data.sql file",
                () -> assertEquals(expectedLength, art.length),
                () -> assertEquals("The Day Dream", art[0].getName()));

    }
    @Test
    void testGettingAllSculptures() throws Exception {
        int expectedLength = 0;
        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/sculptures")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsAString = result.getResponse().getContentAsString();

        Art[] art = mapper.readValue(contentAsAString, Art[].class);
        assertAll("Testing from a test-data.sql file",
                () -> assertEquals(expectedLength, art.length));

    }
    @Test
    void testfindByArtNameContains() throws Exception{
        Art art= new Art();
        art.setName("New Art");

        mapper = new ObjectMapper();

        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/art?filter=new")
                        .content(mapper.writeValueAsString(art))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        art = mapper.readValue(contentAsString, Art.class);
        assertEquals(1, art.getId());
    }
    @Test
    void testFindByArtNameContains() {
        // Mock data
        String filter = "someFilter";
        List<Art> mockArt = Arrays.asList(
                new Art("Art1"),
                new Art("Art2")
                // Add more mock data as needed
        );

        // Set up the mock behavior for your repository method
        when(artRepository.findArtByNameContainingIgnoreCase(eq(filter))).thenReturn(mockArt);

        // Call the service method
        List<Art> result = artService.findByArtNameContains(filter);

        // Verify the interactions and assertions
        Mockito.verify(artRepository, times(1)).findArtByNameContainingIgnoreCase(filter);
        assertThat(result).isNotNull().hasSize(2); // Adjust based on your mock data
    }
}
