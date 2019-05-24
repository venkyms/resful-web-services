package com.venkyms.rest.webservices.resfulwebservices.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class UserDaoService {

  private static List<User> userList = new ArrayList<>();
  private static int usersCount = 3;

  static {
    userList.add(new User(1, "Venkat", new Date()));
    userList.add(new User(2, "Subramanian", new Date()));
    userList.add(new User(3, "subbiah", new Date()));
  }

  public List<User> findAll() {
    return userList;
  }

  public User save(User user) {
    if (user.getId() == null) {
      user.setId(++usersCount);
      userList.add(user);
    }
    return user;
  }

  public User findOne(int id) {
    Optional<User> optionalUser = userList.stream().filter(user -> user.getId() == id).findFirst();
    optionalUser.orElseThrow(() -> new UserNotFoundException("id-" + id));
    return optionalUser.get();
  }

  public boolean deleteById(int id) {
    return userList.removeIf(user -> user.getId() == id);
  }
}
