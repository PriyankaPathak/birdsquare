package birdsquare.model;

public interface BirdInformationDAO {
    void save(BirdInformation birdInformation);
    BirdInformation fetch(long id);
}
