package nl.han.student.HJMPoelen.scenes;

import nl.han.student.HJMPoelen.HAN_Menace;

public class WinScene extends EndScene {
    public WinScene(HAN_Menace hanMenace) {
        super(hanMenace);
    }

    @Override
    protected String getTitle() {
        return "Succes!";
    }
}