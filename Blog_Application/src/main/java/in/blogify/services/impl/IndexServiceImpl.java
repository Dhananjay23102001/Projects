package in.blogify.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.blogify.entity.PostEntity;
import in.blogify.repositories.PostDataRepository;
import in.blogify.services.IndexService;

@Service
public class IndexServiceImpl implements IndexService {

	@Autowired
	private PostDataRepository postDataRepo;

	@Override
	public List<PostEntity> showIndexData() {

		return postDataRepo.findAll();

	}
}
