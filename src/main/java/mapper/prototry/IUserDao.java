package mapper.prototry;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import entity.User;

/**
 * UserDao
 * @author Administrator
 *
 */
@Mapper
public interface IUserDao {
	void save(User user);
	@Select("select * from t_user where id=#{id}")
	User findUser(int id);
}
