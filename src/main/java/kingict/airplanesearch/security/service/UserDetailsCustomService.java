package kingict.airplanesearch.security.service;


import kingict.airplanesearch.entity.User;
import kingict.airplanesearch.exceptions.ValidationException;
import kingict.airplanesearch.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsCustomService implements UserDetailsService {

    private final UserRepository repository;

    public UserDetailsCustomService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = repository.findByUsername(username)
                .orElseThrow(() ->
                        new ValidationException("Ne postoji user s usernamemom: " + username));

        return new UserDetailsCustom(user);
    }
}
