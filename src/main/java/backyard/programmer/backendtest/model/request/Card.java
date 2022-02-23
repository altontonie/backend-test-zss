package backyard.programmer.backendtest.model.request;

import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Data
public class Card {
    private String id;
    private LocalDate expiry;

    public Card() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
        LocalDate date = LocalDate.parse("2022-02-22", formatter);
        this.expiry = date;
    }
}
