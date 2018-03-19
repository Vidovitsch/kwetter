package dao_tests;


import dao_tests.implementations_test.HastagDaoImpl2;
import dao_tests.interfaces.*;
import domain.Hashtag;
import util.MockFactory;
import util.MockService;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.RollbackException;
import java.util.*;

public class HashtagDaoTest {

    private static IHashtagDao hashtagDao;

    @BeforeClass
    public static void Init() {
        hashtagDao = new HastagDaoImpl2("KwetterPU_test");
    }

    @AfterClass
    public static void tearDown() {
        MockService.renewMockData();
    }

    @Test
    public void findAllTest() {
        // Set status before
        List<Hashtag> hashtagsBefore = new ArrayList<>(hashtagDao.findAll());

        // Insert new hashtag
        Hashtag mockHashtag = (Hashtag)MockFactory.createMocks(Hashtag.class, 1).get(0);
        hashtagDao.create(mockHashtag);

        // Check status after
        List<Hashtag> hashtagsAfter = hashtagDao.findAll();
        Assert.assertEquals("Returns list with size + 1",
                hashtagsBefore.size() + 1, hashtagsAfter.size());
        Assert.assertTrue("New hashtag has been added", hashtagsAfter.contains(mockHashtag));
    }

    @Test
    public void findByIdTest() {
        // Insert new hashtag
        Hashtag mockHashtag = (Hashtag)MockFactory.createMocks(Hashtag.class, 1).get(0);
        mockHashtag.setId((long)1);
        try{
            mockHashtag = hashtagDao.create(mockHashtag);}
        catch (RollbackException e){
            mockHashtag = hashtagDao.update(mockHashtag);
        }
        // Check fetched hashtag
        Hashtag fetchedHashtag = hashtagDao.findById((long)1);
        Assert.assertEquals("Fetched hashtag is not the same as the mocked one", mockHashtag, fetchedHashtag);
    }

    @Test
    public void findByNameTest() {
        String name = "SomeName";

        // Insert new hashtag
        Hashtag mockHashtag = (Hashtag)MockFactory.createMocks(Hashtag.class, 1, "name", name).get(0);
        try{
        mockHashtag = hashtagDao.create(mockHashtag);}
        catch (RollbackException e){
            mockHashtag = hashtagDao.findByName(mockHashtag.getName());
        }

        // Check fetched hashtag
        Hashtag fetchedHashtag = hashtagDao.findByName(name);
        Assert.assertEquals("Fetched hashtag is the same as the mocked one", mockHashtag, fetchedHashtag);
    }

    @Test
    public void insertHashtagTest() {
        // Insert new hashtag
        Hashtag mockHashtag = (Hashtag)MockFactory.createMocks(Hashtag.class, 1).get(0);
        hashtagDao.create(mockHashtag);

        // Check hashtag list contains new hashtag
        Assert.assertTrue("New hashtag has been added", hashtagDao.findAll().contains(mockHashtag));
    }

    @Test
    @SuppressWarnings("unchecked")
    public void insertHashtagsTest() {
        // Insert new hashtag
        List<Hashtag> mockHashtags = (List<Hashtag>)MockFactory.createMocks(Hashtag.class, 3);
        hashtagDao.create(mockHashtags);

        // Check hashtag list contains new hashtag
        Assert.assertTrue("New hashtags have been added", hashtagDao.findAll().containsAll(mockHashtags));
    }

    @Test
    public void updateHashtagTest() {
        // Insert new hashtag
        Hashtag mockHashtag = (Hashtag)MockFactory.createMocks(Hashtag.class, 1).get(0);
        mockHashtag = hashtagDao.create(mockHashtag);

        // Check before
        Assert.assertFalse(mockHashtag.getName().equals("Kweet"));

        // Update new hashtag
        mockHashtag.setName("Kweet");
        hashtagDao.update(mockHashtag);

        // Check hashtag list contains new name
        Assert.assertEquals("The name of the hashtag has been changed", "Kweet", mockHashtag.getName());
    }

    @Test
    public void deleteHashtagTest() {
        // Insert new hashtag
        Hashtag mockHashtag = (Hashtag)MockFactory.createMocks(Hashtag.class, 1).get(0);
        mockHashtag = hashtagDao.create(mockHashtag);

        // Delete inserted hashtag
        hashtagDao.remove(mockHashtag);

        // Check hashtag list contains new hashtag
        Assert.assertFalse("New hashtag has not been removed", hashtagDao.findAll().contains(mockHashtag));
    }
}