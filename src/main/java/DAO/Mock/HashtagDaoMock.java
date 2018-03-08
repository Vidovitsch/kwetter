package DAO.Mock;

import Comparator.TrendComparator;
import DaoInterfaces.IHashtagDao;
import Domain.Hashtag;
import Domain.Kweet;
import java.util.*;

public class HashtagDaoMock implements IHashtagDao {

    private List<Hashtag> mockHashtags;

    public HashtagDaoMock(List<Kweet> kweets) {
        this.mockHashtags = createMockHashtags(kweets);
    }

    public List<Hashtag> findAll() {
        return mockHashtags;
    }

    public Hashtag findById(long id) {
        for(Hashtag h : mockHashtags){
            if(h.getId() == id) {
                return h;
            }
        }
        return null;
    }

    public Hashtag findByName(String name) {
        for (Hashtag hashtag : mockHashtags) {
            if (hashtag.getName().equals(name)) {
                return hashtag;
            }
        }
        return null;
    }

    public Hashtag create(Hashtag hashtag) {
        mockHashtags.add(hashtag);
        return hashtag;
    }

    public Hashtag update(Hashtag hashtag) {
        Hashtag existingHashtag = findById(hashtag.getId());
        if(existingHashtag == null){
            mockHashtags.add(hashtag);
        }
        else{
            mockHashtags.remove(existingHashtag);
            mockHashtags.add(hashtag);
        }
        return hashtag;
    }

    public boolean remove(Hashtag hashtag) {
        return mockHashtags.remove(hashtag);
    }

    private ArrayList<Hashtag> createMockHashtags(List<Kweet> kweets) {
        ArrayList<Hashtag> hashtags = new ArrayList<Hashtag>();

        Hashtag hashtag1 = new Hashtag(1, "Test");
        Hashtag hashtag2 = new Hashtag(2,"Kwetter");
        hashtags.add(hashtag1);
        hashtags.add(hashtag2);

        for (Kweet kweet : kweets) {
            kweet.setHashtags(hashtags);
        }
        hashtag1.setKweets(kweets);
        hashtag2.setKweets(kweets);

        return hashtags;
    }
}
