package mx.com.icvt.extraction.impl.util;

/**
 * Created by miguelangeldelatorre on 29/03/14.
 */
public class UrlUtil {

    public static final int GOBMX = 0;
    public static final int WWW = 1;
    public static final int MAIL = 2;
    public static final int FACEBOOK = 3;
    public static final int TWITTER = 4;
    public static final int LINKEDIN = 5;
    public static final int GOOGLEPLUS = 6;
    public static final int YOUTUBE = 7;
    public static final int FLICKR = 8;

    public static boolean isURLValid(String url) {

        String util = url.toLowerCase();

        if (util.endsWith("/"))
            util = util.substring(0, util.length() - 1);

        if (util.contains("?"))
            return false;

        if (util.contains(")"))
            return false;

        if (util.contains(","))
            return false;

        if (util.contains(";"))
            return false;

        if (util.endsWith(".jpg"))
            return false;

        if (util.endsWith(".js"))
            return false;

        if (util.endsWith(".png"))
            return false;

        if (util.endsWith(".gif"))
            return false;

        // formato XML unicode
        if (util.endsWith(".dtd"))
            return false;

        if (util.endsWith(".css"))
            return false;

        if (util.endsWith(".jx"))
            return false;

        if (util.endsWith(".pdf"))
            return false;

        if (util.endsWith(".ppt"))
            return false;

        if (util.endsWith(".pptx"))
            return false;

        if (util.endsWith(".doc"))
            return false;

        if (util.endsWith(".docx"))
            return false;

        if (util.endsWith(".xlsx"))
            return false;

        if (util.endsWith(".xml"))
            return false;

        if (util.endsWith(".wmv"))
            return false;

        if (util.endsWith(".zip"))
            return false;

        if (util.endsWith(".mp3"))
            return false;

        if (util.contains("</script>"))
            return false;

        if (util.contains("<script>"))
            return false;

        if (util.contains(" "))
            return false;

        return true;
    }

    public static int isRedSocial(String url) {
        String util = url.toLowerCase();

        if (util.contains(".gob.mx"))
            return GOBMX;

        if (util.contains("facebook.com"))
            return FACEBOOK;

        if (util.contains("twitter.com"))
            return TWITTER;

        if (util.contains("flickr.com"))
            return FLICKR;

        if (util.contains("plus.google.com"))
            return GOOGLEPLUS;

        if (util.contains("linkedin.com"))
            return LINKEDIN;

        if (util.contains("youtube.com"))
            return YOUTUBE;

        if (util.contains("youtu.be"))
            return YOUTUBE;

        return -1;
    }


    public static String EscapeUrl(String url) {
        //if (url.contains("%")) {
        //    url = url.replace("%", "%25");
        //}
        if (url.contains("-")) {
            url = url.replace("-","%2D");
        }
        if (url.contains("+")) {
            url = url.replace("+","%2B");
        }

        if (url.contains("0")) {
            url = url.replace("0","%30");
        }

        if (url.contains("1")) {
            url = url.replace("1","%31");
        }

        if (url.contains("2")) {
            url = url.replace("2","%32");
        }

        if (url.contains("3")) {
            url = url.replace("3","%33");
        }

        if (url.contains("4")) {
            url = url.replace("4","%34");
        }

        if (url.contains("5")) {
            url = url.replace("5","%35");
        }

        if (url.contains("6")) {
            url = url.replace("6","%36");
        }

        if (url.contains("7")) {
            url = url.replace("7","%37");
        }

        if (url.contains("8")) {
            url = url.replace("8" ,"%38");
        }
        if (url.contains("9")) {
            url = url.replace("9","%39");
        }
        if (url.contains("[")) {
            url = url.replace("[","%5B");
        }
        if (url.contains("\\")) {
            url = url.replace("\\","%5C");
        }
        if (url.contains("%5D")) {
            url = url.replace("%5D","]");
        }
        if (url.contains("^")) {
            url = url.replace("^","%5E");
        }
        if (url.contains("_")) {
            url = url.replace("_","%5F");
        }
        if (url.contains("%7B")) {
            url = url.replace("{","%7B");
        }
        if (url.contains("|")) {
            url = url.replace("|","%7C");
        }
        if (url.contains("}")) {
            url = url.replace("}","%7D");
        }
        if (url.contains("~")) {
            url = url.replace("~","%7E");
        }
        if (url.contains("Á")) {
            url = url.replace("Á","%C1");
        }
        if (url.contains("É")) {
            url = url.replace("É","%C9");
        }
        if (url.contains("Í")) {
            url = url.replace("Í","%CD");
        }
        if (url.contains("Ó")) {
            url = url.replace("Ó","%D3");
        }
        if (url.contains("Ú")) {
            url = url.replace("Ú","%DA");
        }

        if (url.contains("á")) {
            url = url.replace("á","%E1");
        }
        if (url.contains("é")) {
            url = url.replace("é","%E9");
        }
        if (url.contains("í")) {
            url = url.replace("í","%ED");
        }
        if (url.contains("ó")) {
            url = url.replace("ó","%F3");
        }
        if (url.contains("ú")) {
            url = url.replace("ú","%FA");
        }
        if (url.contains("ü")) {
            url = url.replace("ü","%FC");
        }
        if (url.contains("ñ")) {
            url = url.replace("ñ","%F1");
        }
        return url;
    }


