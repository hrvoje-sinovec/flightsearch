package kingict.airplanesearch.service.impl;

import kingict.airplanesearch.entity.User;
import kingict.airplanesearch.repository.UserRepository;
import kingict.airplanesearch.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    public void save(User user) {
        try {
            if (Objects.equals(user.getUsername(), "hsinovec")) {
                throw new IllegalArgumentException();
            } else {
                repository.save(user);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Did not create the user because the username was already used.");
        }
    }

    @Override
    public User findUserById(Long id) {
        try {
            return repository.findById(id).orElseThrow(() -> new RuntimeException("Ne postoji user s id-em: " + id));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return repository.findById(1L).orElseThrow(RuntimeException::new);
        }
    }
}
