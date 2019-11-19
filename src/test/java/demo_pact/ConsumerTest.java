package demo_pact;

import static org.assertj.core.api.Assertions.assertThat;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import io.pactfoundation.consumer.dsl.LambdaDsl;
import java.util.HashMap;
import java.util.Map;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ConsumerTest {

    private static final String API_HELLO = "/hello";

    @Rule
    public PactProviderRuleMk2 myProvider = new PactProviderRuleMk2("myProvider", "localhost", 8080, this);


    @Pact(consumer = "myConsumer")
    public RequestResponsePact createPact(PactDslWithProvider builder) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        DslPart body = LambdaDsl.newJsonBody(o -> o.stringValue("name", "zhangsan")).build();

        return builder
            .given("sayHello")
            .uponReceiving("a request to /hello")
            .path(API_HELLO)
            .method("GET")

            .willRespondWith()
            .status(200)
            .headers(headers)
            .body(body)
            .toPact();
    }

    @Test
    @PactVerification()
    public void runTest() {

        // when
        ResponseEntity<String> response = new RestTemplate()
            .getForEntity(myProvider.getUrl() + API_HELLO, String.class);

        // then
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        assertThat(response.getHeaders().get("Content-Type").contains("application/json")).isTrue();

    }

}
