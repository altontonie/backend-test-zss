package backyard.programmer.backendtest.model;

import lombok.Data;

@Data
public class ReturnException {
    private String timestamp;
    private long status;
    private String error;
    private String message;
    private String path;
}
