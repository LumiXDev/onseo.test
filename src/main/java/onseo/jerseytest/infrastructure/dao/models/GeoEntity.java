package onseo.jerseytest.infrastructure.dao.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GeoEntity {
    private double lat;
    private double lng;
}
