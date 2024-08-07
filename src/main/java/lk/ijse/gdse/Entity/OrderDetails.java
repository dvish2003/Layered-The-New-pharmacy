package lk.ijse.gdse.Entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Data
public class OrderDetails {
    private String itemId;
    private String orderId;
    private int qty;
    private double unitPrice;
}
