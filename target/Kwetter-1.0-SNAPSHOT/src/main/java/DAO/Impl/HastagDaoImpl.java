package DAO.Impl;

import DaoInterfaces.IHashtagDao;
import Domain.Hashtag;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Default
@Stateless
public class HastagDaoImpl implements IHashtagDao {

    @PersistenceContext(name = "KwetterPU")
    private EntityManager em;

    public HastagDaoImpl() { }

    @Override
    public List<Hashtag> findAll() {
        return null;
    }

    @Override
    public Hashtag findById(Long id) {
        return null;
    }

    @Override
    public Hashtag findByName(String name) {
        return null;
    }

    @Override
    public Hashtag create(Hashtag Hashtag) {
        return null;
    }

    @Override
    public List<Hashtag> create(List<Hashtag> hashtags) {
        return null;
    }

    @Override
    public Hashtag update(Hashtag Hashtag) {
        return null;
    }

    @Override
    public boolean remove(Hashtag Hashtag) {
        return false;
    }
}