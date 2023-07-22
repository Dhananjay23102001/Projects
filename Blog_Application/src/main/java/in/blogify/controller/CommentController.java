package in.blogify.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.blogify.constant.ModelAttributes;
import in.blogify.constant.UIConstant;
import in.blogify.entity.CommentEntity;
import in.blogify.entity.PostEntity;
import in.blogify.repositories.CommentRepository;
import in.blogify.repositories.PostDataRepository;
import in.blogify.services.CommentService;
import in.blogify.services.PostDataService;

@Controller
public class CommentController {

	@Autowired
	private PostDataService postDataService;

	@Autowired
	private PostDataRepository postDataRepo;

	@Autowired
	private CommentService commentService;

	@Autowired
	private CommentRepository commentRepo;

	@PostMapping("/post/{postId}/comment")
	public String addComment(@PathVariable Integer postId, @RequestParam("content") String content,
			@RequestParam("name") String name, @RequestParam("email") String email) {
		Optional<PostEntity> findById = postDataRepo.findById(postId);
		if (findById.isPresent()) {
			PostEntity postEntity = findById.get();
			CommentEntity comment = new CommentEntity();
			comment.setContent(content);
			comment.setName(name);
			comment.setEmail(email);
			comment.setPost(postEntity);
			commentRepo.save(comment);

			return "redirect:/post/" + postId;
		}
		return UIConstant.ERROR;

	}

	@GetMapping("/postcomment")
	public String retrivePostTittle(Model model) {
		
//		Object nullObject = null;
//		
//		 nullObject.toString();

		List<PostEntity> loadData = postDataService.loadData();

		model.addAttribute(ModelAttributes.ALLPOST, loadData);

		return UIConstant.POSTTITTLE;

	}

	@GetMapping("/comment/{postId}")
	public String retriveComment(@PathVariable Integer postId, Model model) {

		List<CommentEntity> commentsByPostId = commentService.getCommentsByPost(postId);

		model.addAttribute(ModelAttributes.COMMENTS, commentsByPostId);

		return UIConstant.COMMENT;
	}

	@PostMapping("/comments/{commentId}/delete")
	public String deleteComment(@PathVariable Integer commentId) {
		commentService.deleteComment(commentId);

		return "redirect:/postcomment";
	}

}

/////////////////////////////////////////////////////////////////////////////////////////////////


//@PostMapping("/post/{postId}/comment")
//public String addComment(@PathVariable Integer postId,@ModelAttribute("commentBind") CommentBind commentBind) {
//	Optional<PostEntity> findById = postDataRepo.findById(postId);
//	if(findById.isPresent()) {
//		PostEntity postEntity = findById.get();
//		
//		CommentEntity entity = new CommentEntity();
//
//		BeanUtils.copyProperties(commentBind, entity);
//		
//		entity.setPost(postEntity);
//		
//		commentRepo.save(entity);
//		
//		return "redirect:/Particularpost/" + postId;
//		
//	}

//	return null;

//@GetMapping("/post/{postId}/comment")
//public String loadCmt(Model model) {
//	
//	model.addAttribute("commentBind", new CommentBind());
//
//	return "Particularpost";
//}
//

//@PostMapping("/comment")
//public String saveCmt(@ModelAttribute("commentBind") CommentBind commentBind,Model model) {
//	
//	boolean saveAllComments = commentService.saveAllComments(commentBind);
//	
//	if (saveAllComments) {
//
//		model.addAttribute("sucessMsg", "Comment Saved");
//	} else {
//		model.addAttribute("errorMsg", "Error Occured");
//	}
//	
//	return "Comment";
//			
//}

//@PostMapping("/post/{postId}/comment")
//public String addComment(@PathVariable Long postId, @RequestParam("content") String content) {
//    Optional<Post> optionalPost = postRepository.findById(postId);
//    if (optionalPost.isPresent()) {
//        Post post = optionalPost.get();
//        Comment comment = new Comment();
//        comment.setContent(content);
//        comment.setPost(post);
//        commentRepository.save(comment);
//        return "redirect:/post/" + postId;
//    }
//    return "error";
//}
