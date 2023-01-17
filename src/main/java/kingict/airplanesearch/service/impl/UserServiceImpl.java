package kingict.airplanesearch.service.impl;

import com.amadeus.exceptions.ResponseException;
import kingict.airplanesearch.entity.User;
import kingict.airplanesearch.repository.UserRepository;
import kingict.airplanesearch.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    public void save(User user){
        repository.save(user);
    }

    @Override
    public User findUserById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Ne postoji user s id-em: " + id));
    }
}
