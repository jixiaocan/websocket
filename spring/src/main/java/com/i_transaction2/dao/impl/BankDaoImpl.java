/**
 * 
 */
package com.i_transaction2.dao.impl;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.i_transaction2.dao.BankDao;

/**
 * 
 * @author xiaocan
 * 2017年6月21日
 */
public class BankDaoImpl implements BankDao {
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public void inMoney(int money, int userId) {
		String sql = "update t_count set count=count+:money where userId=:userId";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("money", money);
		sps.addValue("userId", userId);
		namedParameterJdbcTemplate.update(sql, sps);
	}

	public void outMoney(int money, int userId) {
		String sql = "update t_count set count=count-:money where userId=:userId";
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("money", money);
		sps.addValue("userId", userId);
		namedParameterJdbcTemplate.update(sql, sps);
		
	}

}
