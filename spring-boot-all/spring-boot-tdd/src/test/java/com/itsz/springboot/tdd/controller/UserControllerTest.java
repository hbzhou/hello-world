package com.itsz.springboot.tdd.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itsz.springboot.tdd.domain.TbUser;
import com.itsz.springboot.tdd.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void testGetAllUsers() throws Exception {
        List<TbUser> userList = new ArrayList<>();
        userList.add(new TbUser(1, "Eat Thrice", "test1@localhost.com"));
        userList.add(new TbUser(2, "Eat Mouse", "test2@localhost.com"));

        doReturn(userList).when(userService).findAllUser();

        mockMvc.perform(MockMvcRequestBuilders.get("/users")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void testSuccessSaveUser() throws Exception {
        TbUser user = new TbUser(1, "Jeremy Gilbert", "test@local.com");
        doReturn(user).when(userService).save(any(TbUser.class));

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(user)));

        resultActions.andExpect(status().isCreated())
                .andExpect(jsonPath("$.username").value("Jeremy Gilbert"))
                .andExpect(jsonPath("$.email").value("test@local.com"));
    }
}
