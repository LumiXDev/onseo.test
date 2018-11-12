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
public class UserEntity implements Entity {
    private int id;
    private String name;
    private String username;
    private String email;

    private AddressEntity address;

    private String phone;
    private String website;

    private CompanyEntity company;

    public String getEndpointSuffix() {
        return "/users/";
    }
}
