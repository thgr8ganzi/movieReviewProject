package com.example.moviereview.repository;

import com.example.moviereview.domain.entity.Member;
import com.example.moviereview.domain.entity.Movie;
import com.example.moviereview.domain.entity.Review;
import com.example.moviereview.domain.repository.ReviewRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
public class ReviewRepositoryTest {

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    public void inserMovieReviews(){
        IntStream.rangeClosed(1,200).forEach(i -> {
            Long mno = (long)(Math.random()*100) + 1;

            Long mid = ((long)(Math.random()*100) + 1);
            Member member = Member.builder().mid(mid).build();

            Review movReview = Review.builder()
                    .member(member)
                    .movie(Movie.builder().mno(mno).build())
                    .grade((int) (Math.random()*5) + 1)
                    .text("이영화에 대한느낌" + i).build();

            reviewRepository.save(movReview);
        });
    }

    @Test
    public void testGetMovieReviews(){
        Movie movie = Movie.builder().mno(92L).build();

        List<Review> result = reviewRepository.findByMovie(movie);

        result.forEach(movieReview -> {
            System.out.print(movieReview.getReviewnum());
            System.out.print("\t" + movieReview.getGrade());
            System.out.print("\t"+ movieReview.getText());
            System.out.print("\t" + movieReview.getMember().getEmail());
            System.out.println("==========================================");
        });
    }
}
