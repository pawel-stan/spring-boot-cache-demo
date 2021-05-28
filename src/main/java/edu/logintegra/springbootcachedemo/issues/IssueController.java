package edu.logintegra.springbootcachedemo.issues;

import edu.logintegra.springbootcachedemo.comments.Comment;
import edu.logintegra.springbootcachedemo.comments.CommentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/issues")
public class IssueController {

    private final CommentRepository commentRepository;
    private final IssueRepository issueRepository;
    private final IssueService issueService;

    public IssueController(CommentRepository commentRepository, IssueRepository issueRepository, IssueService issueService) {
        this.commentRepository = commentRepository;
        this.issueRepository = issueRepository;
        this.issueService = issueService;
    }

    @GetMapping("/")
    ModelAndView index() {
        ModelAndView mav = new ModelAndView("issues/index");

        List<IssueMap> issueMaps = issueRepository.findAll()
                .stream()
                .map(issueService::asMap)
                .collect(Collectors.toList());

        mav.addObject("issueMaps", issueMaps);

        return mav;
    }

    @GetMapping("/{code}/edit")
    ModelAndView edit(@PathVariable String code) {
        Issue issue = issueRepository.findByCode(code).orElse(null);

        if (issue == null) {
            return index();
        }

        ModelAndView mav = new ModelAndView("issues/form");

        mav.addObject("issue", issue);
        mav.addObject("newComment", new Comment());

        return mav;
    }

    @PostMapping("/{code}/comments")
    ModelAndView saveComment(@PathVariable String code, @ModelAttribute Comment newComment) {
        Issue issue = issueRepository.findByCode(code).orElse(null);

        newComment.setIssue(issue);
        commentRepository.save(newComment);

        issueService.clearCache(issue);

        return new ModelAndView("redirect:/issues/" + code + "/edit/");
    }
}
