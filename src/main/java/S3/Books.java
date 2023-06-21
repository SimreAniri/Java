package S3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Books {
    private String title;
    private String authorSurname;
    private int year;
    private double price;
    private int pagesCount;
}
