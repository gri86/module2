package da.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import da.AtmDAService;
import entity.Atm;
import entity.AtmVolume;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class JsonAtmDAService implements AtmDAService {


    private ObjectMapper mapper;

    public void setMapper(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<Atm> get() {
        URL file =
                JsonAtmDAService.class.getClassLoader().getResource("atm.json");
        List<Atm> list = null;

        try {
            list = mapper.readValue(file, new TypeReference<List<Atm>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public Atm get(String id) {
        return null;
    }

    @Override
    public void insert(Atm item) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void update(Atm item) {

    }
}
