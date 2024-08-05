package ironhack.com.scheduler.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ironhack.com.scheduler.model.Site;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ironhack.com.scheduler.service.SiteService;

import java.util.List;


@RequestMapping("/sites")
@RequiredArgsConstructor
@RestController

public class SiteController {

    private final SiteService siteService;

    @GetMapping
    public List<Site> getSite() {
        return siteService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Site addSite(@RequestBody @Valid Site site){
        return siteService.addSite(site);
    }

    @PutMapping("/{siteId}")
    public Site updateSite(@PathVariable("siteId") int siteId,
                           @RequestBody Site site) {
        return siteService.updateSite(siteId, site);
    }

    @DeleteMapping("/{siteId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSite(@PathVariable("siteId") int siteId) {
        siteService.deleteSite(siteId);
    }



}
