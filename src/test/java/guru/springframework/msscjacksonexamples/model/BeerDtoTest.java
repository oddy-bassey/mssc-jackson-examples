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
        String jsonString = "{\"beerId\":\"afcf68f0-3be9-4f37-8670-81b5ee881625\",\"beerName\":\"BeerName\",\"beerStyle\":\"Ale\",\"upc\":123234345456,\"price\":12.99,\"createdDate\":\"2021-03-04T01:00:40.147798+01:00\",\"lastUpdatedDate\":\"2021-03-04T01:00:40.148083+01:00\"}";

        BeerDto beerDto = objectMapper.readValue(jsonString, BeerDto.class);

        System.out.println(beerDto);
    }
}
