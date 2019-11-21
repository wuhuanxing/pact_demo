package demo_pact;


import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/hello")
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping
    public HelloBean hello() {
        System.out.println("====> in Controller");
        System.out.println("helloService in controller:" + helloService.hashCode());
        return helloService.sayHello();
    }

}
