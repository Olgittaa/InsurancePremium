package de.insurancepremium;

import de.insurancepremium.models.Postcode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostcodeRepository extends JpaRepository<Postcode, Integer> {
}