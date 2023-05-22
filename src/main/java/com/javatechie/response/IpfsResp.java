package com.javatechie.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
@SuppressWarnings("serial")
public class IpfsResp implements Serializable {

	@JsonProperty("Name")
	String name;
	
	@JsonProperty("Hash")
	String hash;
	
	@JsonProperty("Size")
	long size;
	
	@JsonProperty("Message")
	String message;
	
	@JsonProperty("Type")
	String type;
	
	@JsonProperty("Code")
	long code;
}