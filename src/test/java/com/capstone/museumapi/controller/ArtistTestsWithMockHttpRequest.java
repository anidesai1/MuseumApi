package com.capstone.museumapi.controller;

import com.capstone.museumapi.model.Artist;
import com.capstone.museumapi.repository.ArtistRepository;
import com.capstone.museumapi.service.ArtistServiceImpl;
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
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@Sql("classpath:test-data.sql")
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@TestPropertySource(properties = {"spring.sql.init.mode=never"})
 class ArtistTestsWithMockHttpRequest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;
    @Mock
    private ArtistRepository artistRepository;

    @InjectMocks
    private ArtistServiceImpl artistService;
    ResultActions resultActions;

    @Test
    public void testGettingAllArtists() throws Exception {
        int expectedLength = 2;
        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/artists")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsAString = result.getResponse().getContentAsString();

        Artist[] artists = mapper.readValue(contentAsAString, Artist[].class);
        assertAll("Testing from a test-data.sql file",
                () -> assertEquals(expectedLength, artists.length),
                () -> assertEquals("Dante Gabriel Rossetti", artists[0].getArtistName()),
                () -> assertEquals("Artist Unknown", artists[1].getArtistName()));

    }

    @Test
    void testCreateArtist() throws Exception {
        Artist artist = new Artist();
        artist.setArtistName("New Artist");

        mapper = new ObjectMapper();

        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.post("/artist")
                        .content(mapper.writeValueAsString(artist))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        MvcResult result = resultActions.andReturn();
        String contentAsString = result.getResponse().getContentAsString();

        artist = mapper.readValue(contentAsString, Artist.class);
        assertEquals(1, artist.getId());
    }

    @Test
    void testDeleteArtist() throws Exception {
        Artist artist = new Artist();
        artist.setArtistName("New Artist");

        mapper = new ObjectMapper();

        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.delete("/artist/1")
                        .content(mapper.writeValueAsString(artist))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Artist deleted successfully"));
        ;
    }

    @Test
    void testFindByArtistNameContains() {
        // Mock data
        String filter = "someFilter";
        List<Artist> mockArtists = Arrays.asList(
                new Artist("Artist1"),
                new Artist("Artist2")
                // Add more mock data as needed
        );

        // Set up the mock behavior for your repository method
        when(artistRepository.findByArtistNameContains(eq(filter))).thenReturn(mockArtists);

        // Call the service method
        List<Artist> result = artistService.findByArtistNameContains(filter);

        // Verify the interactions and assertions
        Mockito.verify(artistRepository, times(1)).findByArtistNameContains(filter);
        assertThat(result).isNotNull().hasSize(2); // Adjust based on your mock data
    }
}
