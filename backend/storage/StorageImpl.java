package backend.storage;

import backend.exception.CorruptedPersonDataException;
import backend.exception.UnableSavePersonException;
import backend.model.person.Person;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StorageImpl implements Storage {

    private static final Path DIRECTORY_FILEPATH = Paths.get("data");
    private static final Path PERSON_DATA_FILEPATH = Paths.get("data", "person.json");

    public StorageImpl() {}

    @Override
    public Person load() throws CorruptedPersonDataException {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(PERSON_DATA_FILEPATH.toString())) {
            Object personObj = jsonParser.parse(reader);
            JSONObject personData = (JSONObject) personObj;
            JsonPersonBuilder personBuilder = new JsonPersonBuilder(personData);
            return personBuilder.build();
        } catch (IOException | ParseException e) {
            throw new CorruptedPersonDataException();
        }
    }

    @Override
    public void save(Person person) throws UnableSavePersonException {
        if (!isExistingPath(DIRECTORY_FILEPATH)) {
            File data = new File(DIRECTORY_FILEPATH.toUri());
            data.mkdir();
        }
        JsonPersonSerializer personSerializer = new JsonPersonSerializer(person);
        try {
            FileWriter file = new FileWriter(PERSON_DATA_FILEPATH.toString());
            file.write(personSerializer.serialize().toString());
            file.flush();
        } catch (IOException ioException) {
            throw new UnableSavePersonException();
        }
    }

    @Override
    public boolean isExistingPath(Path filepath) {
        return filepath.toFile().exists();
    }

}
