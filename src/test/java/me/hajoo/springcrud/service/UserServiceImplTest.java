package me.hajoo.springcrud.service;

import me.hajoo.springcrud.dto.CreateUserRequest;
import me.hajoo.springcrud.dto.UpdateUserRequest;
import me.hajoo.springcrud.dto.UserResponse;
import me.hajoo.springcrud.entity.User;
import me.hajoo.springcrud.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.*;

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

    @Test
    @DisplayName("유저 조회")
    public void 유저_조회(){
        //given
        final List<UserResponse> expected = List.of(
                new UserResponse(1L, "홍길동", 20, 180, 75),
                new UserResponse(2L, "홍길동2", 20, 180, 75),
                new UserResponse(3L, "홍길동3", 20, 180, 75)
        );
        given(userRepository.findAll()).willReturn(List.of(
                new User("홍길동", 20, 180, 75),
                new User("홍길동2", 20, 180, 75),
                new User("홍길동3", 20, 180, 75)
        ));

        //when
        final List<UserResponse> result = userService.findUsers();

        //then
        verify(userRepository, times(1)).findAll();
        assertThat(result).usingRecursiveComparison()
                .ignoringFields("id")
                .ignoringCollectionOrder()
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("유저 수정")
    public void 유저_수정(){
        //given
        final User expected = new User("홍길동2", 21, 185, 80);
        final UpdateUserRequest request = new UpdateUserRequest(1L, "홍길동2", 21, 185, 80);
        given(userRepository.findById(1L)).willReturn(Optional.of(new User("홍길동", 20, 180, 75)));

        //when
        final User result = userService.updateUser(request);

        //then
        verify(userRepository, times(1)).findById(1L);
        assertThat(result).usingRecursiveComparison()
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("유저 삭제 실패")
    public void 유저_삭제_실패(){
        //given
        willThrow(IllegalArgumentException.class).given(userRepository).deleteById(1L);

        //when, then
        assertThatThrownBy(() -> userService.deleteUser(1L))
                .isInstanceOf(IllegalArgumentException.class);
        verify(userRepository, times(1)).deleteById(1L);
    }

    @Test
    @DisplayName("유저 삭제 성공")
    public void 유저_삭제_성공(){
        //given
        willDoNothing().given(userRepository).deleteById(1L);

        //when
        final Long result = userService.deleteUser(1L);

        //then
        assertThat(result).isEqualTo(1L);
    }
}