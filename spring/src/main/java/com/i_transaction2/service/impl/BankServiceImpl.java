/**
 * 
 */
package com.i_transaction2.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.i_transaction2.dao.BankDao;
import com.i_transaction2.service.BankService;

/**
 * 
 * @author xiaocan
 * 2017年6月21日
 */
@Transactional
public class BankServiceImpl implements BankService {

	private BankDao bankDao;
	
	public void setBankDao(BankDao bankDao){
		this.bankDao = bankDao;
	}
	public void transferAccounts(int count, int userIdA, int userIdB) {
		bankDao.outMoney(count, userIdA);
		bankDao.inMoney(count, userIdB);
	}

}
