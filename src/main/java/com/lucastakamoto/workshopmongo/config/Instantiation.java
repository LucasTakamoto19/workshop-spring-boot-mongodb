package com.lucastakamoto.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import com.lucastakamoto.workshopmongo.domain.Post;
import com.lucastakamoto.workshopmongo.domain.User;
import com.lucastakamoto.workshopmongo.dto.AuthorDTO;
import com.lucastakamoto.workshopmongo.dto.CommentDTO;
import com.lucastakamoto.workshopmongo.repository.PostRepository;
import com.lucastakamoto.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... arg0) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post pos1 = new Post(null, sdf.parse("21/03/2020"), "Partiu Viagem", "Vou viajar para o Chile. Abraços!", new AuthorDTO(maria));
        Post pos2 = new Post(null, sdf.parse("24/03/2020"), "Bom dia", "Acordei no Chile hoje.", new AuthorDTO(maria));

        CommentDTO c1 = new CommentDTO("Boa viagem mano",sdf.parse("21/03/2018"), new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO("Aproveite",sdf.parse("22/03/2018"), new AuthorDTO(bob));
        CommentDTO c3 = new CommentDTO("Boa viagem mano",sdf.parse("23/03/2018"), new AuthorDTO(alex));

        pos1.getComments().addAll(Arrays.asList(c1, c2));
        pos2.getComments().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(pos1, pos2));

        maria.getPosts().addAll(Arrays.asList(pos1, pos2));
        userRepository.save(maria);
    }

}
