package ru.jmentor.SpringBootExample.security;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.security.core.userdetails.UserDetails;import org.springframework.security.core.userdetails.UserDetailsService;import org.springframework.security.core.userdetails.UsernameNotFoundException;import org.springframework.stereotype.Service;import ru.jmentor.SpringBootExample.model.User;import ru.jmentor.SpringBootExample.repository.UserRepository;import java.util.Optional;@Servicepublic class UserDetailsServiceImpl implements UserDetailsService {    private final UserRepository userRepository;    @Autowired    public UserDetailsServiceImpl(UserRepository userRepository) { this.userRepository = userRepository; }    @Override    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {        Optional<User> optionalUsers = Optional.ofNullable(userRepository.findByUserName(userName));        optionalUsers.orElseThrow(() -> new UsernameNotFoundException("Username not found"));        return optionalUsers.map(User::new).get();    }}