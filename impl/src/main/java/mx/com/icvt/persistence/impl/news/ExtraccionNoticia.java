package mx.com.icvt.persistence.impl.news;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable
public class ExtraccionNoticia {
    @Persistent(primaryKey = "true")
    private Long id;


}
