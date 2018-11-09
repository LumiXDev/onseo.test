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
public class GeoEntity {
    private double lat;
    private double lng;
}
