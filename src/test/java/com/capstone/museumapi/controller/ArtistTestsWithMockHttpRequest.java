package com.capstone.museumapi.controller;

import com.capstone.museumapi.model.Artist;
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
public class ArtistTestsWithMockHttpRequest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;
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
                () -> assertEquals("John Constable", artists[0].getArtistName()),
                () -> assertEquals("Dante Gabriel Rossetti", artists[1].getArtistName()));

    }
    @Test
    public void testCreateArtist() throws Exception{
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
    public void testDeleteArtist() throws Exception{
        Artist artist = new Artist();
        artist.setArtistName("New Artist");

        mapper = new ObjectMapper();

        resultActions = this.mockMvc.perform(MockMvcRequestBuilders.delete("/artist/1")
                        .content(mapper.writeValueAsString(artist))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Artist deleted successfully"));;
    }
}
