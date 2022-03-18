package me.hajoo.springcrud.service;

import me.hajoo.springcrud.dto.CreateUserRequest;
import me.hajoo.springcrud.entity.User;
import me.hajoo.springcrud.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Test
    @DisplayName("유저 생성")
    public void 유저_생성(){
        //given
        final CreateUserRequest request = new CreateUserRequest("홍길동", 20, 180, 75);
        final User user = new User("홍길동", 20, 180, 75);
        given(userRepository.save(any(User.class))).willReturn(user);

        //when
        final User result = userService.createUser(request);

        //then
        verify(userRepository, times(1)).save(any());
        assertThat(result).isEqualTo(user);
    }
}