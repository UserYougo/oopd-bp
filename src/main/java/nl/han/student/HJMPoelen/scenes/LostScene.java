package nl.han.student.HJMPoelen.scenes;

import nl.han.student.HJMPoelen.HAN_Menace;

public class LostScene extends EndScene {
    public LostScene(HAN_Menace hanMenace) {
        super(hanMenace);
    }

    @Override
    protected String getTitle() {
        return "DEAD!";
    }
}