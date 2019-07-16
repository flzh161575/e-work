package dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.prototype.IAccountDao;
import entity.Account;
import util.DateUtil;

@Repository
public class AccountDaoSpringImpl implements IAccountDao {

	@Autowired
	private DataSource ds;

	@Autowired
	private JdbcTemplate jt;

	@Override
	public void saveOrUpdate(Account act) {
		if (act.getId() == 0) {
			jt.update("insert into t_account(actNo,password,enable,createDate,balance) " + "values(?,?,?,?,?)",
					new Object[] { act.getActNo(), act.getPassword(), act.isEnable(), act.getCreateDate(),
							act.getBalance() });
		} else {
			jt.update("update t_account set " + "actNo=?,password=?,enable=?,createDate=?,balance=? " + "where id=?",
					new Object[] { act.getActNo(), act.getPassword(), act.isEnable(), act.getCreateDate(),
							act.getBalance(), act.getId() });
		}
	}

	@Override
	public void saveAccounts(List<Account> acts) {
		String sql = "insert into t_account(actNo,password,enable,createDate,balance) " + "values(?,?,?,?,?)";
		List<Object[]> params = new ArrayList<Object[]>();
		for (Account act : acts) {
			Object[] o = new Object[5];
			o[0] = act.getActNo();
			o[1] = act.getPassword();
			o[2] = act.isEnable();
			o[3] = act.getCreateDate();
			o[4] = act.getBalance();
			params.add(o);
		}
		jt.batchUpdate(sql, params);
	}

	@Override
	public void saveAccounts2(List<Account> acts) {
		String sql = "insert into t_account(actNo,password,enable,createDate,balance) " + "values(?,?,?,?,?)";
		jt.batchUpdate(sql, new BatchPreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setString(1, acts.get(i).getActNo());
				ps.setString(2, acts.get(i).getPassword());
				ps.setBoolean(3, acts.get(i).isEnable());
				ps.setString(4, DateUtil.formatDate(acts.get(i).getCreateDate(), "yyyy-MM-dd HH:mm:ss"));
				ps.setDouble(5, acts.get(i).getBalance());
			}

			@Override
			public int getBatchSize() {
				return acts.size();
			}
		});
	}

	@Override
	public void delete(int id) {
		// -- jdbcTemplate
		jt.update("delete from t_account where id=?", new Object[] { id });
	}

	@Override
	public Account findByID(int id) {
		return jt.queryForObject("select * from t_account where id=?", new Object[] { id },
				new BeanPropertyRowMapper<Account>(Account.class));
	}

	@Override
	public Account findByActNo(String actNo) {
		return jt.queryForObject("select * from t_account where actNo=?", new Object[] { actNo },
				new BeanPropertyRowMapper<Account>(Account.class));
	}

	@Override
	public List<Account> findAll() {
		return jt.query("select * from t_account", new BeanPropertyRowMapper<Account>(Account.class));
	}

	@Override
	public List<Account> findPaged(int offset, int pageSize) {
		return jt.query("select * from t_account limit ? , ?", new Object[] { offset, pageSize },
				new BeanPropertyRowMapper<Account>(Account.class));
	}

	public int totalPages(int pageSize) {
		return 0;
	}

}
