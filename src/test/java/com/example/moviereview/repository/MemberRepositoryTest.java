package com.example.moviereview.repository;

import com.example.moviereview.domain.entity.Member;
import com.example.moviereview.domain.repository.MemberRepository;
import com.example.moviereview.domain.repository.ReviewRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.IntStream;

@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    public void insertMember(){
        IntStream.rangeClosed(1,100).forEach(i -> {
            Member member = Member.builder().email("r" + i + "@zerock.org").pw("1111").nickname("reviewer" + i).build();
            memberRepository.save(member);
        });
    }

    @Transactional
    @Commit
    @Test
    public void testDeleteMember(){
        Long mid = 2L;

        Member member = Member.builder().mid(mid).build();

        reviewRepository.deleteByMember(member);
        memberRepository.deleteById(mid);
    }
}
