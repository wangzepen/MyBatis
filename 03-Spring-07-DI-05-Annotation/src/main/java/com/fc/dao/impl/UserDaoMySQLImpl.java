package com.fc.dao.impl;

import com.fc.dao.UserDao;
import com.fc.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("userDaoMySQLImpl")
public class UserDaoMySQLImpl implements UserDao {
    @Override
    public List<User> findAll() {
        ArrayList<User> list = new ArrayList<>();

        list.add(new User(4,"汤布力不","1456"));
        list.add(new User(5, "贾晓东", "4789"));
        list.add(new User(6, "无锡底细", "666"));
        return list;
    }
}
