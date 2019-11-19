package demo_pact;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/hello")
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping
    public HelloBean helloGradle() {
        System.out.println("=============== sayHello =======");
        return helloService.sayHello();
    }

}
