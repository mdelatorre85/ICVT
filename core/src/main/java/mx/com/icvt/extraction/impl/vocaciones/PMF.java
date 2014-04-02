package mx.com.icvt.extraction.impl.vocaciones;

/**
 * Created by lnx1337 on 17/03/14.
 */
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

public final class PMF {
    private static final PersistenceManagerFactory pmfInstance =
            JDOHelper.getPersistenceManagerFactory("SITE");

    private PMF() {}

    public static PersistenceManagerFactory get() {
        return pmfInstance;
    }
}