package dao.interfaces;

import domain.Profile;
import domain.User;

import javax.persistence.EntityManager;
import java.util.List;

public interface IProfileDao {

    EntityManager getEntityManager();

    /**
     * Find all persisted profiles
     * @return a list of profiles
     */
    List<Profile> findAll();

    /**
     * Find one persisted profile by a unique id
     * @param id of the profile
     * @return a profile
     */
    Profile findById(Long id);

    /**
     * Find one persisted profile by a unique owner
     * @param user of the profile
     * @return a profile
     */
    Profile findByUser(User user);

    /**
     * Persists a new profile
     * A unique id will be generated by the persistency framework
     * @param profile to be persisted
     * @return a persisted profile
     */
    Profile create(Profile profile);

    /**
     * Persists a list of new profiles
     * A unique id will be generated by the persistency framework
     * @param profiles to be persisted
     * @return a list of persisted profiles
     */
    List<Profile> create(List<Profile> profiles);

    /**
     * Updates an persisted profile
     * If the profile already exists, the profile gets persisted
     * @param profile to be updated
     * @return an updated profile
     */
    Profile update(Profile profile);

    /**
     * Removes one persisted profile
     * If the profile doesn't exist, a false will return
     * @param profile to be removed
     * @return true (if successful) or false
     */
    boolean remove(Profile profile);
}
