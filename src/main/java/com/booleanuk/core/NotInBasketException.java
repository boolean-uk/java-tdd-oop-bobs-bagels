package com.booleanuk.core;

public class NotInBasketException extends Exception{
	public NotInBasketException(String id){
		super("No item with id: "+id+" in basket.");
	}
}
