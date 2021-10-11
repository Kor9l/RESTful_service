package by.ushev.restful_service.controller;

import by.ushev.restful_service.domain.CarOffer;
import by.ushev.restful_service.dto.request.CreateCarOfferRequest;
import by.ushev.restful_service.dto.request.SearchCarOfferRequest;
import by.ushev.restful_service.dto.request.UpdateCarOfferRequest;
import by.ushev.restful_service.dto.response.CarOfferResponse;
import by.ushev.restful_service.dto.response.MessageResponse;
import by.ushev.restful_service.exception.ValidationException;
import by.ushev.restful_service.security.UserPrincipal;
import by.ushev.restful_service.service.CarOfferService;
import by.ushev.restful_service.validation.NewCarOfferValidator;
import by.ushev.restful_service.validation.UpdateCarOfferValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/carOffer")
public class CarOfferRestController {

    private final CarOfferService carOfferService;
    private final NewCarOfferValidator newCarOfferValidator;
    private final UpdateCarOfferValidator updateCarOfferValidator;

    @GetMapping("/{id}")
    public ResponseEntity<CarOfferResponse> findById(@PathVariable Integer id) {
        CarOfferResponse carOfferResponse = carOfferService.getById(id);
        return new ResponseEntity<>(carOfferResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteById(@PathVariable Integer id) {
        carOfferService.deleteById(id);
        return new ResponseEntity<>(new MessageResponse("Delete successfully"), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<CarOffer>> search(@PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC)
                                                         Pageable pageable,
                                                 @AuthenticationPrincipal UserPrincipal user,
                                                 SearchCarOfferRequest searchCarOfferRequest,
                                                 @RequestParam Optional<String> brand,
                                                 @RequestParam Optional<String> model) {
        return new ResponseEntity<>(carOfferService.search(user, brand.orElse(""), model.orElse(""), searchCarOfferRequest, pageable), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MessageResponse> add(@AuthenticationPrincipal UserPrincipal user,
                                               @RequestBody @Valid CreateCarOfferRequest createCarOfferRequest,
                                               BindingResult errors) {
        if (errors.hasErrors()||errors.hasFieldErrors()){
            throw  new ValidationException(errors);
        }
        carOfferService.create(user, createCarOfferRequest);
        return new ResponseEntity<>(new MessageResponse("Created successfully"), HttpStatus.CREATED);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<CarOfferResponse> update(@PathVariable Integer id, @AuthenticationPrincipal UserPrincipal user,
                                                   @RequestBody @Valid UpdateCarOfferRequest updateCarOfferRequest,
                                                   BindingResult errors) {

        if (errors.hasErrors()||errors.hasFieldErrors()){
            throw  new ValidationException(errors);
        }

        return new ResponseEntity<>(carOfferService.update(id, user, updateCarOfferRequest), HttpStatus.OK);
    }
    @InitBinder ("createCarOfferRequest")
    public void iniCreateValidation(WebDataBinder binder){
        binder.setValidator(newCarOfferValidator);
    }
    @InitBinder ("updateCarOfferRequest")
    public void iniUpdateValidation(WebDataBinder binder){
        binder.setValidator(updateCarOfferValidator);
    }
}
