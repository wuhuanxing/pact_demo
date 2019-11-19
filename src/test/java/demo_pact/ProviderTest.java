package demo_pact;

import static org.mockito.MockitoAnnotations.initMocks;

import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import au.com.dius.pact.provider.spring.SpringRestPactRunner;
import au.com.dius.pact.provider.spring.target.MockMvcTarget;
import au.com.dius.pact.provider.spring.target.SpringBootHttpTarget;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@RunWith(SpringRestPactRunner.class)
@Provider("myProvider")
@PactFolder("target/pacts")
@WebMvcTest(HelloController.class)
public class ProviderTest {

    @InjectMocks
    private HelloController helloController;

    @MockBean
    private HelloService helloService;


    @TestTarget
    public final Target target = new SpringBootHttpTarget();


    @State("sayHello")
    public void runTest() {

        // when running this method , it occurs error :
        // java.lang.Exception: No tests found matching Method runTest(demo_pact.ProviderTest) from org.junit.internal.requests.ClassRequest@2e1b374c
    }
}
