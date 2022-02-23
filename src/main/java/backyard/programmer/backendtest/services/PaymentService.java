package backyard.programmer.backendtest.services;

import backyard.programmer.backendtest.model.request.PurchaseRequest;
import backyard.programmer.backendtest.model.response.PurchaseResponse;
import org.springframework.stereotype.Service;

public interface PaymentService {

    PurchaseResponse purchase(PurchaseRequest purchase);
}
