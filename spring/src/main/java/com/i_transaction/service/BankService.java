package com.i_transaction.service;

public interface BankService {

	/**
	 * @param count
	 * @param userIdA
	 * @param userIdB
	 */
	public void transferAccounts(int count,int userIdA,int userIdB);
}
