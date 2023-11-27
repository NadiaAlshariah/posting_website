package posting_website.User;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AppUserService {
    private final AppUserRepository appUserRepository;

    @Autowired
    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public List<AppUser> getUsers(){
        return appUserRepository.findAll();
    }

    public void addNewUser(AppUser appUser) {
        Optional<AppUser> userOptional = appUserRepository.findUserByEmail(appUser.getEmail());
        if (userOptional.isPresent()){
            throw new IllegalStateException("Email taken");
        }
        appUserRepository.save(appUser);
    }

    public void deleteUser(Long userId) {
        boolean exists = appUserRepository.existsById(userId);
        if (!exists){
            throw new IllegalStateException("User with id " + userId + "does not exist");
        }
        appUserRepository.deleteById(userId);
    }

    @Transactional
    public void updateUser(Long userId, String name, String email) {
        AppUser appUser = appUserRepository.findById(userId).orElseThrow(() -> new IllegalStateException(
                "user with id " + userId + " doesnt exist"));

        if (name != null && !name.isEmpty() && ! Objects.equals(appUser.getDisplay_name(), name)){
            appUser.setDisplay_name(name);
        }

        if (email != null && !email.isEmpty() && ! Objects.equals(appUser.getEmail(), email)){
            Optional<AppUser> userOptional = appUserRepository.findUserByEmail(email);
            if (userOptional.isPresent()){
                throw new IllegalStateException("Email taken");
            }
            appUser.setEmail(email);
        }

    }
}
