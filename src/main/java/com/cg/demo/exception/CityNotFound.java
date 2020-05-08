package com.cg.demo.exception;

public class CityNotFound extends RuntimeException{

	public CityNotFound(String msg) {
		super(msg) ;
	}
}