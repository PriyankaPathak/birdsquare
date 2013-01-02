package birdsquare.helper;

import birdsquare.model.Checkin;
import birdsquare.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Component
public class BirdSquareSession {

    private Session session = null;

    public BirdSquareSession() {
        initSession();
    }

    public Object get(Class clazz, Serializable id) {
        return session.get(clazz, id);
    }
                //TODO can v make this function return bird ID itself?
    public List getCorrespondingRowAccordingToFilterSet(Class clazz, String value, String filter) {
        return session.createCriteria(clazz).add(Restrictions.like(filter, value)).list();
    }

    public List getCorrespondingColumnAccordingToFilter(Class clazz,String filter){
        return session.createCriteria(clazz).setProjection(Projections.property(filter)).list();
    }

    public List getAll(Class clazz) {
        return session.createCriteria(clazz).list();
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
    this.session = BirdSquareSessionFactory.getInstance().createSession();
    }

    public List getSortedDescendingList(Class clazz, String variableToSortBy, int lengthOfList) {
        Criteria criteria = session.createCriteria(clazz).addOrder(Order.desc(variableToSortBy)).setMaxResults(lengthOfList);
        return criteria.list();
    }

    public int getPointsForLastSevenDays(String id) throws ParseException {
        Calendar calendar = new GregorianCalendar();
        Date today = calendar.getTime();
        calendar.add(Calendar.DATE, -7);
        Date startDay= calendar.getTime();

        Criteria criteria = session.createCriteria(Checkin.class)
                .add(Restrictions.like("fbuid", id))
                .add(Restrictions.between("date",startDay,today));
        return criteria.list().size();
    }
    public int maximumPointsAmongUsers(){
        Criteria criteria=session.createCriteria(User.class).setProjection(Projections.max("points"));
        int max=(Integer)criteria.uniqueResult();
        return max;
    }
}
