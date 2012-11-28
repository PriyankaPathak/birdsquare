package birdsquare.helper;

import birdsquare.model.User;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
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
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = new GregorianCalendar();
        Date today = calendar.getTime();
        String dateToday = dateFormat.format(today);

        calendar.add(Calendar.DATE, -7);
        Date endDay= calendar.getTime();
        String dateBefore7Days = dateFormat.format(endDay);

        String query = "select * from checkin where fbuid='"+id+"' and date<='"+dateToday+"' and date>='"+dateBefore7Days+"';";
        SQLQuery sqlQuery = session.createSQLQuery(query);
        List someList = sqlQuery.list();

//        Criteria criteria = session.createCriteria(Checkin.class)
//                .add(Restrictions.like("fbuid", id))
//                .add(Restrictions.between("date", today, endDay));
//        List<Checkin> checkinList = criteria.list();

        return someList.size();
    }
    public int maximumPointsAmongUsers(){
        Criteria criteria=session.createCriteria(User.class).setProjection(Projections.max("points"));
        int max=(Integer)criteria.uniqueResult();
        return max;
    }
}
