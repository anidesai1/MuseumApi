package com.capstone.museumapi.dto;

import com.capstone.museumapi.model.Artist;
import com.capstone.museumapi.model.Sculpture;
import com.capstone.museumapi.util.ArtistSculpturesDtoConverter;
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
class ArtistSculptureDtoTestings {
    @Test
    void testConvert() {
        Artist artist = new Artist();
        artist.setId(1);
        artist.setArtistName("John Doe");

        ArtistSculptureDto artistDto = ArtistSculpturesDtoConverter.convert(artist);

        assertEquals(1, artistDto.getId());
        assertEquals("John Doe", artistDto.getArtistName());
        assertNull(artistDto.getMuseum());
        assertNull(artistDto.getSculptures());
    }

    @Test
    void testConvertWithSculptures() {
        Artist artist = new Artist();
        artist.setId(1);
        artist.setArtistName("John Doe");

        Sculpture sculpture1 = new Sculpture(/* Initialize with proper values */);
        Sculpture sculpture2 = new Sculpture(/* Initialize with proper values */);
        artist.setSculptures(Arrays.asList(sculpture1, sculpture2));

        ArtistSculptureDto artistDto = ArtistSculpturesDtoConverter.convertWithSculptures(artist);

        assertEquals(1, artistDto.getId());
        assertEquals("John Doe", artistDto.getArtistName());
        assertNull(artistDto.getMuseum());
        assertEquals(Arrays.asList(sculpture1, sculpture2), artistDto.getSculptures());
    }
}
