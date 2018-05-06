package com.jrb;

import org.springframework.dao.DataAccessException;

public class DaoFailedException extends DataAccessException {
	public DaoFailedException(String msg) {
		super(msg);
	}
}