package demo_pact;

import org.springframework.stereotype.Service;

@Service
public class HelloService {


    public HelloBean sayHello(){
        return new HelloBean("hello boy", "zhansan");
    }
}
