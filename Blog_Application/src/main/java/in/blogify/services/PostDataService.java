package in.blogify.services;

import java.util.List;

import in.blogify.bind.PostBindClass;
import in.blogify.entity.PostEntity;

public interface PostDataService {

	public boolean savaData(PostBindClass bindData);
	
	public List<PostEntity> loadData();
}
