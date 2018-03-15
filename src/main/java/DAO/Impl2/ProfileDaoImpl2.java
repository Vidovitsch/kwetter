package DAO.Impl2;

import DaoInterfaces.IProfileDao;
import Domain.Profile;
import Domain.User;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;


public class ProfileDaoImpl2 implements IProfileDao {

    private EntityManager em;
    private static EntityManagerFactory factory;

    public ProfileDaoImpl2() {
        factory = Persistence.createEntityManagerFactory("KWETTERPUP");
        em = factory.createEntityManager();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Profile> findAll() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Profile.class));

        return em.createQuery(cq).getResultList();
    }

    @Override
    public Profile findById(Long id) {
        return em.find(Profile.class, id);
    }

    @Override
    public Profile findByUser(User user) {
        Query q = em.createNamedQuery("Profile.findByUser", Profile.class);
        q.setParameter("user", user);

        return (Profile) q.getResultList();
    }

    @Override
    public Profile create(Profile profile) {
        em.persist(profile);

        return profile;
    }

    @Override
    public List<Profile> create(List<Profile> profiles) {
        List<Profile> newProfiles = new ArrayList<>();
        for (Profile profile : profiles) {
            newProfiles.add(create(profile));
        }

        return newProfiles;
    }

    @Override
    public Profile update(Profile profile) {
        return em.merge(profile);
    }

    @Override
    public boolean remove(Profile profile) {
        em.remove(profile);

        return true;
    }
}