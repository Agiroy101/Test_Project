package hsp.chapter11.enumeration;

public class EnumDetail {
    public static void main(String[] args) {
        Run.runs.playing();
        Run.runss.playing();


    }
}

interface play{
    void playing();
}

enum Run implements play{
    runs,runss;

    @Override
    public void playing() {

    }
}
