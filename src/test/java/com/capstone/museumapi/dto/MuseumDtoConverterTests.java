package com.capstone.museumapi.dto;

import com.capstone.museumapi.model.Artist;
import com.capstone.museumapi.model.Museum;
import com.capstone.museumapi.model.MuseumAddress;
import com.capstone.museumapi.util.MuseumDtoConverter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@Sql("classpath:test-data.sql")
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@TestPropertySource(properties = {"spring.sql.init.mode=never"})
class MuseumDtoConverterTests {
    @Test
    void testConvert() {
        Museum museum = new Museum();
        museum.setId(1);
        museum.setMuseumName("Art Museum");
        museum.setLocation("City Center");
        museum.setCurator("John Doe");
        museum.setTotalNumberOfArtWork(100);
        museum.setAddress(new MuseumAddress());

        Artist artist1 = new Artist();
        Artist artist2 = new Artist();
        museum.setArtists(Arrays.asList(artist1, artist2));

        MuseumDto museumDto = MuseumDtoConverter.convert(museum);

        assertEquals(1, museumDto.getId());
        assertEquals("Art Museum", museumDto.getMuseumName());
        assertEquals("City Center", museumDto.getLocation());
        assertEquals("John Doe", museumDto.getCurator());
        assertEquals(100, museumDto.getTotalNumberOfArtWork());
        assertNotNull(museumDto.getAddress());
        assertEquals(Arrays.asList(artist1, artist2), museumDto.getArtists());
    }
    @Test
    void testConvertWithoutArtists() {
        Museum museum = new Museum();
        museum.setId(1);
        museum.setMuseumName("Art Museum");
        museum.setCurator("John Doe");
        museum.setAddress(new MuseumAddress());

        MuseumDto museumDto = MuseumDtoConverter.convertWithLessDetails(museum);

        assertEquals(1, museumDto.getId());
        assertEquals("Art Museum", museumDto.getMuseumName());
        assertEquals("John Doe", museumDto.getCurator());
        assertNotNull(museumDto.getAddress());
        assertNull(museumDto.getArtists());
    }
}
