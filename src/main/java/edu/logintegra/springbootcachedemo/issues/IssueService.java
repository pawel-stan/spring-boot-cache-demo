package edu.logintegra.springbootcachedemo.issues;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class IssueService {

    private final Logger log = LoggerFactory.getLogger(IssueService.class);

    @Cacheable(value = "issue-maps-cache", key = "#issue.id")
    public IssueMap asMap(Issue issue) {
        IssueMap issueMap = new IssueMap(issue);

        issueMap.setNumberOfComments(findNumberOfComments(issue));

        return issueMap;
    }

    public Integer findNumberOfComments(Issue issue) {
        // Normalnie zapytali byśmy bazę danych...

        log.info("Rozpoczynamy obliczanie liczby komentarzy dla " + issue + "...");

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("Zakończyliśmy obliczanie liczby komentarzy dla " + issue + " -- wyszło nam " + issue.id.intValue() + ".");

        return issue.comments.size();
    }

    @CacheEvict(value = "issue-maps-cache", key = "#issue.id")
    public void clearCache(Issue issue) {
        log.info("Czyścimy cache zgłoszenia " + issue + "...");
    }
}
