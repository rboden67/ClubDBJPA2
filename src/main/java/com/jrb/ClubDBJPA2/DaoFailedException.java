package com.jrb.ClubDBJPA2;

import org.springframework.dao.DataAccessException;

public class DaoFailedException extends DataAccessException {
	public DaoFailedException(String msg) {
		super(msg);
	}
}