    public static String unEscapeUrl(String url) {
        if (url.contains("%25")) {
            url = url.replace("%25", "%");
        }
        if (url.contains("%2D")) {
            url = url.replace("%2D", "-");
        }
        if (url.contains("%2B")) {
            url = url.replace("%2B", "+");
        }

        if (url.contains("%30")) {
            url = url.replace("%30", "0");
        }

        if (url.contains("%31")) {
            url = url.replace("%31", "1");
        }

        if (url.contains("%32")) {
            url = url.replace("%32", "2");
        }

        if (url.contains("%33")) {
            url = url.replace("%33", "3");
        }

        if (url.contains("%34")) {
            url = url.replace("%34", "4");
        }

        if (url.contains("%35")) {
            url = url.replace("%35", "5");
        }

        if (url.contains("%36")) {
            url = url.replace("%36", "6");
        }

        if (url.contains("%37")) {
            url = url.replace("%37", "7");
        }

        if (url.contains("%38")) {
            url = url.replace("%38", "8");
        }
        if (url.contains("%39")) {
            url = url.replace("%39", "9");
        }
        if (url.contains("%5B")) {
            url = url.replace("%5B", "[");
        }
        if (url.contains("%5C")) {
            url = url.replace("%5C", "\\");
        }
        if (url.contains("%5D")) {
            url = url.replace("%5D", "]");
        }
        if (url.contains("%5E")) {
            url = url.replace("%5E", "^");
        }
        if (url.contains("%5F")) {
            url = url.replace("%5F", "_");
        }
        if (url.contains("%7B")) {
            url = url.replace("%7B", "{");
        }
        if (url.contains("%7C")) {
            url = url.replace("%7C", "|");
        }
        if (url.contains("%7D")) {
            url = url.replace("%7D", "}");
        }
        if (url.contains("%7E")) {
            url = url.replace("%7E", "~");
        }
        if (url.contains("%C1")) {
            url = url.replace("%C1", "Á");
        }
        if (url.contains("%C9")) {
            url = url.replace("%C9", "É");
        }
        if (url.contains("%CD")) {
            url = url.replace("%CD", "Í");
        }
        if (url.contains("%D3")) {
            url = url.replace("%D3", "Ó");
        }
        if (url.contains("%DA")) {
            url = url.replace("%DA", "Ú");
        }

        if (url.contains("%E1")) {
            url = url.replace("%E1", "á");
        }
        if (url.contains("%E9")) {
            url = url.replace("%E9", "é");
        }
        if (url.contains("%ED")) {
            url = url.replace("%ED", "í");
        }
        if (url.contains("%F3")) {
            url = url.replace("%F3", "ó");
        }
        if (url.contains("%FA")) {
            url = url.replace("%FA", "ú");
        }
        if (url.contains("%FC")) {
            url = url.replace("%FC", "ü");
        }
        if (url.contains("%F1")) {
            url = url.replace("%F1", "ñ");
        }
        return url;
    }


}
