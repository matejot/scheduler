package ironhack.com.scheduler.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ironhack.com.scheduler.model.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ironhack.com.scheduler.repository.SiteRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j



public class SiteService {

    @Autowired
    private SiteRepository siteRepository;

    public List<Site> findAll() {
        log.info("Listing all sites");
        return siteRepository.findAll();
    }

    public Site addSite(Site site) {
        log.info("Creating new site {}", site);
        return siteRepository.save(site);
    }

    public void deleteSite(int siteId) {
        log.info("Deleting site with id: {}", siteId);
        siteRepository.deleteById(siteId);
    }

    public Site updateSite(int siteId, Site site) {
        log.info("Editing site with id {}", siteId);
        var siteToUpdate = siteRepository.findById(siteId).orElseThrow();
        siteToUpdate.setSiteName(site.getSiteName());
        return siteRepository.save(siteToUpdate);
    }


}
