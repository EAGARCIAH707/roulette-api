package com.masivian.rouletteapi.web.rest.bet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.masivian.rouletteapi.commons.constants.api.IEndpointApi;
import com.masivian.rouletteapi.commons.constants.api.IEndpointBet;
import com.masivian.rouletteapi.commons.domains.generic.BetDTO;
import com.masivian.rouletteapi.test.data.builder.BetDTOTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class BetApiTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void bet() throws Exception {
        BetDTO bet = new BetDTOTest().betBuilder();
        HttpHeaders headers = new HttpHeaders();
        headers.add("user-id", "user1");
        mvc.perform(MockMvcRequestBuilders
                .post(IEndpointApi.BASE_PATH.concat(IEndpointBet.CREATE))
                .content(objectMapper.writeValueAsString(bet))
                .headers(headers)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isConflict());
    }

    @Test
    void closeBets() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .patch(IEndpointApi.BASE_PATH.concat("/bets/roulette/1"))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}