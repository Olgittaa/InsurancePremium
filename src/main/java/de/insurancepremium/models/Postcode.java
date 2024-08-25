package de.insurancepremium.models;

import com.opencsv.bean.CsvBindByName;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Data
@ToString
@Entity
@Table(name = "postcode")
@NoArgsConstructor
public class Postcode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @CsvBindByName(column = "REGION1")
    private String state;

    @CsvBindByName(column = "REGION3")
    private String district;

    @CsvBindByName(column = "REGION4")
    private String city;

    @CsvBindByName(column = "ORT")
    private String location;

    @CsvBindByName(column = "AREA1")
    private String area;

    @CsvBindByName(column = "POSTLEITZAHL")
    private String zipcode;

    public Postcode(String state, String district, String city, String location, String area, String zipcode) {
        this.state = state;
        this.district = district;
        this.city = city;
        this.location = location;
        this.area = area;
        this.zipcode = zipcode;
    }
}