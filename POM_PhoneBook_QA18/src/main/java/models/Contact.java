package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder

public class Contact {

    public String name;
    public String lastName;
    public String email;
    public String phone;
    public String address;
    public String description;
}
