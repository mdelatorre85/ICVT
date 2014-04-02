package mx.com.icvt.extraction.impl.patents;

import mx.com.icvt.extraction.DataExtractor;
import mx.com.icvt.model.Patent;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


/**
 * Created by miguelangeldelatorre on 17/03/14.
 */
public class PatentsDataExtractor implements DataExtractor<PatentsExtractorConfiguration, PatentsResultData> {


    @Override
    public PatentsResultData extract(PatentsExtractorConfiguration extractorConfiguration) {

        if (extractorConfiguration == null) {
            throw new IllegalArgumentException("Argument cannot be null or empty");
        }

        PatentsResultData retorno = new PatentsResultData();

        try {
            Document doc = Jsoup.connect(extractorConfiguration.getStringUrl())
                    .userAgent("Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1)").get();
            for (Element e : doc.select(".gs_r")) {

                Elements titleElement = e.select(".gs_rt");
                String title = titleElement.text();
                String url = titleElement.select("a").attr("href");

                String authorsString = e.select(".gs_a").text();
                if (authorsString.contains("-")) {
                    authorsString = authorsString.substring(0, authorsString.indexOf('-')).trim();
                }
                String[] authors = null;
                if (authorsString.contains(",")) {
                    authors = authorsString.split(",");
                } else {
                    authors = new String[1];
                    authors[0] = authorsString;
                }
                String description = e.select(".gs_rs").text();

                String yearString = null;
                String patentString = null;
                try {
                    yearString = e.select(".gs_a").text();
                    if (yearString.contains("Patent")) {
                        patentString = yearString.substring(yearString.indexOf('-') + 1, yearString.length());
                        patentString = patentString.substring(0, patentString.lastIndexOf('-'));
                        patentString = patentString.trim();
                        yearString = patentString.substring(patentString.lastIndexOf(' '), patentString.length()).trim();
                        patentString = patentString.substring(0, patentString.lastIndexOf(',') - 1).trim();
                    } else {
                        yearString = yearString.substring(yearString.lastIndexOf(',') + 1, yearString.lastIndexOf('-')).trim();
                        if (yearString.length() > 4) {
                            yearString = yearString.substring(yearString.length() - 4, yearString.length());
                        }
                    }
                } catch (IndexOutOfBoundsException ex) {
                }

                Patent patent = new Patent(title, url);
                if (authors != null)
                    for (String author : authors) {
                        patent.getAuthors().add(author);
                    }
                patent.setDescriptionText(description);
                patent.setPublicationStringDate(yearString);
                if (patentString != null)
                    patent.setPatentString(patentString);

                retorno.getResults().add(patent);
/*
            System.out.println(title);
            System.out.println(url);
            System.out.println(authors);
            System.out.println(description);
            System.out.println(yearString);
            if (patentString != null)
                System.out.println(patentString);*/
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }


        return retorno;
    }

    public static void main(String[] args) {
        PatentsExtractorConfiguration config = new PatentsExtractorConfiguration("Paper Cup");
        new PatentsDataExtractor().extract(config);
    }

}
