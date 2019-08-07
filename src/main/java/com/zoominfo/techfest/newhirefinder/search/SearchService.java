package com.zoominfo.techfest.newhirefinder.search;

import com.zoominfo.techfest.newhirefinder.model.Contact;
import com.zoominfo.techfest.newhirefinder.model.SearchInput;
import com.zoominfo.techfest.newhirefinder.parser.CSVParser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.comparator.Comparators;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

@Service
public class SearchService {

    private Collection<Contact> allContacts = null;

    public SearchService() throws IOException {
        allContacts = CSVParser.parse();
    }

    public String search() {
        return "Hello";
    }

    public List<Contact> getContacts() {
        Contact contact1 = new Contact();
        contact1.setName("Jon Smith");
        contact1.setCompanyName("IBM");
        contact1.setEmail("jon.smith@ibm.com");
        contact1.setPhone("857-345-1234");
        contact1.setJobTitle("Software Engineer");
        contact1.setScore(86.5);

        Contact contact2 = new Contact();
        contact2.setName("Don Smith");
        contact2.setCompanyName("Oracle");
        contact2.setEmail("don.smith@oracle.com");
        contact2.setPhone("999-345-1234");
        contact2.setJobTitle("Software Development Manager");
        contact2.setScore(91.3);

        return Arrays.asList(contact1, contact2);
    }

    private void processInput(SearchInput searchInput) {
        if (searchInput.getScore() == null)
            searchInput.setScore(0.0);

        if (searchInput.getJobTitle() == null)
            searchInput.setJobTitle("");

        if (searchInput.getCompanyName() == null)
            searchInput.setCompanyName("");
    }

    public Collection<Contact> getContacts(SearchInput searchInput) {

        Map<Double, Contact> contactMap = new TreeMap<>(Collections.reverseOrder());

        if (searchInput == null)
            return contactMap.values();

        processInput(searchInput);

        for (Contact item : allContacts) {
            if (item.getScore() >= searchInput.getScore()
                    && StringUtils.containsIgnoreCase(item.getCompanyName(), searchInput.getCompanyName())
                    && StringUtils.containsIgnoreCase(item.getJobTitle(), searchInput.getJobTitle())) {
                contactMap.put(item.getScore(), item);
            }
        }

        return contactMap.values();
    }

    public Collection<Contact> getContactsForMap(SearchInput searchInput) {

        Map<Double, Contact> contactMap = new TreeMap<>(Collections.reverseOrder());

        if (searchInput == null)
            return contactMap.values();

        processInput(searchInput);

        for (Contact item : allContacts) {
            if (StringUtils.isNotBlank(item.getLat()) && StringUtils.isNotBlank(item.getLng()) &&
                    item.getScore() >= searchInput.getScore()
                    && StringUtils.containsIgnoreCase(item.getCompanyName(), searchInput.getCompanyName())
                    && StringUtils.containsIgnoreCase(item.getJobTitle(), searchInput.getJobTitle())) {
                contactMap.put(item.getScore(), item);
            }
        }

        return contactMap.values();
    }


}
