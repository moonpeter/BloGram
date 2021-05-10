package com.blogram.demo;

import com.blogram.demo.domain.Board;
import com.blogram.demo.domain.User;
import com.blogram.demo.repository.BoardRepository;
import com.blogram.demo.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


@RunWith(SpringRunner.class)
@DataJpaTest        // JPA 테스트 전용 어노테이션
public class JpaMappingTest {
    private final String boardTestTitle = "테스트 제목";
    private final String email = "moonpeter@kakao.com";

    @Autowired
    UserRepository userRepository;

    @Autowired
    BoardRepository boardRepository;

    @Before     // 각 테스트가 실행되기 전에 실행될 메서드
    public void init() {
        User user = userRepository.save(User.builder()
                .name("moonpeter")
                .password("1111")
                .email("moonpeter@kakao.com")
                .createdDate(LocalDateTime.now())
                .build());

        boardRepository.save(Board.builder()
                .title(boardTestTitle)
                .thumbnail("테스트 썸네일")
                .content("테스트 콘텐트")
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .user(user)
                .build());
    }

    @Test       // 실제 테스트가 진행될 메서드
    public void 제대로_생성됐는지_테스트() {
        User user = userRepository.findByEmail(email);
        assertThat(user.getName(), is("moonpeter"));
        assertThat(user.getPassword(), is("1111"));
        assertThat(user.getEmail(), is(email));

        Board board = boardRepository.findByUser(user);
        assertThat(board.getTitle(), is(boardTestTitle));
        assertThat(board.getThumbnail(), is("테스트 썸네일"));
        assertThat(board.getContent(), is("테스트 콘텐트"));
    }
}
