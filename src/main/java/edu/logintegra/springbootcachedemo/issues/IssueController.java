package edu.logintegra.springbootcachedemo.issues;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/issues")
public class IssueController {

    private final IssueRepository issueRepository;
    private final IssueService issueService;

    public IssueController(IssueRepository issueRepository, IssueService issueService) {
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
}
