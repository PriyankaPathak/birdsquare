package birdsquare.helper;

import birdsquare.model.Checkin;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    public List getCorrespondingRowAccordingToFilterSet(Class clazz, String value, String filter) {
        return session.createCriteria(clazz).add(Restrictions.like(filter, value)).list();
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
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date1= new Date();
        Date date2= dateFormat.parse("2012-11-20");
        Calendar now = Calendar.getInstance();
        now.add(Calendar.MINUTE,1);
        Date today = now.getTime();
        dateFormat.format(today);
        System.out.println(date1);
        Calendar calendar=new GregorianCalendar();
        calendar.add(Calendar.DATE,-7);
        Date endDay= calendar.getTime();
        dateFormat.format(endDay);
        System.out.println(date2);
        Criteria criteria = session.createCriteria(Checkin.class).add(Restrictions.like("fbuid",id))
                .add(Restrictions.between("date", date1, date2));
        List<Checkin> checkinList = criteria.list();
        int count=checkinList.size();
        return count;
    }
}
