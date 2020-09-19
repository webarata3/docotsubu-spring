package first.docotsubu.service;

import java.util.Objects;

import org.springframework.stereotype.Service;

import first.docotsubu.dto.User;

@Service
public class LoginService {
    public boolean login(User user) {
        Objects.requireNonNull(user);
        // フォームからの入力なのでnullはありえない
        Objects.requireNonNull(user.getPass());

        return Objects.equals(user.getPass(), "1234");
    }
}
