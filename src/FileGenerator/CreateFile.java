package FileGenerator;
import FileWriter.SaveFile;

import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.FieldNamingPolicy;

public class CreateFile {
    Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .setPrettyPrinting()
            .create();
    public CreateFile(List<SaveFile> saveFiles){
        try{
            FileWriter createJson = new FileWriter("currencies.json");
            createJson.write(gson.toJson(saveFiles));
            createJson.close();
        }catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}