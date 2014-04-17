package mx.com.icvt.persistence;

import mx.com.icvt.extraction.ResultData;

/**
 * Created with IntelliJ IDEA.
 * User: Cesar
 * Date: 09/03/14
 * Time: 18:01
 */
public interface DataResultPersister<T extends ResultData> {
    public void persist(T data);
}
