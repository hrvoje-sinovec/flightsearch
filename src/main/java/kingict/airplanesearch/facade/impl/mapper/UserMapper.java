package kingict.airplanesearch.facade.impl.mapper;

import kingict.airplanesearch.entity.User;
import kingict.airplanesearch.form.UserForm;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private final PasswordEncoder passwordEncoder;

    public UserMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public User map(UserForm userForm){
        User user = new User();
        user.setFirstname(userForm.getFirstname());
        user.setLastname(userForm.getLastname());
        user.setPassword(passwordEncoder.encode(userForm.getPassword()));

        return user;
    }

}
