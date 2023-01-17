package kingict.airplanesearch.service;

import kingict.airplanesearch.entity.User;

public interface UserService {

    public void save(User user);

    public User findUserById(Long id);
}
