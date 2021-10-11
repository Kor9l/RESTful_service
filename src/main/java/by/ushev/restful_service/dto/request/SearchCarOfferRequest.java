package by.ushev.restful_service.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class SearchCarOfferRequest {
    private Integer brandName;
    private Integer cityName;
}
