package contracts;

public abstract class Controller<ViewT extends View> {
    private ViewT view;
    public ViewT getView(){
        return view;
    }
    public void setView(ViewT view){
        this.view = view;
    }
}