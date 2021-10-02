package by.ushev.RESTful_service.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class SearchCarOfferRequest {
    private Integer brandName;
    private Integer cityName;
}
