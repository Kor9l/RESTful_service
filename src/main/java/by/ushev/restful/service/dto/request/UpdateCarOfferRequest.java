package by.ushev.restful.service.dto.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UpdateCarOfferRequest extends CreateCarOfferRequest{
    private Integer id;
    private Boolean delete;
}
