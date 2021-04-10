/**
 * Interface qui renseigne les caratéristiques des observables du jeu de la vie
 * @author Julien PROUDY
 */
public interface Observable{

    void attacheObservateur(Observateur o);
    void detacheObservateur(Observateur o);
    void notifieObservateurs();

}