package com.example.demo.service;

import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.domain.els.Book;
import com.example.demo.domain.els.UserEls;
import com.example.demo.els.config.ElsConfig;
import com.example.demo.els.service.BookService;
import com.example.demo.els.service.UserElsService;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import org.aspectj.lang.annotation.Before;
import org.elasticsearch.action.search.SearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Service
public class SignupService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private ElasticsearchTemplate esTemplate;


    /**
     *
     * set up a default customer with two roles USER and ADMIN
     *
     */
    @PostConstruct
    private void setupDefaultUser() {
        //-- just to make sure there is an ADMIN user exist in the database for testing purpose
        if (userRepository.count() == 0) {
            Role roleUser= new Role("USER");
            Role roleAdmin= new Role("ADMIN");
            roleRepository.save(roleUser);
            roleRepository.save(roleAdmin);
            userRepository.save(new User("admin",
                    passwordEncoder.encode("pass"),
                    Arrays.asList(roleAdmin,roleUser)));
        }
/*



        esTemplate.deleteIndex(Book.class);
        esTemplate.createIndex(Book.class);
        esTemplate.putMapping(Book.class);
        esTemplate.refresh(Book.class);

         */



/*


        try {
            SearchResponse response = elsConfig.client().prepareSearch().execute().actionGet();

        } catch (Exception e) {
            e.printStackTrace();
        }
 */


    }



}
