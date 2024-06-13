package com.jsp.warehouse.responsedto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddressResponse {
	private int addressId;
	private String addressLine;
	private String city;
	private String state;
	private int pincode;
	private String longitude;
	private String latitude;
}