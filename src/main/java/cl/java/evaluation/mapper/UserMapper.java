package cl.java.evaluation.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.java.evaluation.dto.UserDto;
import cl.java.evaluation.model.User;

@Component
public class UserMapper {

    @Autowired
    private ModelMapper modelMapper;

    public User convertUserRequestToUser(UserDto userDto) {
        return this.modelMapper.map(userDto, User.class);
    }

    public UserDto convertUserToUserResponse(User user) {
        return this.modelMapper.map(user, UserDto.class);
    }

}
