package DAO.Impl;

import DaoInterfaces.IProfileDao;
import Domain.Profile;
import Domain.User;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Default
@Stateless
public class ProfileDaoImpl implements IProfileDao {

    @PersistenceContext(name = "KwetterPU")
    private EntityManager em;

    public ProfileDaoImpl() { }

    @Override
    public List<Profile> findAll() {
        return null;
    }

    @Override
    public Profile findById(Long id) {
        return null;
    }

    @Override
    public Profile findByUser(User user) {
        return null;
    }

    @Override
    public List<Profile> findByName(String name) {
        return null;
    }

    @Override
    public Profile create(Profile Profile) {
        return null;
    }

    @Override
    public List<Profile> create(List<Profile> profiles) {
        return null;
    }

    @Override
    public Profile update(Profile Profile) {
        return null;
    }

    @Override
    public boolean remove(Profile Profile) {
        return false;
    }
}