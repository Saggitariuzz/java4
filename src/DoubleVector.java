import java.util.Collections;
import java.util.ListIterator;
import java.util.Vector;

public class DoubleVector{

    private Vector<Double> _vector;

    private ListIterator<Double> _iter;

    public DoubleVector(){
        _vector = new Vector<Double>();
        resetIterator();
    }

    private void resetIterator(){
        _iter = _vector.listIterator();
    }

    public void add(double element){
        _vector.add(element);
        resetIterator();
    }

    public void sort(){
        Collections.sort(_vector);
        resetIterator();
    }

    public Double average(){
        resetIterator();
        if(!_iter.hasNext()){
            throw new IllegalArgumentException("Вектор пуст");
        }
        double sum = 0;
        while (_iter.hasNext()){
            sum += _iter.next();
        }
        return sum/ _vector.size();
    }

    public Double median(){
        if(_vector.isEmpty()){
            throw new IllegalArgumentException("Вектор пуст");
        }
        if(_vector.size()%2!=0){
            return _vector.get(_vector.size()/2);
        }else {
            Vector<Double> tmp = new Vector<>(_vector);
            Collections.sort(tmp);
            return (tmp.get(tmp.size()/2-1)+tmp.get(tmp.size()/2))/2;
        }
    }

    public Vector<Double> getvector() {
        return _vector;
    }

}

