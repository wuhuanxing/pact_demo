package demo_pact.web;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import demo_pact.HelloBean;
import demo_pact.HelloController;
import demo_pact.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * just a normal api test
 */
@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    HelloService helloService;

    @Test
    public void helloGradle() throws Exception {
        String name = "zhangsan";
        HelloBean mock = new HelloBean("hello man",name);
        when(helloService.sayHello()).thenReturn(mock);
        mvc.perform(get("/hello"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name").value(name));
    }

}
