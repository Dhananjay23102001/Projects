package in.blogify.services.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.blogify.bind.PostBindClass;
import in.blogify.entity.PostEntity;
import in.blogify.entity.UserEntity;
import in.blogify.repositories.PostDataRepository;
import in.blogify.repositories.UserRepository;
import in.blogify.services.PostDataService;

@Service
public class PostDataServiceImpl implements PostDataService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private PostDataRepository postDataRepo;

	@Autowired
	private HttpSession httpSession;

	@Override
	public boolean savaData(PostBindClass bindData) {

		PostEntity postEntity = new PostEntity();

		BeanUtils.copyProperties(bindData, postEntity);

		Integer userId = (Integer) httpSession.getAttribute("userId");

		// UserEntity userEntity = userRepo.findById(userId).get();

		Optional<UserEntity> findById = userRepo.findById(userId);

		if (findById.isPresent()) {

			UserEntity userEntity = findById.get();
			postEntity.setUser(userEntity);

		}

		postDataRepo.save(postEntity);

		return true;
	}

	@Override
	public List<PostEntity> loadData() {

		Integer userId = (Integer) httpSession.getAttribute("userId");

		Optional<UserEntity> findById = userRepo.findById(userId);

		if (findById.isPresent()) {

			UserEntity userEntity = findById.get();

			return userEntity.getAllPost();

		}

		return Collections.emptyList();
	}

}
