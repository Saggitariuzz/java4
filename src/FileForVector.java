import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileForVector {

    private BufferedWriter _file;

    private DoubleVector _dv;

    public  FileForVector(){
        _file = null;
        _dv = null;
    }

    public FileForVector(String path, DoubleVector dv) throws IOException {
        _file = new BufferedWriter(new FileWriter(path));
        this._dv = dv;
    }

    public void writetofile() throws IOException {
        if(_dv == null){
            throw new IllegalStateException("Вектор не инициализирован");
        }
        if (_file == null){
            throw new IllegalStateException("Файл не инициализирован");
        }
        _file.write("Изначальный вектор");
        _file.newLine();
        for(Double i: _dv.getvector()){
            _file.write(i.toString() + " ");
        }
        _file.newLine();
        _file.write("Отсортированный вектор");
        _file.newLine();
        _dv.sort();
        for(Double i: _dv.getvector()){
            _file.write(i.toString()+" ");
        }
        _file.newLine();
        _file.write("Среднее значение элементов вектора");
        _file.newLine();
        _file.write(_dv.average().toString());
        _file.newLine();
        _file.write("Медианное значение элементов вектора");
        _file.newLine();
        _file.write(_dv.median().toString());
        _file.close();
    }
}
