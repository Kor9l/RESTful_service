package by.ushev.restful.service.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class SearchCarOfferRequest {
    private Integer brandName;
    private Integer cityName;
}
