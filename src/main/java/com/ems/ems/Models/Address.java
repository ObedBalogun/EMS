package com.ems.ems.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {
    private String city;
    private String postalCode;
    private String state;
    private String addressLine;
}
