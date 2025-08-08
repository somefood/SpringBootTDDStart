package commerce;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Product {
    
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long dataKey;
    
    @Column(unique = true)
    private UUID id;
    
    private UUID sellerId;
    
    private String name;
    
    private String imageUrl;
    
    private String description;
    
    private BigDecimal priceAmount;
    
    private Integer stockQuantity;
}
