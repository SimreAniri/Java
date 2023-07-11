package Base.S3;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String name;
    private String country;
    private Double price;
    private String sort;
    private Double weight; // в кг

}
