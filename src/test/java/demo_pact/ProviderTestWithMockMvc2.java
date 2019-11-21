package demo_pact;

import static org.mockito.Mockito.when;

import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.RestPactRunner;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.TestTarget;
import au.com.dius.pact.provider.spring.target.MockMvcTarget;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

//@RunWith(SpringRestPactRunner.class)
//@Provider("myProvider")
//@PactFolder("target/pacts")
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)

@RunWith(RestPactRunner.class)
@Provider("myProvider")
@PactFolder("target/pacts")
@WebMvcTest(HelloController.class)
public class ProviderTestWithMockMvc2 {

    @InjectMocks
    HelloController helloController;

    @Mock
    HelloService helloService;

    @TestTarget
    public final MockMvcTarget target = new MockMvcTarget();

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        target.setControllers(helloController);
    }

    @State(value = "sayHello")
    public void runTest() {
        System.out.println("running provider test");
        System.out.println("==> helloService in test:" + helloService.hashCode());
        when(helloService.sayHello()).thenReturn(new HelloBean("test msg", "test name"));
    }

    @State(value = "otherState")
    public void runTest2() {

    }
}