package mx.com.icvt.extraction.impl.news;

import mx.com.icvt.extraction.ExtractorConfiguration;

import java.io.Serializable;

public class NewsExtractorConfiguration implements Serializable, ExtractorConfiguration {
    private static final long serialVersionUID = 3787616567194797212L;
    private Long id;
    private String query;
    private String source;
    private Language language;
    private Order order = Order.RELEVANCE;

    @SuppressWarnings("unused")
    private NewsExtractorConfiguration() {
    }

    public NewsExtractorConfiguration(String query) {
        if (query == null || query.length() == 0) {
            throw new IllegalArgumentException("Argument query cannot be null or empty");
        }
        this.query = query.replace(' ', '+');
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public String getQuery() {
        return query;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source.replace(' ', '+');
    }

    @Override
    public String getStringUrl() {

        StringBuilder sb = new StringBuilder("http://news.google.com/news?q=");
        sb.append(query);

        if (source != null) {
            sb.append("+source:\"");
            sb.append(source);
            sb.append("\"");
        }

        if (language != null) {
            sb.append("&");
            sb.append(language.getName());
        }

        if (order != null) {
            sb.append("&");
            sb.append(order.getName());
        }

        sb.append("&ie=UTF-8&num=20&output=rss");
        return sb.toString();
    }

    public enum Language {
        EN("hl=en"), ES("hl=es"), DE("hl=de"), FR("hl=fr"), IT("hl=it"), PL("hl=pl");
        //TODO agregar CN JP PT y KR

        Language(String name) {
            this.name = name;
        }

        private String name;

        public String getName() {
            return name;
        }
    }

    public enum Order {
        RELEVANCE("scoring=r"), DATEDESC("scoring=n"), DATEASC("scoring=o");

        Order(String name) {
            this.name = name;
        }
        private String name;
        public String getName() {
            return name;
        }
    }
}