package com.demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Data;

/**
 * @author amritesh
 *
 */
@Data
@Builder
public class AuthResponse {

	private boolean status;

	@JsonInclude(Include.NON_NULL)
	private String errorMessage;
}
