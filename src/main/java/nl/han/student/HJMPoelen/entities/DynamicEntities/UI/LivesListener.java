package nl.han.student.HJMPoelen.entities.DynamicEntities.UI;

public interface LivesListener {
    /// Player calls this interface when lives change, this way player oesnt have to directly know about LiveDisplay or any other classes that implemt it
    void onLivesChanged(int newLives);
}
