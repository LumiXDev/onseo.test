package onseo.jerseytest.infrastructure.dao.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddressEntity {
    private String street;
    private String suite;
    private String city;
    private String zipcode;

    private GeoEntity geo;
}
