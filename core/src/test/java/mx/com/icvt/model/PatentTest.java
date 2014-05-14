package mx.com.icvt.model;

import org.junit.Test;

import java.net.MalformedURLException;
import java.text.ParseException;

import static junit.framework.Assert.*;

/**
 * Created by miguelangeldelatorre on 29/04/14.
 */
public class PatentTest {

    @Test(expected = IllegalArgumentException.class)
    public void testWrongInstantationNullTittle() throws ParseException, MalformedURLException {
        Patent patent = new Patent(null, "http://www.google.com");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWrongInstantationNullUrl() throws ParseException, MalformedURLException {
        Patent patent = new Patent("El título", null);
    }

    @Test(expected = MalformedURLException.class)
    public void testWrongInstantationBadUrl() throws ParseException, MalformedURLException {
        Patent patent = new Patent("El título", "ElgatoPuntoCom");
    }


    @Test(expected = IllegalArgumentException.class)
    public void testWrongInstantationNullAll() throws ParseException, MalformedURLException {
        Patent patent = new Patent(null, null);
    }

    @Test
    public void testCorrectInstantation() throws ParseException, MalformedURLException {
        Patent patent = new Patent("El título", "http://www.google.com");
        assertNotNull(patent);
    }

    @Test(expected = ParseException.class)
    public void testWrongPublicationStringDate() throws ParseException, MalformedURLException {
        Patent patent = new Patent("El título", "http://www.google.com");
        patent.setPublicationStringDate("Cat");
    }

    @Test
    public void testCorrectPublicationStringDate() throws ParseException, MalformedURLException {
        Patent patent = new Patent("El título", "http://www.google.com");
        patent.setPublicationStringDate("1985");
        assertNotNull(patent);
    }

    @Test
    public void testNotnullAuthors() throws MalformedURLException{
        Patent patent = new Patent("El título", "http://www.google.com");
        assertNotNull(patent.getAuthors());
    }

    @Test
    public void testCompare()throws MalformedURLException, ParseException{
        // Casos con id nulo o diferente (ordenamiento)
        Patent pUno = new Patent("El título", "http://www.google.com");
        Patent pDos = new Patent("El título", "http://www.google.com");
        pUno.setPublicationStringDate("1994");
        pDos.setPublicationStringDate("1994");
        assertTrue(pDos.compareTo(pUno) == 0);

        pUno.setPublicationStringDate("1993");
        pDos.setPublicationStringDate("1994");
        assertTrue(pDos.compareTo(pUno) == 1);

        pUno.setPublicationStringDate("1995");
        pDos.setPublicationStringDate("1994");
        assertTrue(pDos.compareTo(pUno) == -1);

        // Casos con ide igual (discernir cual es el objeto mas completo)
        pUno.setId(new Long (1520l));
        pDos.setId(new Long (1520l));

        pUno.setTittle("El titulo mas largo de mundo punto com");
        assertTrue(pUno.compareTo(pDos) == 1);

        pUno.setTittle("El");
        assertTrue(pUno.compareTo(pDos) == -1);

        pUno.setTittle("Hola");
        pDos.setTittle("Hola");

        pUno.setDescriptionText("Hola mundo punto com");
        pDos.setDescriptionText("Hola mundo");
        assertTrue(pUno.compareTo(pDos)==1);

        pDos.setDescriptionText("Hola mundo punto com");
        pUno.setDescriptionText("Hola mundo");
        assertTrue(pUno.compareTo(pDos)==-1);

        pUno.setDescriptionText("Hola mundo");
        pDos.setDescriptionText("Hola mundo");
        assertTrue(pUno.compareTo(pDos)==0);
    }

    @Test
    public void testEqualsWithDifferentClass() throws MalformedURLException{
        Patent pUno = new Patent("El título", "http://www.google.com");
        assertFalse(pUno.equals("Narwhall"));
    }

    @Test
    public void testEquals() throws MalformedURLException{
        Patent pUno = new Patent("El título", "http://www.google.com");
        Patent pDos = new Patent("El título", "http://www.google.com");
        assertTrue(pUno.equals(pDos));

        pUno.setDescriptionText("Hola mundo punto com");
        pDos.setDescriptionText("Hola mundo punto com");
        assertTrue(pUno.equals(pDos));

        pUno.setId(15l);
        assertFalse(pUno.equals(pDos));

        pDos.setId(15l);
        assertTrue(pUno.equals(pDos));

        pUno.setTittle("Ezequiel 29:17");
        assertFalse(pUno.equals(pDos));

        pDos.setTittle("Ezequiel 29:17");
        assertTrue(pUno.equals(pDos));

        pUno.setTittle("http://yahoo.com");
        assertFalse(pUno.equals(pDos));

        pDos.setTittle("http://yahoo.com");
        assertTrue(pUno.equals(pDos));

        pDos.setDescriptionText("Hola mundo");
        assertFalse(pUno.equals(pDos));

        pUno.setDescriptionText("Hola mundo");
        assertTrue(pUno.equals(pDos));

    }
}
