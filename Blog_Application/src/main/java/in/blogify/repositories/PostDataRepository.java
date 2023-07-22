package in.blogify.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.blogify.entity.PostEntity;

public interface PostDataRepository extends JpaRepository<PostEntity, Integer> {

}
