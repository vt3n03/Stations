public class InterchangeStation extends Station {

    //Instance variables
    private Station[] prevs;
    private Station[] nexts;

    //Constructor
    public InterchangeStation(int stnNo, String stnName, int x, int y) {
        super(stnNo, stnName, x, y);
        prevs = new Station[2];
        nexts = new Station[2];
    }

    //Set methods not useable
    @Override
    public Station getNext() {
        throw new StationException("InterchangeStation cannot use getNext()");
    }

    @Override
    public void setNext(Station next) {
        throw new StationException("InterchangeStation cannot use setNext()");
    }

    @Override
    public Station getPrev() {
        throw new StationException("InterchangeStation cannot use getPrev()");
    }

    @Override
    public void setPrev(Station prev) {
        throw new StationException("InterchangeStation cannot use setPrev()");
    }

    //Get the previos station on given line
    public Station getPrev(char lineLetter) {
        //get index from 0 which is A
        int num = lineLetter - 65;
        //If number is greater than length
        if (num >= prevs.length) {
            return null;
        }
        //retutn the previos station at given line
        return prevs[num];
    }

    //Get the next station on given line
    public Station getNext(char lineLetter) {
        int num = lineLetter - 65;
        if (num >= nexts.length) {
            return null;
        }
        return nexts[num];
    }

    //Set the previous station on given line
    public void setPrev(Station stn, char lineLetter) {
        int num = lineLetter - 65;
        //If array length is small increase it
        if (prevs.length <= num) {
            Station[] st = new Station[num + 1];
            for (int i = 0; i < prevs.length; i++) {
                st[i] = prevs[i];
            }
            prevs = st;
        }
        prevs[num] = stn;
    }

    //Set the next station on given line
    public void setNext(Station stn, char lineLetter) {
        int num = lineLetter - 65;
        if (nexts.length <= num) {
            Station[] st = new Station[num + 1];
            for (int i = 0; i < nexts.length; i++) {
                st[i] = nexts[i];
            }
            nexts = st;
        }
        nexts[num] = stn;
    }

    public Station[] getPrevArray() {
        return prevs;
    }

    public Station[] getNextArray() {
        return nexts;
    }

    //Return previous stations in for of string with station number
    public String getPrevString() {
        String s = "";
        for (int i = 0; i < prevs.length; i++) {
            //If there is no station add __
            if (prevs[i] == null) {
                s += "__  ";
            } else {
                s += prevs[i].getStnNo() + "  ";
            }
        }
        return s;
    }

    //Return next stations in for of string with station number
    public String getNextString() {
        String s = "";
        for (int i = 0; i < nexts.length; i++) {
            if (nexts[i] == null) {
                s += "__  ";
            } else {
                s += nexts[i].getStnNo() + "  ";
            }
        }
        return s;
    }

    @Override
    public String toString() {
        String lines = "";
        for (int i = 0; i < nexts.length; i++) {
            if (nexts[i] != null) {
                lines += ((char) (i + 65)) + " ";
            }
        }
        return super.toString() + " on Lines: " + lines;
    }

}