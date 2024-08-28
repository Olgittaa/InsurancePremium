package de.insurancepremium;

import de.insurancepremium.models.Postcode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/postcode")
@RequiredArgsConstructor
@Validated
public class PostcodeController {
    private final PostcodeService postcodeService;

    @GetMapping("/")
    public ResponseEntity<List<Postcode>> getAllPostcodes(Model model){
        List<Postcode> postcodes = postcodeService.getAllEmployees();

        model.addAttribute("stateWiseList",postcodes.subList(1,postcodes.size()-1));

        return ResponseEntity.ok().body(postcodes);
    }

    @PostMapping("/")
    public ResponseEntity<List<Postcode>> saveAllPostcodes() throws FileNotFoundException {
        return ResponseEntity.ok().body(this.postcodeService.savePostcodes());
    }

    @GetMapping("/find")
    public ResponseEntity<List<Postcode>> findPostcode(
            @RequestParam(required = false, value = "state") Optional<String> state,
            @RequestParam(required = false, value = "district") Optional<String> district,
            @RequestParam(required = false, value = "city") Optional<String> city,
            @RequestParam(required = false, value = "location") Optional<String> location,
            @RequestParam(required = false, value = "area") Optional<String> area,
            @RequestParam(required = false, value = "zipcode") Optional<String> zipcode
    ){
        return ResponseEntity.ok().body(postcodeService.findPostcode(
                state.orElse(""),
                district.orElse(""),
                city.orElse(""),
                location.orElse(""),
                area.orElse(""),
                zipcode.orElse("")));
    }
}
