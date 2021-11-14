
package support;

import java.util.ArrayList;


public interface IDAOT <T> {

    public boolean save(T o);

    public boolean update(T o);

    public boolean delete(int id);

    public ArrayList<T> consultAll();

    public ArrayList<T> consult(String criterio);

    public T consultId(int id);
}
