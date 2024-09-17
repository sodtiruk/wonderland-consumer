package th.co.priorsolution.project.wonderlandconsumer.repository.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import th.co.priorsolution.project.wonderlandconsumer.model.UserModel;
import th.co.priorsolution.project.wonderlandconsumer.repository.UserNativeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

@Repository
public class UserNativeRepositoryImpl implements UserNativeRepository {

    private JdbcTemplate jdbcTemplate;

    public UserNativeRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertManyUser(List<UserModel> userModels) {

        List<Object> paramList = new ArrayList<>();
        String sql = " insert into users (user_id, user_name, user_atk, user_balance) values ";

        StringJoiner stringJoiner = new StringJoiner(",");
        for (UserModel u: userModels) {
            String value = "((select max(user_id)+1 from users u), ?, ?, ?)";

            paramList.add(u.getUserName());
            paramList.add(u.getUserAtk());
            paramList.add(u.getUserBalance());

            stringJoiner.add(value);
        }
        sql += stringJoiner.toString();

        int insertedRow = this.jdbcTemplate.update(sql, paramList.toArray());
        return insertedRow;
    }
}
