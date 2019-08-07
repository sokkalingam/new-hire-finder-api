package com.zoominfo.techfest.newhirefinder.parser;

import com.zoominfo.techfest.newhirefinder.model.Contact;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class CSVParser {

    public static Collection<Contact> parse() throws IOException {

        Reader in = new FileReader("src/main/resources/17k-sample_with_predictions.csv");
        Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
        Collection<Contact> empList = new ArrayList<>();
        for (CSVRecord record : records) {
            Contact contact = new Contact();
            // String id = record.get("id");
//            contact.setId(record.get("id"));
            contact.setName(record.get("name"));
            contact.setCompanyName(record.get("current_company"));
            contact.setPhone(record.get("phone"));
            contact.setEmail(record.get("email"));
            contact.setJobTitle(record.get("current_role_title"));
//            contact.setLat(record.get("lat"));
//            contact.setLng(record.get("long"));
            contact.setLat(String.valueOf(RandomUtils.nextDouble(15, 45)));
            contact.setLng("-" + String.valueOf(RandomUtils.nextDouble(55, 85)));
            contact.setScore(Double.parseDouble(record.get("pred_probability")));
            empList.add(contact);
        }

        return empList;
    }
}
