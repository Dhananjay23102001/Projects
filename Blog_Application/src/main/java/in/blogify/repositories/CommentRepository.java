package in.blogify.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.blogify.entity.CommentEntity;


public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {

      public  List<CommentEntity> findByPostPostId(Integer postId);
      
   
}
