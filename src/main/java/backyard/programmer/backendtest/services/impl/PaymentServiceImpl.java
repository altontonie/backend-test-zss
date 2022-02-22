package backyard.programmer.backendtest.services.impl;

import backyard.programmer.backendtest.model.request.PurchaseRequest;
import backyard.programmer.backendtest.model.response.PurchaseResponse;
import backyard.programmer.backendtest.services.PaymentService;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

public class PaymentServiceImpl implements PaymentService {
    @Override
    public PurchaseResponse purchase(PurchaseRequest purchase) {
        String url = "https://lab.v.co.zw/interview/api/transaction";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer 9ca3d5ed-dc04-4700-8dd6-7d60c3cdf0fa");
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<PurchaseRequest> HttpRqst =
                new HttpEntity<>(purchase, headers);
        ResponseEntity<PurchaseResponse> result = restTemplate.postForEntity(url, HttpRqst, PurchaseResponse.class);
        return result.getBody();
    }
}
