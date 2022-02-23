package backyard.programmer.backendtest.model.request;

import lombok.Data;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Data
public class PurchaseRequest {
    private String type;
    private String extendedType;
    private double amount;
    private Date created;
    private Card card;
    private String reference;
    private String narration;
    private Map<String,Object> additionalData;

    public PurchaseRequest() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        String dateString = format.format(new Date());
        try {
            Date date = format.parse (dateString);
            this.created = date;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        this.type = "PURCHASE";
        this.extendedType = "NONE";
        this.amount = 123.33;
        Card card = new Card();
        this.card = card;
        this.reference = String.valueOf(UUID.randomUUID());
        this.narration = "Backend Test";
        Map<String, Object> data = new HashMap<>();
        data.put("SampleKey","This is a sample value");
        this.additionalData = data;
    }
}
