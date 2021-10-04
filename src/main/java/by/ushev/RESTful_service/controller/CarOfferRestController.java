package by.ushev.RESTful_service.controller;

import by.ushev.RESTful_service.dto.request.CreateCarOfferRequest;
import by.ushev.RESTful_service.dto.request.SearchCarOfferRequest;
import by.ushev.RESTful_service.dto.response.CarOfferResponse;
import by.ushev.RESTful_service.dto.response.MessageResponse;
import by.ushev.RESTful_service.security.UserPrincipal;
import by.ushev.RESTful_service.service.CarOfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/carOffer")
public class CarOfferRestController {

    private final CarOfferService carOfferService;

    @GetMapping("/{id}")
    public ResponseEntity<CarOfferResponse> findById(@PathVariable Integer id){
        CarOfferResponse carOfferResponse = carOfferService.getById(id);
        return new ResponseEntity<>(carOfferResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteById(@PathVariable Integer id){
        carOfferService.deleteById(id);
        return new ResponseEntity<>(new MessageResponse("Delete successfully"), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<CarOfferResponse>> search(@PageableDefault(sort = {"id"},direction = Sort.Direction.ASC)
                                                         Pageable pageable,
                                                         @AuthenticationPrincipal UserPrincipal user,
                                                         SearchCarOfferRequest searchCarOfferRequest) {
        return new ResponseEntity<>(carOfferService.search(user, searchCarOfferRequest, pageable), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MessageResponse> add(@AuthenticationPrincipal UserPrincipal user,
                                                @RequestBody CreateCarOfferRequest createCarOfferRequest){
        carOfferService.create(user,createCarOfferRequest);
        return new ResponseEntity<>(new MessageResponse("Created successfully"), HttpStatus.CREATED);
    }

}
