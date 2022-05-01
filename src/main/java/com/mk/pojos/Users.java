package com.mk.pojos;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(setterPrefix = "set")
public final class Users {

	private String name;
	private String job;

}
