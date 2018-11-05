package onseo.jerseytest.infrastructure.dao.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
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
        return "users/";
    }
}
