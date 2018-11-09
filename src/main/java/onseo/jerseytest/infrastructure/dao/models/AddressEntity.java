package onseo.jerseytest.infrastructure.dao.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Builder;

@Getter
@Builder
@Setter
@AllArgsConstructor
public class AddressEntity {
    private String street;
    private String suite;
    private String city;
    private String zipcode;

    private GeoEntity geo;
}
