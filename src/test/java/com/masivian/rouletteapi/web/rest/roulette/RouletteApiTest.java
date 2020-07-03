package com.masivian.rouletteapi.web.rest.roulette;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.masivian.rouletteapi.commons.constants.api.IEndpointApi;
import com.masivian.rouletteapi.commons.constants.api.IEndpointRoulette;
import com.masivian.rouletteapi.commons.domains.generic.RouletteDTO;
import com.masivian.rouletteapi.test.data.builder.RouletteDTOTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class RouletteApiTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createRoulette() throws Exception {
        RouletteDTO roulette = new RouletteDTOTest().rouletteBuilder();
        mvc.perform(MockMvcRequestBuilders
                .post(IEndpointApi.BASE_PATH.concat(IEndpointRoulette.CREATE))
                .content(objectMapper.writeValueAsString(roulette))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    void listAll() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get(IEndpointApi.BASE_PATH.concat(IEndpointRoulette.FIND_ALL))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void openRoulette() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .patch(IEndpointApi.BASE_PATH.concat("/roulettes/1"))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}