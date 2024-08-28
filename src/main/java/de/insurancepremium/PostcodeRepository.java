package de.insurancepremium;

import de.insurancepremium.models.Postcode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PostcodeRepository extends JpaRepository<Postcode, Integer> {

    @Query(value = "SELECT * FROM postcode " +
            "WHERE state like CONCAT('%',:state,'%')" +
            "AND district like CONCAT('%',:district,'%')" +
            "AND city like CONCAT('%',:city,'%')" +
            "AND location like CONCAT('%',:location,'%')" +
            "AND area like CONCAT('%',:area,'%')" +
            "AND zipcode like CONCAT('%',:zipcode,'%')", nativeQuery = true)
    List<Postcode> findPostcode(String state, String district, String city, String location, String area, String zipcode);
}
