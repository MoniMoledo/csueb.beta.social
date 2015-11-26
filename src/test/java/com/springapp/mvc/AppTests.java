package com.springapp.mvc;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml")
public class AppTests {
    private MockMvc mockMvc;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected WebApplicationContext wac;

    @Before
    public void setup() throws Exception{
        this.mockMvc = webAppContextSetup(this.wac).build();
        mockMvc.perform(post("/register?" +
                "first_name=mocktest1" +
                "&email=mocktest1@email.com" +
                "&last_name=mocktest1" +
                "&first_name=mockname1" +
                "&gender=m" +
                "&password=secret"))
                .andExpect(status().isOk());
        mockMvc.perform(post("/register?" +
                "first_name=mocktest2" +
                "&email=mocktest2@email.com" +
                "&last_name=mocktest2" +
                "&first_name=mockname2" +
                "&gender=m" +
                "&password=secret"))
                .andExpect(status().isOk());
    }

    @After
    public void cleanup() throws Exception{
        this.mockMvc = webAppContextSetup(this.wac).build();
        mockMvc.perform(delete("/unsubscribe/mocktest1@email.com").header("password", "admin"))
                .andExpect(status().isOk());
        mockMvc.perform(delete("/unsubscribe/mocktest2@email.com").header("password", "admin"))
                .andExpect(status().isOk());
    }

    @Test
    public void testSingup() throws Exception {
        mockMvc.perform(get("/signup"))
                .andExpect(status().isOk())
                .andExpect(view().name("signup"));

        mockMvc.perform(post("/register?first_name=mocktest&email=mocktest@email.com&last_name=mocktest&first_name=mockname&gender=m&password=secret"))
                .andExpect(status().isOk());

        mockMvc.perform(delete("/unsubscribe/mocktest@email.com").header("password", "admin"))
                .andExpect(status().isOk());
    }

    @Test
    public void testLogin() throws Exception {
        mockMvc.perform(get("/login"))
                .andExpect(status().isOk())
                .andExpect(view().name("login"));
    }

    @Test
    public void testHome() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("home"));
    }

    @Test
    public void testProfile() throws Exception {
        mockMvc.perform(get("/profile/mocktest1@email.com"))
                .andExpect(status().isOk())
                .andExpect(view().name("profile"));
    }

    @Test
    public void testSearch() throws Exception {
        mockMvc.perform(get("/search"))
                .andExpect(status().isOk())
                .andExpect(view().name("home"));
    }

    /*@Test
    public void testConnection() throws Exception{
        mockMvc.perform(post("/connect?src_email=mocktest1@email.com&dst_email=mocktest2@email.com"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetConnections() throws Exception{
        MvcResult result = mockMvc.perform(get("/connections?user_id=202"))
                .andExpect(status().isOk()).andReturn();
        Assert.assertTrue(result.getModelAndView()!=null);
        Assert.assertTrue(result.getModelAndView().getModel() != null);
        Assert.assertTrue(result.getModelAndView().getModel().get("connections")!= null);
        Assert.assertEquals(1, ((List) result.getModelAndView().getModel().get("connections")).size());
    }*/
}
