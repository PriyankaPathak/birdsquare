package birdsquare.helper;

import org.hibernate.Session;

public class SimpleDAO {

    private Session session = null;

    public SimpleDAO() {
        initSession();
    }

    public void save(Object object) {
        startTransaction();
        session.save(object);
        commit();
    }


    public void saveOrUpdate(Object object) {

        startTransaction();
        session.saveOrUpdate(object);
        commit();
    }

    public Object get(Class clazz, long id) {
        return session.get(clazz, id);

    }

    public void delete(Object object) {
        startTransaction();
        session.delete(object);
        commit();
    }

    public void close() {
        session.close();
        session = null;
    }


    private void startTransaction() {
        if (session == null)
            initSession();
        session.beginTransaction();
    }

    private void commit() {
        session.getTransaction().commit();
    }

    private void initSession() {
        this.session = BirdSessionFactory.getInstance().createSession();
    }
}
