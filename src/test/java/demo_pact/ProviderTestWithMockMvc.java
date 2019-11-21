//package demo_pact;
//
//import static org.mockito.Mockito.when;
//
//import au.com.dius.pact.provider.junit.Provider;
//import au.com.dius.pact.provider.junit.State;
//import au.com.dius.pact.provider.junit.loader.PactFolder;
//import au.com.dius.pact.provider.junit.target.Target;
//import au.com.dius.pact.provider.junit.target.TestTarget;
//import au.com.dius.pact.provider.spring.SpringRestPactRunner;
//import au.com.dius.pact.provider.spring.target.SpringBootHttpTarget;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//@RunWith(SpringRestPactRunner.class)
//@Provider("myProvider")
//@PactFolder("target/pacts")
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class ProviderTestWithMockMvc {
//
//    @InjectMocks
//    HelloController helloController = new HelloController();
//    @MockBean
//    HelloService helloService;
//
//    @TestTarget
//    public final Target target = new SpringBootHttpTarget();
//
//    @State(value = "sayHello")
//    public void runTest() {
//        System.out.println("running provider test");
//    }
//}