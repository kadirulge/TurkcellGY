package kodlama.io.rentacar.business.dto.responses.update.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateModelResponse {
    private int id;
    private int brandId;
    private String name;
}
