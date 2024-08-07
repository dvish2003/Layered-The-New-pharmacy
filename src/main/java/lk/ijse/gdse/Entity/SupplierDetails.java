package lk.ijse.gdse.Entity;

import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Data
public class SupplierDetails {
    private String supplierId;
    private String stockId;
    private Date date;
}
