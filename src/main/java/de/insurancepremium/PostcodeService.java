package de.insurancepremium;

import com.opencsv.bean.CsvToBeanBuilder;
import de.insurancepremium.models.Postcode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostcodeService {

    private final PostcodeRepository postcodeRepository;

    public List<Postcode> getAllEmployees() {
        return postcodeRepository.findAll();
    }

    public List<Postcode> savePostcodes() throws FileNotFoundException {
        String fileName = "src/main/resources/postcodes.csv";

        List<Postcode> postcodes = new CsvToBeanBuilder(new FileReader(fileName))
                .withType(Postcode.class)
                .build()
                .parse();

        return postcodeRepository.saveAll(postcodes);
    }

    public List<Postcode> findPostcode(String state, String district, String city, String location, String area, String zipcode) {
        return postcodeRepository.findPostcode(state, district, city, location, area, zipcode);
    }
}
