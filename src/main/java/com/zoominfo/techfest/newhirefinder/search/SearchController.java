package com.zoominfo.techfest.newhirefinder.search;

import com.zoominfo.techfest.newhirefinder.model.Contact;
import com.zoominfo.techfest.newhirefinder.model.SearchInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String getContacts() {
        return searchService.search();
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Collection<Contact> postSearch(@RequestBody SearchInput searchInput) {
        return searchService.getContacts(searchInput);
    }

    @RequestMapping(value = "/mapSearch", method = RequestMethod.POST)
    public Collection<Contact> postSearchMap(@RequestBody SearchInput searchInput) {
        return searchService.getContactsForMap(searchInput);
    }
}
