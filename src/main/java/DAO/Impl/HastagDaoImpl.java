package DAO.Impl;

import DaoInterfaces.IHashtagDao;
import Domain.Hashtag;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import java.util.List;

public class HastagDaoImpl implements IHashtagDao {

    public List<Hashtag> findAll() {
        return null;
    }

    public Hashtag findById(Long id) {
        return null;
    }

    public Hashtag findByName(String name) {
        return null;
    }

    public Hashtag create(Hashtag Hashtag) {
        return null;
    }

    @Override
    public List<Hashtag> create(List<Hashtag> hashtags) {
        return null;
    }

    public Hashtag update(Hashtag Hashtag) {
        return null;
    }

    public boolean remove(Hashtag Hashtag) {
        return false;
    }

    public List<Hashtag> getTrend() {
        return null;
    }
}
