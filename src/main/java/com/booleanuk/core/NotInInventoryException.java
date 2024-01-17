package com.booleanuk.core;

public class NotInInventoryException extends Exception {
	public NotInInventoryException(int id) {
		super("No item with id:" + id + " in inventory.");
	}
}
