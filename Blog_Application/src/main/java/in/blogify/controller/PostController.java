package in.blogify.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.blogify.bind.PostBindClass;
import in.blogify.constant.AppConstant;
import in.blogify.constant.ModelAttributes;
import in.blogify.constant.UIConstant;
import in.blogify.entity.PostEntity;
import in.blogify.repositories.PostDataRepository;
import in.blogify.services.PostDataService;

@Controller
public class PostController {

	@Autowired
	private PostDataRepository postDataRepo;

	@Autowired
	private PostDataService postDataService;

	@GetMapping("/addpost")
	public String loadAddPostPage(Model model) {

		model.addAttribute(ModelAttributes.BINDFORM, new PostBindClass());
		
		return UIConstant.ADDPOST;
	}

	@PostMapping("/addpost")
	public String addPostPage(@ModelAttribute("bindForm") PostBindClass bindData, Model model) {

		boolean savaData = postDataService.savaData(bindData);

		if (savaData) {

			model.addAttribute(ModelAttributes.SUCCESSMSG, AppConstant.POSTSAVED);
		} else {
			model.addAttribute(ModelAttributes.ERRORMSG, AppConstant.POSTERROR);
		}

		return UIConstant.ADDPOST;
	}

	@GetMapping("/viewpost")
	public String viewPostTable(Model model) {

		model.addAttribute(ModelAttributes.BINDFORM, new PostBindClass());

		List<PostEntity> loadData = postDataService.loadData();

		model.addAttribute(ModelAttributes.ALLPOST, loadData);

		return UIConstant.VIEWPOST;

	}

	@GetMapping("/edit")
	public String editById(@RequestParam("postId") Integer postId, Model model) {

		Optional<PostEntity> findById = postDataRepo.findById(postId);

		if (findById.isPresent()) {

			PostEntity postEntity = findById.get();

			model.addAttribute(ModelAttributes.BINDFORM, postEntity);
		}
		return UIConstant.ADDPOST;

	}

	@GetMapping("/delete")
	public String deleteById(@RequestParam("postId") Integer postId, Model model) {
		


		Optional<PostEntity> findById = postDataRepo.findById(postId);

		if (findById.isPresent()) {
			postDataRepo.deleteById(postId);

		}

		model.addAttribute(ModelAttributes.MSG, AppConstant.DELETE);

		model.addAttribute(ModelAttributes.ALLPOST, postDataRepo.findAll());

		return UIConstant.VIEWPOST;

	}
}
