package de.insurancepremium;

import de.insurancepremium.models.Postcode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/postcode")
@RequiredArgsConstructor
@Validated
public class PostcodeController {
    private final PostcodeService postcodeService;

    @GetMapping("/")
    public ResponseEntity<List<Postcode>> getAllPostcodes(){
        return ResponseEntity.ok().body(postcodeService.getAllEmployees());
    }

    @PostMapping("/")
    public List<Postcode> saveAllPostcodes() throws FileNotFoundException {
        return this.postcodeService.savePostcodes();
    }
}