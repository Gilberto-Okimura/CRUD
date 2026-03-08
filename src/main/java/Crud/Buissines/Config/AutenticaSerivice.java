package Crud.Buissines.Config;

import Crud.Repository.RepositoryOfUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class AutenticaSerivice implements UserDetailsService {


    @Autowired
    RepositoryOfUser repositoryOfUser;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDetails user = repositoryOfUser.findByEmail(email);
        if(user == null){
            throw new UsernameNotFoundException("usuarioNaoencontrado");
        }
        return user;
    }
}
