package cl.java.evaluation.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.java.evaluation.dto.UserDto;
import cl.java.evaluation.mapper.UserMapper;
import cl.java.evaluation.model.User;
import cl.java.evaluation.repository.UserRepository;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    public List<User> getAllUser() {
        List<User> listUser = new ArrayList<>();
        try {
            listUser.addAll(userRepository.getAllUser());
            log.info("Total rows {}", listUser.size());
            return listUser;
        } catch (Exception e) {
            log.error("Exception", e);
            throw e;
        }
    }

    public UserDto createUser(UserDto userDto) throws Exception {

        LocalDateTime fechaHoraActual = LocalDateTime.now();
        List<User> user = userRepository.findByEmail(userDto.getEmail());
        UserDto userResponse = new UserDto();

        try {
            if (user.isEmpty()) {
                validMail(userDto.getEmail());
                validPass(userDto.getPassword());

                User us = userMapper.convertUserRequestToUser(userDto);

                us.setName(userDto.getName());
                us.setEmail(userDto.getEmail());
                us.setPassword(userDto.getPassword());
                us.setCreated(fechaHoraActual);
                us.setModified(fechaHoraActual);
                us.setLast_login(fechaHoraActual);
                us.setIsactive(true);
                userRepository.save(us);

                userResponse = userMapper.convertUserToUserResponse(us);

            } else {
                log.info("El correo {} ya esta registrado.", userDto.getEmail());
                throw new SecurityException("El correo " + userDto.getEmail() + " ya esta registrado.");
            }
            return userResponse;
        } catch (Exception e) {
            log.error("Exception", e);
            throw e;
        }
    }

    public void validMail(String mail) throws Exception {
        String regex = "^[\\w!#$%&amp;'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&amp;'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(mail);
        if (!matcher.matches()) {
            throw new SecurityException("El correo " + mail + " no tiene formato valido.");
        }
    }

    public void validPass(String pass) throws Exception {
        String regex = "^(?=\\w*\\d)(?=\\w*[a-z])\\S{8,16}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(pass);
        if (!matcher.matches()) {
            throw new SecurityException("La contraseña debe contener minimo 8 caracter y al menos un numero.");
        }
    }
}
