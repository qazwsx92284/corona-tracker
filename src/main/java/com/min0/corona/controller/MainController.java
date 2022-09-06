package com.min0.corona.controller;

import com.min0.corona.pojo.Corona;
import com.min0.corona.repository.CoronaRepository;
import com.opencsv.CSVReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Controller
@Slf4j
public class MainController {

    @Autowired
    CoronaRepository coronaRepository;

    @GetMapping("/")
    public String root (Model model) throws IOException {
        // model allows us to inject certain variables into our template
        model.addAttribute("test1", "Hello user this is value");

        String csvFile = "C:\\Users\\Minyoung\\Desktop\\java\\spring boot\\corona\\src\\main\\resources\\01-01-2021.csv";

        CSVReader reader = null;

        reader = new CSVReader(new FileReader(csvFile));
        String[] line;
        int i = 0;
        while((line = reader.readNext()) != null) {
            if(i == 0) { // to skip the first line
                i++;
                continue;
            }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            Corona corona = new Corona();

            corona.setConfirmed((Long.valueOf(line[5])));
            if(!Objects.equals(line[7], "")) {
                corona.setRecovered((Double.valueOf(line[7])));
            }
            if(!line[8].equals("")) {
                corona.setActive((Double.valueOf(line[8])));
            }
//            corona.setCombinedKey(line[11]);
            corona.setLastUpdate(LocalDateTime.parse(line[2], formatter));

            log.info(corona.toString());
            coronaRepository.save(corona);
        }
        return "mainTemplate";
    }
}
