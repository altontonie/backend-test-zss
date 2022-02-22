package backyard.programmer.backendtest.model.response;

import lombok.Data;

@Data
public class PurchaseResponse {
    private String updated;
    private String responseCode;
    private String responseDescription;
    private String reference;
    private String debitReference;
}
