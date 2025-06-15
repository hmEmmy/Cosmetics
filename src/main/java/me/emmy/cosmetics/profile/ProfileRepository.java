package me.emmy.cosmetics.profile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author Emmy
 * @project Cosmetics
 * @since 15/06/2025
 */
public class ProfileRepository {
    private final Map<UUID, Profile> profiles;

    public ProfileRepository() {
        this.profiles = new HashMap<>();
    }

    /**
     * Retrieves a profile by its UUID.
     *
     * @param uuid The UUID of the profile.
     * @return The Profile object if found, otherwise null.
     */
    public Profile getProfile(UUID uuid) {
        if (!this.profiles.containsKey(uuid)) {
            this.profiles.put(uuid, new Profile(uuid));
        }

        return this.profiles.get(uuid);
    }

    /**
     * Method to add a profile to the map.
     *
     * @param profile The Profile to be added.
     */
    public void addProfile(Profile profile) {
        this.profiles.put(profile.getUuid(), profile);
    }
}