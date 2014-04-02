package mx.com.icvt.extraction.impl.news;

import mx.com.icvt.extraction.DataExtractor;
import mx.com.icvt.model.News;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.Date;

/**
 * Created by miguelangeldelatorre on 25/03/14.
 */
public class NewsDataExtractor implements DataExtractor<NewsExtractorConfiguration,NewsResultData>{


    @Override
    public NewsResultData extract(NewsExtractorConfiguration extractorConfiguration) {

        if (extractorConfiguration== null){
            throw new  IllegalArgumentException("Argument cannot be null or empty");
        }

        NewsResultData retorno = new NewsResultData();

        try {
            retorno.setStartDate(new Date());
            Document doc;
            System.out.println(extractorConfiguration.getStringUrl());
            doc = Jsoup.connect(extractorConfiguration.getStringUrl()).get();
            retorno.setConfiguration(extractorConfiguration);
            for (Element e :doc.select("item")){

                String tittle = e.select("title").text();
                String guid = e.select("guid").text();
                guid = guid.substring(guid.indexOf("cluster=")+8);
                String pubdate =  e.select("pubdate").text();

                Document dd = Jsoup.parse(e.select("description").text());
                String description = dd.select(".lh").text();
                String image = dd.select("img").attr("src");

                System.out.println(description);
                if (image != null)
                    System.out.println(image);

                retorno.getResults().add(new News(tittle, guid, pubdate, description, image));

            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(retorno.getResults().size());
        retorno.setEndDate(new Date());
        return retorno;
    }


    public static void main (String[] args){
        NewsExtractorConfiguration config = new NewsExtractorConfiguration("precio cobre");
        config.setOrder(NewsExtractorConfiguration.Order.DATEDESC);
        config.setLanguage(NewsExtractorConfiguration.Language.ES);
        //config.setSource("El Financiero");
        new NewsDataExtractor().extract(config);

    }
}
