package DAO.Mock;

import DaoInterfaces.IKweetDao;
import Domain.*;
import Util.MockFactory;

import java.util.*;

public class KweetDaoMock implements IKweetDao {

    private List<Kweet> mockKweets;

    public KweetDaoMock() { }

    @SuppressWarnings("unchecked")
    public void setMockKweets(List<User> users) {
        mockKweets = (List<Kweet>) MockFactory.createMocks(Kweet.class, 90);
        MockFactory.setNewIds(mockKweets);
        createDummyKweets(mockKweets, users);
    }

    @Override
    public List<Kweet> findAll() {
        return mockKweets;
    }

    @Override
    public Kweet findById(Long id) {
        for(Kweet k : mockKweets){
            if(k.getId().equals(id)){
                return k;
            }
        }
        return null;
    }

    @Override
    public List<Kweet> findByTerm(String message) {
        List<Kweet> foundKweets = new ArrayList<>();
        for(Kweet k : mockKweets){
            if (k.getMessage().toLowerCase().contains(message.toLowerCase())){
                foundKweets.add(k);
            }
        }
        return foundKweets;
    }

    @Override
    public List<Kweet> findBySenderName(String senderName) {
        List<Kweet> foundKweets = new ArrayList<>();
        for(Kweet k : mockKweets){
            if(k.getSender() != null && k.getSender().getUsername().equals(senderName)){
                foundKweets.add(k);
            }
        }
        return foundKweets;
    }

    @Override
    public Kweet create(Kweet kweet) {
        MockFactory.setNextId(kweet, mockKweets);
        mockKweets.add(kweet);

        return kweet;
    }

    @Override
    public List<Kweet> create(List<Kweet> kweets) {
        MockFactory.setNextIds(kweets, mockKweets);
        mockKweets.addAll(kweets);
        return kweets;
    }

    public Kweet update(Kweet kweet) {
        Kweet existingKweet = findById(kweet.getId());
        if(existingKweet == null){
            mockKweets.add(kweet);
        }
        else{
            mockKweets.remove(existingKweet);
            mockKweets.add(kweet);
        }
        return kweet;
    }

    public boolean remove(Kweet kweet) {
        return mockKweets.remove(kweet);
    }

    // For mock purposes
    private void createDummyKweets(List<Kweet> kweets, List<User> users) {
        for (int i = 0; i < users.size(); i++) {
            List<Kweet> kweetsToSend = kweets.subList(i * 9, i * 9 + 9);
            List<User> mentions = new ArrayList<>(users);
            mentions.remove(users.get(i));
            users.get(i).setKweets(kweetsToSend);
            for (Kweet kweet : kweetsToSend) {
                kweet.setSender(users.get(i));
                kweet.setMentions(mentions);
            }
        }
    }
}
