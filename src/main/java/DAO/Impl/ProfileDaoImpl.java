package DAO.Impl;

import DaoInterfaces.IProfileDao;
import Domain.Profile;
import Domain.User;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class ProfileDaoImpl implements IProfileDao {

    public List<Profile> findAll() {
        return null;
    }

    public Profile findById(Long id) {
        return null;
    }

    public Profile findByUser(User user) {
        return null;
    }

    public List<Profile> findByName(String name) {
        return null;
    }

    public Profile create(Profile Profile) {
        return null;
    }

    @Override
    public List<Profile> create(List<Profile> profiles) {
        return null;
    }

    public Profile update(Profile Profile) {
        return null;
    }

    public boolean remove(Profile Profile) {
        return false;
    }
}
