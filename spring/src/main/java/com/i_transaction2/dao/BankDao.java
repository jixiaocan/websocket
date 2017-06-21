/**
 * 
 */
package com.i_transaction2.dao;

/**
 * 
 * @author xiaocan
 * 2017年6月21日
 */
public interface BankDao {
	public void inMoney(int money,int userId);
	
	public void outMoney(int money,int userId);
}
