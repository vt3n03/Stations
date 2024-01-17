public class TransitLine {

    //Instance variables
    private char lineLetter;
    private Station firstStn;

    //Constructor
    public TransitLine(char lineLetter, Station firstStn) {
        this.lineLetter = lineLetter;
        this.firstStn = firstStn;
    }

    //Getters
    public Station getFirstStn() {
        return firstStn;
    }

    public char getLineLetter() {
        return lineLetter;
    }

    //Check if station has next station
    public boolean hasNext(Station stn) {
        //If its InterchangeStation check for next station in given line
        if (stn instanceof InterchangeStation) {
            return ((InterchangeStation) stn).getNext(lineLetter) != null;
        } else {
            return stn.getNext() != null;
        }
    }

    public void addStation(Station stn) {

        Station temp = firstStn;
        while (hasNext(temp)) {
            //If its InterchangeStation get next station in given line
            if (temp instanceof InterchangeStation) {
                temp = ((InterchangeStation) temp).getNext(lineLetter);
            } else {
                temp = temp.getNext();
            }
        }
        //If its InterchangeStation add next station in given line
        if (temp instanceof InterchangeStation) {
            ((InterchangeStation) temp).setNext(stn, lineLetter);
        } else {
            temp.setNext(stn);
        }

        //If its InterchangeStation add previous station in given line
        if (stn instanceof InterchangeStation) {
            ((InterchangeStation) stn).setPrev(temp, lineLetter);
        } else {
            stn.setPrev(temp);
        }

    }

    @Override
    public String toString() {
        Station temp = firstStn;
        String stations = "";
        while (hasNext(temp)) {
            stations += temp.getStnNo() + "  ";
            if (temp instanceof InterchangeStation) {
                temp = ((InterchangeStation) temp).getNext(lineLetter);
            } else {
                temp = temp.getNext();
            }
        }
        stations += temp.getStnNo() + "  ";

        return "Line " + lineLetter + ":  " + stations;
    }

}
