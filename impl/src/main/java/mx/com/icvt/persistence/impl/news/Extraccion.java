package mx.com.icvt.persistence.impl.news;

import javax.persistence.*;

@Entity
@Table(name = "ExtraccionNoticias")
public class Extraccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
