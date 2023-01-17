package kingict.airplanesearch.facade;


import kingict.airplanesearch.entity.User;
import kingict.airplanesearch.form.UserForm;

public interface UserFacade {

    public void register(UserForm userForm);

    public User getUserById(Long id);
}
