package com.example.demo.service;

import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.domain.els.Comment;
import com.example.demo.domain.els.Post;
import com.example.demo.domain.els.UserEls;
import com.example.demo.els.repository.PostRepository;
import com.example.demo.els.repository.UserElsRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    private PostRepository postRepository;
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

        Book book = new Book("1001", "Elasticsearch Basics", "Rambabu Posa", "23-FEB-2017");
        Book book2 = new Book("1002", "pouloulou", "tesyt", "23-Mars-2017");

/*



 */



         SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());



        UserEls author= new UserEls(1l,"Julan");
        Comment comment= new Comment("interessé",timestamp,author);




        Post post = new Post("testTitle","la desc",timestamp,timestamp,timestamp,author,
                Arrays.asList(comment));


        esTemplate.deleteIndex(Post.class);
        esTemplate.createIndex(Post.class);
        esTemplate.putMapping(Post.class);
        esTemplate.refresh(Post.class);

        postRepository.save(post);

        System.out.println(postRepository.findOne(post.getId()));


    }



}
