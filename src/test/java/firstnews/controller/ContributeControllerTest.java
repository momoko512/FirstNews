package firstnews.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/config/simple-config.xml")
@WebAppConfiguration
public class ContributeControllerTest {
@Autowired
private ContributeController contributeController;
    @Test
    public void getByPass() {
        assertEquals("qqq",contributeController.getByPass(2).getContent().get(0).getName());
    }
}