package com.capstone.museumapi.dto;

import com.capstone.museumapi.model.Artist;
import com.capstone.museumapi.model.Painting;
import com.capstone.museumapi.util.ArtistDtoConverter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@Sql("classpath:test-data.sql")
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@TestPropertySource(properties = {"spring.sql.init.mode=never"})
class ArtistDtoTestings {
    @Test
    void testConvert() {
        Artist artist = new Artist();
        artist.setId(1);
        artist.setArtistName("John Doe");

        ArtistPaintingsDto artistDto = ArtistDtoConverter.convert(artist);

        assertEquals(1, artistDto.getId());
        assertEquals("John Doe", artistDto.getArtistName());
        assertNull(artistDto.getMuseum());
        assertNull(artistDto.getPaintings());
    }
    @Test
    void testConvertWithPaintings() {
        Artist artist = new Artist();
        artist.setId(1);
        artist.setArtistName("John Doe");

        Painting painting1 = new Painting(/* Initialize with proper values */);
        Painting painting2 = new Painting(/* Initialize with proper values */);
        artist.setPaintings(Arrays.asList(painting1, painting2));

        ArtistPaintingsDto artistDto = ArtistDtoConverter.convertWithPaintings(artist);

        assertEquals(1, artistDto.getId());
        assertEquals("John Doe", artistDto.getArtistName());
        assertNull(artistDto.getMuseum());
        assertEquals(Arrays.asList(painting1, painting2), artistDto.getPaintings());
    }
}
