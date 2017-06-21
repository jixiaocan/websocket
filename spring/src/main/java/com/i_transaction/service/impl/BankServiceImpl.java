package com.i_transaction.service.impl;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.i_transaction.dao.BankDao;
import com.i_transaction.service.BankService;


public class BankServiceImpl implements BankService{

	private BankDao bankDao;
	
	private TransactionTemplate transactionTemplate;
	
	public void setBankDao(BankDao bankDao) {
		this.bankDao = bankDao;
	}

	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

	public void transferAccounts(final int count, final int userIdA, final int userIdB) {
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus arg0) {
				bankDao.outMoney(count, userIdA);
				bankDao.inMoney(count, userIdB);				
			}
		});
	}

}
