package sg.edu.ntu.singastays.exceptions;


public class AttractionNotFoundException extends RuntimeException  {
    public AttractionNotFoundException(Long id) {
        super("Unable to find attractions with id: "+ id + ".");
    }

}
