package DAO.Mock;

import DaoInterfaces.IKweetDao;
import Domain.*;
import Qualifier.Mock;
import Util.MockFactory;
import Util.MockService;

import javax.enterprise.context.Dependent;
import java.util.*;

@Mock
@Dependent
public class KweetDaoMock implements IKweetDao {

    private List<Kweet> mockKweets;

    public KweetDaoMock() {
        mockKweets = MockService.getInstance().getKweets();
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
    public List<Kweet> findBySender(User sender) {
        List<Kweet> foundKweets = new ArrayList<>();
        for(Kweet k : mockKweets){
            if(k.getSender() != null && k.getSender().getUsername().equals(sender.getUsername())){
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
}
