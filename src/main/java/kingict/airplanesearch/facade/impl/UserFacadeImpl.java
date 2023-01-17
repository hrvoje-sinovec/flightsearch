package kingict.airplanesearch.facade.impl;

import kingict.airplanesearch.entity.User;
import kingict.airplanesearch.facade.UserFacade;
import kingict.airplanesearch.facade.impl.mapper.UserMapper;
import kingict.airplanesearch.form.UserForm;
import kingict.airplanesearch.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserFacadeImpl implements UserFacade {

    private final UserMapper userMapper;
    private final UserService service;


    public UserFacadeImpl(UserMapper userMapper, UserService service) {
        this.userMapper = userMapper;
        this.service = service;
    }

    @Override
    public void register(UserForm userForm) {

        User user = userMapper.map(userForm);
        user.setRoles("USER");
        user.setUsername(userForm.getFirstname().toLowerCase().charAt(0) + userForm.getLastname().toLowerCase());
        service.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return service.findUserById(id);
    }
}
