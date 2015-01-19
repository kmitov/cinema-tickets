package com.cinema.tickets.web.bean;

import com.cinema.tickets.dto.UserDto;
import com.cinema.tickets.service.UserService;
import com.cinema.tickets.service.impl.UserServiceImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import org.springframework.security.core.userdetails.User;

public class UserBean extends SimpleUrlAuthenticationSuccessHandler {

    private UserService userService;
    private UserDto userDto;

    private UserDto loggedInUser;

    private String userName;
    private String password;
    private boolean isRegistrationSuccessful;
    private boolean isUsernameTaken;

    public UserBean()
    {
        userDto = new UserDto();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void createAccount(){
        boolean isAccountCreated = userService.createUserAccount(this.userDto);
        setRegistrationSuccessful(isAccountCreated);
        setUsernameTaken(!isRegistrationSuccessful());
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public UserDto getLoggedInUser() {
        return loggedInUser;
    }

    public boolean isUserLoggedIn() {
        String user = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        return user != null && !user.isEmpty() && !user.equals("anonymousUser");
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        final String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        loggedInUser = userService.getByUsername(userName);
        super.onAuthenticationSuccess(request, response, authentication);
    }

    public boolean isRegistrationSuccessful() {
        return isRegistrationSuccessful;
    }

    public void setRegistrationSuccessful(boolean isRegistrationSuccessful) {
        this.isRegistrationSuccessful = isRegistrationSuccessful;
    }

    public boolean isUsernameTaken() {
        return isUsernameTaken;
    }

    public void setUsernameTaken(boolean isUsernameTaken) {
        this.isUsernameTaken = isUsernameTaken;
    }
}
