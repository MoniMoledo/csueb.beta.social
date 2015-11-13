package com.springapp.mvc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    public void simple() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("home"));
    }

    @Test
    public void testSingup() throws Exception {
        mockMvc.perform(get("/signup"))
                .andExpect(status().isOk())
                .andExpect(view().name("signup"));
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

    /*@Test
    public void testProfile() throws Exception {
        mockMvc.perform(get("/profile"))
                .andExpect(status().isOk())
                .andExpect(view().name("profile"));
    }*/

    @Test
    public void testSearch() throws Exception {
        mockMvc.perform(get("/search"))
                .andExpect(status().isOk())
                .andExpect(view().name("home"));
    }

    @Test
    public void testConnection() throws Exception{
        mockMvc.perform(get("/connect?src_email=bob@test.com&dst_email=bob@test.com"))
                .andExpect(status().isOk());
                //.andExpect(view().name("home"));
    }

    @Test
    public void testGetConnections() throws Exception{
        MvcResult result = mockMvc.perform(get("/connections?user_id=207"))
                .andExpect(status().isOk()).andReturn();
        Assert.assertTrue(result.getModelAndView()!=null);
        Assert.assertTrue(result.getModelAndView().getModel() != null);
        Assert.assertTrue(result.getModelAndView().getModel().get("connections")!= null);
        List list = (List) result.getModelAndView().getModel().get("connections");
        Assert.assertEquals(list.size(), 6);

    }
}
