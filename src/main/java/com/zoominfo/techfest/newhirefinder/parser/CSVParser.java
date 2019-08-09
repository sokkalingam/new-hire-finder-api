package com.zoominfo.techfest.newhirefinder.parser;

import com.zoominfo.techfest.newhirefinder.model.Contact;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.RandomUtils;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;

public class CSVParser {

    public static Collection<Contact> parse() throws IOException {

        Reader in = new FileReader("src/main/resources/16k-sample_with_predictions_with_lat_lng.csv");
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

            long avgTimeInPos = Math.round(Double.parseDouble(record.get("log_average_time_in_position")));
            contact.setAvgTimeInPosition(String.valueOf(
                    avgTimeInPos < 1 ? 1 : avgTimeInPos
            ));

            contact.setChangedAJobLastYear(record.get("changed_a_job_last_year") == "1" ? "Yes" : "No");
            contact.setNumJobChangesLast10Years(record.get("num_job_changes_last_10years"));
            contact.setLat(record.get("new_lat"));
            contact.setLng(record.get("new_lon"));
            contact.setScore(round(Double.parseDouble(record.get("pred_probability")) * 100, 2));
            contact.setAbsScore(Double.parseDouble(record.get("pred_probability")));
            empList.add(contact);
        }

        return empList;
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
