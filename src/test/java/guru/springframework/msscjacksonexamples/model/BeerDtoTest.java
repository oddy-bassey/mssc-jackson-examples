package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.io.IOException;

@JsonTest
public class BeerDtoTest extends BaseTest{

    /*
     * Autowire the default object mapper configured by SpringBoot
     * NOTE: You can create yours which won't pick the SpringBoot configuration.
     */

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testSerializeDto() throws JsonProcessingException {

        BeerDto beerDto = getDto();

        String jsonString = objectMapper.writeValueAsString(beerDto);

        System.out.println(jsonString);
    }

    @Test
    void testDeSerializeDto() throws IOException {
        String jsonString = "{\"beerName\":\"BeerName\",\"beerStyle\":\"Ale\",\"upc\":123234345456,\"price\":\"12.99\",\"createdDate\":\"2021-03-05T12:06:21.841241+01:00\",\"lastUpdatedDate\":\"2021-03-05T12:32:41+0100\",\"myLocalDate\":\"20210305\",\"beerId\":\"2c77e37f-6e9b-4b3e-bfc6-dfab0b75614b\"}";

        BeerDto beerDto = objectMapper.readValue(jsonString, BeerDto.class);

        System.out.println(beerDto);
    }
}
