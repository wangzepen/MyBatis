package com.fc.dao.impl;

import com.fc.dao.UserDao;
import com.fc.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("userDaoImpl")
public class UserDaoImpl implements UserDao {
    @Override
    public List<User> findAll() {
        ArrayList<User> list = new ArrayList<>();

        list.add(new User(1,"易烊千玺","123456"));
        list.add(new User(2, "迪丽热巴", "456789"));
        list.add(new User(3, "古力娜扎", "666666"));
        return list;
    }
}
