//package demo_pact;
//
//import static org.mockito.Mockito.when;
//import static org.mockito.MockitoAnnotations.initMocks;
//
//import au.com.dius.pact.provider.PactVerifyProvider;
//import au.com.dius.pact.provider.junit.Provider;
//import au.com.dius.pact.provider.junit.State;
//import au.com.dius.pact.provider.junit.StateChangeAction;
//import au.com.dius.pact.provider.junit.loader.PactFolder;
//import au.com.dius.pact.provider.junit.target.HttpTarget;
//import au.com.dius.pact.provider.junit.target.Target;
//import au.com.dius.pact.provider.junit.target.TestTarget;
//import au.com.dius.pact.provider.spring.SpringRestPactRunner;
//import au.com.dius.pact.provider.spring.target.MockMvcTarget;
//import au.com.dius.pact.provider.spring.target.SpringBootHttpTarget;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.test.context.junit4.SpringRunner;
//@RunWith(SpringRestPactRunner.class)
//@WebMvcTest(HelloController.class)
////@SpringBootTest( classes = App.class, webEnvironment = WebEnvironment.RANDOM_PORT)
//// or
//
////@RunWith(SpringRunner.class)
////@SpringBootTest(classes = App.class)
////@AutoConfigureMockMvc
//
//@Provider("myProvider")
//@PactFolder("target/pacts")
//public class ProviderTest {
//
//    @InjectMocks
//    private HelloController helloController;
//
//    @MockBean
//    private HelloService helloService;
//
//    @TestTarget
//    public  Target target = new SpringBootHttpTarget();
//
////    @TestTarget
////    public Target target = new HttpTarget(8080);
//
////    @TestTarget
////    public final MockMvcTarget target = new MockMvcTarget();
//
////    @TestTarget
////    public Target target;
////
////    @LocalServerPort
////    public void setPort(int port) {
////        System.out.println("===== port: "+port);
////        this.target = new HttpTarget("http", "localhost", port, "/", true);
////    }
//
//    @State(value = "sayHello")
//    public void runTest() {
//        System.out.println("===");
//        when(helloService.sayHello()).thenReturn(new HelloBean("aa", "mock name"));
//        // when running this method , it occurs error :
//        // java.lang.Exception: No tests found matching Method runTest(demo_pact.ProviderTest) from org.junit.internal.requests.ClassRequest@2e1b374c
//    }
//}
