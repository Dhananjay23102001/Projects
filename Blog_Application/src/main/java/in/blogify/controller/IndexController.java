package in.blogify.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import in.blogify.constant.ModelAttributes;
import in.blogify.constant.UIConstant;
import in.blogify.entity.PostEntity;
import in.blogify.repositories.PostDataRepository;

@Controller
public class IndexController {

	@Autowired
	private PostDataRepository postDataRepo;

	@GetMapping("/")
	public String loadIndexPage(Model model) {

		// List<PostEntity> showIndexData = indexService.showIndexData();

		List<PostEntity> showIndexData = postDataRepo.findAll();

		model.addAttribute(ModelAttributes.POSTS, showIndexData);

		return UIConstant.INDEX;
	}

	@GetMapping("/post/{postId}")
	public String loadParticularViewPage(@PathVariable Integer postId, Model model) {

		// Object nullObject = null;
		// Accessing a member or invoking a method on nullObject
		// nullObject.toString();

		Optional<PostEntity> findById = postDataRepo.findById(postId);

		if (findById.isPresent()) {

			PostEntity postEntity = findById.get();

			model.addAttribute(ModelAttributes.POST, postEntity);

		}

		return UIConstant.PARTICULARPOST;

	}

	@GetMapping("/postlogin")
	public String logout() {

		return "redirect:/login";
	}

}
